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

    private BigDecimal excDollarToEuro ;
    private BigDecimal excDollarToPound;

    private BigDecimal excEuroToDollar;
    private BigDecimal excEuroToPound;

    private BigDecimal excPoundToDollar;
    private BigDecimal excPoundToEuro;

    private static final String EURO_SYMB = "\u20AC";
    private static final String DOLLAR_SYMB = "$";
    private static final String POUND_SYMB = "\u00A3";

    private static final String EURO_NAME = "euro";
    private static final String DOLLAR_NAME = "dollar";
    private static final String POUND_NAME = "pound";

    public MoneyRate() {
        this.excDollarToEuro = new BigDecimal(0.88775);
        this.excDollarToPound = new BigDecimal(0.77464);
        this.excEuroToDollar = new BigDecimal(1.12632);
        this.excEuroToPound = new BigDecimal(0.87254);
        this.excPoundToDollar = new BigDecimal(1.29072);
        this.excPoundToEuro = new BigDecimal(1.14587);
    }

    /**
     * Returns the value of the exchange dollar to euro.
     *
     * @return value of the exchange dollar to euro.
     */
    public BigDecimal excDollarToEuro() {
        return excDollarToEuro;
    }

    /**
     * Returns the value of the exchange dollar to pound.
     *
     * @return value of the exchange dollar to pound.
     */
    public BigDecimal excDollarToPound() {
        return excDollarToPound;
    }

    /**
     * Returns the value of the exchange euro to dollar.
     *
     * @return value of the exchange euro to dollar.
     */
    public BigDecimal excEuroToDollar() {
        return excEuroToDollar;
    }

    /**
     * Returns the value of the exchange euro to pound.
     *
     * @return value of the exchange euro to pound.
     */
    public BigDecimal excEuroToPound() {
        return excEuroToPound;
    }

    /**
     * Returns the value of the exchange pound to dollar.
     *
     * @return value of the exchange pound to dollar.
     */
    public BigDecimal excPoundToDollar() {
        return excPoundToDollar;
    }

    /**
     * Returns the value of the exchange pound to euro.
     *
     * @return value of the exchange pound to euro.
     */
    public BigDecimal excPoundToEuro() {
        return excPoundToEuro;
    }

    public void setExcDollarToEuro(BigDecimal excDollarToEuro) {
        this.excDollarToEuro = excDollarToEuro;
    }

    public void setExcDollarToPound(BigDecimal excDollarToPound) {
        this.excDollarToPound = excDollarToPound;
    }

    public void setExcEuroToDollar(BigDecimal excEuroToDollar) {
        this.excEuroToDollar = excEuroToDollar;
    }

    public void setExcEuroToPound(BigDecimal excEuroToPound) {
        this.excEuroToPound = excEuroToPound;
    }

    public void setExcPoundToDollar(BigDecimal excPoundToDollar) {
        this.excPoundToDollar = excPoundToDollar;
    }

    public void setExcPoundToEuro(BigDecimal excPoundToEuro) {
        this.excPoundToEuro = excPoundToEuro;
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

    public Value calculateValueWithoutCurrency(String currencyName, String value) {
        if (value.contains(",")) {
            value = value.replace(',', '.');
        }

        BigDecimal result = new BigDecimal(value);
        
        if (currencyName.contains(EURO_NAME) || currencyName.contains(DOLLAR_NAME) || currencyName.contains(POUND_NAME)) {
            return new Value(result);
        }
        return null;
    }
}
