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
import lapr4.green.s1.ipc.n1151211.comm.CommExtension2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
//import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ClientTestAction2 extends BaseAction implements Observer {

    private ListenerServer listenerServer;
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

        CommPing ping = new CommPing();
        listenerServer = ListenerServer.getServer();
        listenerServer.addObserver(this);

        // We will test the CommServer by connecting and sending the HelloRequestDTO
//        Socket clientSocket;
//        try {
//            clientSocket = new Socket(InetAddress.getLocalHost(), 15000);
////            client.connect(new InetSocketAddress(InetAddress.getLocalHost(), 15000));
////            client.setSoTimeout(500);
//            CommClientWorker client=new CommClientWorker(clientSocket);
//            
//            ObjectOutputStream outStream=client.getObjectOutputStream();
//
//            outStream.writeObject(new HelloRequestDTO("Hello!"));
//            clientSocket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ClientTestAction2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//		// Lets user select a font
//		int result=JOptionPane.showConfirmDialog(null, "You have selected the Example option. Do you want to set cell A1 to 'Changed'");
//		
//		if (result==JOptionPane.YES_OPTION) {
//		// Vamos exemplificar como se acede ao modelo de dominio (o workbook)
//		try {
//			this.uiController.getActiveSpreadsheet().getCell(0, 0).setContent("Changed");
//		} catch (Exception ex) {
//			// para ja ignoramos a excepcao
//		}
//		}
    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<String> peers = listenerServer.getServicePeers(CommExtension2.NAME);
    }

}
