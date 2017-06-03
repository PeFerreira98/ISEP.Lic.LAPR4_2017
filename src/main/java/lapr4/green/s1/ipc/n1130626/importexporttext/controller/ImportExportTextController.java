/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.controller;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

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
    
    public void importFromTextFile(String filename, String specialChar, boolean containsHeader) throws Exception {
        if(filename.isEmpty()){
            throw new Exception("Please insert a name");
        }
        Cell activeCell = uiController.getActiveCell();
        Spreadsheet activeSpreadsheet = uiController.getActiveSpreadsheet();
        
        Scanner scanner = new Scanner(new File(filename));
        int row;
        int column;
        
        if(containsHeader){
            row = 0;
            column = 0;
        } else {
            row = activeCell.getAddress().getRow();
            column = activeCell.getAddress().getColumn();
        }
        
        List<String[]> matrix = new ArrayList<>();
        String[] line;
        while(scanner.hasNext()){
            line = scanner.nextLine().split(specialChar);
            if(line.length > 0){
                matrix.add(line);
            }
        }
        scanner.close();
        
        int size;
        int max;
        for(int i = 0; i < matrix.size(); i++){
            size = matrix.get(i).length;
            max = size + column;
            for(int j = column; j < max; j++){
                Cell cell = activeSpreadsheet.getCell(new Address(j, row + i));
                cell.setContent(matrix.get(i)[j-column]);
            }
        }
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
            text += "\n";
            fOut.format(text.substring(0, text.length()));
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
