/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import java.io.Serializable;
import java.util.Objects;
import lapr4.blue.s1.lang.n1140953.variables.Variable;

/**
 * Class representing an Array Item, a form of global variable
 * @author Hugo
 */
public class ArrayItem implements Variable , Comparable<ArrayItem> , Serializable{
    
    /** the name */
    private String name;
    /** if it was initiated */
    private boolean initiated;
    /** the value stored */
    private Value value;
    
    /**
     * The constructor with name
     * @param name the name
     */
    public ArrayItem(String name){
        this.value = new Value();
        this.name = name;
        this.initiated = false;
    }
    
    /**
     * A constructor with a value. (unused atm)
     * @param name the name
     * @param value the value
     */
    public ArrayItem(String name, Value value){
        this.value = value;
        this.name = name;
        this.initiated = true;
    }

    /**
     * Returns the name
     * @return the name
     */
    public synchronized String getName() {
        return name;
    }

    /**
     * returns the value
     * @return the value
     */
    public synchronized Value getValue() {
        return value;
    }

    /**
     * Sets the value and signals a change.
     * @param value the value.
     */
    public synchronized void setValue(Value value) {
        this.value = value;
        this.initiated = true;
        VariableEditorWatchdog.instance().signalChange();
    }
    
    /**
     * Checks if this item is initializaded. If a value was added to it.
     * @return true is initializaed else false
     */
    public synchronized boolean isInitiated(){return this.initiated;}

    @Override
    public synchronized Value applyTo(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Value.Type getOperandValueType() {
        return this.value.getType();
    }

    @Override
    public synchronized Value evaluate() throws IllegalValueTypeException {
        return this.value;
    }

    @Override
    public synchronized Object accept(ExpressionVisitor visitor) {
        return visitor.visitVariable(this);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Creates an DTO based on this ArrayItem
     * @return an DTO based on this ArrayItem
     */
    public synchronized ArrayItemDTO toDTO(){
        return new ArrayItemDTO(this.name,this.value.toString());
    }

    @Override
    public synchronized int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public synchronized boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArrayItem other = (ArrayItem) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public synchronized int compareTo(ArrayItem o) {
        return this.name.compareTo(o.name);
    }
   
    
    
    
}
