/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author tmichel1
 */
public class Personnages {
    
    private BufferedImage sprite;
    protected double x, y;
    private boolean gauche, droite, haut, bas;
    private static final int NUM_CHARACTER_SPRITES = 4; // Nombre total de sprites de personnages
    private BufferedImage[] characterSprites;
    private BufferedImage tileset;

    public Personnages() {
        
        this.x = 100;
        this.y = 150;
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        
    }
    
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }
    
    public void setHaut(boolean haut) {
        this.haut = haut;
    }
    
    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public void miseAJour() {
        if (this.gauche) {
            x -= 5;
        }
        if (this.droite) {
            x += 5;
        }
        if (this.haut) {
            y += 5;
        }
        if (this.bas) {
            y -= 5;
        }
        if (x > 607-52) {
            x = 607-52;
        }
        if (x < 0) {
            x = 0;
        }
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.sprite, (int) x, (int) y, null);
    }

    
           private void loadTiles() {
//            int numTiles = tileset.getWidth() / TILE_SIZE;
//            tiles = new BufferedImage[numTiles];
//            for (int i = 0; i < numTiles; i++) {
//                tiles[i] = tileset.getSubimage(i * TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
//            }
    
            characterSprites = new BufferedImage[NUM_CHARACTER_SPRITES];
            try {
                characterSprites[0] = ImageIO.read(new File("perso.png")); // Chargement du sprite du personnage 
            } catch (IOException ex) {
                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[1] = ImageIO.read(new File("baril_rouge.png")); // Chargement du sprite du baril rouge
            } catch (IOException ex) {
                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[2] = ImageIO.read(new File("baril_jaune.png")); // Chargement du sprite du du baril jaune
            } catch (IOException ex) {
                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                characterSprites[3] = ImageIO.read(new File("baril_bleu.png")); // Chargement du sprite du du baril bleu
            } catch (IOException ex) {
                Logger.getLogger(DisplayMap.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        
}
