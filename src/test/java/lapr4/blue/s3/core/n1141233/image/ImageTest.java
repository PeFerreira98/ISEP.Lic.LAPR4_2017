package lapr4.blue.s3.core.n1141233.image;

import java.io.IOException;
import lapr4.blue.s3.core.n1141233.image.insertimage.Images;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rafael Vieira
 */
public class ImageTest
{

    private Images image;

    @Test
    public void testImagesNullImagePath()
    {
        String nullPath = null;
        try
        {
            image = new Images(nullPath);
            fail();
        }
        catch (IOException | IllegalArgumentException ex)
        {
            fail();
        }
        catch (NullPointerException ex)
        {
            System.out.println("testImagesNullImagePath Success");
        }
    }

    @Test
    public void testImagesEmptyImagePath()
    {
        String emptyPath = "";
        try
        {
            image = new Images(emptyPath);
            fail();
        }
        catch (IOException | NullPointerException ex)
        {
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("testImagesEmptyImagePath Success");
        }
    }

    @Test
    public void testImagesNonExistingImage()
    {
        String notFound = "fileThatHopefullyDoesNotExist.jpg";
        try
        {
            image = new Images(notFound);
            fail();
        }
        catch (IllegalArgumentException | NullPointerException ex)
        {
            fail();
        }
        catch (IOException ex)
        {
            System.out.println("testImagesNonExistingImage Success");
        }
    }
}
