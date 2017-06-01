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
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 *
 * Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class EditEventFrameUI extends JDialog {

    private EventPanel eventPanel;
    private JTextField descriptions, date;
    private static final Dimension LABEL = new JLabel("Description Text:sss").
            getPreferredSize();
    private final ContactController controller;
    private Contact c;
    private Event event;

    public EditEventFrameUI(EventPanel father, Contact c, Event e,
            ContactController controller) {

        this.setTitle("Edit Event");
        eventPanel = father;
        this.controller = controller;
        this.c = c;
        this.event = e;
        this.setLayout(new GridLayout(3, 0));

        JPanel p1 = createTextPanel();
        JPanel p2 = createDatePanel();
        JPanel p4 = createButtonsPanel();

        add(p1);
        add(p2);
        add(p4);

        setLocation(father.getX() + 525, father.getY() + 200);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createTextPanel() {
        JLabel lbl = new JLabel("Description Text:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL);

        descriptions = new JTextField(15);
        descriptions.requestFocus();
        descriptions.setText(event.description());
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(new EmptyBorder(10, 10, 0, 0));

        p.add(lbl);
        p.add(descriptions);

        return p;
    }

    private JPanel createDatePanel() {
        JLabel lbl = new JLabel("Date (dd/mm/yyyy):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL);
        final int CAMPO_LARGURA = 15;
        date = new JTextField(CAMPO_LARGURA);
        date.setText(event.time().get(Calendar.DAY_OF_MONTH) + "/"
                + event.time().get(Calendar.MONTH) + "/"
                + event.time().get(Calendar.YEAR)
        );
        date.requestFocus();
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(new EmptyBorder(0, 10, 0, 0));
        p.add(lbl);
        p.add(date);

        return p;
    }

    private JPanel createButtonsPanel() {
        JButton btnOK = createButtonOk();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = createButtonCancel();

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(0, 10, 10, 10));
        p.add(btnOK);
        p.add(btnCancelar);

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

                    controller.editEvent(c, event, descriptions.getText(), DateTime.parseDate(date.
                            getText()));
                    JOptionPane.showMessageDialog(EditEventFrameUI.this, "Event successfully edited");
                    dispose();
                } catch (Exception excecao) {
                    JOptionPane.showMessageDialog(EditEventFrameUI.this,
                            "Something wrong, event cannot be edited: " + excecao.
                            getMessage(),
                            "Create Event",
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
