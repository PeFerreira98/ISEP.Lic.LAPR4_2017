/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CreateRoomAction extends BaseAction {

    /**
     * User Interface Controller
     */
    UIController uiController;


    public CreateRoomAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Create a Chat Room";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        CreateChatRoomUI ui = new CreateChatRoomUI();
    }
}
