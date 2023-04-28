package ig;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tmichel1
 */   
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DessinClavier extends JPanel implements KeyListener {
    private int x = 350; // coordonnée x du dessin
    private int y = 150; // coordonnée y du dessin



    public DessinClavier() {
        addKeyListener(this);
        setFocusable(true);
    }
    
//       public void paint(Graphics r){
//    r.drawRect(200, 100, 900, 600);  
//     }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50); // dessine un rectangle rouge de 50x50 pixels
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
        case KeyEvent.VK_UP:
            y -= 10; // déplace le dessin vers le haut
            break;
        case KeyEvent.VK_DOWN:
            y += 10; // déplace le dessin vers le bas
            break;
        case KeyEvent.VK_LEFT:
            x -= 10; // déplace le dessin vers la gauche
            break;
        case KeyEvent.VK_RIGHT:
            x += 10; // déplace le dessin vers la droite
            break;
        }
        repaint(); // redessine le JPanel pour afficher le dessin à sa nouvelle position
    }

    public void keyReleased(KeyEvent e) {
        // Ne fait rien
    }

    public void keyTyped(KeyEvent e) {
        // Ne fait rien
    }
    
  

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dessin Clavier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DessinClavier dessin = new DessinClavier();
        frame.add(dessin);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}

