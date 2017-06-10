/**
 *  Technical documentation regarding the user story Core02.3: Rich Comments and History.
 * <p>
 * <h2>1. Requirement</h2>
 *
 * Cleansheets should support rich content in comments. For instance, the user
 * should be able to apply style and format to the comments. It should also
 * exist an history of changes. The user interface should display the history of
 * changes to a comment and allow the user to make a new version of a comment
 * based on an old one. It also should have a search feature, allowing the user
 * to search for comments based on text patterns (including the history in the
 * search).
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
 * <h3>3.2. UC Realization</h3>
 *
 * <p>
 * To implement this use case, it is required a sidebar, functionality that was
 * already implemented and have some changes. I have to modify code in the
 * classes previously developed, to realize this use case.
 *
 * <p>
 * The sidebar window associated to this use case is a JPanel, that contais two
 * JLists. One of them, corresponds to the list of comments of a selected
 * cell,and the other corresponds to the history of changes of a particular
 * comment. In this JPanel, there are four buttons: Add,Edit,Search Feature and
 * New Version.
 *
 * <p>
 * The first and the second buttons represents the adding and edditing of a
 * specific comment, where it opens a new window to indroduce the comment,
 * author and choose the style to the comment. When a comment is edited, the old
 * comment is saved, and it will show in the list of history changes. To show
 * the history of a comment, it is necessary click in a comment of the first
 * JList, and the list of histoy(second JList) show the history of that comment.
 *
 * <p>
 * The button "New Version" is used to make a new version of a comment based in
 * a old one and it's possible to introduce the new comment,author and style to
 * the comment.
 * <p>
 * The button "Search Feature" is used for the user search for comments based on
 * text patterns. The result of the search will appear in a new windows.
 *
 * <p>
 * When the user selects a cell, the JList(first) it will show the existing
 * comments of that cell.
 *
 * 
 * Test class: see:
 * <p>
 * <ul>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.CommentChangeTest</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.CommentNewTest</code></li>
 * <li><code>lapr4.white.s1.core.n1234567.comments.CommentableCellTest</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.controller.CommentControllerTest</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.uicommentPanelTest</code>
 * </ul>
 * 
 * 
 * <p>
 *
 * For the user interaction in the use case Core 02.3 - Rich Comments and
 * History, I have the following sequence diagram:
 * <img src="core02_03_design.png" alt="design">
 *
 *
 * <h3>3.3. Classes</h3>
 *
 * <p>
 * The new classes are:
 * <ul>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.ui.commentPanel</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.CommentNew</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.CommentChange</code></li>
 * <li><code>lapr4.green.s2.core.n1140618.richComments.controller.CommentController</code></li>
 * </ul>
 * <p>
 * The modified classes are:
 * <ul>
 * <li><code>lapr4/white/s1/core/n1234567/comments/CommentableCell</code></li>
 * <li><code>lapr4/white/s1/core/n1234567/comments/ui/UIExtensionComments</code></li>
 * </ul>
 *
 * <h3>3.4. Design Patterns and Best Practices</h3>
 *
 * Even following the best practices of a test driven and domain driven design
 * ambient, in the specific use case it wasn't needed the use of patterns for
 * its execution. The use case is open to new extensions or features.
 *
 * <p>
 *
 * <h2>4. Implementation</h2>
 *  Sub-task in Jira:
 * <a href=https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-176></a>
 *
 * <h2>5. Integration/Demonstration</h2>
 *
 * To implement this use case, I have to integrate and adapt my work in work
 * previously developed. The use case is functional, as well as prove the
 * implemented tests.
 *
 *
 */
package lapr4.green.s2.core.n1140618.richComments;
