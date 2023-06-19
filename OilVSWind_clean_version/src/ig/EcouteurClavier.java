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
    
    private JeuIG jeuIG;
    private JeuMoteur jeuMoteur;

    public EcouteurClavier(JeuIG jeuIG, JeuMoteur jeuMoteur) {
        this.jeuIG = jeuIG;
        this.jeuMoteur = jeuMoteur;
    }
    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                jeuIG.getAvatar().setHaut(true);
                break;
            case KeyEvent.VK_DOWN:
                jeuIG.getAvatar().setBas(true);
                break;
            case KeyEvent.VK_LEFT:
                jeuIG.getAvatar().setGauche(true);
                break;
            case KeyEvent.VK_RIGHT:
                jeuIG.getAvatar().setDroite(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                jeuIG.getAvatar().setHaut(false);
                break;
            case KeyEvent.VK_DOWN:
                jeuIG.getAvatar().setBas(false);
                break;
            case KeyEvent.VK_LEFT:
                jeuIG.getAvatar().setGauche(false);
                break;
            case KeyEvent.VK_RIGHT:
                jeuIG.getAvatar().setDroite(false);
                break;
        }
    }
}
