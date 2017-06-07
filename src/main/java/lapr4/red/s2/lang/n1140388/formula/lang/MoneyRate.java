/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.lang;

import csheets.core.Value;
import java.math.BigDecimal;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class MoneyRate {

    private static BigDecimal excDollarToEuro = new BigDecimal(0.88775);
    private static BigDecimal excDollarToPound = new BigDecimal(0.77464);

    private static BigDecimal excEuroToDollar = new BigDecimal(1.12632);
    private static BigDecimal excEuroToPound = new BigDecimal(0.87254);

    private static BigDecimal excPoundToDollar = new BigDecimal(1.29072);
    private static BigDecimal excPoundToEuro = new BigDecimal(1.14587);

    private static final String EURO_SYMB = "€";
    private static final String DOLLAR_SYMB = "$";
    private static final String POUND_SYMB = "£";

    private static final String EURO_NAME = "euro";
    private static final String DOLLAR_NAME = "dollar";
    private static final String POUND_NAME = "pound";

    public MoneyRate() {
    }

    public static BigDecimal excDollarToEuro() {
        return excDollarToEuro;
    }

    public static BigDecimal excDollarToPound() {
        return excDollarToPound;
    }

    public static BigDecimal excEuroToDollar() {
        return excEuroToDollar;
    }

    public static BigDecimal excEuroToPound() {
        return excEuroToPound;
    }

    public static BigDecimal excPoundToDollar() {
        return excPoundToDollar;
    }

    public static BigDecimal excPoundToEuro() {
        return excPoundToEuro;
    }

    public Value calculateValue(String currencyName, String value, String currencySymbol) {
        if (value.contains(",")) {
            value = value.replace(',', '.');
        }
        
        BigDecimal result = new BigDecimal(value);

        if (currencyName.contains(EURO_NAME)) {
            if (currencySymbol.contains(EURO_SYMB)) {
                return new Value(result);
            }
            
            if (currencySymbol.contains(DOLLAR_SYMB)) {
                return new Value(result.multiply(excDollarToEuro()));
            }
            
            if (currencySymbol.contains(POUND_SYMB)) {
                return new Value(result.multiply(excPoundToEuro()));
            }
            
        } else if (currencyName.contains(DOLLAR_NAME)) {

            if (currencySymbol.contains(EURO_SYMB)) {
                return new Value(result.multiply(excEuroToDollar()));
            }
            
            if (currencySymbol.contains(DOLLAR_SYMB)) {
                return new Value(result);
            }
            
            if (currencySymbol.contains(POUND_SYMB)) {
                return new Value(result.multiply(excPoundToDollar()));
            }
            
        } else if (currencyName.contains(POUND_NAME)) {
            
            if (currencySymbol.contains(EURO_SYMB)) {
                return new Value(result.multiply(excEuroToPound()));
            }
            
            if (currencySymbol.contains(DOLLAR_SYMB)) {
                return new Value(result.multiply(excDollarToPound()));
            }
            
            if (currencySymbol.contains(POUND_SYMB)) {
                return new Value(result);
            }
        }

        return null;
    }
}
