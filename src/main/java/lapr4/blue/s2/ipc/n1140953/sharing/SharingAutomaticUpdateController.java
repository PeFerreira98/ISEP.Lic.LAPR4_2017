/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import lapr4.blue.s2.ipc.n1140953.sharing.ui.SharingAutomaticUpdateExtension;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.green.s1.ipc.n1151211.StartSharing.HandleReceiveSharedCells;
import lapr4.green.s1.ipc.n1151211.StartSharing.ReplySendSharedCellsDTO;
import lapr4.green.s1.ipc.n1151211.StartSharing.SendSharedCellsDTO;
import lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension;
import static lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension.NAME;
import lapr4.green.s1.ipc.n1151211.StartSharing.ui.CellsSelected;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommClientWorker2;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateController implements CommHandler2, Observer {

    private Object lastDto;
    private CellsSelected cellsSelected;
    private String choosedPeer;
    private boolean enableSharing = false;

    private CommServer2 commServer;
    private ListenerServer listenerServer;
    private BroadcastServer broadcastServer;

    private static HashMap<String, String> userList = new HashMap<>();

    public SharingAutomaticUpdateController(UIController uiController) {
        this.commServer = CommServer2.getServer();
        this.listenerServer = ListenerServer.getServer();
        this.broadcastServer = BroadcastServer.getServer();

        commServer.addHandler(SendSharedCellsDTO.class, new HandleReceiveSharedCells(uiController));
        broadcastServer.broadcastThisService(NAME, true);
        listenerServer.addObserver(this);
    }

    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        lastDto = dto;
        ReplySendSharedCellsDTO response = (ReplySendSharedCellsDTO) dto;
    }

    @Override
    public Object getLastReceivedDTO() {
        return lastDto;
    }

    public String choosePeer(String selectedPeer) {
        if (selectedPeer == null) {
            return "No peer selected!";
        }
        return this.choosedPeer = selectedPeer;
    }

    public String startStopAutoSharing() {
        if (!this.enableSharing) {
            if (this.choosedPeer == null) {
                return "Select a Peer!";
            }
            this.enableSharing = true;
            return "Auto Sharing Active";
        }
        this.enableSharing = false;
        return "Auto Sharing Deactivated!";
    }

    public void quickShare() {
        System.out.println("QuickSharing...");
        if (this.enableSharing) {
            System.out.println(shareCells());
        }
    }

    private String shareCells() {
        Cell[][] theChosen = cellsSelected.theOnesChosen();
        if (theChosen == null || theChosen.length == 0) {
            return "No cells selected!";
        }

        CommClientWorker2 toPeer = ListenerServer.getServer().getCommClientWorker2(this.choosedPeer);
        if (toPeer == null) {
            return "ERROR: Could not connect to peer!";
        }

        ListenerServer.getServer().addHandler(ReplySendSharedCellsDTO.class, this);

        BroadcastServer.getServer().broadcastThisService(NAME, true);

        SendSharedCellsDTO dto = new SendSharedCellsDTO(theChosen);
        if (toPeer.sendDto(dto) == false) {
            return "ERROR: Communication failure in sending the cells";
        } else {
            return "Waiting for peer response";
        }
    }

    public ArrayList<String> getPeers() {
        return ListenerServer.getServer().getServicePeers(SharingAutomaticUpdateExtension.NAME);
    }

    public Object getListener() {
        return this.listenerServer;
    }

    public void clearUserList() {
        this.userList = new HashMap<>();
    }

    public void addUser(String id, String machineName) {
        this.userList.put(id, machineName);
    }

    public HashMap<String, String> getUsersList() {
        return this.userList;
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = getPeers();

        clearUserList();

        for (String peer : peers) {
            String tmp[] = peer.split("@");

            String machineName = tmp[0] + "@";
            String id = tmp[1];

            addUser(id, machineName);
        }
    }

}
