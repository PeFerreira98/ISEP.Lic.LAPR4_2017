/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class ArrayStorageTest {
    
    private CleanSheets app;
    
    
    public ArrayStorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of retrieveArrayItem method, of class ArrayStorage.
     */
    @Test
    public void testRetrieveArrayItem() {
        System.out.println("retrieveArrayItem");
        
        String content = "=(@a[1]:=2)";
        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        try{
            cellA1.setContent(content);
        }
        catch(FormulaCompilationException ex){
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("");
            System.out.println("ArrayItem creation test ERROR: FormulaCompilationException error GRAMATIC PROBABLY BROKEN");
            System.out.println("Formula used: " + content);
            fail();
        }
        String name = "@a[1]";
        ArrayStorage instance = app.getWorkbooks()[0].retrieveArrayStorage();
        
        ArrayItem result = instance.retrieveArrayItem(name);
        assertTrue(result.getName().equals(name));
        
    }

    /**
     * Test of listContainerAsDTO method, of class ArrayStorage.
     */
    @Test
    public void testListContainerAsDTO() {
        System.out.println("listContainerAsDTO");
        
         String content = "=(@a[1]:=2)";
        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        try{
            cellA1.setContent(content);
        }
        catch(FormulaCompilationException ex){
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("");
            System.out.println("ArrayItem creation test ERROR: FormulaCompilationException error GRAMATIC PROBABLY BROKEN");
            System.out.println("Formula used: " + content);
            fail();
        }
        String name = "@a[1]";
        ArrayStorage instance = app.getWorkbooks()[0].retrieveArrayStorage();
        
        List<ArrayItemDTO> expResult = null;
        List<ArrayItemDTO> result = instance.listContainerAsDTO();
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).name().equals(name));
        
    }

    /**
     * Test of editArrayItem method, of class ArrayStorage.
     */
    @Test
    public void testEditArrayItem() {
        System.out.println("editArrayItem");
        
        String content = "=(@a[1]:=2)";
        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        try{
            cellA1.setContent(content);
        }
        catch(FormulaCompilationException ex){
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");
            System.out.println("");
            System.out.println("ArrayItem creation test ERROR: FormulaCompilationException error GRAMATIC PROBABLY BROKEN");
            System.out.println("Formula used: " + content);
            fail();
        }
        String name = "@a[1]";
        ArrayStorage instance = app.getWorkbooks()[0].retrieveArrayStorage();
        
        ArrayItem result = instance.retrieveArrayItem(name);
        
        ArrayItemDTO dto = result.toDTO();
        String inicial = "2";
        //System.out.println(dto.value());
        assertTrue(dto.value().equals(inicial));
        
        instance.editArrayItem(dto, Value.parseValue("4"));
        
        String tfinal = "4";
        result = instance.retrieveArrayItem(name);
        dto = result.toDTO();
        assertTrue(dto.value().equals(tfinal));
        
    }
    
}
