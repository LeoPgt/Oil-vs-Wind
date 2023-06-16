/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import moteur.*;

/**
 *
 * @author mleconte
 */
public class MandyInterfaceGraphique extends Application {
    private static final String PATH_TO_RESOURCES = "src/resource/";
    private static final int TILE_SIZE = 40;
    private static final int MAP_WIDTH = 40;
    private static final int MAP_HEIGHT = 25;
    private Jeu jeu;
    private Pane root;
    
        public void start(Stage primaryStage) {
            
        primaryStage.setTitle("Jeu Barils et Runner");
        jeu = new Jeu(); // Initialiser le jeu
        root = new Pane();
        Scene scene = new Scene(root, MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
        miseAJourInterfaceGraphique();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                jeu.setGauche(true);
            } else if (event.getCode() == KeyCode.RIGHT) {
                jeu.setDroite(true);
            } else if (event.getCode() == KeyCode.UP) {
                jeu.setHaut(true);
            } else if (event.getCode() == KeyCode.DOWN) {
                jeu.setBas(true);
            }

            jeu.partieMoteurV2(); // mettre à jour le jeu après chaque pression de touche
            miseAJourInterfaceGraphique(); // mettre à jour l'interface graphique après chaque mise à jour du jeu
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                jeu.setGauche(false);
            } else if (event.getCode() == KeyCode.RIGHT) {
                jeu.setDroite(false);
            } else if (event.getCode() == KeyCode.UP) {
                jeu.setHaut(false);
            } else if (event.getCode() == KeyCode.DOWN) {
                jeu.setBas(false);
            }
        });
    }

    private void miseAJourInterfaceGraphique() {
        root.getChildren().clear(); // nettoyer l'écran avant de dessiner la nouvelle image
        for (int i = 0; i < MAP_WIDTH; i++) {
            for (int j = 0; j < MAP_HEIGHT; j++) {
                Element element = jeu.laCaseDeCoordonnees(i, j);
                if (element != null) {
                    ImageView imageView = new ImageView();
                    imageView.setFitHeight(TILE_SIZE);
                    imageView.setFitWidth(TILE_SIZE);

                    String imageFile;

                    if(element instanceof Runner) {
                        imageFile = PATH_TO_RESOURCES + "perso.png";
                    } else if(element instanceof Baril) {
                        imageFile = PATH_TO_RESOURCES + "baril_rouge.png";
                        imageFile = PATH_TO_RESOURCES + "baril_jaune.png";
                        imageFile = PATH_TO_RESOURCES + "baril_bleu.png";
                    } else if(element instanceof Mur) {
                        imageFile = PATH_TO_RESOURCES + "brick.png";
                    } else if(element instanceof Bonus) {
                        imageFile = PATH_TO_RESOURCES + "bonus.png";
                    } else {
                        continue; // ignore non-visual elements
                    }

                    imageView.setImage(new Image(imageFile));
                    imageView.setX(i * TILE_SIZE);
                    imageView.setY(j * TILE_SIZE);
                    root.getChildren().add(imageView);
                }
            }
        }
    }
public void actionPerformed(ActionEvent e) {
                String pseudo = JOptionPane.showInputDialog("Entrez votre pseudo");
                jeu = new Jeu();
                // ici ajoutez le pseudo à votre jeu ou à votre base de données
            }
        });

        // Ajout des contrôles clavier
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        jeu.setHaut(true);
                        break;
                    case KeyEvent.VK_DOWN:
                        jeu.setBas(true);
                        break;
                    case KeyEvent.VK_LEFT:
                        jeu.setGauche(true);
                        break;
                    case KeyEvent.VK_RIGHT:
                        jeu.setDroite(true);
                        break;
                }
                jeu.partieMoteurV2(); // ou autre méthode pour mettre à jour l'état du jeu
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        jeu.setHaut(false);
                        break;
                    case KeyEvent.VK_DOWN:
                        jeu.setBas(false);
                        break;
                    case KeyEvent.VK_LEFT:
                        jeu.setGauche(false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        jeu.setDroite(false);
                        break;
                }
            }
        });

        // Configuration du panel de dessin
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // ici dessinez votre carte en utilisant les méthodes de Graphics
                // par exemple, pour dessiner une case mur:
                // g.drawRect(x, y, largeur, hauteur);
            }
        };

        // Ajout des composants à la fenêtre
        getContentPane().add(buttonJoueur, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

