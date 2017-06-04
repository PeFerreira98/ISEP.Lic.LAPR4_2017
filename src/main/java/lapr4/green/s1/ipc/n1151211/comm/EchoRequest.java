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
public class EchoRequest implements Serializable{
    private String nameRequest;
    private int requestNumber;
    
    public EchoRequest( String nmRq, int number){
        nameRequest = nmRq;
        requestNumber = number;
    }
    
    public EchoRequest( String nmRq ){
        nameRequest = nmRq;
        requestNumber = 0;
    }
    
    public int nextRequest(){
        return ++requestNumber;
    }
    
    public int theRequest(){
        return requestNumber;
    }
    
    public String whoAsk(){
        return nameRequest;
    }
}
