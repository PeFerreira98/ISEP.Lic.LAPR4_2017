/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ArrayStorage;
import lapr4.red.s2.lang.n1131106.globalvariables.domain.GlobalVariable;

/**
 * A workbook which can contain several spreadsheets.
 *
 * @author Einar Pehrson
 */
public class Workbook implements Iterable<Spreadsheet>, Serializable {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = -6324252462576447242L;

    /**
     * The spreadsheets of which the workbook consists
     */
    private List<Spreadsheet> spreadsheets = new ArrayList<Spreadsheet>();

    /**
     * The cell listeners that have been registered on the cell
     */
    private transient List<WorkbookListener> listeners
            = new ArrayList<WorkbookListener>();

    /**
     * The number of spreadsheets that have been created in the workbook
     */
    private int createdSpreadsheets;

    /**
     * this is the list where all Global Variables are stored
     */
    private static List<GlobalVariable> list = new ArrayList<GlobalVariable>();

    /** Storage for Array Variables */
    private transient ArrayStorage arrayStorage;
    
    /**
     * Creates a new empty workbook.
     */
    public Workbook() {
        this.arrayStorage = new ArrayStorage();
    }

    /**
     * Creates a new workbook, which initially contains the given number of
     * blank spreadsheets.
     *
     * @param sheets the number of sheets to create initially
     */
    public Workbook(int sheets) {
        for (int i = 0; i < sheets; i++) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle()));
        }
        this.arrayStorage = new ArrayStorage();
    }

    /**
     * Creates a new workbook, using the given content matrix to create
     * spreadsheets initially.
     *
     * @param contents the content matrices to use when creating spreadsheets
     */
    public Workbook(String[][]... contents) {
        for (String[][] content : contents) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle(), content));
        }
        this.arrayStorage = new ArrayStorage();
    }

    /**
     * Retrieves the ArrayStorage for this workbook.
     * @return the ArrayStorage for this workbook.
     */
    public ArrayStorage retrieveArrayStorage(){
        if(this.arrayStorage == null){
            Logger.getGlobal().log(Level.SEVERE, "Workbook with null ArrayStorage. Creating new one.");
            this.arrayStorage = new ArrayStorage();
        }
        return this.arrayStorage;
    }
    
    /**
     * Adds a blank spreadsheet to the end of the workbook.
     */
    public void addSpreadsheet() {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle());
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * Adds a new spreadsheet to the workbook, in which cells are initialized
     * with data from the given content matrix.
     *
     * @param content the contents of the cells in the spreadsheet
     */
    public void addSpreadsheet(String[][] content) {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle(), content);
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * Returns the title to be used for the next spreadsheet added.
     *
     * @return the title to be used for the next spreadsheet added
     */
    private String getNextSpreadsheetTitle() {
        return SpreadsheetImpl.BASE_TITLE + " " + (createdSpreadsheets++ + 1);
    }

    /**
     * Adds a new blank spreadsheet to the workbook.
     *
     * @param spreadsheet spreadsheet
     */
    public void removeSpreadsheet(Spreadsheet spreadsheet) {
        spreadsheets.remove(spreadsheet);
        // Remove references to the spreadsheet in remaining spreadsheets!
        fireSpreadsheetRemoved(spreadsheet);
    }

    /**
     * Returns the spreadsheet at the given index.
     *
     * @param index the index of the spreadsheet in the workbook
     * @return the spreadsheet at the given index
     * @throws IndexOutOfBoundsException if the index is out of range (index
     * less than 0 or index greater or equal |spreadsheets|)
     */
    public Spreadsheet getSpreadsheet(int index) throws IndexOutOfBoundsException {
        return spreadsheets.get(index);
    }

    /**
     * Returns the number of spreadsheets in the the workbook.
     *
     * @return the number of spreadsheets in the the workbook
     */
    public int getSpreadsheetCount() {
        return spreadsheets.size();
    }

    /**
     * Returns an iterator over the spreadsheets in the workbook.
     *
     * @return an iterator over the spreadsheets in the workbook
     */
    public Iterator<Spreadsheet> iterator() {
        return spreadsheets.iterator();
    }

    /*
 * EVENT HANDLING
     */
    /**
     * Registers the given listener on the workbook.
     *
     * @param listener the listener to be added
     */
    public void addWorkbookListener(WorkbookListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the workbook.
     *
     * @param listener the listener to be removed
     */
    public void removeWorkbookListener(WorkbookListener listener) {
        listeners.remove(listener);
    }

    /**
     * Returns the listeners that have been registered on the workbook.
     *
     * @return the listeners that have been registered on the workbook
     */
    public WorkbookListener[] getWorkbookListeners() {
        return listeners.toArray(new WorkbookListener[listeners.size()]);
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been inserted.
     *
     * @param spreadsheet the spreadsheet that was inserted
     * @param index the index at which the spreadsheet was inserted
     */
    private void fireSpreadsheetInserted(Spreadsheet spreadsheet, int index) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetInserted(spreadsheet, index);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been removed.
     *
     * @param spreadsheet the spreadsheet that was removed
     */
    private void fireSpreadsheetRemoved(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRemoved(spreadsheet);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been renamed.
     *
     * @param spreadsheet the spreadsheet that was renamed
     */
    @SuppressWarnings("unused")
    private void fireSpreadsheetRenamed(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRenamed(spreadsheet);
        }
    }

    /*
 * GENERAL
     */
    /**
     * Customizes deserialization by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        listeners = new ArrayList<WorkbookListener>();
    }

    /**
     * Method that creates one variable and add to the variables list
     *
     * @param name variable name
     * @param value variable value
     * @param ss variable spreadsheet
     */
    public void createVariable(String name, Value value, Spreadsheet ss) {

        GlobalVariable global = new GlobalVariable(name, value, ss);

        addVariable(global);

    }

    /**
     * Method that add a variable to the variables list
     *
     * @param variable the variable that is going to be added
     */
    public void addVariable(GlobalVariable variable) {

        if (findVariable(variable.getSpreadsheet(), variable.getName()) == null) {
            list.add(variable);
        } else {
            for (GlobalVariable var : list) {
                if (var.getName().equalsIgnoreCase(variable.getName())) {
                    list.set(list.indexOf(var), variable);
                }
            }
        }
    }

    /**
     * This method checks if our Variable already exists
     *
     * @param spreadsheet Represent the spreadsheet where the variable was
     * created
     * @param reference Represents a reference to the variable we are looking
     * for
     * @return temporary variable
     */
    public GlobalVariable findVariable(Spreadsheet spreadsheet, String reference) {

        for (GlobalVariable var : list) {
            if (var.getName().equalsIgnoreCase(reference)) {
                return var;

            }
        }

        return null;
    }

    /**
     * Method that allow us to acess the TemporaryVariable List
     *
     * @return our List
     */
    public List<GlobalVariable> getList() {
        return list;
    }

}
