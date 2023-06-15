/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;
/**
 *
 * @author mleconte
 */
import moteur.Regles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MandyClavier implements KeyListener {

    private Regles regles;

    public MandyClavier(Regles regles) {
        this.regles = regles;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                regles.setGauche(true);
                break;
            case KeyEvent.VK_RIGHT:
                regles.setDroite(true);
                break;
            case KeyEvent.VK_UP:
                regles.setHaut(true);
                break;
            case KeyEvent.VK_DOWN:
                regles.setBas(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                regles.setGauche(false);
                break;
            case KeyEvent.VK_RIGHT:
                regles.setDroite(false);
                break;
            case KeyEvent.VK_UP:
                regles.setHaut(false);
                break;
            case KeyEvent.VK_DOWN:
                regles.setBas(false);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // pas utilisé mais doit être implémenté à cause de l'interface KeyListener
    }
}
