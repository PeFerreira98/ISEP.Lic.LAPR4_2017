/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import lapr4.blue.s3.core.n1140948.contactstag.controller.TagController;
import lapr4.blue.s3.core.n1140948.contactstag.ui.AssociateTagUI;

/**
 *
 * @author Tiago Silvestre
 */
public class ContactsTagAction extends FocusOwnerAction {

    private UIController uiController;
    public static String NAME = "Contacts Tag";

    public ContactsTagAction(UIController uiController) {
        this.uiController = uiController;

    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AssociateTagUI();
    }
    
}
