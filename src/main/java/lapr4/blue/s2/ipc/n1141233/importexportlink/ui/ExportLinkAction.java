package lapr4.blue.s2.ipc.n1141233.importexportlink.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * An action of the extension that exemplifies how to export data link to a text
 * file.
 *
 * @author Rafael Vieira
 */
public class ExportLinkAction extends FocusOwnerAction
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
    public ExportLinkAction(UIController uiController)
    {
        this.uiController = uiController;
    }

    @Override
    protected String getName()
    {
        return "Export data link to a text file";
    }

    @Override
    protected void defineProperties()
    {
        // do nothing
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
        Cell[][] selectedCells = this.focusOwner.getSelectedCells();
        ExportLinkUI eUI = new ExportLinkUI(selectedCells, uiController);
        eUI.setVisible(true);
    }

}
