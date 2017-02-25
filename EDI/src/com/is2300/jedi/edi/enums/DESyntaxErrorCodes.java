/* {FADataElementSyntaxErrorCodes.java}
 * This Enumeration maintains the syntax error codes for the Functional Ack-
 * nowledgment (997) document type. These errors codes are used in sending
 * Functional Acknowledgements back to originators of documents when there is
 * a syntactical error within the transaction set segments that were sent.
 *
 * Furthermore, these error codes are used within the Data Segment Note (AK3)
 * segment class and referenced by the Segment Syntax Error Code (AK304) field.
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
 * Functional Acknowledgment (997) Data Element Syntax Error Codes. These codes 
 * are used to relay discovered syntactical errors back to the originator of an 
 * EDI transaction set file. Each of the segments have specific syntax that must 
 * be adhered to, or the data will not be correct.
 * <p>
 * These codes are, mostly, used within the Data Element Note (AK4) segment and
 * by the Element Syntax Error Code (AK403) field (Data Element 723).
 * <p>
 * The error codes and their meanings are as follows:
 * <table summary="Segment Syntax Error Codes">
 *  <tr>
 *      <th>Code</th>
 *      <th>Description</th>
 *  </tr>
 *  <tr>
 *      <td>1 &nbsp; </td>
 *      <td>Mandatory Data Element Missing</td>
 *  </tr>
 *  <tr>
 *      <td>2 &nbsp; </td>
 *      <td>Conditional Required Data Element Missing</td>
 *  </tr>
 *  <tr>
 *      <td>3 &nbsp; </td>
 *      <td>Too Many Data Elements</td>
 *  </tr>
 *  <tr>
 *      <td>4 &nbsp; </td>
 *      <td>Data Element Too Short</td>
 *  </tr>
 *  <tr>
 *      <td>5 &nbsp; </td>
 *      <td>Data Element Too Long</td>
 *  </tr>
 *  <tr>
 *      <td>6 &nbsp; </td>
 *      <td>Invalid Character in Data Element</td>
 *  </tr>
 *  <tr>
 *      <td>7 &nbsp; </td>
 *      <td>Invalid Code Value</td>
 *  </tr>
 *  <tr>
 *      <td>8 &nbsp; </td>
 *      <td>Invalid Date</td>
 *  </tr>
 *  <tr>
 *      <td>9 &nbsp; </td>
 *      <td>Invalid Time</td>
 *  </tr>
 *  <tr>
 *      <td>10 &nbsp; </td>
 *      <td>Exclusion Condition Violated</td>
 *  </tr>
 * </table>
 *
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum DESyntaxErrorCodes {
    MANDATORY_ELEMENT_MISSING(1),
    CONDITION_REQD_ELEMENT_MISSION(2),
    TOO_MANY_ELEMENTS(3),
    ELEMENT_TOO_SHORT(4),
    ELEMENT_TOO_LONG(5),
    INVALID_CHARACTER(6),
    INVALID_CODE(7),
    INVALID_DATE(8),
    INVALID_TIME(9),
    EXCLUSION_VIOLATED(10);
    
    private int value;
    
    private DESyntaxErrorCodes(int val) {
        this.value = val;
    }
    
    /**
     * Converts the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> value to an <tt>int</tt> value.
     * @return converted value to <tt>int</tt>
     */
    public int toInteger() {
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
        String retVal = null;
        
        switch (this.value) {
            case (1):
                retVal = "Mandatory data element missing";
                break;
            case (2):
                retVal = "Conditional required data element missing";
                break;
            case (3):
                retVal = "Too many data elements";
                break;
            case (4):
                retVal = "Data element too short";
                break;
            case (5):
                retVal = "Data element too long";
                break;
            case (6):
                retVal = "Invalid character in data element";
                break;
            case (7):
                retVal = "Invalid code value";
                break;
            case (8):
                retVal = "Invalid Date";
                break;
            case (9):
                retVal = "Invalid Time";
                break;
            case (10):
                retVal = "Exclusion Condition Violated";
                break;
            default:
                retVal = "UNDEFINED ERROR CODE";
                break;
        }
        
        return retVal;
    }
}
