/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1140618;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.UnknownElementException;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Tiago
 */
public class WhileDoOperator implements NaryOperator{

    public WhileDoOperator(){
    
    }
    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        if(operands.length==2){
            try
            {
                Value value = new Value();
                // Get the sequence operator to execute the body as a block
                
                NaryOperator naryOperator = Language.getInstance().getNaryOperator("{");

                // Copy arguments to be executed in each iteration of the loop
                Expression[] body = Arrays.copyOfRange(operands, 2, operands.length);

                while (operands[0].evaluate().toBoolean()) {
			value = naryOperator.applyTo(body);
		}

                return value; 
            } catch (csheets.core.formula.lang.UnknownElementException ex) {
                return new Value(ex);
            }
        }
        return new Value(new IllegalArgumentException("not enough arguments"));
    }

    @Override
    public String getIdentifier() {
        return "WhileDo";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }
    
}
