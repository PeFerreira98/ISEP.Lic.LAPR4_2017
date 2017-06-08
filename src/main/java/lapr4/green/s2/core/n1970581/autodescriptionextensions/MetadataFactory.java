/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

/**
 * A factory to build Metadata objects and associated objects like ExtensionDTO
 * @author Hugo
 */
public class MetadataFactory {
    
    /** The factory instance */
    private static final MetadataFactory instance = new MetadataFactory();
    /** the default version when we lack one */
    private static final int DEFAULT_VERSION = 0;
    /** the default description when we lack one */
    private static final String DEFAULT_DESCRIPTION = " no description avaiable ";
    
    /**
     * Private constructor for the factory
     */
    private MetadataFactory(){
        //empty by default.
    }
    
    /**
     * How to get the factory
     * @return the factory
     */
    public static MetadataFactory instance(){
        return instance;
    }
    
    /**
     * Builds metadata with full parametes
     * @param name the name of extension
     * @param version the version of extension
     * @param description the description of extension
     * @return the metadata built
     */
    public Metadata buildMetadata(String name, int version, String description){
        if(name == null || description == null ) throw new IllegalArgumentException("Metadata building with null parameter");
        Name n = new Name(name);
        Version v = new Version(version);
        Description d = new Description(description);
        return new Metadata(n, v, d);
    }
    
    /**
     * default builder for Metadata when there is no version or description. Used for retrocompatibility
     * @param name the name of the extension
     * @return the metadata built
     */
    public Metadata buildMetadata(String name){
        if(name == null ) throw new IllegalArgumentException("Metadata building with null name");
        Name n = new Name(name);
        Version v = new Version(DEFAULT_VERSION);
        Description d = new Description(DEFAULT_DESCRIPTION);
        return new Metadata(n, v, d);
    }
    
    /**
     * Builds the Extension DTO based on the Metadatalbe extension
     * @param extension the Metadatable Extension
     * @return the ExtensionDTO
     */
    public ExtensionDTO buildExtensionDTO(Metadatable extension){
        if(extension == null) throw new IllegalArgumentException("Null extension passed to MetadataFactory in buildExtensionDTO");
        
        String className = extension.getClass().getCanonicalName();
        
        
        return new ExtensionDTO(extension.metadata().clone(), className);
    }
    
    
    
    
}
