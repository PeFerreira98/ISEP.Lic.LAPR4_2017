package lapr4.green.s1.ipc.n1130626.importexporttext;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.ipc.n1130626.importexporttext.ui.UIExtensionImportExportText;

/**
 * This is an extension about the import and export data features. An extension
 * must extend the Extension abstract class. The class that implements the
 * Extension is the "bootstrap" of the extension.
 *
 * @see Extension
 * @author Pedro Pereira
 */
public class ExtensionImportExportText extends Extension
{

    /**
     * The name of the extension
     */
    public static final String NAME = "Import Export Text";
    public static final String DESCRIPTION = "Imports and exports cell's data to/from a text file";

    /**
     * Creates a new Import Export Data extension.
     */
    public ExtensionImportExportText()
    {
        super(NAME, 2, DESCRIPTION);
    }

    /**
     * Returns the user interface extension of this extension (an instance of
     * the class
     * {@link lapr4.green.s1.ipc.n1130626.importexporttext.ui.UIExtensionImportExportText}).
     * In this extension example we are only extending the user interface.
     *
     * @param uiController the user interface controller
     *
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController)
    {
        return new UIExtensionImportExportText(this, uiController);
    }
}
