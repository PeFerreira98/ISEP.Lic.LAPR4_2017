package lapr4.blue.s1.lang.n1141233.formula;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rafael Vieira
 */
public class FormulaLoopTest
{

    CleanSheets app;

    @Before
    public void setUp()
    {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();

    }

    /**
     * Test For operator "=for{(A1:=15);A1<10;1+2;2<1;a1>10}"
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    public void testFor() throws FormulaCompilationException, IllegalValueTypeException
    {
        String content = "=for{(A1:=15);A1<10;1+2;2<1;a1>10}";
        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));

        // #1 test
        cellA1.setContent("5");

        Cell cellA2 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 1));

        cellA2.setContent(content);

        assertTrue(cellA1.getValue().toDouble() == 15.0);
        assertTrue(cellA2.getValue().toBoolean() == true);
    }

    @After
    public void cleanUp()
    {

    }
}
