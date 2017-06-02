/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s1.lang.n1140956.ConditionalFormatting.CondlFormattingController;

/**
 *
 * @author Marcos
 */
public class CondFormattingListener implements CellListener {

    private final Cell cell;
    private final String condition;

    private final Font trueFont;
    private final Font falseFont;
    private final Color trueBackColor;
    private final Color falseBackColor;

    public CondFormattingListener(Cell cell, String condition, Font trueFont, Font falseFont, Color trueBackColor, Color falseBackColor) {
        this.condition = condition;
        this.trueBackColor = trueBackColor;
        this.trueFont = trueFont;
        this.falseBackColor = falseBackColor;
        this.falseFont = falseFont;
        this.cell = cell;
    }

    public String getCondition() {
        return this.condition;
    }

    @Override
    public void valueChanged(Cell cell) {
        if(!cell.getContent().isEmpty()){
            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
            stylableCell.setBackgroundColor(new Color(0, 0, 0));
            verifyFormula();
        }
    }

    @Override
    public void contentChanged(Cell cell) {
        if(!cell.getContent().isEmpty()){
            verifyFormula();
        }
        
    }

    @Override
    public void dependentsChanged(Cell cell) {
        verifyFormula();
    }

    @Override
    public void cellCleared(Cell cell) {

    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
    }

    /**
     * this method will verify if the formula is true or false. Depending on
     * that result, it will apply the right settings to the selected cell.
     *
     */
    public void verifyFormula() {
        if (condition != null) {
            try {
                Formula form = FormulaCompiler.getInstance().compile(cell, "="+cell.getContent() + condition);
                
                try {
//                    System.out.println(form.evaluate());
//                    System.out.println(form.getExpression().evaluate());
                    if (form.getExpression().evaluate().toBoolean()) {
                        StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);

                        if (this.trueFont != null) {
                            stylableCell.setFont(trueFont);
                        }
                        if (this.trueBackColor != null) {
                            stylableCell.setBackgroundColor(trueBackColor);
                        }

                    } else {
                        StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);

                        if (this.falseFont != null) {
                            stylableCell.setFont(falseFont);
                        }
                        if (this.falseBackColor != null) {
                            stylableCell.setBackgroundColor(falseBackColor);
                        }
                    }
                } catch (IllegalValueTypeException ex) {
                    Logger.getLogger(CondlFormattingController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(CondFormattingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
