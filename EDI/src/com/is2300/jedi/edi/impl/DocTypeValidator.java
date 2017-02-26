/* {DocTypeValidator.java}
 * 
 * This class has one (1) public method to use to validate EDI document type
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
 * The <tt>DocTypeValidator</tt> class provides only one (1) public method,
 * by which the various document type classes can perform validation on the 
 * document type codes provided to them through the incoming EDI file segment
 * data fields.
 * <p>
 * There are almost 1,000 different EDI document types, so this class' 
 * <tt>validate()</tt> method has to work fairly hard to validate the provided
 * document type. EDI covers at least eight (8) different industries:
 * <ul>
 *  <li>Banking</li>
 *  <li>Financial Services</li>
 *  <li>Insurance</li>
 *  <li>Legal Services</li>
 *  <li>Logistics</li>
 *  <li>Manufacturing</li>
 *  <li>Medical</li>
 *  <li>Real Estate</li>
 * </ul>
 * <p>
 * Therefore, there are many different document types that need to be validated.
 * the <tt>validate()</tt> method examines the provided document type and 
 * determines whether or not it is a valid EDI document type.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class DocTypeValidator implements Validator {
    /**
     * The <tt>validate()</tt> method checks the validity of the supplied EDI
     * document type code. This method is able to check the validity of <strong>
     * all</strong> EDI document types, regardless of industry. This method will
     * need to be updated whenever the ANSI X11 Committee adds new document 
     * types to the standards.
     * 
     * @param docType a <tt>java.lang.String</tt> representation of the EDI
     *                document type code
     * @return <tt>true</tt> if the EDI document type is valid; <tt>false</tt>
     *          otherwise
     */
    @Override
    public Boolean validate(String toValidate) {
        // First, let's convert the document type to an integer to make it 
        //+ a little easier to validate. We will accomplish this in a try...
        //+ catch block to trap the possibility of a NumberFormatException.
        Integer doc;
        try {
            doc = new Integer(toValidate);
        } catch ( NumberFormatException ex ) {
            // If the docType parameter contains a letter, we will trap the 
            //+ error and return false, because no EDI document types contain
            //+ letters.
            return false;
        }
        
        // Now that we've converted the String to an Integer, let's create our
        //+ return value.
        Boolean isValid = false;    // We'll default to invalid document type.
        
        // Next, we validate the provided document type using a series of ifs,
        //+ checking ranges of integers where possible.
        if ( isBetween(doc, 0, 206) ) {
            if ( isBetween(doc, 100, 114) ) {
                isValid = true;
            } else if ( isBetween(doc, 120, 121) ) {
                isValid = true;
            } else if ( isBetween(doc, 125, 133) ) {
                isValid = true;
            } else if ( isBetween(doc, 135, 135) ) {
                isValid = true;
            } else if ( isBetween(doc, 138, 144) ) {
                isValid = true;
            } else if ( isBetween(doc, 146, 155) ) {
                isValid = true;
            } else if ( isBetween(doc, 157, 161) ) {
                isValid = true;
            } else if ( isBetween(doc, 163, 163) ) {
                isValid = true;
            } else if ( isBetween(doc, 170, 170) ) {
                isValid = true;
            } else if ( isBetween(doc, 175, 176) ) {
                isValid = true;
            } else if ( isBetween(doc, 179, 180) ) {
                isValid = true;
            } else if ( isBetween(doc, 185, 191) ) {
                isValid = true;
            } else if ( isBetween(doc, 194, 206) ) {
                isValid = true;
            } 
        } else if ( isBetween(doc, 207, 399) ) {
            if ( isBetween(doc, 210, 220) ) {
                isValid = true;
            } else if ( isBetween(doc, 222, 225) ) {
                isValid = true;
            } else if ( isBetween(doc, 227, 228) ) {
                isValid = true;
            } else if ( isBetween(doc, 240, 240) ) {
                isValid = true;
            } else if ( isBetween(doc, 242, 242) ) {
                isValid = true;
            } else if ( isBetween(doc, 244, 245) ) {
                isValid = true;
            } else if ( isBetween(doc, 248, 252) ) {
                isValid = true;
            } else if ( isBetween(doc, 255, 256) ) {
                isValid = true;
            } else if ( isBetween(doc, 259, 278) ) {
                isValid = true;
            } else if ( isBetween(doc, 280, 280) ) {
                isValid = true;
            } else if ( isBetween(doc, 280, 286) ) {
                isValid = true;
            } else if ( isBetween(doc, 288, 288) ) {
                isValid = true;
            } else if ( isBetween(doc, 290, 290) ) {
                isValid = true;
            } else if ( isBetween(doc, 300, 301) ) {
                isValid = true;
            } else if ( isBetween(doc, 303, 304) ) {
                isValid = true;
            } else if ( isBetween(doc, 309, 313) ) {
                isValid = true;
            } else if ( isBetween(doc, 315, 315) ) {
                isValid = true;
            } else if ( isBetween(doc, 317, 317) ) {
                isValid = true;
            } else if ( isBetween(doc, 319, 319) ) {
                isValid = true;
            } else if ( isBetween(doc, 322, 326) ) {
                isValid = true;
            } else if ( isBetween(doc, 350, 350) ) {
                isValid = true;
            } else if ( isBetween(doc, 352, 358) ) {
                isValid = true;
            } else if ( isBetween(doc, 361, 362) ) {
                isValid = true;
            } 
        }else if ( isBetween(doc, 400, 549) ) {
            if ( isBetween(doc, 404, 404) ) {
                isValid = true;
            } else if ( isBetween(doc, 410, 410) ) {
                isValid = true;
            } else if ( isBetween(doc, 412, 412) ) {
                isValid = true;
            } else if ( isBetween(doc, 414, 414) ) {
                isValid = true;
            } else if ( isBetween(doc, 417, 426) ) {
                isValid = true;
            } else if ( isBetween(doc, 429, 429) ) {
                isValid = true;
            } else if ( isBetween(doc, 431, 437) ) {
                isValid = true;
            } else if ( isBetween(doc, 440, 440) ) {
                isValid = true;
            } else if ( isBetween(doc, 451, 453) ) {
                isValid = true;
            } else if ( isBetween(doc, 455, 456) ) {
                isValid = true;
            } else if ( isBetween(doc, 460, 460) ) {
                isValid = true;
            } else if ( isBetween(doc, 463, 463) ) {
                isValid = true;
            } else if ( isBetween(doc, 466, 466) ) {
                isValid = true;
            } else if ( isBetween(doc, 468, 468) ) {
                isValid = true;
            } else if ( isBetween(doc, 470, 470) ) {
                isValid = true;
            } else if ( isBetween(doc, 475, 475) ) {
                isValid = true;
            } else if ( isBetween(doc, 485, 486) ) {
                isValid = true;
            } else if ( isBetween(doc, 490, 490) ) {
                isValid = true;
            } else if ( isBetween(doc, 492, 492) ) {
                isValid = true;
            } else if ( isBetween(doc, 494, 494) ) {
                isValid = true;
            } else if ( isBetween(doc, 500, 501) ) {
                isValid = true;
            } else if ( isBetween(doc, 503, 504) ) {
                isValid = true;
            } else if ( isBetween(doc, 511, 511) ) {
                isValid = true;
            } else if ( isBetween(doc, 517, 517) ) {
                isValid = true;
            } else if ( isBetween(doc, 521, 521) ) {
                isValid = true;
            } else if ( isBetween(doc, 527, 527) ) {
                isValid = true;
            } else if ( isBetween(doc, 536, 536) ) {
                isValid = true;
            } else if ( isBetween(doc, 540, 540) ) {
                isValid = true;
            } 
        }else if ( isBetween(doc, 550, 899) ) {
            if ( isBetween(doc, 561, 561) ) {
                isValid = true;
            } else if ( isBetween(doc, 567, 568) ) {
                isValid = true;
            } else if ( isBetween(doc, 601, 602) ) {
                isValid = true;
            } else if ( isBetween(doc, 620, 620) ) {
                isValid = true;
            } else if ( isBetween(doc, 622, 622) ) {
                isValid = true;
            } else if ( isBetween(doc, 625, 625) ) {
                isValid = true;
            } else if ( isBetween(doc, 650, 650) ) {
                isValid = true;
            } else if ( isBetween(doc, 715, 715) ) {
                isValid = true;
            } else if ( isBetween(doc, 753, 754) ) {
                isValid = true;
            } else if ( isBetween(doc, 805, 806) ) {
                isValid = true;
            } else if ( isBetween(doc, 810, 816) ) {
                isValid = true;
            } else if ( isBetween(doc, 818, 824) ) {
                isValid = true;
            } else if ( isBetween(doc, 826, 889) ) {
                isValid = true;
            } else if ( isBetween(doc, 891, 891) ) {
                isValid = true;
            } else if ( isBetween(doc, 893, 896) ) {
                isValid = true;
            } 
        }else if ( isBetween(doc, 900, 999) ) {
            if ( isBetween(doc, 920, 920) ) {
                isValid = true;
            } else if ( isBetween(doc, 924, 926) ) {
                isValid = true;
            } else if ( isBetween(doc, 928, 928) ) {
                isValid = true;
            } else if ( isBetween(doc, 940, 940) ) {
                isValid = true;
            } else if ( isBetween(doc, 943, 947) ) {
                isValid = true;
            } else if ( isBetween(doc, 980, 980) ) {
                isValid = true;
            } else if ( isBetween(doc, 990, 990) ) {
                isValid = true;
            } else if ( isBetween(doc, 993, 994) ) {
                isValid = true;
            } else if ( isBetween(doc, 996, 999) ) {
                isValid = true;
            }
        }

        // Finally, we return the validity of the document type.
        return isValid;
    }

    /**
     * This method checks to see if the supplied number is between the supplied
     * lower and upper bounds, inclusive.
     * 
     * @param num   number to check
     * @param lower lower bound that the number to check needs to be equal to or
     *              above
     * @param upper upper bound that the number to check needs to be equal to or
     *              below
     * @return <tt>true</tt> if the number to check is within the supplied upper
     *          and lower bounds, inclusive; <tt>false</tt> otherwise.
     */
    private static boolean isBetween(int num, int lower, int upper) {
        return lower <= num && num <= upper;
    }
}
