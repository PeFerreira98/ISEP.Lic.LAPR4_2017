/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.ObjectOutputStream;

public interface CommHandler2 {
    /**
     * 
     * @param dto the object received by the socket
     * @param outStream the output stream to be used to send a reply/response to the socket
     */
    public void handleDTO(Object dto, ObjectOutputStream outStream);
    
    public Object getLastReceivedDTO();
}
