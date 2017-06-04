/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140953.variables.temporary;

import csheets.core.Value;

/**
 *
 * @author zero_
 */
public class Temporary {
    
    private String name;
    private Value value;

    public Temporary(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }
    
}
