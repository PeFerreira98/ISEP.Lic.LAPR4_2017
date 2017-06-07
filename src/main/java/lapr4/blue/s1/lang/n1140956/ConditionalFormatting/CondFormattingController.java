/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Value;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

/**
 *
 * @author Marcos
 */
public class CondFormattingController{

    private Font trueFont;
    private Font falseFont;
    private Color trueBackColor;
    private Color falseBackColor;

    private final UIController uiController;

    public CondFormattingController(UIController uiController) {
        this.uiController = uiController;
    }

    public Font getTrueFont() {
        return trueFont;
    }

    public Font getFalseFont() {
        return falseFont;
    }

    public Color getTrueBackColor() {
        return trueBackColor;
    }

    public Color getFalseBackColor() {
        return falseBackColor;
    }

    /*
    Metodo to get all selectedCells
    */
    public Cell[][] getAllSelectCells() {
        return this.uiController.focusOwner().getSelectedCells();
    }
//    /**
//     * this method will return a list of cells by receiving two strings and will converts that strings to integer to get the correct possition on the vector.
//     * @param firstCell ex: A1
//     * @param lastCell  ex: B6
//     * @return An sorted list of cells.
//     */
//    public SortedSet<Cell> getCells(String firstCell, String lastCell) {
//        String columnAux = firstCell.substring(0, 1);
//        char option = columnAux.charAt(0);
//        String rowAux = firstCell.substring(1);
//        int column = (int) option;
//        int row = Integer.parseInt(rowAux);
//        Address FirstCellAd = new Address((column - 65), row - 1); //como o A em ASCII é o numero 65, então tem-se que subtrair para dar a posição correta na tabela
//
//        columnAux = lastCell.substring(0, 1);
//        option = columnAux.charAt(0);
//        rowAux = lastCell.substring(1);
//        column = (int) option;
//        row = Integer.parseInt(rowAux);
//        Address LastCellAd = new Address((column - 65), row - 1);
//        return this.uiController.getActiveSpreadsheet().getCells(FirstCellAd, LastCellAd);
//
//    }
    

    /**
     *
     * @param TrueFont
     */
    public void setTrueFont(Font TrueFont) {
        this.trueFont = TrueFont;
    }

    /**
     *
     * @param FalseFont
     */
    public void setFalseFont(Font FalseFont) {
        this.falseFont = FalseFont;
    }

    /**
     *
     * @param TrueBackColor
     */
    public void setTrueBackColor(Color TrueBackColor) {
        this.trueBackColor = TrueBackColor;
    }

    /**
     *
     * @param FalseBackColor
     */
    public void setFalseBackColor(Color FalseBackColor) {
        this.falseBackColor = FalseBackColor;
    }

    public CondFormattingListener addListener(String value, String operator, Cell cell) {
        CondFormattingListener cl = new CondFormattingListener( cell,  value, operator, trueFont,  falseFont,  trueBackColor,  falseBackColor);
        cell.addCellListener(cl);
        if(cell.getValue().isOfType(Value.Type.NUMERIC)){
            cl.verifyFormula();
        }
        return cl;
    }

    

}
