/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage;

import java.util.EventListener;

/**
 * A listener interface for receiving notification on events occurring in an
 * imagenable cell.
 * @author Pedro Pereira
 */
public interface ImagenableCellListener extends EventListener {
    
    /**
     * Invoked when a image is added to or removed from a cell.
     * @param cell the cell that was modified
     */
    public void imageChanged(ImagenableCell cell);
    
}
