/**
 * Technical documentation regarding the user story Lang04.1- Insert Function Basic Wizard Team Blue Sprint 1
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Requirement</h2><p>
 * Statement:
 * <p>
 * Cleansheets should have a menu option to launch a wizard to aid the user in
 * calling functions in formulas. This new window should display a list of
 * possible functions. The construction of this list should be made dynamically
 * based on the properties file and self-description of the functions. When a
 * function is selected in the list its syntax should be displayed in a edit
 * box. The 'syntax' should include the name of the functions and its
 * parameters. For example, for the factorial function, that only has one
 * parameter, the following text should be displayed in the edit box '=
 * FACT(Number)'. The window should also contain an area to display a text
 * describing the selected function (i.e., help text). The window should have an
 * 'Apply' and a 'Cancel' button.
 * <p>
 * <h3>1.1. Notes:</h3>
 * <p>
 * If the user selects the cancel option, the system must close the function
 * wizard
 * <p>
 * If the user selects the 'Apply' button the text of the syntax of the function
 * should be written in the formula bar.
 * <p>
 *
 *
 * <h2>2. Analysis</h2><p>
 * <img src="lang04.1_analysis.png" alt="image"></img>
 * <p>
 * <h3>2.1. Notes:</h3><p>
 * In this analysis section, it was created a SSD to simulate a scenario between
 * the system and the user<p>
 * in this respective use case, it is simulating a best case scenario.<p>
 *
 *
 * <h2>3. Tests</h2><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).
 *
 *
 *
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s1.lang.n1140948.functionwizard:
 *
 *
 * @author Tiago Silvestre
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;
