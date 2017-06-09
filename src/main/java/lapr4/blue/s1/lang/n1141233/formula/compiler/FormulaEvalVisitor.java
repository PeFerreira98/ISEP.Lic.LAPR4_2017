package lapr4.blue.s1.lang.n1141233.formula.compiler;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionCall;
import csheets.core.formula.Literal;
import csheets.core.formula.UnaryOperation;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.CellReference;
import csheets.core.formula.lang.RangeReference;
import csheets.core.formula.lang.ReferenceOperation;
import csheets.core.formula.lang.UnknownElementException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s1.lang.n1140953.variables.temporary.TemporaryReference;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperation;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;
import lapr4.red.s2.lang.n1131106.globalvariables.GlobalVariableReference;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Rafael Vieira
 */
public class FormulaEvalVisitor extends Formula3BaseVisitor<Expression> {

    private Cell cell = null;
    int numberOfErros;
    private final StringBuilder errorBuffer;

    public FormulaEvalVisitor(Cell cell) {
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
    public Expression visitExpression(Formula3Parser.ExpressionContext ctx) {
//        return visit(ctx.comparison());

        // child(0) = EQ
        // child(1) = comparision of for
        // child(2) = EOF
        // visiting middle child
        return visit(ctx.getChild(1));
    }

    @Override
    public Expression visitComparison(Formula3Parser.ComparisonContext ctx) {
        if (ctx.getChildCount() == 3) {
            try {
                BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            } catch (UnknownElementException ex) {
                addVisitError(ex.getMessage());
            }
        }

        return visit(ctx.concatenation(0));
    }

    @Override
    public Expression visitConcatenation(Formula3Parser.ConcatenationContext ctx) {
        try {
            if (ctx.getChildCount() == 2) { // Convert unary operation
                int operatorid = 0, operand = 1;  // Assume operator on the left

//                if (ctx.getChild(1).getChildCount() == 0) { // Conclude that operator is on the right
                if (ctx.PERCENT() != null) { // Conclude that operator is on the right
                    operatorid = 1;
                    operand = 0;
                }

                return new UnaryOperation(
                        Language.getInstance().getUnaryOperator(ctx.getChild(operatorid).getText()),
                        visit(ctx.getChild(operand))
                );

            } else if (ctx.getChildCount() == 3) {
                // Convert binary operation
                BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(0)),
                        operator,
                        visit(ctx.getChild(2))
                );
            }

        } catch (FormulaCompilationException ex) {
            addVisitError(ex.getMessage());
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitAtom(Formula3Parser.AtomContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.getChild(1));
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitFunction_call(Formula3Parser.Function_callContext ctx) {
        // Convert function call
        Function function = null;
        try {
            function = Language.getInstance().getFunction(ctx.getChild(0).getText());
        } catch (UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }

        if (function != null) {
            try {
                List<Expression> args = new ArrayList<>();
                if (ctx.getChildCount() > 3) {
                    for (int nChild = 2; nChild < ctx.getChildCount() - 1; nChild += 2) {
                        args.add(visit(ctx.getChild(nChild)));
                    }
                }
                Expression[] argArray = args.toArray(new Expression[args.size()]);
                return new FunctionCall(function, argArray);
            } catch (IllegalFunctionCallException ex) {
                addVisitError(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public Expression visitReference(Formula3Parser.ReferenceContext ctx) {
        try {
            if (ctx.getChildCount() == 3) {
                BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(1).getText());
                return new ReferenceOperation(
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(0).getText()),
                        (RangeReference) operator,
                        new CellReference(cell.getSpreadsheet(), ctx.getChild(2).getText())
                );
            } else {
                return new CellReference(cell.getSpreadsheet(), ctx.getText());
            }
            // return visitChildren(ctx); 
        } catch (ParseException | UnknownElementException ex) {
            addVisitError(ex.getMessage());
        }
        return null;
    }

    @Override
    public Expression visitLiteral(Formula3Parser.LiteralContext ctx) {
        Token t = (Token) ctx.getChild(0).getPayload();

        if (t.getType() == Formula3Parser.NUMBER) {
            return new Literal(Value.parseValue(ctx.getText()));
        } else if (t.getType() == Formula3Parser.STRING) {
            String value = ctx.getText().substring(1, ctx.getText().length() - 1);
            return new Literal(Value.parseValue(value, Value.Type.BOOLEAN, Value.Type.DATE));
        }

        return null;
    }

    @Override
    public Expression visitVariable(Formula3Parser.VariableContext ctx) {
        return new TemporaryReference(cell, ctx.getText());
    }

    public Expression visitGlobalVariableReference(Formula3Parser.VariableContext ctx) {
        return new GlobalVariableReference(cell.getSpreadsheet(), ctx.getText());
    }

    @Override
    public Expression visitAssignment(Formula3Parser.AssignmentContext ctx) {
        if (ctx.ASSIGN() != null) {
            try {
                // Convert binary operation
                BinaryOperator operator = Language.getInstance().getBinaryOperator(ctx.getChild(2).getText());
                return new BinaryOperation(
                        visit(ctx.getChild(1)),
                        operator,
                        visit(ctx.getChild(3))
                );
            } catch (UnknownElementException ex) {
                addVisitError(ex.getMessage());
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public Expression visitBlock(Formula3Parser.BlockContext ctx) {
        // Check if it is a block. Must have at least 3 child nodes

        if (ctx.L_CURLY_BRACKET() != null) {
            try {
                // The L_CURLY_BRACKET is the father node
                // All the other nodes of the blcok are children.
                // The last children node is always the R_CURLY_BRACKET
                // Therefore all the other children will be expressions to be also converted and
                // executed by a "block executor"

                Expression expressions[] = new Expression[ctx.getChildCount() / 2];
                // #1 Convert all the child nodes
                for (int nChild = 1; nChild < ctx.getChildCount(); nChild += 2) {
                    expressions[nChild / 2] = visit(ctx.getChild(nChild));
                }

                // #2 return an instance of the new NaryOperation Class
                NaryOperator operator = Language.getInstance().getNaryOperator(ctx.getChild(0).getText());
                return new NaryOperation(operator, expressions);
            } catch (UnknownElementException ex) {
                addVisitError(ex.getMessage());
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Expression visitFor_loop(Formula3Parser.For_loopContext ctx) {
        //TODO FINISH THIS!
        if (ctx.FUNCTION() != null) {
            try {
                // The FOR is the father node
                // The next is L_CURLY_BRACKET
                // All the other nodes of the FOR are children.
                // The last children node is always the R_CURLY_BRACKET
                // Therefore all the other children will be expressions to be also converted and
                // executed by a "block executor"

                Expression expressions[] = new Expression[(ctx.getChildCount() - 1) / 2];

                // #1 Convert all the child nodes
                for (int nChild = 2; nChild < ctx.getChildCount(); nChild += 2) {
                    expressions[(nChild / 2) - 1] = visit(ctx.getChild(nChild));
                }

                // #2 return an instance of the new NaryOperation Class
                NaryOperator operator = Language.getInstance().getNaryOperator(ctx.getChild(0).getText());
                return new NaryOperation(operator, expressions);
            } catch (UnknownElementException ex) {
                addVisitError(ex.getMessage());
            }
        }
        return visitChildren(ctx);
    }

    private void addVisitError(String msg) {
        errorBuffer.append(msg).append("\n");
        numberOfErros++;
    }
}
