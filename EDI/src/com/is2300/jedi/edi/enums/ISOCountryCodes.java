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
     * Private method to set up the data for the enumeration.
     */
    public void setup() {
        switch (this.value.toLowerCase()) {
            case "af":
                this.value3 = "AFG";
                this.code = 4;
                this.name = "Afghanistan";
                break;
            case "ax":
                this.value3 = "ALA";
                this.code = 248;
                this.name = "Aland Islands";
                break;
            case "al":
                this.value3 = "ALB";
                this.code = 8;
                this.name = "Albania";
                break;
            case "dz":
                this.value3 = "DZA";
                this.code = 12;
                this.name = "Algeria";
                break;
            case "as":
                this.value3 = "ASM";
                this.code = 16;
                this.name = "American Samoa";
                break;
            case "ad":
                this.value3 = "AND";
                this.code = 20;
                this.name = "Andorra";
                break;
            case "ao":
                this.value3 = "AGO";
                this.code = 24;
                this.name = "Angola";
                break;
            case "ai":
                this.value3 = "AIA";
                this.code = 660;
                this.name = "Anguilla";
                break;
            case "aq":
                this.value3 = "ATA";
                this.code = 10;
                this.name = "Antarctica";
                break;
            case "ag":
                this.value3 = "ATG";
                this.code = 28;
                this.name = "Antigua and Barbuda";
                break;
            case "ar":
                this.value3 = "ARG";
                this.code = 32;
                this.name = "Argentina";
                break;
            case "am":
                this.value3 = "ARM";
                this.code = 51;
                this.name = "Armenia";
                break;
            case "aw":
                this.value3 = "ABW";
                this.code = 533;
                this.name = "Aruba";
                break;
            case "au":
                this.value3 = "AUS";
                this.code = 36;
                this.name = "Australia";
                break;
            case "at":
                this.value3 = "AUT";
                this.code = 40;
                this.name = "Austria";
                break;
            case "az":
                this.value3 = "AZE";
                this.code = 31;
                this.name = "Azerbaijan";
                break;
            case "bs":
                this.value3 = "BHS";
                this.code = 44;
                this.name = "The Bahamas";
                break;
            case "bh":
                this.value3 = "BHR";
                this.code = 48;
                this.name = "Bahrain";
                break;
            case "bd":
                this.value3 = "BGD";
                this.code = 50;
                this.name = "Bangladesh";
                break;
            case "bb":
                this.value3 = "BRB";
                this.code = 52;
                this.name = "Barbados";
                break;
            case "by":
                this.value3 = "BLR";
                this.code = 112;
                this.name = "Belarus";
                break;
            case "be":
                this.value3 = "BEL";
                this.code = 56;
                this.name = "Belgium";
                break;
            case "bz":
                this.value3 = "BLZ";
                this.code = 84;
                this.name = "Belize";
                break;
            case "bj":
                this.value3 = "BEN";
                this.code = 204;
                this.name = "Benin";
                break;
            case "bm":
                this.value3 = "BMU";
                this.code = 60;
                this.name = "Bermuda";
                break;
            case "bt":
                this.value3 = "BTN";
                this.code = 64;
                this.name = "Bhutan";
                break;
            case "bo":
                this.value3 = "BOL";
                this.code = 68;
                this.name = "Plurinational State of Bolivia";
                break;
            case "bq":
                this.value3 = "BES";
                this.code = 535;
                this.name = "Bonaire, Sint Eustatius and Saba";
                break;
            case "ba":
                this.value3 = "BIH";
                this.code = 70;
                this.name = "Bosnia and Herzegovina";
                break;
            case "bw":
                this.value3 = "BWA";
                this.code = 72;
                this.name = "Botswana";
                break;
            case "bv":
                this.value3 = "BVT";
                this.code = 74;
                this.name = "Bouvet Island";
                break;
            case "br":
                this.value3 = "BRA";
                this.code = 76;
                this.name = "Brazil";
                break;
            case "io":
                this.value3 = "IOT";
                this.code = 86;
                this.name = "British Indian Ocean Territory";
                break;
            case "bn":
                this.value3 = "BRN";
                this.code = 96;
                this.name = "Brunei Darussalam";
                break;
            case "bg":
                this.value3 = "BGR";
                this.code = 100;
                this.name = "Bulgaria";
                break;
            case "bf":
                this.value3 = "BFA";
                this.code = 854;
                this.name = "Burkina Faso";
                break;
            case "bi":
                this.value3 = "BDI";
                this.code = 108;
                this.name = "Burundi";
                break;
            case "cv":
                this.value3 = "CPV";
                this.code = 132;
                this.name = "Cabo Verde";
                break;
            case "kh":
                this.value3 = "KHM";
                this.code = 116;
                this.name = "Cambodia";
                break;
            case "cm":
                this.value3 = "CMR";
                this.code = 120;
                this.name = "Cameroon";
                break;
            case "ca":
                this.value3 = "CAN";
                this.code = 124;
                this.name = "Canada";
                break;
            case "ky":
                this.value3 = "CYM";
                this.code = 136;
                this.name = "The Cayman Islands";
                break;
            case "cf":
                this.value3 = "CAF";
                this.code = 140;
                this.name = "The Central African Republic";
                break;
            case "td":
                this.value3 = "TCD";
                this.code = 148;
                this.name = "Chad";
                break;
            case "cl":
                this.value3 = "CHL";
                this.code = 152;
                this.name = "Chile";
                break;
            case "cn":
                this.value3 = "CHN";
                this.code = 156;
                this.name = "China";
                break;
            case "cx":
                this.value3 = "CXR";
                this.code = 162;
                this.name = "Christmas Island";
                break;
            case "cc":
                this.value3 = "CCK";
                this.code = 166;
                this.name = "The Cocos (Keeling) Islands";
                break;
            case "co":
                this.value3 = "COL";
                this.code = 170;
                this.name = "Colombia";
                break;
            case "km":
                this.value3 = "COM";
                this.code = 174;
                this.name = "The Comoros";
                break;
            case "cd":
                this.value3 = "COD";
                this.code = 180;
                this.name = "The Democratic Republic of the Congo";
                break;
            case "cg":
                this.value3 = "COG";
                this.code = 178;
                this.name = "The Congo";
                break;
            case "ck":
                this.value3 = "COK";
                this.code = 184;
                this.name = "The Cook Islands";
                break;
            case "cr":
                this.value3 = "CRI";
                this.code = 188;
                this.name = "Costa Rica";
                break;
            case "ci":
                this.value3 = "CIV";
                this.code = 384;
                this.name = "Cote d'Ivoire";
                break;
            case "hr":
                this.value3 = "HRV";
                this.code = 191;
                this.name = "Croatia";
                break;
            case "cu":
                this.value3 = "CUB";
                this.code = 192;
                this.name = "Cuba";
                break;
            case "cw":
                this.value3 = "CUW";
                this.code = 531;
                this.name = "Curacao";
                break;
            case "cy":
                this.value3 = "CYP";
                this.code = 196;
                this.name = "Cyprus";
                break;
            case "cz":
                this.value3 = "CZE";
                this.code = 203;
                this.name = "Czechia";
                break;
            case "dk":
                this.value3 = "DNK";
                this.code = 208;
                this.name = "Denmark";
                break;
            case "dj":
                this.value3 = "DJI";
                this.code = 262;
                this.name = "Djibouti";
                break;
            case "dm":
                this.value3 = "DMA";
                this.code = 212;
                this.name = "Dominica";
                break;
            case "do":
                this.value3 = "DOM";
                this.code = 214;
                this.name = "The Dominican Republic";
                break;
            case "ec":
                this.value3 = "ECU";
                this.code = 218;
                this.name = "Ecuador";
                break;
            case "eg":
                this.value3 = "EGY";
                this.code = 818;
                this.name = "Egypt";
                break;
            case "sv":
                this.value3 = "SLV";
                this.code = 222;
                this.name = "El Salvador";
                break;
            case "gq":
                this.value3 = "GNQ";
                this.code = 226;
                this.name = "Equatorial Guinea";
                break;
            case "er":
                this.value3 = "ERI";
                this.code = 232;
                this.name = "Eritrea";
                break;
            case "ee":
                this.value3 = "EST";
                this.code = 233;
                this.name = "Estonia";
                break;
            case "et":
                this.value3 = "ETH";
                this.code = 231;
                this.name = "Ethiopia";
                break;
            case "fk":
                this.value3 = "FLK";
                this.code = 238;
                this.name = "The Falkland Islands (Malvinas)";
                break;
            case "fo":
                this.value3 = "FRO";
                this.code = 234;
                this.name = "The Faroe Islands";
                break;
            case "fj":
                this.value3 = "FJI";
                this.code = 242;
                this.name = "Fiji";
                break;
            case "fi":
                this.value3 = "FIN";
                this.code = 246;
                this.name = "Finland";
                break;
            case "fr":
                this.value3 = "FRA";
                this.code = 250;
                this.name = "France";
                break;
            case "gf":
                this.value3 = "GUF";
                this.code = 254;
                this.name = "French Guiana";
                break;
            case "pf":
                this.value3 = "PYF";
                this.code = 258;
                this.name = "French Polynesia";
                break;
            case "tf":
                this.value3 = "ATF";
                this.code = 260;
                this.name = "The French Southern Territories";
                break;
            case "ga":
                this.value3 = "GAB";
                this.code = 266;
                this.name = "Gabon";
                break;
            case "gm":
                this.value3 = "GMB";
                this.code = 270;
                this.name = "The Gambia";
                break;
            case "ge":
                this.value3 = "GEO";
                this.code = 268;
                this.name = "Georgia";
                break;
            case "de":
                this.value3 = "DEU";
                this.code = 276;
                this.name = "Germany";
                break;
            case "gh":
                this.value3 = "GHA";
                this.code = 288;
                this.name = "Ghana";
                break;
            case "gi":
                this.value3 = "GIB";
                this.code = 292;
                this.name = "Gibraltar";
                break;
            case "gr":
                this.value3 = "GRC";
                this.code = 300;
                this.name = "Greece";
                break;
            case "gl":
                this.value3 = "GRL";
                this.code = 304;
                this.name = "Greenland";
                break;
            case "gd":
                this.value3 = "GRD";
                this.code = 308;
                this.name = "Grenada";
                break;
            case "gp":
                this.value3 = "GLP";
                this.code = 312;
                this.name = "Guadeloupe";
                break;
            case "gu":
                this.value3 = "GUM";
                this.code = 316;
                this.name = "Guam";
                break;
            case "gt":
                this.value3 = "GTM";
                this.code = 320;
                this.name = "Guatemala";
                break;
            case "gg":
                this.value3 = "GGY";
                this.code = 831;
                this.name = "Guernsey";
                break;
            case "gn":
                this.value3 = "GIN";
                this.code = 324;
                this.name = "Guinea";
                break;
            case "gw":
                this.value3 = "GNB";
                this.code = 624;
                this.name = "Guinea-Bissau";
                break;
            case "gy":
                this.value3 = "GUY";
                this.code = 328;
                this.name = "Guyana";
                break;
            case "ht":
                this.value3 = "HTI";
                this.code = 332;
                this.name = "Haiti";
                break;
            case "hm":
                this.value3 = "HMD";
                this.code = 334;
                this.name = "Heard Island and McDonald Islands";
                break;
            case "va":
                this.value3 = "VAT";
                this.code = 336;
                this.name = "The Holy See";
                break;
            case "hn":
                this.value3 = "HND";
                this.code = 340;
                this.name = "Honduras";
                break;
            case "hk":
                this.value3 = "HKG";
                this.code = 344;
                this.name = "Hong Kong";
                break;
            case "hu":
                this.value3 = "HUN";
                this.code = 348;
                this.name = "Hungary";
                break;
            case "is":
                this.value3 = "ISL";
                this.code = 352;
                this.name = "Iceland";
                break;
            case "in":
                this.value3 = "IND";
                this.code = 356;
                this.name = "India";
                break;
            case "id":
                this.value3 = "IDN";
                this.code = 360;
                this.name = "Indonesia";
                break;
            case "ir":
                this.value3 = "IRN";
                this.code = 364;
                this.name = "Islamic Republic of Iran";
                break;
            case "iq":
                this.value3 = "IRQ";
                this.code = 368;
                this.name = "Iraq";
                break;
            case "ie":
                this.value3 = "IRL";
                this.code = 372;
                this.name = "Ireland";
                break;
            case "im":
                this.value3 = "IMN";
                this.code = 833;
                this.name = "Isle of Man";
                break;
            case "il":
                this.value3 = "ISR";
                this.code = 376;
                this.name = "Israel";
                break;
            case "it":
                this.value3 = "ITA";
                this.code = 380;
                this.name = "Italy";
                break;
            case "jm":
                this.value3 = "JAM";
                this.code = 388;
                this.name = "Jamaica";
                break;
            case "jp":
                this.value3 = "JPN";
                this.code = 392;
                this.name = "Japan";
                break;
            case "je":
                this.value3 = "JEY";
                this.code = 832;
                this.name = "Jersey";
                break;
            case "jo":
                this.value3 = "JOR";
                this.code = 400;
                this.name = "Jordan";
                break;
            case "kz":
                this.value3 = "KAZ";
                this.code = 398;
                this.name = "Kazakhstan";
                break;
            case "ke":
                this.value3 = "KEN";
                this.code = 404;
                this.name = "Kenya";
                break;
            case "ki":
                this.value3 = "KIR";
                this.code = 296;
                this.name = "Kiribati";
                break;
            case "kp":
                this.value3 = "PRK";
                this.code = 408;
                this.name = "The Democratic People's Republic of Korea (North)";
                break;
            case "kr":
                this.value3 = "KOR";
                this.code = 410;
                this.name = "The Republic of Korea (South)";
                break;
            case "kw":
                this.value3 = "KWT";
                this.code = 414;
                this.name = "Kuwait";
                break;
            case "kg":
                this.value3 = "KGZ";
                this.code = 417;
                this.name = "Kyrgyzstan";
                break;
            case "la":
                this.value3 = "LAO";
                this.code = 418;
                this.name = "The Lao People's Democratic Republic";
                break;
            case "lv":
                this.value3 = "LVA";
                this.code = 428;
                this.name = "Latvia";
                break;
            case "lb":
                this.value3 = "LBN";
                this.code = 422;
                this.name = "Lebanon";
                break;
            case "ls":
                this.value3 = "LSO";
                this.code = 426;
                this.name = "Lesotho";
                break;
            case "lr":
                this.value3 = "LBR";
                this.code = 430;
                this.name = "Liberia";
                break;
            case "ly":
                this.value3 = "LBY";
                this.code = 434;
                this.name = "Libya";
                break;
            case "li":
                this.value3 = "LIE";
                this.code = 438;
                this.name = "Liechtenstein";
                break;
            case "lt":
                this.value3 = "LTU";
                this.code = 440;
                this.name = "Lithuania";
                break;
            case "lu":
                this.value3 = "LUX";
                this.code = 442;
                this.name = "Luxembourg";
                break;
            case "mo":
                this.value3 = "MAC";
                this.code = 446;
                this.name = "Macau";
                break;
            case "mk":
                this.value3 = "MKD";
                this.code = 807;
                this.name = "Macedonia (the former Republic of Yugoslav";
                break;
            case "mg":
                this.value3 = "MDG";
                this.code = 450;
                this.name = "Madagascar";
                break;
            case "mw":
                this.value3 = "MWI";
                this.code = 454;
                this.name = "Malawi";
                break;
            case "my":
                this.value3 = "MYS";
                this.code = 458;
                this.name = "Malaysia";
                break;
            case "mv":
                this.value3 = "MDV";
                this.code = 462;
                this.name = "Maldives";
                break;
            case "ml":
                this.value3 = "MLI";
                this.code = 466;
                this.name = "Mali";
                break;
            case "mt":
                this.value3 = "MLT";
                this.code = 470;
                this.name = "Malta";
                break;
            case "mh":
                this.value3 = "MHL";
                this.code = 584;
                this.name = "The Marshall Islands";
                break;
            case "mq":
                this.value3 = "MTQ";
                this.code = 474;
                this.name = "Martinique";
                break;
            case "mr":
                this.value3 = "MRT";
                this.code = 478;
                this.name = "Mauritania";
                break;
            case "mu":
                this.value3 = "MUS";
                this.code = 480;
                this.name = "Mauritius";
                break;
            case "yt":
                this.value3 = "MYT";
                this.code = 175;
                this.name = "Mayotte";
                break;
            case "mx":
                this.value3 = "MEX";
                this.code = 484;
                this.name = "Mexico";
                break;
            case "fm":
                this.value3 = "FSM";
                this.code = 583;
                this.name = "The Federated States of Micronesia";
                break;
            case "md":
                this.value3 = "MDA";
                this.code = 498;
                this.name = "The Republic of Moldova";
                break;
            case "mc":
                this.value3 = "MCO";
                this.code = 492;
                this.name = "Monaco";
                break;
            case "mn":
                this.value3 = "MNG";
                this.code = 496;
                this.name = "Mongolia";
                break;
            case "me":
                this.value3 = "MNE";
                this.code = 499;
                this.name = "Montenegro";
                break;
            case "ms":
                this.value3 = "MSR";
                this.code = 500;
                this.name = "Montserrat";
                break;
            case "ma":
                this.value3 = "MAR";
                this.code = 504;
                this.name = "Morocco";
                break;
            case "mz":
                this.value3 = "MOZ";
                this.code = 508;
                this.name = "Mozambique";
                break;
            case "mm":
                this.value3 = "MMR";
                this.code = 104;
                this.name = "Myanmar";
                break;
            case "na":
                this.value3 = "NAM";
                this.code = 516;
                this.name = "Namibia";
                break;
            case "nr":
                this.value3 = "NRU";
                this.code = 520;
                this.name = "Nauru";
                break;
            case "np":
                this.value3 = "NPL";
                this.code = 524;
                this.name = "Nepal";
                break;
            case "nl":
                this.value3 = "NLD";
                this.code = 528;
                this.name = "The Netherlands";
                break;
            case "nc":
                this.value3 = "NCL";
                this.code = 540;
                this.name = "New Caledonia";
                break;
            case "nz":
                this.value3 = "NZL";
                this.code = 554;
                this.name = "New Zealand";
                break;
            case "ni":
                this.value3 = "NIC";
                this.code = 558;
                this.name = "Nicaragua";
                break;
            case "ne":
                this.value3 = "NER";
                this.code = 562;
                this.name = "The Niger";
                break;
            case "ng":
                this.value3 = "NGA";
                this.code = 566;
                this.name = "Nigeria";
                break;
            case "nu":
                this.value3 = "NIU";
                this.code = 570;
                this.name = "Niue";
                break;
            case "nf":
                this.value3 = "NFK";
                this.code = 574;
                this.name = "Norfolk Island";
                break;
            case "mp":
                this.value3 = "MNP";
                this.code = 580;
                this.name = "The Northern Mariana Islands";
                break;
            case "no":
                this.value3 = "NOR";
                this.code = 578;
                this.name = "Norway";
                break;
            case "om":
                this.value3 = "OMN";
                this.code = 512;
                this.name = "Oman";
                break;
            case "pk":
                this.value3 = "PAK";
                this.code = 586;
                this.name = "Pakistan";
                break;
            case "pw":
                this.value3 = "PLW";
                this.code = 585;
                this.name = "Palau";
                break;
            case "ps":
                this.value3 = "PSE";
                this.code = 275;
                this.name = "State of Palestine";
                break;
            case "pa":
                this.value3 = "PAN";
                this.code = 591;
                this.name = "Panama";
                break;
            case "pg":
                this.value3 = "PNG";
                this.code = 598;
                this.name = "Papua New Guinea";
                break;
            case "py":
                this.value3 = "PRY";
                this.code = 600;
                this.name = "Paraguay";
                break;
            case "pe":
                this.value3 = "PER";
                this.code = 604;
                this.name = "Peru";
                break;
            case "ph":
                this.value3 = "PHL";
                this.code = 608;
                this.name = "The Philippines";
                break;
            case "pn":
                this.value3 = "PCN";
                this.code = 612;
                this.name = "Pitcairn";
                break;
            case "pl":
                this.value3 = "POL";
                this.code = 616;
                this.name = "Poland";
                break;
            case "pt":
                this.value3 = "PRT";
                this.code = 620;
                this.name = "Portugal";
                break;
            case "pr":
                this.value3 = "PRI";
                this.code = 630;
                this.name = "Puerto Rico";
                break;
            case "qa":
                this.value3 = "QAT";
                this.code = 634;
                this.name = "Qatar";
                break;
            case "re":
                this.value3 = "REU";
                this.code = 638;
                this.name = "Reunion";
                break;
            case "ro":
                this.value3 = "ROU";
                this.code = 642;
                this.name = "Romania";
                break;
            case "ru":
                this.value3 = "RUS";
                this.code = 643;
                this.name = "The Russian Federation";
                break;
            case "rw":
                this.value3 = "RWA";
                this.code = 646;
                this.name = "Rwanda";
                break;
            case "bl":
                this.value3 = "BLM";
                this.code = 652;
                this.name = "Saint Barthelemy";
                break;
            case "sh":
                this.value3 = "SHN";
                this.code = 654;
                this.name = "Saint Helena, Ascension and Tristan da Cunha";
                break;
            case "kn":
                this.value3 = "KNA";
                this.code = 659;
                this.name = "Saint Kitts and Nevis";
                break;
            case "lc":
                this.value3 = "LCA";
                this.code = 662;
                this.name = "Saint Lucia";
                break;
            case "mf":
                this.value3 = "MAF";
                this.code = 663;
                this.name = "Saint Martin (French Part)";
                break;
            case "pm":
                this.value3 = "SPM";
                this.code = 666;
                this.name = "Saint Pierre and Miquelon";
                break;
            case "vc":
                this.value3 = "VCT";
                this.code = 670;
                this.name = "Saint Vincent and the Grenadines";
                break;
            case "ws":
                this.value3 = "WSM";
                this.code = 882;
                this.name = "Samoa";
                break;
            case "sm":
                this.value3 = "SMR";
                this.code = 674;
                this.name = "San Marino";
                break;
            case "st":
                this.value3 = "STP";
                this.code = 678;
                this.name = "Sao Tome and Principe";
                break;
            case "sa":
                this.value3 = "SAU";
                this.code = 682;
                this.name = "Saudi Arabia";
                break;
            case "sn":
                this.value3 = "SEN";
                this.code = 686;
                this.name = "Senegal";
                break;
            case "rs":
                this.value3 = "SRB";
                this.code = 688;
                this.name = "Serbia";
                break;
            case "sc":
                this.value3 = "SYC";
                this.code = 690;
                this.name = "Seychelles";
                break;
            case "sl":
                this.value3 = "SLE";
                this.code = 694;
                this.name = "Sierra Leone";
                break;
            case "sg":
                this.value3 = "SGP";
                this.code = 702;
                this.name = "Singapore";
                break;
            case "sx":
                this.value3 = "SXM";
                this.code = 534;
                this.name = "Sint Maarten (Dutch Part)";
                break;
            case "sk":
                this.value3 = "SVK";
                this.code = 703;
                this.name = "Slovakia";
                break;
            case "si":
                this.value3 = "SVN";
                this.code = 705;
                this.name = "Slovenia";
                break;
            case "sb":
                this.value3 = "SLB";
                this.code = 90;
                this.name = "Solomon Islands";
                break;
            case "so":
                this.value3 = "SOM";
                this.code = 706;
                this.name = "Somalia";
                break;
            case "za":
                this.value3 = "ZAF";
                this.code = 710;
                this.name = "South Africa";
                break;
            case "gs":
                this.value3 = "SGS";
                this.code = 239;
                this.name = "South Georgia and the South Sandwich Islands";
                break;
            case "ss":
                this.value3 = "SSD";
                this.code = 728;
                this.name = "South Sudan";
                break;
            case "es":
                this.value3 = "ESP";
                this.code = 724;
                this.name = "Spain";
                break;
            case "lk":
                this.value3 = "LKA";
                this.code = 144;
                this.name = "Sri Lanka";
                break;
            case "sd":
                this.value3 = "SDN";
                this.code = 729;
                this.name = "The Sudan";
                break;
            case "sr":
                this.value3 = "SUR";
                this.code = 740;
                this.name = "Suriname";
                break;
            case "sj":
                this.value3 = "SJM";
                this.code = 744;
                this.name = "Svalbard and Jan Mayen";
                break;
            case "sz":
                this.value3 = "SWZ";
                this.code = 748;
                this.name = "Swaziland";
                break;
            case "se":
                this.value3 = "SWE";
                this.code = 752;
                this.name = "Sweden";
                break;
            case "ch":
                this.value3 = "CHE";
                this.code = 756;
                this.name = "Switzerland";
            case "sy":
                this.value3 = "SYR";
                this.code = 760;
                this.name = "Syrian Arab Republic";
            case "tw":
                this.value3 = "TWN";
                this.code = 158;
                this.name = "Taiwan (Province of China)";
            case "tj":
                this.value3 = "TJK";
                this.code = 762;
                this.name = "Tajikistan";
            case "tz":
                this.value3 = "TZA";
                this.code = 834;
                this.name = "United Republic of Tanzania";
            case "th":
                this.value3 = "THA";
                this.code = 764;
                this.name = "Thailand";
            case "tl":
                this.value3 = "TLS";
                this.code = 626;
                this.name = "Timor-Leste";
            case "tg":
                this.value3 = "TGO";
                this.code = 768;
                this.name = "Togo";
            case "tk":
                this.value3 = "TKL";
                this.code = 772;
                this.name = "Tokelau";
            case "to":
                this.value3 = "TON";
                this.code = 776;
                this.name = "Tonga";
            case "tt":
                this.value3 = "TTO";
                this.code = 780;
                this.name = "Trinidad and Tobago";
            case "tn":
                this.value3 = "TUN";
                this.code = 788;
                this.name = "Tunisia";
            case "tr":
                this.value3 = "TUR";
                this.code = 792;
                this.name = "Turkey";
            case "tm":
                this.value3 = "TKM";
                this.code = 795;
                this.name = "Turkmenistan";
            case "tc":
                this.value3 = "TCA";
                this.code = 796;
                this.name = "The Turks and Caicos Islands";
            case "tv":
                this.value3 = "TUV";
                this.code = 798;
                this.name = "Tuvalu";
            case "ug":
                this.value3 = "UGA";
                this.code = 800;
                this.name = "Uganda";
            case "ua":
                this.value3 = "UKR";
                this.code = 804;
                this.name = "Ukraine";
            case "ae":
                this.value3 = "ARE";
                this.code = 784;
                this.name = "The United Arab Emirates";
            case "gb":
                this.value3 = "GBR";
                this.code = 826;
                this.name = "The United Kingdom of Great Britain and Northern "
                            + "Ireland";
            case "um":
                this.value3 = "UMI";
                this.code = 581;
                this.name = "The United States Minor Outlying Islands";
            case "us":
                this.value3 = "USA";
                this.code = 840;
                this.name = "The United States of America";
            case "uy":
                this.value3 = "URY";
                this.code = 858;
                this.name = "Uruguay";
            case "uz":
                this.value3 = "UZB";
                this.code = 860;
                this.name = "Uzbekistan";
            case "vu":
                this.value3 = "VUT";
                this.code = 548;
                this.name = "Vanuatu";
            case "ve":
                this.value3 = "VEN";
                this.code = 862;
                this.name = "Bolivarian Republic of Venezuela";
            case "vn":
                this.value3 = "VNM";
                this.code = 704;
                this.name = "Viet Nam";
            case "vg":
                this.value3 = "VGB";
                this.code = 92;
                this.name = "British Virgin Islands";
            case "vi":
                this.value3 = "VIR";
                this.code = 850;
                this.name = "U.S. Virgin Islands";
            case "wf":
                this.value3 = "WLF";
                this.code = 876;
                this.name = "Wallis and Futuna";
            case "eh":
                this.value3 = "ESH";
                this.code = 732;
                this.name = "Western Sahara";
            case "ye":
                this.value3 = "YEM";
                this.code = 887;
                this.name = "Yemen";
            case "zm":
                this.value3 = "ZMB";
                this.code = 894;
                this.name = "Zambia";
            case "zw":
                this.value3 = "ZWE";
                this.code = 716;
                this.name = "Zimbabwe";
            default:
                this.value3 = "UNK";
                this.code = 0;
                this.name = "Unknown";
        }
    }
}
