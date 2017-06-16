/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140956.WorkbookSearch;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.regex.Pattern;

/**
 *
 * @author Marcos
 */
public class WorkbookSearchController {

    private final ArrayList<Cell> listCells;
    private final UIController uiCtrl;

    public WorkbookSearchController(UIController uiController) {
        this.listCells = new ArrayList<>();
        this.uiCtrl = uiController;
    }

    private void addCell(Cell cell) {
        this.listCells.add(cell);
    }

    /**
     * Method to compare the string given with the cell content and cell value.
     *
     * @param input string that will be compared
     * @param c
     * @return TRUE or FALSE
     */
    public boolean checkCell(String input, Cell c) {
        if (Pattern.matches(input, c.getContent()) 
                || Pattern.matches(input, c.getValue().toString()) ) {
            return true;
        }
        return false;
    }

    /**
     * Method to search on the active workbook the cells that matches with the the regular expression given. 
     * This method will aplly the regular expression on the content and cell's value.
     * @param input regular expression
     */
    public void search(String input) {
        int spreadsheetCount = this.uiCtrl.getActiveWorkbook().getSpreadsheetCount();

        for (int i = 0; i < spreadsheetCount; i++) {
            SortedSet<Cell> cells = this.uiCtrl.getActiveWorkbook().getSpreadsheet(i).getCells(new Address(0, 0), new Address(51, 127));

            for (Cell c : cells) {
                if (checkCell(input, c)) {
                    this.addCell(c);
                }
            }
        }
    }

    public ArrayList<Cell> getCellList() {
        return this.listCells;
    }

    public void clear() {
        this.listCells.clear();
    }

}
