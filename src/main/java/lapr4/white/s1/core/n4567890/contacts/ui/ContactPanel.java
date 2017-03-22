/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;

/**
 * A panel for adding or editing a comment for a cell
 * @author Alexandre Braganca
 */
@SuppressWarnings("serial")
public class ContactPanel extends JPanel {

	/** The assertion controller */
	//private CommentController controller;


	/** The text field in which the comment of the cell is displayed.*/
        private JTextArea commentField = new JTextArea();

        
        // Controls for the contact panel
        JLabel labelContacts=null;
        JTextField contactsFilterField=new JTextField();
        JList contactsList=new JList();
        JButton contactsAddButton=new JButton();
        JButton contactsRemoveButton=new JButton();
        JButton contactsEditButton=new JButton();

        JPanel labelPane = null;
                
        private void setupContactsWidgets() {

            labelContacts=new JLabel("Filtro: ");
            
            //Lay out the labels in a panel.
            labelPane = new JPanel(new GridLayout(0,1));
            labelPane.add(labelContacts);
        }
        
	/**
	 * Creates a new comment panel.
	 * @param uiController the user interface controller
	 */
	public ContactPanel(UIController uiController) {
		// Configures panel
		super(new BorderLayout());
		setName(ContactsExtension.NAME);

		// Creates controller
		//controller = new CommentController(uiController, this);
		//uiController.addSelectionListener(this);

		// Creates comment components
		ApplyAction applyAction = new ApplyAction();
		
//		commentField.setPreferredSize(new Dimension(120, 240));		// width, height
//		commentField.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
//		commentField.addFocusListener(applyAction);
//		commentField.setAlignmentX(Component.CENTER_ALIGNMENT);

                setupContactsWidgets();
                
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
			
                JPanel contactsPane = new JPanel(new GridLayout(0, 1));

                
                JPanel agendaPane = new JPanel(new GridLayout(0, 1));
                
			// Adds borders
			TitledBorder border = BorderFactory.createTitledBorder("Contacts");
			border.setTitleJustification(TitledBorder.CENTER);
			contactsPane.setBorder(border);
                        
			border = BorderFactory.createTitledBorder("Agenda");
			border.setTitleJustification(TitledBorder.CENTER);
			agendaPane.setBorder(border);
	
			// Creates side bar
			mainPanel.add(contactsPane);
			mainPanel.add(agendaPane);                
                
                
                
		// Lays out comment components
		//JPanel contactPanel = new JPanel();
		//contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.PAGE_AXIS));
		//contactPanel.setPreferredSize(new Dimension(130, 336));
		//contactPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
		
                contactsPane.add(labelPane);

		// Adds borders
//		TitledBorder border = BorderFactory.createTitledBorder("Contact");
//		border.setTitleJustification(TitledBorder.CENTER);
//		contactPanel.setBorder(border);

		// Adds panels
		//JPanel northPanel = new JPanel(new BorderLayout());
		//northPanel.add(contactPanel, BorderLayout.NORTH);
		//add(northPanel, BorderLayout.NORTH);
                add(mainPanel);
                //this.repaint();

        }
	
	protected class ApplyAction implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
//			if (cell != null) {
//				controller.setComment(cell, commentField.getText().trim());
//			}
		}
	}
}
