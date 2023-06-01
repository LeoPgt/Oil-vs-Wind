/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;




public class EcouteurClavier2 extends JPanel implements KeyListener {
     private int[][] characterPositions = {
        {2, 4}, // Position du personnage 1
        {7, 6}, // Position du personnage 2
        // ...
    };

    private int[] characterDx = new int[NUM_CHARACTERS];
    private int[] characterDy = new int[NUM_CHARACTERS];
    private int[] characterDirection = new int[NUM_CHARACTERS];

    private boolean running = true;
    private static final int FPS = 60;
    private static final long FRAME_TIME = 1000L / FPS;

    public EcouteurClavier2() {
        // ...

        // Démarrer la boucle d'animation
        new Thread(() -> {
            long startTime;
            long elapsedTime;
            while (running) {
                startTime = System.currentTimeMillis();

                // Mettre à jour les positions des personnages
                updateCharacterPositions();

                // Redessiner l'affichage
                repaint();

                elapsedTime = System.currentTimeMillis() - startTime;

                // Attendre pour atteindre le temps de rafraîchissement cible
                if (elapsedTime < FRAME_TIME) {
                    try {
                        Thread.sleep(FRAME_TIME - elapsedTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void updateCharacterPositions() {
        for (int i = 0; i < NUM_CHARACTERS; i++) {
            int characterX = characterPositions[i][0];
            int characterY = characterPositions[i][1];
        }
    }}
       
