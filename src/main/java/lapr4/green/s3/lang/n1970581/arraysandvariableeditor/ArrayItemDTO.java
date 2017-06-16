/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import java.util.Objects;

/**
 * class that is a Data Transfer Object for ArrayItems. Used for the UI.
 * @author Hugo
 */
public class ArrayItemDTO implements Comparable<ArrayItemDTO>{
    
    /** Name */
    private final String name;
    /** value */
    private final String value;
    
    /**
     * The constructor of the DTO
     * @param name the name of the ArrayItem
     * @param value the value stored in the ArrayItem
     */
    public ArrayItemDTO(String name, String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(ArrayItemDTO o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArrayItemDTO other = (ArrayItemDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

   

    
    protected Object clone() throws CloneNotSupportedException {
        return new ArrayItemDTO(this.name, this.value);
    }

    @Override
    public String toString() {
        return name + " -> " + value;
    }

   
    
    
    
    
}
