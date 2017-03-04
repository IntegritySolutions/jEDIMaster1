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

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.prefs.Preferences;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

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
    //<editor-fold desc="  Private Member Fields  ">
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
    //</editor-fold>
    
    //<editor-fold desc="  Default Constructor  ">
    /**
     * Constructor for the <code>Processor</code> class. This constructor
     * initializes the member fields to new <code>java.util.List</code>s of
     * <code>java.lang.String</code> objects. Once the class has been 
     * initialized, the the methods may be used to store data to the lists.
     */
    public Processor() {
        
        ////////////////////////////////////////////////////////////////////////
        // DEBUGGING CODE: Remove before release build.                       //
        ////////////////////////////////////////////////////////////////////////
        // This code is to test the Timer and let me know if my math has been //
        //+ fixed, so that the Timer only kicks off every period of time that //
        //+ is stored in the settings.                                        //
        ////////////////////////////////////////////////////////////////////////
        Calendar cal = Calendar.getInstance();                                //
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");              //
        String time = fmt.format(cal.getTime());                              //
        InputOutput io = IOProvider.getDefault().getIO("jEDI Errors", true);  //
        io.getOut().println("Last EDI Processing Run: " + time);              //
        io.getOut().println(new String(new char[80]).replace("\0", "-"));     //
        ////////////////////////////////////////////////////////////////////////
        // END OF DEBUGGING CODE!                                             //
        ////////////////////////////////////////////////////////////////////////
        
        // Initialize the various lists in this class.
        this.envelope = new ArrayList();
        this.group = new ArrayList();
        this.transaction = new ArrayList();
        
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
        // The first thing that we need to do is to setup the database access.
//        this.dbSetup();
        
        // Handle the file. This includes retrieving the file from the SFTP or
        //+ FTPS server and storing it on a local disk for easier access. Once
        //+ the file is local, this method will handle the processing of the 
        //+ file, either internally or by outsourcing to other methods.
        this.handleFile();
        
        
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
        String path = Preferences.userRoot().get("SvrURL", "/") +
                      Preferences.userRoot().get("EDIFilename", "incoming.edi");
        FileObject file = FileUtil.toFileObject(new File(path));
        
        // Verify that the file exists.
        if ( file.isValid() ) {
            // Handle all processing here... \\
            
        }
    }
    //</editor-fold>
}
