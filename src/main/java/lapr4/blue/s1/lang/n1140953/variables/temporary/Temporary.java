/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140953.variables.temporary;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import lapr4.blue.s1.lang.n1140953.variables.Variable;

/**
 *
 * @author zero_
 */
public class Temporary implements Variable {

    private String name;
    private Cell cell;
    private double v;

    public Temporary(Cell c, String name) {
        this.cell = c;
        this.name = name;
    }

    @Override
    public Value applyTo(String name) throws IllegalValueTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.NUMERIC;
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        return this.applyTo(name);
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
