/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.ui;

import eapli.util.DateTime;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 *
 * @author Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class RemoveEventFrameUI extends JDialog {

    private EventPanel eventPanel;

    private final ContactController controller;
    private Contact contact;
    private Event event;

    /**
     * Creates a new event panel to create an event.
     *
     * @param father the user interface controller
     * @param contact the contact chosen
     * @param event the event chosen
     * @param controller the contact controller
     */
    public RemoveEventFrameUI(EventPanel father, Contact contact, Event event,
            ContactController controller) {
        // Configures panel
        this.setTitle("Delete Event");
        eventPanel = father;

        // Creates controller
        this.controller = controller;
        this.contact = contact;
        this.event = event;
        this.setLayout(new GridLayout(2, 1));

        //Creates panels
        JPanel p1 = createInfoPanel();
        JPanel p2 = createButtonsPanel();

        //Add panels
        add(p1);
        add(p2);

        setLocation(father.getX() + 525, father.getY() + 200);
        pack();
        setResizable(false);
        setVisible(true);
    }

    /**
     * Creates a panel to the event information, where we put the description,
     * time and the corresponding contact.
     *
     * @return information panel
     */
    private JPanel createInfoPanel() {
        String[] info = new String[6];

        info[0] = "-----------Contact Info-----------";
        info[1] = "Name: " + contact.name();

        info[2] = "-----------Event Info-----------";
        info[3] = "Description: " + event.description();
        info[4] = "Date: " + DateTime.format(event.time(), "dd-MM-yyyy");

        JList infoJList = new JList(info);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(infoJList);

        return panel;
    }

    /**
     * Creates a panel to the buttons of confirm or cancel the removing of an
     * event.
     *
     * @return buttons of confirm or cancel the removing of an event
     */
    private JPanel createButtonsPanel() {
        JButton btnOK = createButtonOk();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = createButtonCancel();

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(btnOK);
        panel.add(btnCancelar);

        return panel;
    }

    /**
     * Creates a button to confirm the removing of an event.
     *
     * @return button to confirm
     */
    private JButton createButtonOk() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.removeEvent(contact, event);

                    JOptionPane.showMessageDialog(RemoveEventFrameUI.this, "Event successfully deleted");

                    eventPanel.updateEventList();

                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RemoveEventFrameUI.this,
                            "Something wrong, event cannot be deleted: " + ex.getMessage(),
                            "Remove Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        );
        return btn;
    }

    /**
     * Creates a button to cancel the removing of an event.
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
