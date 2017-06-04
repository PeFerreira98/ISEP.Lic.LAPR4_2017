/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 * This class implements the UI interface extension for the Import Export Data extension.
 * A UI interface extension must extend the UIExtension abstract class.
 * @see UIExtension
 * @author Pedro Pereira
 */
public class UIExtensionImportExportText extends UIExtension {
    
        /** The icon to display with the extension's name */
	private Icon icon;
    
        /** The menu of the extension */
        private ImportExportTextMenu menu;
        
        public UIExtensionImportExportText(Extension extension, UIController uiController) {
            super(extension, uiController);
        }
    
        /**
	 * Returns an icon to display with the extension's name.
	 * @return an icon with style
	 */
	public Icon getIcon() {
		return null;
	}
    
        /**
         * Returns an instance of a class that implements JMenu.
         * In this case this class supplies two options.
         * @return a JMenu component
         */
        public JMenu getMenu() {
            if (menu == null)
                menu = new ImportExportTextMenu(uiController);
            return menu;
        }
        
        /**
	 * Returns a cell decorator that visualizes the data added by the extension.
	 * @return a cell decorator, or null if the extension does not provide one
	 */
	public CellDecorator getCellDecorator() {
		return null;
	}
        
        /**
	 * Returns a table decorator that visualizes the data added by the extension.
	 * @return a table decorator, or null if the extension does not provide one
	 */
	public TableDecorator getTableDecorator() {
		return null;
	}
        
        /**
	 * Returns a toolbar that gives access to extension-specific
	 * functionality.
	 * @return a JToolBar component, or null if the extension does not provide one
	 */
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a side bar that gives access to extension-specific
	 * functionality.
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		return null;
	}	
}
