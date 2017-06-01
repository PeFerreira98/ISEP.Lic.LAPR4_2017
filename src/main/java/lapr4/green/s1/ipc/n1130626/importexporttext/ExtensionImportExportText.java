/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext;

import csheets.ext.Extension;

/**
 * This is an extension about the import and export data features.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author Pedro Pereira
 */
public class ExtensionImportExportText extends Extension {
    
        /** The name of the extension */
	public static final String NAME = "Import Export Data";
    
        /**
         * Creates a new Import Export Data extension.
         */
    public ExtensionImportExportText() {
        super(NAME);
    }
    
}
