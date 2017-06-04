package lapr4.white.s1.core.n1234567.comments.ui;

import csheets.core.Cell;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s1.core.n1140376.comments.Comment;

/**
 * A controller for updating the user-specified comment of a cell.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentController {

	/** The user interface controller */
	private UIController uiController;
        
        /** User interface panel **/
        private Cell cell;
        
        public CommentController(UIController uiController) {
		this.uiController = uiController;
	}
        
	/**
	 * Creates a new comment controller.
	 * @param uiController the user interface controller
         * @param cell the cell
	 */
	public CommentController(UIController uiController, Cell cell) {
		this.uiController = uiController;
		this.cell = cell;
	}
	/**
	 * Attempts to create a new comment from the given string.
	 * If successful, adds the comment to the given cell.
	 * If the input string is empty or null, the comment is set to null.
	 * @param cell the cell for which the comment should be set
	 * @param commentString the comment, as entered by the user
	 * @return true if the cell's comment was changed
	 */
	public boolean setComment(CommentableCell cell, String commentString)throws IllegalArgumentException {

		String userName = System.getProperty("user.name");
		// Stores the comment
		cell.addComment(userName, commentString);
		if (uiController != null) {
			uiController.
				setWorkbookModified(cell.getSpreadsheet().getWorkbook());
		}
		return true;
	}
        
        /**
         * Returns all the comments in this cell 
        * @param cell the cell whose comments changed
        * @return 
         */
        public List<Comment> getCommentList(CommentableCell cell) {
		if (cell == null) {
			return new ArrayList();
		}
		return cell.getCommentsList();
	}
}
