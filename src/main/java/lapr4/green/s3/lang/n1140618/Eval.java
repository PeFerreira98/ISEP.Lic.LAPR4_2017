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
public class Eval implements NaryOperator {

    public Eval() {
    }

    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        try {
            Value value;
            
            String content = operands[0].toString();
            if (content.charAt(0) == '"' && content.charAt(content.length() - 1) == '"') {
                content = content.substring(1, content.length() - 1);
            }
            
            Expression test[] = new Expression[1];
            
            test[0] = Expression.class.cast(content);
            
            value = test[0].evaluate();

            return value;
        } catch (Exception ex) {
            return new Value();
        }
    }

    @Override
    public String getIdentifier() {
        return "EVAL";
    }

    @Override
    public Value.Type getOperandValueType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
