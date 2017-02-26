/* {Printing.java}
 * This class is the API for printing data to files. Each of the methods in
 * this API needs to be overriden in order to provide the functionality
 * required.
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
package com.is2300.jedi.edi.api;

import java.io.IOException;

/**
 * The Print API defines the methods that need to be implemented in order to 
 * provide the functionality to be able to write data out to a file or printer.
 * <p>
 * <em><strong>NOTE:</strong> All method documentation is based on using <tt>
 * String</tt> objects for the <tt>Object</tt> parameter. Each developer will 
 * need to document their implementation accordingly to the type of <tt>
 * Object</tt> s/he uses for the <tt>Object</tt> parameter.</em>
 * 
 * @author Sean Carrick
 * @version 0.5.0
 * @since 0.5.0
 */
public interface Printing {
    /**
     * This method sets up the type of document to be printed. The data
     * supplied via the parameter needs to provide the following information:
     * <p>
     * <ul>
     *  <li>Document Title</li>
     *  <li>EDI Document Type Code</li>
     * </ul>
     * <p>
     * This data is used to define certain attributes of the document.
     * <p>
     * By providing this method, the calling application will be able to group
     * all invoices into the same HTML file and print them as one batch.
     * 
     * @param pageData The document title and EDI document type code in the 
     *                 following order:
     * <ul>
     *  <li>[0] : Document Title</li>
     *  <li>[1] : EDI Document Type Code</li>
     * </ul>
     */
    public void openDocument(String[] pageData);
    
    /**
     * This method is used to create the header section of <em>each page</em> of
     * the final document printout. This method should be called immediately
     * after the call to {@link net.integrity.jedi.print.api.PrintAPI 
     * <tt>openDocument</tt>}.
     * 
     * @param pageData Array containing required data, such as Invoice Number,
     *                 Date, etc.
     */
    public void generateHeader(String[] pageData);
    
    /**
     * This method sets up the data for the vendor company information to be 
     * used in the printout. This data should include:
     * <ul>
     *  <li>Company Name</li>
     *  <li>Street Address</li>
     *  <li>Suite Number, if applicable</li>
     *  <li>City</li>
     *  <li>State</li>
     *  <li>Zip Code</li>
     *  <li>Phone Number</li>
     *  <li>Email Address</li>
     * </ul>
     * <p>
     * Not all of these fields are required, but as many as are necessary should
     * be supplied to this method.
     * @param vendorData 
     */
    public void generateVendorAddressBlock(String[] vendorData);
    
    /**
     * This method sets up the data for the purchaser company information to be 
     * used in the printout. This data should include:
     * <ul>
     *  <li>Company Name</li>
     *  <li>Street Address</li>
     *  <li>Suite Number, if applicable</li>
     *  <li>City</li>
     *  <li>State</li>
     *  <li>Zip Code</li>
     *  <li>Phone Number</li>
     *  <li>Email Address</li>
     * </ul>
     * <p>
     * Not all of these fields are required, but as many as are necessary should
     * be supplied to this method.
     * @param purchaserData 
     */
    public void generatePurchaserAddressBlock(String[] purchaserData);
    
    /**
     * This method sets up the data for the shipping information to be 
     * used in the printout. This data should include:
     * <ul>
     *  <li>Company Name</li>
     *  <li>Street Address</li>
     *  <li>Suite Number, if applicable</li>
     *  <li>City</li>
     *  <li>State</li>
     *  <li>Zip Code</li>
     *  <li>Phone Number</li>
     *  <li>Email Address</li>
     * </ul>
     * <p>
     * Not all of these fields are required, but as many as are necessary should
     * be supplied to this method.
     * @param shippingData 
     */
    public void generateShippingAddressBlock(String[] shippingData);
    
    /**
     * This method opens the content body table for the print file. This body
     * table will contain all of the line items that are being reported on. For
     * example, if the document is an invoice, the following table would be 
     * displayed:
     * <p>
     * The table created would then look similar this, depending upon the 
     * desired output format:
     * <p>
     * <table class="body" summary="">
     *  <tr>
     *    <th>Part Number</th>
     *    <th>Part Name</th>
     *    <th>Qty</th>
     *    <th>Price</th>
     *    <th>Line Total</th>
     *  </tr>
     * </table>
     * 
     * @param contentData The data would need to contain only the column headers
     */
    public void openContentTable(String[] contentData);
    
    /**
     * This method is used to create exactly one row in a table. The data
     * supplied in the <tt>String</tt> array is the data that is to be put into
     * each cell of the table. Each array element should contain all of the data
     * for a single cell.
     * <p>
     * This method creates the table row for displaying the data details. The
     * <tt>Boolean</tt> flag, <tt>isEven</tt>, let's the method know whether
     * this row is an odd or even row number for setting the background color
     * desired for alternating rows of data. Therefore, the
     * following example shows what this method will create if the <tt>isEven
     * </tt> flag is <tt>true</tt> and the provided data in the <tt>Object</tt>
     * array is as follows: [0]=1952-A-500; [1]=Class 'A' Widget; [2]=75;
     * [3]=$10.00; and [4]=$750.00:
     * <p>
     * This would show a row like the following:
     * </p>
     * <table summary="">
     *  <tr>
     *   <td>1952-A-500</td>
     *   <td>Class 'A' Widget</td>
     *   <td>75</td>
     *   <td>$10.00</td>
     *   <td>$750.00</td>
     *  </tr>
     * </table>
     * <p>
     * This would have the header row on it, of course, because the program
     * would call the method <tt>openContentTable(Object[] contentData)</tt>
     * prior to calling this method.
     * 
     * @param rowData Data to be displayed in the table row's cells.
     * @param isEven Flag to determine whether the row number is odd or even for
     *               using alternating background colors to make the data more
     *               readable
     */
    public void createTableRow(Object[] rowData, Boolean isEven);
    
    /**
     * Closes out the table for the content of the document. This method would
     * typically be used only if the desired output is HTML, as a way of placing
     * the closing table tag in the HTML file. Other output formats may or may
     * not need to use this method.
     */
    public void closeContentTable();
    
    /**
     * This method generates the notes section of the document. Most EDI 
     * transactions have an <tt>NTE</tt> or <tt>NOT</tt> segment included with
     * them. This is the method that takes care of including those notes on the
     * printed document.
     * 
     * @param notesData The data to be included in the notes section.
     */
    public void generateNotes(Object[] notesData);
    
    /**
     * This method generates the footer section of <em>each page</em> of the
     * final report. The footer data can be almost anything and not every type
     * of document will have footer data.
     * 
     * @param pageFooterData The data that needs to be at the end of each page
     *                       of the final document printout.
     */
    public void generateFooter(Object[] pageFooterData);
    
    /**
     * This method closes out the entire document. This method should only
     * be called <strong>after</strong> all data has been sent to the document.
     * @throws java.io.IOException
     */
    public void closeDocument() throws IOException;
}
