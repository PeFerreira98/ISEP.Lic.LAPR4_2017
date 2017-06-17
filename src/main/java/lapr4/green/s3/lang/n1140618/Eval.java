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
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ui.ctrl.UIController;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Tiago
 */
public class Eval implements NaryOperator {
    
    private UIController ui;
    
    public Eval(UIController ui){
        this.ui=ui;
    }

    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        try {
			String content = operands[0].toString();
			if (content.charAt(0) == '"' && content.charAt(content.length() - 1) == '"') {
				content = content.substring(1, content.length() - 1);
			}
			content = "=" + content;
			Cell cell =  ui.getActiveCell();
			return FormulaCompiler.getInstance().compile(cell, content).
				evaluate();
		} catch (Exception ex) {
			return new Value();
		}
    }

    @Override
    public String getIdentifier() {
        return "Eval";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }
    
}
