/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.controller.DescriptionExtensionLoaderController;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.ui.DescriptionExtensionLoaderUi;

/**
 * Class that deals with the new loading of extensions with user input.
 * @author Hugo
 */
public class DescriptionExtensionLoader {
    
    /** list of all the extensions available to load.*/
    private List <ExtensionDTO> allExtensions;
    /** The default load list shown to the user */
    private List <ExtensionDTO> defaultLoadList;
    /** if we should use the previous loader or the new one */
    private boolean abortNewLoad;
    /** used to indicate that the user has finished the selection */
    private boolean userFinishedSelection;
    
    private DefaultExtensionLoadListBuilder defaultListBuilder;
    
    /**
     * Constructor
     */
    public DescriptionExtensionLoader(){
        this.abortNewLoad = true;
        this.userFinishedSelection = false;
        this.allExtensions = new ArrayList<>();
        this.defaultLoadList = new ArrayList<>();
        this.defaultListBuilder = new DefaultExtensionLoadListBuilderByLatestVersion();
    }
    
    
    
    /**
     * Builds the defaultLoadList
     */
    public void buildDefaultLoadList(){
        List<ExtensionDTO> aux = this.defaultListBuilder.buildDefaultLoadList(allExtensions);
        this.defaultLoadList.clear();
        for(ExtensionDTO dto : aux) this.defaultLoadList.add(dto);
    }
    
    /**
     * Main method of the class for dealing with the user choice.
     */
    public void contactUser(){
        DescriptionExtensionLoaderController ctrl = new DescriptionExtensionLoaderController(this);
        new DescriptionExtensionLoaderUi(ctrl, allExtensions, defaultLoadList).setVisible(true);
        
        
        while(!this.isUserFinishedSelection()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DescriptionExtensionLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    /**
     * Loads the selected extensions to the ExtensionManager
     * @param listToLoad list of ExtensionsDTO of the extensions to load.
     * @return the number of extensions that failed to load.
     */
    public int loadList(List <ExtensionDTO> listToLoad){
        int errors = 0;
        ExtensionManager.getInstance().clear(); // Clears all extensions from the managed list
        
        for (ExtensionDTO extDTO : listToLoad){
            Extension ext = ExtensionManager.getInstance().load(extDTO.className()); 
            if (ext == null) errors++;
        }
        return errors;
    }
    
    /**
     * Validates that this list doesn't has extensionsDTO with the same name.
     * @param listToValidateLoad list you wish to validate ExtensionDTO
     * @return true if valid, false if the names aren't unique.
     */
    public boolean validateLoadingListOfUniqueExtensions(List <ExtensionDTO> listToValidateLoad){
        List <String> names = new ArrayList();
        for (ExtensionDTO dto : listToValidateLoad){
            if (names.contains(dto.getName())) return false;
            names.add(dto.getName());
        }
        return true;
    }
    
    
    
    public synchronized boolean isAbortNewLoad(){ return this.abortNewLoad;}
    public synchronized void indicateUseNewLoader(){ this.abortNewLoad = false;}
    public synchronized boolean isUserFinishedSelection(){ return this.userFinishedSelection;}
    public synchronized void indicateUserFinishedSelection(){ this.userFinishedSelection = true;}
    
    
    
    /**
     * Used to retrieve all the extensions information from the prop files. Used the ExtensionManager
     */ 
    public void retrieveAllExtensions(){
        List <Extension> allExtensionsList = ExtensionManager.getInstance().listAllExtensionFound();
        for(Extension extension : allExtensionsList){
            try{
                this.allExtensions.add(MetadataFactory.instance().buildExtensionDTO(extension));
            }
            catch(IllegalArgumentException ex){
                System.err.println(ex);
            }
        }
        this.allExtensions.sort(null);
    }
    
}
