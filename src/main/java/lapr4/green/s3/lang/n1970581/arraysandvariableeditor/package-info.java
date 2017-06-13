/**
 * Technical documentation regarding the user story Lang02.3 Arrays and Variable Editor Team Green Sprint 3
 * 
 * <p>
 * <b>-Note: this is not a template/example but a real thing.</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- yes</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * 
 * Work notes/log: S3 13-06-2017 (terca) <br>
 * Scrum meeting. Sprint planing meeting. (I'm the scrum Master).<br>
 * Use case selection from backlog and distribution. <br>
 * Analysis start.
 * 
 * 
 * <h2>2. Requirement</h2>
 * 
 * <h3>2.1 Client requirements</h3>
 * <b> Lang02.3 Arrays and Variable Editor </b><br> 
 * Add support for array variables (temporary and global). Any variable can be an array. 
 * When accessing a variable only by its name it should be inferred the position 1 of the array. 
 * To explicitly access a position in a array variable the position index should be specified inside brackets (following the name of the variable).
 * For example, the formula "=@abc[2]:=123" will set the position 2 of the global variable @abc to the value 123.
 * Each position of an array can be of a different type. 
 * For instance it should be possible to have an array with numeric and alphanumeric values. <br>
 * There should also be a window in the sidebar to display and edit the value of global variables. 
 * The values that appear in this window should be automatically updated when the variables are updated.<br>
 * Difficulty: Hard. <br>
 * Mandatory: No. <br>
 * 
 * 
 * <br>
 * <b>Status at the begin.</b>   <p>
 * There are global variables, but they are local to the worksheet and they aren't saved in the workbook.<br>
 * The local variables aren't local but global.<br>
 * No special care with syncronization was detected in previous implementations. (But this analysis may be wrong). <br>
 * The sprint 2 code is not located in a single place but both also in sprint 1 package.<br>
 * There is no extension associated with this use case <br>
 * .<p>
 * 
 * <b> What we need to do in order of priority:</b> <p>
 * 1) Change global variables to an array of variables, only as numeric.<br>
 * 2) Create a sidebar window (and extension) to show the global variables.<br>
 * 3) Allow the sidebar to show the local variables.<br>
 * 4) Make global variables presistent.<br>
 * 5) Make the sidebar display auto-update.<br>
 * 6) Allow the edition of variables.<br>
 * 7) Make sure the change of variables is reflected in the workbook.<br>
 * 8) Allow the use of non numeric variables.<br>
 * <br>
 * This will be impossible to complete in full, as there are many issues and the time is limited. 
 * So we will try to implement them in this order of priority, allowing us to have something to show to the client. <p>
 * 
 * <h3>Lang02.3 Arrays and Variable Editor:</h3><p>
 * <b> Use case </b> <p>
 * The user selects a cell and types a formula creating an array such as "@abc[2]:=123".<br>
 * The system will validate the formula, create an array with the indicated name (abc) and add to the second position the referred value (123). <br>
 * The user selects a cell and types the formula with the name of the array and the position (@abc[2]).<br>
 * They system processes the formula and changes the value of this cell to the referred value (123).<br>
 * The user selects the sidebar extension of the use case.<br>
 * The system displays all the global and local variables or arrays values.<br>
 * The user edits a variable (array) value.<br>
 * The system shows the new variable value, and the workbook updates the cells that reference that variable.<br>
 * <p>
 * <h3>2.2 SSD</h3>
 * 
 * <img src="lang02_3_01_analysis.png" alt="image failed to load">
 * 
 * <h2>3. Analysis</h2>
 *
 *  -- WRITE STUFF ABOUT HOW WE WILL DO IT --
 *
 * <p>
 * 
 * <h3>3.1 First "Analysis" class diagram</h3>* 
 * 
 *  -- CLASS DIAGRAM OF THE ANALYSYS --
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;
