/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The SHARED container class that stores the files found. It stores them under the form of a FileDTO object. <br>
 * Implements the Observable interface. <br>
 * It's not a singleton. <br>
 * @author Hugo
 */
public class FileContainer extends Observable{
    
    /** The list where we store the FileDTO objects found */
    private List<FileDTO> lista;
    /** This store the information for the method that feeds this container if it's to exit.*/
    private boolean exit;
    
    /**
     * No parameter constructor.
     */
    public FileContainer(){
        this.lista = new ArrayList();
        this.exit = false;
    }
    
    /**
     * Allows the insertion of a File in the container.
     * @param file the FILE to be inserted.
     */
    public synchronized void insertFile(File file){
        int size = lista.size();
        FileDTO element = new FileDTO(file, size );
        this.lista.add(element);
        
        this.setChanged();
        
        this.notifyObservers(element);
        
    }
    
    public List getList(){return this.lista;}
    
    
    /** Allows to get the FileDTO stored with the number i 
     * @param i index of stored FileDTO 
     * @return a FileDTO from that index or NULL (from List) 
     */
    public synchronized FileDTO get(int i){return this.lista.get(i);}
    
    /**
     * Allows us to empty the container. Clears the list.
     */
    public synchronized void emptyMe(){this.lista.clear();}
    
    /**
     * Returns the size of the List
     * @return size of the internal List
     */
    public synchronized int size(){return this.lista.size();}
    
    /**
     * Indicates the container that the variable exit should be set to true
     */
    public synchronized void setToExit(){this.exit = true;}
    
    /**
     * Reads the value of the exit variable. Used by the method that feeds this container to know if it should die.
     * @return true if to exit is true, else false.
     */
    public synchronized boolean isToExit() {return this.exit;}
    
    
}