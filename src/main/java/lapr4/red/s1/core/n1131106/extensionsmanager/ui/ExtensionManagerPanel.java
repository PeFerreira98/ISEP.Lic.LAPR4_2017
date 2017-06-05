/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import lapr4.red.s1.core.n1131106.extensionsmanager.ManagerExtension;
import lapr4.red.s1.core.n1131106.extensionsmanager.application.ExtensionManagerController;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class ExtensionManagerPanel extends JPanel implements SelectionListener {

    private ExtensionManagerController controller;
    private Extension[] extensions = csheets.ext.ExtensionManager.getInstance().getExtensions();
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

    public ExtensionManagerPanel(UIController uiController) {

        // Configures panel
        super(new BorderLayout());
        setName(ManagerExtension.NAME);

        // Creates controller
        this.controller = new ExtensionManagerController(uiController);
        uiController.addSelectionListener(this);

        // Add extensions to the checkbox
        int i = 0;
        for (Extension extension : extensions) {
            JCheckBox temp = new JCheckBox();
            temp.setName(extension.getName());
            temp.setText(extension.getName());
            temp.addActionListener(new ApplyAction(i));
            i++;
            checkBoxes.add(temp);
        }

        JPanel managerPanel = new JPanel();
        managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.PAGE_AXIS));
        managerPanel.setPreferredSize(new Dimension(130, 336));     // width, height
        managerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));       // width, height

        // Creates Checkboxs Panel
        JPanel navigatorCheckboxPanel = new JPanel();
        navigatorCheckboxPanel.setLayout(new BoxLayout(navigatorCheckboxPanel, BoxLayout.PAGE_AXIS));

        navigatorCheckboxPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));     // width, height

        JScrollPane scrollPane = new JScrollPane();
        for (JCheckBox cb : checkBoxes) {

            // All extensions except this
            cb.setSelected(true);
            if (!cb.getText().equalsIgnoreCase("Extension Manager")) {
                navigatorCheckboxPanel.add(cb);

            }
        }
        scrollPane.setPreferredSize(new Dimension(100, 300));   // width, height
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.add(navigatorCheckboxPanel);
        scrollPane.setViewportView(navigatorCheckboxPanel);

        managerPanel.add(scrollPane);

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Extension Manager");
        border.setTitleJustification(TitledBorder.CENTER);
        managerPanel.setBorder(border);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(managerPanel, BorderLayout.NORTH);
        add(northPanel, BorderLayout.NORTH);

    }
    

    /**
     *
     * @param event the selection event that was fired
     */
    @Override
    public void selectionChanged(SelectionEvent event) {

    }

    /**
     * Enables/Disables an extension when it is selected
     */
    protected class ApplyAction extends FocusOwnerAction {

        private int posExtension;

        /**
         * Creates a new apply action.
         * @param i an integer
         */
        public ApplyAction(int i) {
            posExtension = i;
        }

        protected String getName() {
            return "Apply";
        }

        public void actionPerformed(ActionEvent e) {
            JCheckBox cb = checkBoxes.get(posExtension);
            // Enables extension
            if (cb.isSelected()) {
                controller.changeState(posExtension, true);
                // Disable extension
            } else {
                controller.changeState(posExtension, false);
            }

        }
    }

}
