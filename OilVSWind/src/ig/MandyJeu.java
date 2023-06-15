/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author mleconte
 */
public class MandyJeu {

        private boolean running;
        private GraphicsInterface graphicsInterface;
        private Player player;
    
// Initialise le jeu, crée les instances nécessaires, configure l'interface utilisateur et lance la boucle de jeu.
    public void startGame() {
        // Initialisation du jeu
        graphicsInterface = new GraphicsInterface();
        player = new Player();

        // Configuration de l'interface utilisateur
        graphicsInterface.registerInputListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                processInput(keyCode);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                processInput(keyCode);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Pas nécessaire pour cette utilisation
            }
        });

        // Lancement de la boucle de jeu
        running = true;
        gameLoop();
    }
    
// Boucle principale du jeu, gère la logique du jeu et met à jour l'état du jeu à chaque itération.
    public void gameLoop() {
        while (running) {
            update();
            render();
        }
    }
    
// Affiche l'état actuel du jeu à l'écran en utilisant une instance de la classe d'interface graphique.
    public void render() {
        graphicsInterface.clearScreen();
        // Affichage de l'état actuel du jeu en utilisant l'interface graphique
        // ...
        graphicsInterface.repaint();
    }
    
// Met à jour l'état du jeu en fonction des entrées de l'utilisateur et de la logique du jeu.
    public void update() {
        // Mise à jour de l'état du jeu en fonction des entrées de l'utilisateur et de la logique du jeu
        // ...
    }

    public void processInput(int keyCode) {
        player.move(keyCode); // Transmet la touche enfoncée au joueur pour le déplacer
    }
}