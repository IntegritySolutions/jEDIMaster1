/* {TxValidator.java}
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

package com.is2300.jedi.edi.validators;

/**
 * Performs validation on Transaction Sets. Validation is performed by 
 * checking that the Transaction Set Control Number in the header (ST) and 
 * trailer (SE) match. Also, verifies that the segment count stated in the 
 * trailer (SE) is the same as the actual count obtained during the parsing 
 * algorithm.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class TxValidator {

    public static Boolean validate(String stCtlNumber, String seCtlNumber,
                                   Integer statedCount, Integer actualCount) {
        // Declare a return variable.
        Boolean retVal = false;     // Default to invalid transaction.
        
        // Validate that the transaction set control number in the header and
        //+ trailer are the same and that the number of included segments is the
        //+ same as stated in the trailer.
        if ( stCtlNumber.equals(seCtlNumber) &&
                statedCount.equals(actualCount) ) {
            // When the above conditions are met, we have a valid transaction
            //+ set.
            retVal = true;
        }
        
        // Return our findings.
        return retVal;
    }
    
}
