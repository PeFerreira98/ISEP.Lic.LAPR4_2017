/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Fernando
 */

public class Peer implements Comparable<Peer> {
    protected static final int ALIVE  = 20; // 45
    private boolean alive;
    private Instant hour;
    private String peerId;
    private String inetAddress;
    private HashMap<String , PeerService> services = null;
    
    public Peer(String id, String address){
        services = new HashMap<>();
        peerId = id;
        inetAddress = address;
        hour = Instant.now();
        alive = true;
    }
    
    protected boolean addService( PeerService service ){
        PeerService svc;
        svc = services.get(service.serviceName());
        if( svc == null ){
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
    
    protected String peerAddress(){
        return inetAddress;
    }

    /**
     * updateServices(Peer pr) of Peer pr
     * @param pr
     * @return
     */
    protected boolean updateServices(Peer pr) {
        boolean change = false;
        
                Collection<PeerService> cps = services.values();
                Iterator it = cps.iterator();
   
        while (it.hasNext()) {
            PeerService svc = (PeerService) it.next();
            if( pr.addService(svc) )
                change = true;
        }

        return change;
    }

    protected String hasServiceName(String serviceName) {
        if( !isAlive() )
            return null;
        
        if( services.containsKey(serviceName) ){
            return peerId + "@" + inetAddress;
        }else
            return null;
    }
    
    protected boolean isAlive(){
        return (ALIVE - (Instant.now().getEpochSecond() - this.hour.getEpochSecond())) > 0 ;
    }

    protected long nextCheck() {
        long sleep = ALIVE - (Instant.now().getEpochSecond() - this.hour.getEpochSecond());
        
        if( sleep > 0 ){
            alive = true;
            return sleep;
        }else if( !alive ){
            return ALIVE;
        }else{
            alive = false;
            return -1;
        }
    }
}
