package lapr4.blue.s3.core.n1141233.image.imageoverlay.controller;

import java.awt.Image;
import java.io.IOException;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;

/**
 * A controller for fetching the associated images of a cell.
 *
 * @author Rafael Vieira
 */
public class ImageOverlayController
{

    /**
     * the cell to view the associated images
     */
    private final ImagenableCell cell;

    /**
     * current image index
     */
    private int imageIndex;

    /**
     * A constructor
     *
     * @param cell currently being hovered cell
     */
    public ImageOverlayController(ImagenableCell cell)
    {
        this.cell = cell;
        this.imageIndex = 0;
    }

    /**
     * returns the image according to the actual image index
     *
     * @return the actual image
     *
     * @throws IOException could not get the image
     */
    public Image getImage() throws IOException
    {
        if (cell.hasImages())
        {
            return cell.getImagesList().get(imageIndex).image();
        }
        return null;
    }

    /**
     * returns the next image in the list according to the actual image index
     *
     * @return the next image in the list
     *
     * @throws IOException could not get the image
     */
    public Image getNextImage() throws IOException
    {
        if (imageIndex < cell.getImagesList().size())
        {
            imageIndex++;
        }
        return getImage();
    }

    /**
     * returns the previous image in the list according to the actual image
     * index
     *
     * @return the previous image in the list
     *
     * @throws IOException could not get the image
     */
    public Image getPreviousImage() throws IOException
    {
        if (imageIndex > 0)
        {
            imageIndex--;
        }
        return getImage();
    }

    /**
     * returns the amount of images of the cell
     *
     * @return the next image in the list
     */
    public int getImagesNum()
    {
        return cell.getImagesList().size();
    }
}
