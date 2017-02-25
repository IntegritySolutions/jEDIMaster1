/* {FunctionalIdentifierCodes.java}
 * This enumeration provides access to all of the valid Functional Group
 * Identifier Codes that can be used in an EDI transmission.
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
 * Provides all of the valid Functional Group Identifier codes for use within an
 * EDI transmission's GS segment.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum FunctionalIdentifierCodes {
    INVOICE("IN");
    
    /**
     * Private field to hold the Functional Identifier Code for this value.
     */
    private String value;
    
    /**
     * Private constructor to establish the Functional Identifier Code.
     * 
     * @param val code to set
     */
    private FunctionalIdentifierCodes(String val) {
        this.value = val;
    }
    
    /**
     * Function to get the full name of the Functional Identifier Code for the
     * current value.
     * 
     * @return java.lang.String Functional Identifier full name
     */
    @Override
    public String toString() {
        String r = null;
        
        switch ( this.value ) {
            case "IN":
                r = "Invoice";
                break;
            default:
                r = "Undefined";
                break;
        }
        
        return r;
    }
}
