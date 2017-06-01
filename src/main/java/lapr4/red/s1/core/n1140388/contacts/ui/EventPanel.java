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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
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

    public EventPanel(UIController uiController) {
        super(new BorderLayout());

        this.controller = new ContactController(uiController.getUserProperties());

        uiController.addSelectionListener(this);
        setName(ContactsExtension.NAME);

        JPanel contactsPanel = new JPanel(new GridLayout(3, 0));
        JPanel eventsListPanel = new JPanel(new GridLayout(1, 0));
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 0));

        contactComboBox = createContactsComboBox();
        listEvents = createList();
        eventsListPanel.add(listEvents);

        contactsPanel.add(contactComboBox);
        selectedContact = buttonChooseContact();
        contactsPanel.add(selectedContact);

        btnCreate = buttonCreate();
        btnEdit = buttonEdit();
        btnRemove = buttonDelete();
        
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));
        buttonsPanel.add(btnCreate);
        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnRemove);
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));

        add(contactsPanel, BorderLayout.NORTH);
        add(eventsListPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setInterfaceToContact(null, false);

    }

    @Override
    public void selectionChanged(SelectionEvent event) {
        
    }

    private JComboBox createContactsComboBox() {
        String[] contactNames = new String[2];

        contactNames[0] = "1";
        contactNames[1] = "2";

        JComboBox contatos = new JComboBox(contactNames);
        return contatos;
    }
    
    private String[] showAllEvents(Contact c) {
        int i = 0;
        String[] names = null;
//                new String[c.AllEvent().size()];

//        if (c.AllEvent().isEmpty()) {
//            return names;
//        }
        Object[] data = null;
//                (Object[]) (Object) c.AllEvent().
//                toArray(new Object[c.AllEvent().size()]);

        for (Object o : data) {
            Event e = (Event) o;

            names[i] = e.description() + " " + e.time().
                    get(Calendar.DAY_OF_MONTH) + "/";
//                    + e.getMonth() + "/"
//                    + e.timeStamp().get(Calendar.YEAR);
            i++;
        }

        eventsList = data;

        return names;
    }

    /**
     * Get contact
     *
     * @param selectedIndex index combobox choise
     * @return Object
     */
    public Object getContact(int selectedIndex) {
        int pos = selectedIndex;
        Object obj = new Object();

        if (contactsList == null) {
            return null;
        }

        for (int i = 0; i < contactsList.length; i++) {
            if (i == pos) {
                obj = contactsList[i];
            }
        }
        return obj;
    }

    /**
     * Get event
     *
     * @param selectedIndex index listEvents choise
     * @return Object
     */
    public Object getEvent(int selectedIndex) {
        int pos = selectedIndex;
        Object obj = new Object();

        if (eventsList == null) {
            return null;
        }

        for (int i = 0; i < eventsList.length; i++) {
            if (i == pos) {
                obj = eventsList[i];
            }
        }
        return obj;
    }

    private JList createList() {
        Object[] data = {};
        JList list = new JList(data);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(1000, 3000));
        return list;
    }


    private JButton buttonCreate() {
        JButton btnbtnCreate = new JButton("  Create Event  ");
        btnbtnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //if (contactComboBox.getSelectedItem() != null) {
                CreateEventFrameUI createEvent = new CreateEventFrameUI(EventPanel.this, contact, controller);
//                } else {
//                    JOptionPane.showMessageDialog(EventPanel.this,
//                            "Please select a contact",
//                            "Show Event",
//                            JOptionPane.WARNING_MESSAGE);
//                }
            }
        });
        return btnbtnCreate;
    }

    private JButton buttonEdit() {
        JButton btnbtnEdit = new JButton("     Edit Event     ");
        btnbtnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (listEvents.getSelectedValue() != null) {
                    EditEventFrameUI editEvent = new EditEventFrameUI(EventPanel.this, (Contact) getContact(contactComboBox.
                            getSelectedIndex()), (Event) getEvent(listEvents.
                                    getSelectedIndex()), controller);

                } else {
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "Please select an envent",
                            "Show Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btnbtnEdit;
    }

    private JButton buttonDelete() {
        JButton btnbtnRemove = new JButton("  Remove Event   ");
        btnbtnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (listEvents.getSelectedValue() != null) {
                    RemoveEventFrameUI deleteEvent = new RemoveEventFrameUI(EventPanel.this, (Contact) getContact(contactComboBox.
                            getSelectedIndex()), (Event) getEvent(listEvents.
                                    getSelectedIndex()), controller);

                } else {
                    JOptionPane.showMessageDialog(EventPanel.this,
                            "Please select an envent",
                            "Show Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btnbtnRemove;
    }

    private JButton buttonChooseContact() {
        JButton choise = new JButton("  Select Contact   ");
        choise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (contactComboBox.getSelectedItem() != null) {
                        Contact c = (Contact) getContact(contactComboBox.
                                getSelectedIndex());
                        setInterfaceToContact(c, true);
                    } else {
                        JOptionPane.showMessageDialog(EventPanel.this,
                                "Please select an contact",
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

    private void setInterfaceToContact(Contact contact, boolean flag) {

        this.selectedContact.setEnabled(true);
        this.contactComboBox.setEnabled(true);

        this.listEvents.setVisible(flag);
        this.btnCreate.setVisible(flag);
        this.btnEdit.setVisible(flag);
        this.btnRemove.setVisible(flag);

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
}
