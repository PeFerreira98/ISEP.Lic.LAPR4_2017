/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions.controller;

import java.util.List;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.DescriptionExtensionLoader;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.ExtensionDTO;

/**
 * Controller for interfacing the UI with DescriptionExtensionLoader
 * @author Hugo
 */
public class DescriptionExtensionLoaderController {
    
    /** The instance that created this controller and will interact with him */
    private final DescriptionExtensionLoader loader;
    
    /**
     * Controller for the interfacing the UI with DescriptionExtensionLoader
     * @param loader DescriptionExtensionLoader to interact with
     */
    public DescriptionExtensionLoaderController(DescriptionExtensionLoader loader){
        this.loader = loader;
    }
    
    /**
     * Orders the loader to load this list, reporting the number of failed extensions load.
     * @param listToLoad list of refered ExtensionDTO to load.
     * @return number of failed extensions load.
     */
    public int loadList(List <ExtensionDTO> listToLoad){
        return this.loader.loadList(listToLoad);
    }
    
    
    /**
     * Validates is this list is ok to load. 
     * @param listToValidateLoad list you wish to validate
     * @return true is valid, false if invalid
     */
    public boolean validateLoadingList(List <ExtensionDTO> listToValidateLoad){
        return this.loader.validateLoadingListOfUniqueExtensions(listToValidateLoad);
    }
    
    
    
    /**
     * Indicates the loader that the user has finished it's selection.
     */
    public synchronized void indicateUserFinishedSelection(){ this.loader.indicateUserFinishedSelection(); loader.wakeAll();}
    
    
}
