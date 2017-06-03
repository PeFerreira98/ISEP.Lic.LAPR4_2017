/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Fernando
 */

public class Peer implements Comparable<Peer> {

    private Instant hour;
    private String peerId;
    private String inetAddress;
    private HashMap<String , PeerService> services = null;
    
    public Peer(String id, String address){
        services = new HashMap<>();
        peerId = id;
        inetAddress = address;
        hour = Instant.now();
    }
    
    protected boolean addService( PeerService service ){
        PeerService svc;
        svc = services.get(service.serviceName());
        if( svc == null ){
            services.put(service.serviceName(), svc);
            return true;
        }
        
        return svc.updateStatus(service.statusOn());
    }
    
    protected void peerIsOn(){
        hour = Instant.now();
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
        
        Set svcSet = services.entrySet();
        Iterator it = svcSet.iterator();
   
        while (it.hasNext()) {
            PeerService svc = (PeerService) it.next();
            if( pr.addService(svc) )
                change = true;
        }

        return change;
    }
}
