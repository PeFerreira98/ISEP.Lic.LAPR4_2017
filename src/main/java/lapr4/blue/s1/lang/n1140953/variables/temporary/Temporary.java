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

    private Cell cell;
    private String name;
    private double value;

    public Temporary(Cell cell, String name, double value) {
        this.cell = cell;
        this.name = name;
        this.value = value;
    }

    public Temporary(Cell cell, String name) {
        this(cell, name, 0);
    }

    public Temporary(Temporary temporary, double value) {
        this(temporary.cell, temporary.name, value);
    }

    @Override
    public Value applyTo(String name) throws IllegalValueTypeException {
        return new Value(value);
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
        return visitor.visitVariable(this);
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public Cell getCell() {
        return cell;
    }
}
