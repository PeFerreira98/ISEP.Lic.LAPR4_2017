/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import lapr4.blue.s2.ipc.n1140953.sharing.ui.SharingAutomaticUpdateExtension;
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
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateController implements CommHandler2 {

    private final UIController uiController;

    private Object lastDto;
    private boolean status = true;
    private CellsSelected cellsSelected;
    private HandleReceiveSharedCells handleReceiveSC;
    private String choosedPeer;

    public SharingAutomaticUpdateController(UIController uiController) {
        this.uiController = uiController;

        BroadcastServer.getServer().broadcastThisService(NAME, status);
        handleReceiveSC = new HandleReceiveSharedCells(uiController);
        CommServer2.getServer().addHandler(SendSharedCellsDTO.class, handleReceiveSC);

    }

    protected String shareCells() {
        Cell[][] theChosen = cellsSelected.theOnesChosen();
        if (theChosen == null || theChosen.length == 0) {
            return "No cells selected!";
        }

        CommClientWorker2 toPeer = ListenerServer.getServer().getCommClientWorker2(this.choosedPeer);
        if (toPeer == null) {
            return "ERROR: Could not connect to peer!";
        }

        ListenerServer.getServer().addHandler(ReplySendSharedCellsDTO.class, this);

        BroadcastServer.getServer().broadcastThisService(NAME, status);

        SendSharedCellsDTO dto = new SendSharedCellsDTO(theChosen);
        if (toPeer.sendDto(dto) == false) {
            return "ERROR: Communication failure in sending the cells";
        } else {
            return "Waiting for peer response";
        }
    }

    public String choosePeer(String selectedPeer) {
        return this.choosedPeer = selectedPeer;
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

    public void startStopAutoSharing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> getPeers() {
        return ListenerServer.getServer().getServicePeers(SharingAutomaticUpdateExtension.NAME);
    }

}
