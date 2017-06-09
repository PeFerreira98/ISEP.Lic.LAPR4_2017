/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1131106.globalvariables.domain;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class GlobalVariable implements Serializable {

    private String name;
    private Value value;
    private Spreadsheet ss;

    public static List<GlobalVariable> list = new ArrayList<GlobalVariable>();

    /**
     * Default empty Constructor
     *
     */
    public GlobalVariable() {

    }

    /**
     * Constructor
     *
     * @param name name of the Global Variable
     * @param value Value of the Global Variable
     * @param ss Spreadsheet where the Variable was created
     */
    public GlobalVariable(String name, Value value, Spreadsheet ss) {
        this.name = name;
        this.value = value;
        this.ss = ss;
    }

    /**
     * Method to get the Value
     *
     * @return Global Variable value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Method to get the Name
     *
     * @return Global Variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to rename our Global Variable
     *
     * @param name new name of the Global Variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to change the current value of Global Variable
     *
     * @param value new value of the Global Variable
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Method to get the Spreadsheet where the Global Variable was created
     *
     * @return Global Variable spreadsheet
     */
    public Spreadsheet getSpreadsheet() {
        return ss;
    }

    @Override
    public String toString() {
        return "Global Variable Name: " + name + " - Value: " + value;
    }
}
