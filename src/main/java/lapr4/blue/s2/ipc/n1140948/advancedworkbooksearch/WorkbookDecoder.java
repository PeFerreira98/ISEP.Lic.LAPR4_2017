package lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Tiago Silvestre
 */
public class WorkbookDecoder
{

    private static final int MATRIX_SIZE = 5;

    private final Workbook workbook;
    private final int maxCellVertical[];
    private final int maxCellHorizontal[];
    private final int minCellVertical[];
    private final int minCellHorizontal[];
    private final int sheets;
    
    private Cell cellList[][][];

    /**
     * Constructor
     *
     * @param previewWorkbook Workbook
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public WorkbookDecoder(Workbook previewWorkbook) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        this.workbook = previewWorkbook;
        this.sheets = workbook.getSpreadsheetCount();
        this.maxCellHorizontal = new int[sheets];
        this.maxCellVertical = new int[sheets];
        this.minCellVertical = new int[sheets];
        this.minCellHorizontal = new int[sheets];
        descodificador();
    }

    /**
     * This method has the responsibility to make a sample which should contain
     * the paper sheets and each sheet content of the first cell with a value.
     */
    private void descodificador()
    {

        int q = 0, w = 0;
        getFistCellNonEmpty();

        cellList = new Cell[MATRIX_SIZE][MATRIX_SIZE][sheets];

        for (int p = 0; p < sheets; p++)
        {
            Spreadsheet sp = workbook.getSpreadsheet(p);
            for (int i = minCellHorizontal[p]; i < maxCellHorizontal[p]; i++)
            {
                for (int j = minCellVertical[p]; j < maxCellVertical[p]; j++)
                {
                    Cell c = sp.getCell(j, i);
                    cellList[q][w][p] = c;
                    w++;
                }
                q++;
                w = 0;
            }
            q = 0;
            w = 0;
        }

    }

    /**
     * Total of sheet's workbook
     *
     * @return num
     */
    public int numSheet()
    {
        return this.sheets;
    }

    public Cell[][][] CellList()
    {
        return this.cellList;
    }

    public Workbook Workbook()
    {
        return this.workbook;
    }

    public int[] maxCellHorizontal()
    {
        return this.maxCellHorizontal;
    }

    public int[] maxCellVertical()
    {
        return this.maxCellVertical;
    }

    public int[] minCellHorizontal()
    {
        return minCellHorizontal;
    }

    public int[] minCellVertical()
    {
        return this.minCellVertical;
    }

    /**
     * This method research first cell != null and do a matrix 5x5 with first
     * cell value (x,y) with reference.
     *
     * @return true if exist cell != null
     */
    private boolean getFistCellNonEmpty()
    {
        int flag[] =
        {
            0, 0, 0
        };
        for (int p = 0; p < sheets; p++)
        {
            Spreadsheet sp = workbook.getSpreadsheet(p);
            for (int i = 0; i < 128; i++)
            {
                for (int j = 0; j < 52; j++)
                {
                    Cell c = sp.getCell(j, i);
                    if (!c.getContent().equals(""))
                    {
                        this.minCellVertical[p] = j;
                        this.minCellHorizontal[p] = i;
                        this.maxCellHorizontal[p] = i + 5;
                        this.maxCellVertical[p] = j + 5;
                        flag[p] = 1;
                        break;
                    }
                    if (flag[p] == 1)
                    {
                        break;
                    }
                }
                if (flag[p] == 1)
                {
                    break;
                }
            }
        }
        for (int i = 0; i < sheets; i++)
        {
            if (flag[i] == 1)
            {
                return true;
            }
        }
        return false;
    }

    public static int matrixSize()
    {
        return MATRIX_SIZE;
    }
}
