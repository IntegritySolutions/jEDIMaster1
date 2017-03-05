/* {ProcessTask.java}
 * 
 * A class to spawn a new thread for processing the EDI transmissions.
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

import java.util.TimerTask;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;

/**
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class ProcessTask extends TimerTask {
    // Private member field.
    ProcessThread proc;
    
    public ProcessTask() {
        proc = new ProcessThread("Processing");
    }

           
    @Override
    public void run() {
//        if ( proc.isDaemon() && proc.isAlive() ) {
//            try {
//                proc.join();
//            } catch (InterruptedException ex) {
//                InputOutput io = IOProvider.getDefault().getIO(
//                                                         "Thread Errors", true);
//                io.getOut().println("Processing file...");
//                io.getOut().println(new String(new char[80]).replace(
//                                                                    "\0", "-"));
//            }
//        } else {
//            proc.start();
//        }
        // Create our Processor object to process the EDI transmissions.
        Processor shepherd = new Processor();
    }

}
