/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1141233.image.insertimage;

import csheets.CleanSheets;
import csheets.core.Address;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rafael Vieira <1141233@isep.ipp.pt>
 */
public class ImagenableCellTest
{

    private CleanSheets app;
    private ImagenableCell cell;

    @Before
    public void setUp()
    {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();

        cell = (ImagenableCell) app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0)).getExtension(ImagesExtension.NAME);
    }

    /**
     * Test of getImagesList method, of class ImagenableCell.
     */
    @Test
    public void testGetImagesList()
    {
        System.out.println("getImagesList");
        ImagenableCell instance = cell;
        List<Images> expResult = null;
        List<Images> result = instance.getImagesList();
        assertNotEquals(expResult, result);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of hasImages method, of class ImagenableCell.
     */
    @Test
    public void testHasImages()
    {
        System.out.println("hasImages");
        ImagenableCell instance = cell;
        boolean expResult = false;
        boolean result = instance.hasImages();
        assertEquals(expResult, result);
    }

    /**
     * Test of addImagenableCellListener method, of class ImagenableCell.
     */
    @Test
    public void testAddImagenableCellListener()
    {
        System.out.println("addImagenableCellListener");
        ImagenableCellListener listener = null;
        ImagenableCell instance = cell;
        instance.addImagenableCellListener(listener);
    }

    /**
     * Test of removeImagenableCellListener method, of class ImagenableCell.
     */
    @Test
    public void testRemoveImagenableCellListener()
    {
        System.out.println("removeImagenableCellListener");
        ImagenableCellListener listener = null;
        ImagenableCell instance = cell;
        instance.removeImagenableCellListener(listener);
    }

    /**
     * Test of addImage method, of class ImagenableCell.
     */
    @Test
    public void testAddImage()
    {
        System.out.println("addImage");
        String path = "image_that_does_not_exist.jpg";
        ImagenableCell instance = cell;
        Images expResult = null;
        Images result = instance.addImage(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeImage method, of class ImagenableCell.
     */
    @Test
    public void testRemoveImage()
    {
        System.out.println("removeImage");
        Images image = null;
        ImagenableCell instance = cell;
        boolean expResult = false;
        boolean result = instance.removeImage(image);
        assertEquals(expResult, result);
    }

    /**
     * Test of fireImagesChanged method, of class ImagenableCell.
     */
    @Test
    public void testFireImagesChanged()
    {
        System.out.println("fireImagesChanged");
        ImagenableCell instance = cell;
        instance.fireImagesChanged();
    }

}
