/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.Value;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class the replicates the storage of Arrays items in a workbook
 * @author Hugo
 */
public class ArrayStorage {
    
    /** The workbook */
    Workbook workbook;
    
    /** The ArrayItems inside this storage */
    Map <String , ArrayItem> variableMap;
    
    /** Default constructor */
    public ArrayStorage(){
        variableMap = new LinkedHashMap<>();
    }
    
    /**
     * Method for retrieving an ArrayItem. If there is none with that name, since it becomes relevant, it's created.
     * @param name the name of the ArrayItem
     * @return the ArrayItem
     */
    public synchronized ArrayItem retrieveArrayItem(String name){
        ArrayItem aux = this.variableMap.get(name);
        //Value aux = this.variableMap.get(name);
        if (aux == null) {
            this.variableMap.put(name, new ArrayItem(name));
            System.out.println("DEBUG: created new ArrayItem.");  //Warns that a new ArrayItem was created.
            return this.variableMap.get(name);
        }
            System.out.println("DEBUG: got an ArrayItem."); // Warns that an ArrayItem was gotten
        return aux;
    }
    
    /**
     * Returns the map of ArrayItems as an list of ArrayItemsDTO
     * @return the map of ArrayItems as an list of ArrayItemsDTO
     */
    public synchronized List<ArrayItemDTO> listContainerAsDTO(){
        List<ArrayItemDTO> list = new ArrayList<>();
        
        for(ArrayItem ai : this.variableMap.values()){
            if(ai != null) list.add(ai.toDTO());
        }
        return list;
    }
    
    /**
     * Allows the edition of an ArrayItem
     * @param dto the DTO that originates the change
     * @param newValue the new value
     * @return true is sucess else false (cannnot find that arrayItem)
     */
    public synchronized boolean editArrayItem(ArrayItemDTO dto, Value newValue){
        String name = dto.name();
        
        ArrayItem toModify = this.variableMap.get(name);
        if(toModify == null) return false;
        
        toModify.setValue(newValue);
        
        return true;
    }
    
}
