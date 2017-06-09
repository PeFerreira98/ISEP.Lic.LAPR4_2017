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
    }
    
    public int loadList(List <ExtensionDTO> listToLoad){
        return 0;
    }
    
    
    public synchronized boolean isAbortNewLoad(){ return this.abortNewLoad;}
    public synchronized void indicateUseNewLoader(){ this.abortNewLoad = false;}
    public synchronized boolean isUserFinishedSelection(){ return this.userFinishedSelection;}
    public synchronized boolean indicateUserFinishedSelection(){ return this.abortNewLoad;}
    
    
    
    /** Used to retrieve all the extensions information from the prop files.*/
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
