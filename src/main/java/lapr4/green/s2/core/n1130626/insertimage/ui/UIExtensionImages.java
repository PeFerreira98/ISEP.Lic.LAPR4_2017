/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 *
 * @author Pedro Pereira
 */
public class UIExtensionImages extends UIExtension {
    
    /** A cell decorator that visualizes images on cells */
    private CellDecorator cellDecorator;
    
    /** A side bar that provides editing of comments */
    private JComponent sideBar;
    
    /**
     * The menu of the extension
     * @param extension extension
     * @param uiController ui controller 
     */
    public UIExtensionImages(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
    /**
     * Returns an icon to display with the extension's name.
     * @return an icon with style
     */
    public Icon getIcon(){
        return null;
    }
    
    /**
     * Returns an instance of a class that implements JMenu.
     * @return a JMenu component
     */
    public JMenu getMenu(){
        return null;
    }
    
    /**
     * Returns a cell decorator that visualizes images on cells.
     * @return decorator for cells with images
     */
    public CellDecorator getCellDecorator(){
        if(cellDecorator == null){
            cellDecorator = new ImagedCellDecorator();
        }
        return cellDecorator;
    }
    
    /**
     * Returns a table decorator that visualizes the data added by the extension.
     * @return a table decorator, or null if the extension does not provide one
     */
    public TableDecorator getTableDecorator(){
        return null;
    }
    
    /**
     * Returns a toolbar that gives access to extension-specific
     * functionality.
     * @return a JToolBar component, or null if the extension does not provide one
     */
    public JToolBar getToolBar(){
        return null;
    }
    
    /**
     * Returns a side bar that provides editing of images.
     * @return a side bar
     */
    public JComponent getSideBar(){
        if(sideBar == null){
            
        }
        return sideBar;
    }
}
