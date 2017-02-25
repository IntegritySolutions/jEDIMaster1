/* {FAFunctionalGroupSyntaxErrorCodes.java}
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
 * Functional Acknowledgment (997) Functional Group Segment Syntax Error Codes. 
 * These codes are used to relay discovered syntactical errors back to the 
 * originator of an EDI transaction set file. Each of the segments have specific 
 * syntax that must be adhered to, or the data will not be correct.
 * <p>
 * These codes are, mostly, used within the Functional Group Response Trailer
 * (AK9) segment and, mostly used by the Functional Group Syntax Error Code 
 * (AK905) field (Data Element 716).
 * <p>
 * The error codes and their meanings are as follows:
 * <table summary="sub">
 *    <tr>
 *        <td>1 &nbsp; </td>
 *        <td>Functional Group Not Supported</td>
 *    </tr>
 *    <tr>
 *        <td>2 &nbsp; </td>
 *        <td>Functional Group Version Not Supported</td>
 *    </tr>
 *    <tr>
 *        <td>3 &nbsp; </td>
 *        <td>Functional Group Trailer Missing</td>
 *    </tr>
 *    <tr>
 *        <td>4 &nbsp; </td>
 *        <td>Group Control Number in the Functional Group Header and
 *            Trailer Do Not Agree</td>
 *    </tr>
 *    <tr>
 *        <td>5 &nbsp; </td>
 *        <td>Number of Included Transaction Sets Does Not Match
 *            Actual Count</td>
 *    </tr>
 *    <tr>
 *        <td>6 &nbsp; </td>
 *        <td>Group Control Number Violates Syntax</td>
 *    </tr>
 *    <tr>
 *        <td>10 &nbsp; </td>
 *        <td>Authentication Key Name Unknown</td>
 *    </tr>
 *    <tr>
 *        <td>11 &nbsp; </td>
 *        <td>Encryption Key Name Unknown</td>
 *    </tr>
 *    <tr>
 *        <td>12 &nbsp; </td>
 *        <td>Requested Service (Authentication or Encryption) Not
 *            Available</td>
 *    </tr>
 *    <tr>
 *        <td>13 &nbsp; </td>
 *        <td>Unknown Security Recipient</td>
 *    </tr>
 *    <tr>
 *        <td>14 &nbsp; </td>
 *        <td>Unknown Security Originator</td>
 *    </tr>
 *    <tr>
 *        <td>15 &nbsp; </td>
 *        <td>Syntax Error in Decrypted Text</td>
 *    </tr>
 *    <tr>
 *        <td>16 &nbsp; </td>
 *        <td>Security Not Supported</td>
 *    </tr>
 *    <tr>
 *        <td>17 &nbsp; </td>
 *        <td>Incorrect Message Length (Encryption Only)</td>
 *    </tr>
 *    <tr>
 *        <td>18 &nbsp; </td>
 *        <td>Message Authentication Code Failed</td>
 *    </tr>
 *    <tr>
 *        <td>19 &nbsp; </td>
 *        <td>S1E Security End Segment Missing for S1S Security Start
 *            Segment</td>
 *    </tr>
 *    <tr>
 *        <td>20 &nbsp; </td>
 *        <td>S1S Security Start Segment Missing for S1E Security End Segment
 *        </td>
 *    </tr>
 *    <tr>
 *        <td>21 &nbsp; </td>
 *        <td>S2E Security End Segment Missing for S2S Security Start
 *            Segment</td>
 *    </tr>
 *    <tr>
 *        <td>22 &nbsp; </td>
 *        <td>S2S Security Start Segment Missing for S2E Security End
 *            Segment</td>
 *    </tr>
 * </table>
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum FGSyntaxErrorCodes {
    NOT_SUPPORTED(1),
    VERSION_NOT_SUPPORTED(2),
    TRAILER_MISSING(3),
    UNMATCHED_CONTROL_NUMBER(4),
    UNMATCHED_TRANSACTION_SET_COUNT(5),
    CONTROL_NUMBER_VIOLATES_SYNTAX(6),
    AUTH_KEY_UNKNOWN(10),
    ENC_KEY_UNKNOWN(11),
    SERVICE_NOT_AVAILABLE(12),
    UNKNOWN_SECURITY_RECIPIENT(13),
    UNKNOWN_SECURITY_ORIGINATOR(14),
    DECRYPTED_TEXT_SYNTAX_ERROR(15),
    SECURITY_NOT_SUPPORTED(16),
    INVALID_MSG_LENGTH(17),
    MSG_AUTH_CODE_FAILED(18),
    NO_S1E_FOR_S1S(19),
    NO_S1S_FOR_S1E(20),
    NO_S2E_FOR_S2S(21),
    NO_S2S_FOR_S2E(22);
    
    private int value;
    
    private FGSyntaxErrorCodes(int val) {
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
    public String toString() {
        String retVal = "";
        
        switch ( this.value ) {
            case (1):
                retVal = "Functional Group Not Supported";
                break;
            case (2):
                retVal = "Functional Group Version Not Supported";
                break;
            case (3):
                retVal = "Functional Group Trailer Missing";
                break;
            case (4):
                retVal = "Group Control Number in the Functional Group Header "
                        + "and Trailer Do Not Match";
                break;
            case (5):
                retVal = "Number of Included Transaction Sets Does Not Match "
                        + "Actual Count";
                break;
            case (6):
                retVal = "Group Control Number Violates Syntax";
                break;
            case (10):
                retVal = "Authentication Key Name Unknown";
                break;
            case (11):
                retVal = "Encryption Key Name Unknown";
                break;
            case (12):
                retVal = "Requested Service (Authentication or Encryption) Not "
                        + "Available";
                break;
            case (13):
                retVal = "Unknown Security Recipient";
                break;
            case (14):
                retVal = "Unknown Security Originator";
                break;
            case (15):
                retVal = "Syntax Error in Decrypted Text";
                break;
            case (16):
                retVal = "Security Not Supported";
                break;
            case (17):
                retVal = "Incorrect Message Length (Encryption Only)";
                break;
            case (18):
                retVal = "Message Authentication Code Failed";
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
                retVal = "Unknown Value";
                break;
        }
        
        return retVal;
    }
}
