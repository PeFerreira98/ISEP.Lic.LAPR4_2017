/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1131106.globalvariables;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s2.lang.n1131106.globalvariables.domain.GlobalVariable;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class GlobalVariableReference implements Expression {

    public static List<GlobalVariable> list = new ArrayList<GlobalVariable>();

    /**
     * The variableG to which the reference points
     */
    Workbook workbook = new Workbook();
    private String variableG;
    private Spreadsheet spreadsheetG;

    /**
     * Creates a new variableG reference to the given variableG.
     *
     * @param variable variable
     *
     */
    public GlobalVariableReference(String variable) {
        this.variableG = variable;
    }

    /**
     * Creates a new variableG reference from a string matching the Spreadsheet
     * spreadsheet and String reference
     *
     * @param spreadsheet the spreadsheet of the cell
     * @param reference a string representation of the reference
     */
    public GlobalVariableReference(Spreadsheet spreadsheet, String reference) {
        variableG = reference;
        this.spreadsheetG = spreadsheet;
        GlobalVariable temp = workbook.findVariable(spreadsheet, reference);

        if (temp == null) {
            workbook.createVariable(reference, new Value(), spreadsheet);
        }

    }

    public Value evaluate() {
        return workbook.findVariable(spreadsheetG, variableG).getValue();
    }

    /**
     * Returns the name of the global variableG
     *
     * @return variableG
     */
    public String getVariable() {
        return variableG;
    }

    /**
     * Returns the spreadsheet to which the global variableG is contained
     *
     * @return spreadsheet
     */
    public Spreadsheet getSpreadSheet() {
        return spreadsheetG;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitGlobalReference(this);
    }

}
