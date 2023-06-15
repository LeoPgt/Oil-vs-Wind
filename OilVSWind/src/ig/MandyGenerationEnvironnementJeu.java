/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

/**
 *
 * @author mleconte
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

        
public class MandyGenerationEnvironnementJeu extends JFrame {
   
   private static final int MAP_WIDTH = 40; // Largeur de la carte en tuiles
   private static final int MAP_HEIGHT = 25; // Hauteur de la carte en tuiles
  
   private static final int[][] MAP_DATA = {
        
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1},
        {1,2,2,1,1,1,1,2,2,2,2,2,2,2,1,1,1,2,2,2,2,2,1,1,1,2,2,2,2,2,2,2,2,1,1,1,1,2,2,1},
        {1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1},
        {1,2,2,1,2,2,2,2,2,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,1,2,2,2,2,2,1,2,2,1},
        {1,2,2,1,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,1},
        {1,2,2,2,2,2,2,2,2,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,1,1,2,2,2,2,1,1,1,2,2,2,2,2,1,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,1,1,1,1,2,2,1,2,2,2,2,2,2,2,2,1,2,2,1,1,1,1,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,2,2,2,2,1},
        {1,2,2,2,2,2,2,1,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,1,1,1,1,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,1},
        {1,2,2,2,2,2,1,2,2,1,2,2,1,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,1,1,1,1,1,1,1,2,2,2,2,1},
        {1,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        
            
    };
   


    
    
    private void loadTileset() {
            try {
                tileset = ImageIO.read(new File("brick.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int y = 0; y < MAP_HEIGHT; y++) {
                for (int x = 0; x < MAP_WIDTH; x++) {
                    int tileIndex = MAP_DATA[y][x];
                    BufferedImage tile = tiles[tileIndex];

                    int xPos = x * TILE_SIZE;
                    int yPos = y * TILE_SIZE;

                    g.drawImage(tile, xPos, yPos, null);
                }
            }
            // Dessiner les personnages
    for (int i = 0; i < positionCaractère.length; i++) {
        int characterX = positionCaractère[i][0];
        int characterY = positionCaractère[i][1];
        
        

        int characterXPos = characterX * TILE_SIZE;
        int characterYPos = characterY * TILE_SIZE;
        

        // Dessiner le sprite du personnage à la position spécifiée
        BufferedImage characterSprite = characterSprites[i];
        g.drawImage(characterSprite, characterXPos, characterYPos,  null);
    }    
        }
    }
    Classe principale (Main) :
        Méthode main() : Point d'entrée de l'application. Crée une instance de la classe de jeu et lance le jeu.

   

    Classe d'interface graphique (GraphicsInterface) :
        Méthode initializeWindow() : Crée et configure la fenêtre de l'interface graphique.
        Méthode renderGame() : Dessine les éléments du jeu sur la fenêtre.
        Méthode updateGame() : Met à jour les éléments du jeu en fonction de l'état actuel du jeu.

    Classe de la carte du jeu (GameMap) :
        Méthode loadMap() : Charge les données de la carte à partir d'un fichier ou les génère aléatoirement.
        Méthode isValidPosition(x, y) : Vérifie si une position donnée sur la carte est valide.
        Méthode getTileAt(x, y) : Récupère le type de tuile à une position donnée sur la carte.

    Classe du joueur (Player) :
        Méthode move(direction) : Déplace le joueur dans une direction donnée.
        Méthode interact() : Gère les interactions du joueur avec les objets du jeu.

   



    Classe d'interface graphique (GraphicsInterface) :
        Méthode initializeWindow() : Crée et configure la fenêtre de l'interface graphique.
        Méthode renderGame() : Dessine les éléments du jeu sur la fenêtre.
        Méthode updateGame() : Met à jour les éléments du jeu en fonction de l'état actuel du jeu.

    Classe de la carte du jeu (GameMap) :
        Méthode loadMap() : Charge les données de la carte à partir d'un fichier ou les génère aléatoirement.
        Méthode isValidPosition(x, y) : Vérifie si une position donnée sur la carte est valide.
        Méthode getTileAt(x, y) : Récupère le type de tuile à une position donnée sur la carte.

    Classe du joueur (Player) :
        Méthode move(direction) : Déplace le joueur dans une direction donnée.
        Méthode interact() : Gère les interactions du joueur avec les objets du jeu.

    Classe des sprites (Sprite) :
        Méthode loadSprites() : Charge les sprites des personnages à partir de fichiers d'images.
        Méthode getSprite(spriteIndex) : Récupère le sprite d'un personnage donné.