/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;
/**
 *
 * @author mleconte
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MandyDeplacementJouable implements KeyListener {
    private int playerIndex;
    private int[][] CHARACTER_POSITIONS;

    public MandyDeplacementJouable (int playerIndex, int[][] CHARACTER_POSITIONS) {
        this.playerIndex = playerIndex;
        this.CHARACTER_POSITIONS = CHARACTER_POSITIONS;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        mouvementJouable(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Gestion des touches relâchées si nécessaire
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Pas utilisé, mais doit être implémenté en raison de l'interface KeyListener
    }

    // Déplacement du joueur avec les informations récupérées au niveau du clavier
    private void mouvementJouable(int keyCode) {
        int playerX = CHARACTER_POSITIONS[playerIndex][0];
        int playerY = CHARACTER_POSITIONS[playerIndex][1];

        int newPlayerX = playerX;
        int newPlayerY = playerY;

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                newPlayerX = playerX - 1;
                break;
            case KeyEvent.VK_RIGHT:
                newPlayerX = playerX + 1;
                break;
            case KeyEvent.VK_UP:
                newPlayerY = playerY - 1;
                break;
            case KeyEvent.VK_DOWN:
                newPlayerY = playerY + 1;
                break;
            default:
            // Ignorer les autres touches
            
        }
    }
    
// Mettre à jour l'affichage quand la mise à jour sur la partie moteur a fonctionné
    private void repaint() {
        
    }
}
