/* {StateOrProvinceCodes.java}
 * This enumeration provides access to all of the valid State or Province codes
 * as assigned by U.S. and Canadian Postal Services. These codes are only 
 * required for U.S. States and Canadian Provinces.
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
 * International Standards Organization (ISO) codes for states and provinces.
 * These codes are only valid when the country identifier is for the United
 * States of America or Canada. If a country identifier is for any other country,
 * these codes are not to be used.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum StateOrProvinceCodes {
    ALBERTA("AB"),
    ALASKA("AK"),
    ALABAMA("AL"),
    ARKANSAS("AR"),
    AMERICAN_SAMOA("AS"),
    ARIZONA("AZ"),
    BRITISH_COLUMBIA("BC"),
    CALIFORNIA("CA"),
    COLORADO("CO"),
    CONNECTICUT("CT"),
    DISTRICT_OF_COLUMBIA("DC"),
    DELAWARE("DE"),
    FLORIDA("FL"),
    FEDERATED_STATES_OF_MICRONESIA("FM"),
    GEORGIA("GA"),
    GUAM("GU"),
    HAWAII("HI"),
    IOWA("IA"),
    IDAHO("ID"),
    ILLINOIS("IL"),
    INDIANA("IN"),
    KANSAS("KS"),
    KENTUCKY("KY"),
    LOUISIANA("LA"),
    MASSACHUSETTS("MA"),
    MANITOBA("MB"),
    MARYLAND("MD"),
    MAINE("ME"),
    MARSHALL_ISLANDS("MH"),
    MICHIGAN("MI"),
    MINNESOTA("MN"),
    MISSOURI("MO"),
    NORTHERN_MARIANNA_ISLANDS("MP"),
    MISSISSIPPI("MS"),
    MONTANA("MT"),
    NEW_BRUNSWICK("NB"),
    NORTH_CAROLINA("NC"),
    NORTH_DAKOTA("ND"),
    NEBRASKA("NE"),
    NEWFOUNDLAND("NF"),
    NEW_HAMPSHIRE("NH"),
    NEW_JERSEY("NJ"),
    NEW_MEXICO("NM"),
    NOVA_SCOTIA("NS"),
    NORTHWEST_TERRITORIES("NT"),
    NUNAVUT("NU"),
    NEVADA("NV"),
    NEW_YORK("NY"),
    OHIO("OH"),
    OKLAHOMA("OK"),
    ONTARIO("ON"),
    OREGON("OR"),
    PENNSYLVANIA("PA"),
    PRINCE_EDWARD_ISLAND("PE"),
    PUERTO_RICO("PR"),
    PALAU("PW"),
    QUEBEC("QC"),
    RHODE_ISLAND("RI"),
    SOUTH_CAROLINA("SC"),
    SOUTH_DAKOTA("SD"),
    SASKATCHEWAN("SK"),
    TENNESSEE("TN"),
    TEXAS("TX"),
    UTAH("UT"),
    VIRGINIA("VA"),
    VIRGIN_ISLANDS("VI"),
    VERMONT("VT"),
    WASHINGTON("WA"),
    WISCONSIN("WI"),
    WEST_VIRGINIA("WV"),
    WYOMING("WY"),
    YUKON("YT");
    
    private String value;
    
    private StateOrProvinceCodes(String val) {
        this.value = val;
    }
    
    
    @Override
    public String toString() {
        String retVal = null;
        
        switch(this.value) {
            case "AB":
                retVal = "Alberta";
                break;
            case "AK":
                retVal = "Alaska";
                break;
            case "AL":
                retVal = "Alabama";
                break;
            case "AR":
                retVal = "Arkansas";
                break;
            case "AS":
                retVal = "American Samoa";
                break;
            case "AZ":
                retVal = "Arizona";
                break;
            case "BC":
                retVal = "British Columbia";
                break;
            case "CA":
                retVal = "California";
                break;
            case "CO":
                retVal = "Colorado";
                break;
            case "CT":
                retVal = "Connecticut";
                break;
            case "DC":
                retVal = "District of Columbia";
                break;
            case "DE":
                retVal = "Delaware";
                break;
            case "FL":
                retVal = "Florida";
                break;
            case "FM":
                retVal = "Federated States of Micronesia";
                break;
            case "GA":
                retVal = "Georgia";
                break;
            case "GU":
                retVal = "Guam";
                break;
            case "HI":
                retVal = "Hawaii";
                break;
            case "IA":
                retVal = "Iowa";
                break;
            case "ID":
                retVal = "Idaho";
                break;
            case "IL":
                retVal = "Illinois";
                break;
            case "IN":
                retVal = "Indiana";
                break;
            case "KS":
                retVal = "Kansas";
                break;
            case "KY":
                retVal = "Kentucky";
                break;
            case "LA":
                retVal = "Louisiana";
                break;
            case "MA":
                retVal = "Massachusetts";
                break;
            case "MB":
                retVal = "Manitoba";
                break;
            case "MD":
                retVal = "Maryland";
                break;
            case "ME":
                retVal = "Maine";
                break;
            case "MH":
                retVal = "Marshall Islands";
                break;
            case "MI":
                retVal = "Michigan";
                break;
            case "MN":
                retVal = "Minnesota";
                break;
            case "MO":
                retVal = "Missouri";
                break;
            case "MP":
                retVal = "Northern Mariana Islands";
                break;
            case "MS":
                retVal = "Mississippi";
                break;
            case "MT":
                retVal = "Montana";
                break;
            case "NB":
                retVal = "New Brunswick";
                break;
            case "NC":
                retVal = "North Carolina";
                break;
            case "ND":
                retVal = "North Dakota";
                break;
            case "NE":
                retVal = "Nebraska";
                break;
            case "NF":
                retVal = "Newfoundland";
                break;
            case "NH":
                retVal = "New Hampshire";
                break;
            case "NJ":
                retVal = "New Jersey";
                break;
            case "NM":
                retVal = "New Mexico";
                break;
            case "NS":
                retVal = "Nova Scotia";
                break;
            case "NT":
                retVal = "Northwest Territories";
                break;
            case "NU":
                retVal = "Nunavut";
                break;
            case "NV":
                retVal = "Nevada";
                break;
            case "NY":
                retVal = "New York";
                break;
            case "OH":
                retVal = "Ohio";
                break;
            case "OK":
                retVal = "Oklahoma";
                break;
            case "ON":
                retVal = "Ontario";
                break;
            case "OR":
                retVal = "Oregon";
                break;
            case "PA":
                retVal = "Pennsylvania";
                break;
            case "PE":
                retVal = "Prince Edward Island";
                break;
            case "PR":
                retVal = "Puerto Rico";
                break;
            case "PW":
                retVal = "Palau";
                break;
            case "QC":
                retVal = "Quebec";
                break;
            case "RI":
                retVal = "Rhode Island";
                break;
            case "SC":
                retVal = "South Carolina";
                break;
            case "SD":
                retVal = "South Dakota";
                break;
            case "SK":
                retVal = "Saskatchewan";
                break;
            case "TN":
                retVal = "Tennessee";
                break;
            case "TX":
                retVal = "Texas";
                break;
            case "UT":
                retVal = "Utah";
                break;
            case "VA":
                retVal = "Virgina";
                break;
            case "VI":
                retVal = "Virgin Islands";
                break;
            case "VT":
                retVal = "Vermont";
                break;
            case "WA":
                retVal = "Washington";
                break;
            case "WI":
                retVal = "Wisconsin";
                break;
            case "WV":
                retVal = "West Virginia";
                break;
            case "WY":
                retVal = "Wyoming";
                break;
            case "YT":
                retVal = "Yukon";
                break;
            default:
                retVal = "Undefined State, Province or Territory";
                break;
        }
        
        return retVal;
    }
}
