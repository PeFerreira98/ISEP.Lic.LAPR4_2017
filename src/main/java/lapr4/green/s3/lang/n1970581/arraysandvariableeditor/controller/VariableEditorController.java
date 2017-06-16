/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor.controller;

import csheets.core.Value;
import csheets.ui.ctrl.UIController;
import java.util.Date;
import java.util.List;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ArrayItemDTO;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.VariableEditorWatchdog;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ui.VariableEditorPanel;

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
    
    
    /**
     * General method for editing the value of an ArrayItem using the DTO.
     * @param dto the DTO to change.
     * @param newValueAsText the new value in text form
     * @return sucess of operation
     */
    public boolean editArrayItem(ArrayItemDTO dto , String newValueAsText){
        if (this.uiController.getActiveWorkbook() == null) throw new NullPointerException("Active Workbook missing.");
        Value newValue = null;
        newValue = Value.parseValue(newValueAsText);
        //System.out.println("Debug: new edited value type = "+ newValue.getType().name());
        return this.uiController.getActiveWorkbook().retrieveArrayStorage().editArrayItem(dto, newValue);
    }
    
    
    
    
     /**
     * Register in the watch dog to start receiving updates.
     */
    public void registerInWatchdog(VariableEditorPanel ui){
        VariableEditorWatchdog.instance().addObserver(ui);
    }

    /**
     * Unregister, to stop receiving updates.
     */
    public void unregisterInWatchdog(VariableEditorPanel ui){
        VariableEditorWatchdog.instance().deleteObserver(ui);
    }
    
    
}
