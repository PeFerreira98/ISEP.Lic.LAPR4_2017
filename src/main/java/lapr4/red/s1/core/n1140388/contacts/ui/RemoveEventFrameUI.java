/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    private JTextField descriptions, date;
    private static final Dimension LABEL_TAMANHO = new JLabel("Description Text:sss").
            getPreferredSize();
    private final ContactController controller;
    private Contact contact;
    private Event event;

    public RemoveEventFrameUI(EventPanel father, Contact c, Event e,
            ContactController controller) {

        this.setTitle("Delete Event");
        eventPanel = father;
        this.controller = controller;
        this.contact = c;
        this.event = e;
        //this.setLayout(new GridLayout(2, 0));

        JPanel p1 = createPanelInfo();
        JPanel p2 = createPanelButtons();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setLocation(father.getX() + 525, father.getY() + 200);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel createPanelInfo() {
        String[] info = new String[6];

        info[0] = "-----------Contact Info-----------";

        Contact c = (Contact) contact;
        info[1] = "Name: " + c.name();

        info[2] = "-----------Event Info-----------";
        info[3] = "Description : " + event.description();
        info[4] = "Date : " + event.time().get(Calendar.DAY_OF_MONTH) + "/"
                + event.time().get(Calendar.MONTH) + "/"
                + event.time().get(Calendar.YEAR);

        JList jl = new JList(info);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(new EmptyBorder(10, 10, 0, 0));

        p.add(jl);
        return p;
    }

    private JPanel createPanelButtons() {
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
                    controller.removeEvent(contact, event);
                    JOptionPane.showMessageDialog(RemoveEventFrameUI.this, "Event successfully deleted");
                    dispose();
                } catch (Exception excecao) {
                    JOptionPane.showMessageDialog(RemoveEventFrameUI.this,
                            "Something wrong, event cannot be deleted: " + excecao.
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
