/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm.sharecells;

import csheets.core.Address;
import csheets.core.Cell;
import java.io.Serializable;
import java.lang.Comparable;

/**
 * This class implements a "version" of the Cell that is suitable for communication 
 * without serializing the all graph of the sheet.<p>
 * Need to include at least: getAddress() and getContent()<p>
 * Need to see the best way to get a set of CellDTO from a set o regular Cells <p>
 * (see SortedSet SpreadsheetImpl.getCells(Address address1, Address address2)).
 * @author alexandrebraganca
 */
public class CellDTO implements Serializable, Comparable<CellDTO> {
    
    private Address address;
    private String content;
    
    public CellDTO(Address addr, String cont) {
        address=addr;
        content=cont;
    }
    
    public static CellDTO createFromCell(Cell aCell) {
        return new CellDTO(aCell.getAddress(), aCell.getContent());
    }
    
    public Address getAddress() {
        return address;
    }
    
    public String getContent() {
        return content;
    }

    @Override
    public int compareTo(CellDTO o) {
	return address.compareTo(o.getAddress());
    }
}
