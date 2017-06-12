/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.io.FileNotFoundException;
import java.io.IOException;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileDTO;
import lapr4.green.s1.ipc.n1970581.findworkbook.ui.SearchWorkbookPanel;

/**
 *
 * @author Tiago Silvestre
 */
public class DescodificadorWorkbook {
    
    private SearchWorkbookPanel searchWorkbook;
    private Workbook workbook;
    private FileDTO file;

    private int maxCellVertical[];
    private int maxCellHorizontal[];
    private int minCellVertical[];
    private int minCellHorizontal[];
    private int numFolhas;
    private Cell cellList[][][];
    private static final int matrixSize = 5;

    /**
     * private constructor
     */
    private DescodificadorWorkbook() {
    }

    /**
     * Constructor
     *
     * @param openFile Workbook
     * @param file File
     * @param search WorkbookPanel
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public DescodificadorWorkbook(Workbook openFile, FileDTO file, SearchWorkbookPanel search) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.searchWorkbook = search;
        this.file = file;
        this.workbook = openFile;
        this.numFolhas = workbook.getSpreadsheetCount();
        this.maxCellHorizontal = new int[numFolhas];
        this.maxCellVertical = new int[numFolhas];
        this.minCellVertical = new int[numFolhas];
        this.minCellHorizontal = new int[numFolhas];
    }

    /**
     * This method has the responsibility to make a sample which should contain
     * the paper sheets and each sheet content of the first cell with a value.
     */
    public void descodificador() {

        int q = 0, w = 0;
        getFistCellNonEmpty();

        cellList = new Cell[matrixSize][matrixSize][numFolhas];

        for (int p = 0; p < numFolhas; p++) {
            Spreadsheet sp = workbook.getSpreadsheet(p);
            for (int i = minCellHorizontal[p]; i < maxCellHorizontal[p]; i++) {
                for (int j = minCellVertical[p]; j < maxCellVertical[p]; j++) {
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
    public int numSheet() {
        return this.numFolhas;
    }

    public Cell[][][] CellList() {
        return this.cellList;
    }

    public Workbook Workbook() {
        return this.workbook;
    }

    public FileDTO File() {
        return this.file;
    }

    public int[] maxCellHorizontal() {
        return this.maxCellHorizontal;
    }

    public int[] maxCellVertical() {
        return this.maxCellVertical;
    }

    public int[] minCellHorizontal() {
        return minCellHorizontal;
    }

    public int[] minCellVertical() {
        return this.minCellVertical;
    }

    /**
     * This method research first cell != null and do a matrix 5x5 with first
     * cell value (x,y) with reference.
     *
     * @return true if exist cell != null
     */
    private boolean getFistCellNonEmpty() {
        int flag[] = {0, 0, 0};
        for (int p = 0; p < numFolhas; p++) {
            Spreadsheet sp = workbook.getSpreadsheet(p);
            for (int i = 0; i < 128; i++) {
                for (int j = 0; j < 52; j++) {
                    Cell c = sp.getCell(j, i);
                    if (!c.getContent().equals("")) {
                        this.minCellVertical[p] = j;
                        this.minCellHorizontal[p] = i;
                        this.maxCellHorizontal[p] = i + 5;
                        this.maxCellVertical[p] = j + 5;
                        flag[p] = 1;
                        break;
                    }
                    if (flag[p] == 1) {
                        break;
                    }
                }
                if (flag[p] == 1) {
                    break;
                }
            }
        }
        for (int i = 0; i < numFolhas; i++) {
            if (flag[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static int matrixSize() {
        return matrixSize;
    }
}
