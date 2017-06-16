/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import lapr4.green.s1.ipc.n1140618.ChatApplication.*;
import java.io.Serializable;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class MessageToRoom implements Serializable{
    
    
    private String content;
    
    private String idDest;
    
    private String idOrig;
    
    public MessageToRoom(){
        
    }
    
    /**
     * COntent to be sent
     * @param content 
     */
    public void setContent(String content){
        this.content=content;
    }
    
    /**
     * Get the Content
     * @return 
     */
    public String getContent(){
        return this.content;
    }

    /**
     * @return the idDest
     */
    public String getIdDest() {
        return idDest;
    }

    /**
     * @param idDest the idDest to set
     */
    public void setIdDest(String idDest) {
        this.idDest = idDest;
    }

    /**
     * @return the idOrig
     */
    public String getIdOrig() {
        return idOrig;
    }

    /**
     * @param idOrig the idOrig to set
     */
    public void setIdOrig(String idOrig) {
        this.idOrig = idOrig;
    }
   
}
