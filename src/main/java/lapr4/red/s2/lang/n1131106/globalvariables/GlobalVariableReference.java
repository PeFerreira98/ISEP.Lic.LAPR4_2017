/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1131106.globalvariables;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;
import lapr4.blue.s1.lang.n1140953.variables.Variable;
import lapr4.red.s2.lang.n1131106.globalvariables.domain.GlobalVariable;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class GlobalVariableReference implements Expression {

    private String variable;
    private int variablePosition = 1;
    private Spreadsheet spreadsheet;

    /**
     * Empty constructor
     */
    public GlobalVariableReference() {

    }

    /**
     * Complete constructor that create one variable if it not exist in the list
     * of variables.
     *
     * @param variable name of the referenced variable
     * @param spreadsheet spreadsheet of the referenced variable
     */
    public GlobalVariableReference(String variable, Spreadsheet spreadsheet) {
        separateVariableFromPosition(variable);
        this.spreadsheet = spreadsheet;
        GlobalVariable var = this.spreadsheet.getWorkbook().
                findVariable(spreadsheet, this.variable);

        if (var == null) {
            this.spreadsheet.getWorkbook().
                    createVariable(variable, this.variablePosition, new Value(), this.spreadsheet);
        }
    }

    private void separateVariableFromPosition(String text) {
        int firstPos = text.indexOf("[");
        if (firstPos == -1) {

            this.variable = text;

        } else {
            this.variable = text.substring(0, firstPos);

            int lastPos = text.indexOf("]");
            if (lastPos != -1) {
                String pos;
                pos = text.substring(firstPos + 1, lastPos);
                this.variablePosition = Integer.parseInt(pos);
            }
        }
        System.out.println("Variable : " + this.variable);
        System.out.println("Position : " + this.variablePosition);

    }

    /**
     * Method that returns the name of the global variable reference
     *
     * @return name of the variable reference
     */
    public String getVariable() {
        return variable;
    }

    public int givePosition() {
        return this.variablePosition;
    }

    /**
     * Method that returns the spreadsheet of the variable reference
     *
     * @return spreadsheet of the variable reference
     */
    public Spreadsheet getSpreadSheet() {
        return spreadsheet;
    }

    /**
     * Method that returns the value of the variable
     *
     * @return the value of the variable
     */
    public Value evaluate() {
        Value value = new Value();

        GlobalVariable var = this.spreadsheet.getWorkbook().
                findVariable(spreadsheet, variable);
        if (var != null) {
            value = var.getVarValue(this.variablePosition);
        }

        return value;
    }

    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitGlobalVariableReference(this);
    }

}
