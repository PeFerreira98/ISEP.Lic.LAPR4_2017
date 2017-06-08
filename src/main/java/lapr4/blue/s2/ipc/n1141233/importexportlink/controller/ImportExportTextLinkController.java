package lapr4.blue.s2.ipc.n1141233.importexportlink.controller;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ui.ctrl.UIController;
import java.io.File;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ExportLinkListener;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ImportLinkRunnable;

/**
 * Controller for use case: IPC04.2 Import/Export Data Link
 *
 * @author Rafael Vieira
 */
public class ImportExportTextLinkController
{

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * Constructor of the ImportExportTextLinkController
     *
     * @param uiController user interface controller
     */
    public ImportExportTextLinkController(UIController uiController)
    {
        this.uiController = uiController;
    }

    /**
     * Gets a range of cells selected by the user and converts to String.
     *
     * @param cells a matrix of cells
     * @return String with the address of the cells (Example B2:D4)
     */
    public String getRangeOfCells(Cell[][] cells)
    {
        String range = cells[0][0].getAddress().toString();
        if (cells.length > 1 || cells[0].length > 1)
        {
            range += ":" + cells[cells.length - 1][cells[0].length - 1].getAddress().toString();
        }
        return range;
    }

    /**
     * This method creates a new Thread that imports the data from the file and
     * updates the cells everytime the file is altered
     *
     * @param filename the name of the text file of the columns or is a regular
     * row
     * @throws Exception if the name is not inserted
     */
    public void importFromTextFile(String filename) throws Exception
    {
        //trimming
        filename = filename.trim();

        // validations
        if (filename.isEmpty())
        {
            throw new Exception("Please insert a file name");
        }

        if (!new File(filename).exists())
        {
            throw new Exception("The text file doesn't exist");
        }
        // validations end

        Cell activeCell = uiController.getActiveCell();

        ImportLinkRunnable importLinkRunnable = new ImportLinkRunnable(uiController, activeCell, filename);

        new Thread(importLinkRunnable).start();
    }

    /**
     * This method creates a cell listener that exports the data to a file and
     * adds the listener to all the selected cells
     *
     * @param selectedCells the cells selected by the user
     * @param filename the name of the text file
     * @param specialChar the special character to separate columns
     * @throws Exception if the name of the file is not inserted or the file
     * already exists
     */
    public void exportToTextFile(Cell[][] selectedCells, String filename, String specialChar) throws Exception
    {
        //trimming
        specialChar = specialChar.trim();
        filename = filename.trim().endsWith(".txt") ? filename.trim() : filename.trim() + ".txt";

        // validations
        if (specialChar.isEmpty())
        {
            throw new Exception("Please insert a valid special character");
        }

        if (filename.isEmpty())
        {
            throw new Exception("Please insert a file name");
        }

        if (new File(filename).exists())
        {
            throw new Exception("The text file already exists");
        }
        // validations end

        ExportLinkListener listener = new ExportLinkListener(selectedCells, filename, specialChar);
        listener.exportToTextFile();

        for (Cell[] rows : selectedCells)
        {
            for (Cell columns : rows)
            {
                columns.addCellListener(listener);
            }
        }
    }

    /**
     * This method checks if the cells contains the same special character to
     * use on export
     *
     * @param specialChar the special character in cause
     * @param selectedCells the cells selected by the user
     * @throws Exception if the cell contains the special character
     */
    public void checkCells(String specialChar, Cell[][] selectedCells) throws Exception
    {
        specialChar = specialChar.trim();
        for (Cell[] rows : selectedCells)
        {
            for (Cell columns : rows)
            {
                if (columns.getContent() != null)
                {
                    if (columns.getContent().contains(specialChar))
                    {
                        throw new Exception("Invalid special character, please replace it");
                    }
                }
            }
        }
    }
}
