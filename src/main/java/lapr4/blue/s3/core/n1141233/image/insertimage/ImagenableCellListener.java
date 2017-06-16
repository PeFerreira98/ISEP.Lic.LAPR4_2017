package lapr4.blue.s3.core.n1141233.image.insertimage;

import java.util.EventListener;

/**
 * A listener interface for receiving notification on events occurring in an
 * imagenable cell.
 *
 * @author Rafael Vieira
 */
public interface ImagenableCellListener extends EventListener
{

    /**
     * Invoked when a image is added to or removed from a cell.
     *
     * @param cell the cell that was modified
     */
    public void imageChanged(ImagenableCell cell);

}
