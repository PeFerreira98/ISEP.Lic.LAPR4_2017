package lapr4.blue.s2.ipc.n1141233.importexportlink.controller;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ExportLinkListener;
import lapr4.blue.s2.ipc.n1141233.importexportlink.ImportLinkRunnable;
import lapr4.blue.s2.ipc.n1141233.importexportlink.Link;
import lapr4.blue.s2.ipc.n1141233.importexportlink.LinkStorage;
import lapr4.green.s1.ipc.n1130626.importexporttext.controller.ImportExportTextController;

/**
 * Controller for use case: IPC04.2 Import/Export Data Link
 *
 * @author Rafael Vieira
 */
public class ImportExportTextLinkController extends ImportExportTextController
{

    /**
     * Constructor of the ImportExportTextLinkController
     *
     * @param uiController user interface controller
     */
    public ImportExportTextLinkController(UIController uiController)
    {
        super(uiController);
    }

    /**
     * This method creates a new Thread that imports the data from the file and
     * updates the cells everytime the file is altered
     *
     * @param filename the name of the text file of the columns or is a regular
     * row
     *
     * @throws Exception if the name is not inserted
     */
    @Override
    public void importFromTextFile(String filename) throws Exception
    {
        //trimming
        filename = filename.trim();

        // validations
        if (filename.isEmpty())
        {
            throw new FileNotFoundException("Please insert a file name");
        }

        if (!new File(filename).exists())
        {
            throw new FileNotFoundException("The text file doesn't exist");
        }
        // validations end

        Cell activeCell = uiController.getActiveCell();

        ImportLinkRunnable importLinkRunnable = new ImportLinkRunnable(uiController, activeCell, filename);

        // add to active links storage
        storeLink(importLinkRunnable);

        new Thread(importLinkRunnable).start();
    }

    /**
     * This method creates a cell listener that exports the data to a file and
     * adds the listener to all the selected cells
     *
     * @param selectedCells the cells selected by the user
     * @param filename the name of the text file
     * @param specialChar the special character to separate columns
     * @param header include cell's header
     *
     * @throws Exception if the name of the file is not inserted or the file
     * already exists
     */
    @Override
    public void exportToTextFile(Cell[][] selectedCells, String filename, String specialChar, boolean header) throws Exception
    {
        //trimming
        specialChar = specialChar.trim();
        filename = filename.trim().endsWith(".txt") ? filename.trim() : filename.trim() + ".txt";

        // validations
        if (specialChar.isEmpty())
        {
            throw new FileNotFoundException("Please insert a valid special character");
        }

        if (filename.isEmpty())
        {
            throw new FileNotFoundException("Please insert a file name");
        }

        if (new File(filename).exists())
        {
            throw new FileAlreadyExistsException("The text file already exists");
        }

        checkCells(specialChar, selectedCells);
        // validations end

        // create a cell listener to export after a modification to the selected cells
        ExportLinkListener listener = new ExportLinkListener(selectedCells, filename, specialChar, header);

        // add to active links storage
        storeLink(listener);

        // force the first export
        listener.exportToTextFile();

        // add the listener to all the selected cells
        for (Cell[] rows : selectedCells)
        {
            for (Cell columns : rows)
            {
                columns.addCellListener(listener);
            }
        }
    }

    /**
     * Adds an active link to storage
     *
     * @param link link to be added
     */
    private void storeLink(Link link)
    {
        LinkStorage.add(link);
    }

    /**
     * Deactivates a link and removes it from storage
     *
     * @param link link to be deactivated
     *
     * @return true if link was removed or false otherwise
     */
    public boolean deactivateLink(Link link)
    {
        return LinkStorage.deactivateLink(link);
    }

    /**
     * This method returns all the active links
     *
     * @return active links
     */
    public Iterable<Link> getActiveLinks()
    {
        return LinkStorage.getAll();
    }
}
