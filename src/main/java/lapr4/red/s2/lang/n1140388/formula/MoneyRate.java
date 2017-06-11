/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula;

import csheets.core.Value;
import java.math.BigDecimal;

/**
 * This class was created to save the exchanges of money.
 *
 * @author Alexandra Ferreira 1140388
 */
public class MoneyRate {

    private BigDecimal excDollarToEuro;
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

    /**
     * Creates a new Money Rate.
     */
    public MoneyRate() {
        this.excDollarToEuro = BigDecimal.valueOf(0.88775);
        this.excDollarToPound = BigDecimal.valueOf(0.77464);
        this.excEuroToDollar = BigDecimal.valueOf(1.12632);
        this.excEuroToPound = BigDecimal.valueOf(0.87254);
        this.excPoundToDollar = BigDecimal.valueOf(1.29072);
        this.excPoundToEuro = BigDecimal.valueOf(1.14587);
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

    /**
     * Modify the value of the exchange dollar to euro.
     *
     * @param excDollarToEuro the new value of exchange
     */
    public void setExcDollarToEuro(BigDecimal excDollarToEuro) {
        this.excDollarToEuro = excDollarToEuro;
    }

    /**
     * Modify the value of the exchange dollar to pound.
     *
     * @param excDollarToPound the new value of exchange
     */
    public void setExcDollarToPound(BigDecimal excDollarToPound) {
        this.excDollarToPound = excDollarToPound;
    }

    /**
     * Modify the value of the exchange euro to dollar.
     *
     * @param excEuroToDollar the new value of exchange
     */
    public void setExcEuroToDollar(BigDecimal excEuroToDollar) {
        this.excEuroToDollar = excEuroToDollar;
    }

    /**
     * Modify the value of the exchange euro to pound.
     *
     * @param excEuroToPound the new value of exchange
     */
    public void setExcEuroToPound(BigDecimal excEuroToPound) {
        this.excEuroToPound = excEuroToPound;
    }

    /**
     * Modify the value of the exchange pound to dollar.
     *
     * @param excPoundToDollar the new value of exchange
     */
    public void setExcPoundToDollar(BigDecimal excPoundToDollar) {
        this.excPoundToDollar = excPoundToDollar;
    }

    /**
     * Modify the value of the exchange pound to euro.
     *
     * @param excPoundToEuro the new value of exchange
     */
    public void setExcPoundToEuro(BigDecimal excPoundToEuro) {
        this.excPoundToEuro = excPoundToEuro;
    }

    /**
     * Converts the given expression to a value.
     *
     * @param currencyName the currency that we want the final result
     * @param value the value of the operand
     * @param currencySymbol the currency of the operand
     * @return the value of the exchange
     */
    public Value calculateValue(String currencyName, String value, String currencySymbol) {
        BigDecimal result = new BigDecimal(value.replace(',', '.'));

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

    /**
     * Converts the given expression to a value.
     *
     * @param currencyName the currency that we want the final result
     * @param value the value of the operand
     * @return the value of the exchange
     */
    public Value calculateValueWithoutCurrency(String currencyName, String value) {
        BigDecimal result = new BigDecimal(value.replace(',', '.'));

        if (currencyName.contains(EURO_NAME) || currencyName.contains(DOLLAR_NAME) || currencyName.contains(POUND_NAME)) {
            return new Value(result);
        }
        return null;
    }
}
