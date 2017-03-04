/* {Installer.java}
 * 
 * A class to kick off the processing the EDI transmission files.
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
import java.util.prefs.Preferences;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
         
        // Create a Timer object.
        Timer process = new Timer(true);
        
        // Get the processor schedule from the settings.
        Integer period = Preferences.userRoot().getInt("CheckPeriod", 15);
        String style = Preferences.userRoot().get("TimePeriod", "minutes");
        Integer inc = 0;
        
        // Determine the period style to use: minutes or hours.
        if ( style.equalsIgnoreCase("minutes") ) {
            inc = 60 * 1000; // Our increaser is set to sixty seconds.
        } else if ( style.equalsIgnoreCase("hours") ) {
            inc = (60 * 60) * 1000; // Our increaser is set to sixty minutes.
        }
        
        // Calculate the milliseconds for our Timer to wait between runs.
        period = period * inc;  // Multiply the period by the increaser.
        
        // Create our schedule for the Timer to execute our Thread.
        process.schedule(new ProcessTask(), 0, period);
    }

}
