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
import lapr4.green.s2.core.n1140618.richComments.CommentChange;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
import lapr4.red.s1.core.n1140376.comments.Comment;

/**
 * An extension of a cell in a spreadsheet, with support for comments.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentableCell extends CellExtension {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 1L;

//	/** The cell's user-specified comment */
//        private String userComment;
    /**
     * The cell's user-specified comments list
     */
    private final List<Comment> commentsList = new ArrayList<>();
    
    
    /**
     * The cell's user-specified comments
     */
    private final ArrayList<CommentNew> userComments = new ArrayList<>();

    /**
     * The listeners registered to receive events from the comentable cell
     */
    private transient List<CommentableCellListener> listeners
            = new ArrayList<CommentableCellListener>();

    /**
     * Creates a comentable cell extension for the given cell.
     *
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
     *
     * @return true if the cell has comments;
     */
    public boolean hasComments() {
        if (this.userComments == null) {
            return false;
        }
        return !this.userComments.isEmpty();
    }
    
    /**
     * Get the cell's user comment.
     *
     * @return The user supplied comment for the cell or <code>null</code> if no
     * user supplied comment exists.
     */
    public ArrayList<CommentNew> getUserComments() {
        if (userComments.isEmpty()) {
            return null;
        } else {
            return userComments;
        }
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
     *
     * @param listener the listener to be added
     */
    public void addCommentableCellListener(CommentableCellListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the cell.
     *
     * @param listener the listener to be removed
     */
    public void removeCommentableCellListener(CommentableCellListener listener) {
        listeners.remove(listener);
    }

    /**
     * Adds a comment to this cells comment list
     *
     * @param userName name of the user performing the comment
     * @param text text of the comment
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
     * Sets the user-specified comment for the cell.
     *
     * @param comment the user-specified comment
     * @param user the user that created the comment
     * @param color the color of the comment
     * @param style the style of the comment
     */
    public void setUserComment(String comment, String user, String color, String style, String size) {
        CommentNew com = new CommentNew(comment, user, color, style, size);
        userComments.add(com);
        // Notifies listeners
        fireCommentsChanged();
    }

    /**
     * Notifies all registered listeners that the cell's comments changed.
     */
    public void fireCommentsChanged() {
        for (CommentableCellListener listener : listeners) {
            listener.commentChanged(this);
        }
    }

    /**
     * Method that shows the tooltip of the cell the user is hovering over
     *
     * @return tooltip
     */
    public String getTooltip() {

        String tooltip = null;
        if (this.hasComments()) {

            tooltip = "<html>";
//            for (Comment cmt : commentsList) {
            for (CommentNew cmt : userComments) {
                tooltip += "<b>";
                tooltip += cmt.getAuthor() + ":</b> ";
                tooltip += cmt.getContent();
                tooltip += "<br/>";
            }
            tooltip += "</html>";
        }

        return tooltip;
    }

    /**
     * Customizes serialization, by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    private void readObject(java.io.ObjectInputStream stream)
            throws java.io.IOException, ClassNotFoundException {
        stream.defaultReadObject();
        listeners = new ArrayList<>();
    }

    /**
     * Method that get´s all history of changes of a comment
     *
     * @return the list of changes of a comment
     */
    public ArrayList<String> getAllHistoryComments() {

        ArrayList<String> history = new ArrayList<>();
        for (CommentNew c : userComments) {
            history.add("Comment: " + c.getContent());
            ArrayList<CommentChange> old = c.getHistory();
            if (!old.isEmpty()) {
                for (CommentChange old1 : old) {
                    history.add("History: " + old1.getComment().getContent());
                }
            }
        }
        return history;
    }

}
