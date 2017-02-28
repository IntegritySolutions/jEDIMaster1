/* {Validate810Segments.java}
 * 
 * This class has one (1) public method to use to validate EDI document segment
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

package com.is2300.jedi.edi.impl;

import com.is2300.jedi.edi.api.Validator;

/**
 * The EDI Invoice (Document Type 810) is used for sending billing information
 * to trading partners. The data is based off of the original or modified 
 * Purchase Orders (Document Type 850 or 860), which is sent to a trading
 * partner to order products from them. Once the PO or PO Change is processed,
 * the system automates the purchase of raw materials, if necessary, and enters
 * the order into the company's work-flow. Once the products are ready to ship,
 * as determined by shipment scheduling, the Invoice (810) is processed and sent
 * to the ordering trading partner.
 * <p>
 * This <tt>Validator</tt> implementation is used on incoming invoices to verify
 * that all segments are valid. Once the invoice is processed from the EDI
 * transmission, the data is entered into the database and work items are 
 * created for the accounting department to handle the invoice payment(s).
 * <p>
 * The following are the valid segments for an 810 Invoice:
 * <ul>
 * <li><strong>ISA</strong>: Interchange Control Header</li>
 * <li><strong>GS</strong>: Function Group Header</li>
 * <li><strong>ST</strong>: Transaction Set Header</li>
 * <li><strong>BIG</strong>: Beginning Segment for Invoice</li>
 * <li><strong>CUR</strong>: Currency</li>
 * <li><strong>REF</strong>: Reference Identification</li>
 * <li><strong>N1</strong>: Name</li>
 * <li><strong>N2</strong>: Additional Name Information</li>
 * <li><strong>N3</strong>: Address Information</li>
 * <li><strong>N4</strong>: Geographic Location</li>
 * <li><strong>PER</strong>: Administrative Communications Contact</li>
 * <li><strong>ITD</strong>: Terms of Sale/Deferred Terms of Sale</li>
 * <li><strong>DTM</strong>: Date/Time Reference</li>
 * <li><strong>N9</strong>: Reference Identification</li>
 * <li><strong>MSG</strong>: Message Text</li>
 * <li><strong>IT1</strong>: Baseline Item Data (Invoice)</li>
 * <li><strong>PID</strong>: Product/Item Description</li>
 * <li><strong>SAC</strong>: Service, Promotion, Allowance or Charge
 *                           Information</li>
 * <li><strong>TXI</strong>: Tax Information</li>
 * <li><strong>TDS</strong>: Total Monetary Value Summary</li>
 * <li><strong>AMT</strong>: Amount</li>
 * <li><strong>CTT</strong>: Transaction Totals</li>
 * <li><strong>SE</strong>: Transaction Set Trailer</li>
 * <li><strong>GE</strong>: Functional Group Trailer</li>
 * <li><strong>IEA</strong>: Interchange Control Trailer</li>
 * </ul>
 * <p>
 * Some of these segments may be used more than once within an EDI transmission,
 * but some may only be used once in a transmission. This <tt>Validator</tt>
 * only checks that the segment is valid within the 810 Invoice context, but not
 * whether it has been used more times than allowed. This is left up to the 
 * calling program to determine.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class Validate810Segments implements Validator {

    @Override
    public Boolean validate(String toValidate) {
        // Create a return value.
        Boolean isValid = false;    // Default it to invalid segment.
        
        // We need to check the supplied segment to see if it is valid.
        switch ( toValidate ) {
            // Since each case that is valid will set the `isValid` return 
            //+ variable to `true`, we're just going to use the "fall-through"
            //+ of the `case` functionality and only use the `break` statement
            //+ when we set the return variable to `true`.
            case "ISA":
            case "GS":
            case "ST":
            case "BIG":
            case "CUR":
            case "REF":
            case "N1":
            case "N2":
            case "N3":
            case "N4":
            case "PER":
            case "ITD":
            case "DTM":
            case "N9":
            case "MSG":
            case "IT1":
            case "PID":
            case "SAC":
            case "TX1":
            case "TDS":
            case "AMT":
            case "CTT":
            case "SE":
            case "GE":
            case "IEA":
                isValid = true;
                break;
        }
        
        // Return our validation discovery.
        return isValid;
    }

    @Override
    public Boolean validate(String toValidate, String toCompare) {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Unused: Not Implemented"); 
    }

}
