/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static lapr4.green.s2.core.n1151211.CompanyContact.ui.UICompanyContactPanel.SHOW_PERSON;

/**
 *
 * @author Fernando
 */
public class ZCompanyNameUI extends JDialog {
    private static final int WINDOW_WIDTH = 500;

    private static final int WINDOW_HEIGHT = 400;
    
    private final int BUTTON_WIDTH = 90, BUTTON_ALTURA = 25;
    
    private JButton[] buttons;
    private JTextField[] textFields;
    private JPanel pPerson;
    
    /**
     * Creates new form NewJDialog
     */
    public ZCompanyNameUI(Frame parent, boolean modal, String title, boolean personCompany ) {
        super(parent, modal);
        this.setTitle(title);
        
        System.out.println("CompanyNameUI");
        initComponents( personCompany );
    }

    private void initComponents(boolean personCompany) {
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setMinimumSize(dim);
        this.setMaximumSize(dim);
        setResizable(false);
        
        textFields = new JTextField[3];
        
        JPanel pName = null;
        //if( personCompany == UICompanyContactPanel.SHOW_COMPANY )
            pName = nameEntry( "Company Name: ", 0, 10, 10, 15, 10 );
        
        add( pName, BorderLayout.NORTH );

        if( personCompany == UICompanyContactPanel.SHOW_PERSON ){
            JPanel pCenter = new JPanel();
            pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
            
            pName = nameEntry( "First name: ", 1, 10, 10, 15, 10 );
            pCenter.add(pName);
            
            pName = nameEntry( "Last name: ", 2, 10, 10, 15, 10 );
            pCenter.add(pName);
            
            add( pCenter, BorderLayout.CENTER );
        }
      
        
        JPanel pButtons = new JPanel();
        ((FlowLayout)pButtons.getLayout()).setAlignment(FlowLayout.RIGHT);
        
        ((FlowLayout)pButtons.getLayout()).setHgap(10);
        ((FlowLayout)pButtons.getLayout()).setHgap(10);

        buttons = new JButton[2];
        
        buttons[ 0 ] = new JButton( "Update" );
        buttons[ 1 ] = new JButton( "Create" );
        
        buttons[ 1 ].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        buttons[ 0 ].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));
        
        pButtons.add( buttons[ 0 ] );
        pButtons.add( buttons[ 1 ] );
        
        
        add( pButtons, BorderLayout.SOUTH );
                
        this.pack();

    }
    
    private JPanel nameEntry( String strName, int txtField, int north, int south, int east, int west ){
        JPanel panel = new JPanel();
        BorderLayout bName = new BorderLayout();

        panel.setLayout( bName );
        panel.add(Box.createVerticalStrut(north), BorderLayout.NORTH );
        panel.add(Box.createVerticalStrut(south), BorderLayout.SOUTH );
        

        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        JPanel pNameW = new JPanel();
        pNameW.add(Box.createHorizontalStrut(west) );
        
        pNameW.add( new JLabel( strName, JLabel.LEFT ) );
        panel.add( pNameW, BorderLayout.WEST);
        
        
        
        textFields[ txtField ]  = new JTextField();
        panel.add( textFields[ txtField ], BorderLayout.CENTER);
        panel.add(Box.createHorizontalStrut(east), BorderLayout.EAST );
      

        return panel;
    }
    
    

}
