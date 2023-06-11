/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camara;
import javax.swing.*;
import java.awt.event.*;
import java.awt.AWTEvent;
import java.awt.Color;



/**
 * @author Diego
 * @author Julian 
 * @author Brayan
 */
public class Camara extends JFrame implements ActionListener{

    private JButton b1,b2,b3,b4,b5;
    private JTextArea area;
    private JScrollPane scroll;
    private JLabel et1;
    
    public Camara(){
        
        setTitle("CAM");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        
        b1 = new JButton("Capturar");
        b1.setBounds(160,500,100,30);
        add(b1);
        
        b2 = new JButton("Alejar");
        b2.setBounds(10, 500, 100, 30);
        add(b2);
        
        b3 = new JButton("Acercar");
        b3.setBounds(320, 500, 100, 30);
        add(b3);
        
        b4 = new JButton("Encender");
        b4.setBounds(40,540,90,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Apagar");
        b5.setBounds(300,540,90,30);
        b5.addActionListener(this);
        add(b5);
        
        
        //area = new JTextArea();
        et1 = new JLabel("");
        scroll = new JScrollPane(et1);
        scroll.setBounds(30, 40, 380, 450);
        scroll.setVisible(false);
        add(scroll);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b4){
            scroll.setVisible(true);
            JOptionPane.showMessageDialog(null,"Encedido");
        }
        
        if(e.getSource() == b5){
            scroll.setVisible(false);
            JOptionPane.showMessageDialog(null,"Apagado");
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Camara in = new Camara();
        in.setBounds(0,0,450,640);
        in.setVisible(true);
        in.setResizable(false);
        in.setLocationRelativeTo(null);
        
    }
    
}
