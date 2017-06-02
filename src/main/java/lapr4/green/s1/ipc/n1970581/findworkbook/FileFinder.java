/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;
import java.io.File;
import java.io.FilenameFilter;

/**
 * Generic file finding Threadable class
 * @author Hugo
 */
public class FileFinder implements Runnable{
    /** The root directory of where to look for our file types */
    private File root;
    /** The FilenameFilter to use to filter filenames */
    private FilenameFilter filenameFilter;
    /** The FileContainer that will store all the Files that match the FilenameFilter inside our root Directory */
    private FileContainer container;
    
    /**
     * 
     * @param dir The FILE root directory of where to look for our file types. Must be a directory.
     * @param container The FileContainer that will store all the Files that match the FilenameFilter inside our root Directory
     * @param filenameFilter  The FilenameFilter to use to filter filenames 
     */
    public FileFinder(File dir, FileContainer container , FilenameFilter filenameFilter){
        if (dir == null || container == null || filenameFilter == null) throw new IllegalArgumentException("Null parameter passed");
        if (!dir.isDirectory()) throw new IllegalArgumentException("dir must be a directory");
        this.root = dir;
        this.container = container;
        this.filenameFilter = filenameFilter;
    }

    /**
     * Main runnable method for Thread , just starts a search.
     */
    @Override
    public void run() {
        this.searchInDir(root);
    }
    
    /**
     * Recursive method to find the matching files and place them in the container. Calls itself for each subdirectory.
     * @param dir the FILE directory where to search.
     */
    public void searchInDir(File dir){
        File[] filelist = dir.listFiles(this.filenameFilter);
        for(File file : filelist){
            if(file.isFile())this.container.insertFile(file);
        }
        File[] dirList = dir.listFiles();
        for(File localDir : dirList){
            if(localDir.isDirectory() && !container.isToExit()){// Se for diretorio e não existir indicação de sair.
                System.out.println("Searching in " + localDir.getName());
                searchInDir(localDir);
            }
        }
    }
    
}
