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

/**
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
        this.filename = filename;
        this.timeStamp = 0;
        this.keepGoing = true;
    }

    /**
     * This method uses the necessary data to import from a text file
     *
     * @throws Exception if the name is not inserted
     */
    public void importFromTextFile() throws Exception
    {
        if (filename.isEmpty())
        {
            throw new Exception("Please insert a name");
        }

        Spreadsheet activeSpreadsheet = uiController.getActiveSpreadsheet();

        int row = originCell.getAddress().getRow();
        int column = originCell.getAddress().getColumn();

        Scanner scanner = new Scanner(new File(filename));
        boolean flag = true;

        List<String[]> matrix = new ArrayList<>();
        String[] line;
        String specialChar = "";

        while (scanner.hasNext())
        {
            if (flag)
            {
                specialChar = scanner.nextLine().trim();
                flag = false;
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
        scanner.close();

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
     * @return true if file was modified since last time or false otherwise
     */
    private boolean isModified(String filename)
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
    public void stop()
    {
        keepGoing = false;
    }

    @Override
    public void run()
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
