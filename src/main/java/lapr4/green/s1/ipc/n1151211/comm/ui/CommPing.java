/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Fernando
 */
public class CommPing extends JFrame {

    private static final int WINDOW_WIDTH = 200;

    private static final int WINDOW_HEIGHT = 350;
    
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    private JList<String> peerList;
    
    private JButton btPing;
    
    public CommPing() {

        super("Ping Peers");

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        buildComponents();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = new Dimension( WINDOW_WIDTH, WINDOW_HEIGHT );
        this.setMaximumSize(dim);
        setVisible(true);
    }



            

    private void buildComponents() {
        makeButton();
        JPanel pNorth = new JPanel();
        pNorth.setBackground(Color.YELLOW);
        pNorth.add(btPing);
        add(pNorth, BorderLayout.NORTH);
        
        
        //create the list
        peerList = new JList<>(listModel);
        peerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane pCenter = new JScrollPane(peerList );

        add( pCenter );

    }
    
    
    private void makeButton() {

        btPing = new JButton("Ping");
        btPing.setForeground(Color.BLUE);
        final int BUTTON_WIDTH = 80, BUTTON_ALTURA = 50;
        btPing.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));

        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CommPing.this, "Carregou em " + e.getActionCommand());
            }
        });

    }



}
