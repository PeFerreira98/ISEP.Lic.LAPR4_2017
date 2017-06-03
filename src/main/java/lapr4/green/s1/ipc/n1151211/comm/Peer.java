/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Fernando
 */

public class Peer implements Comparable<Peer> {

    private Instant hora;
    private String peerId;
    private String inetAddress;
    HashMap<String , PeerService> services = null;
    
    public Peer(String id, String address){
        services = new HashMap<>();
        peerId = id;
        inetAddress = address;
    }
    
    protected synchronized boolean addService( PeerService service ){
        hora = Instant.now();
        
        PeerService svc;
        svc = services.get(service.getServiceName());
        if( svc == null ){
            services.put(service.getServiceName(), svc);
            return true;
        }
        if( svc.statusOn() == service.statusOn()){
            return false;
        }else{
            svc.setStatus(service.statusOn());
            return true;
        }
    }
    
    
    @Override
    public int compareTo(Peer o) {
        if (this == o) {
            return 0;
        }
        return inetAddress.compareToIgnoreCase(o.inetAddress);
    }
}
