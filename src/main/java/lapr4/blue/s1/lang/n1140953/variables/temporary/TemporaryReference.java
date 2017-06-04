/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140953.variables.temporary;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import java.util.SortedSet;
import java.util.TreeSet;
import lapr4.blue.s1.lang.n1140953.variables.Variable;

/**
 *
 * @author zero_
 */
public class TemporaryReference implements Variable {

    private Cell cell;
    private String name;
    private Temporary temporary;

    public TemporaryReference(Cell cell, String name) {
        this.cell = cell;
        this.name = name;
    }

    @Override
    public Value evaluate() {
        return applyTo(name);
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitVariable(this);
    }

    @Override
    public Value applyTo(String name) {
        if (TemporaryStorage.exists(name)) {
            return TemporaryStorage.getTemporaryByName(name).getValue();
        }
        return new Value((Number) 0);
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.NUMERIC;
    }

    public String getName() {
        return name;
    }

    public Temporary getTemporary() {
        return temporary;
    }

    public Cell getCell() {
        return cell;
    }

}
