/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

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
    
    public void keyPressed(KeyEvent e) {
        // Gérer l'appui d'une touche
        int keyCode = e.getKeyCode();

        // Exemple de gestion de l'appui des touches de direction
        if (keyCode == KeyEvent.VK_UP) {
            // Déplacer le personnage vers le haut
            this.haut = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Déplacer le personnage vers le bas
            this.bas = true;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            // Déplacer le personnage vers la gauche
            this.gauche = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Déplacer le personnage vers la droite
            this.droite = true;
        }
    }

    public void keyTyped(KeyEvent e) {
        // Gérer la frappe d'une touche (non utilisé dans cet exemple)
    }

    public void keyReleased(KeyEvent e) {
        // Gérer le relâchement d'une touche (non utilisé dans cet exemple)
    }

