/* {FGAcknowledgmentCodes.java}
 * This enumeration provides the valid acknowledgment codes for the Functional
 * Groups in a Functional Acknowledgment (997) EDI document.
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
package com.is2300.jedi.edi.enums;

/**
 * This <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
 * enum</a>eration provides the valid acknowledgment codes for the Functional
 * Groups in a Functional Acknowledgment (997) EDI document.
 * <p>
 * <strong><em>Functional Group Acknowledgment Codes</em></strong>
 * <table summary="Functional Group Acknowledgment Codes">
 *  <tr>
 *      <th>Code</th>
 *      <th>Description</th>
 *  </tr>
 *  <tr>
 *      <td>A</td>
 *      <td>Accepted</td>
 *  <tr>
 *      <td>E</td>
 *      <td>Accepted, But Errors Were Noted</td>
 *  </tr>
 *  <tr>
 *      <td>P</td>
 *      <td>Partially Accepted, At Least One Transaction Set Was Rejected</td>
 *  </tr>
 *  <tr>
 *      <td>R</td>
 *      <td>Rejected</td>
 *  </tr>
 * </table>
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum FGAcknowledgmentCodes {
    ACCEPTED('A'),
    ACCEPTED_WITH_ERRORS('E'),
    PARTIALLY_ACCEPTED('P'),
    REJECTED('R');
    
    private char value;
    
    private FGAcknowledgmentCodes ( char val ) {
        this.value = val;
    }
    
    /**
     * Converts the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> value to an <tt>char</tt> value.
     * @return converted value to <tt>char</tt>
     */
    public char toChar() {
        return this.value;
    }
    /**
     * Retrieves the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> representation of this <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> object.
     * @return <tt>String</tt> representation of this <tt>Enum</tt> value
     */
    
    @Override
    public String toString() {
        String retVal = "";
        
        switch ( this.value ) {
            case ('A'):
                retVal = "Accepted";
                break;
            case ('E'):
                retVal = "Accepted with Errors";
                break;
            case ('P'):
                retVal = "Partially Accepted, at least one Transaction Set "
                        + "Rejected";
                break;
            case ('R'):
                retVal = "Rejected";
                break;
            default:
                retVal = "Undefined Value";
                break;
        }
        
        return retVal;
    }
}
