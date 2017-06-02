/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook.controller;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.Observer;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileContainer;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileFinder;
import lapr4.green.s1.ipc.n1970581.findworkbook.FilenameFilterBasic;

/**
 * Controller for use case: IPC01.1 Search Workbook
 * @author Hugo
 */
public class SearchWorkbookController {
    
    /** The user interface controller */
    private UIController uiController;
    
    
    private FileContainer container;
    
    
    
    /**
    * Creates a new comment controller.
    * @param uiController the user interface controller
    */
    public SearchWorkbookController(UIController uiController){
        this.uiController = uiController;
    }
    
    /**
     * Searches for a file and places it inside a container that passes FileDTO to the Observer for each file found.
     * @param rootDir root directory to start the search.
     * @param observer The observer that receives the FileDTO.
     */
    public void search(File rootDir , Observer observer){
        if(this.container != null) {this.container.setToExit();}
        this.container = new FileContainer();
        if(observer != null) this.container.addObserver(observer);
        FileFinder fileFinder = new FileFinder(rootDir, container, new FilenameFilterBasic());
        Thread thread = new Thread(fileFinder);
        thread.start();
    }
    
}
