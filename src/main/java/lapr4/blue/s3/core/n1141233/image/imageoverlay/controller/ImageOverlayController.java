package lapr4.blue.s3.core.n1141233.image.imageoverlay.controller;

import java.awt.Image;
import java.io.IOException;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;

/**
 *
 * @author Rafael Vieira
 */
public class ImageOverlayController
{

//    private final UIController uIController;
    private final ImagenableCell cell;
    private int imageIndex;

    public ImageOverlayController(ImagenableCell cell)
    {
//        this.uIController = uiController;
        this.cell = cell;
        this.imageIndex = 0;
    }

    public Image getImage() throws IOException
    {
        return cell.getImagesList().get(imageIndex).image();
    }

    public Image getNextImage() throws IOException
    {
        imageIndex++;
        return getImage();
    }

    public Image getPreviousImage() throws IOException
    {
        imageIndex--;
        return getImage();
    }

    public int getImagesNum()
    {
        return cell.getImagesList().size();
    }
}
