/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archives;

import ig.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 *
 * @author tmichel1
 */
public class EcouteurClavier implements KeyListener {
    
     private Aurelia_Jeu jeu;

    public EcouteurClavier(Aurelia_Jeu jeu) {
        this.jeu = jeu;
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.jeu.joueur.setDroite(true);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.jeu.joueur.setGauche(true);
        }
//        if (evt.getKeyCode() == evt.VK_UP) {
//            this.jeu.joueur.setHaut(true);
//        }
//        if (evt.getKeyCode() == evt.VK_DOWN) {
//            this.jeu.joueur.setBas(true);
//        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.jeu.joueur.setDroite(false);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.jeu.joueur.setGauche(false);
        }
//        if (evt.getKeyCode() == evt.VK_UP) {
//            this.jeu.joueur.setHaut(false);
//        }
//        if (evt.getKeyCode() == evt.VK_DOWN) {
//            this.jeu.joueur.setBas(false);
//        }
    }
    

    @Override
    public void keyTyped(KeyEvent event) {
        //Nothing to do here !
    }
    
    
// private int x = 350; // coordonnée x du dessin
// private int y = 150; // coordonnée y du dessin
//   
//
//    
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
//     
//    }
//
//    public void keyReleased(KeyEvent e) {
//        // Ne fait rien
//    }
//
//    public void keyTyped(KeyEvent e) {
//        // Ne fait rien
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    
   
    }
    

