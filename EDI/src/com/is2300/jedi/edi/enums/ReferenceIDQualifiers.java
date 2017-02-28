/* {ReferenceIDQualifiers.java}
 * This enumeration provides access to all of the possible identification code
 * qualifiers that describe the identification code being used within an EDI
 * transmission document. This enumeration will need to be updated as new
 * identification code qualifiers are discovered.
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
 * Codes that qualify the Reference Identification (Data Element 127).
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum ReferenceIDQualifiers {
    /**
     * <strong>Billing Account</strong>
     * <p>
     * Account number under which billing is rendered.
     */
    BILLING_ACCOUNT("12"),
    /**
     * <strong>Provincial Tax Identification</strong>
     */
    PROVINCIAL_TAX_ID("4G"),
    /**
     * <strong>Agreement Number</strong>
     * <p>
     * If a Master Agreement is to be cited on the Invoice order detail section,
     * then the agreement number goes in <tt>REF02</tt>, and <tt>REF03</tt> is
     * unused. This is used in conjunction with <tt>DTM</tt> @1/140, with
     * <tt>DTM01-"LEA"</tt>.
     */
    AGREEMENT_NUMBER("AH"),
    /**
     * <strong>Accounts Receivable Number</strong>
     * <p>
     * Supplier-assigned customer ID.
     */
    ACCOUNTS_RECEIVABLE_ID("AP"),
    /**
     * <strong>State Tax Identification Number</strong>
     */
    STATE_TAX_ID("BAD"),
    /**
     * <strong>Carrier's Reference Number</strong>
     * <p>
     * This may be the Invoice Number or a carrier assigned PRO Number.
     */
    CARRIERS_REFERENCE_NUMBER("CN"),
    /**
     * <strong>Goods and Service Tax Registration Number</strong>
     */
    GOODS_SVC_TAX_NUMBER("GT"),
    /**
     * <strong>Internal Order Number</strong>
     * <p>
     * Example: <tt>REF*IL*1234567@</tt>
     * <p>
     * Used only for internal identification of a purchase order. Trading
     * Partners should only return <tt>REF*IL</tt> if it is present in the 850.
     * Otherwise do not map it.
     * <p>
     * If used, <tt>REF02</tt> contains a numeric purchase order identifier
     * assigned in-house. <tt>REF03</tt> is ignored.
     * <p>
     * This information is not visible to the Trading Partners, and is reserved
     * only for internal EDI processing.
     */
    INTERNAL_ORDER_NUMBER("IL"),
    /**
     * <strong>Seller's Invoice Number</strong>
     * <p>
     * If Trading Partner needs to specify an invoice number longer than 22
     * characters, <tt>REF*IV</tt> can be used to convey up to 30 characters in
     * <tt>REF02</tt>. If present, <tt>REF02</tt> takes priority over the 
     * invoice number found in <tt>BIG02</tt>. <tt>REF03</tt> is ignored.
     * <p>
     * This can be used in combination with <tt>DTM</tt> @1/140, where
     * <tt>DTM01="003"</tt>, to provide the full date, time, and zone for the
     * invoice time.
     */
    SELLERS_INVOICE_NUMBER("IV"),
    /**
     * <strong>Ship Notice/Manifest Number</strong>
     * <p>
     * Shipment ID of an earlier Advance Ship Notice (ASN). This would be
     * <tt>BSN02</tt> (Data Element 0396) "Shipment Identifier" from an 856
     * previously sent.
     * <p>
     * If you are using this, then it is recommended to include a <tt>DTM</tt>
     * @1/140, with <tt>DTM01="111"</tt> Manifest/Ship Notice Date which would
     * match its counterpart in <tt>BSN03</tt> (date) and <tt>BSN04</tt> (time)
     * from the 856.
     * <p>
     * Example:
     * <p>
     * (1/050) <tt>REF*MA*843-2187-5193@</tt><br>
     * (1/140) <tt>DTM*111*20010903*121844@</tt>
     * <p>
     * produces:
     * <p>
     * <table border="0">
     * <tr><td align="right">Shipment ID: 843-2187-5193<br>
     *                       Notice Date: 2001-09-03 12:18:44</td></tr>
     * </table>
     */
    SN_MANI_NUMBER("MA"),
    /**
     * <strong>Purchase Order Number</strong>
     * <p>
     * Provided to support order numbers longer than 22 characters. There have 
     * been cases where Trading Partners have sent purchase orders where the
     * order number was longer than 22 characters and thus had problems in EDI
     * order routing.
     * <p>
     * To address the above stated problem, the 850 document will implement
     * <tt>REF*PO</tt> to represent order numbers up to 30 characters.
     * <p>
     * If <tt>REF*PO</tt> is present, the <tt>REF02</tt> overrides the order
     * number found in <tt>BIG04</tt>. <tt>REF03</tt> is ignored.
     * <p>
     * This can be used in combination with <tt>DTM</tt> @1/140, where
     * <tt>DTM01="004"</tt>.
     */
    PO_NUMBER("PO"),
    /**
     * <strong>Payee's Financial Institution Account Number</strong>
     * <p>
     * Account number for check, draft or wire payments for the payee; Receiving
     * company account number for ACH transfer.
     */
    PAYEE_ACCT_NUMBER("PY"),
    /**
     * <strong>Payee's Financial Institution Routing Number</strong>
     * <p>
     * Routing number for check, draft or wire payments for the payee; Receiving
     * depository financial institution transit routing number for ACH transfers.
     */
    PAYEE_ROUTING_NUMBER("RT"),
    /**
     * <strong>Federal Taxpayer's Identification Number</strong>
     */
    FEDERAL_TAX_ID("TJ"),
    /**
     * <strong>Tax Exempt Number</strong>
     * <p>
     * Identification number for tax-exempt, not-for-profit companies.
     */
    TAX_EXEMPT_NUMBER("TX"),
    /**
     * <strong>Vender Order Number</strong>
     * <p>
     * This is the supplier's order number. Compare to <tt>BAK08</tt> in the 
     * 855. <tt>REF03</tt> is unused.
     */
    SUPPLIER_ON("VN"),
    /**
     * <strong>Value-Added Tax Registration Number</stron>
     * <p>
     * This value is only valid for European countries.
     */
    VAT_REGISTRATION_ID("VX"),
    /**
     * <strong>Mutually Defined</strong>
     * <p>
     * Text extrinsics with a supplier-defined name in <tt>REF02</tt> and data
     * in <tt>REF03</tt>. Note that this data cannot be electronically processed,
     * unless your customer is programatically aware of the name used in
     * <tt>REF02</tt>.
     * <p>
     * Both <tt>REF02</tt> and <tt>REF03</tt> are <em>required</em>.
     * <p>
     * Example:
     * <p>
     * <tt>REF*ZZ*Employee ID*ABC1235@</tt>
     * <p>
     * will place "Employee ID" and the ID number in the Invoice notes.
     */
    MUTUALLY_DEFINED("ZZ");
    
    /**
     * Member field to hold the value of this enumeration.
     */
    private String value;
    /**
     * Member field to hold the plain English definition of the value of this
     * enumeration.
     */
    private String definition;
    
    /**
     * Private constructor to initialize this enumeration's value and definition.
     * @param value 
     */
    private ReferenceIDQualifiers(String value) {
        this.value = value;
        this.setup();
    }
    
    /**
     * Private method to initialize this enumeration's definition based upon the
     * value.
     */
    private void setup() {
        switch ( this.value) {
            case "AH":
                this.definition = "Agreement Number";
                break;
            case "IL":
                this.definition = "Internal Order Number";
                break;
            case "IV":
                this.definition = "Seller's Invoice Number";
                break;
            case "MA":
                this.definition = "Ship Notice / Manifest Number";
                break;
            case "PO":
                this.definition = "Purchase Order Number";
                break;
            case "VN":
                this.definition = "Vender Order Number";
                break;
            case "ZZ":
                this.definition = "Mutually Defined";
                break;
            case "12":
                this.definition = "Billing Account";
                break;
            case "4G":
                this.definition = "Provincial Tax Identification";
                break;
            case "AP":
                this.definition = "Accounts Receivable Number";
                break;
            case "BAD":
                this.definition = "State Tax Identification Number";
                break;
            case "CN":
                this.definition = "Carrier's Reference Number (PRO/Invoice)";
                break;
            case "GT":
                this.definition = "Goods and Service Tax Registration Number";
                break;
            case "PY":
                this.definition = "Payee's Financial Institution Account Number"
                        + "Company for Check, Draft or Wire Payments; Receiving"
                        + " Account Number for ACH Transfer";
                break;
            case "RT":
                this.definition = "Payee's Financial Institution Transit Rout"
                        + "ing Number for Check, Draft or Wire Payments. "
                        + "Receiving Depository Financial Institution Transit "
                        + "Routing Number for ACH Transfers.";
                break;
            case "TJ":
                this.definition = "Federal Taxpayer's Identification Number";
                break;
            case "TX":
                this.definition = "Tax Exempt Number";
                break;
            case "VX":
                this.definition = "Value-Added Tax Registration Number (Europe)";
                break;
            default:
                this.definition = "Undefined Qualifier";
                break;
        }
    }
    
    /**
     * Function to return this enumeration's value as a <tt>java.lang.String
     * </tt> object.
     * 
     * @return java.lang.String representation of this enumeration's value
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Function to get the definition of this enumeration's value.
     * 
     * @return java.lang.String definition of the current value
     */
    public String getDefinition() {
        return this.definition;
    }
}
