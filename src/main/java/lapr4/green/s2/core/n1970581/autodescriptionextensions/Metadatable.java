/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

/**
 * This is the interface for Metadata. It allows us to not forget anything during implementation and some abstraction.
 * @author Hugo
 */
public interface Metadatable {
    
    /**
     * Returns the name of the extension.
     * @return the name of the extension
    */
    public String getName();
    
    /**
     * Returns the version of the extension.
     * @return Returns the version of the extension.
     */
    public int version();
    
    /**
     * return the description of the extension
     * @return return the description of the extension
     */
    public String description();
    
    /**
     * returns a clone of the metadata
     * @return a clone of the metadata
     */
    public Metadata metadata();
    
    
}
