/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140953.variables.temporary;

import csheets.core.Cell;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zero_
 */
public class TemporaryStorage {

    private static Map<String, Temporary> temporaryMap = new HashMap<>();
    
    public static void update(String left, double value) {
        Temporary temporary = new Temporary(temporaryMap.get(left), value);
        temporaryMap.put(left, temporary);
    }

    public static boolean exists(String left) {
        return temporaryMap.containsKey(left);
    }

    public static void add(Cell cell, String left, double value) {
        Temporary temporary = new Temporary(cell, left, value);
        temporaryMap.put(left, temporary);
    }
    
}
