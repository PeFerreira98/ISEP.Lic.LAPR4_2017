package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ui.ExportLinkAction;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ui.ImportLinkAction;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ui.RemoveLinkAction;

/**
 * Represents the UI extension menu of the import and export text.
 *
 * Added Import/Export text link - 07/06/2017 
 * Added Remove text link - 10/06/2017
 *
 * @author Pedro Pereira
 */
public class ImportExportTextMenu extends JMenu
{

    /**
     * Creates an import export text menu. This constructor creates and adds the
     * menu options. In this feature/use case there are two menu options. The
     * import option is an action (in this case
     * {@link lapr4.green.s1.ipc.n1130626.importexporttext.ui.ImportAction}) The
     * export option is an action too (in this case
     * {@link lapr4.green.s1.ipc.n1130626.importexporttext.ui.ExportAction})
     * import link option is an action too (in this case
     * {@link lapr4.blue.s2.ipc.n1141233.importexportlink.ui.ImportLinkAction})
     * export link option is an action too (in this case
     * {@link lapr4.blue.s2.ipc.n1141233.importexportlink.ui.ExportLinkAction})
     * remove link option is an action too (in this case
     * {@link lapr4.blue.s2.ipc.n1141233.importexportlink.ui.RemoveLinkAction})
     *
     * @param uiController the user interface controller
     */
    public ImportExportTextMenu(UIController uiController)
    {
        super("Import/Export Text");
        setMnemonic(KeyEvent.VK_I);

        // Adds font actions
        add(new ImportAction(uiController));
        add(new ExportAction(uiController));

        // Adds import/export/remove link
        add(new ImportLinkAction(uiController));
        add(new ExportLinkAction(uiController));
        add(new RemoveLinkAction(uiController));
    }
}
