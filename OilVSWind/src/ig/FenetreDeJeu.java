package ig;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import moteur.*;

/**
 * Exemple de fenetre de jeu en utilisant uniquement des commandes
 *
 * @author guillaume.laurent
 */
public class FenetreDeJeu extends JFrame implements ActionListener{
    private HashMap<String, BufferedImage> images;
    private BufferedImage framebuffer;
    private Graphics2D contexte;
    private JLabel jLabel1;
    private JeuIG jeu; // On va prendre le moteur
    private Jeu jeuMoteur;
    private Timer timer;
    
    //Les Listeners
    private EcouteurClavier keyL;

    public FenetreDeJeu() {
        // initialisation de la fenetre
        images = new HashMap<String, BufferedImage>();
        try {
            images.put("2", ImageIO.read(new File("chemin_vers_image_mur.jpg")));
            images.put("S", ImageIO.read(new File("chemin_vers_image_spot.jpg")));
            images.put("6", ImageIO.read(new File("chemin_vers_image_bonus.jpg")));
            // Ajouter d'autres images si nécessaire
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setSize(607, 380);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(607, 380));
        this.setContentPane(this.jLabel1);
        this.pack();
        
        // Creation du jeu
        this.jeuMoteur = new Jeu();
        this.jeu = new JeuIG(this.jeuMoteur); //MANAL : C'est ici que je fais le lien entre le coté moteur et l'IG précisément !
        
        //Ajout du listener ici
        this.keyL = new EcouteurClavier(jeu); //Of course on le met APRES avoir déclaré Jeu()....
        this.addKeyListener(this.keyL);

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.framebuffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(40, this);
        this.timer.start();
    }

    // Methode appelee par le timer et qui effectue la boucle de jeu
    @Override
    public void actionPerformed(ActionEvent e) {
        //Les fameuses deux étapes importantes : MiseàJour et rendu qu'on trouve dans la classe Jeu.
        this.jeu.miseAJour();
        this.jeu.rendu(contexte);
        
        //Ca c'est juste pour appliquer le rendu()...
        this.jLabel1.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FenetreDeJeu fenetre = new FenetreDeJeu();
        fenetre.setVisible(true);
    }

}
