/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

/**
 *
 * @author Fernando
 */
public class PeerService implements Comparable<PeerService> {
    private final String name;
    private boolean status;
    
    public PeerService( String nm, boolean stts ){
        name = nm;
        status = stts;
    }

   @Override
    public int compareTo(PeerService o) {
        if (this == o) {
            return 0;
        }
        return name.compareToIgnoreCase(o.name);
    }
    
    public String serviceName(){
        return name;
    }
    
    public boolean statusOn(){
        return status;
    }
  
    public boolean updateStatus( boolean stts ){
        if( status == stts ){
            return false;
        }else{
            status = stts;
            return true;
        }
    }

    String broadcastName() {
        return "::" + name + "::" + ((status) ? "on" : "off");
    }
    
}
