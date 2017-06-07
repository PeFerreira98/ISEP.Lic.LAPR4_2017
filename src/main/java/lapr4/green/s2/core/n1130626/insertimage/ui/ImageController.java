/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.green.s2.core.n1130626.insertimage.ImagenableCell;
import lapr4.green.s2.core.n1130626.insertimage.Images;

/**
 *
 * @author Pedro Pereira
 */
public class ImageController {
    
    /** The user interface controller */
    private UIController uiController;
    
    /** The cell */
    private Cell cell;
    
    public ImageController(UIController uiController){
        this.uiController = uiController;
    }
    
    /**
     * Creates a new image controller.
     * @param uiController the user interface controller
     * @param cell the cell
     */
    public ImageController(UIController uiController, Cell cell){
        this.uiController = uiController;
        this.cell = cell;
    }
    
    /**
     * Returns all the images in this cell 
     * @param cell the cell whose images changed
     * @return 
     */
    public List<Images> getImagesList(ImagenableCell cell){
        if(cell == null){
            return new ArrayList();
        }
        return cell.getImagesList();
    }
}
