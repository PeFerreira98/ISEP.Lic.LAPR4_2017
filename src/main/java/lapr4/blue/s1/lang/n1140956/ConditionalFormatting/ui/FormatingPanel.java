/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;


/**
 *
 * @author Marcos
 */
@SuppressWarnings("serial")
public class FormatingPanel extends JPanel implements ActionListener {

     // Controller for Contacts
    private ContactController controller=null;
    private JPanel contactsPane= null;
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public FormatingPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        // Creates controller
        this.controller = new ContactController(uiController.getUserProperties());

        setupFormatingWidgets();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Formating Settings");
        border.setTitleJustification(TitledBorder.CENTER);
        contactsPane.setBorder(border);

        // Creates side bar
        mainPanel.add(contactsPane);

        add(mainPanel);
    }
    
    private void setupFormatingWidgets() {
        
        contactsPane = new JPanel(new BorderLayout());

    }
}
