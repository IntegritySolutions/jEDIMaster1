/* {IdentificationCodeQualifiers.java}
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
 * Qualifier to designate the system/method of code structure used to designate 
 * the sender or receiver ID element being qualified.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum IdentificationCodeQualifiers {
    /**
     * Dun & Bradstreet
     */
    DUNS_NUMBER("01"),
    /**
     * Standard Carrier Alpha Code
     */
    SCAC("02"),
    /**
     * Federal Maritime Commission
     */
    FMC("03"),
    /**
     * International Air Transport Association
     */
    IATA("04"),
    /**
     * UCC EDI Communications ID (Comm ID)
     */
    UCC_EDI("08"),
    /**
     * X.121 (CCITT)
     */
    X_121("09"),
    /**
     * Department of Defense (DoD) Activity Address Code
     */
    DOD_ACTIVITY_ADDRESS("10"),
    /**
     * Drug Enforcement Agency
     */
    DEA("11"),
    /**
     * Telephone Companies
     */
    PHONE("12"),
    /**
     * The UCS Code is a Code used for UCS Transmissions; it includes the Area
     * Code and Telephone Number of a Modem; it does not include punctuation,
     * blanks or access codes.
     */
    UCS("13"),
    /**
     * DUNS number plus a suffix.
     */
    DUNS_PLUS_SUFFIX("14"),
    /**
     * Petroleum Accountants Society of Canada Company Code.
     */
    PAS_OF_CAN("15"),
    /**
     * Duns number with 4-character suffix.
     */
    DUNS_FOUR_CHAR_SUFFIX("16"),
    /**
     * American Bankers Association (ABA) Transit Routing Number (Including
     * check digit, 9 digits).
     */
    ABA_ROUTING_NUM("17"),
    /**
     * Association of American Railroads (AAR) standard distribution code.
     */
    AAR_STANDARD("18"),
    /**
     * EDI Council of Australia (EDICA) communications ID number (Comm ID).
     */
    EDICA("19"),
    /**
     * Health Industry Number.
     */
    HIN("20"),
    /**
     * Integrated Postsecondary Education Data System, or (IPEDS).
     */
    IPEDS("21"),
    /**
     * Federal Interagency Commission on Education (FICE).
     */
    FICE("22"),
    /**
     * National Center for Education Statistics Common Core of Data 12-digit
     * number for pre-K through 12th Grade institutes, or NCES.
     */
    NCES("23"),
    /**
     * The College Board's Admission Testing Program 4-digit code of 
     * Postsecondary Institutes (ATP).
     */
    ATP("24"),
    /**
     * American College Testing Program 4-digit code of Postsecondary
     * Institutions or ACT.
     */
    ACT("25"),
    /**
     * Statistics of Canada List of Postsecondary Institutions.
     */
    SCLPI("26"),
    /**
     * Carrier Identification Number as assigned by Health Care Financing 
     * Administration (HCFA).
     */
    HCFA_CARRIER_ID("27"),
    /**
     * Fiscal Intermediary Identification Number as assigned by Health Care 
     * Financing Administration (HCFA).
     */
    HCFA_FISCAL_ID("28"),
    /**
     * Medicare Provider and Supplier Identification Number as assigned by 
     * Health Care Financing Administration (HCFA).
     */
    HCFA_PROVIDER_ID("29"),
    /**
     * U.S. Federal Tax Identification Number
     */
    US_TIN("30"),
    /**
     * Jurisdiction Identification Number plus 4 as assigned by the International
     * Association of Industrial Accident Boards and Commissions (IAIABC).
     */
    IAIABC_JIN("31"),
    /**
     * U.S. Federal Employer Identification Number (FEIN).
     */
    US_FEIN("32"),
    /**
     * National Association of Insurance Commissioners Company Code (NAIC).
     */
    NAIC("33"),
    /**
     * Medicaid Provider and Supplier Identification Number as assigned by the
     * individual State Medicaid Agencies in conjunction with Health Care
     * Financing Administration (HCFA).
     */
    MPSIN_STATE_HCFA("34"),
    /**
     * Statistics Canada Canadian College Student Information System Institution
     * Codes.
     */
    SCCCS("35"),
    /**
     * Statistics Canada University Student Information System Institution Codes.
     */
    SCUSI("36"),
    /**
     * Society of Property Information Compilers and Analysts.
     */
    SPICA("37"),
    /**
     * Association Mexicana del Codigo de Producto (AMECOP) Communication ID.
     */
    AMECOP("AM"),
    /**
     * National Retail Merchants Association (NRMA) - Assigned.
     */
    NRMA("NR"),
    /**
     * Standard Address Number.
     */
    STD_ADDRESS("SN"),
    /**
     * Mutually Defined.
     */
    MUTUALLY_DEFINED("ZZ"),
    /**
     * Assigned by Seller.
     */
    ASSIGNED_BY_SELLER("91"),
    /**
     * Assigned by Buyer.
     */
    ASSIGNED_BY_BUYER("92");
    
    private String value;
    
    private IdentificationCodeQualifiers(String val) {
        this.value = val;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
    
    
    public String getName() {
        String retVal = null;
        
        switch(this.value) {
            case "01":
                retVal = "D-U-N-S Number, Dun & Bradstreet";
                break;
            case "02":
                retVal = "Standard Carrier Alpha Code (SCAC)";
                break;
            case "03":
                retVal = "FMC (Federal Maritime Commission)";
                break;
            case "04":
                retVal = "International Air Transport Association (IATA)";
                break;
            case "08":
                retVal = "UCC EDI Communications ID (Comm ID)";
                break;
            case "09":
                retVal = "X.121 (CCITT)";
                break;
            case "10":
                retVal = "Department of Defense (DoD) Activity Address Code";
                break;
            case "11":
                retVal = "DEA (Drug Enforcement Agency";
                break;
            case "12":
                retVal = "Phone (Telephone Companies)";
                break;
            case "13":
                retVal = "UCS Code (The UCS Code is a code used for UCS Transmi"
                        + "ssions; it includes the Area Code and Telephone Numb"
                        + "er of a Modem; it does not include punctuation, blan"
                        + "ks or access codes)";
                break;
            case "14":
                retVal = "D-U-N-S plus Suffix";
                break;
            case "15":
                retVal = "Petroleum Accountants Society of Canada Company Code";
                break;
            case "16":
                retVal = "D-U-N-S Number with 4-character suffix";
                break;
            case "17":
                retVal = "American Bankers Association (ABA) Transit Routing Nu"
                        + "mber (including check digits, 9 digits)";
                break;
            case "18":
                retVal = "Association of American Railroads (AAR) Standard Dist"
                        + "ribution Code";
                break;
            case "19":
                retVal = "EDI Council of Australia (EDICA) communications ID nu"
                        + "ber (COMM ID)";
                break;
            case "20":
                retVal = "Health Industry Number (HIN)";
                break;
            case "21":
                retVal = "Integrated Postsecondary Education Data System (IPEDS"
                        + ")";
                break;
            case "22":
                retVal = "Federal Interagency Commission on Education (FICE)";
                break;
            case "23":
                retVal = "National Center for Education Statistics Common Core "
                        + "of Data 12-digit Number for PreK-Grade 12 Institues "
                        + "(NCES)";
                break;
            case "24":
                retVal = "The College Board's Admission Testing Program 4-digit"
                        + " code of postsecondary institutes (ATP)";
                break;
            case "25":
                retVal = "American College Testing Program 4-digit code of post"
                        + "secondary institutions (ACT)";
                break;
            case "26":
                retVal = "Statistics of Canada List of Postsecondary Institutio"
                        + "ns";
                break;
            case "27":
                retVal = "Carrier Identification Number as assigned by Health C"
                        + "are Financing Administration (HCFA)";
                break;
            case "28":
                retVal = "Fiscal Intermediary Identification Number as assigned"
                        + " by Health Care Financing Administration (HCFA)";
                break;
            case "29":
                retVal = "Medicare Provider and Supplier Identification Number "
                        + "as assigned by the Health Care Financing Administrat"
                        + "ion (HCFA)";
                break;
            case "30":
                retVal = "U.S. Federal Tax Idnetification Number (FTIN)";
                break;
            case "31":
                retVal = "Jurisdiction Identification Number plus 4 as assigned"
                        + " by the INternational Association of Industrial Acci"
                        + "dent Boards and Commissions (IAIABC)";
                break;
            case "32":
                retVal = "U.S. Federal Employer Identification Number (FEIN)";
                break;
            case "33":
                retVal = "National Association of Insurance Commissioners Compa"
                        + "ny Code (NAIC)";
                break;
            case "34":
                retVal = "Medicaid Provider and Supplier Identification Number "
                        + "as assigned by individual State Medicaid Agencies in"
                        + " conujunction with Health Care Financing Administrat"
                        + "ion (HCFA)";
                break;
            case "35":
                retVal = "Statistics Canada Canadian College Student Informatio"
                        + "n System Institution Codes";
                break;
            case "36":
                retVal = "Statistics Canada University Student Information Syst"
                        + "em Institution Codes";
                break;
            case "37":
                retVal = "Society of Property Information Compilers and Analyst"
                        + "s";
                break;
            case "AM":
                retVal = "Association Mexicana del Codigo de Producto (AMECOP) "
                        + "Communication ID";
                break;
            case "NR":
                retVal = "National Retail Merchants Association (NRMA) - Assign"
                        + "ed";
                break;
            case "SN":
                retVal = "Standard Address Number";
                break;
            case "ZZ":
                retVal = "Mutually Defined";
                break;
            case "91":
                retVal = "Assigned by Seller or Seller's Agent";
                break;
            case "92":
                retVal = "Assigned by Buyer or Buyer's Agent";
                break;
            default:
                retVal = "Undefined Identification Code Qualifier";
                break;
        }
        
        return retVal;
    }
}
