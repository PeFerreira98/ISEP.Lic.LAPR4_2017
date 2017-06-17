package lapr4.blue.s3.core.n1141233.image.imageoverlay;

import csheets.core.Cell;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.ui.ImageOverlayUI;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagesExtension;

/**
 *
 * @author Rafael Vieira
 */
public class OverlayMouseMotionListener extends MouseMotionAdapter
{

    private SpreadsheetTable table;
    private static boolean active = true;

    public OverlayMouseMotionListener()
    {
        //EMPTY CONSTRUCTOR
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (active)
        {
            table = (SpreadsheetTable) e.getSource();
            int row = table.rowAtPoint(e.getPoint());
            int column = table.columnAtPoint(e.getPoint());
            Cell cell = table.getSpreadsheet().getCell(column, row);

            ImagenableCell choosedCell = (ImagenableCell) cell.getExtension(ImagesExtension.NAME);

            if (choosedCell.hasImages())
            {
                active = false;

                table.removeMouseMotionListener(this);

                Point point = MouseInfo.getPointerInfo().getLocation();
                ImageOverlayUI ui = new ImageOverlayUI(choosedCell, point);
                ui.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        Point mousePos = MouseInfo.getPointerInfo().getLocation();
                        Rectangle bounds = ui.getBounds();
                        bounds.setLocation(ui.getLocationOnScreen());
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        Point mousePos = MouseInfo.getPointerInfo().getLocation();
                        Rectangle bounds = ui.getBounds();
                        bounds.setLocation(ui.getLocationOnScreen());

                        if (!bounds.contains(mousePos))
                        {
                            ui.dispose();
                            OverlayMouseMotionListener.setActive();
                        }
                    }
                });
            }
        }
    }

    public static void setActive()
    {
        active = true;
    }

    public static boolean isActive()
    {
        return active;
    }
}
