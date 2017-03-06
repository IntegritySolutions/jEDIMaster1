/* {FGValidator.java}
 * 
 * This class has one (1) public method to use to validate EDI document type
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

package com.is2300.jedi.edi.impl;

/**
 * Performs validation on Functional Groups. Validation is performed by checking
 * that the Functional Group Control Number in the header (GS) and trailer (GE)
 * match. Also, verifies that the transaction count stated in the trailer (GE)
 * is the same as the actual count obtained during the parsing algorithm.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class FGValidator {

    public static Boolean validateGroup ( String gsCtlNumber, String geCtlNumber,
                                   Integer statedCount, Integer actualCount ) {
        // Declare a return variable.
        Boolean retVal = false;     // Default to invalid.
        
        // Validate that the group control numbers match in the header and 
        //+ trailer and that the transaction count stated in the trailer is the
        //+ same as the actual transaction count..
        if ( gsCtlNumber.equals(geCtlNumber) && 
                statedCount.equals(actualCount) ) {
            retVal = true;
        }
        
        // Return our findings.
        return retVal;
    }

}
