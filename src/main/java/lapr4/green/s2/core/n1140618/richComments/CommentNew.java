/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments;

import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class CommentNew {

    /**
     * Variable that stores the comment content
     */
    private String comment;
    /**
     * Variable that stores the author identification
     */
    private String author;

    /**
     * Represents the color of the comment
     */
    private String color;

    /**
     * Represents the style of the comment
     */
    private String style;

    /**
     * Represents the history of modifications of a comment
     */
    ArrayList<CommentChange> history = new ArrayList<>();

    /**
     * Constructor of Comment class that creates a new instance of Comment by
     * receiving its content and author identification
     *
     * @param comment comment's content
     * @param author identification of the comment's author
     * @param color the color
     * @param style the style
     */
    public CommentNew(String comment, String author, String color, String style) {
        this.comment = comment;
        this.author = author;
        this.color = color;
        this.style = style;
    }

    /**
     * This method converts an instance of CommentNew to a formatted String with
 its data
     *
     * @return formatted String with CommentNew's data.
     */
    public String toString() {

        return style + " " + comment + " " + author;
    }

    /**
     * This method returns the comment component of this CommentNew
     *
     * @return comment component of this comment
     */
    public String getContent() {
        return this.comment;
    }

    /**
     * This method returns the author identification component of this CommentNew
     *
     * @return author identification component of this comment
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * This method sets the comment component of this CommentNew with the given
 String
     *
     * @param content content of the comment
     */
    public void setContent(String content) {
        this.comment = content;
    }

    /**
     * This method sets the author identification component of this CommentNew with
 the given String.
     *
     * @param author author of comment
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Set's the color of a comment
     *
     * @param color the new color of a comment
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Set's the style of a comment
     *
     * @param style the new style of a comment
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Creates a clone of comment.
     *
     * @return the new comment.
     */
    @Override
    public CommentNew clone() {
        CommentNew newComment = new CommentNew(this.comment, this.author, this.color, this.style);
        return newComment;
    }

    /**
     * Records the modification of a comment.
     *
     * @param oldComment the last alteration of a comment
     */
    public void addChange(CommentNew oldComment) {
        history.add(new CommentChange(oldComment));
    }

    /**
     * Get's the history of modification of a comment.
     *
     * @return all history comments
     */
    public ArrayList<CommentChange> getHistory() {
        return history;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CommentNew c = (CommentNew) obj;

        return this.comment.equalsIgnoreCase(c.comment)
                && this.author.equalsIgnoreCase(c.author)
                && this.color.equalsIgnoreCase(c.color)
                && this.style.equalsIgnoreCase(c.style);
    }
}
