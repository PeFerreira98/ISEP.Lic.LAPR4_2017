/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui;

import com.sun.glass.events.KeyEvent;
import csheets.core.Cell;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javafx.scene.control.ComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import lapr4.blue.s1.lang.n1140956.ConditionalFormatting.CondFormattingController;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;

/**
 *
 * @author Marcos
 */
@SuppressWarnings("serial")
public class FormatingPanel extends JPanel implements ActionListener {

    // Controller for Contacts
    private CondFormattingController controller = null;
    private UIController uiController;
    private JPanel mainPanel = null;
    
    // Array of cells
    Cell[][] array;
    
    private final JComboBox cmbOperators;
    private final JButton btnTrue;
    private final JButton btnFalse;
    private final JButton btnOK;
    private final JButton btnReset;
    private final Object[] items = {">", "<", "<=", ">=", "=", "<>"};

    private final JTextField txtValue;

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FormatingPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        // Creates controller
        this.controller = new CondFormattingController(uiController);
        this.uiController = uiController;
         
        mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel optionButtonsPanel = new JPanel(new GridLayout(6, 2));
        JPanel confirmButtonsPanel = new JPanel(new GridLayout(5, 0));

        // Adds borders
//        TitledBorder border = BorderFactory.createTitledBorder("Formating Settings");
//        border.setTitleJustification(TitledBorder.CENTER);
//        contactsPane.setBorder(border);
        cmbOperators = new JComboBox(items);
        txtValue = createTxtValue();
        btnTrue = createBtnTrue();
        btnFalse = createBtnFalse();
        btnOK = createBtnOK();
        btnReset = createBtnReset();
     
        mainPanel.add(txtValue);
        mainPanel.add(cmbOperators);

        optionButtonsPanel.add(new JToolBar.Separator(new Dimension(10, 10)));
        optionButtonsPanel.add(btnTrue);
        optionButtonsPanel.add(btnFalse);

        confirmButtonsPanel.add(btnOK);
        confirmButtonsPanel.add(btnReset);

        // Creates side bar
        add(mainPanel, BorderLayout.NORTH);
        add(optionButtonsPanel, BorderLayout.CENTER);
        add(confirmButtonsPanel, BorderLayout.SOUTH);
    }

    private JTextField createTxtValue() {
        JTextField txt = new JTextField();
        txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char vchar = evt.getKeyChar();
                if (!(Character.isDigit(vchar) || (vchar == KeyEvent.VK_COMMA)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {}

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {}
        });
        return txt;
    }

    private JButton createBtnTrue() {
        JButton btnTrue = new JButton("True");
        btnTrue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormattingCells(uiController, controller, "true");
            }
        });
        return btnTrue;

    }

    private JButton createBtnFalse() {
        JButton btnFalse = new JButton("False");
        btnFalse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormattingCells(uiController, controller, "false");
            }
        });
        return btnFalse;
    }
    
    private JButton createBtnReset(){
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtValue.getText().isEmpty()) {
                    array = controller.getAllSelectCells();
                    for(int i=0 ; i <array.length ;i++){
                        for(int j=0 ; j <array[i].length ;j++){
                        Cell cell = array[i][j];
                            StylableCell stylableCell = (StylableCell) cell.getExtension(StyleExtension.NAME);
                            stylableCell.setBackgroundColor(new Color(255, 255, 255));
                        }
                    }
                    //Not needed
                    //controller.clearAllSelectedCells();
                }
            }
        });
        return btnReset;
    }

    private JButton createBtnOK() {
              
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.getFalseBackColor() == null && controller.getFalseFont() == null || controller.getTrueBackColor() == null && controller.getTrueFont() == null) {
                    JOptionPane.showMessageDialog(mainPanel, "You have to select format options", "Conditional Formating", JOptionPane.INFORMATION_MESSAGE);

                } else if (!txtValue.getText().isEmpty()) {
                    array = controller.getAllSelectCells();
                    for(int i=0 ; i <array.length ;i++){
                        for(int j=0 ; j <array[i].length ;j++){
                        Cell cell = array[i][j];
                        controller.addListener(txtValue.getText(), cmbOperators.getSelectedItem().toString(), cell);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(mainPanel, "You have to insert a formula ", "Conditional Formating", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        this.txtValue.setText("");
        return btnOK;
    }
}
