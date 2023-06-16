/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import moteur.*;

public class MandyInterfaceGraphique extends JFrame {
    private Jeu jeu;
    private BufferedImage backgroundImage;
    private BufferedImage briqueMurImage;
    private BufferedImage briqueSableImage;
    private BufferedImage spotImage;
    private BufferedImage runnerImage;
    private BufferedImage baril1Image;
    private BufferedImage baril2Image;
    private BufferedImage baril3Image;
    private JPanel panel;
    private boolean jeuCommence;

    public MandyInterfaceGraphique() {
        setTitle("OIL VS WIND");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jeuCommence = false;

        try {
            backgroundImage = ImageIO.read(new File("src/resource/fonddentreedujeu.PNG"));
            briqueMurImage = ImageIO.read(new File("src/resource/brique_mur.PNG"));
            briqueSableImage = ImageIO.read(new File("src/resource/brique_sable.PNG"));
            // Charger les images des personnages
            runnerImage = ImageIO.read(new File("src/resource/perso.png"));
            baril1Image = ImageIO.read(new File("src/resource/baril_jaune.png"));
            baril2Image = ImageIO.read(new File("src/resource/baril_bleu.png"));
            baril3Image = ImageIO.read(new File("src/resource/baril_rouge.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configuration du bouton "Joueur"
        JButton buttonJoueur = new JButton("Jouer");
        buttonJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pseudo = JOptionPane.showInputDialog("Entrez votre pseudo");
                jeu = new Jeu();
                // Ajoutez ici le pseudo à votre jeu ou à votre base de données

                // Masquer le bouton "Joueur"
                buttonJoueur.setVisible(false);

                // Rafraîchir l'affichage de la fenêtre
                repaint();

                // Le jeu commence
                jeuCommence = true;
            }
        });

        // Ajout des contrôles clavier
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (jeuCommence) {
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
                    // Rafraîchir l'affichage de la fenêtre
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (jeuCommence) {
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
            }
        });

        // Configuration du panel de dessin
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (!jeuCommence) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                } else {
                    DessinerCarte(g);
                // Dessiner les spots
                try {
                    dessinerSpots(g);
                } catch (IOException ex) {
                    Logger.getLogger(MandyInterfaceGraphique.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        };

        // Ajout des composants à la fenêtre
        getContentPane().add(buttonJoueur, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void DessinerCarte(Graphics g) {
        int largeurCase = getWidth() / jeu.getCarteMoteur().getLargeur();
        int hauteurCase = getHeight() / jeu.getCarteMoteur().getHauteur();

        for (int i = 0; i < jeu.getCarteMoteur().getLargeur(); i++) {
            for (int j = 0; j < jeu.getCarteMoteur().getHauteur(); j++) {
                Element element = jeu.laCaseDeCoordonnees(i, j);

                if (element instanceof Mur) {
                    g.drawImage(briqueMurImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Runner) {
                    g.drawImage(runnerImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Baril) {
                    g.drawImage(baril1Image, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else {
                    g.drawImage(briqueSableImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                }
            }
        }  
    }
    
    private void dessinerSpots(Graphics g) throws IOException {
        int largeurCase = getWidth() / jeu.getCarteMoteur().getLargeur();
        int hauteurCase = getHeight() / jeu.getCarteMoteur().getHauteur();
        
        // Charger l'image du spot
        spotImage = ImageIO.read(new File("src/resource/brique_spot.PNG"));
        // Parcourir la liste des spots dans la carte du jeu
        for (int i = 0; i < jeu.getCarteMoteur().getSpots().size(); i++) {
            int x_spot = jeu.CarteMoteur.getSpots().get(i).getX();
            int y_spot = jeu.CarteMoteur.getSpots().get(i).getY();

            // Dessiner l'image du spot à la position correspondante
            g.drawImage(spotImage, x_spot * largeurCase, y_spot * hauteurCase, null);
        }
    }

    public static void main(String[] args) {
        MandyInterfaceGraphique gui = new MandyInterfaceGraphique();
        gui.setVisible(true);
        gui.panel.setFocusable(true);
    }
}


