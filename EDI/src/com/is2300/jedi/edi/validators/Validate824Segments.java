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
        // Debugger loop counter.
        int dbgCount = 0;
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
//                case "ISA":
//                case "GS":
                ////////////////////////////////////////////////////////////////
                /////////////////// I N F O R M A T I O N //////////////////////
                ////////////////////////////////////////////////////////////////
                // In the following `case` blocks, we create multiple Object  //
                // arrays which are clones of the Object array, arySegment.   //
                // This is necessary to make sure that each element of our    //
                // List<Object[]> is unique. If we were to simply change the  //
                // data in `arySegment`, then readd it to the List<Object[]>, //
                // fieldInfo, we would have a list of the proper number of    //
                // elements, but each element would contain the same data.    //
                // This is because the List interface DOES NOT hold the data, //
                // but a reference to the data. Therefore, whenever we were to//
                // change the data in `arySegment`, the data in each element  //
                // of the list gets changed as well. The clones of arySegment //
                // allow us to place different data in each element of the    //
                // `fieldInfo` List, which is the desired outcome. After we   //
                // are done with each Object[] array, other than arySegment,  //
                // we set that Object[] array to null so that it can be       //
                // cleaned up by the garbage collector and we don't waste any //
                // system resources, nor create a memory leak.                //
                ////////////////////////////////////////////////////////////////
                case "ST":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Create a List of Segment data types with min and max
                    //+ length value.
                    Object[] st01 = arySegment.clone();
                    st01[0] = "ID";   // ST01
                    st01[1] = 3;
                    st01[2] = 3;
                    st01[3] = true;
                    fieldInfo.add(st01);
                    Object[] st02 = arySegment.clone();
                    st02[0] = "AN";   // ST02
                    st02[1] = 4;
                    st02[2] = 9;
                    st02[3] = true;
                    fieldInfo.add(st02);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    st01 = null;
                    st02 = null;
                    
                    // Break out of the switch block.
                    break;
                case "BGN":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    Object[] bgn01 = arySegment.clone();
                    bgn01[0] = "ID";   // BGN01
                    bgn01[1] = 2;
                    bgn01[2] = 2;
                    bgn01[3] = true;
                    fieldInfo.add(bgn01);
                    Object[] bgn02 = arySegment.clone();
                    bgn02[0] = "AN";   // BGN02
                    bgn02[1] = 1;
                    bgn02[2] = 30;
                    bgn02[3] = true;
                    fieldInfo.add(bgn02);
                    Object[] bgn03 = arySegment.clone();
                    bgn03[0] = "DT";   // BGN03
                    bgn03[1] = 8;
                    bgn03[2] = 8;
                    bgn03[3] = true;
                    fieldInfo.add(bgn03);
                    Object[] bgn04 = arySegment.clone();
                    bgn04[0] = "TM";   // BGN04
                    bgn04[1] = 4;
                    bgn04[2] = 8;
                    bgn04[3] = false;
                    fieldInfo.add(bgn04);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 4, 3, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    bgn01 = null;
                    bgn02 = null;
                    bgn03 = null;
                    bgn04 = null;
                    
                    // Break out of the switch block.
                    break;
                case "N1":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    Object[] n101 = arySegment.clone();
                    n101[0] = "ID";   // N101
                    n101[1] = 2;
                    n101[2] = 3;
                    n101[3] = true;
                    fieldInfo.add(n101);
                    Object[] n103 = arySegment.clone();
                    n103[0] = "ID";   // N103
                    n103[1] = 1;
                    n103[2] = 2;
                    n103[3] = false;
                    fieldInfo.add(n103);
                    Object[] n104 = arySegment.clone();
                    n104[0] = "AN";   // N104
                    n104[1] = 2;
                    n104[2] = 80;
                    n104[3] = false;
                    fieldInfo.add(n104);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 3, 1, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    n101 = null;
                    n103 = null;
                    n104 = null;
                    
                    // Break out of the switch block.
                    break;
                case "OTI":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    Object[] oti01 = arySegment.clone();
                    oti01[0] = "ID";   // OTI01
                    oti01[1] = 1;
                    oti01[2] = 2;
                    oti01[3] = true;
                    fieldInfo.add(oti01);
                    Object[] oti02 = arySegment.clone();
                    oti02[0] = "ID";   // OTI02
                    oti02[1] = 2;
                    oti02[2] = 3;
                    oti02[3] = true;
                    fieldInfo.add(oti02);
                    Object[] oti03 = arySegment.clone();
                    oti03[0] = "AN";   // OTI03
                    oti03[1] = 1;
                    oti03[2] = 30;
                    oti03[3] = true;
                    fieldInfo.add(oti03);
                    Object[] oti10 = arySegment.clone();
                    oti10[0] = "ID";   // OTI10
                    oti10[1] = 3;
                    oti10[2] = 3;
                    oti10[3] = false;
                    fieldInfo.add(oti10);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 4, 1, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    oti01 = null;
                    oti02 = null;
                    oti03 = null;
                    oti10 = null;
                    
                    // Break out of the switch block.
                    break;
                case "DTM":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length value.
                    Object[] dtm01 = arySegment.clone();
                    dtm01[0] = "ID";   // DTM01
                    dtm01[1] = 3;
                    dtm01[2] = 3;
                    dtm01[3] = true;
                    fieldInfo.add(dtm01);
                    Object[] dtm02 = arySegment.clone();
                    dtm02[0] = "DT";   // DTM02
                    dtm02[1] = 8;
                    dtm02[2] = 8;
                    dtm02[3] = false;
                    fieldInfo.add(dtm02);
                    Object[] dtm03 = arySegment.clone();
                    dtm03[0] = "TM";   // DTM03
                    dtm03[1] = 4;
                    dtm03[2] = 8;
                    dtm03[3] = false;
                    fieldInfo.add(dtm03);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 3, 1, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    dtm01 = null;
                    dtm02 = null;
                    dtm03 = null;
                    
                    // Break out of the switch block.
                    break;
                case "AMT":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values.
                    Object[] amt01 = arySegment.clone();
                    amt01[0] = "ID";   // AMT01
                    amt01[1] = 1;
                    amt01[2] = 3;
                    amt01[3] = true;
                    fieldInfo.add(amt01);
                    Object[] amt02 = arySegment.clone();
                    amt02[0] = "R";    // AMT02
                    amt02[1] = 1;
                    amt02[2] = 18;
                    amt02[3] = true;
                    fieldInfo.add(amt02);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    amt01 = null;
                    amt02 = null;
                    
                    // Break out of the switch block.
                    break;
                case "TED":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values;
                    Object[] ted01 = arySegment.clone();
                    ted01[0] = "ID";   // TED01
                    ted01[1] = 1;
                    ted01[2] = 3;
                    ted01[3] = true;
                    fieldInfo.add(ted01);
                    Object[] ted02 = arySegment.clone();
                    ted02[0] = "AN";   // TED02
                    ted02[1] = 1;
                    ted02[2] = 60;
                    ted02[3] = false;
                    fieldInfo.add(ted02);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 1, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    ted01 = null;
                    ted02 = null;
                    
                    // Break out of the switch block.
                    break;
                case "SE":
                    // Start by clearing the fieldInfo list.
                    fieldInfo.clear();
                    
                    // Then create a list of Segment data types with min and max
                    //+ length values.
                    Object[] se01 = arySegment.clone();
                    se01[0] = "N0";   // SE01
                    se01[1] = 1;
                    se01[2] = 10;
                    se01[3] = true;
                    fieldInfo.add(se01);
                    Object[] se02 = arySegment.clone();
                    se02[0] = "AN";   // SE02
                    se02[1] = 4;
                    se02[2] = 9;
                    se02[3] = true;
                    fieldInfo.add(se02);
                    
                    errors = SegmentValidator.validate(toValidate.get(x), 2, 2, 
                                                       fieldInfo);
                    errCnt += errors.size();
                    fieldInfo.add(arySegment);
//                case "GE":
//                case "IEA":
//                    isValid = true;
                    // Prepare the Object arrays we created for garbage col-
                    //+ lection.
                    se01 = null;
                    se02 = null;
                    
                    // Break out of the switch block.
                    break;
            } // End switch...case block.

////////////////////////////////////////////////////////////////////////////////
///////////////////// N O   L O N G E R   N E E D E D //////////////////////////
////////////////////////////////////////////////////////////////////////////////
//            // If we ever have an invalid segment, we need to count the error
//            //+ because if we only have one error, we may still be able to use
//            //+ the transaction set, but more than one error and we may need 
//            //+ to fail the whole transaction set.
//            if ( !isValid ) {
//                errCnt++;
//            }
////////////////////////////////////////////////////////////////////////////////
        } // End for loop.
        
        // Return our error count.
        return errCnt;
    }

}
