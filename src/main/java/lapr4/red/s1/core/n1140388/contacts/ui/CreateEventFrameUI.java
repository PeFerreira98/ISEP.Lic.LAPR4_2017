/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.ui;

import eapli.util.DateTime;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class CreateEventFrameUI extends JDialog {

    private EventPanel eventPanel;
    private JTextField descriptions, date;
    private File photoFile;
    private static final Dimension LABEL_SIZE = new JLabel("Description Text:---").
            getPreferredSize();
    private ContactController controller;
    private Contact c;

    private JCheckBox checkBox;

    public CreateEventFrameUI(EventPanel father, Contact c,
            ContactController controller) {

        this.setTitle("Create Event");
        eventPanel = father;
        this.controller = controller;
        this.c = c;
        this.setLayout(new GridLayout(4, 0));

        JPanel p1 = createDescriptionPanel();
        JPanel p2 = createTimePanel();
        JPanel p3 = createButtonsPanel();

        add(p1);
        add(p2);
        add(p3);

        setLocation(father.getX() + 525, father.getY() + 200);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createDescriptionPanel() {
        JLabel lbl = new JLabel("Description Text:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);

        descriptions = new JTextField(15);
        descriptions.requestFocus();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(new EmptyBorder(10, 10, 0, 0));

        p.add(lbl);
        p.add(descriptions);

        return p;
    }

    private JPanel createTimePanel() {
        JLabel lbl = new JLabel("Date (dd/mm/yyyy):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);

        date = new JTextField(15);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(new EmptyBorder(0, 10, 0, 0));

        p.add(lbl);
        p.add(date);

        return p;
    }

    private JPanel createButtonsPanel() {
        JButton btnOK = createButtonOk();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancel = createButtonCancel();

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(0, 10, 10, 10));

        p.add(btnOK);
        p.add(btnCancel);

        return p;
    }

    private JButton createButtonOk() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String desc = descriptions.getText();
                    if (desc == null) {
                        throw new IllegalArgumentException("Error. Empty Description");
                    }

                    String date_read = date.getText();
                    if (date_read == null) {
                        throw new IllegalArgumentException("Error. Empty Date");
                    }

                    controller.addEvent(c, descriptions.getText(), DateTime.parseDate(date.
                            getText()));

                    JOptionPane.
                            showMessageDialog(CreateEventFrameUI.this, "Event successfully created");
                    dispose();

                } catch (Exception excecao) {
                    JOptionPane.showMessageDialog(CreateEventFrameUI.this,
                            "Something wrong, contact cannot be created: " + excecao.
                            getMessage(),
                            "Create Contact",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        }
        );
        return btn;
    }

    private JButton createButtonCancel() {
        JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }

}
