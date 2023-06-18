/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archives;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import moteur.*;


public class MandyInterfaceGraphique extends JFrame implements ActionListener, KeyListener {
    private Jeu jeu;
    private BufferedImage backgroundImage;
    private BufferedImage briqueMurImage;
    private BufferedImage briqueSableImage;
    private BufferedImage spotImage;
    private BufferedImage runnerImage;
    private BufferedImage baril1Image;
    private BufferedImage baril2Image;
    private BufferedImage baril3Image;
    private JLabel jLabel1;
    private boolean jeuCommence;
    private final Timer timer;
    private final BufferedImage framebuffer;
    private final Graphics2D contexte;
    private JButton buttonJoueur;

    public MandyInterfaceGraphique() {
        // Initialisation de la fenêtre
        setTitle("OIL VS WIND");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jLabel1 = new JLabel();
        jeuCommence = false;

        // Configuration du panel de dessin
        jLabel1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
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

        // Charger les images
        try {
            backgroundImage = ImageIO.read(new File("src/resource/fonddentreedujeu.PNG"));
            briqueMurImage = ImageIO.read(new File("src/resource/brique_mur.PNG"));
            briqueSableImage = ImageIO.read(new File("src/resource/brique_sable.PNG"));
            runnerImage = ImageIO.read(new File("src/resource/perso.png"));
            baril1Image = ImageIO.read(new File("src/resource/baril_jaune.png"));
            baril2Image = ImageIO.read(new File("src/resource/baril_bleu.png"));
            baril3Image = ImageIO.read(new File("src/resource/baril_rouge.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
      
        this.framebuffer = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();

        // Creation du jeu
        this.jeu = new Jeu();

        // Configuration du bouton "Joueur"
        buttonJoueur = new JButton("Jouer");
        buttonJoueur.addActionListener(this);

        // Ajout des composants à la fenêtre
        getContentPane().add(buttonJoueur, BorderLayout.SOUTH);
        getContentPane().add(jLabel1, BorderLayout.CENTER);

        // Configuration du Timer
        this.timer = new Timer(1000, this);
        this.timer.start();

        // Ajout d'un écouteur clavier
        this.addKeyListener(this);

        // Configuration de la fenêtre
        pack();
        setVisible(true);
        jLabel1.setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonJoueur) {
            String pseudo = JOptionPane.showInputDialog("Entrez votre pseudo");

            buttonJoueur.setVisible(false);
            jeuCommence = true;
            repaint();
        } else if (jeuCommence) {
            jeu.partieMoteurV2();
            DessinerCarte(contexte);
        
            //Ca c'est juste pour appliquer le rendu()
            this.jLabel1.repaint();
            
            if (jeu.partieMoteurV2()) {
                timer.stop();
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
        
    private void DessinerCarte(Graphics g) {
        int largeurCase = getWidth() / jeu.getCarteMoteur().getLargeur();
        int hauteurCase = getHeight() / jeu.getCarteMoteur().getHauteur();
        
        // Ajouter la ligne de débogage ici
        System.out.println("Width: " + getWidth() + ", Height: " + getHeight());
        
        for (int i = 0; i < jeu.getCarteMoteur().getLargeur(); i++) {
            for (int j = 0; j < jeu.getCarteMoteur().getHauteur(); j++) {
                Element element = jeu.laCaseDeCoordonnees(i, j);

                if (element instanceof Mur) {
                    g.drawImage(briqueMurImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Runner) { // Dessiner l'image du runner à la position correspondante
                    g.drawImage(runnerImage, jeu.runner.getX() * largeurCase, jeu.runner.getY() * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Baril) {
                    Baril baril_element = (Baril)element;
                    int index = jeu.getBarrilJoueur().indexOf(baril_element); 
                    switch (index) {
                        case 0:
                            g.drawImage(baril1Image, jeu.getBarrilJoueur().get(index).getX() * largeurCase, jeu.getBarrilJoueur().get(index).getY()  * hauteurCase, largeurCase, hauteurCase, null); // dessiner l'image du barril à la position correspondante
                            break;
                        case 1:
                            g.drawImage(baril2Image, jeu.getBarrilJoueur().get(index).getX() * largeurCase, jeu.getBarrilJoueur().get(index).getY()  * hauteurCase, largeurCase, hauteurCase, null);
                            break;
                        case 2:
                            g.drawImage(baril3Image, jeu.getBarrilJoueur().get(index).getX() * largeurCase, jeu.getBarrilJoueur().get(index).getY() * hauteurCase, largeurCase, hauteurCase, null);
                            break;
                        default:
                            break;
                    }
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
            g.drawImage(spotImage, x_spot* largeurCase, y_spot * hauteurCase,largeurCase, hauteurCase, null);
        }
    }

    public static void main(String[] args) {
        MandyInterfaceGraphique gui = new MandyInterfaceGraphique();
        gui.setVisible(true);
        gui.jLabel1.setFocusable(true);
    }
}


