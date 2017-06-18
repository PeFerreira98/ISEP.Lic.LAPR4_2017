/**
 * Technical documentation regarding the user story Lang.01.3: Eval and While Loops
 * <p>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the sprint's work.-
 * <p>
 * This week work time was mostly spent on how the base application works, on
 * tuesday we had a meeting with the client and a scrumm meeting, where each one
 * chose a use case. Created the Jira Issues related to my use case. Started the
 * Analysis of the case.
 *
 * <p>
 * <h2>2. Requirement</h2>
 *
 * Add the 'Eval' function. This function has a single parameter that is a
 * string. When executed, this function will 'compile' the formula contained in
 * the only parameter and execute the resulting expression. The result of 'Eval'
 * is the result of the execution of the compiled expression. For example, if we
 * write the following formula '=“ 2 + 3 “' we get the string “2 + 3“ in the
 * cell. However, if we write the formula '= eval (“ 2 + 3 “)' the value
 * obtained in the cell is '5'. Add the following two loop functions: 'DoWhile'
 * and 'WhileDo'. The 'DoWhile' executes the first expression in loop while the
 * second expression evaluates to true. In each iteration of the loop the the
 * first expression is the first to be evaluated. The 'WhileDo' executes the
 * second expression in loop while the first evaluates to true. In each
 * iteration of the loop the the first expression is the first to be evaluated.
 * <p>
 * 
 * For instance, when we use Eval there must set the cell to the result of the expression used.
 * <p>
 * 
 * Also, there must be implemented two new loop funcions:<p>
 * - 'DoWhile' function where the first expression is executed and the second validated;
 * <p>
 * - 'WhileDo' function where the second expression is executed and the first is validated;<p>
 * 
 * In both cases, the first expression must be the first to be evaluated;<p>
 * 
 * <h2>3. Analysis</h2>
 * 
 * First the user needs to select a cell to edit. This cell will be activated.
 * The User inserts an instruction that starts with "=" and presses the enter
 * button. With this, the Formula Compiler starts to process the instructions.
 * First, it's important to check if the structure of the instruction goes
 * according with the one provided. Then, if it is valid, the FormulaCompiler
 * compiles the given instructions using the EvalExpressionCompiler and
 * returns the result to the Cell Editor. 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 *
 * The following diagrams depicts a proposal for the realization of the
 * previously described use case. We call this diagrams an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design.<p>
 * 
 * <p>
 * <img src="analysis_lang01.3.png" alt="image">
 * <p>
 * From the previous diagram we see that we need to insert a valid expression
 * and the system will give us back the result.
 * 
 * 
 * <h3>3.1 User Stories</h3>
 *
 * <b>US1.</b> As a User I want to be able to put a formula.<br>
 * Story Acceptance Criteria 1: Formula should begin with "="<br>
 * Story Acceptance Criteria 2: Instructions must be delimited by curly
 * braces<br>
 * <b>US2.</b> As a User I want to be able to use the WhileDo formula.<br>
 * <b>US3.</b> As a User I want to be able to use the DoWhile formula<br>
 * 
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 *
 * Basically, from requirements and also analysis, an important part is to test
 * the newly created classes. The desired result must be equal to the result
 * returned by the function. Following this pattern, tests to the new Compiler
 * should be made.
 * <p>
 * 
 * <p>
 * Alternative and Exception Scenarios<br>
 * <p>
 * Exception 1: Formula should begin with "=".
 * <p>
 * Exception 2: Instructions must be delimited by curly braces
 * <p>
 *
 * <h3>Acceptance Tests</h3>
 *
 * <b>Exception 1</b><br>
 * <pre>
 * {@code
 * Given
 *   Formula without "=" at the begin
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 * <b>Exception 2</b><br>
 * <pre>
 * {@code
 * Given
 *   Formula without instructions delimited by curly braces
 * Then
 *   System throws Exception
 * }
 * </pre>
 * 
 * 
 * <h3>4.2. UC Realization</h3>
 *
 * The following diagram shows how the UC works. After the introduction of block
 * of instructions, the cell is stored and through 'compile' method the
 * instructions will be validated with the grammar.
 * 
 * 
 * <h3>UC1 - Insert Formula</h3>
 * The following diagram illustrates what happens when the user insert a formula
 * into the cell.
 * <p>
 * <img src="design_lang01.2.png" alt="image">
 * <p>
 *
 */
package lapr4.green.s3.lang.n1140618;
