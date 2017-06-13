/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing;

import csheets.core.Cell;
import csheets.core.CellListener;
import lapr4.green.s1.ipc.n1151211.StartSharing.ui.UIStartSharing;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateCellListener implements CellListener {

    private final UIStartSharing controller;

    public SharingAutomaticUpdateCellListener(UIStartSharing uIStartSharing) {
        this.controller = uIStartSharing;
    }

    @Override
    public void valueChanged(Cell cell) {
        this.controller.quickShare(cell);
    }

    @Override
    public void contentChanged(Cell cell) {
        this.controller.quickShare(cell);
    }

    @Override
    public void dependentsChanged(Cell cell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCleared(Cell cell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
