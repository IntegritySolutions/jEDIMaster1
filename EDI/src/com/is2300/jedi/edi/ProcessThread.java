/* {ProcessThread.java}
 * 
 * An extension of the Thread interface to have the processing of EDI trans-
 * missions run in a separate thread from the rest of the application and as a
 * daemon, so that it can complete before it ends, even if the application is
 * terminated during a run for some reason.
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

/**
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class ProcessThread extends Thread {
    public ProcessThread(String str) {
        super(str);
    }

    public void run() {
        // Create our Processor object to process the EDI transmissions.
        Processor shepherd = new Processor();
    }
}
