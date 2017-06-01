/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;

import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.core.formula.lang.Language;

/**
 *
 * @author Tiago Silvestre
 */
public class AddFunctionController {
    
    private Function[] m_listFunctions;
    
    public AddFunctionController(){
        this.m_listFunctions = Language.getInstance().getFunctions();
    }
    
    /**
     * Method that return a list of functions.
     *
     * @return listFunctions
     */
    public Function[] listFunctions() {
        return this.m_listFunctions;
    }
    
    /**
     * Method that compiles a determined expression returning due formula with
     * its result.
     *
     * @param formulaData
     * @return Formula corresponding expression or error if the expression is
     * not recognized.
     * @throws FormulaCompilationException
     */
    public Formula compileFormula(String formulaData) throws FormulaCompilationException {
        try {
            return FormulaCompiler.getInstance().compile(null, formulaData);

        } catch (FormulaCompilationException ex) {
            throw new FormulaCompilationException(ex.getMessage());
        }

    }
    
}
