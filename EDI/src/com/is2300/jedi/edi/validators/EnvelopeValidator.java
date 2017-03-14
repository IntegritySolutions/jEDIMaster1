/* {EnvelopeValidator.java}
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
 * Performs validation on Interchange Envelopes. Validation is performed by 
 * checking that the Interchange Control Number in the header (ISA) and trailer 
 * (IEA) match. Also, verifies that the functional group count stated in the 
 * trailer (IEA) is the same as the actual count obtained during the parsing 
 * algorithm.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class EnvelopeValidator {

    public static Boolean validate(String isaCtlNumber, String ieaCtlNumber,
                                   Integer statedCount, Integer actualCount) {
        // Declare a return variable.
        Boolean retVal = false;     // Default to invalid.
        
        // Check that the header and trailer control numbers match and that the
        //+ stated group count and actual group count match.
        if ( isaCtlNumber.equals(ieaCtlNumber) &&
                statedCount.equals(actualCount) ) {
            // When the above conditions are met, we have a valid envelope.
            retVal = true;
        }
        
        // Return our findings.
        return retVal;
    }
    
}
