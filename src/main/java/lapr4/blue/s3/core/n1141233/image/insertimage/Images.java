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

    private final String name;

    /**
     * The image
     */
    private final byte[] image;

    /**
     * The constructor
     *
     * @param url_link link of the image
     *
     * @throws java.io.IOException
     */
    public Images(String url_link) throws IOException
    {
        File f = new File(url_link);
        this.name = f.getName();
        image = Converter.setImage(f);
    }

    /**
     * Returns the url/link of the image
     *
     * @return String of the url/link
     */
    public String name()
    {
        return name;
    }

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
