/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import static lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension.NAME;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateUISidebar extends JPanel implements Observer {

    private final SharingAutomaticUpdateController controller;

    private final JLabel statusLabel = new JLabel("Status", JLabel.CENTER);
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> peerList = new JList<>(listModel);
    private JScrollPane scrollPane;
    private JButton btPing;
    private JButton btStatus;

    public SharingAutomaticUpdateUISidebar(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(SharingAutomaticUpdateExtension.NAME);

        // Creates controller
        this.controller = new SharingAutomaticUpdateController(uiController);

        buildComponents();

        ListenerServer.getServer().addObserver(this);
        this.update(null, null);
        BroadcastServer.getServer().broadcastThisService(NAME, true);
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

        pPanel.add(btStatus);
        pPanel.add(btPing);
        return pPanel;
    }

    public void updateNotification(String notification) {
        statusLabel.setText(notification);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = controller.getPeers();

        listModel.clear();
        for (int i = 0; i < peers.size(); ++i) {
            listModel.add(i, peers.get(i));
        }
    }

}
