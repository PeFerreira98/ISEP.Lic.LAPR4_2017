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
    private JTextField txtDescription;
    private JTextField txtTime;

    private static final Dimension LABEL_SIZE = new JLabel("Description Text:---").
            getPreferredSize();

    private ContactController controller;
    private Contact contact;

    /**
     * Creates a new event panel to create an event.
     *
     * @param father the user interface controller
     * @param contact the contact chosen
     * @param controller the contact controller
     */
    public CreateEventFrameUI(EventPanel father, Contact contact,
            ContactController controller) {
        // Configures panel
        this.setTitle("Create Event");
        this.eventPanel = father;

        // Creates controller
        this.controller = controller;
        this.contact = contact;
        this.setLayout(new GridLayout(4, 0));

        //Creates panels
        JPanel p1 = createDescriptionPanel();
        JPanel p2 = createTimePanel();
//        JPanel p3 = createPhotoPanel();
        JPanel p3 = createButtonsPanel();

        //Add panels
        add(p1);
        add(p2);
        add(p3);

        setLocation(father.getX() + 525, father.getY() + 200);
        pack();
        setResizable(false);
        setVisible(true);
    }

    /**
     * Creates a panel to the event description, where we put a label and a
     * corresponding text field area.
     *
     * @return description panel
     */
    private JPanel createDescriptionPanel() {
        JLabel lbl = new JLabel("Description Text:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);

        txtDescription = new JTextField(15);
        txtDescription.requestFocus();

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new EmptyBorder(10, 10, 0, 0));

        panel.add(lbl);
        panel.add(txtDescription);

        return panel;
    }

    /**
     * Creates a panel to the event time, where we put a label and a
     * corresponding text field area.
     *
     * @return time panel
     */
    private JPanel createTimePanel() {
        JLabel lbl = new JLabel("Date (dd-MM-yyyy):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);

        txtTime = new JTextField(15);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new EmptyBorder(0, 10, 0, 0));

        panel.add(lbl);
        panel.add(txtTime);

        return panel;
    }

    /**
     * Creates a panel to the buttons of confirm or cancel the creation of an
     * event.
     *
     * @return buttons of confirm or cancel the creation of an event
     */
    private JPanel createButtonsPanel() {
        JButton btnOK = createButtonOk();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancel = createButtonCancel();

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 10, 10, 10));

        panel.add(btnOK);
        panel.add(btnCancel);

        return panel;
    }

    /**
     * Creates a button to confirm the creation of an event.
     *
     * @return button to confirm
     */
    private JButton createButtonOk() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String description = txtDescription.getText();

                    if (description == null) {
                        throw new IllegalArgumentException("Error. Empty Description");
                    }

                    String time = txtTime.getText();

                    if (time == null) {
                        throw new IllegalArgumentException("Error. Empty Date");
                    }

                    
                    
                    controller.addEvent(contact, description, DateTime.parseDate(time));

                    JOptionPane.
                            showMessageDialog(CreateEventFrameUI.this, "Event successfully created");
                    
                    eventPanel.updateEventList();
                    
                    dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(CreateEventFrameUI.this,
                            "Something wrong, event cannot be created: " + ex.getMessage(),
                            "Create Event",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        }
        );
        return btn;
    }

    /**
     * Creates a button to cancel the creation of an event.
     *
     * @return button to cancel
     */
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
