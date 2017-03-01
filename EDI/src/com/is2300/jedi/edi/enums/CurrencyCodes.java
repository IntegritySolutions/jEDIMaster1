/* {CurrencyCodes.java}
 * This enumeration provides access to all of the ISO Standard currency codes 
 * for the currencies of the world.
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
 * <code>CurrencyCodes</code> is an enumeration of <tt>java.lang.String</tt>s 
 * for accessing the various currency codes and their definitions that could 
 * appear in EDI
 * transmissions.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public enum CurrencyCodes {
    UAE_DIRHAM("AED"),
    AFGHANISTAN_AFGHANI("AFN"),
    ALBANIAN_LEK("ALL"),
    ARMENIA_DRAM("AMD"),
    NETHERLANDS_ANTILLES_GUILDER("ANG"),
    ANGOLA_KWANZA("AOA"),
    ARGENTINA_PESO("ARS"),
    AUSTRALIA_DOLLAR("AUD"),
    ARUBA_GUILDER("AWG"),
    AZERBAIJAN_NEW_MANAT("AZN"),
    BOSNIA_HERZOGOVINA_CONVERTIBLE_MARKA("BAM"),
    BARBADOS_DOLLAR("BBD"),
    BANGLADESH_TAKA("BDT"),
    BULGARIA_LEV("BGN"),
    BAHRAIN_DINAR("BHD"),
    BURUNDI_FRANC("BIF"),
    BURMUDA_DOLLAR("BMD"),
    BRUNEI_DAUSSALAM_DOLLAR("BND"),
    BOLIVIA_BOLIVIANO("BOB"),
    BRAZIL_REAL("BRL"),
    BAHAMAS_DOLLAR("BSD"),
    BHUTAN_NGULTRUM("BTN"),
    BOTSWANA_PULA("BWP"),
    BELARUS_RUBLE("BYN"),
    BELIZE_DOLLAR("BZD"),
    CANADIAN_DOLLAR("CAD"),
    CONGO_KINSHASA_FRANC("CDF"),
    SWITZERLAND_FRANC("CHF"),
    CHILE_PESO("CLP"),
    CHINA_YUAN_RENMINBI("CNY"),
    COLOMBIA_PESO("COP"),
    COSTA_RICA_COLON("CRC"),
    CUBA_CONVERTIBLE_PESO("CUC"),
    CUBA_PESO("CUP"),
    CAPE_VERDE_ESCUDO("CVE"),
    CZECH_REPUBLIC_KORUNA("CZK"),
    DJIBOUTI_FRANC("DJF"),
    DENMARK_KRONE("DKK"),
    DOMINICAN_REPUBLIC_PESO("DOP"),
    ALGERIA_DINAR("DZD"),
    EGYPT_POUND("EGP"),
    ERITREA_NAKFA("ERN"),
    ETHIOPIA_BIRR("ETB"),
    EURO_MEMBER_COUNTRIES("EUR"),
    FIJI_DOLLAR("FJD"),
    FALKLAND_ISLANDS_MALVINAS_POUND("FKP"),
    UNITED_KINGDOM_POUND("GBP"),
    GEORGIA_LARI("GEL"),
    GUEMSEY_POUND("GGP"),
    GHANA_CEDI("GHS"),
    GIBRALTAR_POUND("GIP"),
    GAMBIA_DALASI("GMD"),
    GUINEA_FRANC("GNF"),
    GUATEMALA_QUETZAL("GTQ"),
    GUYANA_DOLLAR("GYD"),
    HONG_KONG_DOLLAR("HKD"),
    HONDURAS_LEMPIRA("HNL"),
    CROATIA_KUNA("HRK"),
    HAITI_GOURDE("HTG"),
    HUNGARY_FORINT("HUF"),
    INDONESIA_RUPIAH("IDR"),
    ISRAEL_SHEKEL("ILS"),
    ISLE_OF_MAN_POUND("IMP"),
    INDIA_RUPEE("INR"),
    IRAQ_DINAR("IQD"),
    IRAN_RIAL("IRR"),
    ICELAND_KRONA("ISK"),
    JERSEY_POUND("JEP"),
    JAMAICA_DOLLAR("JMD"),
    JORDAN_DINAR("JOD"),
    JAPAN_YEN("JPY"),
    KENYA_SHILLING("KES"),
    KYRGYZSTAN_SOM("KGS"),
    CAMBODIA_RIEL("KHR"),
    COMOROS_FRANC("KMF"),
    KOREA_NORTH_WON("KPW"),
    KOREA_SOUTH_WON("KRW"),
    KUWAIT_DINAR("KWD"),
    CAYMAN_ISLANDS_DOLLAR("KYD"),
    KAZAKHSTAN_TENGE("KZT"),
    LAOS_KIP("LAK"),
    LEBANON_POUND("LBP"),
    SRI_LANKA_RUPEE("LKR"),
    LIBERIA_DOLLAR("LRD"),
    LESOTHO_LOTI("LSL"),
    LIBYA_DINAR("LYD"),
    MOROCCO_DIRHAM("MAD"),
    MOLDOVA_LEU("MDL"),
    MADAGASCAR_ARIARY("MGA"),
    MACEDONIA_DENAR("MDK"),
    MYANMAR_BURMA_KYAT("MMK"),
    MONGOLIA_TUGHRIK("MNT"),
    MACAU_PATACA("MOP"),
    MAURITANIA_OUGUIYA("MRO"),
    MAURITIUS_RUPEE("MUR"),
    MALDIVES_RUFIYAA("MVR"),
    MALAWI_KWACHA("MWK"),
    MEXICO_PESO("MXN"),
    MALAYSIA_RINGGIT("MYR"),
    MOZAMBIQUE_METICAL("MZN"),
    NAMIBIA_DOLLAR("NAD"),
    NIGERIA_NAIRA("NGN"),
    NICARAQUA_CORDOBA("NIO"),
    NORWAY_KRONE("NOK"),
    NEPAL_RUPEE("NPR"),
    NEW_ZEALAND_DOLLAR("NZD"),
    OMAN_RIAL("OMR"),
    PANAMA_BALBOA("PAB"),
    PERU_SOL("PEN"),
    PAPUA_NEW_GUINEA_KINA("PGK"),
    PHILIPPINES_PESO("PHP"),
    PAKISTAN_RUPEE("PKR"),
    POLAND_ZLOTY("PLN"),
    PARAGUAY_GUARANI("PYG"),
    QATAR_RIYAL("QAR"),
    ROMANIA_NEW_LEU("RON"),
    SERBIA_DINAR("RSD"),
    RUSSIA_RUBLE("RUB"),
    RWANDA_FRANC("RWF"),
    SAUDI_ARABIA_RIYAL("SAR"),
    SOLOMON_ISLANDS_DOLLAR("SBD"),
    SEYCHELLES_RUPEE("SCR"),
    SUDAN_POUND("SDG"),
    SWEDEN_KRONA("SEK"),
    SINGAPORE_DOLLAR("SGD"),
    SAINT_HELENA_POUND("SHP"),
    SIERRA_LEONE_LEONE("SLL"),
    SOMALIA_SHILLING("SOS"),
    SEBORGA_LUIGINO("SPL"),
    SURINAME_DOLLAR("SRD"),
    SAO_TOME_AND_PRINCIPE_DOBRA("STD"),
    EL_SALVADOR_COLON("SVC"),
    SYRIA_POUND("SYP"),
    SWAZILAND_LILANGENI("SZL"),
    THAILAND_BAHT("THB"),
    TAJIKISTAN_SOMONI("TSJ"),
    TURKMENISTAN_MANAT("TMT"),
    TUNISIA_DINAR("TND"),
    TONGA_PAANGA("TOP"),
    TURKEY_LIRA("TRY"),
    TRINIDAD_AND_TOBAGO_DOLLAR("TTD"),
    TUVALU_DOLLAR("TVD"),
    TAIWAN_NEW_DOLLAR("TWD"),
    TANZANIA_SHILLING("UGX"),
    UKRAINE_HRYVNIA("UAH"),
    UGANDA_SHILLING("UGX"),
    UNITED_STATES_DOLLAR("USD"),
    URUGUAY_PESO("UYU"),
    UZBEKISTAN_SOM("UZS"),
    VENEZUELA_BOLIVAR("VEF"),
    VIET_NAM_DONG("VND"),
    VANUATU_VATU("VUV"),
    SAMOA_TALA("WST"),
    COMMUAUTE_FINANCIERE_AFRICAINE_BEAC_CFA_FRANC("XAF"),
    EAST_CARIBBEAN_DOLLAR("XCD"),
    INTERNATIONAL_MONETARY_FUND_SPECIAL_DRAWING_RIGHTS("XDR"),
    COMMUNAUTE_FINANCIERE_AFRICAINE_BCEAO_FRANC("XOF"),
    COMPTOIR_FRANCAIS_DU_PACIFIQUE_FRANC("XPF"),
    YEMEN_RIAL("YER"),
    SOUTH_AFRICA_RAND("ZAR"),
    ZAMBIA_KWACHA("ZMW"),
    ZIMBABWE_DOLLAR("ZWD");
    
    private String value;
    private String definition;
    
    private CurrencyCodes(String val) {
        this.value = val;
    }
    
    /**
     * Gets the current Currency Code as a <tt>java.lang.String</tt>.
     * 
     * @return java.lang.String of the current Currency Code
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Gets the definition of the currently set Currency Code.
     * 
     * @return java.lang.String definition of the current Currency Code
     */
    public String getDefinition() {
        // Return our definition.
        return this.definition;
    }

    /**
     * Gets the definition of the specified Currency Code.
     * 
     * @param code the java.lang.String of the Currency Code to look up
     * @return the definition of the specified Currency Code string
     */
    public String getDefinition(String code) {
        String retVal = "";
        switch (code) {
            case "AED":
                retVal = "United Arab Emirates Dirham";
                break;
            case "AFN":
                retVal = "Afghanistan Afghani";
                break;
            case "ALL":
                retVal = "Albania Lek";
                break;
            case "AMD":
                retVal = "Armenia Dram";
                break;
            case "ANG":
                retVal = "Netherlands Antilles Guilder";
                break;
            case "AOA":
                retVal = "Angola Kwanza";
                break;
            case "ARS":
                retVal = "Argentina Peso";
                break;
            case "AUD":
                retVal = "Australian Dollar";
                break;
            case "AWG":
                retVal = "Aruba Guilder";
                break;
            case "AZN":
                retVal = "Azerbaijan New Manat";
                break;
            case "BAM":
                retVal = "Bosnia and Herzegovina Convertible Marka";
                break;
            case "BBD":
                retVal = "Barbados Dollar";
                break;
            case "BDT":
                retVal = "Bangladesh Taka";
                break;
            case "BGN":
                retVal = "Bulgaria Lev";
                break;
            case "BHD":
                retVal = "Bahrain Dinar";
                break;
            case "BIF":
                retVal = "Burundi Franc";
                break;
            case "BMD":
                retVal = "Bermuda Dollar";
                break;
            case "BND":
                retVal = "Brunei Darussalam Dollar";
                break;
            case "BOB":
                retVal = "Bolivia Boliviano";
                break;
            case "BRL":
                retVal = "Brazil Real";
                break;
            case "BSD":
                retVal = "Bahamas Dollar";
                break;
            case "BTN":
                retVal = "Bhutan Ngultrum";
                break;
            case "BWP":
                retVal = "Botswana Pula";
                break;
            case "BYN":
                retVal = "Belarus Ruble";
                break;
            case "BZD":
                retVal = "Belize Dollar";
                break;
            case "CAD":
                retVal = "Canadian Dollar";
                break;
            case "CDF":
                retVal = "Congo/Kinshasa Franc";
                break;
            case "CHF":
                retVal = "Switzerland Franc";
                break;
            case "CLP":
                retVal = "Chile Peso";
                break;
            case "CNY":
                retVal = "China Yuan Renminbi";
                break;
            case "COP":
                retVal = "Colombia Peso";
                break;
            case "CRC":
                retVal = "Costa Rica Colon";
                break;
            case "CUC":
                retVal = "Cuba Convertible Peso";
                break;
            case "CUP":
                retVal = "Cuba Peso";
                break;
            case "CVE":
                retVal = "Cape Verde Escudo";
                break;
            case "CZK":
                retVal = "Czech Republic Koruna";
                break;
            case "DJF":
                retVal = "Djibouti Franc";
                break;
            case "DKK":
                retVal = "Denmark Krone";
                break;
            case "DOP":
                retVal = "Dominican Republic Peso";
                break;
            case "DZD":
                retVal = "Algeria Dinar";
                break;
            case "EGP":
                retVal = "Egypt Pound";
                break;
            case "ERN":
                retVal = "Eritrea Nakfa";
                break;
            case "ETB":
                retVal = "Ethiopia Birr";
                break;
            case "EUR":
                retVal = "Euro Member Countries";
                break;
            case "FJD":
                retVal = "Fiji Dollar";
                break;
            case "FKP":
                retVal = "Faulkland Islands (Malvinas) Pound";
                break;
            case "GBP":
                retVal = "United Kingdom Pound";
                break;
            case "GEL":
                retVal = "Georgia Lari";
                break;
            case "GGP":
                retVal = "Guernsey Pound";
                break;
            case "GHS":
                retVal = "Ghana Cedi";
                break;
            case "GIP":
                retVal = "Gibraltar Pound";
                break;
            case "GMD":
                retVal = "Gambia Dalasi";
                break;
            case "GNF":
                retVal = "Guinea Franc";
                break;
            case "GTQ":
                retVal = "Guatemala Quetzal";
                break;
            case "GYD":
                retVal = "Guyana Dollar";
                break;
            case "HKD":
                retVal = "Hong Kong Dollar";
                break;
            case "HNL":
                retVal = "Honduras Lempira";
                break;
            case "HRK":
                retVal = "Croatia Kuna";
                break;
            case "HTG":
                retVal = "Haiti Gourde";
                break;
            case "HUF":
                retVal = "Hungary Forint";
                break;
            case "IDR":
                retVal = "Indonesia Rupiah";
                break;
            case "ILS":
                retVal = "Israel Shekel";
                break;
            case "IMP":
                retVal = "Isle of Man Pound";
                break;
            case "INR":
                retVal = "India Rupee";
                break;
            case "IQD":
                retVal = "Iraq Dinar";
                break;
            case "IRR":
                retVal = "Iran Rial";
                break;
            case "ISK":
                retVal = "Iceland Krona";
                break;
            case "JEP":
                retVal = "Jersey Pound";
                break;
            case "JMD":
                retVal = "Jamaica Dollar";
                break;
            case "JOD":
                retVal = "Jordan Dinar";
                break;
            case "JPY":
                retVal = "Japan Yen";
                break;
            case "KES":
                retVal = "Kenya Shilling";
                break;
            case "KGS":
                retVal = "Kyrgyzstan Som";
                break;
            case "KHR":
                retVal = "Cambodia Riel";
                break;
            case "KMF":
                retVal = "Comoros Franc";
                break;
            case "KPW":
                retVal = "North Korea Won";
                break;
            case "KRW":
                retVal = "South Korea Won";
                break;
            case "KWD":
                retVal = "Kuwait Dinar";
                break;
            case "KYD":
                retVal = "Cayman Islands Dollar";
                break;
            case "KZT":
                retVal = "Kazakhstan Tenge";
                break;
            case "LAK":
                retVal = "Laos Kip";
                break;
            case "LBP":
                retVal = "Lebanon Pound";
                break;
            case "LKR":
                retVal = "Si Lanka Rupee";
                break;
            case "LRD":
                retVal = "Liberia Dollar";
                break;
            case "LSL":
                retVal = "Lesotho Lati";
                break;
            case "LYD":
                retVal = "Libya Dinar";
                break;
            case "MAD":
                retVal = "Morocco Dirham";
                break;
            case "MDL":
                retVal = "Moldova Leu";
                break;
            case "MGA":
                retVal = "Madagascar Ariary";
                break;
            case "MKD":
                retVal = "Macedonia Denar";
                break;
            case "MMK":
                retVal = "Myanmar (Burma) Kyat";
                break;
            case "MNT":
                retVal = "Mongolia Tughrik";
                break;
            case "MOP":
                retVal = "Macau Pataca";
                break;
            case "MRO":
                retVal = "Mauritania Ouguiya";
                break;
            case "MUR":
                retVal = "Mauritius Rupee";
                break;
            case "MVR":
                retVal = "Maldives (Maldive Islands) Rufiyaa";
                break;
            case "MWK":
                retVal = "Malawi Kwacha";
                break;
            case "MXN":
                retVal = "Mexico Peso";
                break;
            case "MYR":
                retVal = "Malaysia Ringgit";
                break;
            case "MZN":
                retVal = "Mozambique Metical";
                break;
            case "NAD":
                retVal = "Namibia Dollar";
                break;
            case "NGN":
                retVal = "Nigeria Naira";
                break;
            case "NIO":
                retVal = "Nicaragua Cordoba";
                break;
            case "NOK":
                retVal = "Norway Krone";
                break;
            case "NPR":
                retVal = "Nepal Rupee";
                break;
            case "NZD":
                retVal = "New Zealand Dollar";
                break;
            case "OMR":
                retVal = "Oman Rial";
                break;
            case "PAB":
                retVal = "Panama Balboa";
                break;
            case "PEN":
                retVal = "Peru Sol";
                break;
            case "PGK":
                retVal = "Papua New Guinea Kina";
                break;
            case "PHP":
                retVal = "Philippines Peso";
                break;
            case "PKR":
                retVal = "Pakistan Rupee";
                break;
            case "PLN":
                retVal = "Poland Zloty";
                break;
            case "PYG":
                retVal = "Paraguay Guarani";
                break;
            case "QAR":
                retVal = "Qatar Riyal";
                break;
            case "RON":
                retVal = "Romania New Leu";
                break;
            case "RSD":
                retVal = "Serbia Dinar";
                break;
            case "RUB":
                retVal = "Russia Ruble";
                break;
            case "RWF":
                retVal = "Rwanda Franc";
                break;
            case "SAR":
                retVal = "Saudi Arabia Riyal";
                break;
            case "SBD":
                retVal = "Solomon Islands Dollar";
                break;
            case "SCR":
                retVal = "Seychelles Rupee";
                break;
            case "SDG":
                retVal = "Sudan Pound";
                break;
            case "SEK":
                retVal = "Sweden Krona";
                break;
            case "SGD":
                retVal = "Singapore Dollar";
                break;
            case "SHP":
                retVal = "Saint Helena Pound";
                break;
            case "SLL":
                retVal = "Sierra Leone Leone";
                break;
            case "SOS":
                retVal = "Somalia Shilling";
                break;
            case "SPL":
                retVal = "Seborga Luigino";
                break;
            case "SRD":
                retVal = "Suriname Dollar";
                break;
            case "STD":
                retVal = "Sao Tome and Principe Dobra";
                break;
            case "SVC":
                retVal = "El Salvador Colon";
                break;
            case "SYP":
                retVal = "Syria Pound";
                break;
            case "SZL":
                retVal = "Swaziland Lilangeni";
                break;
            case "THB":
                retVal = "Thailand Baht";
                break;
            case "TJS":
                retVal = "Tajikistan Somoni";
                break;
            case "TMT":
                retVal = "Turkmenistan Manat";
                break;
            case "TND":
                retVal = "Tunisia Dinar";
                break;
            case "TOP":
                retVal = "Tongo Pa'anga";
                break;
            case "TRY":
                retVal = "Turkey Lira";
                break;
            case "TTD":
                retVal = "Trinidad and Tobago Dollar";
                break;
            case "TVD":
                retVal = "Tuvalu Dollar";
                break;
            case "TWD":
                retVal = "Taiwan New Dollar";
                break;
            case "TZS":
                retVal = "Tanzania Shilling";
                break;
            case "UAH":
                retVal = "Ukraine Hryvnia";
                break;
            case "UGX":
                retVal = "Uganda Shilling";
                break;
            case "USD":
                retVal = "United States Dollar";
                break;
            case "UYU":
                retVal = "Uruguay Peso";
                break;
            case "UZS":
                retVal = "Uzbekistan Som";
                break;
            case "VEF":
                retVal = "Venezuela Bolivar";
                break;
            case "VND":
                retVal = "Viet Nam Dong";
                break;
            case "VUV":
                retVal = "Vanuatu Vatu";
                break;
            case "WST":
                retVal = "Samoa Tala";
                break;
            case "XAF":
                retVal = "Communaute Financiere Africaine (BEAC) CFA Franc";
                break;
            case "XCD":
                retVal = "East Caribbean Dollar";
                break;
            case "XDR":
                retVal = "International Monetary Fund (IMF) Special Drawing Rights";
                break;
            case "XOF":
                retVal = "Communaute Financiere Africaine (BCEAO) Franc";
                break;
            case "XPF":
                retVal = "Comptoirs Fancais du Pacifique (CFP) Franc";
                break;
            case "YER":
                retVal = "Yemen Rial";
                break;
            case "ZAR":
                retVal = "South Africa Rand";
                break;
            case "ZMW":
                retVal = "Zambia Kwacha";
                break;
            case "ZWD":
                retVal = "Zimbabwe Dollar";
                break;
            default:
                retVal = "Undefined Currency";
                break;
        }
        
        // Return our definition.
        return retVal;
    }
    
    /**
     * Private method to setup the data for this <tt>enum</tt>.
     */
    private void setup () {
        switch (this.value) {
            case "AED":
                this.definition = "United Arab Emirates Dirham";
                break;
            case "AFN":
                this.definition = "Afghanistan Afghani";
                break;
            case "ALL":
                this.definition = "Albania Lek";
                break;
            case "AMD":
                this.definition = "Armenia Dram";
                break;
            case "ANG":
                this.definition = "Netherlands Antilles Guilder";
                break;
            case "AOA":
                this.definition = "Angola Kwanza";
                break;
            case "ARS":
                this.definition = "Argentina Peso";
                break;
            case "AUD":
                this.definition = "Australian Dollar";
                break;
            case "AWG":
                this.definition = "Aruba Guilder";
                break;
            case "AZN":
                this.definition = "Azerbaijan New Manat";
                break;
            case "BAM":
                this.definition = "Bosnia and Herzegovina Convertible Marka";
                break;
            case "BBD":
                this.definition = "Barbados Dollar";
                break;
            case "BDT":
                this.definition = "Bangladesh Taka";
                break;
            case "BGN":
                this.definition = "Bulgaria Lev";
                break;
            case "BHD":
                this.definition = "Bahrain Dinar";
                break;
            case "BIF":
                this.definition = "Burundi Franc";
                break;
            case "BMD":
                this.definition = "Bermuda Dollar";
                break;
            case "BND":
                this.definition = "Brunei Darussalam Dollar";
                break;
            case "BOB":
                this.definition = "Bolivia Boliviano";
                break;
            case "BRL":
                this.definition = "Brazil Real";
                break;
            case "BSD":
                this.definition = "Bahamas Dollar";
                break;
            case "BTN":
                this.definition = "Bhutan Ngultrum";
                break;
            case "BWP":
                this.definition = "Botswana Pula";
                break;
            case "BYN":
                this.definition = "Belarus Ruble";
                break;
            case "BZD":
                this.definition = "Belize Dollar";
                break;
            case "CAD":
                this.definition = "Canadian Dollar";
                break;
            case "CDF":
                this.definition = "Congo/Kinshasa Franc";
                break;
            case "CHF":
                this.definition = "Switzerland Franc";
                break;
            case "CLP":
                this.definition = "Chile Peso";
                break;
            case "CNY":
                this.definition = "China Yuan Renminbi";
                break;
            case "COP":
                this.definition = "Colombia Peso";
                break;
            case "CRC":
                this.definition = "Costa Rica Colon";
                break;
            case "CUC":
                this.definition = "Cuba Convertible Peso";
                break;
            case "CUP":
                this.definition = "Cuba Peso";
                break;
            case "CVE":
                this.definition = "Cape Verde Escudo";
                break;
            case "CZK":
                this.definition = "Czech Republic Koruna";
                break;
            case "DJF":
                this.definition = "Djibouti Franc";
                break;
            case "DKK":
                this.definition = "Denmark Krone";
                break;
            case "DOP":
                this.definition = "Dominican Republic Peso";
                break;
            case "DZD":
                this.definition = "Algeria Dinar";
                break;
            case "EGP":
                this.definition = "Egypt Pound";
                break;
            case "ERN":
                this.definition = "Eritrea Nakfa";
                break;
            case "ETB":
                this.definition = "Ethiopia Birr";
                break;
            case "EUR":
                this.definition = "Euro Member Countries";
                break;
            case "FJD":
                this.definition = "Fiji Dollar";
                break;
            case "FKP":
                this.definition = "Faulkland Islands (Malvinas) Pound";
                break;
            case "GBP":
                this.definition = "United Kingdom Pound";
                break;
            case "GEL":
                this.definition = "Georgia Lari";
                break;
            case "GGP":
                this.definition = "Guernsey Pound";
                break;
            case "GHS":
                this.definition = "Ghana Cedi";
                break;
            case "GIP":
                this.definition = "Gibraltar Pound";
                break;
            case "GMD":
                this.definition = "Gambia Dalasi";
                break;
            case "GNF":
                this.definition = "Guinea Franc";
                break;
            case "GTQ":
                this.definition = "Guatemala Quetzal";
                break;
            case "GYD":
                this.definition = "Guyana Dollar";
                break;
            case "HKD":
                this.definition = "Hong Kong Dollar";
                break;
            case "HNL":
                this.definition = "Honduras Lempira";
                break;
            case "HRK":
                this.definition = "Croatia Kuna";
                break;
            case "HTG":
                this.definition = "Haiti Gourde";
                break;
            case "HUF":
                this.definition = "Hungary Forint";
                break;
            case "IDR":
                this.definition = "Indonesia Rupiah";
                break;
            case "ILS":
                this.definition = "Israel Shekel";
                break;
            case "IMP":
                this.definition = "Isle of Man Pound";
                break;
            case "INR":
                this.definition = "India Rupee";
                break;
            case "IQD":
                this.definition = "Iraq Dinar";
                break;
            case "IRR":
                this.definition = "Iran Rial";
                break;
            case "ISK":
                this.definition = "Iceland Krona";
                break;
            case "JEP":
                this.definition = "Jersey Pound";
                break;
            case "JMD":
                this.definition = "Jamaica Dollar";
                break;
            case "JOD":
                this.definition = "Jordan Dinar";
                break;
            case "JPY":
                this.definition = "Japan Yen";
                break;
            case "KES":
                this.definition = "Kenya Shilling";
                break;
            case "KGS":
                this.definition = "Kyrgyzstan Som";
                break;
            case "KHR":
                this.definition = "Cambodia Riel";
                break;
            case "KMF":
                this.definition = "Comoros Franc";
                break;
            case "KPW":
                this.definition = "North Korea Won";
                break;
            case "KRW":
                this.definition = "South Korea Won";
                break;
            case "KWD":
                this.definition = "Kuwait Dinar";
                break;
            case "KYD":
                this.definition = "Cayman Islands Dollar";
                break;
            case "KZT":
                this.definition = "Kazakhstan Tenge";
                break;
            case "LAK":
                this.definition = "Laos Kip";
                break;
            case "LBP":
                this.definition = "Lebanon Pound";
                break;
            case "LKR":
                this.definition = "Si Lanka Rupee";
                break;
            case "LRD":
                this.definition = "Liberia Dollar";
                break;
            case "LSL":
                this.definition = "Lesotho Lati";
                break;
            case "LYD":
                this.definition = "Libya Dinar";
                break;
            case "MAD":
                this.definition = "Morocco Dirham";
                break;
            case "MDL":
                this.definition = "Moldova Leu";
                break;
            case "MGA":
                this.definition = "Madagascar Ariary";
                break;
            case "MKD":
                this.definition = "Macedonia Denar";
                break;
            case "MMK":
                this.definition = "Myanmar (Burma) Kyat";
                break;
            case "MNT":
                this.definition = "Mongolia Tughrik";
                break;
            case "MOP":
                this.definition = "Macau Pataca";
                break;
            case "MRO":
                this.definition = "Mauritania Ouguiya";
                break;
            case "MUR":
                this.definition = "Mauritius Rupee";
                break;
            case "MVR":
                this.definition = "Maldives (Maldive Islands) Rufiyaa";
                break;
            case "MWK":
                this.definition = "Malawi Kwacha";
                break;
            case "MXN":
                this.definition = "Mexico Peso";
                break;
            case "MYR":
                this.definition = "Malaysia Ringgit";
                break;
            case "MZN":
                this.definition = "Mozambique Metical";
                break;
            case "NAD":
                this.definition = "Namibia Dollar";
                break;
            case "NGN":
                this.definition = "Nigeria Naira";
                break;
            case "NIO":
                this.definition = "Nicaragua Cordoba";
                break;
            case "NOK":
                this.definition = "Norway Krone";
                break;
            case "NPR":
                this.definition = "Nepal Rupee";
                break;
            case "NZD":
                this.definition = "New Zealand Dollar";
                break;
            case "OMR":
                this.definition = "Oman Rial";
                break;
            case "PAB":
                this.definition = "Panama Balboa";
                break;
            case "PEN":
                this.definition = "Peru Sol";
                break;
            case "PGK":
                this.definition = "Papua New Guinea Kina";
                break;
            case "PHP":
                this.definition = "Philippines Peso";
                break;
            case "PKR":
                this.definition = "Pakistan Rupee";
                break;
            case "PLN":
                this.definition = "Poland Zloty";
                break;
            case "PYG":
                this.definition = "Paraguay Guarani";
                break;
            case "QAR":
                this.definition = "Qatar Riyal";
                break;
            case "RON":
                this.definition = "Romania New Leu";
                break;
            case "RSD":
                this.definition = "Serbia Dinar";
                break;
            case "RUB":
                this.definition = "Russia Ruble";
                break;
            case "RWF":
                this.definition = "Rwanda Franc";
                break;
            case "SAR":
                this.definition = "Saudi Arabia Riyal";
                break;
            case "SBD":
                this.definition = "Solomon Islands Dollar";
                break;
            case "SCR":
                this.definition = "Seychelles Rupee";
                break;
            case "SDG":
                this.definition = "Sudan Pound";
                break;
            case "SEK":
                this.definition = "Sweden Krona";
                break;
            case "SGD":
                this.definition = "Singapore Dollar";
                break;
            case "SHP":
                this.definition = "Saint Helena Pound";
                break;
            case "SLL":
                this.definition = "Sierra Leone Leone";
                break;
            case "SOS":
                this.definition = "Somalia Shilling";
                break;
            case "SPL":
                this.definition = "Seborga Luigino";
                break;
            case "SRD":
                this.definition = "Suriname Dollar";
                break;
            case "STD":
                this.definition = "Sao Tome and Principe Dobra";
                break;
            case "SVC":
                this.definition = "El Salvador Colon";
                break;
            case "SYP":
                this.definition = "Syria Pound";
                break;
            case "SZL":
                this.definition = "Swaziland Lilangeni";
                break;
            case "THB":
                this.definition = "Thailand Baht";
                break;
            case "TJS":
                this.definition = "Tajikistan Somoni";
                break;
            case "TMT":
                this.definition = "Turkmenistan Manat";
                break;
            case "TND":
                this.definition = "Tunisia Dinar";
                break;
            case "TOP":
                this.definition = "Tongo Pa'anga";
                break;
            case "TRY":
                this.definition = "Turkey Lira";
                break;
            case "TTD":
                this.definition = "Trinidad and Tobago Dollar";
                break;
            case "TVD":
                this.definition = "Tuvalu Dollar";
                break;
            case "TWD":
                this.definition = "Taiwan New Dollar";
                break;
            case "TZS":
                this.definition = "Tanzania Shilling";
                break;
            case "UAH":
                this.definition = "Ukraine Hryvnia";
                break;
            case "UGX":
                this.definition = "Uganda Shilling";
                break;
            case "USD":
                this.definition = "United States Dollar";
                break;
            case "UYU":
                this.definition = "Uruguay Peso";
                break;
            case "UZS":
                this.definition = "Uzbekistan Som";
                break;
            case "VEF":
                this.definition = "Venezuela Bolivar";
                break;
            case "VND":
                this.definition = "Viet Nam Dong";
                break;
            case "VUV":
                this.definition = "Vanuatu Vatu";
                break;
            case "WST":
                this.definition = "Samoa Tala";
                break;
            case "XAF":
                this.definition = "Communaute Financiere Africaine (BEAC) CFA Franc";
                break;
            case "XCD":
                this.definition = "East Caribbean Dollar";
                break;
            case "XDR":
                this.definition = "International Monetary Fund (IMF) Special Drawing Rights";
                break;
            case "XOF":
                this.definition = "Communaute Financiere Africaine (BCEAO) Franc";
                break;
            case "XPF":
                this.definition = "Comptoirs Fancais du Pacifique (CFP) Franc";
                break;
            case "YER":
                this.definition = "Yemen Rial";
                break;
            case "ZAR":
                this.definition = "South Africa Rand";
                break;
            case "ZMW":
                this.definition = "Zambia Kwacha";
                break;
            case "ZWD":
                this.definition = "Zimbabwe Dollar";
                break;
            default:
                this.definition = "Undefined Currency";
                break;
        }
    }
}
