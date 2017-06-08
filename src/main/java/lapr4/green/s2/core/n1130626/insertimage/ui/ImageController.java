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
     * Attempts to create a new image from the given location (string).
     * If successful, adds the image to the given cell.
     * If the input string is empty or null, the image is set to null.
     * @param cell the cell for which the image should be set
     * @param location the location of the image, as entered by the user
     * @return true if the cell's image was changed
     */
    public boolean setImage(ImagenableCell cell, String location){
        //Stores the image
        cell.addImage(location);
        if(uiController != null){
            uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        }
        return true;
    }
    
    public boolean removingImage(ImagenableCell cell, String location){
        //Removes the image
        cell.removeImage(location);
        if(uiController != null){
            uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        }
        return true;
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
