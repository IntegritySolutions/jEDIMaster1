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
import com.is2300.jedi.edi.impl.FGValidator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        int mins = this.end.compareTo(this.start);
        this.io.getOut().println("Processed in " + 
                                 new Double(mins / (1000 * 60)) + 
                                                                 " minute(s).");
        this.outBldr.append(this.time);
        this.outBldr.append(":  Pocessed in ");
        this.outBldr.append(new Double(mins / (1000 * 60)));
        this.outBldr.append(" minute(s).\n");
        
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
//        this.dbSetup();
        
        // Handle the file. This includes retrieving the file from the SFTP or
        //+ FTPS server and storing it on a local disk for easier access. Once
        //+ the file is local, this method will handle the processing of the 
        //+ file, either internally or by outsourcing to other methods.
        this.handleFile();
        
        // Now that the file has been opened and is read into our List variable,
        //+ we need to process the file appropriately. To do this, we are going 
        //+ to pass control to the parser() method.
        this.parser();
        
        // Save the output report to file.
        this.saveReport();
        
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
                case "isa":     // Use fall-through
                case "iea":
                    this.envelope.add(fields);
                    break;
                case "ge":
                    // Grab the total transactions in this functional group.
                    this.gT_Count = this.t_Count;
                    
                    // Add the functional group transaction count to the total
                    //+ transaction count.
                    this.total_T_Count += this.t_Count;
                    
                    // Reset the transaction count for the processor.
                    this.t_Count = 0;
                    
                    // Validate whether the functional group is valid.
                    validGrp = FGValidator.validateGroup(
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
                    this.outBldr.append(msg);
                    this.outBldr.append("\n");
                case "gs":
                    this.group.add(fields);
                    break;
                case "se":
                    this.t_Count += 1;  // Then fall-through
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
