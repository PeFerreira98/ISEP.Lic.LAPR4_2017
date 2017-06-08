/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.Objects;

/**
 * Class that represents an description
 * @author Hugo
 */
public class Description implements Comparable<String> , Cloneable{
    /* the description */
    private final String description;
    
    public Description(String description){
        if (description == null) throw new IllegalArgumentException("Description building with null description");
        this.description = description;
    }

    /**
     * returns the description as an String
     * @return the description as an String
     */
    public String description(){
        return this.description;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.description);
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
        final Description other = (Description) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public int compareTo(String o) {
        return this.description.compareTo(o);
    }

    @Override
    public Description clone(){
        return new Description(this.description);
    }
    
    
    
}
