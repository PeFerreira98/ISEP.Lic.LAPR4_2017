/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;


import java.io.File;
import java.util.Objects;

/**
 * This FileDTO is an objecto to transfer data between processes regarding Files and provide some extra functions. <br>
 * While minimizing the chance of someone using this same file object in two threads. <br>
 * Also, we wish to add the serialNumber to the file. <br>
 * And make a specific toString, while avoiding extends. <br>
 * @author Hugo
 */
public class FileDTO implements Comparable<FileDTO> {
    
    //** The File inside this object */
    //private File file;
    /** The serialNumber of this FileDTO */
    private final int serialNumber;
    /** The filename of this File */
    private final String filename;
    /** The absolute path of this fileName */
    private final String path;
            
    /**
     * Constructor with parameters.
     * @param file the file to wrap this FileDTO around
     * @param serialNumber the serial number of this FileDTO
     */
    public FileDTO(File file, int serialNumber){
        if(file == null) throw new IllegalArgumentException("Null file");
        //this.file = file;
        this.serialNumber = serialNumber;
        this.filename = file.getName();
        this.path = file.getAbsolutePath();
    }

    /**
     * Allows the reading of it's serial number.
     * @return int with the serial number
     */
    public int serial() {
        return this.serialNumber;
    }

    /** KILLED, THERE IS NO NEED. TURNED INTO PURE DTO
     * Unwraps the file AVOID USE TODO :  check if we really need this, if not, kill it.
     * @return the file inside the FileDTO 
     */
    //public File file() {return this.file;}
    
    /**
     * Returns the full path of the file
     * @return the full path of the file
     */
    public String path() {return this.path;}
    
    
    /**
     * Return the filename
     * @return filename
     */
    public String filename(){return this.filename;}
    
    /**
     * Displays the filename.
     * @return filename in String form
     */
    @Override
    public String toString(){return this.filename;}

    /**
     * Hashcode, based on the path of the file
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.path);
        return hash;
    }

    /**
     * Compares FileDTO, based on the path of the file. Same path, same file.
     * @param obj the other object to compare.
     * @return true if equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileDTO other = (FileDTO) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        return true;
    }

    

    
    /**
     * Compares this object with the specified object for order.
     * @param o objecto to compare to
     * @return Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. 
     */
    @Override
    public int compareTo(FileDTO o) {
        return this.path.compareTo(o.path);
    }
    
    
    
    
    
}