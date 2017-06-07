/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.util.ArrayList;
import java.util.List;

/**
 * An extension of a cell in a spreadsheet, with support for images.
 * @author Pedro Pereira
 */
public class ImagenableCell extends CellExtension {
    
    /** The unique version identifier used for serialization */
    private static final long serialVersionUID = 1L;
   
    /**
     * The cell's user-specified images list
     */
    private List<Images> imagesList = new ArrayList<>();
    
    /** The listeners registered to receive events from the imagenable cell */
    private transient List<ImagenableCellListener> listeners = new ArrayList<ImagenableCellListener>();
    
    /**
     * Creates a imagenable cell extension for the given cell.
     * @param cell the cell to extend
     */
    ImagenableCell(Cell cell){
        super(cell, ImagesExtension.NAME);
    }
    
/*
 * DATA UPDATES
 */
    
/*
 * IMAGE ACCESSORS
 */
    
    /**
     * Get the images list on this cell
     * @return the images list
     */
    public List<Images> getImagesList(){
        return imagesList;
    }
    
    /**
     * Return wether the cell has images.
     * @return true if the cell has images;
     */
    public boolean hasImages(){
        if(this.imagesList == null){
            return false;
        }
        return !this.imagesList.isEmpty();
    }
    
/*
 * COMMENT MODIFIERS
 */
    
/*
 * EVENT LISTENING SUPPORT
 */

    /**
     * Registers the given listener on the cell.
     * @param listener the listener to be added
     */
    public void addImagenableCellListener(ImagenableCellListener listener){
        listeners.add(listener);
    }
    
    /**
     * Removes the given listener from the cell.
     * @param listener the listener to be removed
     */
    public void removeImagenableCellListener(ImagenableCellListener listener){
        listeners.remove(listener);
    }
    
    /**
     * Adds a image to this cells images list
     * @param urlLink the url or the link of the image
     */
    public void addImage(String urlLink){
        Images newImage = new Images(urlLink);
        imagesList.add(newImage);
        // Notifies listeners
        fireImagesChanged();
    }
    
    public void removeImage(Images imageRemoving){
        imagesList.remove(imageRemoving);
        // Notifies listeners
        fireImagesChanged();
    }
    
    /**
     * Notifies all registered listeners that the cell's comments changed.
     */
    protected void fireImagesChanged(){
        for(ImagenableCellListener listener : listeners){
            listener.imageChanged(this);
        }
    }
    
    /**
     * Customizes serialization, by recreating the listener list.
     * @param stream the object input stream from which the object is to be read
     * @throws java.io.IOException If any of the usual Input/Output related exceptions occur
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    private void readObject(java.io.ObjectInputStream stream)
			throws java.io.IOException, ClassNotFoundException {
	    stream.defaultReadObject();
		listeners = new ArrayList<ImagenableCellListener>();
	}
}
