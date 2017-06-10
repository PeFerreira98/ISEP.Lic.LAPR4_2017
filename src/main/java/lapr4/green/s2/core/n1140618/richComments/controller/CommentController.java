/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments.controller;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
import lapr4.green.s2.core.n1140618.richComments.ui.commentPanel;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentsExtension;

/**
 *
 * @author Tiago
 */
public class CommentController {
    
    /**
     * The user interface controller
     */
    private UIController uiController;
    
    private commentPanel panel;
    
    
    
    public CommentController(UIController uiController, commentPanel uiPanel){
        this.panel=uiPanel;
        this.uiController=uiController;
    }
    
    
    /**
     * Attempts to create a new comment from the given string. If successful,
     * adds the comment to the given cell. If the input string is empty or null,
     * the comment is set to null.
     *
     * @param cell the cell for which the comment should be set
     * @param commentString the comment, as entered by the user
     * @param userString the comment's author name
     * @param color the color of the comment
     * @param style the style of the comment
     * @return true if the cell's comment was changed
     */
    public boolean setComment(CommentableCell cell, String commentString, String userString, String color, String style, String size) {
        // Clears comment, if insufficient input
        if (commentString == null || commentString.equals("") || userString == null || userString.equals("")) {
            cell.setUserComment(null, null, null, null, null);
            return true;
        }

        // Stores the comment
        cell.setUserComment(commentString, userString, color, style, size);
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());

        return true;
    }
    
    /**
     * Methot that edits a comment
     *
     * @param cell an extension of a cell in a spreadsheet, with support for
     * comments
     * @param c the comment to be edited
     * @param comment the new comment
     * @param author the new author
     * @param color the new color
     * @param style the new style
     */
    public void editComment(CommentableCell cell, CommentNew c, String comment, String author, String color, String style, String size) {

        CommentNew oldComment = c.clone();
        c.setContent(comment);
        c.setAuthor(author);
        c.setColor(color);
        c.setStyle(style);
        c.setSize(size);

        cell.fireCommentsChanged();

        c.addChange(oldComment);

    }
    
    /**
     * Method that search for comments based on a given text
     *
     * @param search the given text
     * @param cell an extension of a cell in a spreadsheet, with support for
     * comments
     * @return a string that contains the search
     */
    public String searchCommentsByText(String search, CommentableCell cell) {

        String s = "";

        SortedSet<Cell> cells = cell.getSpreadsheet().getCells(new Address(0, 0), new Address(51, 127));
        for (Cell c : cells) {
            CommentableCell c1 = (CommentableCell) c.getExtension(CommentsExtension.NAME);
            ArrayList<String> list = c1.getAllHistoryComments();
            if (list.size() != 0) {
                for (String comment : list) {
                    if (comment.contains(search)) {
                        s += "Cell: " + c.getAddress() + ": " + comment + "\n";
                    }
                }
            }
        }
        return s;
    }

    /**
     * A cell is selected.
     *
     * @param cell the cell was selected
     */
    public void cellSelected(CommentableCell cell) {

        if (cell.hasComments()) {
            panel.setCommentList(cell.getUserComments());
        } else {
            panel.setCommentList(null);
        }
    }
    
    
    
    
}
