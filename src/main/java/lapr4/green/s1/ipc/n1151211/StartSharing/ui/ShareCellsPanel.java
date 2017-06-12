/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class ShareCellsPanel extends JPanel {

    private JList<String> peerList;
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final UIStartSharing controller;
    private final UIController uiCntrl;

    private JButton btPing;
    private JButton btStatus;
    private JScrollPane scrollPane;
    private JLabel answer;
    private JPanel pButtons;

    public ShareCellsPanel(UIController uiController, UIStartSharing cntrl) {
        setName(StartSharingExtension.NAME);
        controller = cntrl;
        uiCntrl = uiController;

        buildComponents();

        // Configuring the Echo Reply Service
    }

    private void buildComponents() {
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        JPanel pNorth = new JPanel();

        pButtons = makeButtons();
        changesColorButtons();
        pNorth.add(pButtons);

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

    private JPanel makeButtons() {
        final int BUTTON_WIDTH = 100, BUTTON_ALTURA = 30;

        btPing = new JButton("Share Cells");
        btPing.setForeground(Color.BLUE);
        btPing.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));


        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.getStatus() == false) {
                    return;
                }

                String oneSelected = peerList.getSelectedValue();
                if (oneSelected == null) {
                    answer.setText("No peer selected!");
                    return;
                }

                answer.setText(controller.theOnesChosen(oneSelected));
            }
        });

        btStatus = new JButton("On-Off");

        btStatus.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));

        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.changeStatus();
                changesColorButtons();
            }
        });

        JButton btRefresh = new JButton();
        btRefresh = new JButton("Lock cells");
        btRefresh.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        btRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oneSelected = peerList.getSelectedValue();
                if (oneSelected == null) {
                    answer.setText("No peer selected!");
                    return;
                }
                
                controller.lockPeer(peerList.getSelectedValue());
                Cell[][] array;
                array = controller.getAllSelectedCells();
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        Cell cell = array[i][j];
                        controller.addListener(cell);
                    }
                }
                answer.setText("Region & Selected Peer Locked!");
            }
        });

        JPanel pPanel = new JPanel();

        pPanel.add(btStatus);
        pPanel.add(btPing);
        pPanel.add(btRefresh);

        return pPanel;
    }

    private void changesColorButtons() {
        if (controller.getStatus() == true) {
            pButtons.setBackground(Color.YELLOW);
            btStatus.setText("ON");
            btStatus.setForeground(Color.BLUE);
        } else {
            btStatus.setText("OFF");
            btStatus.setForeground(Color.BLACK);
            pButtons.setBackground(Color.GRAY);
        }
    }

    protected void updatePeers(ArrayList<String> peers) {
        if (listModel.isEmpty() || peers.isEmpty()) {
            if (peers.isEmpty()) {
                listModel.clear();
            } else {
                if (theSamePeers(peers)) {
                    return;
                }

                String selected = peerList.getSelectedValue();

                listModel.clear();
                for (int i = 0; i < peers.size(); ++i) {
                    listModel.add(i, peers.get(i));
                }
                if (selected != null && listModel.contains(selected)) {
                    peerList.setSelectedValue(selected, false);
                }
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

    protected void reply(String messageText) {
        answer.setText(messageText);
    }
}
