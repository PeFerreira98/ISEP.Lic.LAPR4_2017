package lapr4.blue.s1.lang.n1141233.formula.lang;

import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Function;
import csheets.core.formula.UnaryOperator;
import csheets.core.formula.lang.UnknownElementException;
import java.util.ArrayList;
import java.util.List;

import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 * A factory for creating certain types of language elements.
 *
 * @author Rafael Vieira
 */
public class Language
{

    private lapr4.gray.s1.lang.n3456789.formula.lang.Language baseInstance = null;

    private static final Language INSTANCE = new Language();
//    private final List<Function> functions = new ArrayList<>();

    private final List<NaryOperator> naryOperators = new ArrayList<>();

    /**
     * Creates a new language.
     */
    private Language()
    {

        baseInstance = lapr4.gray.s1.lang.n3456789.formula.lang.Language.getInstance();

        // IMP: Need to add new function (FOR)
//        functions.add(new For());
        naryOperators.add(new For());
    }

    /**
     * Returns the singleton INSTANCE.
     *
     * @return the singleton INSTANCE
     */
    public static Language getInstance()
    {
        return INSTANCE;
    }

    /**
     * Returns the unary operator with the given identifier.
     *
     * @param identifier identifier
     *
     * @return the unary operator with the given identifier
     *
     * @throws csheets.core.formula.lang.UnknownElementException throws
     */
    public UnaryOperator getUnaryOperator(String identifier) throws UnknownElementException
    {
        return baseInstance.getUnaryOperator(identifier);
    }

    /**
     * Returns the binary operator with the given identifier.
     *
     * @param identifier identifier
     *
     * @return the binary operator with the given identifier
     *
     * @throws csheets.core.formula.lang.UnknownElementException throws
     */
    public BinaryOperator getBinaryOperator(String identifier) throws UnknownElementException
    {
        return baseInstance.getBinaryOperator(identifier);
    }

    /**
     * Returns the n-ary operator with the given identifier.
     *
     * @param identifier identifier
     *
     * @return the binary operator with the given identifier
     *
     * @throws csheets.core.formula.lang.UnknownElementException throws
     */
    public NaryOperator getNaryOperator(String identifier) throws UnknownElementException
    {
        try
        {
            return baseInstance.getNaryOperator(identifier);
        }
        catch (UnknownElementException e)
        {
            for (NaryOperator nop : naryOperators)
            {
                if (identifier.equalsIgnoreCase(nop.getIdentifier()))
                {
                    return nop;
                }
            }
            throw new UnknownElementException(identifier);
        }
    }

    /**
     * Returns the function with the given identifier.
     *
     * @param identifier identifier
     *
     * @return the function with the given identifier
     *
     * @throws csheets.core.formula.lang.UnknownElementException throws
     */
    public Function getFunction(String identifier) throws UnknownElementException
    {
//        try
//        {
        return baseInstance.getFunction(identifier);
//        }
//        catch (UnknownElementException e)
//        {
//            for (Function function : functions)
//            {
//                if (identifier.equalsIgnoreCase(function.getIdentifier()))
//                {
//                    return function;
//                }
//            }
//            throw new UnknownElementException(identifier);
//        }

    }

    /**
     * Returns whether there is a function with the given identifier.
     *
     * @param identifier identifier
     *
     * @return whether there is a function with the given identifier
     */
    public boolean hasFunction(String identifier)
    {
        return baseInstance.hasFunction(identifier);
    }

    /**
     * Returns the functions that are supported by the syntax.
     *
     * @return the functions that are supported by the syntax
     */
    public Function[] getFunctions()
    {
        return baseInstance.getFunctions();
    }
}
