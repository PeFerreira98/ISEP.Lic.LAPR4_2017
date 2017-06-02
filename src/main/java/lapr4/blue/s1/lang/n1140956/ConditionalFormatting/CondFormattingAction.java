/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.CondFormDialog;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ext.style.ui.StyleAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Marcos
 */
public class CondFormattingAction extends StyleAction implements SelectionListener {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     *
     * @param uiController
     */
    public CondFormattingAction(UIController uiController) {
        super(uiController);
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Conditional Formating";
    }

    @Override
    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_F);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (focusOwner == null) {
            return;
        }
        new CondFormDialog(uiController);
    }

    @Override
    public void selectionChanged(SelectionEvent event) {
        if (event.getCell() != null && event.isCellChanged()) {
            StylableCell cell = (StylableCell) event.getCell().getExtension(
                    StyleExtension.NAME);
        }
    }

    @Override
    protected void applyStyle(StylableCell cell) {
    }

}
