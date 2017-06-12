/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.ipc.n1140388.chatrooms.ui.UIChatRoomExtension;

/**
 * An extension to support chat rooms.
 *
 * @author Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class ChatRoomExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Chat Rooms";
    /**
     * The version number
     */
    public static final int VERSION = 1;
    /**
     * The description
     */
    public static final String DESCRIPTION = "Events related extension from sprint 1.";

    /**
     * Creates a new Event extension.
     */
    public ChatRoomExtension() {
        super(NAME, VERSION, DESCRIPTION);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {

        return new UIChatRoomExtension(this, uiController);

    }
}
