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

//Librerias extra
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 *
 * @author Brayan
 */

public class Camara extends JFrame implements ActionListener{
    //Declaracion de objetos 
    private JButton b1,b2,b3,b4,b5,b6,b7,b8;
    private JTextArea area;
    private JScrollPane scroll;
    private JFrame ver;
    private JLabel panel;
    
    //Constructor
    public Camara(){
        
        Webcam webcam = Webcam.getDefault();//Se crea el objeto webcam 
        webcam.open();
        WebcamPanel panel= new WebcamPanel(webcam);//Se crea el panel domnde se va a visulaizara la camara  
        panel.setMirrored(true);//Se pone el metodo para poder visluaizar el panel
        
        setLayout(null);//Acomodo de los elementos
        setTitle("CamDucks");//Titulo de la ventana  
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Con este metodo se cierra el programa y se finaliza
        getContentPane().setBackground(Color.white);//Con  este metodo se coloca el fondo de la ventana
        //Atributos de los objetos 
        
        b1 = new JButton("Validar");//Creacion del boton validar 
        b1.setBounds(160,515,100,30);//Posicion y tamaño del boton
        add(b1);//Se agregan los atributos 
        b1.setVisible(false);//Con este metodo se esconde el objeto
        b1.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        
        b2 = new JButton("Alejar");//Creacion  del boton Alejar
        b2.setBounds(10, 515, 100, 30);//Posicion y tamaño del boton
        add(b2);//Se agregan los atributos
        b2.setVisible(false);//Con este metodo se esconde el objeto
        b2.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        
        b3 = new JButton("Acercar");//Creacion del boton Acercar
        b3.setBounds(320, 515, 100, 30);//Posicion y tamaño del boton
        add(b3);//Se agregan los atributos
        b3.setVisible(false);//Con este metodo se esconde el objeto
        b3.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        
        b4 = new JButton("Encender");//Creacion del boton Encender
        b4.setBounds(40,560,90,30);//Posicion y tamaño del boton
        b4.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        add(b4);//Se agregan los atributos
        
        b5 = new JButton("Apagar");//Creacion del boton Apagar
        b5.setBounds(300,560,90,30);//Posicion y tamaño del boton
        b5.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        add(b5);//Se agregan los atributos
        b5.setVisible(false);//Con este metodo se esconde el objeto
        
        b6 = new JButton("Flash");//Creacion del boton Flash 
        b6.setBounds(10,15,90,30);//Posicion y tamaño del boton
        b6.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        add(b6);//Se agregan los atributos
        b6.setVisible(false);//Con este metodo se esconde el objeto  
        
        b7 = new JButton("Enfocar");//Creacion de boton Enfocar 
        b7.setBounds(320,15,90,30);//Posicion y tamaño del boton
        b7.addActionListener(this);//Espera que el boton sea pulsado para realizar una accion
        add(b7);//Se agregan los atributos
        b7.setVisible(false);//Con este metodo se esconde el objeto
      
        //Este JCroll grada el panel de la camara para visulizarlo le da un formato y tamaño  
        scroll = new JScrollPane(panel);//Se crea el scroll
        scroll.setBounds(30,55,380, 450);//Se le da posicon y tamaño
        scroll.setVisible(false);//Se esconde el objeto
        add(scroll);//Se agragan los atributos 
        
    }
    
    public void actionPerformed(ActionEvent e){
        //Aciones del boton Validar 
        if(e.getSource() == b1){
            byte o1,o2,o3,o4;
            o1=Byte.parseByte(JOptionPane.showInputDialog("Tiene pico ?\n"
                    + "1 Si\n"
                    + "2 No"));
            if(o1==1){
                o2 = Byte.parseByte(JOptionPane.showInputDialog("Es cafe o blanco ?\n"
                        + "1 Si\n"
                        + "2 No"));
                o3 = Byte.parseByte(JOptionPane.showInputDialog("Tiene las patas palmeadas ?\n"
                        + "1 Si\n"
                        + "2 No"));
                if(o3==1){
                    o4 = Byte.parseByte(JOptionPane.showInputDialog("Hace cuaac ?\n"
                        + "1 Si\n"
                        + "2 No"));
                    if(o4==1){
                        
                        Webcam webcam = Webcam.getDefault();
                        webcam.open();
                        String name = String.format("test-%d.jpg", System.currentTimeMillis());
                        {
                            try {
                                ImageIO.write(webcam.getImage(), "JPG", new File(name));
                            } catch (IOException ex) {
                                Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.format("File %s has been saved\n", name);
                        JOptionPane.showMessageDialog(null,"La captura fue realizada");
                        ImageIcon image = new ImageIcon(name);
                        panel = new JLabel(image);
                        ver = new JFrame("Imagenen Capturada");
                        ver.setSize(400, 400);
                        ver.setVisible(true);
                        ver.add(panel);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El objetivo no es un pato, la captura nose se puede efectuar."); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "El objetivo no es un pato, la captura nose se puede efectuar."); 
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El objetivo no es un pato, la captura nose se puede efectuar.");
            }
        }
        //Acciones del boton Alejar
        if(e.getSource() == b2){
            Alejar in = new Alejar();
            in.setBounds(0, 0, 450, 640);
            in.setVisible(true);
            in.setResizable(false);
            in.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        //Acciones del boton Acercar
        if(e.getSource() == b3){
            Acercar in = new Acercar();
            in.setBounds(0, 0,450, 640);
            in.setVisible(true);
            in.setResizable(false);
            in.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        //Acciones del boton Encender
        if(e.getSource() == b4){
            scroll.setVisible(true);
            JOptionPane.showMessageDialog(null,"Encedido");
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
            b5.setVisible(true);
            b6.setVisible(true);
            b7.setVisible(true);
            b8.setVisible(true);
        }
        //Acciones del boton Apagar 
        if(e.getSource() == b5){
            scroll.setVisible(false);
            JOptionPane.showMessageDialog(null,"Apagado");
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b5.setVisible(false);
            b6.setVisible(false);
            b7.setVisible(false);
            b8.setVisible(false);
        }
        //Acciones del boton Flash
        if(e.getSource() == b6){
            JOptionPane.showMessageDialog(null,"Flash encendido");
        }
        //Acciones del boton Enfocar
        if(e.getSource() == b7){
            JOptionPane.showMessageDialog(null,"Enfocando");
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