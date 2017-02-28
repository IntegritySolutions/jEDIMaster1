/* {ISOCountryCodes.java}
 * This enumeration provides access to all of the valid ISO Country codes
 * as assigned by the International Standards Organization. These codes are used
 * to validate the countries provided in EDI transmission documents.
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
 * The International Standards Organization (ISO) two-character country codes.
 * This enumeration also provides methods for retrieving the:
 * <ul>
 *  <li>ISO three-character country codes</li>
 *  <li>ISO integer country codes</li>
 *  <li>English short name for each country</li>
 * </ul>
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum ISOCountryCodes {
    //<editor-fold desc="   Country Constants   ">
    AFGHANISTAN("AF"),
    ALAND_ISLANDS("AX"),
    ALBANIA("AL"),
    ALGERIA("DZ"),
    AMERICAN_SAMOA("AS"),
    ANDORRA("AD"),
    ANGOLA("AO"),
    ANGUILLA("AI"),
    ANTARCTICA("AQ"),
    ANTIGUA_AND_BARBUDA("AG"),
    ARGENTINA("AR"),
    ARMENIA("AM"),
    ARUBA("AW"),
    AUSTRALIA("AU"),
    AUSTRIA("AT"),
    AZERBAIJAN("AZ"),
    BAHAMAS("BS"),
    BAHRAIN("BH"),
    BANGLADESH("BD"),
    BARBADOS("BB"),
    BELARUS("BY"),
    BELGIUM("BE"),
    BELIZE("BZ"),
    BENIN("BJ"),
    BERMUDA("BM"),
    BHUTAN("BT"),
    BOLIVIA("BO"),
    BONAIRE_SINT_EUSTATIUS_AND_SABA("BQ"),
    BOZNIA_HERZEGOVINA("BA"),
    BOTSWANA("BW"),
    BOUVET_ISLAND("BV"),
    BRAZIL("BR"),
    BRITISH_INDIAN_OCEAN_TERRITORY("IO"),
    BRUNEI_DARUSSALAM("BN"),
    BULGARIA("BG"),
    BURKINA_FASO("BF"),
    BURUNDI("BI"),
    CABO_VERDE("CV"),
    CAMBODIA("KH"),
    CAMEROON("CM"),
    CANADA("CA"),
    CAYMAN_ISLANDS("KY"),
    CENTRAL_AFRICAN_REPUBLIC("CF"),
    CHAD("TD"),
    CHILE("CL"),
    CHINA("CN"),
    CHRISTMAS_ISLAND("CX"),
    COCOS_ISLANDS("CC"),
    COLOMBIA("CO"),
    COMOROS("KM"),
    CONGO("CG"),
    COOK_ISLANDS("CK"),
    COSTA_RICA("CR"),
    COTE_DIVOIRE("CI"),
    CROATIA("HR"),
    CUBA("CU"),
    CURACAO("CW"),
    CYPRUS("CY"),
    CZECHIA("CZ"),
    DENMARK("DK"),
    DJIBOUTI("DJ"),
    DOMINICA("DM"),
    DOMINICAN_REPUBILC("DO"),
    ECUADOR("EC"),
    EGYPT("EG"),
    EL_SALVADOR("SV"),
    EQUATORIAL_GUINEA("GQ"),
    ERITREA("ER"),
    ESTONIA("EE"),
    ETHIOPIA("ET"),
    FALKLAND_ISLANDS_MALVINAS("FK"),
    FAROE_ISLANDS("FO"),
    FIJI("FJ"),
    FINLAND("FI"),
    FRANCE("FR"),
    FRENCH_GUIANA("GF"),
    FRENCH_POLYNESIA("PF"),
    FRENCH_SOUTHERN_TERRITORIES("TF"),
    GABON("GA"),
    GAMBIA("GM"),
    GEORGIA("GE"),
    GERMANY("DE"),
    GHANA("GH"),
    GIBRALTAR("GI"),
    GREECE("GR"),
    GREENLAND("GL"),
    GRENADA("GD"),
    GUADELOUPE("GP"),
    GUAM("GU"),
    GUATEMALA("GT"),
    GUERNSEY("GG"),
    GUINEA("GN"),
    GUINEA_BISSAU("GW"),
    GUYANA("GY"),
    HAITI("HT"),
    HEARD_ISLAND_AND_MCDONALD_ISLAND("HM"),
    HOLY_SEE("VA"),
    HONDURAS("HN"),
    HONG_KONG("HK"),
    HUNGARY("HU"),
    ICELAND("IS"),
    INDIA("IN"),
    INDONESIA("ID"),
    IRAN("IR"),
    IRAQ("IQ"),
    IRELAND("IE"),
    ISLE_OF_MAN("IM"),
    ISRAEL("IL"),
    ITALY("IT"),
    JAMAICA("JM"),
    JAPAN("JP"),
    JERSEY("JE"),
    JORDAN("JO"),
    KAZAKHSTAN("KZ"),
    KENYA("KE"),
    KIRIBATI("KI"),
    KOREA_NORTH("KP"),
    KOREA_SOUTH("KR"),
    KUWAIT("KW"),
    KYRGYZSTAN("KG"),
    LAO_PEOPLES_DEMOCRATIC_REPUBLIC("LA"),
    LATVIA("LV"),
    LEBANON("LB"),
    LESOTHO("LS"),
    LIBERIA("LR"),
    LIBYA("LY"),
    LIECHTENSTEIN("LI"),
    LITHUANIA("LT"),
    LUXEMBOURG("LU"),
    MACAO("MO"),
    MACEDONIA_FMR_YUGOSLAVIA("MK"),
    MADAGASCAR("MG"),
    MALAWI("MW"),
    MALAYSIA("MY"),
    MALDIVES("MV"),
    MALI("ML"),
    MALTA("MT"),
    MARSHALL_ISLANDS("MH"),
    MARTINIQUE("MQ"),
    MAURITANIA("MR"),
    MARITIUS("MU"),
    MAYOTTE("YT"),
    MEXICO("MX"),
    MICRONESIA("FM"),
    MOLDOVA("MD"),
    MONACO("MC"),
    MONGOLIA("MN"),
    MONTENEGRO("ME"),
    MONTSERRAT("MS"),
    MOROCCO("MA"),
    MOZAMBIQUE("MZ"),
    MYANMAR("MM"),
    NAMIBIA("NA"),
    NAURU("NR"),
    NEPAL("NP"),
    NETHERLANDS("NL"),
    NEW_CALEDONIA("NC"),
    NEW_ZEALAND("NZ"),
    NICARAGUA("NI"),
    NIGER("NE"),
    NIGERIA("NG"),
    NIEU("NU"),
    NORFOLK_ISLAND("NF"),
    NORTHERN_MARIANA_ISLANDS("MP"),
    NORWAY("NO"),
    OMAN("OM"),
    PAKISTAN("PK"),
    PALAU("PW"),
    PALESTINE("PS"),
    PANAMA("PA"),
    PAPUA_NEW_GUINEA("PG"),
    PERU("PY"),
    PHILIPPINES("PH"),
    PITCAIRN("PN"),
    POLAND("PL"),
    PORTUGAL("PT"),
    PUERTO_RICO("PR"),
    QATAR("QA"),
    REUNION("RE"),
    ROMANIA("RO"),
    RUSSIAN_FEDERATION("RU"),
    RWANDA("RW"),
    SAINT_BARTHELEMY("BL"),
    SAINT_HELENA_ASCENSION_AND_TRISTAN_DA_CUNHA("SH"),
    SAINT_KITTS_AND_NEVIS("KN"),
    SAINT_LUCIA("LC"),
    SAINT_VINCENT_AND_THE_GRENADINES("VC"),
    SAMOA("WS"),
    SAN_MARINO("SM"),
    SAO_TOME_AND_PRINCIPE("ST"),
    SAUDI_ARABIA("SA"),
    SENEGAL("SN"),
    SERBIA("RS"),
    SEYCHELLES("SC"),
    SIERRA_LEONE("SL"),
    SINGAPORE("SG"),
    SINT_MAARTEN("SX"),
    SLOVAKIA("SK"),
    SLOVENIA("SI"),
    SOLOMON_ISLANDS("SB"),
    SOMALIA("SO"),
    SOUTH_AFRICA("ZA"),
    SOUTH_GEORGIA_AND_SANDWICH_ISLANDS("GS"),
    SOUTH_SUDAN("SS"),
    SPAIN("ES"),
    SRI_LANKA("LK"),
    SUDAN("SD"),
    SURINAME("SR"),
    SVALBARD_AND_JAN_MAYEN("SJ"),
    SWAZILAND("SZ"),
    SWEDEN("SE"),
    SWITZERLAND("CH"),
    SYRIAN_ARAB_REPUBLIC("SY"),
    TAIWAN("TW"),
    TAJIKISTAN("TJ"),
    TANZANIA("TZ"),
    THAILAND("TH"),
    TIMOR_LESTE("TL"),
    TOGO("TG"),
    TOKELAU("TK"),
    TONGA("TO"),
    TRINIDAD_AND_TOBAGO("TT"),
    TUNISIA("TN"),
    TURKEY("TR"),
    TURKMENISTAN("TM"),
    TURKS_AND_CAICOS_ISLANDS("TC"),
    TUVALU("TV"),
    UGANDA("UG"),
    UKRAINE("UA"),
    UNITED_ARAB_EMIRATES("AE"),
    UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND("GB"),
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM"),
    UNITED_STATES_OF_AMERICA("US"),
    URUGUAY("UY"),
    UZBEKISTAN("UZ"),
    VANUATU("VU"),
    VENEZUELA("VE"),
    VIET_NAM("VN"),
    VIRGIN_ISLANDS_BRITISH("VG"),
    VIRGIN_ISLANDS_US("VI"),
    WALLIS_AND_FUTUNA("WF"),
    WESTERN_SAHARA("EH"),
    YEMEN("YE"),
    ZAMBIA("ZM"),
    ZIMBABWE("ZW");
    //</editor-fold>
        /**
         * The current value of the enumeration. This is the ISO 2-letter code
         * for the country in question.
         */
        private String value;
        /**
         * The current value of the enumeration which is the ISO 3-letter code
         * for the country in question.
         */
        private String value3;
        /**
         * The current value of the enumeration which is the English short name
         * for the country in question.
         */
        private String name;
        /**
         * The current value of the enumeration which is the ISO integer code
         * for the country in question.
         */
        private Integer code;
        /**
         * The dialing code for the country which this enumeration represents.
         */
        private Integer dialingCode;
    
    /**
     * Private constructor for the enumeration. The value is set based upon the
     * chosen enumeration constant.
     * @param val 
     */
    private ISOCountryCodes(String val) {
        // Assign the constant value to our value field.
        this.value = val;
        
        // Set up the rest of our fields' data.
        this.setup();
    }
    
    /**
     * Returns the <tt><a
     * href="http://docs.oracle.com/javase/8/docs/api/java/lang/String.html">
     * java.lang.String</a></tt> value for this enumeration constant.
     * 
     * @return java.lang.String two-character country code
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Retrieves the ISO three-character country code for this country.
     * 
     * @return java.lang.String 3-char country code
     */
    public String toThreeCharCode() {
        return this.value;
    }
    /**
     * Retrieves the English short name for this country.
     * 
     * @return java.lang.String English short name for this country
     */
    public String toName() {
        return this.name;
    }
    /**
     * Retrieves the ISO country code as a java.lang.Integer value.
     * 
     * @return java.lang.Integer ISO-assigned integer code for this country
     */
    public Integer toInteger() {
        return this.code;
    }
    /**
     * Retrieves the dialing code for the country.
     * 
     * @return java.lang.String country dialing code
     */
    public Integer getDialingCode() {
        return this.dialingCode;
    }
    
    /**
     * Private method to set up the data for the enumeration.
     */
    public void setup() {
        switch (this.value.toLowerCase()) {
            case "af":
                this.value3 = "AFG";
                this.code = 4;
                this.name = "Afghanistan";
                this.dialingCode = 93;
                break;
            case "ax":
                this.value3 = "ALA";
                this.code = 248;
                this.name = "Aland Islands";
                this.dialingCode = 358;
                break;
            case "al":
                this.value3 = "ALB";
                this.code = 8;
                this.name = "Albania";
                this.dialingCode = 355;
                break;
            case "dz":
                this.value3 = "DZA";
                this.code = 12;
                this.name = "Algeria";
                this.dialingCode = 213;
                break;
            case "as":
                this.value3 = "ASM";
                this.code = 16;
                this.name = "American Samoa";
                this.dialingCode = 1;
                break;
            case "ad":
                this.value3 = "AND";
                this.code = 20;
                this.name = "Andorra";
                this.dialingCode = 376;
                break;
            case "ao":
                this.value3 = "AGO";
                this.code = 24;
                this.name = "Angola";
                this.dialingCode = 244;
                break;
            case "ai":
                this.value3 = "AIA";
                this.code = 660;
                this.name = "Anguilla";
                this.dialingCode = 1;
                break;
            case "aq":
                this.value3 = "ATA";
                this.code = 10;
                this.name = "Antarctica";
                this.dialingCode = 672;
                break;
            case "ag":
                this.value3 = "ATG";
                this.code = 28;
                this.name = "Antigua and Barbuda";
                this.dialingCode = 1;
                break;
            case "ar":
                this.value3 = "ARG";
                this.code = 32;
                this.name = "Argentina";
                this.dialingCode = 54;
                break;
            case "am":
                this.value3 = "ARM";
                this.code = 51;
                this.name = "Armenia";
                this.dialingCode = 374;
                break;
            case "aw":
                this.value3 = "ABW";
                this.code = 533;
                this.name = "Aruba";
                this.dialingCode = 297;
                break;
            case "au":
                this.value3 = "AUS";
                this.code = 36;
                this.name = "Australia";
                this.dialingCode = 61;
                break;
            case "at":
                this.value3 = "AUT";
                this.code = 40;
                this.name = "Austria";
                this.dialingCode = 43;
                break;
            case "az":
                this.value3 = "AZE";
                this.code = 31;
                this.name = "Azerbaijan";
                this.dialingCode = 994;
                break;
            case "bs":
                this.value3 = "BHS";
                this.code = 44;
                this.name = "The Bahamas";
                this.dialingCode = 1;
                break;
            case "bh":
                this.value3 = "BHR";
                this.code = 48;
                this.name = "Bahrain";
                this.dialingCode = 973;
                break;
            case "bd":
                this.value3 = "BGD";
                this.code = 50;
                this.name = "Bangladesh";
                this.dialingCode = 880;
                break;
            case "bb":
                this.value3 = "BRB";
                this.code = 52;
                this.name = "Barbados";
                this.dialingCode = 1;
                break;
            case "by":
                this.value3 = "BLR";
                this.code = 112;
                this.name = "Belarus";
                this.dialingCode = 375;
                break;
            case "be":
                this.value3 = "BEL";
                this.code = 56;
                this.name = "Belgium";
                this.dialingCode = 32;
                break;
            case "bz":
                this.value3 = "BLZ";
                this.code = 84;
                this.name = "Belize";
                this.dialingCode = 501;
                break;
            case "bj":
                this.value3 = "BEN";
                this.code = 204;
                this.name = "Benin";
                this.dialingCode = 229;
                break;
            case "bm":
                this.value3 = "BMU";
                this.code = 60;
                this.name = "Bermuda";
                this.dialingCode = 1;
                break;
            case "bt":
                this.value3 = "BTN";
                this.code = 64;
                this.name = "Bhutan";
                this.dialingCode = 975;
                break;
            case "bo":
                this.value3 = "BOL";
                this.code = 68;
                this.name = "Plurinational State of Bolivia";
                this.dialingCode = 591;
                break;
            case "bq":
                this.value3 = "BES";
                this.code = 535;
                this.name = "Bonaire, Sint Eustatius and Saba";
                this.dialingCode = 599;
                break;
            case "ba":
                this.value3 = "BIH";
                this.code = 70;
                this.name = "Bosnia and Herzegovina";
                this.dialingCode = 387;
                break;
            case "bw":
                this.value3 = "BWA";
                this.code = 72;
                this.name = "Botswana";
                this.dialingCode = 267;
                break;
            case "bv":
                this.value3 = "BVT";
                this.code = 74;
                this.name = "Bouvet Island";
                this.dialingCode = 0;
                break;
            case "br":
                this.value3 = "BRA";
                this.code = 76;
                this.name = "Brazil";
                this.dialingCode = 55;
                break;
            case "io":
                this.value3 = "IOT";
                this.code = 86;
                this.name = "British Indian Ocean Territory";
                this.dialingCode = 246;
                break;
            case "bn":
                this.value3 = "BRN";
                this.code = 96;
                this.name = "Brunei Darussalam";
                this.dialingCode = 673;
                break;
            case "bg":
                this.value3 = "BGR";
                this.code = 100;
                this.name = "Bulgaria";
                this.dialingCode = 359;
                break;
            case "bf":
                this.value3 = "BFA";
                this.code = 854;
                this.name = "Burkina Faso";
                this.dialingCode = 226;
                break;
            case "bi":
                this.value3 = "BDI";
                this.code = 108;
                this.name = "Burundi";
                this.dialingCode = 257;
                break;
            case "cv":
                this.value3 = "CPV";
                this.code = 132;
                this.name = "Cabo Verde";
                this.dialingCode = 238;
                break;
            case "kh":
                this.value3 = "KHM";
                this.code = 116;
                this.name = "Cambodia";
                this.dialingCode = 855;
                break;
            case "cm":
                this.value3 = "CMR";
                this.code = 120;
                this.name = "Cameroon";
                this.dialingCode = 237;
                break;
            case "ca":
                this.value3 = "CAN";
                this.code = 124;
                this.name = "Canada";
                this.dialingCode = 1;
                break;
            case "ky":
                this.value3 = "CYM";
                this.code = 136;
                this.name = "The Cayman Islands";
                this.dialingCode = 1;
                break;
            case "cf":
                this.value3 = "CAF";
                this.code = 140;
                this.name = "The Central African Republic";
                this.dialingCode = 236;
                break;
            case "td":
                this.value3 = "TCD";
                this.code = 148;
                this.name = "Chad";
                this.dialingCode = 235;
                break;
            case "cl":
                this.value3 = "CHL";
                this.code = 152;
                this.name = "Chile";
                this.dialingCode = 56;
                break;
            case "cn":
                this.value3 = "CHN";
                this.code = 156;
                this.name = "China";
                this.dialingCode = 86;
                break;
            case "cx":
                this.value3 = "CXR";
                this.code = 162;
                this.name = "Christmas Island";
                this.dialingCode = 61;
                break;
            case "cc":
                this.value3 = "CCK";
                this.code = 166;
                this.name = "The Cocos (Keeling) Islands";
                this.dialingCode = 891;
                break;
            case "co":
                this.value3 = "COL";
                this.code = 170;
                this.name = "Colombia";
                this.dialingCode = 57;
                break;
            case "km":
                this.value3 = "COM";
                this.code = 174;
                this.name = "The Comoros";
                this.dialingCode = 269;
                break;
            case "cd":
                this.value3 = "COD";
                this.code = 180;
                this.name = "The Democratic Republic of the Congo";
                this.dialingCode = 243;
                break;
            case "cg":
                this.value3 = "COG";
                this.code = 178;
                this.name = "The Congo";
                this.dialingCode = 242;
                break;
            case "ck":
                this.value3 = "COK";
                this.code = 184;
                this.name = "The Cook Islands";
                this.dialingCode = 682;
                break;
            case "cr":
                this.value3 = "CRI";
                this.code = 188;
                this.name = "Costa Rica";
                this.dialingCode = 506;
                break;
            case "ci":
                this.value3 = "CIV";
                this.code = 384;
                this.name = "Cote d'Ivoire";
                this.dialingCode = 225;
                break;
            case "hr":
                this.value3 = "HRV";
                this.code = 191;
                this.name = "Croatia";
                this.dialingCode = 385;
                break;
            case "cu":
                this.value3 = "CUB";
                this.code = 192;
                this.name = "Cuba";
                this.dialingCode = 53;
                break;
            case "cw":
                this.value3 = "CUW";
                this.code = 531;
                this.name = "Curacao";
                this.dialingCode = 599;
                break;
            case "cy":
                this.value3 = "CYP";
                this.code = 196;
                this.name = "Cyprus";
                this.dialingCode = 357;
                break;
            case "cz":
                this.value3 = "CZE";
                this.code = 203;
                this.name = "Czechia";
                this.dialingCode = 420;
                break;
            case "dk":
                this.value3 = "DNK";
                this.code = 208;
                this.name = "Denmark";
                this.dialingCode = 45;
                break;
            case "dj":
                this.value3 = "DJI";
                this.code = 262;
                this.name = "Djibouti";
                this.dialingCode = 253;
                break;
            case "dm":
                this.value3 = "DMA";
                this.code = 212;
                this.name = "Dominica";
                this.dialingCode = 1;
                break;
            case "do":
                this.value3 = "DOM";
                this.code = 214;
                this.name = "The Dominican Republic";
                this.dialingCode = 1;
                break;
            case "ec":
                this.value3 = "ECU";
                this.code = 218;
                this.name = "Ecuador";
                this.dialingCode = 593;
                break;
            case "eg":
                this.value3 = "EGY";
                this.code = 818;
                this.name = "Egypt";
                this.dialingCode = 20;
                break;
            case "sv":
                this.value3 = "SLV";
                this.code = 222;
                this.name = "El Salvador";
                this.dialingCode = 503;
                break;
            case "gq":
                this.value3 = "GNQ";
                this.code = 226;
                this.name = "Equatorial Guinea";
                this.dialingCode = 240;
                break;
            case "er":
                this.value3 = "ERI";
                this.code = 232;
                this.name = "Eritrea";
                this.dialingCode = 240;
                break;
            case "ee":
                this.value3 = "EST";
                this.code = 233;
                this.name = "Estonia";
                this.dialingCode = 372;
                break;
            case "et":
                this.value3 = "ETH";
                this.code = 231;
                this.name = "Ethiopia";
                this.dialingCode = 251;
                break;
            case "fk":
                this.value3 = "FLK";
                this.code = 238;
                this.name = "The Falkland Islands (Malvinas)";
                this.dialingCode = 500;
                break;
            case "fo":
                this.value3 = "FRO";
                this.code = 234;
                this.name = "The Faroe Islands";
                this.dialingCode = 298;
                break;
            case "fj":
                this.value3 = "FJI";
                this.code = 242;
                this.name = "Fiji";
                this.dialingCode = 679;
                break;
            case "fi":
                this.value3 = "FIN";
                this.code = 246;
                this.name = "Finland";
                this.dialingCode = 358;
                break;
            case "fr":
                this.value3 = "FRA";
                this.code = 250;
                this.name = "France";
                this.dialingCode = 33;
                break;
            case "gf":
                this.value3 = "GUF";
                this.code = 254;
                this.name = "French Guiana";
                this.dialingCode = 594;
                break;
            case "pf":
                this.value3 = "PYF";
                this.code = 258;
                this.name = "French Polynesia";
                this.dialingCode = 689;
                break;
            case "tf":
                this.value3 = "ATF";
                this.code = 260;
                this.name = "The French Southern Territories";
                this.dialingCode = 262;
                break;
            case "ga":
                this.value3 = "GAB";
                this.code = 266;
                this.name = "Gabon";
                this.dialingCode = 241;
                break;
            case "gm":
                this.value3 = "GMB";
                this.code = 270;
                this.name = "The Gambia";
                this.dialingCode = 220;
                break;
            case "ge":
                this.value3 = "GEO";
                this.code = 268;
                this.name = "Georgia";
                this.dialingCode = 955;
                break;
            case "de":
                this.value3 = "DEU";
                this.code = 276;
                this.name = "Germany";
                this.dialingCode = 49;
                break;
            case "gh":
                this.value3 = "GHA";
                this.code = 288;
                this.name = "Ghana";
                this.dialingCode = 233;
                break;
            case "gi":
                this.value3 = "GIB";
                this.code = 292;
                this.name = "Gibraltar";
                this.dialingCode = 350;
                break;
            case "gr":
                this.value3 = "GRC";
                this.code = 300;
                this.name = "Greece";
                this.dialingCode = 30;
                break;
            case "gl":
                this.value3 = "GRL";
                this.code = 304;
                this.name = "Greenland";
                this.dialingCode = 299;
                break;
            case "gd":
                this.value3 = "GRD";
                this.code = 308;
                this.name = "Grenada";
                this.dialingCode = 1;
                break;
            case "gp":
                this.value3 = "GLP";
                this.code = 312;
                this.name = "Guadeloupe";
                this.dialingCode = 590;
                break;
            case "gu":
                this.value3 = "GUM";
                this.code = 316;
                this.name = "Guam";
                this.dialingCode = 1;
                break;
            case "gt":
                this.value3 = "GTM";
                this.code = 320;
                this.name = "Guatemala";
                this.dialingCode = 502;
                break;
            case "gg":
                this.value3 = "GGY";
                this.code = 831;
                this.name = "Guernsey";
                this.dialingCode = 44;
                break;
            case "gn":
                this.value3 = "GIN";
                this.code = 324;
                this.name = "Guinea";
                this.dialingCode = 224;
                break;
            case "gw":
                this.value3 = "GNB";
                this.code = 624;
                this.name = "Guinea-Bissau";
                this.dialingCode = 245;
                break;
            case "gy":
                this.value3 = "GUY";
                this.code = 328;
                this.name = "Guyana";
                this.dialingCode = 592;
                break;
            case "ht":
                this.value3 = "HTI";
                this.code = 332;
                this.name = "Haiti";
                this.dialingCode = 509;
                break;
            case "hm":
                this.value3 = "HMD";
                this.code = 334;
                this.name = "Heard Island and McDonald Islands";
                this.dialingCode = 0;
                break;
            case "va":
                this.value3 = "VAT";
                this.code = 336;
                this.name = "The Holy See";
                this.dialingCode = 379;
                break;
            case "hn":
                this.value3 = "HND";
                this.code = 340;
                this.name = "Honduras";
                this.dialingCode = 504;
                break;
            case "hk":
                this.value3 = "HKG";
                this.code = 344;
                this.name = "Hong Kong";
                this.dialingCode = 852;
                break;
            case "hu":
                this.value3 = "HUN";
                this.code = 348;
                this.name = "Hungary";
                this.dialingCode = 36;
                break;
            case "is":
                this.value3 = "ISL";
                this.code = 352;
                this.name = "Iceland";
                this.dialingCode = 354;
                break;
            case "in":
                this.value3 = "IND";
                this.code = 356;
                this.name = "India";
                this.dialingCode = 91;
                break;
            case "id":
                this.value3 = "IDN";
                this.code = 360;
                this.name = "Indonesia";
                this.dialingCode = 62;
                break;
            case "ir":
                this.value3 = "IRN";
                this.code = 364;
                this.name = "Islamic Republic of Iran";
                this.dialingCode = 98;
                break;
            case "iq":
                this.value3 = "IRQ";
                this.code = 368;
                this.name = "Iraq";
                this.dialingCode = 964;
                break;
            case "ie":
                this.value3 = "IRL";
                this.code = 372;
                this.name = "Ireland";
                this.dialingCode = 353;
                break;
            case "im":
                this.value3 = "IMN";
                this.code = 833;
                this.name = "Isle of Man";
                this.dialingCode = 44;
                break;
            case "il":
                this.value3 = "ISR";
                this.code = 376;
                this.name = "Israel";
                this.dialingCode = 972;
                break;
            case "it":
                this.value3 = "ITA";
                this.code = 380;
                this.name = "Italy";
                this.dialingCode = 39;
                break;
            case "jm":
                this.value3 = "JAM";
                this.code = 388;
                this.name = "Jamaica";
                this.dialingCode = 1;
                break;
            case "jp":
                this.value3 = "JPN";
                this.code = 392;
                this.name = "Japan";
                this.dialingCode = 81;
                break;
            case "je":
                this.value3 = "JEY";
                this.code = 832;
                this.name = "Jersey";
                this.dialingCode = 44;
                break;
            case "jo":
                this.value3 = "JOR";
                this.code = 400;
                this.name = "Jordan";
                this.dialingCode = 962;
                break;
            case "kz":
                this.value3 = "KAZ";
                this.code = 398;
                this.name = "Kazakhstan";
                this.dialingCode = 7;
                break;
            case "ke":
                this.value3 = "KEN";
                this.code = 404;
                this.name = "Kenya";
                this.dialingCode = 254;
                break;
            case "ki":
                this.value3 = "KIR";
                this.code = 296;
                this.name = "Kiribati";
                this.dialingCode = 686;
                break;
            case "kp":
                this.value3 = "PRK";
                this.code = 408;
                this.name = "The Democratic People's Republic of Korea (North)";
                this.dialingCode = 850;
                break;
            case "kr":
                this.value3 = "KOR";
                this.code = 410;
                this.name = "The Republic of Korea (South)";
                this.dialingCode = 82;
                break;
            case "kw":
                this.value3 = "KWT";
                this.code = 414;
                this.name = "Kuwait";
                this.dialingCode = 965;
                break;
            case "kg":
                this.value3 = "KGZ";
                this.code = 417;
                this.name = "Kyrgyzstan";
                this.dialingCode = 996;
                break;
            case "la":
                this.value3 = "LAO";
                this.code = 418;
                this.name = "The Lao People's Democratic Republic";
                this.dialingCode = 856;
                break;
            case "lv":
                this.value3 = "LVA";
                this.code = 428;
                this.name = "Latvia";
                this.dialingCode = 371;
                break;
            case "lb":
                this.value3 = "LBN";
                this.code = 422;
                this.name = "Lebanon";
                this.dialingCode = 961;
                break;
            case "ls":
                this.value3 = "LSO";
                this.code = 426;
                this.name = "Lesotho";
                this.dialingCode = 266;
                break;
            case "lr":
                this.value3 = "LBR";
                this.code = 430;
                this.name = "Liberia";
                this.dialingCode = 231;
                break;
            case "ly":
                this.value3 = "LBY";
                this.code = 434;
                this.name = "Libya";
                this.dialingCode = 218;
                break;
            case "li":
                this.value3 = "LIE";
                this.code = 438;
                this.name = "Liechtenstein";
                this.dialingCode = 423;
                break;
            case "lt":
                this.value3 = "LTU";
                this.code = 440;
                this.name = "Lithuania";
                this.dialingCode = 370;
                break;
            case "lu":
                this.value3 = "LUX";
                this.code = 442;
                this.name = "Luxembourg";
                this.dialingCode = 352;
                break;
            case "mo":
                this.value3 = "MAC";
                this.code = 446;
                this.name = "Macau";
                this.dialingCode = 853;
                break;
            case "mk":
                this.value3 = "MKD";
                this.code = 807;
                this.name = "Macedonia (the former Republic of Yugoslav";
                this.dialingCode = 389;
                break;
            case "mg":
                this.value3 = "MDG";
                this.code = 450;
                this.name = "Madagascar";
                this.dialingCode = 261;
                break;
            case "mw":
                this.value3 = "MWI";
                this.code = 454;
                this.name = "Malawi";
                this.dialingCode = 265;
                break;
            case "my":
                this.value3 = "MYS";
                this.code = 458;
                this.name = "Malaysia";
                this.dialingCode = 60;
                break;
            case "mv":
                this.value3 = "MDV";
                this.code = 462;
                this.name = "Maldives";
                this.dialingCode = 960;
                break;
            case "ml":
                this.value3 = "MLI";
                this.code = 466;
                this.name = "Mali";
                this.dialingCode = 223;
                break;
            case "mt":
                this.value3 = "MLT";
                this.code = 470;
                this.name = "Malta";
                this.dialingCode = 356;
                break;
            case "mh":
                this.value3 = "MHL";
                this.code = 584;
                this.name = "The Marshall Islands";
                this.dialingCode = 692;
                break;
            case "mq":
                this.value3 = "MTQ";
                this.code = 474;
                this.name = "Martinique";
                this.dialingCode = 596;
                break;
            case "mr":
                this.value3 = "MRT";
                this.code = 478;
                this.name = "Mauritania";
                this.dialingCode = 222;
                break;
            case "mu":
                this.value3 = "MUS";
                this.code = 480;
                this.name = "Mauritius";
                this.dialingCode = 230;
                break;
            case "yt":
                this.value3 = "MYT";
                this.code = 175;
                this.name = "Mayotte";
                this.dialingCode = 262;
                break;
            case "mx":
                this.value3 = "MEX";
                this.code = 484;
                this.name = "Mexico";
                this.dialingCode = 52;
                break;
            case "fm":
                this.value3 = "FSM";
                this.code = 583;
                this.name = "The Federated States of Micronesia";
                this.dialingCode = 691;
                break;
            case "md":
                this.value3 = "MDA";
                this.code = 498;
                this.name = "The Republic of Moldova";
                this.dialingCode = 373;
                break;
            case "mc":
                this.value3 = "MCO";
                this.code = 492;
                this.name = "Monaco";
                this.dialingCode = 377;
                break;
            case "mn":
                this.value3 = "MNG";
                this.code = 496;
                this.name = "Mongolia";
                this.dialingCode = 976;
                break;
            case "me":
                this.value3 = "MNE";
                this.code = 499;
                this.name = "Montenegro";
                this.dialingCode = 382;
                break;
            case "ms":
                this.value3 = "MSR";
                this.code = 500;
                this.name = "Montserrat";
                this.dialingCode = 1;
                break;
            case "ma":
                this.value3 = "MAR";
                this.code = 504;
                this.name = "Morocco";
                this.dialingCode = 212;
                break;
            case "mz":
                this.value3 = "MOZ";
                this.code = 508;
                this.name = "Mozambique";
                this.dialingCode = 258;
                break;
            case "mm":
                this.value3 = "MMR";
                this.code = 104;
                this.name = "Myanmar";
                this.dialingCode = 95;
                break;
            case "na":
                this.value3 = "NAM";
                this.code = 516;
                this.name = "Namibia";
                this.dialingCode = 264;
                break;
            case "nr":
                this.value3 = "NRU";
                this.code = 520;
                this.name = "Nauru";
                this.dialingCode = 674;
                break;
            case "np":
                this.value3 = "NPL";
                this.code = 524;
                this.name = "Nepal";
                this.dialingCode = 977;
                break;
            case "nl":
                this.value3 = "NLD";
                this.code = 528;
                this.name = "The Netherlands";
                this.dialingCode = 31;
                break;
            case "nc":
                this.value3 = "NCL";
                this.code = 540;
                this.name = "New Caledonia";
                this.dialingCode = 687;
                break;
            case "nz":
                this.value3 = "NZL";
                this.code = 554;
                this.name = "New Zealand";
                this.dialingCode = 64;
                break;
            case "ni":
                this.value3 = "NIC";
                this.code = 558;
                this.name = "Nicaragua";
                this.dialingCode = 505;
                break;
            case "ne":
                this.value3 = "NER";
                this.code = 562;
                this.name = "The Niger";
                this.dialingCode = 227;
                break;
            case "ng":
                this.value3 = "NGA";
                this.code = 566;
                this.name = "Nigeria";
                this.dialingCode = 234;
                break;
            case "nu":
                this.value3 = "NIU";
                this.code = 570;
                this.name = "Niue";
                this.dialingCode = 683;
                break;
            case "nf":
                this.value3 = "NFK";
                this.code = 574;
                this.name = "Norfolk Island";
                this.dialingCode = 672;
                break;
            case "mp":
                this.value3 = "MNP";
                this.code = 580;
                this.name = "The Northern Mariana Islands";
                this.dialingCode = 1;
                break;
            case "no":
                this.value3 = "NOR";
                this.code = 578;
                this.name = "Norway";
                this.dialingCode = 47;
                break;
            case "om":
                this.value3 = "OMN";
                this.code = 512;
                this.name = "Oman";
                this.dialingCode = 968;
                break;
            case "pk":
                this.value3 = "PAK";
                this.code = 586;
                this.name = "Pakistan";
                this.dialingCode = 92;
                break;
            case "pw":
                this.value3 = "PLW";
                this.code = 585;
                this.name = "Palau";
                this.dialingCode = 680;
                break;
            case "ps":
                this.value3 = "PSE";
                this.code = 275;
                this.name = "State of Palestine";
                this.dialingCode = 970;
                break;
            case "pa":
                this.value3 = "PAN";
                this.code = 591;
                this.name = "Panama";
                this.dialingCode = 507;
                break;
            case "pg":
                this.value3 = "PNG";
                this.code = 598;
                this.name = "Papua New Guinea";
                this.dialingCode = 675;
                break;
            case "py":
                this.value3 = "PRY";
                this.code = 600;
                this.name = "Paraguay";
                this.dialingCode = 595;
                break;
            case "pe":
                this.value3 = "PER";
                this.code = 604;
                this.name = "Peru";
                this.dialingCode = 51"00";
                break;
            case "ph":
                this.value3 = "PHL";
                this.code = 608;
                this.name = "The Philippines";
                this.dialingCode = 63;
                break;
            case "pn":
                this.value3 = "PCN";
                this.code = 612;
                this.name = "Pitcairn";
                this.dialingCode = 64;
                break;
            case "pl":
                this.value3 = "POL";
                this.code = 616;
                this.name = "Poland";
                this.dialingCode = 48;
                break;
            case "pt":
                this.value3 = "PRT";
                this.code = 620;
                this.name = "Portugal";
                this.dialingCode = 351;
                break;
            case "pr":
                this.value3 = "PRI";
                this.code = 630;
                this.name = "Puerto Rico";
                this.dialingCode = 1;
                break;
            case "qa":
                this.value3 = "QAT";
                this.code = 634;
                this.name = "Qatar";
                this.dialingCode = 974;
                break;
            case "re":
                this.value3 = "REU";
                this.code = 638;
                this.name = "Reunion";
                this.dialingCode = 262;
                break;
            case "ro":
                this.value3 = "ROU";
                this.code = 642;
                this.name = "Romania";
                this.dialingCode = 40;
                break;
            case "ru":
                this.value3 = "RUS";
                this.code = 643;
                this.name = "The Russian Federation";
                this.dialingCode = 7;
                break;
            case "rw":
                this.value3 = "RWA";
                this.code = 646;
                this.name = "Rwanda";
                this.dialingCode = 250;
                break;
            case "bl":
                this.value3 = "BLM";
                this.code = 652;
                this.name = "Saint Barthelemy";
                this.dialingCode = 590;
                break;
            case "sh":
                this.value3 = "SHN";
                this.code = 654;
                this.name = "Saint Helena, Ascension and Tristan da Cunha";
                this.dialingCode = 290;
                break;
            case "kn":
                this.value3 = "KNA";
                this.code = 659;
                this.name = "Saint Kitts and Nevis";
                this.dialingCode = 1;
                break;
            case "lc":
                this.value3 = "LCA";
                this.code = 662;
                this.name = "Saint Lucia";
                this.dialingCode = 1;
                break;
            case "mf":
                this.value3 = "MAF";
                this.code = 663;
                this.name = "Saint Martin (French Part)";
                this.dialingCode = 1;
                break;
            case "pm":
                this.value3 = "SPM";
                this.code = 666;
                this.name = "Saint Pierre and Miquelon";
                this.dialingCode = 508;
                break;
            case "vc":
                this.value3 = "VCT";
                this.code = 670;
                this.name = "Saint Vincent and the Grenadines";
                this.dialingCode = 1;
                break;
            case "ws":
                this.value3 = "WSM";
                this.code = 882;
                this.name = "Samoa";
                this.dialingCode = 685;
                break;
            case "sm":
                this.value3 = "SMR";
                this.code = 674;
                this.name = "San Marino";
                this.dialingCode = 378;
                break;
            case "st":
                this.value3 = "STP";
                this.code = 678;
                this.name = "Sao Tome and Principe";
                this.dialingCode = 239;
                break;
            case "sa":
                this.value3 = "SAU";
                this.code = 682;
                this.name = "Saudi Arabia";
                this.dialingCode = 966;
                break;
            case "sn":
                this.value3 = "SEN";
                this.code = 686;
                this.name = "Senegal";
                this.dialingCode = 221;
                break;
            case "rs":
                this.value3 = "SRB";
                this.code = 688;
                this.name = "Serbia";
                this.dialingCode = 381;
                break;
            case "sc":
                this.value3 = "SYC";
                this.code = 690;
                this.name = "Seychelles";
                this.dialingCode = 248;
                break;
            case "sl":
                this.value3 = "SLE";
                this.code = 694;
                this.name = "Sierra Leone";
                this.dialingCode = 232;
                break;
            case "sg":
                this.value3 = "SGP";
                this.code = 702;
                this.name = "Singapore";
                this.dialingCode = 65;
                break;
            case "sx":
                this.value3 = "SXM";
                this.code = 534;
                this.name = "Sint Maarten (Dutch Part)";
                this.dialingCode = 1;
                break;
            case "sk":
                this.value3 = "SVK";
                this.code = 703;
                this.name = "Slovakia";
                this.dialingCode = 421;
                break;
            case "si":
                this.value3 = "SVN";
                this.code = 705;
                this.name = "Slovenia";
                this.dialingCode = 386;
                break;
            case "sb":
                this.value3 = "SLB";
                this.code = 90;
                this.name = "Solomon Islands";
                this.dialingCode = 677;
                break;
            case "so":
                this.value3 = "SOM";
                this.code = 706;
                this.name = "Somalia";
                this.dialingCode = 252;
                break;
            case "za":
                this.value3 = "ZAF";
                this.code = 710;
                this.name = "South Africa";
                this.dialingCode = 27;
                break;
            case "gs":
                this.value3 = "SGS";
                this.code = 239;
                this.name = "South Georgia and the South Sandwich Islands";
                this.dialingCode = 500;
                break;
            case "ss":
                this.value3 = "SSD";
                this.code = 728;
                this.name = "South Sudan";
                this.dialingCode = 211;
                break;
            case "es":
                this.value3 = "ESP";
                this.code = 724;
                this.name = "Spain";
                this.dialingCode = 34;
                break;
            case "lk":
                this.value3 = "LKA";
                this.code = 144;
                this.name = "Sri Lanka";
                this.dialingCode = 94;
                break;
            case "sd":
                this.value3 = "SDN";
                this.code = 729;
                this.name = "The Sudan";
                this.dialingCode = 249;
                break;
            case "sr":
                this.value3 = "SUR";
                this.code = 740;
                this.name = "Suriname";
                this.dialingCode = 597;
                break;
            case "sj":
                this.value3 = "SJM";
                this.code = 744;
                this.name = "Svalbard and Jan Mayen";
                this.dialingCode = 0;
                break;
            case "sz":
                this.value3 = "SWZ";
                this.code = 748;
                this.name = "Swaziland";
                this.dialingCode = 268;
                break;
            case "se":
                this.value3 = "SWE";
                this.code = 752;
                this.name = "Sweden";
                this.dialingCode = 46;
                break;
            case "ch":
                this.value3 = "CHE";
                this.code = 756;
                this.name = "Switzerland";
                this.dialingCode = 41;
            case "sy":
                this.value3 = "SYR";
                this.code = 760;
                this.name = "Syrian Arab Republic";
                this.dialingCode = 963;
            case "tw":
                this.value3 = "TWN";
                this.code = 158;
                this.name = "Taiwan (Province of China)";
                this.dialingCode = 886;
            case "tj":
                this.value3 = "TJK";
                this.code = 762;
                this.name = "Tajikistan";
                this.dialingCode = 992;
            case "tz":
                this.value3 = "TZA";
                this.code = 834;
                this.name = "United Republic of Tanzania";
                this.dialingCode = 255;
            case "th":
                this.value3 = "THA";
                this.code = 764;
                this.name = "Thailand";
                this.dialingCode = 66;
            case "tl":
                this.value3 = "TLS";
                this.code = 626;
                this.name = "Timor-Leste";
                this.dialingCode = 670;
            case "tg":
                this.value3 = "TGO";
                this.code = 768;
                this.name = "Togo";
                this.dialingCode = 228;
            case "tk":
                this.value3 = "TKL";
                this.code = 772;
                this.name = "Tokelau";
                this.dialingCode = 690;
            case "to":
                this.value3 = "TON";
                this.code = 776;
                this.name = "Tonga";
                this.dialingCode = 676;
            case "tt":
                this.value3 = "TTO";
                this.code = 780;
                this.name = "Trinidad and Tobago";
                this.dialingCode = 1;
            case "tn":
                this.value3 = "TUN";
                this.code = 788;
                this.name = "Tunisia";
                this.dialingCode = 216;
            case "tr":
                this.value3 = "TUR";
                this.code = 792;
                this.name = "Turkey";
                this.dialingCode = 90;
            case "tm":
                this.value3 = "TKM";
                this.code = 795;
                this.name = "Turkmenistan";
                this.dialingCode = 993;
            case "tc":
                this.value3 = "TCA";
                this.code = 796;
                this.name = "The Turks and Caicos Islands";
                this.dialingCode = 1;
            case "tv":
                this.value3 = "TUV";
                this.code = 798;
                this.name = "Tuvalu";
                this.dialingCode = 688;
            case "ug":
                this.value3 = "UGA";
                this.code = 800;
                this.name = "Uganda";
                this.dialingCode = 256;
            case "ua":
                this.value3 = "UKR";
                this.code = 804;
                this.name = "Ukraine";
                this.dialingCode = "810";
            case "ae":
                this.value3 = "ARE";
                this.code = 784;
                this.name = "The United Arab Emirates";
                this.dialingCode = 971;
            case "gb":
                this.value3 = "GBR";
                this.code = 826;
                this.name = "The United Kingdom of Great Britain and Northern "
                            + "Ireland";
                this.dialingCode = 44;
            case "um":
                this.value3 = "UMI";
                this.code = 581;
                this.name = "The United States Minor Outlying Islands";
                this.dialingCode = 1;
            case "us":
                this.value3 = "USA";
                this.code = 840;
                this.name = "The United States of America";
                this.dialingCode = 1;
            case "uy":
                this.value3 = "URY";
                this.code = 858;
                this.name = "Uruguay";
                this.dialingCode = 598;
            case "uz":
                this.value3 = "UZB";
                this.code = 860;
                this.name = "Uzbekistan";
                this.dialingCode = 998;
            case "vu":
                this.value3 = "VUT";
                this.code = 548;
                this.name = "Vanuatu";
                this.dialingCode = 678;
            case "ve":
                this.value3 = "VEN";
                this.code = 862;
                this.name = "Bolivarian Republic of Venezuela";
                this.dialingCode = 58;
            case "vn":
                this.value3 = "VNM";
                this.code = 704;
                this.name = "Viet Nam";
                this.dialingCode = 84;
            case "vg":
                this.value3 = "VGB";
                this.code = 92;
                this.name = "British Virgin Islands";
                this.dialingCode = 1;
            case "vi":
                this.value3 = "VIR";
                this.code = 850;
                this.name = "U.S. Virgin Islands";
                this.dialingCode = 1;
            case "wf":
                this.value3 = "WLF";
                this.code = 876;
                this.name = "Wallis and Futuna";
                this.dialingCode = 681;
            case "eh":
                this.value3 = "ESH";
                this.code = 732;
                this.name = "Western Sahara";
                this.dialingCode = 212;
            case "ye":
                this.value3 = "YEM";
                this.code = 887;
                this.name = "Yemen";
                this.dialingCode = 967;
            case "zm":
                this.value3 = "ZMB";
                this.code = 894;
                this.name = "Zambia";
                this.dialingCode = 260;
            case "zw":
                this.value3 = "ZWE";
                this.code = 716;
                this.name = "Zimbabwe";
                this.dialingCode = 263;
            default:
                this.value3 = "UNK";
                this.code = 0;
                this.name = "Unknown";
                this.dialingCode = 0;
        }
    }
}
