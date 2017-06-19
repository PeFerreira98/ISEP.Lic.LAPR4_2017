/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import lapr4.blue.s3.core.n1140948.contactstag.ContactsTagExtension;

/**
 *
 * @author Tiago Silvestre
 */
public class TagPanel extends JPanel{
    
    private UIController uiController;
    
    public TagPanel(UIController uiController) {
        super(new BorderLayout());
        setName(ContactsTagExtension.NAME);
        
        this.uiController = uiController;
        
        buildComponents();
    }
    
    private void buildComponents() {
        JPanel topPanel = new JPanel();

        topPanel.add(makeButtons());

        add(topPanel);
    }
    
        private JPanel makeButtons() {
        final int BUTTON_WIDTH = 100, BUTTON_ALTURA = 30;
        JPanel pPanel = new JPanel();
        JButton createWindowButton = new JButton("Create Tag UI");

        createWindowButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));

        createWindowButton.addActionListener((ActionEvent e) -> {
            new AssociateTagUI(uiController);
        });

        pPanel.add(createWindowButton);
        return pPanel;
    }

}
