package lapr4.blue.s2.ipc.n1141233.importexportlink.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * An action of the extension that exemplifies how to remove an active link.
 *
 * @author Rafael Vieira
 */
public class RemoveLinkAction extends FocusOwnerAction
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
    public RemoveLinkAction(UIController uiController)
    {
        this.uiController = uiController;
    }

    @Override
    protected String getName()
    {
        return "Remove active import/export link";
    }

    @Override
    protected void defineProperties()
    {
        // do nothing
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        RemoveLinkUI iui = new RemoveLinkUI(uiController);
        iui.setVisible(true);
        focusOwner.updateUI();
    }

}
