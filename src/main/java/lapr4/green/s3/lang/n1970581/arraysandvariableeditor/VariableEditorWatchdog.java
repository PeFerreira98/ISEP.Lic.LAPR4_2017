/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import java.util.Observable;

/**
 * Watchdog that signals changes in the ArrayStorage
 * @author Hugo
 */
public class VariableEditorWatchdog extends Observable{
    
      /** The VariableEditorWatchdog instance */
    private static final VariableEditorWatchdog instance = new VariableEditorWatchdog();  
    
    /**
     * Private constructor for the VariableEditorWatchdog
     */
    private VariableEditorWatchdog(){
        //empty by default.
    }
    /**
     * How to get the VariableEditorWatchdog
     * @return the VariableEditorWatchdog
     */
    public static VariableEditorWatchdog instance(){
        return instance;
    }
    
    /**
     * Used to indicate to the observers that a change has occured.
     */
    public synchronized void signalChange(){
        this.setChanged();
        this.notifyObservers();
    }
}
