/* {InvalidDocTypeException.java}
 * 
 * An Exception for handling invalid EDI Document Types.
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
package com.is2300.jedi.edi.exceptions;

/**
 * The <tt>InvalidDocTypeException</tt> is for catching invalid EDI Document
 * Types that may be passed through EDI transmission files.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class InvalidDocTypeException extends Exception {

    /**
     * Creates a new instance of <code>InvalidDocTypeException</code> without
     * detail message.
     */
    public InvalidDocTypeException() {
        super();
    }

    /**
     * Constructs an instance of <code>InvalidDocTypeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDocTypeException(String msg) {
        super(msg);
    }
}
