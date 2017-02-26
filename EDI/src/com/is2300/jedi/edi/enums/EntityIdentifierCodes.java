/* {EntityIdentifierCodes.java}
 * This enumeration provides access to all of the possible entity identifier
 * codes that may be used in an EDI transmission document. This enumeration will
 * need to be updated as new entity identifier codes are discovered.
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
 * Code identifying an organizational entity, a physical location, property, or
 * an individual.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum EntityIdentifierCodes {
    /**
     * Party to be billed for other than the freight (Bill To).
     */
    BILL_TO("BT"),
    /**
     * Buying party (Purchaser).
     */
    BUYING_PARTY("BY"),
    /**
     * Identifies the carrier commissioned for the shipment.
     */
    CARRIER("CA"),
    /**
     * Suppliers should use "II" if the Issuer of Invoice is different from 
     * their corporate office. Either "II" or "SU" must be used. They can both
     * be used.
     */
    INVOICE_ISSUER("II"),
    /**
     * Party to receive payment on the Invoice.
     */
    PAYEE("PE"),
    /**
     * Party to receive all correspondence in conjuction with this invoice.
     */
    CORRESPONDENCE_PARTY("PJ"),
    /**
     * Party to receive the Advanced Ship Notice (ASN) for this invoice.
     */
    ASN_PARTY("PN"),
    /**
     * Party to receive the Invoice.
     */
    RECEIVER("RE"),
    /**
     * Party to whom payment should be remitted, if Issuer of Invoice is 
     * different than the corporate office.
     */
    REMIT_TO("RI"),
    /**
     * Party which sold the goods covered by the Invoice.
     */
    SELLING_PARTY("SE"),
    /**
     * Location from which the items were shipped.
     */
    SHIP_FROM("SF"),
    /**
     * Shipper
     */
    SHIPPER("SH"),
    /**
     * Party to whom the goods were sold.
     */
    SOLD_TO("SO"),
    /**
     * Location to which the items are to be shipped.
     */
    SHIP_TO("ST"),
    /**
     * The supplier of the goods sold.
     */
    SUPPLIER("SU"),
    /**
     * The vendor of the goods sold.
     */
    VENDOR("VN");
    
    /**
     * Member field which contains the value of the <tt>java.lang.Enum</tt>
     */
    private String value;
    /**
     * Member field which contains the definition for the current value.
     */
    private String definition;
    
    /**
     * Private constructor for setting up this enumeration.
     * @param val 
     */
    private EntityIdentifierCodes(String val) {
        this.value = val;
        
        this.setup();
    }
    
    /**
     * Returns the current enumeration value as a <tt>java.lang.String</tt>.
     * 
     * @return java.lang.String representation of the current value
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Returns the definition of the current enumeration value.
     * 
     * @return java.lang.String definition of the current value
     */
    public String getDefinition() {
        return this.definition;
    }
    
    /**
     * Private method for setting up the current value and definition for this
     * enumeration.
     */
    public void setup() {
        switch (this.value) {
            case "BY":
                this.definition = "Buying Party";
                break;
            case "BT":
                this.definition = "Bill To";
                break;
            case "CA":
                this.definition = "Carrier";
                break;
            case "II":
                this.definition = "Issuer of Invoice";
                break;
            case "PE":
                this.definition = "Payee";
                break;
            case "PJ":
                this.definition = "Party to Receive Correspondence";
                break;
            case "PN":
                this.definition = "Party to Receive Shipping Notice";
                break;
            case "RE":
                this.definition = "Party to receive commercial invoice remittance";
                break;
            case "RI":
                this.definition = "Remit To";
                break;
            case "SF":
                this.definition = "Ship From";
                break;
            case "SH":
                this.definition = "Shipper";
                break;
            case "SO":
                this.definition = "Sold To if Different from Bill To";
                break;
            case "ST":
                this.definition = "Ship To";
                break;
            case "SE":
                this.definition = "Selling Party";
                break;
            case "SU":
                this.definition = "Supplier";
                break;
            case "VN":
                this.definition = "Vendor";
                break;
            default:
                this.definition = "Undefined Entity Identifier Code";
                break;
        }
    }
}
