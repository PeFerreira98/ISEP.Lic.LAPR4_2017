/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.Serializable;

/**
 *
 * @author Fernando
 */
public class EchoReply implements Serializable{
    private String nameReply;
    private String nameRequest;
    private int requestNumber;
    
    
    public EchoReply( String nmReply, EchoRequest request ){
        nameReply = nmReply;
        nameRequest = request.whoAsk();
        requestNumber = request.theRequest();
    }
    
    public int theRequest(){
        return requestNumber;
    }
    
    public String whoAsk(){
        return nameRequest;
    }
    
    public String whoAnswered(){
        return nameReply;
    }
    
}
