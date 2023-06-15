/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author rmorel
 */
public class igMethode {
    private boolean gauche = false;
    private boolean droite = false;
    private  boolean haut = false;
    private boolean bas = false;
     private static int [][] positionCaractère ={
    {2, 2}, // Position du personnage
    {5, 5},  // Position du baril rouge
    {8, 8},  // Position du baril jaune
    {12, 12}  // Position du baril bleu  
    };
    private static final int TILE_SIZE = 40; // Taille des tuiles en pixels
    private static final int MAP_WIDTH = 40; // Largeur de la carte en tuiles
    private static final int MAP_HEIGHT = 25; // Hauteur de la carte en tuiles
    private static final int NUM_CHARACTER_SPRITES = 4; // Nombre total de sprites de personnages
    private static final int[][] MAP_DATA = {
        
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
        {2,0,0,2,2,2,2,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,2,2,2,2,0},
        {2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
        {2,0,0,2,0,0,0,0,0,2,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,2,0,0,0,0,2,0,0},
        {2,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,2,0,0},
        {2,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,2,2,0,0,0,0,2,2,2,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,2,2,2,2,0,0,2,0,0,0,0,0,0,0,0,2,0,0,2,2,2,2,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,2},
        {2,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,2,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,2,2,2,2,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,2},
        {2,0,0,0,0,0,2,0,0,2,0,0,2,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,2},
        {2,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    
    // modifie  les positions des "sprites"
    public void setPosition (int x, int y,int playerIndex){
        positionCaractère[playerIndex][0] = x;
        positionCaractère[playerIndex][1] = y;
    }

    // recupère toutes le s positions pour l'envoie SQL
    public static int[][] getPositionCaractère() {
        return positionCaractère;
    }
    
        public static int getMAP_WIDTH() {
        return MAP_WIDTH;
    }

    public static int getMAP_HEIGHT() {
        return MAP_HEIGHT;
    }

    public static int[][] getMAP_DATA() {
        return MAP_DATA;
    }
//    public boolean movePlayer(int keyCode, int playerIndex, boolean possible) {
//     // L'index du joueur à déplacer (ici, le personnage principal)
//        boolean redessiner = false;
//        int playerX = positionCaractère[playerIndex][0];
//        int playerY = positionCaractère[playerIndex][1];
//
//        int newPlayerX = playerX;
//        int newPlayerY = playerY;
//
//        switch (keyCode) {
//            case KeyEvent.VK_LEFT:
//                
//                newPlayerX = playerX - 1;
//                break;
//            case KeyEvent.VK_RIGHT:
//                newPlayerX = playerX + 1;
//                break;
//            case KeyEvent.VK_UP:
//                newPlayerY = playerY - 1;
//                break;
//            case KeyEvent.VK_DOWN:
//                newPlayerY = playerY + 1;
//                break;
////            default:
////                return; // Ignorer les autres touches
//        }
//        // Vérifier si la nouvelle position est valide
//    if (possible) {
//        positionCaractère[playerIndex][0] = newPlayerX;
//        positionCaractère[playerIndex][1] = newPlayerY;
//        redessiner = true;
//    }
//    else{redessiner = false;}
//    return redessiner;
//    }

    public static class MapPanel extends JPanel implements KeyListener{

    private BufferedImage tileset;
    private BufferedImage[] tiles;
    private BufferedImage[] characterSprites;
    private int speed; // Vitesse du joueur



    public MapPanel() {
        loadTileset();
        loadTiles();
        setPreferredSize(new Dimension(MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
        @Override

        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println("keyCode=" + keyCode);
            int playerIndex = 0; //int playerIndex= Jeu.ChoixJoueur() qui retourne le numero du joueur choisi par l'utilisateur
    }
    });
        }
        @Override
        public void keyPressed(KeyEvent e) {
             int keyCode = e.getKeyCode();
             processKeyInput(keyCode);
}
        public void processKeyInput(int keyCode) {
        // Code pour traiter l'entrée de la touche
    }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            processKeyInput(keyCode);
    }
    

        @Override
        public void keyTyped(KeyEvent e) {
    // Pas nécessaire pour cette utilisation, mais doit être implémentée en raison de l'interface
        }
    private void loadTileset() {
            try {
                tileset = ImageIO.read(new File("brick.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void loadTiles() {
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

}
