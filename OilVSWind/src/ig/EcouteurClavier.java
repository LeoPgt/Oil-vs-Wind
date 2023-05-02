/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author tmichel1
 */
public class EcouteurClavier implements KeyListener {
 private int x = 350; // coordonnée x du dessin
 private int y = 150; // coordonnée y du dessin
   

    
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
     
    }

    public void keyReleased(KeyEvent e) {
        // Ne fait rien
    }

    public void keyTyped(KeyEvent e) {
        // Ne fait rien
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
   
    }
    

