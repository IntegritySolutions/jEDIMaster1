/* {TransactionTypeCodes.java}
 * This enumeration provides access to all of the possible transaction type 
 * codes for the various transactions in EDI transmissions. This enumeration 
 * will need to be updated as new transaction type codes are discovered.
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
 * An enumeration of the various Transaction Type Codes that may be found in an
 * EDI transmission document.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum TransactionTypeCodes {
    CREDIT_MEMO("CR"),
    DEBIT_INVOICE("DI"),
    DEBIT_MEMO("DR");
    
    private String value;
    
    private TransactionTypeCodes(String val) {
        this.value = val;
    }
    
    /**
     * Gets the definition of the <tt>TransactionTypeCodes</tt> value.
     * 
     * @return <tt>java.lang.String</tt> definition
     */
    @Override
    public String toString() {
        String retVal = null;
        
        switch (this.value) {
            case "CR":
                retVal = "Credit Memo";
                break;
            case "DI":
                retVal = "Debit Invoice";
                break;
            case "DR":
                retVal = "Debit Memo";
                break;
            default:
                retVal = "Undefined Transaction Type Code";
                break;
        }
        
        return retVal;
    }
}
