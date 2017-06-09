/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.Objects;

/**
 * This class represents the information ragarding an extension.
 * @author Hugo
 */
public class ExtensionDTO implements Metadatable , Comparable<ExtensionDTO>, Cloneable{
    
    //* The metadata of the Extension */
    private final Metadata metadata;
    //* The class name of the extension */
    private final String className;
    
    /**
     * Constructor with parameters
     * @param metadata the metadata of the extension
     * @param className the class name of the extension
     */
    public ExtensionDTO(Metadata metadata, String className){
        if(metadata == null || className == null) throw new IllegalArgumentException("Null metadata or Null classname for ExtensionDTO in constructor");
        this.metadata = metadata;
        this.className = className;
    }

    @Override
    public String getName() {
        return this.metadata.getName();
    }

    @Override
    public int version() {
        return this.metadata.version();
    }

    @Override
    public String description() {
        return this.metadata.description();
    }

    @Override
    public Metadata metadata() {
        return this.metadata.clone();
    }
    
    /**
     * REturn the class name of the extension this DTO refers to.
     * @return the class name of the extension this DTO refers to. 
     */
    public String className(){
        return this.className;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.metadata);
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
        final ExtensionDTO other = (ExtensionDTO) obj;
        if (!Objects.equals(this.metadata, other.metadata)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return this.metadata.getName() + "  v" + this.metadata.version();
    }

    @Override
    public int compareTo(ExtensionDTO o) {
        return this.metadata.compareTo(o.metadata());
    }

    @Override
    protected ExtensionDTO clone(){
        return new ExtensionDTO(this.metadata.clone(), this.className);
    }

    
    
    
}
