/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments.controller;

import csheets.ui.ctrl.UIController;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;

/**
 *
 * @author Tiago
 */
public class CommentController {
    
    /**
     * The user interface controller
     */
    private UIController uiController;
    
    
    
    public CommentController(){
        
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
    public boolean setComment(CommentableCell cell, String commentString, String userString, String color, String style) {
        // Clears comment, if insufficient input
        if (commentString == null || commentString.equals("") || userString == null || userString.equals("")) {
            cell.setUserComment(null, null, null, null);
            return true;
        }

        // Stores the comment
        cell.setUserComment(commentString, userString, color, style);
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());

        return true;
    }
    
    
}
