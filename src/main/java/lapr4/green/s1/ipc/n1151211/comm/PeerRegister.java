/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author Fernando
 */
public class PeerRegister extends Observable {

    private HashMap<String, Peer> peers = null;
    private Object lock = null;

    public PeerRegister() {
        lock = new Object();
        peers = new HashMap<>();
    }

    public void addPeer(Peer peer) {
        boolean change = false;
        synchronized (lock) {

            Peer pr = peers.get(peer.peerAddress());

            if (pr == null) {
                peers.put(peer.peerAddress(), peer);
                change = true;
            } else {
                change = peer.updateServices(pr);
            }
        }

        hasChange(true);
    }

    private void hasChange(boolean change) {
        if (change) {
            setChanged();
            notifyObservers(null);
        }
    }

    ArrayList<String> getServicePeers(String serviceName) {
        ArrayList<String> prs = new ArrayList<>();

        synchronized (lock) {
            Collection<Peer> prv = peers.values();
            Iterator it = prv.iterator();

            while (it.hasNext()) {
                Peer pvl = (Peer) it.next();
                String pvls = pvl.hasServiceName( serviceName );
                if( pvls != null )
                    prs.add(pvls);
            }

        }

        return prs;

    }

    protected long peersClean() {
        long sleep = Peer.ALIVE;
        boolean change = false;
        
        synchronized (lock) {
            Collection<Peer> prv = peers.values();
            Iterator it = prv.iterator();

            while (it.hasNext()) {
                Peer pvl = (Peer) it.next();
                long slp = pvl.nextCheck();
                if( slp < 0 ){
                    change = true;
                }else if( slp < sleep ){
                    sleep = slp;
                }
            }
        }
        
        hasChange( change );
        return sleep;
    }

    protected CommClientWorker2 getCommClientWorker2(String peerSelected, CommServer2 commSever, int serverPort) {
        String[] split = peerSelected.split("@");
        if( split.length != 2)
            return null;
        Peer peer = peers.get( split[ 1 ] );
        if( peer == null )
            return null;
        
        return peer.getCommClientWorker2( commSever, serverPort );
    }
}


/*
     Set set = hm.entrySet();
                                 Iterator it = set.iterator();
   
                                 while (it.hasNext()) {
                                                 Map.Entry m = (Map.Entry) it.next();
                                                 System.out.println(m.getKey() + ":" + m.getValue());
   
                                 }

*/
