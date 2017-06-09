/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr4.green.s2.core.n1151211.CompanyContact.CompanyContactExtension;
import lapr4.green.s2.core.n1151211.CompanyContact.application.CompanyContactController;

/**
 *
 * @author Fernando
 */
public class CompanyContactPanel extends JPanel {
    static protected final String PUSH_TO_COMPANY_CONTACT = "Push to company contacts";
    static protected final String PUSH_TO_PERSON_CONTACT = "Push to personal contacts";
    
    static protected final boolean SHOW_PERSON = true;
    static protected final boolean SHOW_COMPANY = false;
    
    static protected final String BT_PERSON_CONTACT = "Contacts";
    static protected final String BT_COMPANY_CONTACT = "Company Contacts";
    
    static protected final String TITLE_CONTACTS = "Contacts - double/right click to edit, create, delete";
    
    static protected final String TITLE_PERSON_EVENTS = "Events - double/right click to edit, create, delete";
    
    static protected final String TITLE_RELATED_PERSONS = "Related persons - read only";
    
    static protected final String TITLE_COMPANY_EVENTS = "Events - read only";
    
    
    
    private final int BUTTON_WIDTH = 170, BUTTON_ALTURA = 25;


    private UIController uiController;
    private CompanyContactController controller;
    
    private JLabel lPushTo;
    private JButton bPushToChange;
    private boolean personCompany = SHOW_PERSON;
    
    private JScrollPane pContacts;
    private DefaultListModel<String> lmContacts = new DefaultListModel<>();
    private JList<String> lstContcts;


    private JScrollPane pEventsRelated;
    private DefaultListModel<String> lmEventsRelated = new DefaultListModel<>();
    private JList<String> lstEventsRelated;


    private JScrollPane pCompanyEvents;
    private DefaultListModel<String> lmCompanyEvents = new DefaultListModel<>();
    private JList<String> lstCompanyEvents;

    
    public CompanyContactPanel(UIController uiController) {
        super.setName(CompanyContactExtension.NAME);

        this.uiController = uiController;
        controller = new CompanyContactController();
        initComponents();


    }

    private void initComponents() {
        personCompany = SHOW_PERSON;
        // Configura o gestor de posicionamento do JPanel
        BorderLayout bl = new BorderLayout();
        //bl.setHgap( 20 );
        //bl.setVgap( 20 );
        setLayout(bl);
        
        // Cria os paneis do Norte
        
        // Painel do info
        JPanel pPushTo = new JPanel();
        //pPushTo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ((FlowLayout)pPushTo.getLayout()).setAlignment(FlowLayout.CENTER);
        ((FlowLayout)pPushTo.getLayout()).setVgap(0);
        lPushTo = new JLabel( PUSH_TO_COMPANY_CONTACT, JLabel.CENTER );        
        //lPushTo.setFont( lPushTo.getFont().deriveFont(4) );
        pPushTo.add(lPushTo);
                
        // Painel do button
        JPanel pPushToChange = new JPanel();
        ((FlowLayout)pPushToChange.getLayout()).setAlignment(FlowLayout.CENTER);
        
        bPushToChange = new JButton( BT_PERSON_CONTACT );
        bPushToChange.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        //bPushToChange.setFont(bPushToChange.getFont().deriveFont(20));
        
        bPushToChange.addActionListener(new EscutarCancelar());

        pPushToChange.add(bPushToChange);

        // Painel norte
        JPanel pNorth = new JPanel();
        pNorth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.Y_AXIS));
        pNorth.add(pPushTo);
        pNorth.add(pPushToChange);
        
        add(pNorth, BorderLayout.NORTH);
       
        ///////////////////////////////////////////////////////////////////////
        
        lstContcts = new JList<>(new DefaultListModel<>());
        lstContcts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pContacts = new JScrollPane(lstContcts);
        pContacts.setBorder(BorderFactory.createTitledBorder(TITLE_CONTACTS ) );
      

        lstEventsRelated = new JList<>(new DefaultListModel<>());
        lstEventsRelated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pEventsRelated = new JScrollPane(lstEventsRelated);
        pEventsRelated.setBorder(BorderFactory.createTitledBorder(TITLE_PERSON_EVENTS ) );
        
        lstCompanyEvents = new JList<>(new DefaultListModel<>());
        lstCompanyEvents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pCompanyEvents = new JScrollPane(lstCompanyEvents);
        pCompanyEvents.setBorder(BorderFactory.createTitledBorder(TITLE_COMPANY_EVENTS ) );
        
        pCompanyEvents.setVisible(personCompany == SHOW_COMPANY);
        
        // Painel center
        JPanel pCenter = new JPanel();
        //pCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        
        pCenter.add(pContacts);
        pCenter.add(pEventsRelated);
        pCenter.add(pCompanyEvents);
        
        add(pCenter, BorderLayout.CENTER);
        
        
        repaint();
    }
    
    class EscutarCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            personCompany = !personCompany;
            
            if( personCompany == SHOW_PERSON ){
                lPushTo.setText(PUSH_TO_COMPANY_CONTACT);
                bPushToChange.setText(BT_PERSON_CONTACT);
                pEventsRelated.setBorder(BorderFactory.createTitledBorder(TITLE_PERSON_EVENTS ) );

            }else{
                lPushTo.setText(PUSH_TO_PERSON_CONTACT);
                bPushToChange.setText(BT_COMPANY_CONTACT);
                pEventsRelated.setBorder(BorderFactory.createTitledBorder(TITLE_RELATED_PERSONS ) );
            }
            
            pCompanyEvents.setVisible(personCompany == SHOW_COMPANY);
        }
    }
}



