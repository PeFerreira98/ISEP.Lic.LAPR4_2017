/**
 * Technical documentation regarding the user story Lang04.2: Insert Function Intermediate Wizard.
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * The wizard window should display an edit box for each parameter of the selected function. The user
 * should use these edit boxes to enter the values for each parameter of the function. As the user enters the
 * values the wizard should display (in a new region of the window) the result of the execution of the formula
 * or a message explaining the problem. The function list should now include also the operators as well as
 * the functions that are dynamically loaded from java.lang.Math. The wizard should be now launched
 * from an icon or button located in the formula bar, between the label of the active cell and the edit box of
 * the formula/value of the current cell. The menu option should be removed.
 * <p>
 * Notes:
 * <p>
 * 
 *
 *
 * <b>Analysis</b><p>
 * <img src="lang04.2_analysis.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * In this analysis section, it was created a SSD to simulate a scenario between the system and the user<p>
 * in this respective use case.<p>
 * It is simulating a scenario without errors.<p>
 * 
 *
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).<p>
 *
 * Insert a function on the wizard Functional/Integration Test:<p>
 * 1. Selects the cell that he wants to insert a function<p>
 * 2. Selects the wizard button<p>
 * 3. The wizard window appears
 * 4. The wizard shows the avaliable functions<p>
 * 5. Selects the function he wants to use on the list<p>
 * 6. The syntax of the selected function is shown in a label<p>
 * 7. The text box is filled with the syntax<p>
 * 8. The user edits the parameters of the syntax of the function with values<p>
 * 9. Selects the preview button<p>
 * 10. The result appears on the label<p>
 * 11. Selects the insert button<p>
 * 12. The result of the function is inserted in the selected cell<p>
 * 13. The wizard closes<p>
 * 14. The users selects the cell<p>
 * 15. The function is appeared in the formula bar<p>
 * 16. No error should occur<p>
 * 
 * 
 * <p>
 *
 * 
 * <b>Design</b><p>
 * The design section will be divided by parts, to show in a more easy way the process of this use case<p>
 * 
 * <p>
 * 
 * <b>Part 1:</b><p>
 * This is a full sequence diagram about the respective use case<p>
 * 
 * <img src="lang04.2_design_part1.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 2:</b><p>
 * This is a full class diagram about the respective use case<p>
 * 
 * <img src="lang04.2_design_part2.png" alt="image">
 * 
 * <p>
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s3.lang.n1130626.intermediatewizard.controller:
 * Package lapr4.green.s3.lang.n1130626.intermediatewizard.ui:
 *
 * @author Pedro Pereira
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard;
