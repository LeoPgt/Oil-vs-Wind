/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import moteur .*;

/**
 *
 * @author m.leconte
 */

public class EcouteurClavier implements KeyListener {
    
    private Jeu jeu;

    public EcouteurClavier(JeuIG jeuIG) {
        this.jeu = jeu;
    }
    
    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode()  == evt.VK_LEFT ) {
            this.jeu.setGauche(true);
        } else if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.jeu.setDroite(true);
        } else if (evt.getKeyCode()  == evt.VK_UP)) {
            this.jeu.setHaut(true);
        } else if (evt.getKeyCode()  == evt.VK_DOWN)) {
            this.jeu.setBas(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.jeuIG.avatar.setDroite(false);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.jeuIG.avatar.setGauche(false);
        }
    }
    

    @Override
    public void keyTyped(KeyEvent event) {
        //Nothing to do here !
    }


}
