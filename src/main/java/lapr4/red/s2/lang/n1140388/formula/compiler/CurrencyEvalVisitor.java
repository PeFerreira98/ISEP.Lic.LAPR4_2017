/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.Expression;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CurrencyEvalVisitor extends CurrencyBaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;

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
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitCurrenciesName(CurrencyParser.CurrenciesNameContext ctx){
        return null;
    }
    
    @Override
    public Expression visitCurrenciesSymb(CurrencyParser.CurrenciesSymbContext ctx){
        return null;
    }

    @Override
    public Expression visitCurrenciesCount(CurrencyParser.CurrenciesCountContext ctx){
        return null;
    }
    
    @Override
    public Expression visitArithmetic_basic(CurrencyParser.Arithmetic_basicContext ctx){
        return null;
    }
    
    @Override
    public Expression visitArithmetic_pro(CurrencyParser.Arithmetic_proContext ctx){
        return null;
    }
    
    @Override
    public Expression visitMoney(CurrencyParser.MoneyContext ctx){
        return null;
    }
            
    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
