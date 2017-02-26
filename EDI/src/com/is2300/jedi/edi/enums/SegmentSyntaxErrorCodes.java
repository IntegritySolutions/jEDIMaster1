/* {FASegmentSyntaxErrorCodes.java}
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
 * Functional Acknowledgment (997) Segment Syntax Error Codes. These codes are 
 * used to relay discovered syntactical errors back to the originator of an EDI 
 * transaction set file. Each of the segments have specific syntax that must be
 * adhered to, or the data will not be correct.
 * <p>
 * These codes are, mostly, used within the Data Segment Note (AK3) segment and
 * by the Segment Syntax Error Code (AK304) field (Data Element 720).
 * <p>
 * The error codes and their meanings are as follows:
 * <table summary="Segment Syntax Error Codes">
 *  <tr>
 *      <th>Code</th>
 *      <th>Description</th>
 *  </tr>
 *  <tr>
 *      <td>1</td>
 *      <td>Unrecognized segment ID</td>
 *  </tr>
 *  <tr>
 *      <td>2</td>
 *      <td>Unexpected segment</td>
 *  </tr>
 *  <tr>
 *      <td>3</td>
 *      <td>Mandatory segment missing</td>
 *  </tr>
 *  <tr>
 *      <td>4</td>
 *      <td>Loop occurs over maximum times</td>
 *  </tr>
 *  <tr>
 *      <td>5</td>
 *      <td>Segment exceeds maximum use</td>
 *  </tr>
 *  <tr>
 *      <td>6</td>
 *      <td>Segment not in defined transaction set</td>
 *  </tr>
 *  <tr>
 *      <td>7</td>
 *      <td>Segment not in proper sequence</td>
 *  </tr>
 * </table>
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum SegmentSyntaxErrorCodes {
    UNRECOGNIZE_SEGMENT_ID(1),
    UNEXPECTED_SEGMENT(2),
    MANDATORY_SEGMENT_MISSING(3),
    LOOP_OCCURS_OVER_MAX_TIMES(4),
    SEGMENT_EXCEEDS_MAX_USE(5),
    SEGMENT_NOT_DEFINED(6),
    SEGMENT_NOT_IN_SEQUENCE(7);
    
    private int value;
    
    private SegmentSyntaxErrorCodes(int value) {
        this.value = value;
    }
    
    /**
     * Converts the <tt>
     * <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html">
     * java.lang.Enum</a></tt> value to an <tt>int</tt> value.
     * @return converted value to <tt>int</tt>
     */
    public int toInteger() {
        return value;
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
            case(1):
                retVal = "Unrecognized Segment ID";
                break;
            case(2):
                retVal = "Unexpected Segment";
                break;
            case(3):
                retVal = "Mandatory Segment Missing";
                break;
            case(4):
                retVal = "Loop Occurs Over Maximum Times";
                break;
            case(5):
                retVal = "Segment Exceed Maximum Usage";
                break;
            case(6):
                retVal = "Segment Not in Defined Transaction Set";
                break;
            case(7):
                retVal = "Segment Not in Proper Sequence";
                break;
            default:
                retVal = "Undefined Enumeration";
                break;
        }   // End switch case block.
        
        // Return our string.
        return retVal;
    }
}
