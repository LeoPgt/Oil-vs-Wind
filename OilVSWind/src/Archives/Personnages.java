/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archives;

import ig.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author tmichel1
 */
public class Personnages extends JPanel {

//    private BufferedImage sprite;
    protected double x, y;
    private boolean gauche, droite;
    private static final int NUM_CHARACTER_SPRITES = 4; // Nombre total de sprites de personnages
    BufferedImage[] characterSprites;
    private MapData Map;
    
// BufferedImage image1= ImageIO.read(new File("baril_bleu.jpg"));
 
    public Personnages () {
       // characterSprites = new BufferedImage[NUM_CHARACTER_SPRITES];
//            try {
//                this.sprite = ImageIO.read(new File("perso1.png")); // Chargement du sprite du personnage 1
//            } catch (IOException ex) {
//                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
//            }
//          

           
            characterSprites = new BufferedImage[NUM_CHARACTER_SPRITES];
            try {
                characterSprites[0] = ImageIO.read(new File("perso.png")); // Chargement du sprite du personnage
            } catch (IOException ex) {
                Logger.getLogger(DisplayMapTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[1] = ImageIO.read(new File("baril_rouge.png")); // Chargement du sprite du baril rouge
            } catch (IOException ex) {
                Logger.getLogger(DisplayMapTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[2] = ImageIO.read(new File("baril_jaune.png")); // Chargement du sprite du du baril jaune
            } catch (IOException ex) {
                Logger.getLogger(DisplayMapTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[3] = ImageIO.read(new File("baril_bleu.png")); // Chargement du sprite du du baril bleu
            } catch (IOException ex) {
                Logger.getLogger(DisplayMapTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            try {
//                characterSprites[1] = ImageIO.read(new File("perso2.png")); // Chargement du sprite du personnage 2
//            } catch (IOException ex) {
//                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
//        try {
////            this.sprite = ImageIO.read(getClass().getClassLoader().getResource("ressources/baril.jpg"));
//            this.sprite = ImageIO.read(getClass().getClassLoader().getResource("resources/baril.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(Personnages.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.x = 100;
//        this.y = 150;
//        this.gauche = false;
//        this.droite = false;
    }

    
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public void miseAJour() {
        if (this.gauche) {
            x -= 5;
        }
        if (this.droite) {
            x += 5;
        }
        if (x > 607-52) {
            x = 607-52;
        }
        if (x < 0) {
            x = 0;
        }
    }

//    public void rendu(Graphics2D contexte) {
////        contexte[0]=image1;
////      return contexte;
//      contexte.drawImage(this.sprite, (int) x, (int) y, null);
//    }
//    
//    
//    public BufferedImage getSprite(){
//        return this.sprite;
//    }
    
    private static final int[][] CHARACTER_POSITIONS = {
        {2, 2}, // Position du personnage
        {5, 5},  // Position du baril rouge
        {8, 8},  // Position du baril jaune
        {12, 12}  // Position du baril bleu
    };
    

    public void paintComponent(Graphics g) {
    super.paintComponent(g);

    
    
    // Dessiner les personnages
    for (int i = 0; i < CHARACTER_POSITIONS.length; i++) {
        int characterX = CHARACTER_POSITIONS[i][0];
        int characterY = CHARACTER_POSITIONS[i][1];
        
        

        int characterXPos = characterX * Map.getTILE_SIZE();
        int characterYPos = characterY * Map.getTILE_SIZE();
    

        // Dessiner le sprite du personnage à la position spécifiée
        BufferedImage characterSprite = characterSprites[i];
        g.drawImage(characterSprite, characterXPos, characterYPos,  null);
        }
    }
    
void movePlayer(int keyCode) {
    int playerIndex = 0; // L'index du joueur à déplacer (ici, le personnage principal)

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
            return; // Ignorer les autres touches
    }

    // Vérifier si la nouvelle position est valide
    if (isValidPosition(newPlayerX, newPlayerY)) {
        CHARACTER_POSITIONS[playerIndex][0] = newPlayerX;
        CHARACTER_POSITIONS[playerIndex][1] = newPlayerY;
        repaint();
    }
}

private boolean isValidPosition(int x, int y) {
    // Vérifier si la position est à l'intérieur de la carte et si elle est traversable (pas un mur, etc.)
    return x >= 0 && x < Map.getMAP_WIDTH() && y >= 0 && y < Map.getMAP_HEIGHT() && Map.getMAP_DATA()[y][x] != 1;
}      

    Object getCHARACTER_POSITIONS() {
       return CHARACTER_POSITIONS;
    }

   
    
}

