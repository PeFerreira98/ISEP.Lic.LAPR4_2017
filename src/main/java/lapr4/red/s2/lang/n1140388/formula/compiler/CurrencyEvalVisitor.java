/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Literal;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import lapr4.red.s2.lang.n1140388.formula.lang.MoneyRate;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CurrencyEvalVisitor extends CurrencyBaseVisitor<Expression> {

    int numberOfErros;
    private final StringBuilder errorBuffer;
    private String currencyName;

    /**
     * Creates the currency eval visitor.
     */
    public CurrencyEvalVisitor() {
        numberOfErros = 0;
        errorBuffer = new StringBuilder();
    }

    /**
     * Return the number of errors.
     * 
     * @return the number of errors.
     */
    public int getNumberOfErrors() {
        return numberOfErros;
    }

    /**
     * Return the message of the error.
     * 
     * @return the message of the error.
     */
    public String getErrorsMessage() {
        return errorBuffer.toString();
    }

    /**
     * Visit the expression.
     * 
     * @param ctx the expression
     * @return the value of the expression
     */
    @Override
    public Expression visitExpression(CurrencyParser.ExpressionContext ctx) {
        //visitCurrenciesName
        visit(ctx.getChild(1));

        //visitCurrenciesCount
        return visit(ctx.getChild(3));
    }

    /**
     * Return the currencie name.
     * 
     * @param ctx the expression
     * @return the currencie name
     */
    @Override
    public Expression visitCurrenciesName(CurrencyParser.CurrenciesNameContext ctx) {
        currencyName = ctx.getText();

        return null;
    }

    /**
     * Return the count of the expression.
     * 
     * @param ctx the expression
     * @return the value of the expression
     */
    @Override
    public Expression visitCurrenciesCount(CurrencyParser.CurrenciesCountContext ctx) {
        try {
            if (ctx.getChildCount() == 3) {
                // Convert binary operation
                BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                if (operator.equals(Language.getInstance().getBinaryOperator("+"))
                        || operator.equals(Language.getInstance().getBinaryOperator("-"))) {

                    return new BinaryOperation(visit(ctx.getChild(0)),
                            operator,
                            visit(ctx.getChild(2))
                    );
                }

                if (operator.equals(Language.getInstance().getBinaryOperator("*"))
                        || operator.equals(Language.getInstance().getBinaryOperator("/"))) {

                    MoneyRate mr = new MoneyRate();

                    if (ctx.getChild(0).getChildCount() == 0) {
                        return new BinaryOperation(new Literal(mr.calculateValueWithoutCurrency(currencyName, ctx.getChild(0).getText())),
                                operator,
                                visit(ctx.getChild(2)));
                    } else {
                        return new BinaryOperation(visit(ctx.getChild(0)),
                                operator,
                                new Literal(mr.calculateValueWithoutCurrency(currencyName, ctx.getChild(2).getText())));
                    }

                }
            }
        } catch (FormulaCompilationException ex) {
            addVisitError(ex.getMessage());
        }

        return visitChildren(ctx);
    }

    /**
     * Return the exchange rate of money.
     * 
     * @param ctx the expression
     * @return the exchange
     */
    @Override
    public Expression visitMoney(CurrencyParser.MoneyContext ctx) {

        String number = ctx.getChild(0).getText();
        MoneyRate mr = new MoneyRate();
        String currency = ctx.getChild(1).getText();

        return new Literal(mr.calculateValue(currencyName, number, currency));
    }

    /**
     * Return the currency.
     * 
     * @param ctx the expression
     * @return the currency
     */
    @Override
    public Expression visitCurrenciesSymb(CurrencyParser.CurrenciesSymbContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Add a visit error.
     * 
     * @param msg the message of error
     */
    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
