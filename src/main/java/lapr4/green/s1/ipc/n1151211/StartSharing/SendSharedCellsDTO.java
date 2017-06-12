/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

import csheets.core.Address;
import csheets.core.Cell;
import java.io.Serializable;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;

/**
 *
 * @author Fernando
 */
public class SendSharedCellsDTO implements Serializable {
    
    private final String spreadsheetName;
    
    private final SortedSet<CellDTO> sharedcells;
    
    private final Address address1;
    
    private final Address address2;
    private int nmbrOfCells = 0;
    
    public SendSharedCellsDTO(Cell[][] theChosen) {
        
        spreadsheetName = theChosen[0][0].getSpreadsheet().getTitle();
        address1=theChosen[0][0].getAddress();
        address2=theChosen[theChosen.length - 1][theChosen[0].length - 1].getAddress();
        
        // build the serializable set of cells
        sharedcells=new TreeSet<>(); 
        
        nmbrOfCells = 0;
        for( int i = 0; i < theChosen.length; ++i ){
            for( int j = 0; j < theChosen[i].length; ++j ){
                sharedcells.add( CellDTO.createFromCell( theChosen[i][j] ) );
                ++nmbrOfCells;
            }
        }
    }
    
    public SortedSet<CellDTO> getCells() {
        return sharedcells;
    }
    
    public Address getAddress1() {
        return address1;
    }
            
    public Address getAddress2() {
        return address2;
    }
    
    public String getSpreadsheetName() {
        return spreadsheetName;
    }
    public int numberOfCells(){
        return nmbrOfCells;
    }
    
    public Iterator<CellDTO> getIterator(){
        return sharedcells.iterator();
    }
    
}
