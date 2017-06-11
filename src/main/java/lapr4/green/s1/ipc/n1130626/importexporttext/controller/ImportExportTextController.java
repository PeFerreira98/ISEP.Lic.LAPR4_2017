package lapr4.green.s1.ipc.n1130626.importexporttext.controller;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 * Controller for use case: IPC04.1 Import/Export Data
 *
 * removed the need to indicate the special character to import - Rafael Vieira
 * 06/06/2017
 *
 * @author Pedro Pereira
 */
public class ImportExportTextController
{

    public static final String HEADERS = "@HEADERS@";
    public static final String HEADERS_TOKEN = ";";
    public static final String TOKEN = "@TOKEN@";

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Constructor of the ImportExportTextController
     *
     * @param uiController user interface controller
     */
    public ImportExportTextController(UIController uiController)
    {
        this.uiController = uiController;
    }

    /**
     * Gets a range of cells selected by the user and converts to String.
     *
     * @param cells a matrix of cells
     *
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
     * This method uses the necessary data to import from a text file
     *
     * @param filename the name of the text file
     *
     * @throws Exception if the name is not inserted
     */
    public void importFromTextFile(String filename) throws Exception
    {
        if (filename.isEmpty())
        {
            throw new FileNotFoundException("Please insert a name");
        }

        Cell activeCell = uiController.getActiveCell();
        Spreadsheet activeSpreadsheet = uiController.getActiveSpreadsheet();

        int row = activeCell.getAddress().getRow();
        int column = activeCell.getAddress().getColumn();

        List<String[]> matrix;
        try (Scanner scanner = new Scanner(new File(filename)))
        {
            boolean flag = true;
            matrix = new ArrayList<>();
            String[] line;
            String specialChar = "";
            while (scanner.hasNext())
            {
                if (flag)
                {
                    String tmp = scanner.nextLine();
                    if (tmp.equals(HEADERS))
                    {
                        String[] ref = scanner.nextLine().split(HEADERS_TOKEN);
                        column = Integer.parseInt(ref[0]);
                        row = Integer.parseInt(ref[1]);
                    }
                    else if (tmp.equals(TOKEN))
                    {
                        specialChar = scanner.nextLine().trim();
                        flag = false;
                    }
                }
                else
                {
                    line = scanner.nextLine().split(specialChar);
                    if (line.length > 0)
                    {
                        matrix.add(line);
                    }
                }
            }
        }

        int size;
        int max;
        for (int i = 0; i < matrix.size(); i++)
        {
            size = matrix.get(i).length;
            max = size + column;
            for (int j = column; j < max; j++)
            {
                Cell cell = activeSpreadsheet.getCell(new Address(j, row + i));
                cell.setContent(matrix.get(i)[j - column]);
            }
        }
    }

    /**
     * This method uses the necessary data to export to a text file
     *
     * @param selectedCells the cells selected by the user
     * @param filename the name of the text file
     * @param specialChar the special character to separate columns
     * @param header include the cell's header
     *
     * @throws Exception if the name of the file is not inserted or the file
     * already exists
     */
    public void exportToTextFile(Cell[][] selectedCells, String filename, String specialChar, boolean header) throws Exception
    {
        String token = specialChar.trim();

        if (filename.isEmpty())
        {
            throw new FileNotFoundException("Please insert a name");
        }

        if (!filename.endsWith(".txt"))
        {
            filename = filename + ".txt";
        }

        if (new File(filename).exists())
        {
            throw new FileAlreadyExistsException("The text file already exists");
        }

        try (Formatter fOut = new Formatter(new File(filename)))
        {
            if (header)
            {
                fOut.format(HEADERS + "\n");
                fOut.format(selectedCells[0][0].getAddress().getColumn() + HEADERS_TOKEN
                        + selectedCells[0][0].getAddress().getRow() + HEADERS_TOKEN + "\n");
            }

            fOut.format(TOKEN + "\n" + token + "\n");

            for (Cell[] rows : selectedCells)
            {
                String text = "";
                for (Cell columns : rows)
                {
                    if (columns.getContent().isEmpty())
                    {
                        text += " " + token;
                    }
                    else
                    {
                        text += columns.getContent() + token;
                    }
                }
                text += "\n";
                fOut.format(text);
            }
        }
    }

    /**
     * This method checks if the cells contains the same special character to
     * use on export
     *
     * @param specialChar the special character in cause
     * @param selectedCells the cells selected by the user
     *
     * @throws IllegalArgumentException if the special character chosen is
     * contained in one of the selected cells
     */
    public void checkCells(String specialChar, Cell[][] selectedCells) throws IllegalArgumentException
    {
        String token = specialChar.trim();
        if(token.isEmpty()){
            throw new IllegalArgumentException("Invalid special character, please replace it");
        }
        for (Cell[] row : selectedCells)
        {
            for (Cell cell : row)
            {
                if (cell.getContent() != null)
                {
                    if (cell.getContent().contains(token))
                    {
                        throw new IllegalArgumentException("This cell contains the special character that you selected, please replace it");
                    }
                }
            }
        }
    }
}
