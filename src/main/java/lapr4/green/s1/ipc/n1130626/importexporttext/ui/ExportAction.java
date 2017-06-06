/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * An action of the extension that exemplifies how to export data to a text
 * file.
 *
 * @author Pedro Pereira
 */
public class ExportAction extends FocusOwnerAction
{

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ExportAction(UIController uiController)
    {
        this.uiController = uiController;
    }

    @Override
    protected String getName()
    {
        return "Export data to a text file";
    }

    @Override
    protected void defineProperties()
    {
    }

    /**
     * The action that perfoms when select this option. It opens a specific UI
     * to fill the data and Exports.
     *
     * @param ae the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //JOptionPane.showMessageDialog(null, "This is only a test if it work here. Export");
        Cell[][] selectedCells = this.focusOwner.getSelectedCells();
        ExportUI eUI = new ExportUI(selectedCells, uiController);
        eUI.setVisible(true);
    }

}
