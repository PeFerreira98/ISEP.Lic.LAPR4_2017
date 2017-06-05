/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing.ui;

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
import lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension;
import static lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension.NAME;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;

/**
 *
 * @author Fernando
 */
public class ShareCellsPanel extends JPanel implements Observer {

    private JList<String> peerList;
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private UIStartSharing controller;

    private JPanel jPanel2;
    private JButton btPing;
    private JButton btStatus;
    private JScrollPane scrollPane;
    private JLabel answer;
    private boolean status = false;
    private JPanel pNorth;

    public ShareCellsPanel(UIController uiController, UIStartSharing cntrl) {
        setName(StartSharingExtension.NAME);
        controller = cntrl;
        jPanel2 = new JPanel();
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        buildComponents();

        // Configuring the Echo Reply Service
        BroadcastServer.getServer().broadcastThisService(new PeerService(NAME, status));
    }

    private void buildComponents() {
        makeButtons();

        pNorth = new JPanel();
        if (status == true) {
            pNorth.setBackground(Color.YELLOW);
        } else {
            pNorth.setBackground(Color.GRAY);
        }

        pNorth.add(btPing);
        pNorth.add(btStatus);
        add(pNorth, BorderLayout.NORTH);

        JPanel pSouth = new JPanel();

        answer = new JLabel("answer", JLabel.CENTER);
        pSouth.add(answer);
        add(pSouth, BorderLayout.SOUTH);

        //create the list
        peerList = new JList<>(listModel);
        peerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(peerList);

        add(scrollPane);

    }

    private void makeButtons() {

        btPing = new JButton("Share Cells");
        btPing.setForeground(Color.BLUE);
        final int BUTTON_WIDTH = 90, BUTTON_ALTURA = 50;
        btPing.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));

        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oneSelected = peerList.getSelectedValue();

                if (oneSelected != null) {
                    //controller.doPing(oneSelected);
                }
            }
        });

        btStatus = new JButton("On/Off");
        //btStatus.setForeground(Color.BLACK);
        btStatus.setPreferredSize(new Dimension(50, 50));
        

        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = !status;
                if (status == true) {
                    pNorth.setBackground(Color.YELLOW);
                } else {
                    pNorth.setBackground(Color.GRAY);
                }
                
                BroadcastServer.getServer().broadcastThisService(new PeerService(NAME, status));
            }
        });

    }

    protected void updatePeers(ArrayList<String> peers) {
        if (listModel.isEmpty() && peers.isEmpty()) {
            return;
        } else if (peers.isEmpty()) {
            listModel.clear();
        } else {

            if (theSamePeers(peers)) {
                return;
            }

            String selected = null;
            selected = peerList.getSelectedValue();

            listModel.clear();
            for (int i = 0; i < peers.size(); ++i) {
                listModel.add(i, peers.get(i));
            }
            if (selected != null && listModel.contains(selected)) {
                peerList.setSelectedValue(selected, false);
            }
        }

    }

    private boolean theSamePeers(ArrayList<String> peers) {
        if (peers.size() != listModel.size()) {
            return false;
        }

        boolean same = true;
        for (int i = 0; i < peers.size(); ++i) {
            same = peers.get(i).equals(listModel.get(i));
            if (!same) {
                break;
            }
        }

        return same;
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = ListenerServer.getServer().getServicePeers(StartSharingExtension.NAME);

        updatePeers(peers);
    }
}
