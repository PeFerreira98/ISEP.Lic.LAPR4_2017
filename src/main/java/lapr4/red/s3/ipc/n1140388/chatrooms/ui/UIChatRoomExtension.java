/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 * This class implements the UI interface extension for the chat rooms
 * extension. A UI interface extension must extend the UIExtension abstract
 * class.
 *
 * @see UIExtension
 * @author Alexandra Ferreira 1140388
 */
public class UIChatRoomExtension extends UIExtension {

    /**
     * A sidebar that provides to create a chat room
     */
    private JComponent sidebar;
    
    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIChatRoomExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
    /**
     * Returns a side bar that provides received messages
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sidebar == null) {
            sidebar = new ChatRoomPanel(uiController);
        }
        return sidebar;
    }
}
