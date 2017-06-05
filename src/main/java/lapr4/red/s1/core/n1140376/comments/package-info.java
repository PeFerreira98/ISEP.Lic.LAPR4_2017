/**
 * Technical documentation regarding the user story Core02.2: Tooltip and User Associated to Comment.
 * <h3>2.2. Analysis</h3>
 * Cleansheets should register the name of the user that creates comments and
 * each cell should support several comments. When the mouse pointer is hovering
 * above a cell and the cell has comments then these comments should be
 * displayed in a form similar to a "tooltip". The name of the author of each
 * comment should also appear in all displays of comments. Comments should be
 * persisted with the workbook.Cleansheets should register the name of the user
 * that creates comments and each cell should support several comments. When the
 * mouse pointer is hovering above a cell and the cell has comments then these
 * comments should be displayed in a form similar to a "tooltip". The name of
 * the author of each comment should also appear in all displays of comments.
 * Comments should be persisted with the workbook.<p>
 * 
 * <h3>4.2. UC Realization</h3>
 * To realize this user story we will need to create a new comment classe, and a new panel that will cotain various commentPanels called CommentsPanel
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>UC Realization Diagram</h3>
 * The following diagram shows what the user does in this Use Case
 * <p>
 * <img src="comments_extension_uc_realization2.png" alt="image">
 * 
 *
 * <h3>Design</h3>
 * The following diagram illustrates what happens in more detail in this Use Case
 * <p>
 * <img src="comments_Tooltip_And_User_To_Comment_Design.png" alt="image"> 
 * @author 1140376
 */
package lapr4.red.s1.core.n1140376.comments;

