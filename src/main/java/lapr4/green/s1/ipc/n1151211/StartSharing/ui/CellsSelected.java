/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Fernando
 */
public class CellsSelected extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public CellsSelected(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Export data to a text file";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cell[][] theOnesChosen() {
        return focusOwner.getSelectedCells();
    }
}

//    @Override
//    public void selectionChanged(SelectionEvent event) {
//        System.out.println("CellsSelected");
//        if( event.getCell() != null )
//            System.out.println("cell" + event.getCell().getAddress().toString() );
//        if( event.getPreviousCell() != null )
//            System.out.println("prev" + event.getPreviousCell().getAddress().toString() );
//    }

