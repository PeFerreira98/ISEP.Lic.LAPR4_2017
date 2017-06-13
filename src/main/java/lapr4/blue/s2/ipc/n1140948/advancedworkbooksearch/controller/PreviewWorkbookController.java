package lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.controller;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.DescodificadorWorkbook;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileDTO;

/**
 *
 * @author Tiago Silvestre
 */
public class PreviewWorkbookController
{

    private final UIController uiController;
    private final FileDTO file;

    private final DescodificadorWorkbook decoderWorkBook;

    private final Workbook previewWorkbook;

    public PreviewWorkbookController(FileDTO file, UIController uiController) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        this.file = file;
        this.uiController = uiController;
        this.previewWorkbook = openFile(file);
        this.decoderWorkBook = new DescodificadorWorkbook(previewWorkbook);
    }

    private Workbook openFile(FileDTO file) throws IOException, ClassNotFoundException
    {
        Workbook workbook = null;
        if (file != null)
        {

            CleanSheets cs = new CleanSheets();
            File f = new File(file.path());
            cs.load(f);
            workbook = cs.getWorkbook(f);
        }
        else
        {
            throw new NullPointerException("File can't be null");
        }
        return workbook;
    }

    public int matrixSize()
    {
        return DescodificadorWorkbook.matrixSize();
    }

    public int[] minCellHorizontal()
    {
        return decoderWorkBook.minCellHorizontal();
    }

    public int[] minCellVertical()
    {
        return decoderWorkBook.minCellVertical();
    }

    public int numSheet()
    {
        return decoderWorkBook.numSheet();
    }

    public void open()
    {
        uiController.setActiveWorkbook(previewWorkbook);
    }

    public Cell[][][] CellList()
    {
        return decoderWorkBook.CellList();
    }

}
