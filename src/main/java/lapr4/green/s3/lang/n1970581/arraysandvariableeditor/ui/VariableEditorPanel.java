/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ui;

import csheets.ui.ctrl.UIController;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ArrayItemDTO;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.controller.VariableEditorController;

/**
 *  Ui for interacting with the Global variables or Arrays and editing them.
 * @author Hugo
 */
public class VariableEditorPanel extends javax.swing.JPanel implements Observer{

    /** edit variable title */
    private final String EDIT_VARIABLE_TITLE = "Edit variable";
    
     /**
     * The ui Controller of the main window
     */
    private final UIController uiController;

    /**
     * The Controller of the use case
     */
    private final VariableEditorController controller;
    
    
    private DefaultListModel<ArrayItemDTO> list;
    
    /**
     * Creates new form VariableEditorPanel
     * @param uiController the UIController
     */
    public VariableEditorPanel(UIController uiController) {
        this.uiController = uiController;
        this.controller = new VariableEditorController(uiController);
        initComponents();
        this.list = (DefaultListModel<ArrayItemDTO>)this.jListDTO.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListDTO = new javax.swing.JList();
        jToggleButtonAutoUpdate = new javax.swing.JToggleButton();
        jTextFieldEditText = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jTextFieldShowValue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Variable Editor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jListDTO.setModel(new DefaultListModel<ArrayItemDTO>());
        jListDTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDTOMouseClicked(evt);
            }
        });
        jListDTO.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListDTOValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListDTO);

        jToggleButtonAutoUpdate.setText("Auto Update");
        jToggleButtonAutoUpdate.setToolTipText("Tougle to autoupdate the variables.");
        jToggleButtonAutoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAutoUpdateActionPerformed(evt);
            }
        });

        jTextFieldEditText.setText("EDIT FIELD");

        jButtonEdit.setText("Edit");
        jButtonEdit.setToolTipText("Select the variable with mouse and fill the EDIT field before pressing me.");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jTextFieldShowValue.setEditable(false);
        jTextFieldShowValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldShowValueActionPerformed(evt);
            }
        });

        jLabel1.setText("New value:");

        jLabel2.setText("value:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButtonAutoUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldShowValue))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEditText)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldShowValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonAutoUpdate)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonEdit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonAutoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAutoUpdateActionPerformed
        // TODO add your handling code here:
        if(this.jToggleButtonAutoUpdate.isSelected()){
            this.registerInWatchdog();
        }
        else this.unregisterInWatchdog();
    }//GEN-LAST:event_jToggleButtonAutoUpdateActionPerformed

    private void jListDTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDTOMouseClicked
        // TODO add your handling code here:
        if (this.jListDTO.isSelectionEmpty()) return;
        ArrayItemDTO dto = (ArrayItemDTO)this.jListDTO.getSelectedValue();
        this.jTextFieldShowValue.setText(dto.value());
        this.jTextFieldEditText.setText(dto.value());
        
    }//GEN-LAST:event_jListDTOMouseClicked

    private void jTextFieldShowValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldShowValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldShowValueActionPerformed

    private void jListDTOValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListDTOValueChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jListDTOValueChanged

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (this.jListDTO.isSelectionEmpty()) return;
        ArrayItemDTO dto = (ArrayItemDTO)this.jListDTO.getSelectedValue();
        String newString = this.jTextFieldEditText.getText();
        String mesage = "Accept this edit of " + dto.name() + "\nfrom: "+ dto.value() + "\nto: " + newString;
        int answer = 0;  // NO = 1 , YES = 0
        answer = JOptionPane.showConfirmDialog(this, mesage , EDIT_VARIABLE_TITLE , JOptionPane.YES_NO_OPTION);
        if(answer == 1) return;
        boolean sucess = false;
        try {
            sucess = this.controller.editArrayItem(dto, newString);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            this.list.clear();
            return;
        }
        if (!sucess) JOptionPane.showMessageDialog(this, "ERROR");
    }//GEN-LAST:event_jButtonEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListDTO;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldEditText;
    private javax.swing.JTextField jTextFieldShowValue;
    private javax.swing.JToggleButton jToggleButtonAutoUpdate;
    // End of variables declaration//GEN-END:variables


    /**
     * Updates the list of DTO's.
     */
    public void updateList(){
        List<ArrayItemDTO> listOfDTO;
        try{
            listOfDTO = this.controller.retriveActiveWorkbookVariableList();
            listOfDTO.sort(null);
            this.list.clear();
            for(ArrayItemDTO dto : listOfDTO){
                this.list.addElement(dto);
            }
            
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            this.list.clear();
        }
    }

    /**
     * Register in the watch dog to start receiving updates.
     */
    public void registerInWatchdog(){
        this.controller.registerInWatchdog(this);
        this.updateList();
    }

    /**
     * Unregister, to stop receiving updates.
     */
    public void unregisterInWatchdog(){
        this.controller.unregisterInWatchdog(this);
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        this.updateList();
    }

}