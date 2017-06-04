/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class PeerRegisterCleaner extends Thread{
    private PeerRegister peerRegister = null;
    
    public PeerRegisterCleaner( PeerRegister pr ){
        peerRegister = pr;   
    }
    
    @Override
    public void run(){
        while(true){
            try {
                TimeUnit.SECONDS.sleep( peerRegister.peersClean() );
            } catch (InterruptedException ex) {
                Logger.getLogger(PeerRegisterCleaner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
