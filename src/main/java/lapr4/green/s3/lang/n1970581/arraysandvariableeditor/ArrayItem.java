/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import lapr4.blue.s1.lang.n1140953.variables.Variable;

/**
 *
 * @author Hugo
 */
public class ArrayItem implements Variable {
    
    String name;
    boolean initiated;
    Value value;
    
    public ArrayItem(String name){
        this.value = new Value();
        this.name = name;
        this.initiated = false;
    }
    
    public ArrayItem(String name, Value value){
        this.value = value;
        this.name = name;
        this.initiated = true;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public Value applyTo(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Value.Type getOperandValueType() {
        return this.value.getType();
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        return this.value;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitVariable(this);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
    
    
    
}
