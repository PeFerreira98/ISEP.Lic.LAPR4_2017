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
 * Analysis start.<br>
 * <br>
 * Work notes/log: S3 14-06-2017 (quarta) <br>
 * Grammar copied to a new package, so we can change it.<br>
 * Analysis + Some design. <br>
 * Skeleton implementation of arrays. Grammar and visitor and 2 classes.<br>
 * Test: Functional testing and debug.<br>
 * Design documentation <br>
 * <br>
 * Work notes/log: S3 15-06-2017 (quinta) <br>
 * Ui and some classes implemented. Implementation: of Empty Sidebar, UI + controllers barebones skeleton. <br>
 * Designing.<br>
 * Implementation: Sidebard list with AutoUpdate, new VariableEditorWatchdog , testing.<br>
 * 
 * Work notes/log: S3 16-06-2017 (sexta) <br>
 * Design documentation. Showing the 2 SD's<br>
 * Implementation: Sidebard variable editing <br>
 * Design documentation. Showing the edit SD <br>
 *
 * Work notes/log: S3 17-06-2017 (sabado) <br>
 * Implementation: Variables Index are now presistent. Saved on workbook. Minor debuging. <br>
 * Implementation: varname defaults to varname[1] Grammar extremely uncooperative. <br>
 * Unit Test to ArrayStorage including expression test.
 *
 * Work notes/log: S3 18-06-2017 (domingo) <br>
 * Analysis: finish documenting. Draft of ui placed.<br>
 * 
 *
 * <br>
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
 * 3) Allow the sidebar to show the global variables.<br>
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
 * 1) The user selects a cell and types a formula creating an array such as "@abc[2]:=123".<br>
 * 2) The system will validate the formula, create an array with the indicated name (abc) and add to the second position the referred value (123). <br>
 * 3) The user selects a cell and types the formula with the name of the array and the position (@abc[2]).<br>
 * 4) They system processes the formula and changes the value of this cell to the referred value (123).<br>
 * 5) The user selects the sidebar extension of the use case.<br>
 * 6) The system displays all the global and local variables or arrays values.<br>
 * 7) The user edits a variable (array) value.<br>
 * 8) The system shows the new variable value, and the workbook updates the cells that reference that variable.<br>
 * <p>
 * <h3>2.2 SSD</h3>
 * 
 * <img src="image02.png" alt="image failed to load">
 * 
 * 
 * 
 * 
 * <h2>3. Analysis</h2>
 *
 * The workbook will have an object that needs to be serializable , the ArrayStorage. This storage will contain the ArrayItems.
 * Each of the ArrayItems will be an Array position. Since we cannot implement real arrays due to the lack of initialization code parameters.
 * Like: "int array[12];" we will treat each array position as an individual variable.
 * We will have to make sure that "@abc" will default to "@abc[1]".<p>
 * We will need to create a new Extension and Sidebar UI panel. 
 * The sidebar will show all global variables in the form of a list.
 * Access to the workbook will be done by the UIController.
 * We will have to have a field to edit a variable.
 * We will probably need a ArrayItemDTO to transfer information to the UI panel inside the sidebar.
 * To update the UI on a variable change we will need some sort of Watchdog to catch some sort of Array change event.
 * And then warn the UI to refresh.<p>
 *
 * <p>
 * 
 * <h3>3.1 First "Analysis" class diagram</h3> 
 * 
 *  <img src="image01.png" alt="image failed to load"><br>
 * We will need several classes. An ArrayItem to represent the variables.
 * A ArrayStorage to store them inside the workbook. 
 * An VariableEditorWatchdog to pass warning of changes.
 * And the regular classes associated with the sidebar extension.<p>
 * 
 * <h3> 3.2 Draft of what the user should see in the sidebar</h3>
 * <img src=" data:image/png;base64,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" alt="image failed to load">
 * <p>
 * 
 * 
 * 
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Testing </h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to use global variables as arrays in formula expressions and edit them in an GUI.<p>
 * What should we test: <br> 
 * <ul>
 * <li> 1 </li> 
 * <li> 2 </li> 
 * <li> 3 </li> 
 * <li> 4 </li> 
 * <li> 5 </li> 
 * </ul>
 * 
 * Blockages: <br>
 *  None at this time.<br>
 *  
 * <h3>4.1.1 Main Functional Test </h3>
 * 
 *  This test represent a user following the use case. It describes the user actions and the expected outcome.<p>
 *  
 *  <b>Pre conditions:</b><p>
 *  The application should be running.<p>
 * 
 *  <b>Test:</b>
 *  <ul>
 *  <li>The user selects a cell and types a formula creating an array using "=(@a[1]:=1)".</li>
 *  <li>The system shows the cell contents as "1".</li>
 *  <li>The user selects another sell and types the formula "(@a[1])".</li>
 *  <li>The system shows the cell contents as "1".</li>
 *  <li>The user selects another sell and types the formula "(@a)".</li>
 *  <li>The system shows the cell contents as "1".</li>
 *  <li>Them inside the View menu the users selects the Sidebars option and selects the Edit Variable extension.</li>
 *  <li>A new sidebar should appear in the right most side of the worksheet, showing a list with all global variables and arrays depicting the name and value.</li>
 *  <li>The user selects an array variable and edits it by inserting a new value for "@a[1]" of "2".</li>
 *  <li>The system updates all the connected cells, changing them to the value "2".</li>
 *  <li>The user selects a cell and types a formula creating an array using "=(@a[2]:=5)".</li>
 *  <li>The system updates the sidebar list, showing a new array variable "@a[2]" with the value "5".</li>
 *  <li>The user presses the save button and saves the workbook.</li>
 *  <li>The system saves without errors.</li>
 *  <li>The user presses the close button.</li>
 *  <li>The system closes the workbook.</li>
 *  <li>The user presses the open button and selects the previous workbook.</li>
 *  <li>The system opens the previous workbook displaying correctly the array variables.</li>
 *  </ul>
 * 
 * 
 * <h3>4.1.2 Unit Tests </h3>
 * 
 *  Unit Test: <br>
 *   
 *  Ongoing <p>
 * 
 * <h2>4.2 UC Realization</h2>
 * 
 * <p>
 * 
 * <h3>4.2.1 Language modifications </h3>
 * 
 * The following excerpt show the language modifications introduced to provide support for arrays.
 * Some items such as variable, TEMPORARY, GLOBAL, NUMBER already existed and were left unmodified.
 * 
 * <pre>
 * Code snippet:
 *   {@code 
 * variable
 *         :       TEMPORARY
 *         |       GLOBAL
 *         |       GLOBALINDEX        
 *         ;
 *    TEMPORARY
 *         :       UNDSCR ( NUMBER | LETTER )+
 *         ;
 * 		
 * GLOBAL
 *         :       ARROBA ( NUMBER | LETTER )+
 *         ;
 * 
 * GLOBALINDEX
 *         :       ARROBA ( INTEIRO | LETTER )+ L_SQR_BRACKET INTEIRO  R_SQR_BRACKET
 *         ;
 * NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;
 * 
 * INTEIRO: DIGIT | (DIGIT_NON_ZERO ( DIGIT )+);
 *
 * fragment 
 * DIGIT : '0'..'9' ;
 * DIGIT_NON_ZERO : '1'..'9' ;
 * 
 * L_SQR_BRACKET : '[' ;
 * R_SQR_BRACKET : ']' ;
 *       
 * }
 * </pre>
 * .<p>
 * 
 * <h3>4.2.2 Sequence Diagrams </h3>
 * 
 * <b> Array global variable creation and assignment </b> <p>
 * This SD shows the creation of an ArrayItem object, and how the value is transfered to it.
 * It also show the warning of the Watchdog that a variable has changed.<p>
 * <br>
 * <img src="image04.png" alt="image failed to load"><p>
 * <br>
 * <b> Sidebar auto updating </b> <p>
 * This SD shows how we auto update the UI everytime a Array is changed.<p>
 * <br>
 * <img src="image05.png" alt="image failed to load"><p>
 * <br>
 * <b> Edit SD </b> <p>
 * This SD shows how we edit a variable.<p>
 * <br>
 * <img src="image06.png" alt="image failed to load"><p>
 * <br>
 * 
 * <h2>4.3 Classes</h2>
 * 
 * The following image represents the classes used for this use case. <p>
 * <br>
 * <img src="image03.png" alt="image failed to load"><p>
 * <br>
 *
 * 
 * <h3>4.4. Design Patterns and Best Practices</h3>
 * 
 * 
 * 
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;
