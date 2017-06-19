/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard.controller;

import csheets.core.Cell;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import csheets.ui.ctrl.UIController;

/**
 * Controller for use case: Lang04.2 Insert Function Intermediate Wizard
 * @author Pedro Pereira
 */
public class InsertFunctionController {
    
    /**The User Interface controller*/
    private final UIController uiController;
    
    /**The Language class*/
    private final Language language;
    
    /**The Formula Compiler class*/
    private final FormulaCompiler formulaCompiler;
    
    /**
     * The constructor
     * @param uiController user interface controller
     */
    public InsertFunctionController(UIController uiController){
        this.uiController = uiController;
        this.language = Language.getInstance();
        this.formulaCompiler = FormulaCompiler.getInstance();
    }
    
    /**
     * Give the active cell
     * @return the active cell
     */
    public Cell obtainActiveCell(){
        return this.uiController.getActiveCell();
    }
    
    /**
     * Obtain the supported functions that can be used on CleanSheets
     * @return The list of supported functions
     */
    public Function[] getListSupportedFunctions(){
        return this.language.getFunctions();
    }
    
    /**
     * Obtain the supported binary operators that can be used on CleanSheets
     * @return The list of supported binary operators
     */
    public BinaryOperator[] getListSupportedOperators(){
        return this.language.getOperators();
    }
    
    /**
     * Returns the function for the given identifier
     * @param identifier identifier of the respective function
     * @return the respective function of the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException 
     */
    public Function getFunction(String identifier) throws UnknownElementException{
        return this.language.getFunction(identifier);
    }
    
    /**
     * Checks if it has the function with the selected identifier
     * @param identifier identifier of a function
     * @return true if the function exists otherwise return false
     */
    public boolean hasFunction(String identifier){
        return this.language.hasFunction(identifier);
    }
    
    /**
     * Returns the binary operator for the given identifier
     * @param identifier identifier of the respective operator
     * @return the respective operator of the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException
     */
    public BinaryOperator getOperator(String identifier) throws UnknownElementException{
        return this.language.getBinaryOperator(identifier);
    }
    
    /**
     * Compiles the formula with the given data
     * @param formulaData parameters to compile the formula
     * @return a compiled formula
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     * 
     */
    public Formula compileFormula(String formulaData) throws FormulaCompilationException{
        return this.formulaCompiler.compile(obtainActiveCell(), formulaData);
    }
    
    /**
     * Copies the content for the active cell
     * @param content the content to copy
     * @throws csheets.core.formula.compiler.FormulaCompilationException 
     */
    public void copyContentToCell(String content) throws FormulaCompilationException{
        this.uiController.getActiveCell().setContent(content);
    }
}
