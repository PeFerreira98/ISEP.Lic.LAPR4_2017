package lapr4.blue.s3.core.n1141233.image.insertimage;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An extension of a cell in a spreadsheet, with support for images.
 *
 * @author Rafael Vieira
 */
public class ImagenableCell extends CellExtension
{

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 1L;

    /**
     * The cell's user-specified images list
     */
    private final List<Images> imagesList = new ArrayList<>();

    /**
     * The listeners registered to receive events from the imagenable cell
     */
    private transient List<ImagenableCellListener> listeners = new ArrayList<ImagenableCellListener>();

    /**
     * Creates a imagenable cell extension for the given cell.
     *
     * @param cell the cell to extend
     */
    ImagenableCell(Cell cell)
    {
        super(cell, ImagesExtension.NAME);
    }

    /*
     * DATA UPDATES
     */
    /**
     * IMAGE ACCESSORS
     */
    /**
     * Get the images list on this cell
     *
     * @return the images list
     */
    public List<Images> getImagesList()
    {
        return imagesList;
    }

    /**
     * Return wether the cell has images.
     *
     * @return true if the cell has images;
     */
    public boolean hasImages()
    {
        if (this.imagesList == null)
        {
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
     *
     * @param listener the listener to be added
     */
    public void addImagenableCellListener(ImagenableCellListener listener)
    {
        if (listener != null)
        {
            listeners.add(listener);
        }
    }

    /**
     * Removes the given listener from the cell.
     *
     * @param listener the listener to be removed
     */
    public void removeImagenableCellListener(ImagenableCellListener listener)
    {
        if (listener != null)
        {
            listeners.remove(listener);
        }
    }

    /**
     * Adds a image to this cell's images list
     *
     * @param path the path to the image
     *
     * @return the added image or null case the image was not added
     */
    public Images addImage(String path)
    {
        try
        {
            Images newImage = new Images(path);
            if (imagesList.add(newImage))
            {
                // Notifies listeners
                fireImagesChanged();
                return newImage;
            }
        }
        catch (IOException ex)
        {
        }
        return null;
    }

    /**
     * Remove an image from the cell images list
     *
     * @param image the image to be removed
     *
     * @return true if the image was removed, false if the image was null or was
     * not removed
     */
    public boolean removeImage(Images image)
    {
        if (image != null)
        {
            if (imagesList.remove(image))
            {
                // Notifies listeners
                fireImagesChanged();
                return true;
            }
        }
        return false;
    }

    /**
     * Notifies all registered listeners that the cell's images changed.
     */
    protected void fireImagesChanged()
    {
        listeners.forEach((listener) ->
        {
            listener.imageChanged(this);
        });
    }

    /**
     * Customizes serialization, by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     *
     * @throws java.io.IOException If any of the usual Input/Output related
     * exceptions occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    private void readObject(java.io.ObjectInputStream stream)
            throws java.io.IOException, ClassNotFoundException
    {
        stream.defaultReadObject();
        listeners = new ArrayList<>();
    }
}
