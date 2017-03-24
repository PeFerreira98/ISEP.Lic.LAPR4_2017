/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import csheets.ui.ctrl.UIController;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 * A panel for adding or editing a comment for a cell
 * @author Alexandre Braganca
 */
@SuppressWarnings("serial")
public class ContactPanel extends JPanel implements ActionListener {

        // Controller for Contacts
	private ContactController controller=null;

	/** The text field in which the comment of the cell is displayed.*/
        private JTextArea commentField = new JTextArea();

        
        // Controls for the contact panel
        private JLabel labelContacts=null;
        private JTextField contactsFilterField=null;
        private JList<Contact> contactsList=null;
        private DefaultListModel<Contact> model=null;
        private JButton contactsAddButton=null;
        private JButton contactsRemoveButton=null;
        private JButton contactsEditButton=null;

        private JPanel contactsPane= null;
        private JPanel filterPane = null;
        private JPanel buttonPane = null;
        
        // Action commands
        private final static String addAction="add";
        private final static String removeAction="remove";
        private final static String editAction="edit";
                
        private void setupContactsWidgets() {

            labelContacts=new JLabel("Filtro: ");
            
            // First Pane: The "filter", FlowLayout (from left to right)
            filterPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
            contactsFilterField=new JTextField();
            contactsFilterField.setColumns(10);
            
            filterPane.add(labelContacts);
            filterPane.add(contactsFilterField); 

            model = new DefaultListModel();
            Iterable<Contact> contacts=controller.allContacts();
            for(Contact c: contacts) {
                model.addElement(c);
            }

            contactsList = new JList(model);
            
            contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane centerPane=new JScrollPane(contactsList);

            // Last Pane: A row of buttons and the end
            buttonPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
            contactsAddButton=new JButton("Add");
            contactsAddButton.setActionCommand(ContactPanel.addAction);
            contactsAddButton.addActionListener(this);
            contactsRemoveButton=new JButton("Remove");
            contactsRemoveButton.setActionCommand(ContactPanel.removeAction);
            contactsRemoveButton.addActionListener(this);
            contactsEditButton=new JButton("Edit");
            contactsEditButton.setActionCommand(ContactPanel.editAction);
            contactsEditButton.addActionListener(this);
            buttonPane.add(contactsAddButton);
            buttonPane.add(contactsRemoveButton);
            buttonPane.add(contactsEditButton);
            
            // The parent Pane is of type BorderLayout so that the center list occupies all the "empty" canvas
            contactsPane = new JPanel(new BorderLayout());
            contactsPane.add(filterPane, BorderLayout.PAGE_START);
            contactsPane.add(centerPane, BorderLayout.CENTER);
            contactsPane.add(buttonPane, BorderLayout.PAGE_END);
        }
        
    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public ContactPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        // Creates controller
        this.controller = new ContactController(uiController.getUserProperties());

        setupContactsWidgets();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

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

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index=-1;
        
        switch (e.getActionCommand()) {
            case ContactPanel.addAction:
                {
                    Contact c=null;
                    ContactDialog.showDialog(this, contactsAddButton, this.controller,
                                        ContactDialog.ContactDialogMode.ADD, "New Contact");
                    if (ContactDialog.successResult()) {
                        c=ContactDialog.contact();
                        // Update the model of the JList
                        model.addElement(c);
                    }
                }
                break;

            case ContactPanel.removeAction:
                index=contactsList.getSelectedIndex();
                if (index!=-1) {
                    Contact c;
                    //c = (Contact)(contactsList.getModel().getElementAt(index));
                    c = model.getElementAt(index);

                    ContactDialog.showDialog(this, contactsRemoveButton, this.controller,
                                        ContactDialog.ContactDialogMode.DELETE, "Delete Contact", c);
                    if (ContactDialog.successResult()) {
                        // Update the model of the JList
                        model.remove(index);
                    }
                }
                break;

            case ContactPanel.editAction:
                index=contactsList.getSelectedIndex();
                if (index!=-1) {
                    Contact c;
                    //c = (Contact)(contactsList.getModel().getElementAt(index));
                    c = model.getElementAt(index);
                    
                    ContactDialog.showDialog(this, contactsEditButton, this.controller,
                                        ContactDialog.ContactDialogMode.EDIT, "Edit Contact", c);
                    if (ContactDialog.successResult()) {
                        // Update the model of the JList
                        model.set(index, c);
                    }
                    else {
                        // Maybe the user tried to update but failed and canceled. We need to "refresh" the contact object
                        Contact updatedContact=this.controller.getContactById(c.id());
                        // Update the model of the JList
                        model.set(index, updatedContact);
                    }
                        
                }
                break;
        }
    }
}
