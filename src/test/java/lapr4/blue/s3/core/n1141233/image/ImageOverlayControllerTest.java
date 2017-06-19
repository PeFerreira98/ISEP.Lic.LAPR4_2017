/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1141233.image;

import csheets.CleanSheets;
import csheets.core.Address;
import java.awt.Image;
import java.io.IOException;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.controller.ImageOverlayController;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagesExtension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rafael Vieira
 */
public class ImageOverlayControllerTest
{

    private CleanSheets app;
    private ImageOverlayController controller;
    private ImagenableCell cell;

    @Before
    public void setUp()
    {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();

        cell = (ImagenableCell) app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0)).getExtension(ImagesExtension.NAME);

        controller = new ImageOverlayController(cell);

    }

    @Test
    public void testGetImage() throws IOException
    {
        Image image = null;

        Assert.assertEquals(image, controller.getImage());
    }

    @Test
    public void testGetNextImage() throws IOException
    {
        Image image = null;

        Assert.assertEquals(image, controller.getNextImage());
    }

    @Test
    public void testGetPreviousImage() throws IOException
    {
        Image image = null;

        Assert.assertEquals(image, controller.getPreviousImage());
    }

    @Test
    public void testGetImagesNum() throws IOException
    {
        int expected = 0;

        Assert.assertTrue(expected == controller.getImagesNum());
    }
}
