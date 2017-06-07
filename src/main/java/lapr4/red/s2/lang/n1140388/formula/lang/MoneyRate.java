/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.lang;

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.ULocale;
import csheets.core.Value;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

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

    private static final String EURO_SYMB = "\u20AC";
    private static final String DOLLAR_SYMB = "$";
    private static final String POUND_SYMB = "\u00A3";

    private static final String EURO_NAME = "euro";
    private static final String DOLLAR_NAME = "dollar";
    private static final String POUND_NAME = "pound";

    public MoneyRate() {
    }

    /**
     * Returns the value of the exchange dollar to euro.
     *
     * @return value of the exchange dollar to euro.
     */
    public static BigDecimal excDollarToEuro() {
        return excDollarToEuro;
    }

    /**
     * Returns the value of the exchange dollar to pound.
     *
     * @return value of the exchange dollar to pound.
     */
    public static BigDecimal excDollarToPound() {
        return excDollarToPound;
    }

    /**
     * Returns the value of the exchange euro to dollar.
     *
     * @return value of the exchange euro to dollar.
     */
    public static BigDecimal excEuroToDollar() {
        return excEuroToDollar;
    }

    /**
     * Returns the value of the exchange euro to pound.
     *
     * @return value of the exchange euro to pound.
     */
    public static BigDecimal excEuroToPound() {
        return excEuroToPound;
    }

    /**
     * Returns the value of the exchange pound to dollar.
     *
     * @return value of the exchange pound to dollar.
     */
    public static BigDecimal excPoundToDollar() {
        return excPoundToDollar;
    }

    /**
     * Returns the value of the exchange pound to euro.
     *
     * @return value of the exchange pound to euro.
     */
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
