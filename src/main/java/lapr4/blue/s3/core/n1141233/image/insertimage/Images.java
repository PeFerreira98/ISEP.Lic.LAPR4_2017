package lapr4.blue.s3.core.n1141233.image.insertimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import lapr4.red.s1.core.n1140388.contacts.ui.Converter;

/**
 * Domain class for images
 *
 * @author Rafael Vieira
 */
public class Images implements Serializable
{

    /**
     * The image's name
     */
    private final String name;

    /**
     * The image
     */
    private final byte[] image;

    /**
     * The constructor
     *
     * @param path path to the image
     *
     * @throws java.io.IOException
     */
    public Images(String path) throws IOException, NullPointerException, IllegalArgumentException
    {
        if (path == null)
        {
            throw new NullPointerException("image path can't be null");
        }
        if (path.isEmpty())
        {
            throw new IllegalArgumentException("image path can't be empty");
        }

        File f = new File(path);
        this.name = f.getName();
        this.image = Converter.setImage(f);
    }

    /**
     * Returns the name of the image
     *
     * @return String of the image's name
     */
    public String name()
    {
        return name;
    }

    /**
     * Returns the image as a BufferedImage
     *
     * @return the image itself
     *
     * @throws java.io.IOException
     */
    public BufferedImage image() throws IOException
    {
        return Converter.getImage(image);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Images other = (Images) obj;
        return Objects.equals(this.image, other.image);
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public String toString()
    {
        return "Image: " + name;
    }

}
