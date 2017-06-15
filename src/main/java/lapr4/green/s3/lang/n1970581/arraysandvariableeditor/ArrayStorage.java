/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.Value;
import csheets.core.Workbook;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Hugo
 */
public class ArrayStorage {
    
    Workbook workbook;
    Map <String , ArrayItem> variableMap;
    //Map <String , Value> variableMap;
    
    public ArrayStorage(){
        variableMap = new LinkedHashMap<>();
    }
    
    
    public ArrayItem retrieveArrayItem(String name){
        ArrayItem aux = this.variableMap.get(name);
        //Value aux = this.variableMap.get(name);
        if (aux == null) {
            this.variableMap.put(name, new ArrayItem(name));
            System.out.println("DEBUG: created new ArrayItem.");
            return this.variableMap.get(name);
        }
            System.out.println("DEBUG: got an ArrayItem.");
        return aux;
    }
    
    
    
}
