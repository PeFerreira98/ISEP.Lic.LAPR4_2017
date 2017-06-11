/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.ipc.n1140618.ChatApplication.ui.UIExtensionChat;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class ChatExtension extends Extension {

    public static final String NAME = "Chat";
    /** The version number */
    public static final int VERSION = 1;
    /** The description */
    public static final String DESCRIPTION = "Chat extension from sprint 1.";

    /**
     * Creates a new chat extension
     */
    public ChatExtension() {
        super(NAME, VERSION, DESCRIPTION);
    }
 
    /**
     * Returns the user interface extension of this extension 
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
    	return new UIExtensionChat(this, uiController);
    }  



}
