package lapr4.red.s2.lang.n1131106;

import csheets.core.Value;
import csheets.core.Workbook;
import lapr4.red.s2.lang.n1131106.globalvariables.domain.GlobalVariable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;

public class WorkbookTest {

    GlobalVariable globV = new GlobalVariable("@count", new Value(30), null);
    GlobalVariable glob = new GlobalVariable("@glob", new Value(24), null);

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of createVariable method, of class Workbook.
     */
    @Test
    public void testCreateVariable() {
        System.out.println("createVariable");
        Workbook w = new Workbook();
        int inicialResult = w.getList().size();
        w.createVariable("@count", new Value(5), null);
        int result = w.getList().size();
        assertTrue("", inicialResult < result);
    }

    /**
     * Test of addVariable method, of class Workbook.
     */
    @Test
    public void testAddVariable() {
        System.out.println("addVariable");
        Workbook w = new Workbook();
        int inicialResult = w.getList().size();
        w.addVariable(glob);
        int result = w.getList().size();
        assertTrue("", inicialResult < result);
    }

    /**
     * Test of findVariable method, of class Workbook.
     */
    @Test
    public void testFindVariable() {
        System.out.println("findVariable");
        String expResult = globV.getName();
        Workbook w = new Workbook();
        GlobalVariable tt = w.findVariable(globV.getSpreadsheet(), globV.getName());
        String result = tt.getName();
        assertEquals(expResult, result);
    }
}
