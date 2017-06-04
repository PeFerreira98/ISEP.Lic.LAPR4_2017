/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class BroadcastServer extends Thread {

    private static BroadcastServer theBroadcastServer = null;

    private int serverPort = 16100;
    private long sleep = 10000;
    private Object lock = null;

    private String peerId = null;
    private HashMap<String, PeerService> services = null;

    private ArrayList<InetAddress> listOfBroadcasts = null;

    private DatagramSocket udpSock = null;

    private BroadcastServer() {

    }

    protected static BroadcastServer getServer(int svrPrt, String id) {
        if (theBroadcastServer == null) {
            theBroadcastServer = new BroadcastServer();
            theBroadcastServer.lock = theBroadcastServer;

            theBroadcastServer.serverPort = svrPrt;
            theBroadcastServer.peerId = id;
            theBroadcastServer.services = new HashMap<>();

            theBroadcastServer.listOfBroadcasts = new ArrayList();

            theBroadcastServer.start();
        }
        return theBroadcastServer;
    }

    public static BroadcastServer getServer() {
        return theBroadcastServer;
    }

    /**
     * Starts the server
     *
     */
    @Override
    public void run() {
        System.out.println("BroadcastServer");
        init();

        byte data[] = new byte[ CommExtension2.PACKET_SIZE_RECEIVE ];

        DatagramPacket udpPacket = new DatagramPacket(data, data.length, listOfBroadcasts.get(0), serverPort);

        while (true) {
            synchronized (lock) {
                String text, svcBroadName;
                boolean newPacket;

                text = "";
                svcBroadName = "";
                newPacket = true;

                Collection<PeerService> cps = services.values();
                Iterator it = cps.iterator();
                PeerService svc = null;
                
                while (it.hasNext()) {
                    if (svc == null) {
                        svc = (PeerService) it.next();
                        svcBroadName = svc.broadcastName();
                    }

                    if (newPacket) {
                        newPacket = false;
                        text = peerId;
                    }
                    if ((text.length() + svcBroadName.length()) <= data.length) {
                        text += svcBroadName;
                        svc = null;
                    } else {
                        broadcastPacket(text, udpPacket);
                        newPacket = true;
                    }
                }

                if (!text.isEmpty()) {
                    broadcastPacket(text, udpPacket);
                }
                
                try {
                    lock.wait( sleep );
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    private void init() {
        getBroadcastAdress();
        try {
            udpSock = new DatagramSocket();
            udpSock.setBroadcast(true);
        } catch (SocketException ex) {
            Logger.getLogger(BroadcastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // http://stackoverflow.com/questions/4887675/detecting-to_string_all-available-networks-broadcast-addresses-in-java
    private void getBroadcastAdress() {

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

                        InetAddress broadcast = address.getBroadcast();
                        if (broadcast != null && !listOfBroadcasts.contains(broadcast)) {
                            listOfBroadcasts.add(broadcast);
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(BroadcastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void broadcastPacket(String text, DatagramPacket udpPacket) {
        System.out.println("broadcastPacket");
        byte[] octetos = text.getBytes();
        udpPacket.setData(octetos);
        udpPacket.setLength(octetos.length);

        for (int i = 0; i < listOfBroadcasts.size(); ++i) {
            udpPacket.setAddress(listOfBroadcasts.get(i));
            try {
                udpSock.send(udpPacket);
            } catch (IOException ex) {
                Logger.getLogger(BroadcastServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     *  Add/update a service to/in the list of services broadcasted.
     *  If the servide is new or change the status a broadcast is made immediately
     * 
     * @param service
     */
    public void broadcastThisService( PeerService service){
        synchronized (lock) {
            boolean makeBroadcast = true;
            PeerService svc = services.get( service.serviceName() );
        
            if( svc == null )
                services.put( service.serviceName(), service );
            else
                makeBroadcast = svc.updateStatus(service.statusOn());
            
            if( makeBroadcast )
                lock.notifyAll();
        }
    }
    
    
    
}
