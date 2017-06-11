/**
 *  Technical documentation regarding the user story Lang.01.2: Monetary Language
 *  and the work of the team member (1140388) Alexandra Ferreira during week2.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- yes</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
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
 *
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-52">LAPR4E17DL-52</a>
 *
 * <h2>2. Requirement</h2>
 * For the user to use this language instead of the 'regular' Excel language it
 * should start the formula by the character '#' instead of the '=' character
 * and the instructions must be delimited by curly braces.
 * <p>
 * Followed by the "#" there must be the currency that we want our result to be
 * in.
 * <p>
 * This new formula should accept operations like subtraction, addition,
 * multiplication and divison. Also all the operands are monetary values.
 * <p>
 * The user should be able to calculate monetary operations like: "#euro{10,2€ +
 * 2£} using various currencies: £,€,$.
 * <p>
 * Cleansheets should also provide a way for setting exchange rates (by means of
 * a configuration).
 * <p>
 * The implementation should avoid the use of numbers in floating point
 * representation (e.g., float, double) in order to avoid precision problems.
 *
 *
 *
 * <p>
 * <b>Use Case "Monetary Language":</b>
 * The user attempts to insert a formula in the cell where he/she wants to
 * calculate.
 * <p>
 * The system calculates and validates the result.
 * <p>
 * The system saves the result of the operation in the cell.
 *
 *
 *
 *
 * <h2>3. Analysis</h2>
 * First the user needs to select a cell to edit. This cell will be activated.
 * The User inserts an instruction that starts with "#" and presses the enter
 * button. With this, the Formula Compiler starts to process the instructions.
 * First, it's important to check if the structure of the instruction goes
 * according with the one provided. Then, if it is valid, the FormulaCompiler
 * compiles the given instructions using the MonetaryExpressionCompiler and
 * returns the result to the Cell Editor. The extra requirement of changing the
 * currency rates should also be easily done, a simple UI to change the
 * constants should suffice.
 *
 *
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 * The following diagrams depicts a proposal for the realization of the
 * previously described use case. We call this diagrams an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design.
 *
 * <p>
 * <img src="analysis_lang01.2.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to insert a valid expression
 * and the system will give us back the result.
 *
 *
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * <p>
 * We don't have core technical problems regarding this issue.
 *
 *
 *
 *
 *
 * <h3>3.1 User Stories</h3>
 *
 * <b>US1.</b> As a User I want to be able to put a formula.<br>
 * Story Acceptance Criteria 1: Formula should begin with "#"<br>
 * Story Acceptance Criteria 2: Instructions must be delimited by curly
 * braces<br>
 * Story Acceptance Criteria 3: Operands should have the currency<br>
 * <b>US2.</b> As a User I want to be able to exchange the rate.<br>
 *
 *
 *
 *
 *
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
 * Forthermore I need to test the MoneyRate class. This method is the one who
 * will make all the conversions of the currencies.
 *
 * <p>
 * <b>UC1 Insert Formula (from US1)</b>
 * <p>
 * To insert a formula we have to make sure that begins with the character "#",
 * the instructions should be delimited by curly braces and operands must have
 * currency. So we have created a test that represents this business rule.
 *
 * <p>
 * see: <code>lapr4.red.s2.lang.n1140388.formula.MoneyRateTest</code>
 *
 *
 * <p>
 * Alternative and Exception Scenarios<br>
 * <p>
 * Exception 1: Formula should begin with "#".
 * <p>
 * Exception 2: Instructions must be delimited by curly braces
 * <p>
 * Exception 3: Operands should have the currency
 *
 *
 * <h3>Acceptance Tests</h3>
 *
 * <b>Exception 1</b><br>
 * <pre>
 * {@code
 * Given
 *   Formula without "#" at the begin
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
 * <b>Exception 3</b><br>
 * <pre>
 * {@code
 * Given
 *   Operands without the currency
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 *
 *
 * <h3>4.2. UC Realization</h3>
 *
 * The following diagram shows how the UC works. After the introduction of block
 * of instructions, the cell is stored and through 'compile' method the
 * instructions will be validated with the grammar.
 *
 *
 *
 *
 * <h3>UC1 - Insert Formula</h3>
 * The following diagram illustrates what happens when the user insert a formula
 * into the cell.
 * <p>
 * <img src="design_lang01.2.png" alt="image">
 * <p>
 *
 * <h3>UC2 - Exchange rates</h3>
 * The following diagram illustrates what happens when the user wants to
 * exchange the rates.
 * <p>
 * <img src="design_lang01.2_exchangeRates.png" alt="image">
 * <p>
 *
 *
 * <p>
 *
 *
 *
 *
 *
 *
 *
 *
 * <h3>4.3. Classes</h3>
 *
 * <img src="domain_model_formulas.png" alt="image">
 *
 *
 * <h3>4.4. Design Patterns and Best Practices</h3>
 *
 * -nothing-
 * <p>
 *
 *
 * <h2>5. Implementation</h2>
 *
 * {@link lapr4.red.s2.lang.n1140388.formula.compiler.CurrencyEvalVisitor}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.compiler.MonetaryExpressionCompiler}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.MoneyRate}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.ui.MoneyRateUI}
 *
 *
 *
 * <h2>6. Integration/Demonstration</h2>
 *
 *
 *
 *
 * <h2>7. Final Remarks</h2>
 *
 *
 *
 * <h2>8. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Analysis of the use case.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 *
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis of the use case.
 * <p>
 * Today
 * <p>
 * 1. Meeting with our supervisor and decided who were the Area Leaders as well
 * who was going to be Scrum Master.
 * <p>
 * 2. Confirm the chosen issue to deal.
 * <p>
 * 3. Created sub-tasks to that issue.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 *
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis and design.
 * <p>
 * Today
 * <p>
 * 1. Started the implementation.
 * <p>
 * 2. Started the planning of tests implementation.
 * <p>
 * Blocking:
 * <p>
 * -nothing-
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis, Design and Implemetation
 * <p>
 * Today
 * <p>
 * 1. Implementation of UI.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 *
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Implementation
 * <p>
 * Today
 * <p>
 * 1. Unit test.
 * <p>
 * Blocking:
 * <p>
 * <b>Saturday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Implementation and Unit test
 * <p>
 * Today
 * <p>
 * 1. -nothing-
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
 *
 * <h2>9. Self Assessment</h2>
 *
 * This sprint was very thight in time. He had to design our solution, implement
 * it and deal with swing design (UI).
 *
 * Overall it was a good sprint because we accomplished our requirements with
 * what we think it was a good solution.
 *
 *
 * <h3>R3. Rubric Requirements Fulfilment: 3</h3>
 *
 * 3- some defects. The student did fulfil all the requirements and also did
 * justify the eventual options related to the interpretation/analysis of the
 * problem.
 *
 * <h3>R6. Rubric Requirements Analysis: 4</h3>
 *
 * 4- correct. There is a robust and very complete analysis of the problem with
 * well chosen technical artifacts (diagrams, grammars, etc.) for its
 * documentation and without errors.
 *
 * <h3>R7. Rubric Design and Implement: 3</h3>
 *
 * 3- some defects. Unit tests do cover a significant amount of functionalities
 * (e.g., more than 80%) and there are some evidences of a test first approach.
 * The code does not "break" the design options of the original project code and
 * the code follows the good practices of the technical area (e.g.,
 * synchronization for IPC, design patterns, grammar design for Lang). Also, the
 * technical documentation (e.g., diagrams) is very complete and without
 * significant errors.
 *
 *
 *
 * @author Alexandra Ferreira 1140388@isep.ipp.pt
 */
package lapr4.red.s2.lang.n1140388.formula;
