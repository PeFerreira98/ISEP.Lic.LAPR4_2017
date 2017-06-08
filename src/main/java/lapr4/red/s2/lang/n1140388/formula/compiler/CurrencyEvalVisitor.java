/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Literal;
import csheets.core.formula.UnaryOperation;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.CellReference;
import java.math.BigDecimal;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import lapr4.red.s2.lang.n1140388.formula.lang.MoneyRate;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CurrencyEvalVisitor extends CurrencyBaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;
    private String currencyName;

    public CurrencyEvalVisitor(Cell cell) {
        this.cell = cell;
        numberOfErros = 0;
        errorBuffer = new StringBuilder();
    }

    public int getNumberOfErrors() {
        return numberOfErros;
    }

    public String getErrorsMessage() {
        return errorBuffer.toString();
    }

    @Override
    public Expression visitExpression(CurrencyParser.ExpressionContext ctx) {
        //visitCurrenciesName
        visit(ctx.getChild(1));

        //visitCurrenciesCount
        return visit(ctx.getChild(3));
    }

    @Override
    public Expression visitCurrenciesName(CurrencyParser.CurrenciesNameContext ctx) {
        currencyName = ctx.getText();

        return null;
    }

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

                    if(ctx.getChild(0).getChildCount() == 0){
                        return new BinaryOperation(new Literal(mr.calculateValueWithoutCurrency(currencyName, ctx.getChild(0).getText())),
                            operator,
                            visit(ctx.getChild(2)));
                    }else{
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

    @Override
    public Expression visitMoney(CurrencyParser.MoneyContext ctx) {

        String number = ctx.getChild(0).getText();
        MoneyRate mr = new MoneyRate();
        String currency = ctx.getChild(1).getText();
        
        return new Literal(mr.calculateValue(currencyName, number, currency));
    }

    @Override
    public Expression visitCurrenciesSymb(CurrencyParser.CurrenciesSymbContext ctx) {
        return visitChildren(ctx);
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
