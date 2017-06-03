/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Tiago
 */
public class ChatExtensionMenu extends JMenu{
    
    public ChatExtensionMenu(UIController uiController){
        super("Import/Export Text");
        setMnemonic(KeyEvent.VK_C);
    }
    
}
