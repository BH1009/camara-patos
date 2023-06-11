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

public class Camara extends JFrame implements ActionListener{
    //Declaracion de objetos 
    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JTextArea area;
    private JScrollPane scroll;
    
    //Constructor
    public Camara(){
        
        Webcam webcam = Webcam.getDefault();//Se crea el objeto webcam 
        webcam.open();//Se inicializa
        WebcamPanel panel= new WebcamPanel(webcam);//Se crea el panel domnde se va a visulaizara la camara  
        panel.setMirrored(true);//Se pone el metodo para poder visluaizar el panel
        
        setLayout(null);//Acomodo de los elementos
        setTitle("CamDucks");//Titulo de la ventana  
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Con este metodo se cierra el programa y se finaliza
        getContentPane().setBackground(Color.white);//Con  este metodo se coloca el fondo de la ventana
        
        //Atributos de los objetos 
        
        b1 = new JButton("Validar");//Creacion del boton validar 
        b1.setBounds(160,515,100,30);//Posicion y tamaño del boton
        add(b1);//Se agragan los atributos 
        b1.setVisible(false);//Con este metodo se esconde el objeto
        b1.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        
        b2 = new JButton("Alejar");
        b2.setBounds(10, 515, 100, 30);
        add(b2);
        b2.setVisible(false);
        b2.addActionListener(this);
        
        b3 = new JButton("Acercar");
        b3.setBounds(320, 515, 100, 30);
        add(b3);
        b3.setVisible(false);
        b3.addActionListener(this);
        
        b4 = new JButton("Encender");
        b4.setBounds(40,560,90,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Apagar");
        b5.setBounds(300,560,90,30);
        b5.addActionListener(this);
        add(b5);
        b5.setVisible(false);
        
        b6 = new JButton("Flash");
        b6.setBounds(10,15,90,30);
        b6.addActionListener(this);
        add(b6);
        b6.setVisible(false);        
        
        //Este JCroll grada el panel de la camara para visulizarlo le da un formato y tamaño  
        scroll = new JScrollPane(panel);//Se crea el scroll
        scroll.setBounds(30,55,380, 450);//Se le da posicon y tamaño
        scroll.setVisible(false);//Se esconde el objeto
        add(scroll);//Se agragan los atributos 
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == b1){
            
        }
        
        if(e.getSource() == b2){
            Alejar in = new Alejar();
            in.setBounds(0, 0, 450, 640);
            in.setVisible(true);
            in.setResizable(false);
            in.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        
        if(e.getSource() == b3){
            Acercar in = new Acercar();
            in.setBounds(0, 0,450, 640);
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
        
        Camara in = new Camara();
        in.setBounds(0,0,450,640);
        in.setVisible(true);
        in.setResizable(false);
        in.setLocationRelativeTo(null);
        
    }

    
    
}
