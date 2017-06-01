package lapr4.blue.s1.lang.n1141233.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.lang.UnknownElementException;
import java.util.Arrays;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Rafael Vieira <1141233@isep.ipp.pt>
 */
public class For implements NaryOperator
{

    /**
     * Creates a new instance of the DO function.
     */
    public For()
    {
    }

    @Override
    public String getIdentifier()
    {
        return "FOR";
    }

    @Override
    public Value applyTo(Expression[] arguments) throws IllegalValueTypeException
    {
        try
        {
            // Get the sequence operator
            NaryOperator nop = Language.getInstance().getNaryOperator("{");

            // Initialization
            arguments[0].evaluate();

            // Copy arguments to be executed in each iteration of the loop
            Expression[] body = Arrays.copyOfRange(arguments, 2, arguments.length);
            Value value;

            do
            {
                // Loop body instructions
                value = nop.applyTo(body);
            }
            while (arguments[1].evaluate().toBoolean());

            return value;
        }
        catch (UnknownElementException e)
        {
            return new Value(e);
        }
    }

//    @Override
//    public FunctionParameter[] getParameters()
//    {
//        return PARAMETERS;
//    }
//
//    @Override
//    public boolean isVarArg()
//    {
//        return false;
//    }
    @Override
    public Value.Type getOperandValueType()
    {
        return Value.Type.UNDEFINED;
    }
}
