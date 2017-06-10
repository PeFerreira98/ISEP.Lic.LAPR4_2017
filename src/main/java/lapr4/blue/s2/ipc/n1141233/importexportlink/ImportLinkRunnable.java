package lapr4.blue.s2.ipc.n1141233.importexportlink;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.green.s1.ipc.n1130626.importexporttext.controller.ImportExportTextController;

/**
 * ExportLinkListener implements CellListener and is responsible for importing
 * the data from the file to the cells everytime the file's content is changed
 *
 * @author Rafael Vieira
 */
public class ImportLinkRunnable implements Runnable
{

    /**
     * The user interface controller
     */
    private final UIController uiController;

    private final Cell originCell;
    private final String filename;

    private long timeStamp;
    private boolean keepGoing;

    public ImportLinkRunnable(UIController uiController, Cell activeCell, String filename)
    {
        this.uiController = uiController;
        this.originCell = activeCell;
        this.filename = filename.trim();
        this.timeStamp = 0;
        this.keepGoing = true;
    }

    /**
     * This method uses the necessary data to import from a text file
     *
     * @throws Exception if the name is not inserted
     */
    public synchronized void importFromTextFile() throws Exception
    {
        if (filename.isEmpty())
        {
            throw new Exception("Please insert a name");
        }

        Spreadsheet activeSpreadsheet = uiController.getActiveSpreadsheet();

        int row = originCell.getAddress().getRow();
        int column = originCell.getAddress().getColumn();

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
                    if (tmp.equals(ImportExportTextController.HEADERS))
                    {
                        String ref[] = scanner.nextLine().split(ImportExportTextController.HEADERS_TOKEN);
                        column = Integer.parseInt(ref[0]);
                        row = Integer.parseInt(ref[1]);
                    }
                    else if (tmp.equals(ImportExportTextController.TOKEN))
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
     * checks if the file was modified and updates de last modification
     * timestamp if necessary
     *
     * @param filename the file's name
     *
     * @return true if file was modified since last time or false otherwise
     */
    private synchronized boolean isModified(String filename)
    {
        File f = new File(filename);
        if (f.lastModified() != timeStamp)
        {
            timeStamp = f.lastModified();
            return true;
        }
        return false;
    }

    /**
     * stops the the run method when called
     */
    public synchronized void stop()
    {
        keepGoing = false;
    }

    @Override
    public synchronized void run()
    {
        while (keepGoing)
        {
            try
            {
                try
                {
                    if (isModified(filename))
                    {
                        importFromTextFile();
                    }
                }
                catch (Exception ex)
                {
                    Logger.getLogger(ImportLinkRunnable.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(ImportLinkRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
