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
 *
 * @author Pedro Pereira
 */
public class InsertFunctionController {
    
    private final UIController uiController;
    private final Language language;
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
     * 
     * @return 
     */
    public Function[] getListSupportedFunctions(){
        return this.language.getFunctions();
    }
    
    /**
     * 
     * @param identifier
     * @return 
     * @throws csheets.core.formula.lang.UnknownElementException 
     */
    public Function getFunction(String identifier) throws UnknownElementException{
        return this.language.getFunction(identifier);
    }
    
    /**
     * 
     * @param identifier
     * @return 
     */
    public boolean hasFunction(String identifier){
        return this.language.hasFunction(identifier);
    }
    
    /**
     * 
     * @param identifier
     * @return
     * @throws csheets.core.formula.lang.UnknownElementException
     */
    public BinaryOperator getOperator(String identifier) throws UnknownElementException{
        return this.language.getBinaryOperator(identifier);
    }
    
    /**
     * 
     * @param formulaData
     * @return
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     * 
     */
    public Formula compileFormula(String formulaData) throws FormulaCompilationException{
        return this.formulaCompiler.compile(obtainActiveCell(), formulaData);
    }
    
    /**
     * 
     * @param content
     * @throws csheets.core.formula.compiler.FormulaCompilationException 
     */
    public void copyContentToCell(String content) throws FormulaCompilationException{
        this.uiController.getActiveCell().setContent(content);
    }
}
