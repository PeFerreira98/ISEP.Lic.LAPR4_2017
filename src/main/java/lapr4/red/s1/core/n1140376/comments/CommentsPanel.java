/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140376.comments;

import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.ui.CommentController;
import lapr4.white.s1.core.n1234567.comments.ui.CommentPanel;

/**
 *
 * @author i140376
 */
public class CommentsPanel {
    
    /**
     * The commentable cell currently being displayed in the panel
     */
        private CommentableCell cell;
    
    /** The assertion controller */
	private CommentController controller;
    /**
    * The selected commentable cell's list of comments
    */
	private List<CommentPanel> listComments;
    
    /** The user interface controller */
	private UIController uiController;
        
        public CommentsPanel(UIController uiController, CommentPanel commentP){
            
        controller = new CommentController(uiController,commentP);
	this.uiController = uiController;
        
        }
        
        private void paintCommentPanels() {
                    
        }
        
        private void cleanCommentsPanel() {
            
        }
        
        private void refreshUI() {
            
        }
        
        private void newComment() {
            
        }


}
