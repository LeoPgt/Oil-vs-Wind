/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mleconte
 */

public class MandySprites {
   private static final int TILE_SIZE = 40; // Taille des tuiles en pixels
   private static final int NUM_CHARACTER_SPRITES = 4; // Nombre total de sprites de personnages
   private BufferedImage tileset;
   private BufferedImage[] tiles;
   private BufferedImage[] characterSprites;
   
// Charge les sprites des personnages à partir de fichiers d'images.
    private void loadSprites() {
            int numTiles = tileset.getWidth() / TILE_SIZE;
            tiles = new BufferedImage[numTiles];
            for (int i = 0; i < numTiles; i++) {
                tiles[i] = tileset.getSubimage(i * TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
            }
    
            characterSprites = new BufferedImage[NUM_CHARACTER_SPRITES];
            try {
                characterSprites[0] = ImageIO.read(new File("perso.png")); // Chargement du sprite du personnage
            } catch (IOException ex) {
                Logger.getLogger(DispayBisTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[1] = ImageIO.read(new File("baril_rouge.png")); // Chargement du sprite du baril rouge
            } catch (IOException ex) {
                Logger.getLogger(DispayBisTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[2] = ImageIO.read(new File("baril_jaune.png")); // Chargement du sprite du du baril jaune
            } catch (IOException ex) {
                Logger.getLogger(DispayBisTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[3] = ImageIO.read(new File("baril_bleu.png")); // Chargement du sprite du du baril bleu
            } catch (IOException ex) {
                Logger.getLogger(DispayBisTest.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    // Méthode qui permet de récupérer le sprite d'un personnage donné
    public BufferedImage getSprite(int spriteIndex) {
        // Vérification de l'index du sprite
        if (spriteIndex >= 0 && spriteIndex < characterSprites.length) {
            return characterSprites[spriteIndex];
        } else {
            throw new IllegalArgumentException("Index de sprite invalide : " + spriteIndex);
        }
    }
    
}
