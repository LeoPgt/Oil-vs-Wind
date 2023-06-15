/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author rmorel
 */
public class InterfaceClavier {
    private boolean haut = false;
    private boolean bas = false;
    private boolean droite = false;
    private boolean gauche = false;
    

    public int keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        System.out.println("Key pressed - Key code: " + keyCode + ", Key char: " + keyChar);
        return keyCode;
    }

    public int keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        System.out.println("Key released - Key code: " + keyCode + ", Key char: " + keyChar);
        return keyCode;
    }


    public int keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        System.out.println("Key typed - Key char: " + keyChar);
        return keyChar;
    }
      private void movePlayer(int keyCode) {
     // L'index du joueur à déplacer (ici, le personnage principal)
    
    switch (keyCode) {
        case KeyEvent.VK_LEFT:
            this.gauche = true;
            break;
        case KeyEvent.VK_RIGHT:
            this.droite = true;
            break;
        case KeyEvent.VK_UP:
            this.haut = true;
            break;
        case KeyEvent.VK_DOWN:
            this.bas = true;
            break;
        default:
            return; // Ignorer les autres touches
    }
      }

    public boolean isHaut() {
        return haut;
    }

    public boolean isBas() {
        return bas;
    }

    public boolean isDroite() {
        return droite;
    }

    public boolean isGauche() {
        return gauche;
    }
  
}

