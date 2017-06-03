/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.controller;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.Formatter;

/**
 *
 * @author Pedro Pereira
 */
public class ImportExportTextController {
    
    /** The user interface controller */
    private UIController uiController;
    
    /**
     * 
     * @param uiController 
     */
    public ImportExportTextController(UIController uiController){
        this.uiController = uiController;
    }
    
    /**
     * Empty constructor.
     */
    public ImportExportTextController(){
    }
    
    /**
     * 
     * @param cells
     * @return 
     */
    public String getRangeOfCells(Cell[][] cells){
        String range = cells[0][0].getAddress().toString();
        if(cells.length > 1 || cells[0].length > 1) {
            range += ":" + cells[cells.length - 1][cells[0].length - 1].getAddress().toString();
        }
        return range;
    }
    
    /**
     * 
     * @param selectedCells
     * @param filename
     * @param specialChar
     * @throws Exception 
     */
    public void exportToTextFile(Cell[][] selectedCells, String filename, String specialChar) throws Exception {
        if(filename.isEmpty()){
            throw new Exception("Please insert a name");
        }
        
        if(!filename.endsWith(".txt")){
            filename = filename + ".txt";
        }
        
        if(new File(filename).exists()){
            throw new Exception("The text file already exists");
        }
        
        Formatter fOut = new Formatter(new File(filename));
        String text;
        
        for(Cell[] rows : selectedCells){
            text = "";
            for(Cell columns : rows){
                if(columns.getContent().isEmpty()){
                    text += " " + specialChar;
                } else {
                    text += columns.getContent() + specialChar;
                }             
            }
            fOut.format(text.substring(0, text.length()) + "\n");
        }
        fOut.close();
    }
    
    /**
     * 
     * @param specialChar
     * @param selectedCells
     * @throws Exception 
     */
    public void checkCells(String specialChar, Cell[][] selectedCells) throws Exception {
        for(Cell[] rows : selectedCells){
            for(Cell columns : rows){
                if(columns.getContent() != null){
                    if(columns.getContent().contains(specialChar)){
                        throw new Exception("This cell contains the special character that you selected, please replace it");
                    }
                }
            }
        }
    }
}
