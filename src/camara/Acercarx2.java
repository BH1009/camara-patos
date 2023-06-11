/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camara;
//Librerias de Interfaz grafica 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Librerias para mostrar la camara
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

/**
 * @author Diego
 * @author Julian 
 * @author Brayan
 */
public class Acercarx2 extends JFrame implements ActionListener{

    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JTextArea area;
    private JScrollPane scroll;
    private JPanel panel;
    
    public Acercarx2(){
        
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        WebcamPanel panel= new WebcamPanel(webcam);
        panel.setMirrored(true);
        
        setLayout(null);
        setTitle("CamDucks acercamiento x2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        
         
        b1 = new JButton("Validar");
        b1.setBounds(160,515,100,30);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Alejar");
        b2.setBounds(10, 515, 100, 30);
        add(b2);
        b2.addActionListener(this);
        
        b3 = new JButton("Normal");
        b3.setBounds(320, 515, 100, 30);
        add(b3);
        b3.addActionListener(this);
        
        b4 = new JButton("Encender");
        b4.setBounds(40,560,90,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Apagar");
        b5.setBounds(300,560,90,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Flash");
        b6.setBounds(10,15,90,30);
        b6.addActionListener(this);
        add(b6);      
        
        //setBounds(30, 40,380, 450);
        scroll = new JScrollPane(panel);
        scroll.setBounds(0,55,550, 450);
        scroll.setVisible(true);
        scroll.setBackground(Color.WHITE);
        add(scroll);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == b1){
            
        }
        
        if(e.getSource() == b2){
            
        }
        
        if(e.getSource() == b3){
            Normal in = new Normal();
            in.setBounds(0, 0, 450, 640);
            in.setVisible(true);
            in.setResizable(false);
            in.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        
        if(e.getSource() == b4){
            scroll.setVisible(true);
            JOptionPane.showMessageDialog(null,"Encedido");
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
            b5.setVisible(true);
            b6.setVisible(true);
        }
        
        if(e.getSource() == b5){
            scroll.setVisible(false);
            JOptionPane.showMessageDialog(null,"Apagado");
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b6.setVisible(false);
            b5.setVisible(false);
        }
        
        if(e.getSource() == b6){
            JOptionPane.showMessageDialog(null,"Flash encendido");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Acercarx2 in = new Acercarx2();
        in.setBounds(0,0,450,640);
        in.setVisible(true);
        in.setResizable(false);
        in.setLocationRelativeTo(null);
    }
    
}
