/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n1234567.comments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import lapr4.red.s1.core.n1140376.comments.Comment;

/**
 * An extension of a cell in a spreadsheet, with support for comments.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentableCell extends CellExtension {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 1L;

//	/** The cell's user-specified comment */
//        private String userComment;
        
        /**
	 * The cell's user-specified comments list
	 */
	private List<Comment> commentsList = new ArrayList<>();

	/** The listeners registered to receive events from the comentable cell */
	private transient List<CommentableCellListener> listeners
		= new ArrayList<CommentableCellListener>();

	/**
	 * Creates a comentable cell extension for the given cell.
	 * @param cell the cell to extend
	 */
	CommentableCell(Cell cell) {
		super(cell, CommentsExtension.NAME);
	}


/*
 * DATA UPDATES
 */


//	public void contentChanged(Cell cell) {
//	}


/*
 * COMMENT ACCESSORS
 */

        /*
        Get the comments list on this cell
        */
        public List<Comment> getCommentsList() {
            return commentsList;
        }
    
//	/**
//	 * Get the cell's user comment.
//	 * @return The user supplied comment for the cell or <code>null</code> if no user
//	 supplied comment exists.
//	*/
//	public String getUserComment() {
//		return userComment;
//	}

//	/**
//	 * Returns whether the cell has a comment.
//	 * @return true if the cell has a comment
//	 */
//	public boolean hasComment() {
//		return userComment != null;
//	}
        
        /**
         * Return wether the cell has comments.
         * @return true if the cell has comments;
         */
        public boolean hasComments(){
            if (this.commentsList == null) {
			return false;
		}
		return !this.commentsList.isEmpty();
        }

/*
 * COMMENT MODIFIERS
 */

//	/**
//	 * Sets the user-specified comment for the cell.
//	 * @param comment the user-specified comment
//	 */
//	public void setUserComment(String comment) {
//		this.userComment = comment;
//		// Notifies listeners
//		fireCommentsChanged();
//	}


/*
 * EVENT LISTENING SUPPORT
 */
          

	/**
	 * Registers the given listener on the cell.
	 * @param listener the listener to be added
	 */
	public void addCommentableCellListener(CommentableCellListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the given listener from the cell.
	 * @param listener the listener to be removed
	 */
	public void removeCommentableCellListener(CommentableCellListener listener) {
		listeners.remove(listener);
	}
        /**
         * Adds a comment to this cells comment list
         * @param userName name of the user performing the comment
         * @param text text of the comment
     * @param font
     * @param bgColor
     * @param border
         * @throws IllegalArgumentException 
         */
       public void addComment(String userName, String text)
		throws IllegalArgumentException {

		if (userName == null || userName.isEmpty()) {
			throw new IllegalArgumentException("Unable to get the username.");
		}
		if (text == null || text.isEmpty()) {
			throw new IllegalArgumentException("Comment string is empty or null.");
		}
		Comment newComment = new Comment(userName, text);
		commentsList.add(newComment);
		// Notifies listeners
		fireCommentsChanged();
	}
	/**
	 * Notifies all registered listeners that the cell's comments changed.
	 */
	protected void fireCommentsChanged() {
		for (CommentableCellListener listener : listeners)
			listener.commentChanged(this);
	}
        /**
         * Method that shows the tooltip of the cell the user is hovering over
         * @return tooltip
         */
        public String getTooltip() {

		String tooltip = null;;
		if (this.hasComments()) {

			tooltip = "<html>";
			for (Comment cmt : commentsList) {
				tooltip += "<b>";
				tooltip += cmt.userName() + ":</b> ";
				tooltip += cmt.text();
				tooltip += "<br/>";
			}
			tooltip += "</html>";
		}

		return tooltip;
	}

	/**
	 * Customizes serialization, by recreating the listener list.
	 * @param stream the object input stream from which the object is to be read
	 * @throws IOException If any of the usual Input/Output related exceptions occur
	 * @throws ClassNotFoundException If the class of a serialized object cannot be found.
	 */
	private void readObject(java.io.ObjectInputStream stream)
			throws java.io.IOException, ClassNotFoundException {
	    stream.defaultReadObject();
		listeners = new ArrayList<CommentableCellListener>();
	}
}

