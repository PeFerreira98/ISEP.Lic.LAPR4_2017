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
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the chat rooms
 * extension. A UI interface extension must extend the UIExtension abstract
 * class.
 *
 * @see UIExtension
 * @author Alexandra Ferreira 1140388
 */
public class UIChatRoomExtension extends UIExtension {

    private JComponent sidebar;
    
    /**
     * A menu that provides to create a chat room
     */
    private ChatRoomsMenu menu;

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
     * Returns an instance of a class that implements JMenu.
     *
     * @return menu of extension
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ChatRoomsMenu(uiController);
        }
        return menu;
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
