/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomExtension;
import lapr4.red.s3.ipc.n1140388.chatrooms.controller.ChatRoomController;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomPanel extends JPanel implements SelectionListener {

    private JButton btnUpdate;
    private JButton btnCreate;
    private JButton btnJoin;

    private final JButton selectedRoom;

    private final JComboBox roomsComboBox;

    private Object[] roomsList;

    private ChatRoomController controller;

    public ChatRoomPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());

        // Creates controller
        this.controller = new ChatRoomController();
        uiController.addSelectionListener(this);
        setName(ChatRoomExtension.NAME);

        JPanel roomsPanel = new JPanel(new GridLayout(3, 0));
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 0));

        //Creates comboBox of ChatRooms and List of Events
        roomsComboBox = createRoomsComboBox();

        //Add combo box and button to choose contact on panel and finish the operation with that contact
        roomsPanel.add(createUpdateFinishButtonPanel());
        roomsPanel.add(roomsComboBox);
        selectedRoom = btnChooseRoom();
        roomsPanel.add(selectedRoom);

        //Creates buttons to create
        btnCreate = buttonCreate();
        btnJoin = buttonJoin();

        //Add buttons to panel
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));
        buttonsPanel.add(btnCreate);
        buttonsPanel.add(btnJoin);
        buttonsPanel.add(new JToolBar.Separator(new Dimension(20, 20)));

        // Creates side bar
        add(roomsPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    /**
     * Creates a combo box to choose the contact.
     *
     * @return combo box
     */
    private JComboBox createRoomsComboBox() {
        String[] contactNames = showAllRooms();
        JComboBox contatos = new JComboBox(contactNames);
        return contatos;
    }

    /**
     * Returns an array with the names of contacts to be visible on the combo
     * box, and adds all objects of contacts on the roomsList array.
     *
     * @return array with the contacts name
     */
    private String[] showAllRooms() {
        int i = 0;

        List<ChatRoom> list = controller.chatRoomsList();

        String[] names = new String[list.size()];

        if (list.isEmpty()) {
            return names;
        }

        Object[] data = (Object[]) (Object) list.toArray(new Object[list.size()]);

        for (Object obj : data) {
            ChatRoom room = (ChatRoom) obj;
            names[i] = "Name: " + room.name();
            i++;
        }

        roomsList = data;

        return names;
    }

    private JButton btnChooseRoom() {
        JButton choise = new JButton(" Go to Room ");
        choise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (roomsComboBox.getSelectedItem() != null) {
                    ChatRoom room = getRoom(roomsComboBox.getSelectedIndex());
//                    ChatRoomUI ui = new ChatRoomUI(room);
                } else {
                    JOptionPane.showMessageDialog(ChatRoomPanel.this,
                            "Please select a contact",
                            "Show ChatRoom",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        return choise;
    }

    /**
     * Get the contact selected on the combo box.
     *
     * @param selectedIndex index of contact chosen on combo box
     * @return the contact chosen
     */
    public ChatRoom getRoom(int selectedIndex) {

        if (roomsList == null) {
            return null;
        }

        return (ChatRoom) roomsList[selectedIndex];
    }

    /**
     * Creates a panel with the update and finish button.
     *
     * @return panel with the update and finish button
     */
    private JPanel createUpdateFinishButtonPanel() {
        this.btnUpdate = buttonUpdate();

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(btnUpdate);
        return panel;
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
                    JOptionPane.showMessageDialog(ChatRoomPanel.this,
                            "There are no contacts to show",
                            "Show Contacts",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return update;
    }

    /**
     * This method will update the list of contacts, showing all the actual
     * contacts of the combo box list.
     *
     * @return true if has contacts
     */
    public boolean updateContactos() {
        Object[] data = showAllRooms();
        roomsComboBox.removeAllItems();
        for (Object o : data) {
            roomsComboBox.addItem(o);
        }
        return data.length != 0;
    }

    /**
     * Creates a button to create an event to the select the contact. This
     * button will open a new window to create that event.
     *
     * @return the button to create the event
     */
    private JButton buttonCreate() {
        btnCreate = new JButton(" Create Chat Room ");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CreateChatRoomUI ui = new CreateChatRoomUI(controller);
            }
        });

        return btnCreate;
    }
    
    /**
     * Creates a button to create an event to the select the contact. This
     * button will open a new window to create that event.
     *
     * @return the button to create the event
     */
    private JButton buttonJoin() {
        btnJoin = new JButton(" Join Chat Room ");
        btnJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JoinRoomUI ui = new JoinRoomUI();
            }
        });

        return btnJoin;
    }

    @Override
    public void selectionChanged(SelectionEvent event) {

    }

}
