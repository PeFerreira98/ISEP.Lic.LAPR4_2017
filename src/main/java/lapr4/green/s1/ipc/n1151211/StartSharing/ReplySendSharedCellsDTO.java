/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

import csheets.core.Address;
import java.io.Serializable;
import java.util.SortedSet;

/**
 *
 * @author Fernando
 */
public class ReplySendSharedCellsDTO  implements Serializable {
    
    private final String message;
    
    public ReplySendSharedCellsDTO(String msg) {
        message = msg; 
    }
    
    public String messageText(){
        return message;
    }
}
