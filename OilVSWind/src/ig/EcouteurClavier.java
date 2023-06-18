/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import moteur.*;

/**
 *
 * @author manal.benaissa
 */

public class EcouteurClavier implements KeyListener {
    
    private JeuIG jeu;

    public EcouteurClavier(JeuIG jeu) {
        this.jeu = jeu;
    }
    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                jeu.getAvatar().setHaut(true);
                break;
            case KeyEvent.VK_DOWN:
                jeu.getAvatar().setBas(true);
                break;
            case KeyEvent.VK_LEFT:
                jeu.getAvatar().setGauche(true);
                break;
            case KeyEvent.VK_RIGHT:
                jeu.getAvatar().setDroite(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                jeu.getAvatar().setHaut(false);
                break;
            case KeyEvent.VK_DOWN:
                jeu.getAvatar().setBas(false);
                break;
            case KeyEvent.VK_LEFT:
                jeu.getAvatar().setGauche(false);
                break;
            case KeyEvent.VK_RIGHT:
                jeu.getAvatar().setDroite(false);
                break;
        }
    }
}
