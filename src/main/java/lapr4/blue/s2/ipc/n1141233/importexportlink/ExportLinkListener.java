package lapr4.blue.s2.ipc.n1141233.importexportlink;

import csheets.core.Cell;
import csheets.core.CellListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lapr4.green.s1.ipc.n1130626.importexporttext.controller.ImportExportTextController.HEADERS;
import static lapr4.green.s1.ipc.n1130626.importexporttext.controller.ImportExportTextController.HEADERS_TOKEN;
import static lapr4.green.s1.ipc.n1130626.importexporttext.controller.ImportExportTextController.TOKEN;

/**
 * ExportLinkListener implements CellListener and is responsible for exporting
 * the data to the file everytime the cells' content is changed
 *
 * @author Rafael Vieira
 */
public class ExportLinkListener implements CellListener, Link
{

    private final Cell[][] selectedCells;
    private final String filename;
    private final String specialChar;
    private final boolean header;

    public ExportLinkListener(Cell[][] selectedCells, String filename, String specialChar, boolean header)
    {
        this.selectedCells = selectedCells;
        this.filename = filename.trim();
        this.specialChar = specialChar.trim();
        this.header = header;
    }

    /**
     * This method uses the necessary data to export to a text file
     *
     * @throws Exception if the name of the file is not inserted or the file
     * already exists
     */
    public void exportToTextFile() throws Exception
    {

        if (filename.isEmpty())
        {
            throw new FileNotFoundException("Please insert a name");
        }

        try (Formatter fOut = new Formatter(new File(filename)))
        {
            if (header)
            {
                fOut.format(HEADERS + "\n");
                fOut.format(selectedCells[0][0].getAddress().getColumn() + HEADERS_TOKEN
                        + selectedCells[0][0].getAddress().getRow() + HEADERS_TOKEN + "\n");
            }

            fOut.format(TOKEN + "\n" + specialChar + "\n");

            for (Cell[] rows : selectedCells)
            {
                String text = "";
                for (Cell columns : rows)
                {
                    if (columns.getContent().isEmpty())
                    {
                        text += " " + specialChar;
                    }
                    else
                    {
                        text += columns.getContent() + specialChar;
                    }
                }
                text += "\n";
                fOut.format(text);
            }
        }
    }

    /**
     * returns the cells selected to be exported
     *
     * @return selected cells
     */
    public Cell[][] getSelectedCells()
    {
        return selectedCells;
    }

    // CellListener Methods
    @Override
    public void valueChanged(Cell cell)
    {
        try
        {
            exportToTextFile();
        }
        catch (Exception ex)
        {
            Logger.getLogger(ImportLinkRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contentChanged(Cell cell)
    {
        try
        {
            exportToTextFile();
        }
        catch (Exception ex)
        {
            Logger.getLogger(ImportLinkRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dependentsChanged(Cell cell)
    {
        // do nothing
    }

    @Override
    public void cellCleared(Cell cell)
    {
        try
        {
            exportToTextFile();
        }
        catch (Exception ex)
        {
            Logger.getLogger(ImportLinkRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cellCopied(Cell cell, Cell source)
    {
    }

    // toString
    @Override
    public String toString()
    {
        return "Export Link: " + filename;
    }
}
