/* {SegmentValidator.java}
 * 
 * This class has one (1) public method to use to validate EDI document segment
 * data.
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

package com.is2300.jedi.edi.validators;

import com.is2300.jedi.edi.utils.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The <code>SegmentValidator</code> class provides one, <em>generic</em> method
 * that allows the calling class to validate <strong>any</strong> EDI segment.
 * <p>
 * The validation algorithm for validating EDI segments takes certain parameters
 * to allow it to have an understanding of the segment it is validating, 
 * including the data the segment is supposed to contain. By allowing any EDI
 * segment to be validated by this one algorithm, it is very generic by design.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class SegmentValidator {

    /**
     * This is a generic function for validating EDI segments and their data.
     * <p>
     * The <code>validate</code> function is used to validate the segment and 
     * its data for any EDI segment. Particular attention needs to be paid to 
     * what is expected in the function parameters.
     * 
     * @param segment           An array of <code>java.lang.String</code>
     *                          objects that contain the various fields of the
     *                          EDI segment.
     * 
     * @param fieldCount        The number of fields this segment contains.
     * 
     * @param requiredCount     The number of fields this segment is required
     *                          to contain.
     * 
     * @param fieldInfo         An list of <code>java.lang.Object</code> 
     *                          object arrays that need to be as follows:
     *                          <ol><li><code>java.lang.String</code> that holds
     *                                  the data type code for this field</li>
     *                              <li><code>java.lang.Integer</code> that 
     *                                  holds the minimum number of characters
     *                                  that are required in this field</li>
     *                              <li><code>java.lang.Integer</code> that
     *                                  holds the maximum number of characters
     *                                  that are allowed in this field</li>
     *                              <li><code>java.lang.Boolean</code> that
     *                                  tells whether this field's data is 
     *                                  mandatory or required (true); not 
     *                                  mandatory or required (false)</li></ol>
     * 
     * @return                  A list of <code>java.lang.Object</code> object
     *                          arrays that holds the following information:
     *                          <ol><li><code>java.lang.String</code> that holds
     *                                  the segment identifier (i.e., ISA, GS,
     *                                  ST, BIG, etc.)</li>
     *                              <li><code>java.lang.Boolean</code> that 
     *                                  tells whether the segment was in error
     *                                  (true) or not (false)</li>
     *                              <li><code>java.lang.String</code> that holds
     *                                  the description of the error.</li></ol>
     */
    public static List<Object[]> validate(String[] segment, int fieldCount,
                                          int requiredCount, 
                                          List<Object[]> fieldInfo) {
        // First off, declare a return variable to hold our list of Objects.
        List<Object[]> retVal = new ArrayList();
        
        // Second of all, we need to create an error Object array for reporting
        //+ any and all errors that we discover.
        Object[] errors = new Object[3];
        
        // The first validation to do is to verify that the String array has
        //+ exactly one more element than the List of Objects.
        int segCnt = segment.length;
        int infCnt = fieldInfo.size();
        
        if ( (segCnt - infCnt) == 1 && 
             (fieldCount >= requiredCount)) {
            // We're golden! This means that our segment has exactly one more
            //+ element than our fieldInfo List, which is as it should be.
            //+ Therefore, we can continue with our validation.
            //
            // We need to create some variables to hold the information for
            //+ validating the segment fields. This is just to make everything
            //+ easier to understand later.
            String dataType;    // The data type, i.e., AN, ID, N0, etc.
            Integer minChars;   // The minimum number of characters in the data
            Integer maxChars;   // The maximum number of characters in the data
            Boolean isRequired; // Whether or not data is required.
            
            // Also, we should create a marker to maintain our location in the
            //+ array of String objects contained in `segment`.
            int currentElement = 1; // Zeroeth element is the segment ID. No
                                    //+ validation required for it.
            
            // Now, we need to loop through each of the Object arrays in the
            //+ fieldInfo List in order to validate the fields of the segment.
            for (Object[] field : fieldInfo ) {
                // First thing here is to get our data metrics out of our 
                //+ current list item.
                dataType = (String) field[0];
                minChars = (Integer) field[1];
                maxChars = (Integer) field[2];
                isRequired = (Boolean) field[3];
                
                // Next, we need to check that the data in the field complies
                //+ with the required data type. The only data types we really
                //+ need to verify are numeric and date/time. All other EDI data
                //+ types can be alpha-numeric, so anything goes with them.
                if ( dataType.toLowerCase().equals("n0") ) {
                    // We can verify that the data in this field is numeric by
                    //+ simply attempting to cast it to an Integer, Float or
                    //+ Double data type. If it fails, then we know that it is
                    //+ not valid data. In order to attempt casting it to the
                    //+ correct data type, we need to determine whether or not
                    //+ there is a decimal in the number. Since the data is
                    //+ currently in String form, we can simply use the methods
                    //+ of the String class to determine this.
                    if ( segment[currentElement].contains(".") ) {
                        // This is some form of decimal, non-integer, number.
                        //+ Therefore, we need to attempt casting to a float or
                        //+ a double. In order to accomplish attempting both a
                        //+ float and a double, we are going to attempt the 
                        //+ double first. If it throws an exception, we will
                        //+ attempt a float in the catch block. If that also
                        //+ does not work, we will add to our error List.
                        try {
                            Double d = Double.parseDouble(
                                                       segment[currentElement]);
                        } catch (NumberFormatException ex) {
                            // Since parsing into a double failed, let's now try
                            //+ parsing into a float.
                            try {
                                Float f = Float.parseFloat(
                                                       segment[currentElement]);
                            } catch (NumberFormatException e) {
                                // Since neither of those worked, we can assume
                                //+ that the data is not valid. Therefore, we
                                //+ are going to add this field to our errors
                                //+ list.
                                errors[0] = segment[0]; // Segment Identifier
                                errors[1] = true;       // Ther IS an error
                                errors[2] = "Number value required, but non-" +
                                            "numerical string supplied.";
                                
                                // Add the Object array to our list.
                                retVal.add(errors);
                            } // End inner try...catch block.
                        } // End outer try...catch block.
                    } else {
                        // We can now assume that this is a whole number, an
                        //+ integer. Therefore, we can attempt to parse the data
                        //+ to an integer to validate the value.
                        try {
                            Integer i = Integer.parseInt(
                                                       segment[currentElement]);
                        } catch (NumberFormatException ex) {
                            // Since parsing the string to an integer did not
                            //+ work, we can assume that the data is invalid and
                            //+ add this field to our errors list.
                            errors[0] = segment[0]; // Segment Identifier
                            errors[1] = true;       // Ther IS an error
                            errors[2] = "Number value required, but non-" +
                                        "numerical string supplied.";
                            
                            // Add the Object array to our list.
                            retVal.add(errors);
                        } // End try...catch block.
                    } // End inner if...else block.
                } else if ( dataType.toLowerCase().equals("dt") ) {
                    // This data type is supposed to contain a Date. EDI Date
                    //+ fields can be formatted as either YYMMDD or YYYYMMDD.
                    //+ We will use our Utils class to determine if this data
                    //+ is valid or not.
                    Date dt = Utils.string2Date(segment[currentElement]);
                    
                    // Create a date to represent the current date so that we 
                    //+ at least validate that the date in this field is not in
                    //+ the future.
                    Date d2 = new Date();
                    
                    if (dt.compareTo(d2) > 0) {
                        // Cannot be valid becuase it is in the future, so add
                        //+ this field to our errors list.
                        errors[0] = segment[0];  // Segment identifier
                        errors[1] = true;       // There IS an error
                        errors[2] = "The date in this field is not a valid " +
                                    "date.";
                        
                        // Add the error array to our list.
                        retVal.add(errors);
                    } // End of date validation if block.
                } else if ( dataType.toLowerCase().equals("tm") ) {
                    // This data type is supposed to contain a Time value. EDI
                    //+ time fields can be formatted as either HHMM or HHMMSS.
                    //+ We will use our Utils class to determine if this data
                    //+ is valid or not.
                    Date dt = Utils.string2Time(segment[currentElement]);
                    
                    // Now, we need to be sure that the time is valid and not
                    //+ null.
                    if ( dt == null ) {
                        // This is not valid, so add this field to our errors
                        //+ list.
                        errors[0] = segment[0]; // Segment identifier
                        errors[1] = true;       // There IS an error
                        errors[2] = "The time in this field is not a valid " +
                                    "time.";
                        
                        // Add the error to our list
                        retVal.add(errors);
                    }
                } // End of data type validation block.
                
                // Now that we've validated the data type, we need to validate
                //+ the data length. Each field in an EDI segment has a minimum
                //+ and a maximum length. These limits are provided in our local
                //+ variables minChars and maxChars. We simply need to grab the
                //+ length of the current field and verify that it falls between
                //+ the minimum and maximum length for the field.
                Integer fieldLength = segment[currentElement].length();
                
                if ( fieldLength < minChars ) {
                    // The field length is too short, so this is an error.
                    errors[0] = segment[0]; // Segment identifier
                    errors[1] = true;       // There IS an error
                    errors[2] = "The data is too short for this field.";
                    
                    // Add the error to our list.
                    retVal.add(errors);
                } else if ( fieldLength > maxChars ) {
                    // The field length is too long, so this is an error.
                    errors[0] = segment[0]; // Segment identifier
                    errors[1] = true;       // There IS an error
                    errors[2] = "The data is too long for this field.";
                    
                    // Add the error to our list.
                    retVal.add(errors);
                } // End of length check.
                
                // The last thing to check is whether or not the data is 
                //+ mandatory for this field.
                if ( isRequired ) {
                    // Since the data is mandatory, we need to verify that data
                    //+ is present. To do this, we just make sure that the field
                    //+ is not null.
                    if ( segment[currentElement] == null ) {
                        // This is an error.
                        errors[0] = segment[0]; // Segment identifier
                        errors[1] = true;       // There IS an error
                        errors[2] = "This is a MANDATORY field, but it is " +
                                    "blank.";
                        
                        // Add the error to our list.
                        retVal.add(errors);
                    } // End of null check.
                } // End of mandatory data check.
            } // End for each loop.
        } else {
            // Houston, we have a problem! We were not given enough information,
            //+ or we were given too much information, for validating the fields
            //+ of the segment. Therefore, we need to set up our error object to
            //+ advise the calling class as to what went wrong.
            errors[0] = segment[0]; // The segment identifier.
            errors[1] = true;       // There IS an error.
            errors[2] = "There was either not enough, or too much, information"
                        + " provided to validate the segment field data.\n\t" +
                        "Number of fields in segment: " + segCnt + "\n\t" +
                        "Number of items in fieldInfo: " + infCnt + "\n\n" +
                        "The number of items in the fieldInfo list should be " +
                        "exactly one (1) less than the number of elements in " +
                        "the segment array.\n" +
                        "Please correct these errors and try again.";
            
            // Add this object to our return list.
            retVal.add(errors);
        } // End of all data validation.
        
        // Lastly, return our findings.
        return retVal;
    }
    
}
