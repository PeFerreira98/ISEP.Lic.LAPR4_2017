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
import lapr4.red.s3.ipc.n1140388.chatrooms.controller.ChatRoomApplicationController;

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

    private ChatRoomApplicationController controller;

    /**
     * Creates a new chat room panel.
     *
     * @param uiController the user interface controller
     */
    public ChatRoomPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());

        // Creates controller
        this.controller = new ChatRoomApplicationController();
        uiController.addSelectionListener(this);
        setName(ChatRoomExtension.NAME);

        JPanel roomsPanel = new JPanel(new GridLayout(3, 0));
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 0));

        //Creates comboBox of ChatRooms
        roomsComboBox = createRoomsComboBox();

        //Add combo box and button to choose the room on panel and update the comboBox
        roomsPanel.add(createUpdateButtonPanel());
        roomsPanel.add(roomsComboBox);
        selectedRoom = btnChooseRoom();
        roomsPanel.add(selectedRoom);

        //Creates buttons to create and join
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
     * Creates a combo box to choose the chat room.
     *
     * @return combo box
     */
    private JComboBox createRoomsComboBox() {
        String[] chatroomsNames = showAllRooms();
        JComboBox chatrooms = new JComboBox(chatroomsNames);
        return chatrooms;
    }

    /**
     * Returns an array with the names of chat rooms to be visible on the combo
     * box, and adds all objects of chat rooms on the roomsList array.
     *
     * @return array with the contacts name
     */
    private String[] showAllRooms() {
        int i = 0;

        List<ChatRoom> list = controller.getRoomsList().getChatRoomsList();
        
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

    /**
     * Creates a button to choose the chat room. This button will send a message
     * if there is not any chat room selected.
     *
     * @return the button to choose the chat room
     * @return
     */
    private JButton btnChooseRoom() {
        JButton choise = new JButton(" Go to Room ");
        choise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (roomsComboBox.getSelectedItem() != null) {
                    ChatRoom room = getRoom(roomsComboBox.getSelectedIndex());
                     new CommunicationChatRoomUI(controller, room);
                } else {
                    JOptionPane.showMessageDialog(ChatRoomPanel.this,
                            "Please select a chat room",
                            "Show ChatRoom",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        return choise;
    }

    /**
     * Get the chat room selected on the combo box.
     *
     * @param selectedIndex index of chat room chosen on combo box
     * @return the chat room chosen
     */
    public ChatRoom getRoom(int selectedIndex) {

        if (roomsList == null) {
            return null;
        }

        return (ChatRoom) roomsList[selectedIndex];
    }

    /**
     * Creates a panel with the update button.
     *
     * @return panel with the update button
     */
    private JPanel createUpdateButtonPanel() {
        this.btnUpdate = buttonUpdate();

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(btnUpdate);
        return panel;
    }

    /**
     * Creates a button to update the chat room list. This button will send a
     * message if there is not any chat room.
     *
     * @return the button to update the chat room list
     */
    private JButton buttonUpdate() {
        btnUpdate = new JButton(" Update ");
        btnUpdate.setBackground(Color.white);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!updateContactos()) {
                    JOptionPane.showMessageDialog(ChatRoomPanel.this,
                            "There are no chat rooms to show",
                            "Show Chat Rooms",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btnUpdate;
    }

    /**
     * This method will update the list of chat rooms, showing all the actual
     * chat rooms of the combo box list.
     *
     * @return true if has chat room
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
     * Creates a button to create a chat room. This button will open a new
     * window to create that chat room.
     *
     * @return the button to create the chat room
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
     * Creates a button to join to that chat room. This button will open a new
     * window to join to that chat room.
     *
     * @return the button to join the chat room
     */
    private JButton buttonJoin() {
        btnJoin = new JButton(" Join Chat Room ");
        btnJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JoinRoomUI ui = new JoinRoomUI(controller);
            }
        });

        return btnJoin;
    }

    @Override
    public void selectionChanged(SelectionEvent event) {

    }

}
