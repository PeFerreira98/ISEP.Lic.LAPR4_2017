/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.ipc.n1970581.findworkbook.ui.UIExtensionSearchWorkbook;

/**
 * Extension for IPC01.1 Search Workbook
 * This is a side bar extension.
 * @author Hugo
 */
public class SearchWorkbookExtension extends Extension{
    
    /** The name of the extension */
    public static final String NAME = " Search Workbook";
    /** The version number */
    public static final int VERSION = 1;
    /** The description */
    public static final String DESCRIPTION = "Extension for searching workbooks in the local directory.";

    
    /**
    * Creates a new Example extension.
    */
    public SearchWorkbookExtension() {
	super(NAME, VERSION, DESCRIPTION);
    }
        
        
        
    /**
     * Returns the user interface extension of this extension 
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
    	return new UIExtensionSearchWorkbook(this, uiController);
    }    
    
}
