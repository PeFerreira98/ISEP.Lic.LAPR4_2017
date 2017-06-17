/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1140618;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ui.ctrl.UIController;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Tiago
 */
public class Eval implements Function  {
    
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.TEXT, "Formula", false,
							  "Expression to be executed by the function as formula")
	};
    
    public Eval(){
    }

    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        try {
			String content = operands[0].toString();
			if (content.charAt(0) == '"' && content.charAt(content.length() - 1) == '"') {
				content = content.substring(1, content.length() - 1);
			}
			content = "=" + content;
//			Cell cell =  UIController.getUIController().getActiveWorkbook().
//				getSpreadsheet(0).getCell(0, 0);
//			return FormulaCompiler.getInstance().compile(cell, content).
//				evaluate();
return null;
		} catch (Exception ex) {
			return new Value();
		}
    }

    @Override
    public String getIdentifier() {
        return "Eval";
    }

    @Override
    public FunctionParameter[] getPARAMETERS() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return false;
    }
    
}
