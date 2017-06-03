/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication;

import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class Message implements SendDto{
    
    
    private String content;
    
    public Message(){
        
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

    @Override
    public boolean sendDto(Object dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
