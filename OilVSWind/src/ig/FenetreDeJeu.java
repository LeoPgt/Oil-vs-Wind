package ig;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import moteur.*;

/**
 *
 * @author mandy.leconte
 */
public class FenetreDeJeu extends JFrame implements ActionListener{
    
    private BufferedImage framebuffer;
    private BufferedImage backgroundImage;
    private Graphics2D contexte;
    private JLabel jLabel1;
    private JeuIG jeu; 
    private JeuMoteur jeuMoteur;
    private Timer timer;
    private JButton buttonJoueur;
    private boolean jeuCommence;
    private BufferedImage imageCarte;
    
    //Les dimensions du jeu
    private int largeurJeu;
    private int hauteurJeu;
    
    //Les Listeners
    private EcouteurClavier keyL;

    public FenetreDeJeu() {
        jeuCommence = false;
        // Initialisation de la fenêtre
        this.setTitle("OIL VS WIND");
        this.largeurJeu = 1216;
        this.hauteurJeu = 800;
        this.setSize(this.largeurJeu, this.hauteurJeu);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configuration du panel de dessin
        jLabel1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (!jeuCommence) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                } else {
                    BufferedImage imageCarte = jeu.getImageCarte(); // Récupérer l'image de la carte depuis JeuIG
                    if (imageCarte != null) {
                        g.drawImage(imageCarte, 0, 0, getWidth(), getHeight(), null);
                        jeu.rendu((Graphics2D) g); // Afficher les personnages sur la carte
                    }
                }
            }
        };
        // Charger les images
        try {
            backgroundImage = ImageIO.read(new File("src/resource/fonddentreedujeu.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Creation du jeu
        this.jeuMoteur = new JeuMoteur();
        this.jeu = new JeuIG(this.jeuMoteur, this.largeurJeu, this.hauteurJeu, this.contexte); //MANAL : C'est ici que je fais le lien entre le coté moteur et l'IG précisément !
        
        // pour que la fenêtre de jeu a le focus pour recevoir les événements clavier
        this.setFocusable(true);
        
        //Ajout du listener ici
        this.keyL = new EcouteurClavier(jeu, jeuMoteur); //Of course on le met APRES avoir déclaré Jeu()....
        this.addKeyListener(this.keyL);

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.framebuffer = new BufferedImage(this.largeurJeu, this.hauteurJeu, BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();
               
        // Configuration du bouton "Joueur"
        buttonJoueur = new JButton("Jouer");
        buttonJoueur.addActionListener(this);
        

        // Ajout des composants à la fenêtre
        this.add(buttonJoueur, BorderLayout.SOUTH);
        this.add(jLabel1, BorderLayout.CENTER);
        
        //carte crée dans JeuIG
        this.imageCarte = null;

    }

    public JLabel getjLabel1() {
        return jLabel1;
    }
  
    // Methode appelee par le timer et qui effectue la boucle de jeu
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == buttonJoueur) {
            String pseudo = JOptionPane.showInputDialog("Entrez votre pseudo");

// Par contre ici il manque une instruction pour récuperer le pseudo, l'associer à un joueur pour le temps de la partie.
            buttonJoueur.setVisible(false);
            jeuCommence = true;
            imageCarte = jeu.DessinerCarte(); // Chargez l'image de la carte
            
            // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
            RepaintListener L = new RepaintListener(this.jeu, this.jeuMoteur, this.jLabel1, this.contexte);
            this.timer = new Timer(40, L);
            this.timer.start();
            repaint();
            
         } else if (jeuCommence) {
            boolean jeuTermine = jeuMoteur.partieMoteurV2();

            // Mettre à jour les positions des personnages
            this.jeu.miseAJour();
            this.jeu.rendu(contexte);
            // Redessiner l'affichage
        
            //Ca c'est juste pour appliquer le rendu()...
            this.jLabel1.repaint();

            // Vérifier si la partie est terminée
            if (jeuTermine) {
                timer.stop();
            }
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FenetreDeJeu fenetre = new FenetreDeJeu();
        fenetre.setVisible(true);
    }

}
