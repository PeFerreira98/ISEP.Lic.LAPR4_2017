/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

/**
 * Class that represents a version
 * @author Hugo
 */
public class Version implements Comparable<Integer> , Cloneable{
    /* the version*/
    private final int version;
    
    
    /**
     * Version constructor
     * @param version the version number
     */
    public Version(int version){
        this.version = version;
    }

    /**
     * Returns the version as an int
     * @return the version as an int
     */
    public int version(){
        return this.version;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.version;
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
        final Version other = (Version) obj;
        if (this.version != other.version) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(version);
    }
    

    @Override
    public int compareTo(Integer o) {
        return Integer.valueOf(version).compareTo(o);
    }
    
    @Override
    public Version clone(){
        return new Version(this.version);
    }
    
}
