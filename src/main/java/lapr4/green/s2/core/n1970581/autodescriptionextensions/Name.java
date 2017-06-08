/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.Objects;

/**
 * Class that represents a name.
 * @author Hugo
 */
public class Name implements Comparable<String> , Cloneable{
    
    /* A name */
    private final String name;
    
    /**
     * The Name constructor
     * @param name name
     */
    public Name(String name){
        if (name == null) throw new IllegalArgumentException("Name building with null name");
        this.name = name;
    }
    
    /**
     * Returns the stored name as string.
     * @return Returns the stored name as string.
     */
    public String name(){return this.name;}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.name);
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(String o) {
        return this.name.compareTo(o);
    }
    
    @Override
    public Name clone(){
        return new Name(this.name);
    }
    
}
