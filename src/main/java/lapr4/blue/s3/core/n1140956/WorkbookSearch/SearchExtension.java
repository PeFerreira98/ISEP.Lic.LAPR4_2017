/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140956.WorkbookSearch;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s3.core.n1140956.WorkbookSearch.ui.UIExtensionSearch;

/**
 *
 * @author Marcos
 */
public class SearchExtension extends Extension{
    
    public static final String NAME = "Search";
    /** The version number */
    public static final int VERSION = 1;
    /** The description */
    public static final String DESCRIPTION = "Search on active workbook";

    /**
     * Creates a new chat extension
     */
    public SearchExtension() {
        super(NAME, VERSION, DESCRIPTION);
    }
 
    /**
     * Returns the user interface extension of this extension 
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
    	return new UIExtensionSearch(this, uiController);
    }  
    
}
