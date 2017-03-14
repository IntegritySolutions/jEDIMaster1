/* {Validate824Segments.java}
 * 
 * This class has one (1) public method to use to validate EDI document segment
 * codes.
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

import java.util.ArrayList;
import java.util.List;

/**
 * The EDI Application Advice (Document Type 824) is used for reporting error
 * info to trading partners. The data is based off of the original or modified 
 * transaction sets or functional groups, which is sent to a trading
 * partner to advise them of any data-centric errors.
 * <p>
 * This <tt>Validator</tt> implementation is used on incoming Advice to verify
 * that all segments are valid. Once the Advice is processed from the EDI
 * transmission, the data is entered into the database and work items are 
 * created for the appropriate departments, provided that the data can still be
 * used. In other words, the data is not invalid to the point of needing to be
 * rejected in toto.
 * <p>
 * The following are the valid segments for an 810 Invoice:
 * <ul>
 * <li><strong>ISA</strong>: Interchange Control Header</li>
 * <li><strong>GS</strong>: Function Group Header</li>
 * <li><strong>ST</strong>: Transaction Set Header</li>
 * <li><strong>BGN</strong>: Beginning Segment for ASN</li>
 * <li><strong>N1</strong>: Name</li>
 * <li><strong>OTI</strong>: Original Transaction Indentification</li>
 * <li><strong>DTM</strong>: Date/Time Reference</li>
 * <li><strong>AMT</strong>: Monetary Amount</li>
 * <li><strong>TED</strong>: Technical Error Description</li>
 * <li><strong>SE</strong>: Transaction Set Trailer</li>
 * <li><strong>GE</strong>: Functional Group Trailer</li>
 * <li><strong>IEA</strong>: Interchange Control Trailer</li>
 * </ul>
 * <p>
 * Some of these segments may be used more than once within an EDI transmission,
 * but some may only be used once in a transmission. This <tt>Validator</tt>
 * only checks that the segment is valid within the 810 Invoice context, but not
 * whether it has been used more times than allowed. This is left up to the 
 * calling program to determine.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class Validate824Segments {

    public static Integer validate(List<String[]> toValidate) {
        // Create a return value.
        Integer errCnt = 0;
        
        // Create a validity flag.
        Boolean isValid = false;    // Default it to invalid segment.
        
        // A List object for storing the Segment fields data type, min and max
        //+ length values for the current segment.
        List<Object[]> fieldInfo = new ArrayList();
        Object[] arySegment = new Object[4];
        
        // Create a list to hold any and all errors that are discovered.
        List<Object[]> errors = new ArrayList();
        
        // Loop through all of the items in the list.
        for ( int x = 0; x < toValidate.size() - 1; x++ ) {
            // We need to check the supplied segment to see if it is valid.
            switch ( toValidate.get(x)[0] ) {
                // Since each case that is valid will set the `isValid` return 
                //+ variable to `true`, we're just going to use the "fall-through"
                //+ of the `case` functionality and only use the `break` statement
                //+ when we set the return variable to `true`.
    //            case "ISA":
    //            case "GS":
                case "ST":
                    // Create a List of Segment data types with min and max
                    //+ length value.
                    arySegment[0] = "ID";   // ST01
                    arySegment[1] = 3;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // ST02
                    arySegment[1] = 4;
                    arySegment[2] = 9;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "BGN":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    arySegment[0] = "ID";   // BGN01
                    arySegment[1] = 2;
                    arySegment[2] = 2;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // BGN02
                    arySegment[1] = 1;
                    arySegment[2] = 30;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "DT";   // BGN03
                    arySegment[1] = 8;
                    arySegment[2] = 8;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "TM";   // BGN04
                    arySegment[1] = 4;
                    arySegment[2] = 8;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "N1":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    arySegment[0] = "ID";   // N101
                    arySegment[1] = 2;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "ID";   // N103
                    arySegment[1] = 1;
                    arySegment[2] = 2;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // N104
                    arySegment[1] = 2;
                    arySegment[2] = 80;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "OTI":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    arySegment[0] = "ID";   // OTI01
                    arySegment[1] = 1;
                    arySegment[2] = 2;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "ID";   // OTI02
                    arySegment[1] = 2;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // OTI03
                    arySegment[1] = 1;
                    arySegment[2] = 30;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "ID";   // OTI10
                    arySegment[1] = 3;
                    arySegment[2] = 3;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "DTM":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    arySegment[0] = "ID";   // DTM01
                    arySegment[1] = 3;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "DT";   // DTM02
                    arySegment[1] = 8;
                    arySegment[2] = 8;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "TM";   // DTM 03
                    arySegment[1] = 4;
                    arySegment[2] = 8;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "AMT":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values.
                    arySegment[0] = "ID";   // AMT01
                    arySegment[1] = 1;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "R";    // AMT02
                    arySegment[1] = 1;
                    arySegment[2] = 18;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "TED":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values;
                    arySegment[0] = "ID";   // TED01
                    arySegment[1] = 1;
                    arySegment[2] = 3;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // TED02
                    arySegment[1] = 1;
                    arySegment[2] = 60;
                    arySegment[3] = false;
                    fieldInfo.add(arySegment);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                case "SE":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values.
                    arySegment[0] = "N0";   // SE01
                    arySegment[1] = 1;
                    arySegment[2] = 10;
                    arySegment[3] = true;
                    fieldInfo.add(arySegment);
                    arySegment[0] = "AN";   // SE02
                    arySegment[1] = 4;
                    arySegment[2] = 9;
                    arySegment[3] = true;
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    fieldInfo.add(arySegment);
    //            case "GE":
    //            case "IEA":
                    isValid = true;
                    break;
            } // End switch...case block.
            
            // If we ever have an invalid segment, we need to count the error
            //+ because if we only have one error, we may still be able to use
            //+ the transaction set, but more than one error and we may need to
            //+ fail the whole transaction set.
            if ( !isValid ) {
                errCnt++;
            }
        } // End for loop.
        
        // Return our error count.
        return errCnt;
    }

    private static void validateSegment(String[] segment, int numFields, 
                                      int reqFields, List<Object[]> fieldInfo) {
        // Create a List<Object[]> to return.
        List<Object[]> retVal = new ArrayList();
        
        // Create an Object array to hold our returnable information. This 
        //+ information is as follows:
        //+     array[0] = String   Segment ID
        //+     array[1] = Boolean  Segment in error
        //+     array[2] = String   Description of error
        Object[] errors = new Object[3];
        
        // Create some variables to hold the actual requirements for the field
        //+ information to validate. The List<Object[]> should be as follows:
        //+     List[0]: [0] String, [1] int, [2] int, [3] boolean
        //+ And the fields represent:
        //+     List[0]: [0] Data type, [1] min chars, [2] max chars, and
        //+              [3] data required
        String dataType;
        Integer minChars;
        Integer maxChars;
        Boolean required;
        
        // Declare a marker to hold where we currently are in our String array.
        int x = 0;
        
        // We are going to need to loop through the list to validate each field
        //+ in the segment.
        for ( Object[] obj : fieldInfo ) {
            // First, grab our field information so we know what we are 
            //+ validating.
            dataType = (String) obj[0];
            minChars = (Integer) obj[1];
            maxChars = (Integer) obj[2];
            required = (Boolean) obj[3];
            
            // Now, we need to loop through all of the fields in 
        }
    }

}
