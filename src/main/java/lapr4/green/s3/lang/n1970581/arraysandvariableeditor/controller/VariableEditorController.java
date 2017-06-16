/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor.controller;

import csheets.ui.ctrl.UIController;
import java.util.List;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ArrayItemDTO;

/**
 * The controller for the VariableEditor. interfaces ui with the main code.
 * @author Hugo
 */
public class VariableEditorController {
    
    /** The user interface controller */
    private final UIController uiController;

    /**
    * Creates a new VariableEditor controller.
    * @param uiController the user interface controller
    */    
    public VariableEditorController(UIController uiController){
        this.uiController = uiController;
    }
    
    /**
     * Returns the list of ArrayItems as DTO from the active Workbook ArrayStorage
     * @return the list of ArrayItems as DTO from the active Workbook ArrayStorage
     */
    public List<ArrayItemDTO> retriveActiveWorkbookVariableList(){
        if (this.uiController.getActiveWorkbook() == null) throw new NullPointerException("Active Workbook missing.");
        return this.uiController.getActiveWorkbook().retrieveArrayStorage().listContainerAsDTO();
    }
    
    
}
