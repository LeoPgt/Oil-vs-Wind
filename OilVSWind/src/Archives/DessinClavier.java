package Archives;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tmichel1
 */   
import ig.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class DessinClavier extends JPanel implements ActionListener{
    private int x; // coordonnée x du dessin
    private int y; // coordonnée y du dessin
    EcouteurClavier L;
    private Timer timer;



    public DessinClavier() {
        //this.L = new EcouteurClavier();
        this.x = 350;
        this.y= 150;
        addKeyListener(L);
        setFocusable(true);
        this.timer = new Timer(1, (ActionListener) this);
        this.timer.start();
    }
    
//    public void MiseAJour(int x, int y){
//        
//        this.x = L.getX();
//        this.y = L.getY();    
//    }
    
    public void actionPerformed(ActionEvent e) {
            //this.x = L.getX();
            //this.y = L.getY();
            System.out.println(this.x);
            System.out.println(this.y);
//            this..repaint();
    }

    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50); // dessine un cercle rouge de 50x50 pixels
        g.drawRect(200, 100,600, 500);
        
    }
    

//    public void keyPressed(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        switch (keyCode) {
//        case KeyEvent.VK_UP:
//            y -= 10; // déplace le dessin vers le haut
//            break;
//        case KeyEvent.VK_DOWN:
//            y += 10; // déplace le dessin vers le bas
//            break;
//        case KeyEvent.VK_LEFT:
//            x -= 10; // déplace le dessin vers la gauche
//            break;
//        case KeyEvent.VK_RIGHT:
//            x += 10; // déplace le dessin vers la droite
//            break;
//        }
//        repaint(); // redessine le JPanel pour afficher le dessin à sa nouvelle position
//    }
//
//    public void keyReleased(KeyEvent e) {
//        // Ne fait rien
//    }
//
//    public void keyTyped(KeyEvent e) {
//        // Ne fait rien
//    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Dessin Clavier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.addKeyListener(new EcouteurClavier());
        DessinClavier dessin = new DessinClavier();
        frame.add(dessin);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        
        
        
    }
    
}

