/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.Objects;

/**
 * Class that represents a metadata of an extension
 * @author Hugo
 */
public class Metadata implements Comparable<Metadata>, Metadatable, Cloneable{
    
    /* the name */
    private final Name name;
    /* the version */
    private final Version version;
    /* the description */
    private final Description description;
    
    /**
     * Constructor with parameters
     * @param name the name
     * @param version the version 
     * @param description the description
     */
    public Metadata(Name name, Version version, Description description){
        if(name == null || version == null || description == null ) throw new IllegalArgumentException("Metadata building with null parameter");
        this.name = name;
        this.version = version;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.version);
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
        final Metadata other = (Metadata) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Metadata o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.name.name();
    }

    @Override
    public int version() {
        return this.version.version();
    }

    @Override
    public String description() {
        return this.description.description();
    }

    @Override
    public Metadata metadata() {
        return this.clone();
    }
    
    
    @Override
    public Metadata clone(){
        return new Metadata(name.clone(), version.clone(), description.clone());
    }
    
    
}
