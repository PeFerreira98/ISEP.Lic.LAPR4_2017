/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr4.blue.s2.ipc.n1140953.sharing.SharingAutomaticUpdateController;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateUISidebar extends JPanel {

    private final SharingAutomaticUpdateController controller;

    private final JLabel statusLabel = new JLabel("Status", JLabel.CENTER);
    private final JList<String> peerList = new JList<>(new DefaultListModel<>());
    private JScrollPane scrollPane;
    private JButton btPing;
    private JButton btStatus;
    private JButton btRefresh;

    public SharingAutomaticUpdateUISidebar(UIController uiController) {
        super(new BorderLayout());

        this.controller = new SharingAutomaticUpdateController(uiController);
        buildComponents();
    }

    private void buildComponents() {

        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();

        pNorth.add(buttonPanel());
        add(pNorth, BorderLayout.NORTH);

        pSouth.add(statusLabel);
        add(pSouth, BorderLayout.SOUTH);

        //create the list
        this.peerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.scrollPane = new JScrollPane(peerList);
        add(scrollPane);
    }

    private JPanel buttonPanel() {
        final JPanel pPanel = new JPanel();
        final int BUTTON_WIDTH = 100, BUTTON_ALTURA = 30;

        this.btPing = new JButton("Automatic Sharing");
        this.btPing.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        this.btPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText(controller.choosePeer(peerList.getSelectedValue()));
            }
        });

        this.btStatus = new JButton("On-Off");
        this.btStatus.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        this.btStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText(controller.startStopAutoSharing());
            }
        });

        this.btRefresh = new JButton("Refresh");
        this.btRefresh.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        this.btRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
            }
        });

        pPanel.add(btStatus);
        pPanel.add(btPing);
        pPanel.add(btRefresh);
        return pPanel;
    }

    public void updateNotification(String notification) {
        statusLabel.setText(notification);
    }

    public void updateList() {

        DefaultListModel model = new DefaultListModel();
        HashMap<String, String> list = controller.getUsersList();
        
        list.values().stream().forEach((object) -> {
            model.addElement(object);
        });

        peerList.setModel(model);
    }

}
