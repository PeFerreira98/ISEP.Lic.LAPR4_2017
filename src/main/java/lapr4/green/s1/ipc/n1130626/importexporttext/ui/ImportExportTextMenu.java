/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Representes the UI extension menu of the import and export data.
 * @author Pedro Pereira
 */
public class ImportExportTextMenu extends JMenu {
    
    
    /**
     * Creates an import export data menu.
     * This constructor creates and adds the menu options. 
     * In this feature/use case there are two menu options.
     * The import option is an action (in this case {@link csheets.ext.simple.ui.ImportAction})
     * The export option is an action too
     * @param uicontroller the user interface controller
     */
    public ImportExportTextMenu(UIController uicontroller){
        super("Import/Export Data");
        setMnemonic(KeyEvent.VK_I);
        
    }
}
