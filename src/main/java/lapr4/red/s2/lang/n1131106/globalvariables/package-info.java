/**
 * Technical documentation regarding the user story Lang02.2: Global Variables.
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * 
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-55">Lang02.2- Global Variables</a>
 *
 * 
 * <h2>2. Requirement</h2>
 * The global variables that exist in the context of the workbook, are persisted with the workbook and their names must start with the "@" sign.
 * At its creation, the global variable must be reffered in a formula.The value must be set with the following assign operator ":=".
 * 
 * <h2>3. Analysis</h2>
 * 
 * This case requires in first change the Formula.g file so it can be possible
 * to accept the symbol "@", with grammar changed and can accept this character
 * followed by a string with the variable name is already possible to interpret
 * and create Lexer associated tokens. 
 * <p>
 * Then you must create a class that is
 * responsible the creation of the Variable object, which will have a name and a
 * value spreadshet. The name will be a string to identify the variable, the
 * value It will be a double with the contents of the variable, and the
 * spreadsheet will be the current Spreadsheet. 
 * <p>
 * To persists global variables I create a list of all global variables in class Workbook and when the
 * workbook is saved, the list is saved to. To accomplish this Requirement, 
 * first of all I Will create an class called GlobalVariable, which is responsable for 
 * creating a variable when the grammar finds the TOKEN variable, in other words, 
 * a String starting with an "@".
 * 
 * <img src="lang02_02_analysis.png" alt="image"> 
 * 
 * <h2>4. Design</h2>
 * 
 * <img src="lang02_02_design.png" alt="image"> 
 * 
 *
 * <h3>4.1. Functional Tests</h3>
 * 
 *  It should be tested for ability to persist global variables that is, whenever one workbook 
 * is stored global variables are associated with the same. It should also be tested the ability 
 * to record a global variable with "@ " , ie test the validity of grammar.
 * 
 * 
 * <h3>4.2. Classes</h3>
 *  <img src="" alt="image"> 
 * 
 * 
 * <h2>8. Work Log</h2> 
 * 
 * <p>
 * <b>Monday:</b>
 * </p>
 * <p>
 * 1. Apresentation the Sprint1
 * </p>
 * 
 * <p>
 * <b>Tuesday:</b>
 * </p>
 * <p>
 * 1. Start the analysis of my UC
 * </p>
 * <p>
 * <u>Blocking:</u>
 * </p>
 * <p>
 * 1. -nothing-
 * </p>
 * 
 * 
 * @author Nuno Costa 1131106
 */
package lapr4.red.s2.lang.n1131106.globalvariables;
