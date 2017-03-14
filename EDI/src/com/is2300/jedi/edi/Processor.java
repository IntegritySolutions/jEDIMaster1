/* {Processor.java}
 * 
 * Shepherds all processing for incoming EDI transmissions, from retrieving the
 * EDI file from the server, to parsing the lines and activating the appropriate
 * classes for parsing the lines of EDI text, and generating output files or
 * database storage.
 * 
 * Copyright (C) 2017 Integrity Solutions
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.is2300.jedi.edi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.prefs.Preferences;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbPreferences;
import com.is2300.jedi.edi.gui.options.EDISettingsOptionsPanelController;
import com.is2300.jedi.edi.validators.FGValidator;
import com.is2300.jedi.edi.utils.Utils;
import com.is2300.jedi.edi.validators.EnvelopeValidator;
import com.is2300.jedi.edi.validators.Validate810Segments;
import com.is2300.jedi.edi.validators.Validate824Segments;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

/**
 * <code>Processor</code> shepherds the incoming EDI file through the phases of
 * processing. This includes retrieval from the server; reading the lines from 
 * the EDI transmission file; gathering an envelope, functional group or segment
 * together into an object; breaking the data out of the transaction set and
 * putting into the database and/or writing it to a file; validating the data
 * where ever it may be required; and sending EDI transmissions as necessary.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class Processor {
    //<editor-fold desc="  Private Constant Declarations  ">
    /**
     * Constant for handling the title of the output window to use for our
     * various messages.
     */
    private static final String MSG_TITLE = "EDI Processing";
    
    private final Preferences PREFS = NbPreferences.forModule(
                                       EDISettingsOptionsPanelController.class);
    //</editor-fold>
    
    //<editor-fold desc="  Private Member Fields  ">
    /**
     * A <code>java.util.List</code> of <code>java.lang.String</code> elements
     * that holds <strong>all</strong> lines of the incoming EDI transmission
     * file.
     */
    private List<String> asLines;
    /**
     * A <code>java.util.List</code> of <code>java.lang.String</code> elements
     * that holds the Interchange Control Header and Trailer information for a
     * single EDI envelope.
     * <p>
     * An Interchange Control envelope begins with the ISA EDI Segment and ends
     * with the IEA EDI Segment. This list will hold both so that validation of
     * the envelope can be checked.
     */
    private List<String[]> envelope;
    /**
     * A <code>java.util.List</code> of <code>java.lang.String</code> elements
     * that holds the Functional Group Header and Trailer information for a
     * single EDI functional group.
     * <p>
     * A Functional Group begins with the GS EDI Segment and ends with the GE
     * EDI Segment. This list will contain both so that validation of the
     * Functional Group can be checked.
     */
    private List<String[]> group;
    /**
     * A <code>java.util.List</code> of <code>java.lang.String</code> elements
     * that holds the Transaction Set information for a single EDI transaction.
     * <p>
     * A Transaction Set begins with the ST EDI Segment and ends with the SE
     * EDI Segment. This list will contain both of those segments, as well as
     * all of the segments between them. A Transaction Set describes a document
     * and contains all of the data that document holds.
     * <p>
     * Validation on a Transaction Set needs to be handled at multiple levels
     * and there will be multiple validators used.
     */
    private List<String[]> transaction;
    /**
     * A <code>java.lang.Integer</code> to keep count of how many transactions
     * are contained in a functional group. This counter gets reset after each
     * functional group ends.
     */
    private Integer t_Count;
    /**
     * A <code>java.lang.Integer</code> to keep count of how many functional
     * groups are in an interchange envelope. This counter gets reset after each
     * envelope ends.
     */
    private Integer g_Count;
    /**
     * A <code>java.lang.Integer</code> to keep a running count of how many
     * transactions are contained in a single transmission.
     */
    private Integer total_T_Count;
    /**
     * A <code>java.lang.Integer</code> to keep count of how many transactions
     * are contained in a functional group.
     */
    private Integer gT_Count;
    /**
     * A <code>java.sql.Connection</code> object for connecting to the MySQL
     * database server.
     */
    private Connection conn;
    /**
     * A <code>java.sql.Statement</code> object for manipulating the database
     * once the connection is made.
     */
    private Statement stmt;
    /**
     * A <code>java.lang.String</code> object for storing the current user's
     * database server username.
     */
    private String uname;
    /**
     * A <code>java.lang.String</code> object for storing the current user's
     * database server password.
     */
    private String pwd;
    /**
     * A <code>java.lang.String</code> object for storing the name of the 
     * database on the server.
     */
    private String dbName;
    /**
     * A <code>java.lang.String</code> object for storing the name of the
     * database server.
     */
    private String dbSvr;
    /**
     * A <code>java.lang.Integer</code> object to hold the port for the database
     * server.
     */
    private Integer port;
    /**
     * A <code>java.lang.String</code> object to hold the proper path to the 
     * remote SFTP or FTPS server from which we need to fetch the incoming EDI
     * transmission file.
     */
    private String url;
    /**
     * <code>java.util.Calendar</code> object for getting the system date and
     * time for various output messages.
     */
    private Calendar cal;
    /**
     * <code>java.text.SimpleDateFormat</code> object for formatting the system
     * date and time for the various output messages.
     */
    private SimpleDateFormat fmt;
    /**
     * <code>org.netbeans.api.io.InputOutput</code> object for writing various
     * messages to the Platform Output window.
     */
    private InputOutput io;
    /**
     * <code>java.lang.String</code> object to hold the formatted current time
     * for the various output messages.
     */
    private String time;
    /**
     * <code>java.util.Calendar</code> to hold the processing start time.
     */
    private Calendar start;
    /**
     * <code>java.util.Calendar</code> to hold the processing end time.
     */
    private Calendar end;
    /**
     * A <code>java.util.StringBuilder</code> object for building messages to
     * store in the Output Report file. This will be built in tandem with the
     * messages being writen to the Output Window.
     */
    private StringBuilder outBldr;
    //</editor-fold>
    
    //<editor-fold desc="  Default Constructor  ">
    /**
     * Constructor for the <code>Processor</code> class. This constructor
     * initializes the member fields to new <code>java.util.List</code>s of
     * <code>java.lang.String</code> objects. Once the class has been 
     * initialized, the the methods may be used to store data to the lists.
     */
    public Processor() {
        
        // First thing to do is to initialize our output builder object.
        this.outBldr = new StringBuilder(); // Now it is ready to use.
        
        // Show processing initialization message:
        //- Begin by initializing our messaging fields.
        this.cal = Calendar.getInstance();
        this.start = this.cal;
        this.fmt = new SimpleDateFormat("EEE: MM/dd/yyyy - HH:mm:ss", 
                                                           Locale.getDefault());
        io = IOProvider.getDefault().getIO(MSG_TITLE, false);
        this.time = this.fmt.format(this.cal.getTime());
        io.getOut().println(this.time + ":  Initializing EDI processor...");
        this.outBldr.append(this.fmt.format(this.cal.getTime()));
        this.outBldr.append(": Initializing EDI processor...\n");
        
        // Initialize the various lists in this class.
        this.envelope = new ArrayList();
        this.group = new ArrayList();
        this.transaction = new ArrayList();
        
        // Initialize the various Integers in this class.
        this.t_Count = 0;
        this.g_Count = 0;
        this.total_T_Count = 0;
        this.gT_Count = 0;
        
        // Initialize the database user information.
        this.uname = "_edi";
        this.pwd = "3d1_u53r";
        /*^^^^^^^^^^^^^^^^^^^^**************************************************
         * This user is a special user that needs to be created on the database*
         * server at the client site. This user is only for use in processing  *
         * the EDI transmissions and for nothing else. _edi user has full      *
         * access to the is_jedi database for creating and updating the data   *
         * within the tables. _edi CANNOT delete the data, nor can it drop     *
         * tables, nor create users/grant privileges. This user only servers   *
         * the purposes of transferring retainable data from the EDI trans-    *
         * missions to the appropriate database tables, firing any database    *
         * triggers that may be present.                                       *
         *                                                                     *
         * Furthermore, the _edi user SHOULD NEVER be used as a standard user  *
         * on the database server within jEDI Master. This user does not have  *
         * the appropriate rights for such use and can read *ALL* database     *
         * tables, which is not secure for standard users to be able to do.    *
         **********************************************************************/
        
        // Initialize our database server information. This module should be 
        //+ installed on the same machine as the database server.
        this.dbSvr = Preferences.userRoot().get("SvrPath", "localhost");
        // Retrieve the port number for the database server from the settings
        //+ file for the user.
        this.port = Preferences.userRoot().getInt("SvrPort", 3306);
        // This is the name of the database on the database server that stores
        //+ all data forjEDI Master.
        this.dbName = "is_jedi";    
        
        // Last thing before shepherding the process is to store the path to the
        //+ SFTP or FTPS server from which to fetch the incoming EDI trans-
        //+ mission file.
        this.url = Preferences.userRoot().get("SvrURL", 
                                              "/home/sean/Public/edi/incoming");
        
        // Begin shepherding the EDI transmission file through the parsing
        //+ process.
        this.shepherd();
    }
    //</editor-fold>

    //<editor-fold desc="  Destructor  ">
    private void selfDestruct() {
        // Output the lapsed time of the document processing.
        this.end = Calendar.getInstance();
        long strt = this.start.getTimeInMillis();
        long fnsh = this.end.getTimeInMillis();
        long mins = fnsh - strt;
        float procTime = mins / 60000f;
        this.io.getOut().printf("Processed in %1$f minute(s)", procTime);
        this.outBldr.append(this.time);
        this.outBldr.append(":  Pocessed in ");
        this.outBldr.append(procTime);
        this.outBldr.append(" minute(s).\n");
        
        // Save the output report to file.
        this.saveReport();
        
        // We need to set everything to null, so that we can be garbage col-
        //+ lected.
        this.conn = null;
        this.dbName = null;
        this.dbSvr = null;
        this.envelope = null;
        this.group = null;
        this.port = null;
        this.pwd = null;
        this.stmt = null;
        this.transaction = null;
        this.uname = null;
        this.url = null;
        this.asLines = null;
        this.cal = null;
        this.end = null;
        this.fmt = null;
        this.io = null;
        this.start = null;
        this.t_Count = null;
        this.total_T_Count = null;
        this.gT_Count = null;
        this.time = null;
    }
    //</editor-fold>
    
    //<editor-fold desc="  Property Adding Methods  ">
    /**
     * Adds a <code>java.lang.String</code> array to the <code>java.util.List
     * </code>.
     * <p>
     * Typically, this value will be the <code>java.lang.String</code> array
     * from the split line of the incoming EDI transmission file. The only times
     * that a value should be added to this field is when element zero (0) of 
     * the array contains either "ISA" or "IEA".
     * 
     * @param value the split line of the Interchange Control Header or Footer
     *              from the incoming EDI transmission file.
     */
    public void addEnvelope(String[] value) {
        this.envelope.add(value);
    }
    /**
     * Adds a <code>java.lang.String</code> array to the <code>java.util.List
     * </code>.
     * <p>
     * Typically, this value will be the <code>java.lang.String</code> array
     * from the split line of the incoming EDI transmission file. The only times
     * that a value should be added to this field is when element zero (0) of
     * the array contains either "GS" or "GE".
     * 
     * @param value the split line of the Functional Group Header or Footer from
     *              the incoming EDI transmission file.
     */
    public void addGroup(String[] value) {
        this.group.add(value);
    }
    /**
     * Adds a <code>java.lang.String</code> array to the <code>java.util.List
     * </code>.
     * <p>
     * Typically, this value will be the <code>java.lang.String</code> array 
     * from the split line of the incoming EDI transmission file. The first line
     * that is added to this field is when element zero (0) of the array 
     * contains "ST". Every segment after the "ST" segment, up to and including
     * the segment "SE", should also be added to this field.
     * 
     * @param value the split line of the Transaction Set Header, and all 
     *              segments up to and including the Transaction Set Trailer.
     */
    public void addTransaction(String[] value) {
        this.transaction.add(value);
    }
    //</editor-fold>
    
    //<editor-fold desc="  Database Access Functions  ">
    /**
     * A <code>private</code> method for setting up the database connection to
     * the server. This method should be the first method called from the 
     * shepherding function.
     */
    private void dbSetup() {
        
        // Build the connection string.
        String connection = "jdbc:mysql://" + this.dbSvr + ":3306/";
        connection += this.dbName;
        
        try {
            
            // Load the MySQL database driver.
            Class.forName("com.mysql.jdbc.Driver");
            
            // Create a connection to the database server.
            this.conn = DriverManager.getConnection(
                        connection, this.uname, this.pwd);
            
            // Prepare our Statement object for use.
            this.stmt = this.conn.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            // Handle the Exception.
            // We'll use the NotifyDescriptor API to display the error to the
            //+ user, if an Exception is thrown.
            NotifyDescriptor d = new NotifyDescriptor.Exception(ex);
            
            // Show the dialog to the user.
            DialogDisplayer.getDefault().notify(d);

            // Finally, print the stacktrace to the Output window.
            InputOutput io = IOProvider.getDefault().getIO("jEDI SQL Access", 
                                                                          true);
            ex.printStackTrace(io.getErr());
            
        }
        
    }
    
    /**
     * This method adds an EDI transmission envelope to the database audits
     * table. The transmissions should be maintained for a period after the
     * transmission arrives, in case there are any issues with the transmission
     * that are not discovered until later.
     * <p>
     * The EDI transmission audits are broken into three (3) tables on the
     * database:
     * <ul>
     *  <li>is_edi_audits: This table stores audit information about the EDI
     *      transmission envelopes. The data collected are:
     *      <ul>
     *          <li>Interchange Control Number (ISA13)</li>
     *          <li>Interchange Date (ISA09) and Interchange Time (ISA10)</li>
     *          <li>Interchange Sender ID (ISA06)</li>
     *          <li>Interchange Receiver ID (ISA08)</li>
     *          <li>Functional Group Count (counted internally)</li>
     *          <li>Error Count (determined via validation algorithms)</li>
     *      </ul></li>
     *  <li>is_edi_audit_grp_details: This table stores audit information about
     *      each Functional Group within an envelope.</li>
     *  <li>is_edi_audit_doc_details: This table stores audit information about
     *      each transaction within a functional group.</li>
     * </ul>
     * @see com.is2300.jedi.edi.Processor.auditGroup for more details about the
     * Functional Group auditing data collected.
     * @see com.is2300.jedi.edi.Processor.auditTransaction for more details 
     * about the Transaction auditing data collected.
     * 
     * @param ctlNumber Interchange Control Number from the ISA13 field
     * @param date  Interchange Date from the ISA09 field, along with the 
     *              Interchange Time from the ISA10 field.
     * @param sender    Interchange Sender ID from the ISA06 field
     * @param rcvr  Interchange Receiver ID from the ISA08 field
     * @param grpCount  Total number of Functional Groups contained in the 
     *                  envelope.
     * @param errCount  Total number of errors discovered through validation in
     *                  the envelope. This only counts interchange envelope
     *                  errors...Group and Transaction errors are tracked in 
     *                  those tables.
     */
    private void auditEnvelope(Integer ctlNumber, 
                               Date date, 
                               String sender,
                               String rcvr, 
                               Integer grpCount, 
                               Integer errCount) {
        // Create a StringBuilder object in which to build the SQl statement to
        //+ use for storing the data to the is_edi_audits table.
        StringBuilder sql = new StringBuilder();
        
        // Convert our date to a SQL date.
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        // Start the SQL string with the INSERT statement, because we will be
        //+ adding a new record to the data table.
        sql.append("INSERT INTO `is_jedi`.`is_edi_audits` VALUES(0,\n");
        
        // Now, add in the various values that we will need to store.
//        sql.append("`TxCtlNum`='");
        sql.append(ctlNumber);
        sql.append(",\n");
//        sql.append("`TxDate`='");
        sql.append("'");
        
        // We need to pause here to build the date. The date should be stored
        //+ as a string in the format YYMMDD HHMMSS. To accomplish this, we need
        //+ to use our SimpleDateFormat to create the properly formatted string.
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
        
        // Now that we've created the proper format for our date to be stored in
        //+ the database, we need to add it to our INSERT statement.
        sql.append(df.format(date.getTime()));
        sql.append("',\n");
        
        // Next, continue adding the data to the table.
//        sql.append("`TxSenderID`='");
        sql.append("'");
        sql.append(sender);
        sql.append("',\n");
//        sql.append("`TxRcvrID`='");
        sql.append("'");
        sql.append(rcvr);
        sql.append("',\n");
//        sql.append("`GrpCnt`=");
        sql.append(grpCount);
        sql.append(",\n");
//        sql.append("`ErrCnt`=");
        sql.append(errCount);
        sql.append(");");
        
        try {
            // Now that we've got our statement built, we need to execute it on the
            //+ database server.
            this.stmt.execute(sql.toString());
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            this.cal = Calendar.getInstance();
            this.time = this.fmt.format(this.cal.getTime());
            this.io.getOut().println(time + ":  The following SQL Exception "
                    + "was caught:");
            ex.printStackTrace(this.io.getErr());
            this.outBldr.append(this.time);
            this.outBldr.append(":  The following SQL Exception was caught:\n\t");
            this.outBldr.append(ex.getLocalizedMessage());
            this.outBldr.append("\n");
        }
    }

    /**
     * This method adds an EDI transmission envelope to the database audits
     * table. The transmissions should be maintained for a period after the
     * transmission arrives, in case there are any issues with the transmission
     * that are not discovered until later.
     * <p>
     * The EDI transmission audits are broken into three (3) tables on the
     * database:
     * <ul>
     *  <li>is_edi_audits: This table stores audit information about the EDI
     *      transmission envelopes. The data collected are:
     *  <li>is_edi_audit_grp_details: This table stores audit information about
     *      each Functional Group within an envelope.</li>
     *      <ul>
     *          <li>Functional Group Control Number (GS06)</li>
     *          <li>Interchange Control Number (ISA13)</li>
     *          <li>Functional Group Code (GS01)</li>
     *          <li>Transaction Count (GE01)</li>
     *          <li>Error Count (determined via validation algorithms)</li>
     *      </ul></li>
     *  <li>is_edi_audit_doc_details: This table stores audit information about
     *      each transaction within a functional group.</li>
     * </ul>
     * @see com.is2300.jedi.edi.Processor.auditEnvelope for more details about 
     * the transaction envelope auditing data collected.
     * @see com.is2300.jedi.edi.Processor.auditTransaction for more details 
     * about the Transaction auditing data collected.
     * 
     * @param ctlNumber Functional Group Control Number from the GS06 field
     * @param txCtlNumber  Interchange Control Number from the ISA13 field
     * @param grpCode   Functional Group Code from the GS01 field
     * @param docCount  Count of documents in the Functional Group from the GE01
     *                  field
     * @param errCount  Total number of errors discovered through validation in
     *                  the Functional Group. This only counts Functional Group
     *                  errors...Envelope and Transaction errors are tracked in 
     *                  those tables.
     */
    private void auditGroup(Integer ctlNumber, 
                            Integer txCtlNumber, 
                            String grpCode,
                            Integer docCount, 
                            Integer errCount) {
        // Create a StringBuilder object in which to build the SQl statement to
        //+ use for storing the data to the is_edi_audits table.
        StringBuilder sql = new StringBuilder();
        
        // Start the SQL string with the INSERT statement, because we will be
        //+ adding a new record to the data table.
        sql.append("INSERT INTO `is_jedi`.`is_edi_audit_grp_details`");
        sql.append(" VALUES(0,\n");
        
        // Now, add in the various values that we will need to store.
//        sql.append("`GrpCtlNum`='");
        sql.append(ctlNumber);
        sql.append(",\n");
//        sql.append("`TxCtlNum`='");
        sql.append(txCtlNumber);
        sql.append(",\n'");
//        sql.append("`GrpCode`='");
        sql.append(grpCode);
        sql.append("',\n");
//        sql.append("`DocCnt`='");
        sql.append(docCount);
        sql.append(",\n");
//        sql.append("`ErrCnt`=");
        sql.append(errCount);
        sql.append(");");
        
        try {
            // Now that we've got our statement built, we need to execute it on the
            //+ database server.
            this.stmt.execute(sql.toString());
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            this.cal = Calendar.getInstance();
            this.time = this.fmt.format(this.cal.getTime());
            this.io.getOut().println(time + ":  The following SQL Exception "
                    + "was caught:");
            ex.printStackTrace(this.io.getErr());
            this.outBldr.append(this.time);
            this.outBldr.append(":  The following SQL Exception was caught:\n\t");
            this.outBldr.append(ex.getLocalizedMessage());
            this.outBldr.append("\n");
        }
    }

    /**
     * This method adds an EDI transmission envelope to the database audits
     * table. The transmissions should be maintained for a period after the
     * transmission arrives, in case there are any issues with the transmission
     * that are not discovered until later.
     * <p>
     * The EDI transmission audits are broken into three (3) tables on the
     * database:
     * <ul>
     *  <li>is_edi_audits: This table stores audit information about the EDI
     *      transmission envelopes. The data collected are:
     *  <li>is_edi_audit_grp_details: This table stores audit information about
     *      each Functional Group within an envelope.</li>
     *  <li>is_edi_audit_doc_details: This table stores audit information about
     *      each transaction within a functional group.</li>
     *      <ul>
     *          <li>Document Control Number (ST02)</li>
     *          <li>Interchange Control Number (ISA13)</li>
     *          <li>Functional Group Control Number (GS06)</li>
     *          <li>Document Type (ST01)</li>
     *          <li>Document Count (GE01)</li>
     *          <li>Error Count (determined via validation algorithms)</li>
     *          <li>Accepted (boolean whether accepted or rejected)</li>
     *      </ul></li>
     * </ul>
     * @see com.is2300.jedi.edi.Processor.auditGroup for more details about the
     * Functional Group auditing data collected.
     * @see com.is2300.jedi.edi.Processor.auditEnvelope for more details 
     * about the transaction Envelope auditing data collected.
     * 
     * @param ctlNumber Document Control Number from the ST02 field
     * @param txCtlNumber  Interchange Control Number from the ISA13 field.
     * @param grpCtlNumber Functional Group Control Number from the GS06 field
     * @param docType   Document Type Code from the ST01 field
     * @param docCount  Total number of documents contained in the transaction.
     * @param errCount  Total number of errors discovered through validation in
     *                  the envelope. This only counts interchange envelope
     *                  errors...Group and Transaction errors are tracked in 
     *                  those tables.
     * @param accepted  True if the document was accepted, false if rejected.
     */
    private void auditTransaction(Integer ctlNumber, 
                            Integer txCtlNumber, 
                            Integer grpCtlNumber,
                            String docType, 
                            Integer docCount,
                            Integer errCount,
                            Boolean accepted) {
        // Create a StringBuilder object in which to build the SQl statement to
        //+ use for storing the data to the is_edi_audits table.
        StringBuilder sql = new StringBuilder();
        
        // Start the SQL string with the INSERT statement, because we will be
        //+ adding a new record to the data table.
        sql.append("INSERT INTO `is_jedi`.`is_edi_audit_doc_details`");
        sql.append(" VALUES(0,\n");
        
        // Now, add in the various values that we will need to store.
//        sql.append("`DocCtlNum`='");
        sql.append(ctlNumber);
        sql.append(",\n");
//        sql.append("`TxCtlNum`='");
        sql.append(txCtlNumber);
        sql.append(",\n");
//        sql.append("`GrpCtlNum`='");
        sql.append(grpCtlNumber);
        sql.append(",\n'");
//        sql.append("`DocType`='");
        sql.append(docType);
        sql.append("',\n");
//        sql.append("`DocCnt`='");
        sql.append(docCount);
        sql.append(",\n");
//        sql.append("`ErrCnt`=");
        sql.append(errCount);
        sql.append(",\n");
//        sql.append("`Accepted`=");
        sql.append(accepted);
        sql.append(");");
        
        try {
            // Now that we've got our statement built, we need to execute it on the
            //+ database server.
            this.stmt.execute(sql.toString());
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            this.cal = Calendar.getInstance();
            this.time = this.fmt.format(this.cal.getTime());
            this.io.getOut().println(time + ":  The following SQL Exception "
                    + "was caught:");
            ex.printStackTrace(this.io.getErr());
            this.outBldr.append(this.time);
            this.outBldr.append(":  The following SQL Exception was caught:\n\t");
            this.outBldr.append(ex.getLocalizedMessage());
            this.outBldr.append("\n");
        }
    }
    //</editor-fold>

    //<editor-fold desc="  EDI Processing Algorithms  ">
    /**
     * The primary function for shepherding the EDI transmission file through
     * the processing that needs to be done.
     * <p>
     * This method simply calls the other required methods to handle the parsing
     * of the EDI transmission file. In the other methods, other objects may be
     * created to handle the processing of the various EDI document types and
     * the validation thereof.
     */
    private void shepherd() {
        // Display progress.
        this.cal = Calendar.getInstance();
        this.time = fmt.format(this.cal.getTime());
        this.io.getOut().println(this.time + ":  Begin shepherding EDI file "
                                             + "process...");
        this.outBldr.append(this.time);
        this.outBldr.append(":  Begin shepherding EDI file process...\n");
        
        // The first thing that we need to do is to setup the database access.
        this.dbSetup();
        
        // Handle the file. This includes retrieving the file from the SFTP or
        //+ FTPS server and storing it on a local disk for easier access. Once
        //+ the file is local, this method will handle the processing of the 
        //+ file, either internally or by outsourcing to other methods.
        this.handleFile();
        
        // Now that the file has been opened and is read into our List variable,
        //+ we need to process the file appropriately. To do this, we are going 
        //+ to pass control to the parser() method.
        this.parser();
        
        ////////////////////////////////////////////////////////////////////////
        //             K E E P   A S   T H E   L A S T   L I N E              //
        ////////////////////////////////////////////////////////////////////////
        // Destroy ourself.
        this.selfDestruct();
    }
    
    /**
     * Handles all file handling and processing situations. Primarily, this 
     * method puts the incoming EDI transmission file through all of the 
     * required processing, so that the data can be extracted from it.
     */
    private void handleFile() {
        
        // Display progress.
        this.cal = Calendar.getInstance();
        this.time = this.fmt.format(this.cal.getTime());
        this.io.getOut().println(time + ":  Retrieving file...");
        this.outBldr.append(this.time);
        this.outBldr.append(":  Retrieving file(s)...\n");
        
        // Retrieve the path to the incoming EDI file from the settings.
        String path = this.PREFS.get("SvrURL", "/");
        String fileName = this.PREFS.get("EDIFilename", "incoming.edi");
        
        try {
            URL url = new URL(path);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
            this.cal = Calendar.getInstance();
            this.time = this.fmt.format(cal.getTime());
            this.io.getOut().println(time + ":  The following Exception was "
                                                                   + "caught:");
            this.outBldr.append(this.time);
            this.outBldr.append(":  The following exception was caught:\n\t");
            this.outBldr.append(ex.getLocalizedMessage());
            this.outBldr.append("\n");
            ex.printStackTrace(this.io.getErr());
        }
        this.cal = Calendar.getInstance();
        this.time = this.fmt.format(this.cal.getTime());
        this.io.getOut().println(time + ":  File Location: " + path);
        this.outBldr.append(this.time);
        this.outBldr.append(":  File Location: ");
        this.outBldr.append(path);
        this.outBldr.append("\n");
        
        // Create a FileObject object for the file.
        FileObject file = FileUtil.toFileObject(new File(url + "/" + fileName));
        
        // Verify that the file exists.
        if ( file.isValid() ) {
            // Handle all processing here... \\
            this.cal = Calendar.getInstance();
            this.time = this.fmt.format(cal.getTime());
            this.io.getOut().println(time + ":  Incoming file is valid...");
            this.outBldr.append(this.time);
            this.outBldr.append(":  Incoming file is valid...\n");
            
            try {
                this.asLines = file.asLines();
                this.io.getOut().println("\tLines: " + asLines.size());
                this.outBldr.append("\tLines: ");
                this.outBldr.append(asLines.size());
                this.outBldr.append("\n");
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
                this.cal = Calendar.getInstance();
                this.time = this.fmt.format(cal.getTime());
                this.io.getOut().println(time + ":  The following Exception was"
                                                                  + " caught:");
                this.outBldr.append(this.time);
                this.outBldr.append(":  The following Exception was caught:");
                this.outBldr.append("\n\t");
                this.outBldr.append(ex.getLocalizedMessage());
                ex.printStackTrace(this.io.getErr());
            } finally {
                // Now, we need to parse out the data that we just brought into
                //+ the list "asLines". To do this, return to the shepherding
                //+ method.
                return;
            }
            
        }
    }
    
    /**
     * This method handles all file parsing. In this method, the 
     * <code>java.util.List&lt;T&gt;</code> created in the <code>handleFile()
     * </code> method will get parsed into its derivative fields, then stored
     * into the appropriate List. Finally, this method will call the correct
     * document algorithm for the document type currently being processed.
     */
    private void parser() {
        
        // Declare an array of type String in which to store our fields.
        String[] fields;
        
        // Declare a variable to hold a message text for validation messages.
        String msg;
        
        // Declare some validation flags and default them to invalid.
        Boolean validEnv = false;
        Boolean validGrp = false;
        Boolean validTSet = false;
        Boolean validSeg = false;
        
        // Declare two variables: one (1) for transaction control number and one
        //+ (1) for group control number.
        Integer txCtlNum = 0;
        Integer grpCtlNum = 0;
        
        // Declare counters for error for the envelopes, groups and docs.
        Integer envErrCnt = 0;
        Integer grpErrCnt = 0;
        Integer docErrCnt = 0;
        
        // We need to loop through the list of lines from the file and split 
        //+ them into their individual fields. Once they are split into the
        //+ fields, we need to determine what the line represents and store the
        //+ fields in the appropriate place. Once they are stored, we need to
        //+ move on to the next line.
        this.cal = Calendar.getInstance();
        this.time = this.fmt.format(cal.getTime());
        this.io.getOut().println(this.time + ":  Commencing parsing...");
        this.outBldr.append(this.time);
        this.outBldr.append(": Commencing parsing...\n");
        for ( String line : asLines ) {
            fields = line.split("\\*");
            
            // Now, determine what needs to be done. This is accomplished by 
            //+ looking at the value of the zeroeth (0th) element of the array.
            switch ( fields[0].toLowerCase() ) {
                case "iea":
                    // We need to make sure that this envelope is valid.
                    validEnv = EnvelopeValidator.validate(
                                this.envelope.get(this.envelope.size() - 1)[13],
                                fields[2], new Integer(fields[1]), 
                                this.g_Count);
                    
                    // Check our findings.
                    if (!validEnv) {
                        // Report to the Output Window that this group is not
                        //+ valid and the control numbers, as well as the
                        //+ reported and actual functional group counts.
                        msg = "Interchange Envelope (";
                        msg += this.envelope.get(this.envelope.size() - 1)[13];
                        msg += ") is NOT valid.\n\t";
                        msg += "Header Control Number (Trailer):  ";
                        msg += this.envelope.get(this.envelope.size() - 1)[13];
                        msg += " (" + fields[2] + ")\n\t";
                        msg += "Number of reported functional groups (Actual):";
                        msg += "  " + fields[1] + "(" + this.group.size() / 2;
                        msg += ")";
                    } else {
                        msg = "Interchange Envelope (" + fields[2] + ") ";
                        msg += "transmitted " + this.g_Count;
                        msg += " funtional groups.";
                    }
                    
                    // Reset our functional group counter.
                    this.g_Count = 0;
 
                    // Provide report to Output Window.
                    this.cal = Calendar.getInstance();
                    this.time = this.fmt.format(cal.getTime());
                    this.io.getOut().println(time + ":  " + msg);
                    this.outBldr.append(time);
                    this.outBldr.append(":  ");
                    this.outBldr.append(msg);
                    this.outBldr.append("\n");
                    
                    // We need to create a new Date object based upon the date
                    //+ and time transmitted in the envelope header.
                    
                    this.auditEnvelope(txCtlNum, 
                                       Utils.string2Date(
                                           this.envelope.get(
                                                   this.envelope.size() - 1)[9],
                                           this.envelope.get(
                                                   this.envelope.size() - 1)[10]
                                       ), this.envelope.get(
                                           this.envelope.size() - 1)[6], 
                                       this.envelope.get(
                                           this.envelope.size() - 1)[8], 
                                       new Integer(fields[1]), envErrCnt);
                case "isa":
                    this.envelope.add(fields);
                    if ( fields[0].equalsIgnoreCase("isa") ) txCtlNum = new 
                                                            Integer(fields[13]);
                    
                    break;
                case "ge":
                    // Add the group to the functional group counter.
                    this.g_Count += 1;
                    
                    // Grab the total transactions in this functional group.
                    this.gT_Count = this.t_Count;
                    
                    // Add the functional group transaction count to the total
                    //+ transaction count.
                    this.total_T_Count += this.t_Count;
                    
                    // Reset the transaction count for the processor.
                    this.t_Count = 0;
                    
                    // Validate whether the functional group is valid.
                    validGrp = FGValidator.validate(
                            this.group.get(this.group.size() - 1)[6], fields[2], 
                            new Integer(fields[1]), this.gT_Count);
                    
                    // Check our findings.
                    if (!validGrp) {
                        // Report to the Output Window that this group is not
                        //+ valid and the control numbers, as well as the
                        //+ reported transaction count and actual count.
                        msg = "Functional Group (" + this.group.get(
                                this.group.size() - 1)[6] + ") is NOT valid.";
                        msg += "\n\tHeader Control Number (Trailer):  ";
                        msg += this.group.get(this.group.size() - 1)[6] + "(";
                        msg += fields[2] + ")\n\t";
                        msg += "Number Reported Transactions (Actual):  ";
                        msg += fields[1] + "(" + this.gT_Count + ")";
                    } else {
                        msg = "Funtional Group (" + fields[2] + ") transmitted";
                        msg += " " + this.gT_Count + " transaction sets.";
                    }

                    // Provide report to Output Window.
                    this.cal = Calendar.getInstance();
                    this.time = this.fmt.format(cal.getTime());
                    this.io.getOut().println(time + ":  " + msg);
                    this.outBldr.append(time);
                    this.outBldr.append(":  ");
                    this.outBldr.append(msg);
                    this.outBldr.append("\n");
                    
                    // Store the Functional Group information to the group
                    //+ audits table in the database.
                    this.auditGroup(new Integer(this.group.get(
                                    this.group.size() - 1)[6]), 
                                    new Integer(this.envelope.get(
                                            this.envelope.size() - 1)[13]), 
                                    this.group.get(this.group.size() - 1)[1], 
                                    new Integer(fields[1]), 
                                    grpErrCnt);
                case "gs":
                    this.group.add(fields);
                    
                    if ( fields[0].equalsIgnoreCase("gs") ) grpCtlNum = new 
                                                             Integer(fields[6]);
                    break;
                case "se":
                    // Increment the transaction count.
                    this.t_Count += 1;
                    
                    // Add the SE segment to the transaction.
                    this.transaction.add(fields);
                    
                    // The first thing to do is to check for the document type.
                    switch (this.transaction.get(0)[1]) {
                        case "810": // Invoice
                            // We need to validate the segments
                            docErrCnt = Validate810Segments.validate(
                                                              this.transaction);
                            
                            // See how many, if any, segment errors we have. If
                            //+ there are more than zero, we need to invalidate
                            //+ the transaction.
                            if ( docErrCnt > 0 ) validSeg = false;
                            
                            // Break out of the switch case block.
                            break;
                        case "824": // Application Advice
                            // We need to validate the segments
                            docErrCnt = Validate824Segments.validate(
                                                              this.transaction);
                            
                            // See how many, if any, segment errors we have. If
                            //+ there are more than zero, we need to invalidate
                            //+ the transaction.
                            if ( docErrCnt > 0 ) validSeg = false;
                            
                            // Break out of the switch case block.
                            break;
                    }
                    
                    // We need to add the document to our document audits table.
                    this.auditTransaction(new Integer(fields[2]), 
                            new Integer(this.envelope.get(
                                    this.envelope.size() - 1)[13]), 
                            new Integer(this.group.get(
                                    this.group.size() - 1)[6]), 
                            this.transaction.get(0)[1], 
                            new Integer(this.group.get(
                                    this.group.size() - 1)[6]), 
                            docErrCnt, validSeg);
                    
                    // Lastly, break out of the switch so we don't add the
                    //+ segment a second time. This is just good practice, even
                    //+ though we will clear the transaction list on the next
                    //+ ST segment we encounter.
                    break;
                case "st":
                    // We need to reset the transaction list for this tran-
                    //+ saction set.
                    this.transaction.clear();
                    // Then fall through.
                default:        // All other segments
                    this.transaction.add(fields);
            }
        }
        
        this.cal = Calendar.getInstance();
        this.time = this.fmt.format(cal.getTime());
        this.io.getOut().println("Parsing complete.");
        this.io.getOut().println("\t   Envelopes:  " + this.envelope.size() / 2);
        this.io.getOut().println("\t      Groups:  " + this.group.size() / 2);
        this.io.getOut().println("\tTransactions:  " + this.total_T_Count);
        this.outBldr.append(this.time);
        this.outBldr.append(":  Parsing Complete.\n");
        this.outBldr.append("\t   Envelopes:  ");
        this.outBldr.append(this.envelope.size() / 2);  // Contains ISA & IEA
        this.outBldr.append("\n\t      Groups:  ");
        this.outBldr.append(this.group.size() / 2);     // Contains GS & GE
        this.outBldr.append("\n\tTransactions:  ");
        this.outBldr.append(this.total_T_Count);
        this.outBldr.append("\n");
        
    }
    
    void saveReport() {
        
        // Create File object to which to write the data.
        File file;
        
        // Create a FileWriter object to wrap our File object in for easier
        //+ writing functionality.
        FileWriter fw = null;
        
        // Create a SimpleDateFormat object to set up the date/time for the
        //+ file name for our report file.
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");
        
        // Get the report storage path from the settings.
        String rptPath = this.PREFS.get("OutputPath", 
                                               System.getProperty("user.home"));
        
        // Create our file name from the SimpleDateFormat of the start time and
        //+ add the ".rpt" extension.
        String fname = dt.format(this.start.getTime()) + ".rpt";
        
        // Create our File object and point it to the file we wish to create.
        file = new File(rptPath + System.getProperty("file.separator") + fname);
        
        // Now, we are going to attempt to write out the data from the Output
        //+ Window to our report file.
        try {
            // Initialize our FileWriter object to wrap our File object.
            fw = new FileWriter(file);
            
            // Create a BufferedWriter to wrap the FileWriter. This seems like
            //+ an unnecessary step, however, it DOES ease the writing process.
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Write the built report from the StringBuilder object.
            bw.write(this.outBldr.toString());
            
            // Flush the buffer so that the data will be present in the file.
            bw.flush();
            
            // Close the BufferedWriter object.
            bw.close();
        } catch (IOException ex) {
            // Display the NetBeans Platform error message box.
            Exceptions.printStackTrace(ex);
        } finally {
            try {
                // Attempt to close the FileWriter object.
                fw.close();
                
                // Set our File object to null.
                file = null;
            } catch (IOException ex) {
                // Again, display the NetBeans Platform error message box.
                Exceptions.printStackTrace(ex);
            }
        }
    }
    //</editor-fold>
}
