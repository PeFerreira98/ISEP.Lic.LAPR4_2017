/**
 * Technical documentation regarding the user story macros01.1: ciclos e funcoes. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Bloco de instruções. Acrescentar a possibilidade de se escrever um bloco (ou sequência) de instruções. Um bloco deve ser delimitado por chavetas e as suas instruções separadas por “;". As instruções de um bloco são executadas sequencialmente e o resultado do bloco é o resultado da última instrução do bloco. Por exemplo, a fórmula “={1+2; sum(A1:A10); B3+4}” deve resultar na execução sequencial de todas as expressões e o resultado será o valor da expressão “B3+4”. Fazer o ciclo FOR usando os blocos. <p>Operador de Atribuição. Acrescentar o operator “:=“ para atribuição. Este operador deve atribuir à esquerda o resultado da expressão à direita do operador. Para já à esquerda deve ser possivel colocar o nome de uma célula. <p>
 *  
 * <b>Attention:</b><p> 
 * In package csheets.core.formula.util,ExpressionVisitor it is necessary to add a new method to support visiting the new type of operator "naryoperator". 
 * This will add an "uncommon" dependency between the core code and the lapr4 code!
 * 
 * <b>macros01.1a: Analysis</b><p>
 * 
 * <b>Notes</b><p>
 * - This use case regards essentially the formula compiler and executer. It does not seem to have any impact in other areas of the application.<p> 
 * - The entry point for the execution of the formula compiler is the method setContent of the interface Cell.<p>
 * - The setContent method basically does three things:<p>
 *      -- storeContent(content);    = this compiles de content and produces a Formula object and update cell dependencies based on the Formula<p>
 *	-- fireContentChanged();     = this notifies listenners about content changes<p>
 *      -- reevaluate();             = this executes the Formula and notifies listenners about value changes
 * <p>
 * <b>storeContent</b><p>
 * Executes formula=FormulaCompiler.getInstance().compile(content)  = this will select the instance of ExpressionCompiler based on the "starter char"<p>
 * - <b>compile</b><p>
 * -- will execute the FormulaParser (generated from ANTLR) to obtain the parser tree.<p>
 * -- the parser tree is then traversed and an Expression is generated.
 * <p>
 * <b>How the parser and executer work together</b><p>
 * Antlr will generate a parser tree. The parser tree includes nodes for grammar elements that are marked with ""^ as a suffix. The other elements in the same rule will become child elements of the node. The elements that are marked with the "!" suffix are not included.<p>
 * For instance, the following grammar rule:<p>
 * L_CURLY_BRACKET^ comparison ( SEMI! comparison )* R_CURLY_BRACKET <p>
 * will generate a node for the L_CURLY_BRACKET and all other elements will be child nodes. The SEMI terminal will not be include in the child elements.
 * <p>
 * <b>Converting parser tree to Expressions</b><p>
 * Each ExpressionCompiler (ExcelExpressionCompiler or any other) will traverse the nodes of the parser tree and generate an Expression for each node. At the end the result is a tree of expressions.<p>
 * The next diagram illustrates the Expression interface and its hierarchy.<p>
 * For the block the idea is to have a new class to support n-ary operations<p>
 * For the assignment the idea is to implement it as a binary operator<p>
 * <img src="domain_model_formulas.png" alt="image"> 
 * <p>
 * <b>macros01.1t: Tests</b><p>
 * Formulas can be tested interactively using <b>{@link csheets.core.formula.compiler.Console}</b><p>
 * Example of formulas that should be supported by this use case:<p>
 * <b>={ 1+2; sum(a1:a10); b3+4 }</b><p>
 * The following formula will set the value of the cell to the result of the attribution expression. An attribution expression will result always in the value of the expression to the right of the attribution operator.<p>
 * We propose to surround the assignment operator with curly brackets so that the impact in the grammar is minor.<p>
 * <b>=(a1:=a3+1)+23</b><p>
 * In the following proposal for the cycle FOR, the first expression is the initialization, the second expression is the limit condition and all the other expressions are to be executed for each iteration of the cycle.<p>
 * <b>=FOR{ a1:=1; a1&lt;10; a2:=a2+a1; a1:=a1+1 }</b><p>
 * See Package csheets.core.formula:<p>
 * FormulaLoopTest<p>
 * 
 * <b>macros01.1d: Design</b><p>
 *
 * <b>macros01.1c: Code</b><p>
 * 
 * @author alexandrebraganca
 */
package lapr4.gray.s1.lang.n3456789.formula;




