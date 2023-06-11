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
 * @author Brayan
 */
public class Acercarx2 extends JFrame implements ActionListener{

    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JTextArea area;
    private JScrollPane scroll;
    private JFrame ver;
    private JLabel panel;
    
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
        
        b7 = new JButton("Enfocar");
        b7.setBounds(320,15,90,30);
        b7.addActionListener(this);
        add(b7);
        
        scroll = new JScrollPane(panel);
        scroll.setBounds(0,55,550, 450);
        scroll.setVisible(true);
        add(scroll);
    }
    
    
    public void actionPerformed(ActionEvent e){
        
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
        
        if(e.getSource() == b2){
            Alejar in = new Alejar();
            in.setBounds(0, 0, 450, 640);
            in.setVisible(true);
            in.setResizable(false);
            in.setLocationRelativeTo(null);
            this.setVisible(false);
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
            b7.setVisible(true);
        }
        
        if(e.getSource() == b5){
            scroll.setVisible(false);
            JOptionPane.showMessageDialog(null,"Apagado");
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b5.setVisible(false);
            b6.setVisible(false);
            b7.setVisible(false);
        }
        
        if(e.getSource() == b6){
            JOptionPane.showMessageDialog(null,"Flash encendido");
        }
        
        if(e.getSource() == b7){
            JOptionPane.showMessageDialog(null,"Enfocando");
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
