/* {FATransactionSetSyntaxErrorCodes.java}
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
 * Functional Acknowledgment (997) Transaction Set Syntax Error Codes. These 
 * codes are used to relay discovered syntactical errors back to the originator 
 * of an EDI  transaction set file. Each of the segments have specific syntax 
 * that must be adhered to, or the data will not be correct.
 * <p>
 * These codes are, mostly, used within the Transaction Set Response Trailer
 * (AK5) segment and by the Transaction Set Syntax Error Code (AK502) field 
 * (Data Element 718).
 * <p>
 * The error codes and their meanings are as follows:
 * <table summary="Segment Syntax Error Codes">
 *  <tr>
 *      <th>Code</th>
 *      <th>Description</th>
 *  </tr>
 *  <tr>
 *      <td>1 &nbsp; </td>
 *      <td>Transaction Set Not Supported</td>
 *  </tr>
 *  <tr>
 *      <td>2 &nbsp; </td>
 *      <td>Transaction Set Trailer Missing</td>
 *  </tr>
 *  <tr>
 *      <td>3 &nbsp; </td>
 *      <td>Transaction Set Control Number in Header and Trailer Do Not 
 *          Match</td>
 *  </tr>
 *  <tr>
 *      <td>4 &nbsp; </td>
 *      <td>Number of Included Segments Does Not Match Actual Count</td>
 *  </tr>
 *  <tr>
 *      <td>5 &nbsp; </td>
 *      <td>One or More Segments in Error</td>
 *  </tr>
 *  <tr>
 *      <td>6 &nbsp; </td>
 *      <td>Missing or Invalid Transaction Set Identifier</td>
 *  </tr>
 *  <tr>
 *      <td>7 &nbsp; </td>
 *      <td>Missing or Invalid Transaction Set Control Number</td>
 *  </tr>
 *  <tr>
 *      <td>8 &nbsp; </td>
 *      <td>Authentication Key Name Unknown</td>
 *  </tr>
 *  <tr>
 *      <td>9 &nbsp; </td>
 *      <td>Encryption key Name Unknown</td>
 *  </tr>
 *  <tr>
 *      <td>10 &nbsp; </td>
 *      <td>Requested Service (Authentication or Encryption) Not 
 *          Available</td>
 *  </tr>
 *  <tr>
 *      <td>11 &nbsp; </td>
 *      <td>Unknown Security Recipient</td>
 *  </tr>
 *  <tr>
 *      <td>12 &nbsp; </td>
 *      <td>Incorrect Message Length (Encryption Only)</td>
 *  </tr>
 *   <tr>
 *       <td>13</td>
 *       <td>Message Authentication Code Failed</td>
 *   </tr>
 *   <tr>
 *       <td>15</td>
 *       <td>Unknown Security Originator</td>
 *   </tr>
 *   <tr>
 *       <td>16</td>
 *       <td>Syntax Error in Decrypted Text</td>
 *   </tr>
 *   <tr>
 *       <td>17</td>
 *       <td>Security Not Supported</td>
 *   </tr>
 *   <tr>
 *       <td>19</td>
 *       <td>S1E Security End Segment Missing for S1S Security
 *           Start Segment</td>
 *   </tr>
 *   <tr>
 *       <td>20</td>
 *       <td>S1S Security Start Segment Missing for S1E Security End
 *           Segment</td>
 *   </tr>
 *    <tr>
 *       <td>21</td>
 *       <td>S2E Security End Segment Missing for S2S Security Start
 *           Segment</td>
 *   </tr>
 *   <tr>
 *       <td>22</td>
 *       <td>S2S Security Start Segment Missing for S2E Security End
 *           Segment</td>
 *   </tr>
 * </table>
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum TSSyntaxErrorCodes {
    NOT_SUPPORTED(1),
    TRAILER_MISSING(2),
    UNMATCHED_CONTROL_NUMBERS(3),
    SEGMENT_COUNT_MISMATCH(4),
    SEGMENTS_IN_ERROR(5),
    MISSING_OR_INVALID_IDENTIFIER(6),
    MISSING_OR_INVALIC_CONTROL_NUMBER(7),
    AUTH_KEY_UNKNOWN(8),
    ENC_KEY_UNKNOWN(9),
    SERVICE_NOT_AVAILABLE(10),
    UNKNOWN_SECURITY_RECIPIENT(11),
    INCORRECT_MSG_LENGTH(12),
    MSG_AUTH_CODE_FAILED(13),
    UNKNOWN_SECURITY_ORIGINATOR(15),
    DECRYPTED_TEXT_SYNTAX_ERROR(16),
    SECURITY_NOT_USUPPORTED(17),
    S1E_MISSING_FOR_S1S(19),
    S1S_MISSING_FOR_S1E(20),
    S2E_MISSING_FOR_S2S(21),
    S2S_MISSING_FOR_S2E(22);
    
    private int value;
    
    private TSSyntaxErrorCodes(int val) {
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
        
        switch (this.value) {
            case (1):
                retVal = "Transaction Set Not Supported";
                break;
            case (2):
                retVal = "Transaction Set Trailer Missing";
                break;
            case (3):
                retVal = "Transaction Set Control Number in Header and Trailer"
                        + " Do Not Match";
                break;
            case (4):
                retVal = "Number of Included Segments Does Not Match Actual "
                        + "Count";
                break;
            case (5):
                retVal = "One or More Segments in Error";
                break;
            case (6):
                retVal = "Missing or Invalid Transaction Set Identifier";
                break;
            case (7):
                retVal = "Missing or Invalid Transaction Set Control Number";
                break;
            case (8):
                retVal = "Authentication Key Name Unknown";
                break;
            case (9):
                retVal = "Encryption Key Name Unknown";
                break;
            case (10):
                retVal = "Requested Service (Authentication or Encryption) Not "
                        + "Available";
                break;
            case (11):
                retVal = "Unknown Security Recipient";
                break;
            case (12):
                retVal = "Incorrect Message Length (Encryption Only)";
                break;
            case (13):
                retVal = "Message Authentication Code Failed";
                break;
            case (15):
                retVal = "Unknown Security Originator";
                break;
            case (16):
                retVal = "Syntax Error in Decrypted Text";
                break;
            case (17):
                retVal = "Security Not Supported";
                break;
            case (19):
                retVal = "S1E Security End Segment Missing for S1S Security "
                        + "Start Segment";
                break;
            case (20):
                retVal = "S1S Security Start Segment Missing for S1E Security "
                        + "End Segment";
                break;
            case (21): 
                retVal = "S2E Security End Segment Missing for S2S Security "
                        + "Start Segment";
                break;
            case (22):
                retVal = "S2S Security Start Segment Missing for S2E Security "
                        + "End Segment";
                break;
            default:
                retVal = "Unknown Enumeration Value";
                break;
        }
        
        return retVal;
    }
}
