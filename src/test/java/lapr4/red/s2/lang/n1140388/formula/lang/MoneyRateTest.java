/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.lang;

import csheets.core.Value;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class MoneyRateTest {

    public MoneyRateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of excDollarToEuro method, of class MoneyRate.
     */
    @Test
    public void testExcDollarToEuro() {
        System.out.println("excDollarToEuro");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(0.88775);
        BigDecimal result = instance.excDollarToEuro();
        assertEquals(expResult, result);
    }

    /**
     * Test of excDollarToPound method, of class MoneyRate.
     */
    @Test
    public void testExcDollarToPound() {
        System.out.println("excDollarToPound");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(0.77464);
        BigDecimal result = instance.excDollarToPound();
        assertEquals(expResult, result);
    }

    /**
     * Test of excEuroToDollar method, of class MoneyRate.
     */
    @Test
    public void testExcEuroToDollar() {
        System.out.println("excEuroToDollar");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(1.12632);
        BigDecimal result = instance.excEuroToDollar();
        assertEquals(expResult, result);
    }

    /**
     * Test of excEuroToPound method, of class MoneyRate.
     */
    @Test
    public void testExcEuroToPound() {
        System.out.println("excEuroToPound");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(0.87254);
        BigDecimal result = instance.excEuroToPound();
        assertEquals(expResult, result);
    }

    /**
     * Test of excPoundToDollar method, of class MoneyRate.
     */
    @Test
    public void testExcPoundToDollar() {
        System.out.println("excPoundToDollar");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(1.29072);
        BigDecimal result = instance.excPoundToDollar();
        assertEquals(expResult, result);
    }

    /**
     * Test of excPoundToEuro method, of class MoneyRate.
     */
    @Test
    public void testExcPoundToEuro() {
        System.out.println("excPoundToEuro");
        MoneyRate instance = new MoneyRate();
        BigDecimal expResult = new BigDecimal(1.14587);
        BigDecimal result = instance.excPoundToEuro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcDollarToEuro method, of class MoneyRate.
     */
    @Test
    public void testSetExcDollarToEuro() {
        System.out.println("setExcDollarToEuro");
        BigDecimal excDollarToEuro = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcDollarToEuro(excDollarToEuro);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excDollarToEuro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcDollarToPound method, of class MoneyRate.
     */
    @Test
    public void testSetExcDollarToPound() {
        System.out.println("setExcDollarToPound");
        BigDecimal excDollarToPound = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcDollarToPound(excDollarToPound);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excDollarToPound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcEuroToDollar method, of class MoneyRate.
     */
    @Test
    public void testSetExcEuroToDollar() {
        System.out.println("setExcEuroToDollar");
        BigDecimal excEuroToDollar = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcEuroToDollar(excEuroToDollar);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excEuroToDollar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcEuroToPound method, of class MoneyRate.
     */
    @Test
    public void testSetExcEuroToPound() {
        System.out.println("setExcEuroToPound");
        BigDecimal excEuroToPound = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcEuroToPound(excEuroToPound);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excEuroToPound();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcPoundToDollar method, of class MoneyRate.
     */
    @Test
    public void testSetExcPoundToDollar() {
        System.out.println("setExcPoundToDollar");
        BigDecimal excPoundToDollar = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcPoundToDollar(excPoundToDollar);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excPoundToDollar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExcPoundToEuro method, of class MoneyRate.
     */
    @Test
    public void testSetExcPoundToEuro() {
        System.out.println("setExcPoundToEuro");
        BigDecimal excPoundToEuro = new BigDecimal(2);
        MoneyRate instance = new MoneyRate();
        instance.setExcPoundToEuro(excPoundToEuro);
        BigDecimal expResult = new BigDecimal(2);
        BigDecimal result = instance.excPoundToEuro();
        assertEquals(expResult, result);
    }
}
