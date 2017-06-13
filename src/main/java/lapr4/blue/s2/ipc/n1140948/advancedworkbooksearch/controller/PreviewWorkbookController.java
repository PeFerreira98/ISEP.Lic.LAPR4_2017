/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.controller;

import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import java.io.IOException;
import lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.DescodificadorWorkbook;
import lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.UI.PreviewUI;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileDTO;
import lapr4.green.s1.ipc.n1970581.findworkbook.ui.SearchWorkbookPanel;

/**
 *
 * @author Tiago Silvestre
 */
public class PreviewWorkbookController {
    
    private SearchWorkbookPanel searchWorkbookPanel;
    private UIController uiController;
    private DescodificadorWorkbook descWorkBook;
    private PreviewUI previewUI;
    private Workbook oldWorkbook;

    private PreviewWorkbookController() {
    }

    public PreviewWorkbookController(SearchWorkbookPanel aThis, UIController uiCtrl) {
        this.searchWorkbookPanel = aThis;
        this.uiController = uiCtrl;
        this.oldWorkbook = uiController.getActiveWorkbook();
    }
    
    public Workbook openFile(FileDTO file) {
        Workbook workbook = null;
        if (file != null) {
            workbook = uiController.getActiveWorkbook();
        } else {
            throw new NullPointerException("File can't be null");
        }
        return workbook;
    }
    
    public Workbook getPreviousWorkbook(){
        Workbook old = this.oldWorkbook;
        return old;
    }
    
    public void setPreviousWorkbook(Workbook old){
        old = this.oldWorkbook;
    }
    
    /**
     * For best performance, the object DescodificadorWorkbook is only created
     * now
     *
     * @param workbook Workbook
     * @param file File
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void previewFile(Workbook workbook, FileDTO file) throws IOException, FileNotFoundException, ClassNotFoundException {
        descWorkBook = new DescodificadorWorkbook(workbook, file, searchWorkbookPanel);
        descWorkBook.descodificador();
        showPreviewWorkbook(descWorkBook);
    }

    /**
     * For best performance, the object PreviewUI is only created now
     *
     * @param descWorkBook DescodificadorWorkbook
     */
    private void showPreviewWorkbook(DescodificadorWorkbook descWorkBook) {
        previewUI = new PreviewUI(descWorkBook, uiController);
    }
    
}
