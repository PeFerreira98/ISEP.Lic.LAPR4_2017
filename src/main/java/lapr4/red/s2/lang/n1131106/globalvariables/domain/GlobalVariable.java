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

/**
 *
 * @author Nuno Filipe 1131106
 */
public class GlobalVariable implements Serializable {

    private String varName;
    private ArrayList<Value> varValues = new ArrayList<Value>();
    private Spreadsheet spreadsheet;
    private int currentPosition = 1;

    /**
     * Empty constructor
     */
    public GlobalVariable() {
    }

    /**
     * Complete constructor
     *
     * @param varName variable name
     * @param varPosition the position of the variable
     * @param varValue variable value
     * @param spreadsheet variable spreadsheet
     */
    public GlobalVariable(String varName, int varPosition, Value varValue,
            Spreadsheet spreadsheet) {
        this.varName = varName;
        this.currentPosition = varPosition;
        initiateArray(varPosition);
        this.varValues.add(varPosition - 1, varValue);
        this.spreadsheet = spreadsheet;
    }

    /**
     * Method that returns the variable name
     *
     * @return variable name
     */
    public String getVarName() {
        return varName;
    }

    private void initiateArray(int varPosition) {
        int size = varValues.size();
        for (int i = size; i < varPosition; i++) {
            this.varValues.add(i, new Value("NULL"));
        }
    }

    /**
     * Method that modifies the variable name
     *
     * @param varName the new variable name
     */
    public void setVarName(String varName) {
        this.varName = varName;
    }

    /**
     * Method that returns the variable value
     *
     * @return the variable value
     */
    public ArrayList<Value> getVarValues() {
        return varValues;
    }

    public Value getVarValue(int position) {
        initiateArray(position);
        return varValues.get(position - 1);
    }

    /**
     * Method that modifies the variable value
     *
     * @param varValue the new variable value
     * @param position the position of the variable
     */
    public void setVarValue(Value varValue, int position) {
        initiateArray(position);
        this.varValues.add(position - 1, varValue);
    }

    /**
     * Method that returns the variable spreadsheet
     *
     * @return variable spreadsheet
     */
    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    /**
     * Method that prints the name and value of the variable
     *
     * @return name and value of the variable
     */
    @Override
    public String toString() {
        return "Global Variable Name: " + varName + ", Variable Value: " + varValues.
                get(0);
    }

}
