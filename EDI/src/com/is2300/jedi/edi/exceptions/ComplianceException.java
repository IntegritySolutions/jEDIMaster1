/* {ComplianceException.java}
 * 
 * An Exception for handling invalid use of segment data for the purposes that
 * it may be used.
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
 *This object should be thrown any time that a transmission segment provides 
 * invalid data for the segment, even though that data is technically legal. 
 * This is used as a way of trapping data that makes no sense in its context.
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public class ComplianceException extends Exception {

    /**
     * Creates a new instance of <code>ComplianceException</code> without detail
     * message.
     */
    public ComplianceException() {
    }

    /**
     * Constructs an instance of <code>ComplianceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ComplianceException(String msg) {
        super(msg);
    }
}
