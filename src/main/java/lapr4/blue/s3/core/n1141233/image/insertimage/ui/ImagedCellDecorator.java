package lapr4.blue.s3.core.n1141233.image.insertimage.ui;

import csheets.core.Cell;
import csheets.ui.ext.CellDecorator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.ui.ImageOverlayUI;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagesExtension;

/**
 * A decorator for imaged cells.
 *
 * @author Rafael Vieira
 */
public class ImagedCellDecorator extends CellDecorator
{

    private static final Font FONT = new Font("Dialog", Font.PLAIN, 10);

    /**
     * Creates a new cell decorator.
     */
    public ImagedCellDecorator()
    {
        //empty constructor
    }

    /**
     * Decorates the given graphics context if the cell being rendered has an
     * image
     *
     * @param component the cell renderer component
     * @param g the graphics context on which drawing should be done
     * @param cell the cell being rendered
     * @param selected whether the cell is selected
     * @param hasFocus whether the cell has focus
     */
    @Override
    public void decorate(JComponent component, Graphics g, Cell cell, boolean selected, boolean hasFocus)
    {
        if (enabled)
        {
            ImagenableCell imagenableCell = (ImagenableCell) cell.getExtension(ImagesExtension.NAME);
            if (imagenableCell.hasImages())
            {
                // Stores current graphics context properties
                Graphics2D g2 = (Graphics2D) g;
                Color oldPaint = g2.getColor();
                Font oldFont = g2.getFont();

                // Prints '*' using own font, then restores the old font
                g2.setColor(Color.red);
                g2.setFont(FONT);
                g2.drawString("*", 70, 16);

                // Restores graphics context properties
                g2.setColor(oldPaint);
                g2.setFont(oldFont);
            }
        }
    }
}
