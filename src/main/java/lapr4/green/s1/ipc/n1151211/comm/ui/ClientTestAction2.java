/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import lapr4.green.s1.ipc.n1151211.comm.CommClientWorker2;
import lapr4.green.s1.ipc.n1151211.comm.CommExtension2;
import lapr4.green.s1.ipc.n1151211.comm.EchoReply;
import lapr4.green.s1.ipc.n1151211.comm.EchoRequest;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
//import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ClientTestAction2 extends BaseAction implements Observer{
   private ListenerServer listenerServer;
   private CommPing ping = null;

   private int pingNumber = 0;
    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ClientTestAction2(UIController uiController) {
        this.uiController = uiController;
    }

    protected String getName() {
        return "Client Test...";
    }

    protected void defineProperties() {
    }

    /**
     * A simple action that presents a confirmation dialog. If the user confirms
     * then the contents of the cell A1 of the current sheet are set to the
     * string "Changed".
     *
     * @param event the event that was fired
     */
    public void actionPerformed(ActionEvent event) {

       ping = new CommPing( this );
       listenerServer = ListenerServer.getServer();

        listenerServer.addObserver(this);
    }

        @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = listenerServer.getServicePeers(CommExtension2.NAME);
        
        System.out.println("update " + peers + "  " + arg);
        
        ping.updatePeers( peers );
    }

    protected void doPing(String peerSelected ) {
        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2( peerSelected );
        if( toPeer == null )
            return;
        
        listenerServer.addHandler(EchoReply.class, ping );

        EchoRequest echoRequest = new EchoRequest( CommExtension2.NAME, ++pingNumber );
        toPeer.sendDto(echoRequest);
    }

}