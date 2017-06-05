package lapr4.blue.s1.lang.n1141233.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.lang.UnknownElementException;
import java.util.Arrays;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author Rafael Vieira
 */
public class ForOperator implements NaryOperator
{

    /**
     * Creates a new instance of the FOR function.
     */
    public ForOperator()
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
        if (arguments.length > 2)
        {
            try
            {
                Value value;
                // Get the sequence operator to execute the body as a block
                NaryOperator naryOperator = Language.getInstance().getNaryOperator("{");

                // Initialization
                value = arguments[0].evaluate();

                // Copy arguments to be executed in each iteration of the loop
                Expression[] body = Arrays.copyOfRange(arguments, 2, arguments.length);

                do
                {
                    // Loop body instructions
                    value = naryOperator.applyTo(body);
                }
                while (arguments[1].evaluate().toBoolean());

                return value;
            }
            catch (UnknownElementException e)
            {
                return new Value(e);
            }
        }
        return new Value(new IllegalArgumentException("not enough arguments"));
    }

    @Override
    public Value.Type getOperandValueType()
    {
        return Value.Type.UNDEFINED;
    }
}
