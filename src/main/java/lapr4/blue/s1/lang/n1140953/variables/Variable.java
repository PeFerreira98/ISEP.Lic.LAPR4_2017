/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140953.variables;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;

/**
 *
 * @author zero_
 */
public interface Variable extends Expression {
    
    public Value applyTo(String name) throws IllegalValueTypeException;
    
    public Value.Type getOperandValueType();
}
