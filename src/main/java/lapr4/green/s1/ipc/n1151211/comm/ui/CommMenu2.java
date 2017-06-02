/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm.ui;




import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Fernando
 */

public class CommMenu2 extends JMenu {

	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link ClientTestAction2})
	 * @param uiController the user interface controller
	 */
	public CommMenu2(UIController uiController) {
		super("Comm");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ClientTestAction2(uiController));
	}	
}
