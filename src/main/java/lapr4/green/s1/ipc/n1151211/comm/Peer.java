/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class Peer implements Comparable<Peer> {

    protected static final int ALIVE = 20; // 45
    private boolean alive;
    private Instant hour;
    private String peerId;
    private String inetAddress;
    private HashMap<String, PeerService> services = null;
    private CommClientWorker2 commClientWorker = null;

    private Object peerLock = null;

    public Peer(String id, String address) {
        services = new HashMap<>();
        peerId = id;
        inetAddress = address;
        hour = Instant.now();
        alive = true;
        peerLock = this;
    }

    protected boolean addService(PeerService service) {
        PeerService svc;
        svc = services.get(service.serviceName());
        if (svc == null) {
            services.put(service.serviceName(), service);
            return true;
        }

        hour = Instant.now();
        return svc.updateStatus(service.statusOn());
    }

    @Override
    public int compareTo(Peer o) {
        if (this == o) {
            return 0;
        }
        return inetAddress.compareToIgnoreCase(o.inetAddress);
    }

    protected String peerAddress() {
        return inetAddress;
    }

    /**
     * updateServices(Peer pr) of Peer pr
     *
     * @param pr
     * @return
     */
    protected boolean updateServices(Peer pr) {
        boolean change = false;

        Collection<PeerService> cps = services.values();
        Iterator it = cps.iterator();

        while (it.hasNext()) {
            PeerService svc = (PeerService) it.next();
            if (pr.addService(svc)) {
                change = true;
            }
        }

        return change;
    }

    protected String hasServiceName(String serviceName) {
        if (!isAlive()) {
            return null;
        }

        if (services.containsKey(serviceName)) {
            return peerId + "@" + inetAddress;
        } else {
            return null;
        }
    }

    protected boolean isAlive() {
        return (ALIVE - (Instant.now().getEpochSecond() - this.hour.getEpochSecond())) > 0;
    }

    protected long nextCheck() {
        long sleep = ALIVE - (Instant.now().getEpochSecond() - this.hour.getEpochSecond());

        if (sleep > 0) {
            alive = true;
            return sleep;
        } else if (!alive) {
            return ALIVE;
        } else {
            alive = false;
            return -1;
        }
    }

    protected CommClientWorker2 getCommClientWorker2(CommServer2 commSever, int serverPort) {
        synchronized (peerLock) {
            if (commClientWorker == null) {
                try {
                    Socket sock = new Socket(InetAddress.getByName(inetAddress.substring(1)), serverPort);
                    commClientWorker = new CommClientWorker2(sock, commSever, this);

                    commClientWorker.start();
                } catch (IOException ex) {
                    Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return commClientWorker;

    }

    void workerDown() {
        synchronized (peerLock) {
            commClientWorker = null;
        }

    }
    
    
    
  
}
