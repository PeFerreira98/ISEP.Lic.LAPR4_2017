/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1140618;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import java.util.Arrays;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Tiago
 */
public class DoWhileOperator  implements Function{

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
							  "A number to be included in the sum"),
		new FunctionParameter(Value.Type.BOOLEAN, "Condition", false,
							  "A condition to evaluate before proceeding")};
    
    public DoWhileOperator(){
    
    }
    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        if(operands.length==2){
            Value value = new Value();
		do {
			value = operands[0].evaluate();
		} while (operands[1].evaluate().toBoolean());
		return value;
        }
        return new Value(new IllegalArgumentException("not enough arguments"));
    }

    @Override
    public String getIdentifier() {
        return "DoWhile";
    }

    @Override
    public FunctionParameter[] getPARAMETERS() {
        return this.parameters;
    }

    @Override
    public boolean isVarArg() {
        return false;
    }
    
}
