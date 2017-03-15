/* {Utils.java}
 * 
 * This class provides some functionality through static methods for data 
 * conversion, string manipulation, math and similar types of needs.
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

package com.is2300.jedi.edi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The jEDI <tt>Utils</tt> class is a source of methods for manipulating data
 * throughout the jEDI utility. All methods contained in this class are static,
 * the the class does not need to be initialize in order to use them, they can
 * just be accessed as needed.
 * 
 * @author Sean Carrick &lt;<a href="mailto:PekinSOFT@outlook.com">
 *              PekinSOFT@outlook.com</a>&gt;
 * @version <strong><em>Program:</em></strong> [Version]
 * @since [Version]
 */
public class Utils {
    /**
     * <tt>string2Date(String date)</tt> returns a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Date.html">
     * java.util.Date</a></tt> object that can then be used as is or to create
     * other objects for use, such as a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html">
     * java.util.Calendar</a></tt> object.
     * 
     * @param date the <tt>java.lang.String</tt> that needs to be converted to a
     *             <tt>java.util.Date</tt> object. The string needs to be 
     *             formatted as either:
     *              <ul><li>YYMMDD</li>
     *                  <li>YYYYMMDD</li></ul>
     *             If the string is formatted in any other manner, an invalid
     *             date will be returned. <em>It is good practice to validate
     *             the returned <tt>java.util.Date</tt> object before using it
     * @return <tt>java.util.Date</tt> object initialized to the date string
     *          that was provided.
     */
    public static Date string2Date(String date) {
        // Declare three strings to hold the month, day and year once we parse
        //+ them out of the date string that is provided.
        String day = null;
        String month = null;
        String year = null;
        
        // Also, declare a DateFormat object that we will need to initialize
        //+ when we split the string.
        DateFormat fmt = null;
        
        // And, declare the Date object that we are going to return.
        Date retVal;
        
        // Now, check the length of the date string.
        if ( date.length() == 6 ) {
            // The format of the string is YYMMDD, so we need to parse those
            //+ individual fields out of the string.
            year = date.substring(0, 1);
            month = date.substring(2, 3);
            day = date.substring(4, 5);
            
            // Initialize our formatter.
            fmt = new SimpleDateFormat("MM/dd/yy");
        } else if ( date.length() == 8 ) {
            // The format of the string is YYYYMMDD, so we need to parse those
            //+ individual fields out of the string.
            year = date.substring(0, 3);
            month = date.substring(4, 5);
            day = date.substring(6, 7);
            
            // Initialize our formatter.
            fmt = new SimpleDateFormat("MM/dd/yyyy");
        }
        
        // Now that the date is parsed into the day, month and year variables,
        //+ we should be able to create a new java.util.Date object by passing
        //+ those values to the constructor.
        try {
            retVal = fmt.parse(month + "/" + day + "/" + year);
        } catch (ParseException ex) {
            // Since we ran into a problem creating the date, we need to return
            //+ a null object.
            retVal = null;
        }
        
        // Return our return value.
        return retVal;
    }
    
    /**
     * <tt>string2Date(String date, String time)</tt> returns a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Date.html">
     * java.util.Date</a></tt> object that can then be used as is or to create
     * other objects for use, such as a <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html">
     * java.util.Calendar</a></tt> object.
     * 
     * @param date the <tt>java.lang.String</tt> that needs to be converted to a
     *             <tt>java.util.Date</tt> object. The string needs to be 
     *             formatted as either:
     *              <ul><li>YYMMDD</li>
     *                  <li>YYYYMMDD</li></ul>
     *             If the string is formatted in any other manner, an invalid
     *             date will be returned. <em>It is good practice to validate
     *             the returned <tt>java.util.Date</tt> object before using it
     *             </em>
     * @param time the <tt>java.lang.String</tt> that needs to be converted to a
     *              <tt>java.util.Date</tt> object. The string needs to be 
     *              formatted as either:
     *              <ul><li>HHMM</li>
     *                  <li>HHMMSS</li></ul>
     *              If the string is formatted in any other manner, an invalid
     *              date will be returned. <em>It is good practice to validate
     *              the returned <tt>java.util.Date</tt> object before using it
     *              </em>
     * @return <tt>java.util.Date</tt> object initialized to the date string
     *          that was provided.
     */
    public static Date string2Date(String date, String time) {
        // Declare three strings to hold the month, day and year once we parse
        //+ them out of the date string that is provided.
        Integer day = null;
        Integer month = null;
        Integer year = null;
        
        // Declare three strings to hold the house, minutes and seconds once we
        //+ parse them out of the time string that is provided.
        Integer hours = null;
        Integer minutes = null;
        Integer seconds = null;
        
        // Now, check the length of the date string.
        if ( date.length() == 6 ) {
            // The format of the string is YYMMDD, so we need to parse those
            //+ individual fields out of the string.
            year = new Integer(date.substring(0, 2));
            month = new Integer(date.substring(2, 4));
            day = new Integer(date.substring(4, 6));

        } else if ( date.length() == 8 ) {
            // The format of the string is YYYYMMDD, so we need to parse those
            //+ individual fields out of the string.
            year = new Integer(date.substring(0, 4));
            month = new Integer(date.substring(4, 6));
            day = new Integer(date.substring(6, 8));
            
        }
        
        // Next, we need to deal with the time. So, we need to check its length.
        if ( time.length() == 4 ) {
            // The format of the string is HHMM, so we need to parse those
            //+ individual fields out of the string.
            hours = new Integer(time.substring(0, 2));
            minutes = new Integer(time.substring(2, 4));
            seconds = 0;
            
        } else if ( time.length() == 6 ) {
            // The format of the string is HHMMSS, so we need to parse those
            //+ individual fields out of the string.
            hours = new Integer(time.substring(0, 2));
            minutes = new Integer(time.substring(2, 4));
            seconds = new Integer(time.substring(4, 6));
            
        }
        
        // Return our new Date object.
        return new Date(year, month, day, hours, minutes, seconds);
    }
    
    
    public static Date string2Time(String time) {
        // Declare three strings to hold the house, minutes and seconds once we
        //+ parse them out of the time string that is provided.
        Integer hours = null;
        Integer minutes = null;
        Integer seconds = null;
            
        // Next, we need to deal with the time. So, we need to check its length.
        if ( time.length() == 4 ) {
            // The format of the string is HHMM, so we need to parse those
            //+ individual fields out of the string.
            hours = new Integer(time.substring(0, 2));
            minutes = new Integer(time.substring(2, 4));
            seconds = 0;
            
        } else if ( time.length() == 6 ) {
            // The format of the string is HHMMSS, so we need to parse those
            //+ individual fields out of the string.
            hours = new Integer(time.substring(0, 2));
            minutes = new Integer(time.substring(2, 4));
            seconds = new Integer(time.substring(4, 6));
            
        }
        
        // Return our new Date object.
        return new Date(0, 0, 0, hours, minutes, seconds);
}
}
