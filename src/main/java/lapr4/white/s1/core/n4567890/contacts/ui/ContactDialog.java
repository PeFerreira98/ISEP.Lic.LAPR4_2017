/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import csheets.CleanSheets;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;
import lapr4.red.s1.core.n1140388.contacts.ui.Converter;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author alexandrebraganca
 */
public class ContactDialog extends JDialog implements ActionListener {

    private static ContactDialog dialog;
    private static String value = "";
    private JList list;

    private static Contact _contact = null;
    private static boolean _success = false;

    public enum ContactDialogMode {
        ADD,
        DELETE,
        EDIT
    }

    public static Contact contact() {
        return _contact;
    }

    public static boolean successResult() {
        return _success;
    }

    private ContactDialogMode mode = ContactDialogMode.ADD;
    private ContactController ctrl = null;

    /**
     * Set up and show the dialog. The first Component argument determines which
     * frame the dialog depends on; it should be a component in the dialog's
     * controlling frame. The second Component argument should be null if you
     * want the dialog to come up with its left corner in the center of the
     * screen; otherwise, it should be the component on top of which the dialog
     * should appear.
     */
    public static void showDialog(Component frameComp,
            Component locationComp,
            ContactController ctrl,
            ContactDialogMode mode,
            String title, Contact contact) {
        _success = false;
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new ContactDialog(frame,
                locationComp,
                ctrl,
                mode,
                title, contact);
        dialog.setVisible(true);
    }

    public static void showDialog(Component frameComp,
            Component locationComp,
            ContactController ctrl,
            ContactDialogMode mode,
            String title) {

        showDialog(frameComp, locationComp, ctrl, mode, title, null);
    }

    // Widgets
    private JButton confirmButton = null;
    private JButton cancelButton = null;

    private JLabel fullNameLabel = null;
    private JLabel firstNameLabel = null;
    private JLabel lastNameLabel = null;
    private JLabel photoLabel = null;

    private JTextField fullNameField = null;
    private JTextField firstNameField = null;
    private JTextField lastNameField = null;
    private JTextField photoPathField = null;

    /**
     * File chooser to select photograph.
     */
    private JFileChooser chooser;

    private JPanel formPanel = null;
    private JPanel buttonPanel = null;

    private JLabel statusLabel = null;
    private File photoFile = null;

    private void setupContactsWidgets() {

        formPanel = new JPanel(new SpringLayout());

        // FullName
        fullNameLabel = new JLabel(CleanSheets.getString("full_name_label"), JLabel.TRAILING);
        fullNameField = new JTextField(30);
        fullNameLabel.setLabelFor(fullNameField);
        formPanel.add(fullNameLabel);
        formPanel.add(fullNameField);

        // FirstName
        firstNameLabel = new JLabel(CleanSheets.getString("first_name_label"), JLabel.TRAILING);
        firstNameField = new JTextField(10);
        firstNameLabel.setLabelFor(firstNameField);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);

        // LastName
        lastNameLabel = new JLabel(CleanSheets.getString("last_name_label"), JLabel.TRAILING);
        lastNameField = new JTextField(10);
        lastNameLabel.setLabelFor(lastNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);

        SpringUtilities.makeCompactGrid(formPanel,
                3, 2, //rows, cols
                6, 6, //initX, initY
                10, 10
        );       //xPad, yPad

        // Last Pane: A row of buttons and the end
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        confirmButton = new JButton(CleanSheets.getString("confirm_button"));
        confirmButton.setActionCommand("confirm");
        confirmButton.addActionListener(this);
        cancelButton = new JButton(CleanSheets.getString("cancel_button"));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        //Photo
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Photo"));
        panel.setPreferredSize(new Dimension(130, 130));

        photoLabel = new JLabel();
        photoLabel.setSize(100, 100);
        panel.add(photoLabel);
        buttonPanel.add(panel);
        JButton btn = createButtonFile();
        buttonPanel.add(btn);

        // Final Pane: The status label for messages
        statusLabel = new JLabel();

        switch (this.mode) {
            case ADD:
                statusLabel.setText(CleanSheets.getString("status_please_enter_data_for_new_contcat"));
                break;
            case DELETE:
                statusLabel.setText(CleanSheets.getString("status_please_confirm_contact_to_delete"));

                // All fields in read-only mode
                this.fullNameField.setEditable(false);
                this.firstNameField.setEditable(false);
                this.lastNameField.setEditable(false);
                break;
            case EDIT:
                statusLabel.setText(CleanSheets.getString("status_please_update_data_of_contcat"));
                break;
        }

        //Put everything together, using the content pane's BorderLayout.
        Container contentPane = getContentPane();
        contentPane.add(formPanel, BorderLayout.PAGE_START);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(statusLabel, BorderLayout.PAGE_END);
        contentPane.setSize(300, 300);
    }

    private ImageIcon iconImageFromFile(File photoFile) {
        try {
            BufferedImage img = ImageIO.read(photoFile);
            return scaledImageIcon(img);
        } catch (IOException ex) {
            JOptionPane.
                    showMessageDialog(this, "Error opening file!", "User photo", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private ImageIcon scaledImageIcon(Image theImage) {
        return new ImageIcon(theImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    }

    private JButton createButtonFile() {
        JButton btn = new JButton("...");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(ContactDialog.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: "
                            + chooser.getSelectedFile().getName());
                }
                photoFile = chooser.getSelectedFile();
                photoLabel.setIcon(iconImageFromFile(photoFile));
            }
        }
        );

        return btn;

    }

    private void setupData() {
        if (_contact != null) {
            this.fullNameField.setText(_contact.name());
            this.firstNameField.setText(_contact.firstName());
            this.lastNameField.setText(_contact.lastName());
        }
    }

    private ContactDialog(Frame frame,
            Component locationComp,
            ContactController ctrl,
            ContactDialogMode mode,
            String title, Contact contact) {
        super(frame, title, true);

        this.mode = mode;
        this.ctrl = ctrl;
        _contact = contact;

        setupContactsWidgets();

        setupData();

        pack();
        setLocationRelativeTo(locationComp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("confirm".equals(e.getActionCommand())) {
            switch (this.mode) {
                case ADD: {
                    try {
                        // The User confirms the creation of a Contact
                        if (photoFile != null) {
                            _contact = this.ctrl.addContact(this.fullNameField.getText(), this.firstNameField.getText(), this.lastNameField.getText(), Converter.
                                    setImage(photoFile));
                        }else{
                            _contact = this.ctrl.addContact(this.fullNameField.getText(), this.firstNameField.getText(), this.lastNameField.getText(), null);
                        }
                        
                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    } catch (IOException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case DELETE: {
                    try {
                        boolean r;

                        //fazer o update do contacto com eventos
                        List<Contact> aux = (List<Contact>) this.ctrl.allContacts();
                        for (Contact c : aux) {
                            if (c.name().equals(_contact.name())) {
                                _contact = c;
                            }
                        }

                        r = this.ctrl.removeContact(_contact);

                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    }
                }
                break;

                case EDIT: {
                    try {
                        _contact = this.ctrl.updateContact(_contact, this.fullNameField.getText(), this.firstNameField.getText(), this.lastNameField.getText());

                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    }
                }
                break;
            }
            //ContactDialog.value = (String)(list.getSelectedValue());
        } else {
            _success = false;
            // Exit the dialog
            ContactDialog.dialog.setVisible(false);
        }
    }
}
