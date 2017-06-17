package lapr4.blue.s3.core.n1141233.image.imageoverlay;

import csheets.ui.ext.TableDecorator;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;

/**
 * Adds a MouseMotionListener to the SpreadsheetTable it is decorating
 *
 * @author Rafael Vieira
 */
public class OverlayTableDecorator extends TableDecorator
{

    public static final OverlayMouseMotionListener OVERLAY_MOUSE_MOTION_LISTENER = new OverlayMouseMotionListener();

    /**
     * empty constructor
     */
    public OverlayTableDecorator()
    {
        setEnabled(true);
    }

    @Override
    public void decorate(Graphics g, SpreadsheetTable table)
    {
        for (MouseMotionListener mml : table.getMouseMotionListeners())
        {
            if (mml == OVERLAY_MOUSE_MOTION_LISTENER)
            {
                // listener already added, end method call
                return;
            }
        }
        table.addMouseMotionListener(OVERLAY_MOUSE_MOTION_LISTENER);
    }
}
