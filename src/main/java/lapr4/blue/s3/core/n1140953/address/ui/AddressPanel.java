/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.PopupMenu;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr4.blue.s3.core.n1140953.address.AddressExtension;

/**
 *
 * @author zero_
 */
public class AddressPanel extends JPanel {

    private final DefaultListModel<String> listModel = new DefaultListModel<>();

    public AddressPanel(UIController uiController) {
        super(new BorderLayout());
        setName(AddressExtension.NAME);

        buildComponents();
    }

    private void buildComponents() {
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.add(new JLabel("Select Contact", JLabel.CENTER));

        JList<String> contactsList = new JList<>(listModel);
        contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(contactsList);
        
        bottomPanel.add(makeButtons());
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel makeButtons() {
        final int BUTTON_WIDTH = 100, BUTTON_ALTURA = 30;
        JPanel pPanel = new JPanel();
        JButton createAddressButton = new JButton("Create Address");
        JButton editAddressButton = new JButton("Edit Address");
        JButton removeAddressButton = new JButton("Remove Address");

        createAddressButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        editAddressButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        removeAddressButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        
        pPanel.add(createAddressButton);
        pPanel.add(editAddressButton);
        pPanel.add(removeAddressButton);
        return pPanel;
    }

}
