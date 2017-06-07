/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Function: listens and keeps track of the ads of the peers and thei services and status.
 * It makes this information available for other services.
 * Accepts observers who are notified whenever changes are detected to the status of the information collected.
 * 
 * Provides service to connect to peers that have been located on the network.
 * 
 * The server is a singleton
 * 
 * @author Fernando
 */
public class ListenerServer extends Thread{
    private static ListenerServer theListenerServer = null;

    private int serverPort = 15000;
    private CommServer2 commSever = null;

    
    private DatagramSocket udpSock = null;

    private ArrayList<InetAddress> listOfLocalAddress = null;
    
    private PeerRegister peerRegister = null;
    
    private PeerRegisterCleaner peerRegisterCleaner = null;
    
    private ListenerServer() {

    }
    
    /**
     *  Used to start the service.
     *  Used by the CommExtension just once.
     * 
     * @param svtPrt
     * @param commSvr
     * @return
     */
    protected static ListenerServer getServer(  int svtPrt, CommServer2 commSvr  ) {
        if (theListenerServer == null) {
            theListenerServer = new ListenerServer();
            theListenerServer.serverPort = svtPrt;
            theListenerServer.commSever = commSvr;
            
            theListenerServer.peerRegister = new PeerRegister();
            theListenerServer.peerRegisterCleaner = new PeerRegisterCleaner( theListenerServer.peerRegister );
            
            theListenerServer.start();
            
            theListenerServer.peerRegisterCleaner.start();

            // To test the server we are going to create a simple handler
            //CommHandler aHandler = new HelloHandler();
            //theCommServer.addHandler(HelloRequestDTO.class, aHandler);
        }
        return theListenerServer;
    }
    
    /**
     *  Returns the reference to the server instance.
     * 
     * @return
     */
    public static ListenerServer getServer( ) {
        return theListenerServer;
    }
    
    
     /**
     * Starts the server
     * 
     * ethernet = 1500 bytes
     * ipv6 = 40 b
     * UDP = 8 b
     * remaining = 1500 - 40 - 8 = 1452
     */
    @Override
    public void run() {
        System.out.println("ListenerServer");

        init();
        
        try {
            byte data[] = new byte[ CommExtension2.PACKET_SIZE_RECEIVE ];

            DatagramPacket udpPacket = new DatagramPacket(data, data.length );

            while (true) {
                udpSock.receive( udpPacket );
        
                if( listOfLocalAddress.contains( udpPacket.getAddress() ) )
                    continue;
                            
                String text = new String(udpPacket.getData(), 0, udpPacket.getLength());
                String[] split = text.split("::");
                
                if(split.length < 3){
                    continue;
                }
                Peer peer = new Peer( split[0], udpPacket.getAddress().toString() );
                for(int i = 1; i < split.length ; i += 2 ){
                    peer.addService( new PeerService(split[ i ], "on".equals(split[ i + 1] ) ) );
                }
                
                peerRegister.addPeer( peer );
            }

        } catch (Exception ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void init(){
        getLocalAdress();
        try {
            udpSock = new DatagramSocket(serverPort);
            udpSock.setBroadcast(true);
        } catch (SocketException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // http://stackoverflow.com/questions/4887675/detecting-to_string_all-available-networks-broadcast-addresses-in-java
    private void getLocalAdress(){       
        listOfLocalAddress = new ArrayList();

        Enumeration list;
        try {
            list = NetworkInterface.getNetworkInterfaces();

            while (list.hasMoreElements()) {
                NetworkInterface iface = (NetworkInterface) list.nextElement();

                if (iface == null) {
                    continue;
                }

                if (iface.isUp() && !iface.isLoopback()) {

                    Iterator it = iface.getInterfaceAddresses().iterator();
                    while (it.hasNext()) {
                        InterfaceAddress address = (InterfaceAddress) it.next();

                        if (address == null) {
                            continue;
                        }

                        InetAddress localAddress = address.getAddress();
                        if (localAddress != null && !listOfLocalAddress.contains(localAddress)) {
                            listOfLocalAddress.add(localAddress);
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Register a method to be invoked whenever the state of the peers changes
     * @param o
     */
    public void addObserver( Observer o ){
       peerRegister.addObserver_(o);
   }

   /**
     * Removes a method from being invoked whenever the state of the peers changes
     * 
     * @param o
     */
   public void deleteObserver( Observer o ){
       peerRegister.deleteObserver(o);
   }

    /**
     * Returns a list of peers that have the service named NAME active.
     * The returned string can be used for viewing and to identify the peer
     * by the server to open connections to the peer.
     * 
     * @param NAME
     * @return
     */
    public ArrayList<String> getServicePeers(String NAME) {
        return peerRegister.getServicePeers(NAME);
    }

    /**
     * Returns an instance object that allows objects to be transmitted over the network.
     * You should get an updated instance whenever you want to send objects over the network.
     * 
     * @param peerSelected
     * @return
     */
    public CommClientWorker2 getCommClientWorker2(String peerSelected) {
        return  peerRegister.getCommClientWorker2( peerSelected, commSever, serverPort );
    }

    /**
     *  Registers the association of a class with the hander that will process the objects of this class.
     * It's redirected to the commSever
     * 
     * @param dto
     * @param handler
     */
    public void addHandler(Class dto, CommHandler2 handler) {
        commSever.addHandler( dto, handler );
    }
}
