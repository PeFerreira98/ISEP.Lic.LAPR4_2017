/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomsMenu extends JMenu {

    /**
     * Creates a JMenu with the sorting options
     *
     * @param uiController The User Interface Controller associated with this
     * instance
     */
    public ChatRoomsMenu(UIController uiController) {
        super("Chat Rooms");
        add(new CreateRoomAction(uiController));
    }

}
