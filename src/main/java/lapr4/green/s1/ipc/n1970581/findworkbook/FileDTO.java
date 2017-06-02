/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;


import java.io.File;
import java.util.Objects;

/**
 * This FileDTO is a wraper to store our File in and provide some extra functions. <br>
 * While minimizing the chance of someone using this same file object in two threads. <br>
 * Also, we wish to add the serialNumber to the file. <br>
 * And make a specific toString, while avoiding extends. <br>
 * @author Hugo
 */
public class FileDTO {
    
    /** The File inside this object */
    private File file;
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
        this.file = file;
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

    /**
     * Unwraps the file AVOID USE TODO :  check if we really need this, if not, kill it.
     * @return the file inside the FileDTO 
     */
    public File file() {return this.file;}
    
    /**
     * Returns the full path of the file
     * @return the full path of the file
     */
    public String path() {return this.path;}
    
    
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
    
    
    
    
    
}