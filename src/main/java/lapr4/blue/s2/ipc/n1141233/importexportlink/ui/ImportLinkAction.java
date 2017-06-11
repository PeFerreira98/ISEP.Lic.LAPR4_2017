package lapr4.blue.s2.ipc.n1141233.importexportlink.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * An action of the extension that exemplifies how to import data from a text
 * file.
 *
 * @author Rafael Vieira
 */
public class ImportLinkAction extends FocusOwnerAction
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
    public ImportLinkAction(UIController uiController)
    {
        this.uiController = uiController;
    }

    @Override
    protected String getName()
    {
        return "Import data link from a text file";
    }

    @Override
    protected void defineProperties()
    {
        // do nothing
    }

    /**
     * The action that perfoms when select this option. It opens a specific UI
     * to fill the data and Imports.
     *
     * @param ae the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        ImportLinkUI iui = new ImportLinkUI(uiController);
        iui.setVisible(true);
        focusOwner.updateUI();
    }
}
