/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import lapr4.green.s2.core.n1140618.richComments.CommentChange;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
import lapr4.green.s2.core.n1140618.richComments.controller.CommentController;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentableCellListener;
import lapr4.white.s1.core.n1234567.comments.CommentsExtension;

/**
 *
 * @author Tiago
 */
public class commentPanel extends JPanel implements SelectionListener,
        CommentableCellListener {

    /**
     * The assertion controller
     */
    private CommentController controller;

    /**
     * The commentable cell currently being displayed in the panel
     */
    private CommentableCell cell;

    /**
     * The button to create a new comment.
     */
    private JButton addButton;

    /**
     * The button to edit a comment.
     */
    private JButton editButton;

    /**
     * The button to search for comment's.
     */
    private JButton searchButton;

    /**
     * The button to make a new version of a comment
     */
    private JButton makeVersionButton;

    /**
     * JList related with the comment's list
     */
    private JList commentList;

    /**
     * The default list model of commentList
     */
    private DefaultListModel listModel;

    /**
     * JList related with the history list
     */
    private JList historyList;

    /**
     * The default list model of historyList
     */
    private DefaultListModel historyModel;

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public commentPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(CommentsExtension.NAME);

        // Creates controller
        controller = new CommentController(uiController, this);
        uiController.addSelectionListener(this);

        // Creates comment components
        ApplyAction applyAction = new ApplyAction();

        listModel = new DefaultListModel();
        commentList = new JList(listModel);
        commentList.setPreferredSize(new Dimension(650, 670));		// width, height
        commentList.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        commentList.setAlignmentX(Component.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(commentList);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

        addButton = new JButton();
        addButton.setText("Add");
        addButton.addActionListener(new AddAction());

        editButton = new JButton();
        editButton.setText("Edit");
        editButton.addActionListener(new EditAction());

        searchButton = new JButton();
        searchButton.setText("Search Feature");
        searchButton.addActionListener(new SearchAction());

        makeVersionButton = new JButton();
        makeVersionButton.setText("New Version");
        makeVersionButton.addActionListener(new MakeNewVersionAction());

        commentList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                updateHistory();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);

        JLabel label = new JLabel("History");
        historyModel = new DefaultListModel();
        historyList = new JList(historyModel);
        historyList.setPreferredSize(new Dimension(400, 320));		// width, height
        historyList.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        historyList.setAlignmentX(Component.CENTER_ALIGNMENT);
        JScrollPane scrollPane2 = new JScrollPane(historyList);

        // Lays out comment components
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.PAGE_AXIS));
        commentPanel.setPreferredSize(new Dimension(600, 500));
        commentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        commentPanel.add(scrollPane);
        commentPanel.add(buttonPanel);
        commentPanel.add(label);
        commentPanel.add(scrollPane2);
        commentPanel.add(makeVersionButton);

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Comment");
        border.setTitleJustification(TitledBorder.CENTER);
        commentPanel.setBorder(border);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(commentPanel, BorderLayout.NORTH);
        add(northPanel, BorderLayout.NORTH);
    }

    /**
     * Updates the comments field
     *
     * @param event the selection event that was fired
     */
    public void selectionChanged(SelectionEvent event) {
        historyModel.clear();
        Cell cell = event.getCell();
        if (cell != null) {
            CommentableCell activeCell
                    = (CommentableCell) cell.getExtension(CommentsExtension.NAME);
            activeCell.addCommentableCellListener(this);

            commentChanged(activeCell);
        } else {
            listCellComments();
        }

        // Stops listening to previous active cell
        if (event.getPreviousCell() != null) {
            ((CommentableCell) event.getPreviousCell().getExtension(CommentsExtension.NAME))
                    .removeCommentableCellListener(this);
        }
    }

    /**
     * Updates the comment field with all the comments added previously to
     * selected cell
     *
     */
    public void updateText() {
        if (cell.hasComments()) {
            listCellComments();
        }
    }

    /**
     * Add/create a comment in the selected cell
     *
     * @param comment comment to be inserted
     * @param user writer of the comment
     * @param color the color of the comment
     * @param style the style of the comment
     */
    public void addComment(String comment, String user, String color, String style, String size) {

        controller.setComment(cell, comment, user, color, style, size);
        updateText();

    }

    /**
     * Updates the comment field when the comments of the active cell is
     * changed.
     *
     * @param cell the cell whose comments changed
     */
    @Override
    public void commentChanged(CommentableCell cell) {
        // Stores the cell for use when applying comments
        this.cell = cell;

        // The controller must decide what to do...
        controller.cellSelected(cell);
        updateText();
    }

    protected class ApplyAction implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub

        }
    }

    /**
     * Action done when the add button is pressed
     */
    protected class AddAction implements ActionListener {

        /**
         * Action done when the add button is pressed
         *
         * @param ae event of pressing the button
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            AddCommentUI add = new AddCommentUI(commentPanel.this);

        }

    }

    /**
     * Action done when the edit button is pressed
     */
    protected class EditAction implements ActionListener {

        /**
         * Action done when the edit button is pressed
         *
         * @param ae event of pressing the button
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            historyModel.clear();
            if (commentList.getSelectedIndex() != -1) {
                MakeNewVersionEditUI edit = new MakeNewVersionEditUI(controller, ((CommentNew) commentList.getSelectedValue()), cell, null);
                //updateHistory();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a comment from the list", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * Action done when the makeNewVersion button is pressed
     */
    protected class MakeNewVersionAction implements ActionListener {

        /**
         * Action done when the makeNewVersion button is pressed
         *
         * @param ae event of pressing the button
         */
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (commentList.getSelectedIndex() != -1 && historyList.getSelectedIndex() != -1) {
                MakeNewVersionEditUI make = new MakeNewVersionEditUI(controller,
                        (CommentNew) commentList.getSelectedValue(), cell, (CommentNew) historyList.getSelectedValue());

            } else {
                JOptionPane.showMessageDialog(null, "Please select a comment and a comment from the list of history", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            historyModel.clear();
        }
    }

    /**
     * Action done when the search button is pressed
     */
    protected class SearchAction implements ActionListener {

        /**
         * Action done when the search button is pressed
         *
         * @param ae event of pressing the button
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            String search = JOptionPane.showInputDialog(null, "Insert text to search for");
            if (search == null || search.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "The insert search is not valid!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                ShowHistoryUI history = new ShowHistoryUI(cell, search, controller);
            }
        }

    }

    /**
     * Method that updates the history of a comment in a JList - historyList
     */
    public void updateHistory() {
        historyModel.clear();
        CommentNew comment = (CommentNew) commentList.getSelectedValue();
        if (comment != null) {
            for (CommentChange change : comment.getHistory()) {
                historyModel.addElement(change.getComment());
            }
        }
    }

    /**
     * Inserts comments in a jlist about a cell
     *
     * @param comments the array that contains the comments
     */
    public void setCommentList(ArrayList<CommentNew> comments) {
        listModel.clear();
        if (comments != null) {
            for (CommentNew comment : comments) {
                listModel.addElement(comment);
            }
        }
    }

    /**
     * List all the comments of a cell
     */
    public void listCellComments() {
        listModel.clear();
        ArrayList<CommentNew> comments = cell.getUserComments();
        if (comments != null) {
            for (CommentNew comment : comments) {
                listModel.addElement(comment);
            }
        }
    }
    
}
