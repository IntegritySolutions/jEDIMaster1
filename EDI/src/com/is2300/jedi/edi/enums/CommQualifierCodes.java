/* {CurrencyCodes.java}
 * This enumeration provides access to all of the ISO Standard currency codes 
 * for the currencies of the world.
 *
 * Copyright (c) 2017 Integrity Solutions
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
package com.is2300.jedi.edi.enums;

/**
 * <code>CommQualifierCodes</code> is an enumeration of valid codes that 
 * identify the type of communication contained in an EDI transmission PER
 * segment, PER04, PER06, and PER08 field.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum CommQualifierCodes {
    EMAIL("EM"),
    FAX("FX"),
    TELEPHONE("TE"),
    WEBSITE("UR");
    
    /**
     * Value of the current enumeration implementation.
     */
    private String value;
    
    /**
     * Constructor for the enumeration.
     * 
     * @param java.lang.String the value to be used for this enumeration
     */
    private CommQualifierCodes(String value) {
        this.value = value;
    }
    
    /**
     * Returns the <code>java.lang.String</code> representation of the current
     * value.
     * 
     * @return java.lang.String the current value of this enumeration
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Returns the definition for the current code value.
     * 
     * @return java.lang.String the definition of the current code value
     */
    public String getDefinition() {
        // Declare a variable to hold the return value.
        String r = null;
        
        // Figure out what the current value is and return the appropriate 
        //+ definition.
        switch ( this.value.toLowerCase() ) {
            case "em":
                r = "Email Address";
                break;
            case "fx":
                r = "Fax Number";
                break;
            case "te":
                r = "Telephone Number";
                break;
            case "ur":
                r = "Website Universal Resource Locator (URL)";
                break;
            default:
                r = "Undefined Contact Type";
                break;
        }
        
        // Return the value.
        return r;
    }
}
