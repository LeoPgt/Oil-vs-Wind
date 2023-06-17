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
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        setSize(3240, 1680);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jeuCommence = false;
        
        // Configuration du panel de dessin
        jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(1600, 830));
        this.setContentPane(this.jLabel1);
        this.pack();
        
        

        try {
            //charger les images du fond
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

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.framebuffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();

        // Creation du jeu
        this.jeu = new Jeu();

        // Creation du Timer qui appelle this.actionPerformed() tous les 1 s
        this.timer = new Timer(1000, this);
        this.timer.start();
        int x = 42;
        // Ajout d'un ecouteur clavier
        this.addKeyListener(this);
   
        
        // Configuration du bouton "Joueur"
        buttonJoueur = new JButton("Jouer");

        // Ajout des composants à la fenêtre
        getContentPane().add(buttonJoueur, BorderLayout.SOUTH);
        getContentPane().add(jLabel1, BorderLayout.CENTER);
    }
    
    public void paintComponent(Graphics g) {
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
    
    // Methode appelee par le timer et qui effectue la boucle de jeu
    @Override
    public void actionPerformed(ActionEvent e) {
        String pseudo = JOptionPane.showInputDialog("Entrez votre pseudo");
        jeu = new Jeu();

        // Vérifier si c'est le premier joueur
        if (jeu.getListeJoueurs().isEmpty()) {
            Runner runner = new Runner(0, pseudo, 0, 0, 0);
            jeu.InsertJoueur(runner, pseudo);
        } else {
            Baril baril = new Baril(0, pseudo, 0, 0, false);
            jeu.InsertJoueur(baril, pseudo);
        }
        // Masquer le bouton "Joueur"
        buttonJoueur.setVisible(false);

        // Le jeu commence
        jeuCommence = true;
        
        // Mettre à jour l'état du jeu
        this.jeu.partieMoteurV2(); 
        this.jLabel1.repaint();
        
        if (this.jeu.partieMoteurV2()) {
            this.timer.stop();
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

        for (int i = 0; i < jeu.getCarteMoteur().getLargeur(); i++) {
            for (int j = 0; j < jeu.getCarteMoteur().getHauteur(); j++) {
                Element element = jeu.laCaseDeCoordonnees(i, j);

                if (element instanceof Mur) {
                    g.drawImage(briqueMurImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Runner) { // Dessiner l'image du runner à la position correspondante
                    g.drawImage(runnerImage, jeu.runner.getX() * largeurCase, jeu.runner.getY() * hauteurCase, largeurCase, hauteurCase, null);
                } else if (element instanceof Baril baril) {
                    int index = jeu.getBarrilJoueur().indexOf(baril);
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


