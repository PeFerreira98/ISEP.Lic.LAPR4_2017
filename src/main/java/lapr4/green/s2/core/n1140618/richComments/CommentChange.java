/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments;

/**
 *
 * @author Tiago
 */
public class CommentChange {

    /**
     * Represents the old comment associated to a comment.
     */
    private CommentNew oldComment;

    /**
     * Creates a new instance of CommentNew Change
     *
     * @param oldComment the old comment
     */
    public CommentChange(CommentNew oldComment) {
        this.oldComment = oldComment;
    }

    /**
     * Get's the text about the comment
     *
     * @return information about the comment.
     */
    @Override
    public String toString() {
        return "Old comment: " + oldComment;
    }

    /**
     * Get's the old comment.
     *
     * @return the old comment
     */
    public CommentNew getComment() {
        return oldComment;
    }

}
