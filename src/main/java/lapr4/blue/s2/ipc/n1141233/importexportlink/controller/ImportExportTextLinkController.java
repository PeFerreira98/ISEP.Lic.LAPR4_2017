/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * This method uses the necessary data to import from a text file
     *
     * @param filename the name of the text file of the columns or is a regular
     * row
     * @throws Exception if the name is not inserted
     */
    public void importFromTextFile(String filename) throws Exception
    {
        if (filename.isEmpty())
        {
            throw new Exception("Please insert a name");
        }

        if (new File(filename).exists())
        {
            throw new Exception("The text file already exists");
        }

        Cell activeCell = uiController.getActiveCell();
//        Spreadsheet activeSpreadsheet = uiController.getActiveSpreadsheet();

        ImportLinkRunnable importLinkRunnable = new ImportLinkRunnable(uiController, activeCell, filename);

        new Thread(importLinkRunnable).start();
//        int row;
//        int column;
//
//        if (containsHeader)
//        {
//            row = 0;
//            column = 0;
//        }
//        else
//        {
//            row = activeCell.getAddress().getRow();
//            column = activeCell.getAddress().getColumn();
//        }
//
//        Scanner scanner = new Scanner(new File(filename));
//        boolean flag = true;
//
//        List<String[]> matrix = new ArrayList<>();
//        String[] line;
//        String specialChar = "";
//
//        while (scanner.hasNext())
//        {
//            if (flag)
//            {
//                specialChar = scanner.nextLine().trim();
//                flag = false;
//            }
//            else
//            {
//                line = scanner.nextLine().split(specialChar);
//                if (line.length > 0)
//                {
//                    matrix.add(line);
//                }
//            }
//        }
//        scanner.close();
//
//        int size;
//        int max;
//        for (int i = 0; i < matrix.size(); i++)
//        {
//            size = matrix.get(i).length;
//            max = size + column;
//            for (int j = column; j < max; j++)
//            {
//                Cell cell = activeSpreadsheet.getCell(new Address(j, row + i));
//                cell.setContent(matrix.get(i)[j - column]);
//            }
//        }
    }

    /**
     * This method uses the necessary data to export to a text file
     *
     * @param selectedCells the cells selected by the user
     * @param filename the name of the text file
     * @param specialChar the special character to separate columns
     * @throws Exception if the name of the file is not inserted or the file
     * already exists
     */
    public void exportToTextFile(Cell[][] selectedCells, String filename, String specialChar) throws Exception
    {
        specialChar = specialChar.trim();

        if (filename.isEmpty())
        {
            throw new Exception("Please insert a name");
        }

        if (!filename.endsWith(".txt"))
        {
            filename = filename + ".txt";
        }

        if (new File(filename).exists())
        {
            throw new Exception("The text file already exists");
        }

        CellListener listener = new ExportLinkListener(selectedCells, filename, specialChar);

        for (Cell[] rows : selectedCells)
        {
            for (Cell columns : rows)
            {
                columns.addCellListener(listener);
            }
        }

//        Formatter fOut = new Formatter(new File(filename));
//
//        fOut.format(specialChar + "\n");
//
//        for (Cell[] rows : selectedCells)
//        {
//            String text = "";
//            for (Cell columns : rows)
//            {
//                if (columns.getContent().isEmpty())
//                {
//                    text += " " + specialChar;
//                }
//                else
//                {
//                    text += columns.getContent() + specialChar;
//                }
//            }
//            text += "\n";
//            fOut.format(text);
//        }
//        fOut.close();
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
                        throw new Exception("This cell contains the special character that you selected, please replace it");
                    }
                }
            }
        }
    }
}
