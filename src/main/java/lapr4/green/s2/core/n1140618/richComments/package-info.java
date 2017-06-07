/**
 *  Technical documentation regarding the user story Core02.3: Rich Comments and History.
 * <p>
 * <h2>1. Requirement</h2>
 *
 *Cleansheets should support rich content in comments. For instance, the user should 
 * be able to apply style and format to the comments. It should also exist an history of changes. 
 * The user interface should display the history of changes to a comment and allow the user to make 
 * a new version of a comment based on an old one. It also should have a search feature, 
 * allowing the user to search for comments based on text patterns (including the history in the search).
 *
 * <h2>2. Analysis</h2>
 * <p>
 * Sequence System Diagram</p>
 * <img src="core02_03_analysis_SSD.png" alt="imageSSD">
 *
 * <p>
 * The following diagram illustrates the program execution flow for the actual
 * use case.
 * <img src="core02_03_analysis.png" alt="image">
 *
 * <h2>3. Design</h2>
 *
 * <h3>3.1. Functional Tests</h3>
 *
 * Basically, from requirements and also analysis, I see that the core
 * functionality of this use case is to be able to support rich content in
 * comments.
 *
 * <p>
 * In each comment, the user has the option to apply style and format to the
 * comments, but he also has the option to edit the comment, see the history of
 * changes of a particular comment and make a new version of a comment based in
 * a old one.
 *
 * <p>
 * To be able to accomplish this feature, I need to analyse the code that was
 * previously done and add the new features. For this, I add three new
 * buttons(Edit,Search Feature,New Version) and create a new JList, that
 * represents the history of a particular comment.
 *
 *
 * <p>
 * To test the classes involved in this use case, first, I need to have a
 * UIController object and, to have this one, it is created a CleanSheets
 * object. It is also created a Workbook object, and a Spreadsheet object. After
 * that, I create a CommentPanel object, and associate him a UIController
 * object. Then, I create a Cell object(to test I use the cell(0,0)) and a
 * CommentableCell to this cell, to active comments for the cell.
 *
 * <p>
 */
package lapr4.green.s2.core.n1140618.richComments;
