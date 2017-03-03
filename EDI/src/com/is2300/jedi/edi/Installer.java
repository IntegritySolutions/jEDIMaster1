/* {Installer.java}
 * 
 * A class to kick off the processing of incoming EDI transmission files.
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

import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;
import org.openide.modules.ModuleInstall;
import org.openide.util.NbPreferences;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        
        // Create an anonymous inner Thread class.
        class ProcessThread extends Thread {
            public ProcessThread(String str) {
                super(str);
            }
            
            public void run() {
                // Create our Processor object to process the EDI transmissions.
                Processor shepherd = new Processor();
            }
        };
        
        // Create a Timer.
        Timer process = new Timer(true);
        
        // Get the processor schedule from the settings.
        Integer time = Preferences.userRoot().getInt("CheckPeriod", 15);
        String period = Preferences.userRoot().get("TimePeriod", "minutes");
        Integer by = 0;
        
        // Determine the time period to use: minutes or hours.
        if ( period.equalsIgnoreCase("minutes") ) {
            by = 60;
        } else if ( period.equalsIgnoreCase("hours") ) {
            by = 60*60;
        }
        
        // Calculate the milliseconds for our Timer to wait between runs.
        time *= by;
        
        // Create our schedule for the Timer to execute our Thread.
        process.schedule(new ProcessTask(), time, time);
    }

}
