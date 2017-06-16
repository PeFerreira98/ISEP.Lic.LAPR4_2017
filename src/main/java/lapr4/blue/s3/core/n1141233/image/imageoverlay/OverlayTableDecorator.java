package lapr4.blue.s3.core.n1141233.image.imageoverlay;

import csheets.ui.ext.TableDecorator;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Rafael Vieira
 */
public class OverlayTableDecorator extends TableDecorator
{

    public static final OverlayMouseMotionListener OVERLAY_MOUSE_MOTION_LISTENER = new OverlayMouseMotionListener();

    public OverlayTableDecorator()
    {
        setEnabled(true);
    }

    @Override
    public void decorate(Graphics g, SpreadsheetTable table)
    {
        System.out.println("decorating...");
        System.out.println(OverlayMouseMotionListener.isActive());
        for (MouseMotionListener mml : table.getMouseMotionListeners())
        {
            if (mml == OVERLAY_MOUSE_MOTION_LISTENER)
            {
                return;
            }
        }
        table.addMouseMotionListener(OVERLAY_MOUSE_MOTION_LISTENER);
    }
}
