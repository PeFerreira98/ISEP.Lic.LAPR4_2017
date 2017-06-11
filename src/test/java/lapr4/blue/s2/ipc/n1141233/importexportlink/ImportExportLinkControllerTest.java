package lapr4.blue.s2.ipc.n1141233.importexportlink;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import lapr4.blue.s2.ipc.n1141233.importexportlink.controller.ImportExportTextLinkController;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rafael Vieira
 */
public class ImportExportLinkControllerTest
{

    private CleanSheets app;
    private ImportExportTextLinkController controller;
    private UIController uiCtrl;

    @Before
    public void setUp()
    {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();
        uiCtrl = new UIController(app);

        controller = new ImportExportTextLinkController(uiCtrl);

    }

    /**
     * Test controller check cells
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    public void testControllerCheckCells() throws FormulaCompilationException
    {
        String specialChar = ";";

        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("biscoito");

        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cellA1;

        // #1 test
        // test expression with not enough arguments
        try
        {
            controller.checkCells(specialChar, cells);
        }
        catch (IllegalArgumentException e)
        {
            fail("something went wrong...");
        }
        System.out.println("success");
    }

    /**
     * Test controller check cells with invalid Special character
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    public void testControllerInvalidSpecialCharacter() throws FormulaCompilationException
    {
        String specialChar = "o";

        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("biscoito");

        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cellA1;

        // #2 test
        // test expression with not enough arguments
        try
        {
            controller.checkCells(specialChar, cells);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("success");
        }
    }

    /**
     * Test controller check cells with empty Special character
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    public void testControllerEmptySpecialCharacter() throws FormulaCompilationException
    {
        String specialChar = " ";

        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("biscoito");

        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cellA1;

        // #2 test
        // test expression with not enough arguments
        try
        {
            controller.checkCells(specialChar, cells);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("success");
        }
    }
    
    /**
     * Test controller import from non existing file
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    public void testControllerImportFromNonexistingFile() throws FormulaCompilationException, Exception
    {
        String filename = "nonExistingDirectory/fileThatHopefullyDoesNotExist.txt";

        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("biscoito");

        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cellA1;

        // #2 test
        // test expression with not enough arguments
        try
        {
            controller.importFromTextFile(filename);
            fail();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("success");
        }
    }
    
    /**
     * Test controller import from empty filename
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    public void testControllerImportFromEmptyFilename() throws FormulaCompilationException, Exception
    {
        String filename = " ";

        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("biscoito");

        Cell[][] cells = new Cell[1][1];
        cells[0][0] = cellA1;

        // #2 test
        // test expression with not enough arguments
        try
        {
            controller.importFromTextFile(filename);
            fail();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("success");
        }
    }
}
