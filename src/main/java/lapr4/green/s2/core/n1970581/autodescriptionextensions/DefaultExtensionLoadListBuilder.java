/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.List;

/**
 * Interface for building the a default loading list of extensions 
 * @author Hugo
 */
public interface DefaultExtensionLoadListBuilder {
 
    
    /**
     * Used for building the a default loading list of extensions 
     * @param allExtensions all the extensions available.
     * @return a default loading list of extensions as ExtensionDTO
     */
    public List<ExtensionDTO> buildDefaultLoadList(List<ExtensionDTO> allExtensions);
    
}
