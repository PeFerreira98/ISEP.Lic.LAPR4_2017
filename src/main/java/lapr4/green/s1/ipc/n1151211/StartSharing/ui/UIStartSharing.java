/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing.ui;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;
import lapr4.blue.s2.ipc.n1140953.sharing.SharingAutomaticUpdateCellListener;
import lapr4.green.s1.ipc.n1151211.StartSharing.HandleReceiveSharedCells;
import lapr4.green.s1.ipc.n1151211.StartSharing.SendSharedCellsDTO;
import lapr4.green.s1.ipc.n1151211.StartSharing.ReplySendSharedCellsDTO;
import lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension;
import static lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension.NAME;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommClientWorker2;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Fernando
 */
public class UIStartSharing extends UIExtension implements CommHandler2, Observer {

    private ShareCellsPanel sideBar;
    private Object lastDto;
    private boolean status = false;
    private CellsSelected cellsSelected;
    private HandleReceiveSharedCells handleReceiveSC;

    public UIStartSharing(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public JMenu getMenu() {
        return null;
    }

    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {

            cellsSelected = new CellsSelected(uiController);
            handleReceiveSC = new HandleReceiveSharedCells(uiController);

            CommServer2.getServer().addHandler(SendSharedCellsDTO.class, handleReceiveSC);

            sideBar = new ShareCellsPanel(uiController, this);
            ListenerServer.getServer().addObserver(this);
            update(null, null);
        }
        return sideBar;
    }

    protected String shareCells(String peer, Cell[][] theChosen) {
        CommClientWorker2 toPeer = ListenerServer.getServer().getCommClientWorker2(peer);
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

    //  CommHandler2
    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        lastDto = dto;
        ReplySendSharedCellsDTO response = (ReplySendSharedCellsDTO) dto;

        sideBar.reply(response.messageText());
    }

    @Override
    public Object getLastReceivedDTO() {
        return lastDto;
    }

    // Observer
    @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = ListenerServer.getServer().getServicePeers(StartSharingExtension.NAME);

        sideBar.updatePeers(peers);
    }

    protected String theOnesChosen(String oneSelected) {
        Cell[][] theChosen = cellsSelected.theOnesChosen();

        if (theChosen == null || theChosen.length == 0) {
            return "No cells selected!";
        }

        return shareCells(oneSelected, theChosen);
    }

    protected boolean getStatus() {
        return status;
    }

    protected void changeStatus() {
        status = !status;
        BroadcastServer.getServer().broadcastThisService(NAME, status);
    }

    private String selectedPeer;
    private List<String> selectedPeers;

    void addSpreadsheetListener() {
        SharingAutomaticUpdateCellListener sharingAutomaticUpdateCellListener = new SharingAutomaticUpdateCellListener(this);
        uiController.getActiveSpreadsheet().addCellListener(sharingAutomaticUpdateCellListener);
    }
    
    void lockPeer(String peer){
        this.selectedPeer = peer;
    }
    
    void lockPeers(List<String> peers){
        this.selectedPeers = peers;
    }
    
    public void quickShare(Cell cell) {
        System.out.println("QuickSharing to " + this.selectedPeer + "...");
        
        if (this.selectedPeer != null && !this.selectedPeer.isEmpty()) {
            System.out.println(shareStylableCells(cell));
            return;
        }
        System.out.println("Selected Peer is empty or null...");
    }
    
      public void multiQuickShare(Cell cell){
        if (!selectedPeers.isEmpty()) {
            for (int i = 0; i < selectedPeers.size(); i++) {

                System.out.println("QuickSharing to " + this.selectedPeers.get(i) + "...");

                if (this.selectedPeers.get(i) != null && !this.selectedPeers.get(i).isEmpty()) {
                    System.out.println(multiShareStylableCells(cell,this.selectedPeers.get(i)));
                    return;
                }
            }
        }
        System.out.println("No peers selected");
    }
                
    
    private String shareStylableCells(Cell cell) {
        CommClientWorker2 toPeer = ListenerServer.getServer().getCommClientWorker2(this.selectedPeer);
        if (toPeer == null) {
            return "ERROR: Could not connect to peer!";
        }

        ListenerServer.getServer().addHandler(ReplySendSharedCellsDTO.class, this);
        BroadcastServer.getServer().broadcastThisService(NAME, status);
        
        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cell;
        SendSharedCellsDTO dto = new SendSharedCellsDTO(cells);
        
//        CellDTO dto = CellDTO.createFromCell(cell);
//        StylableCellDTO dto = StylableCellDTO.createFromCell(cell);
        
        if (!toPeer.sendDto(dto)) {
            return "ERROR: Communication failure in sending the cells";
        }
        return "Waiting for peer response";
    }
     private String multiShareStylableCells(Cell cell, String peer) {
        CommClientWorker2 toPeer = ListenerServer.getServer().getCommClientWorker2(peer);
        if (toPeer == null) {
            return "ERROR: Could not connect to peer!";
        }

        ListenerServer.getServer().addHandler(ReplySendSharedCellsDTO.class, this);
        BroadcastServer.getServer().broadcastThisService(NAME, status);
        
        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cell;
        SendSharedCellsDTO dto = new SendSharedCellsDTO(cells);
        
//        CellDTO dto = CellDTO.createFromCell(cell);
//        StylableCellDTO dto = StylableCellDTO.createFromCell(cell);
        
        if (!toPeer.sendDto(dto)) {
            return "ERROR: Communication failure in sending the cells";
        }
        
        return "Waiting for peer response";
        
    }

}


