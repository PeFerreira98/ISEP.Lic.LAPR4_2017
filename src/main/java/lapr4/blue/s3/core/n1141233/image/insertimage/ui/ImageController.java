package lapr4.blue.s3.core.n1141233.image.insertimage.ui;

import csheets.ui.ctrl.UIController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;
import lapr4.blue.s3.core.n1141233.image.insertimage.Images;

/**
 * A controller for updating the user-specified image of a cell.
 *
 * @author Rafael Vieira
 */
public class ImageController
{

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * A constructor
     *
     * @param uiController the user interface controller
     */
    public ImageController(UIController uiController)
    {
        this.uiController = uiController;
    }

    /**
     * Attempts to create a new image from the given location (string). If
     * successful, adds the image to the given cell. If the input string is
     * empty or null, the image is set to null.
     *
     * @param cell the cell for which the image should be set
     * @param location the location of the image, as entered by the user
     *
     * @return true if the cell's image was changed
     *
     * @throws java.io.IOException if file couldn't be found or opened
     */
    public Images addImage(ImagenableCell cell, String location) throws IOException
    {
        //Stores the image
        Images image = cell.addImage(location);
        if (uiController != null)
        {
            uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        }
        return image;
    }

    /**
     * Attempts to remove the old image from the given location (string). If
     * successful, removes the image to the given cell. If the input string is
     * empty or null, the image is set to null.
     *
     * @param cell the cell for which the image should be removed
     * @param image the image
     *
     * @return true if the cell's image was removed
     */
    public boolean removeImage(ImagenableCell cell, Images image)
    {
        //Removes the image
        cell.removeImage(image);
        if (uiController != null)
        {
            uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        }
        return true;
    }

    /**
     * Returns all the images in this cell
     *
     * @param cell the cell whose images changed
     *
     * @return
     */
    public List<Images> getImagesList(ImagenableCell cell)
    {
        if (cell == null)
        {
            return new ArrayList();
        }
        return cell.getImagesList();
    }
}
