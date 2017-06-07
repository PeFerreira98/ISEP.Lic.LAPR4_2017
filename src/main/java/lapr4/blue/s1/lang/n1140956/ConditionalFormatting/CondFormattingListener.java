/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class CondFormattingListener implements CellListener {

    private final Cell cell;
    private final String value;
    private final String operator;

    private final Font trueFont;
    private final Font falseFont;
    private final Color trueBackColor;
    private final Color falseBackColor;

    public CondFormattingListener(Cell cell, String value, String operator, Font trueFont, Font falseFont, Color trueBackColor, Color falseBackColor) {
        this.value = value;
        this.operator = operator;
        this.trueBackColor = trueBackColor;
        this.trueFont = trueFont;
        this.falseBackColor = falseBackColor;
        this.falseFont = falseFont;
        this.cell = cell;
    }

    public String getCondition() {
        return this.operator+this.value;
    }

    public String getValue(){
        return this.value;
    }
    
    /**
     * when we change something on the cell, we need to verify the new number and if the the cell is empty or not
     * @param cell 
     */
    @Override
    public void valueChanged(Cell cell) {
        if (!cell.getContent().isEmpty() && cell.getValue().isOfType(Value.Type.NUMERIC)) {
            verifyFormula();
        } else {
            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
            stylableCell.setBackgroundColor(new Color(255, 255, 255));
        }

    }

    /**
     * when we change something on the cell, we need to verify the new number and if the the cell is empty or not
     * @param cell 
     */
    @Override
    public void contentChanged(Cell cell) {
        if (!cell.getContent().isEmpty() && cell.getValue().isOfType(Value.Type.NUMERIC)) {
            verifyFormula();
        } else {
            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
            stylableCell.setBackgroundColor(new Color(255, 255, 255));
        }

    }

    @Override
    public void dependentsChanged(Cell cell) {}

    @Override
    public void cellCleared(Cell cell) {}

    @Override
    public void cellCopied(Cell cell, Cell source) {}

    /**
     * this method will verify if the formula is true or false. Depending on
     * that result, it will apply the right settings to the selected cell.
     *
     */
    public void verifyFormula() {
        if (this.value != null && !cell.getContent().isEmpty()) {
            try {
                Formula form = FormulaCompiler.getInstance().compile(cell, "=" + cell.getContent() + this.operator + this.value);

                try {
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
                    Logger.getLogger(CondFormattingController.class.getName()).log(Level.SEVERE, null, ex);

                }
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(CondFormattingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
