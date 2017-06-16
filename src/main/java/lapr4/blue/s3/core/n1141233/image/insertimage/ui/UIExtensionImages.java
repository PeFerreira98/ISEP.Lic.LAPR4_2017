package lapr4.blue.s3.core.n1141233.image.insertimage.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.OverlayTableDecorator;

/**
 * This class implements the UI interface extension for the images extension. A
 * UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author Rafael Vieira
 */
public class UIExtensionImages extends UIExtension
{

    /**
     * A cell decorator that visualizes images on cells
     */
    private CellDecorator cellDecorator;

    /**
     * A cell decorator that opens the images overlay
     */
    private TableDecorator tableDecorator;

    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionImages(Extension extension, UIController uiController)
    {
        super(extension, uiController);
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    @Override
    public Icon getIcon()
    {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu.
     *
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu()
    {
        return null;
    }

    /**
     * Returns a cell decorator that visualizes images on cells.
     *
     * @return decorator for cells with images
     */
    @Override
    public CellDecorator getCellDecorator()
    {
        if (cellDecorator == null)
        {
            cellDecorator = new ImagedCellDecorator();
        }
        return cellDecorator;
    }

    /**
     * Returns a table decorator that visualizes the data added by the
     * extension.
     *
     * @return a table decorator, or null if the extension does not provide one
     */
    @Override
    public TableDecorator getTableDecorator()
    {
        if (tableDecorator == null)
        {
            tableDecorator = new OverlayTableDecorator();
        }
        return tableDecorator;
    }

    /**
     * Returns a toolbar that gives access to extension-specific functionality.
     *
     * @return a JToolBar component, or null if the extension does not provide
     * one
     */
    @Override
    public JToolBar getToolBar()
    {
        return null;
    }

    /**
     * Returns a side bar that provides editing of images.
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar()
    {
        if (sideBar == null)
        {
            sideBar = new ImagesPanel(uiController);
        }
        return sideBar;
    }
}
