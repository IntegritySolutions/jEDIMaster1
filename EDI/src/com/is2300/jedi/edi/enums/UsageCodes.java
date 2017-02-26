/* {UsageCodes.java}
 * This enumeration provides access to the Usage Codes for indicating test or
 * production data in an EDI transmission.
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
 * Code to indicate whether data enclosed by this interchange envelope is test 
 * or production.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum UsageCodes {
    /**
     * The EDI transmission contains production data.
     */
    PRODUCTION('P'),
    /**
     * The EDI transmission contains test data.
     */
    TEST('T');
    
    /**
     * Private field to hold the character that determines what type of data is
     * in the EDI transmission.
     */
    private char value;
    
    /**
     * Private constructor to establish the transmission data type value.
     */
    private UsageCodes(char val) {
        this.value = val;
    }
    
    /**
     * Returns the complete <tt>java.lang.String</tt> value of whether the EDI
     * transmission contains <em>Production</em> or <em>Test</em> data.
     * 
     * @return java.lang.String long form of the code.
     */
    @Override
    public String toString() {
        // Return the appropriate String value based on the setting of value.
        if ( this.value == 'P' ) {
            return "Production Data";
        } else if ( this.value == 'T' ) {
            return "TestData";
        }
        
        // If neither of the branches of the if...else if block were entered,
        //+ return null.
        return null;
    }
}
