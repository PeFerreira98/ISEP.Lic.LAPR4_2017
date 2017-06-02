/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.ui;

import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import csheets.ui.ctrl.UIController;
import eapli.util.DateTime;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 * A panel for adding, editing or removing an event.
 *
 * @author Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class EventPanel extends JPanel implements SelectionListener {

    private JButton btnFinish;
    private JButton btnUpdate;

    private final JList listEvents;

    private final JButton btnCreate;
    private final JButton btnEdit;
    private final JButton btnRemove;

    private final JButton selectedContact;
    private final JComboBox contactComboBox;
    private final ContactController controller;

    private Contact contact;

    private Object[] contactsList;
    private Object[] eventsList;

    /**
     * Creates a new event panel.
     *
     * @param uiController the user interface controller
     */
    public EventPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());

        // Creates controller
        this.controller = new ContactController(uiController.getUserProperties());

        uiController.addSelectionListener(this);
        setName(ContactsExtension.NAME);

        JPanel contactsPanel = new JPanel(new GridLayout(3, 0));
        JPanel eventsListPanel = new JPanel(new GridLayout(1, 0));
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 0));

        //Creates comboBox of Contacts and List of Events
        contactComboBox = createContactsComboBox();
        listEvents = createList();
        eventsListPanel.add(listEvents);

        //Add combo box and button to choose contact on panel and finish the operation with that contact
        contactsPanel.add(createUpdateFinishButtonPanel());
        contactsPanel.add(contactComboBox);
        selectedContact = buttonChooseContact();
        contactsPanel.add(selectedContact);

        //Creates buttons to add, edit and remove events
        btnCreate = buttonCreate();
        btnEdit = buttonEdit();
        btnRemove = buttonDelete();

        //Add buttons to panel
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));
        buttonsPanel.add(btnCreate);
        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnRemove);
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));

        // Creates side bar
        add(contactsPanel, BorderLayout.NORTH);
        add(eventsListPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setInterfaceToContact(null, false);

    }

    @Override
    public void selectionChanged(SelectionEvent event) {

    }

    /**
     * Creates a combo box to choose the contact.
     *
     * @return combo box
     */
    private JComboBox createContactsComboBox() {
        String[] contactNames = showAllContacts();
        JComboBox contatos = new JComboBox(contactNames);
        return contatos;
    }

    /**
     * Returns an array with the names of contacts to be visible on the combo
     * box, and adds all objects of contacts on the contactsList array.
     *
     * @return array with the contacts name
     */
    private String[] showAllContacts() {
        int i = 0;

        List<Contact> list = (List<Contact>) controller.allContacts();

        String[] names = new String[list.size()];

        if (list.isEmpty()) {
            return names;
        }

        Object[] data = (Object[]) (Object) list.toArray(new Object[list.size()]);

        for (Object obj : data) {
            Contact contact = (Contact) obj;
            names[i] = "Name: " + contact.firstName() + " " + contact.lastName();
            i++;
        }

        contactsList = data;

        return names;
    }

    /**
     * Creates a list where the contacts will be show.
     *
     * @return list on the panel
     */
    private JList createList() {
        Object[] data = {};
        JList list = new JList(data);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(1000, 3000));
        return list;
    }

    /**
     * Creates a button that will select the contact to manage the events of his
     * agenda.
     *
     * @return the button to select the contact
     */
    private JButton buttonChooseContact() {
        JButton choise = new JButton(" Select Contact ");
        choise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (contactComboBox.getSelectedItem() != null) {
                        Contact contact = getContact(contactComboBox.getSelectedIndex());

                        String info = popUpWithEvents(contact);
                        
                        PopUp up = new PopUp(EventPanel.this, true, controller, info);
                        
                        setInterfaceToContact(contact, true);
                    } else {
                        JOptionPane.showMessageDialog(EventPanel.this,
                                "Please select a contact",
                                "Show Contact",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NullPointerException e) {
                    setInterfaceToContact(null, false);
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "The contact doesen't exist, please refresh there contact list",
                            "Contact Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        return choise;
    }

    private String popUpWithEvents(Contact contact) {

        List<Event> eventsForToday = null;

        showAllEvents(contact);

        String popUp = null;

        for (Object obj : eventsList) {
            Event e = (Event) obj;
            if (e.time().equals(Calendar.getInstance())) {
                eventsForToday.add(e);
            }
        }

        if (eventsForToday != null) {
            popUp = eventsForToday.toString();
        }

        
            popUp = "The contact has no events for today";
        

        return popUp;
    }

    /**
     * Get the contact selected on the combo box.
     *
     * @param selectedIndex index of contact chosen on combo box
     * @return the contact chosen
     */
    public Contact getContact(int selectedIndex) {

        if (contactsList == null) {
            return null;
        }

        return (Contact) contactsList[selectedIndex];
    }

    /**
     * This method will enabled the contact operations and set visible the
     * events management.
     *
     * @param contact the contact that we want to see
     * @param flag if there wasn't a contact, the flag will be false, so the
     * method will not change the visibility of events management, if there was
     * a contact the method will change it.
     */
    private void setInterfaceToContact(Contact contact, boolean flag) {

        this.btnFinish.setEnabled(false);
        this.btnUpdate.setEnabled(true);

        this.selectedContact.setEnabled(true);
        this.contactComboBox.setEnabled(true);

        this.listEvents.setVisible(flag);
        this.btnCreate.setVisible(flag);
        this.btnEdit.setVisible(flag);
        this.btnRemove.setVisible(flag);

        if (flag) {
            this.btnUpdate.setEnabled(!flag);
        }
        if (flag) {
            this.btnFinish.setEnabled(flag);
        }
        if (flag) {
            this.selectedContact.setEnabled(!flag);
        }
        if (flag) {
            this.contactComboBox.setEnabled(!flag);
        }

        if (contact != null) {
            Object[] data = showAllEvents((Contact) contact);
            listEvents.setListData(data);

            if (data.length == 0) {
                JOptionPane.showMessageDialog(EventPanel.this,
                        "The contact has no events",
                        "Show Event",
                        JOptionPane.WARNING_MESSAGE);
            }

            this.contact = contact;
        }
    }

    /**
     * Returns an array with the events description and time to be visible on
     * the list, and adds all objects of events on the eventsList array.
     *
     * @param contact the contact that we want to management
     * @return array with the events description and time
     */
    private String[] showAllEvents(Contact contact) {
        int i = 0;

        String[] names = new String[contact.agenda().events().size()];

        if (contact.agenda().events().isEmpty()) {
            return names;
        }

        Object[] data = (Object[]) (Object) contact.agenda().events().
                toArray(new Object[contact.agenda().events().size()]);

        for (Object o : data) {
            Event e = (Event) o;

            names[i] = e.description() + "   "
                    + DateTime.format(e.time(), "dd-MM-yyyy");
            i++;
        }

        eventsList = data;

        return names;
    }

    /**
     * Creates a button to create an event to the select the contact. This
     * button will open a new window to create that event.
     *
     * @return the button to create the event
     */
    private JButton buttonCreate() {
        JButton btnCreate = new JButton(" Create Event ");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CreateEventFrameUI createEvent = new CreateEventFrameUI(EventPanel.this, contact, controller);
            }
        });

        return btnCreate;
    }

    /**
     * Creates a button to edit a selected event of the contact. This button
     * will open a new window to edit that event.
     *
     * @return the button to edit the event
     */
    private JButton buttonEdit() {
        JButton btnEdit = new JButton(" Edit Event ");
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (listEvents.getSelectedValue() != null) {
                    EditEventFrameUI editEvent = new EditEventFrameUI(EventPanel.this, contact, getEvent(listEvents.
                            getSelectedIndex()), controller);

                } else {
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "Please select an event",
                            "Show Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btnEdit;
    }

    /**
     * Creates a button to remove a selected event of the contact. This button
     * will open a new window with the information of the event.
     *
     * @return the button to remove the event
     */
    private JButton buttonDelete() {
        JButton btnRemove = new JButton("  Remove Event   ");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (listEvents.getSelectedValue() != null) {
                    RemoveEventFrameUI deleteEvent = new RemoveEventFrameUI(EventPanel.this, contact, getEvent(listEvents.
                            getSelectedIndex()), controller);

                } else {
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "Please select an event",
                            "Show Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btnRemove;
    }

    /**
     * This method will update the list of events, showing all the actual events
     * of the selected contact.
     */
    public void updateEventList() {
        if (contact != null) {
            Object[] data = showAllEvents(contact);
            listEvents.setListData(data);
        }
    }

    /**
     * This method will update the list of contacts, showing all the actual
     * contacts of the combo box list.
     *
     * @return true if has contacts
     */
    public boolean updateContactos() {
        Object[] data = showAllContacts();
        contactComboBox.removeAllItems();
        for (Object o : data) {
            contactComboBox.addItem(o);
        }
        return data.length != 0;
    }

    /**
     * Get event selected on the list.
     *
     * @param selectedIndex index of event chosen on the list
     * @return the event chosen
     */
    public Event getEvent(int selectedIndex) {

        if (eventsList == null) {
            return null;
        }

        return (Event) eventsList[selectedIndex];
    }

    /**
     * Creates a panel with the update and finish button.
     *
     * @return panel with the update and finish button
     */
    private JPanel createUpdateFinishButtonPanel() {
        this.btnUpdate = buttonUpdate();
        this.btnFinish = buttonFinish();

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(btnUpdate);
        panel.add(btnFinish);

        return panel;
    }

    /**
     * Creates a button to finish the contact session. This button will put the
     * contact list on combo box visible again.
     *
     * @return the button to finish the contact session
     */
    private JButton buttonFinish() {
        JButton finish = new JButton(" Finish ");
        finish.setBackground(Color.white);
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setInterfaceToContact(null, false);
            }
        });
        return finish;
    }

    /**
     * Creates a button to update the contacts list. This button will send a
     * message if there is not any contact.
     *
     * @return the button to update the contact list
     */
    private JButton buttonUpdate() {
        JButton update = new JButton(" Update ");
        update.setBackground(Color.white);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!updateContactos()) {
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "There are no contacts to show",
                            "Show Contacts",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return update;
    }
}
