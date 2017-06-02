/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class CondlFormattingController{

    private Font trueFont;
    private Font falseFont;
    private Color trueBackColor;
    private Color falseBackColor;
    private String formula;

    private UIController uiController;

    public CondlFormattingController(UIController uiController) {
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

//    /**
//     * this method will verify if the formula is true or false. Depending on
//     * that result, it will apply the right settings to the selected cell.
//     *
//     * @param formula
//     * @param arrayCell
//     */
//    public void verifyFormula(String formula, Cell cell) {
//        if (formula != null) {
//            this.formula = formula;
//                try {
//                    Formula form = FormulaCompiler.getInstance().compile(cell, formula);
//                    try {
//                        if (form.getExpression().evaluate().toBoolean()) {
//                            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
//
//                            if (this.trueFont != null) {
//                                stylableCell.setFont(trueFont);
//                            }
//                            if (this.trueBackColor != null) {
//                                stylableCell.setBackgroundColor(trueBackColor);
//                            }
//
//                        } else {
//                            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
//
//                            if (this.falseFont != null) {
//                                stylableCell.setFont(falseFont);
//                            }
//                            if (this.falseBackColor != null) {
//                                stylableCell.setBackgroundColor(falseBackColor);
//                            }
//                        }
//                    } catch (IllegalValueTypeException ex) {
//                        Logger.getLogger(CondlFormattingController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                } catch (FormulaCompilationException ex) {
//                    Logger.getLogger(CondlFormattingController.class.getName()).log(Level.SEVERE, null, ex);
//                
//            }
//        }
//    }

    public SortedSet<Cell> getCells(String FirstCell, String LastCell) {
        String ColumnS = FirstCell.substring(0, 1);
        char option = ColumnS.charAt(0);
        String rowS = FirstCell.substring(1);
        int column = (int) option;
        int row = Integer.parseInt(rowS);
        Address FirstCellAd = new Address((column - 65), row - 1);

        ColumnS = LastCell.substring(0, 1);
        option = ColumnS.charAt(0);
        rowS = LastCell.substring(1);
        column = (int) option;
        row = Integer.parseInt(rowS);
        Address LastCellAd = new Address((column - 65), row - 1);

        return this.uiController.getActiveSpreadsheet().getCells(FirstCellAd, LastCellAd);

    }

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

    public void addListener(String text, Cell cell) {
        CondFormattingListener cl = new CondFormattingListener( cell,  text,  trueFont,  falseFont,  trueBackColor,  falseBackColor);
        cell.addCellListener(cl);
        cl.verifyFormula();
    }

    

}
