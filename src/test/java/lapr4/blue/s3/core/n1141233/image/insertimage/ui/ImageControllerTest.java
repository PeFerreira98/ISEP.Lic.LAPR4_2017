package lapr4.blue.s3.core.n1141233.image.insertimage.ui;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.controller.ImageOverlayController;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;
import lapr4.blue.s3.core.n1141233.image.insertimage.Images;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagesExtension;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafael Vieira <1141233@isep.ipp.pt>
 */
public class ImageControllerTest
{

    private CleanSheets app;
    private ImageController controller;
    private ImagenableCell cell;

    @Before
    public void setUp()
    {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();

        UIController uiController = new UIController(app);

        cell = (ImagenableCell) app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0)).getExtension(ImagesExtension.NAME);

        controller = new ImageController(uiController);

    }

    /**
     * Test of addImage method, of class ImageController.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddImage() throws Exception
    {
        System.out.println("addImage");
        String location = "nonExistingImage.jpg";
        ImageController instance = controller;
        Images expResult = null;
        Images result = instance.addImage(cell, location);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeImage method, of class ImageController.
     */
    @Test
    public void testRemoveImage()
    {
        System.out.println("removeImage");
        Images image = null;
        ImageController instance = controller;
        boolean expResult = false;
        boolean result = instance.removeImage(cell, image);
        assertEquals(expResult, result);
    }

    /**
     * Test of getImagesList method, of class ImageController.
     */
    @Test
    public void testGetImagesList()
    {
        System.out.println("getImagesList");
        ImageController instance = controller;
        List<Images> expResult = new ArrayList<>();
        List<Images> result = instance.getImagesList(cell);
        assertEquals(expResult, result);
    }

}
