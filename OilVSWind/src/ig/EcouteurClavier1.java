/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


/**
 *
 * @author tmichel1
 */
public class EcouteurClavier1 extends JPanel implements KeyListener{
    public EcouteurClavier1(){
        // Ajouter l'écouteur d'événements clavier à la classe MapPanel
        addKeyListener(this);
        setFocusable(true);
    }

    // Implémenter les méthodes de l'interface KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        // Gérer l'appui d'une touche
        int keyCode = e.getKeyCode();

        // Exemple de gestion de l'appui des touches de direction
        if (keyCode == KeyEvent.VK_UP) {
            // Déplacer le personnage vers le haut
            moveCharacter(0, -1);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Déplacer le personnage vers le bas
            moveCharacter(0, 1);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            // Déplacer le personnage vers la gauche
            moveCharacter(-1, 0);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Déplacer le personnage vers la droite
            moveCharacter(1, 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Gérer la frappe d'une touche (non utilisé dans cet exemple)
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Gérer le relâchement d'une touche (non utilisé dans cet exemple)
    }

    // ...


private static final int[][] CHARACTER_POSITIONS = {
        {2, 2}, // Position du personnage 
        {5, 5},  // Position du baril rouge
        {8, 8},  // Position du baril jaune
        {12, 12}  // Position du baril bleu
    };

 

private void moveCharacter(int dx, int dy) {
    // Obtenez la position du personnage actif (vous pouvez utiliser une variable pour suivre le personnage actif)
    int activeCharacter = 0; // Supposons que le personnage 1 est l'actif       
    int characterX = CHARACTER_POSITIONS[activeCharacter][0];
    int characterY = CHARACTER_POSITIONS[activeCharacter][1];

    // Calculez la nouvelle position du personnage
    int newCharacterX = characterX + dx;
    int newCharacterY = characterY + dy;

    // Vérifiez si la nouvelle position est valide (à l'intérieur des limites de la carte)
    if (isValidPosition(newCharacterX, newCharacterY)) {
        // Mettez à jour la position du personnage
        CHARACTER_POSITIONS[activeCharacter][0] = newCharacterX;
        CHARACTER_POSITIONS[activeCharacter][1] = newCharacterY;

        // Appelez repaint() pour redessiner l'affichage avec les nouvelles positions des personnages
        repaint();
    }
}

private boolean isValidPosition(int x, int y) {
    // Vérifiez si les coordonnées (x, y) sont à l'intérieur des limites de la carte
    return x >= 0 && x < MAP_WIDTH && y >= 0 && y < MAP_HEIGHT;
}

 
}
