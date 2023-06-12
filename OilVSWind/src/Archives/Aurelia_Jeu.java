/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archives;

import ig.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author tmichel1
 */
public class Aurelia_Jeu extends JPanel {
//     private BufferedImage[] fond;
     private MapData Map;
    public Personnages joueur;

    public Aurelia_Jeu() {
//        try {
//            this.fond = ImageIO.read(getClass().getClassLoader().getResource("resources/fond.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
//        }

        this.joueur = new Personnages();
    }

    /**
    * Cette méthode est importante, c'est cool si vous respectez d'ailleurs ce format avec une méthode MiseàJour() et une méthode rendu(). C'est MiseàJour() qui va mettre à jour le jeu coté moteur et déplacer votre joueur coté IG.
    */
    public void miseAJour() {
        this.joueur.miseAJour();
    }

    /**
    * Maitnenant que vous avez changé du coté "console" votre jeu (avec MiseàJour()) bah...il faut l'afficher. C'est ce que fait rendu()
   * @param contexte
    */
    public void rendu(Graphics2D contexte) {
        joueur.paintComponent(contexte);
//        this.Map.afficherMap();
        
    }
    
//  public void paintComponent(Graphics g) {
//    super.paintComponent(g);
//
//    for (int y = 0; y < Map.getMAP_HEIGHT(); y++) {
//        for (int x = 0; x < Map.getMAP_WIDTH(); x++) {
//            int tileIndex = Map.getMAP_DATA()[y][x];
//            BufferedImage tile = Map.afficherMap()[tileIndex];
//
//            int xPos = x * Map.getTILE_SIZE();
//            int yPos = y * Map.getTILE_SIZE();
//
//            g.drawImage(tile, xPos, yPos, null);
//        }
//    }
//
//    // Dessiner les personnages
//    int[][] CHARACTER_POSITIONS= (int[][]) joueur.getCHARACTER_POSITIONS();
//    for (int i = 0; i < CHARACTER_POSITIONS.length; i++) {
//        int characterX = CHARACTER_POSITIONS[i][0];
//        int characterY = CHARACTER_POSITIONS[i][1];
//        
//        
//
//        int characterXPos = characterX * Map.getTILE_SIZE();
//        int characterYPos = characterY * Map.getTILE_SIZE();
//        
//
//        // Dessiner le sprite du personnage à la position spécifiée
//        BufferedImage characterSprite = joueur.characterSprites[i];
//        g.drawImage(characterSprite, characterXPos, characterYPos,  null);
//    }
//}

    
    
}
