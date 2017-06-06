/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the Import Export Data
 * extension. A UI interface extension must extend the UIExtension abstract
 * class.
 *
 * @see UIExtension
 * @author Pedro Pereira
 */
public class UIExtensionImportExportText extends UIExtension
{
    /**
     * The menu of the extension
     */
    private ImportExportTextMenu menu;

    public UIExtensionImportExportText(Extension extension, UIController uiController)
    {
        super(extension, uiController);
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    @Override
    public Icon getIcon()
    {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu. In this case this
     * class supplies two options.
     *
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu()
    {
        if (menu == null)
        {
            menu = new ImportExportTextMenu(uiController);
        }
        return menu;
    }
}
