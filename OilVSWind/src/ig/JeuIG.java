package ig;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import moteur.*;

/**
 * C'est la classe Jeu mais coté INTERFACE GRAPHIQUE ! 
 * L'idée c'est que dans les attributs, il y aura aussi le "jeu" mais coté Moteur, que vous allez mettre ausi à jour.
 *
 * @author mandy
 */

public class JeuIG {
    private BufferedImage backgroundImage;
    private BufferedImage briqueMurImage;
    private BufferedImage briqueSableImage;
    private BufferedImage spotImage;
    private Avatars avatar;
    private Jeu JeuMoteur;
    private BufferedImage carteImage; // Ajout d'une variable pour stocker l'image de la carte
    private boolean jeuCommence = false;
    private int largeurCase; //MANAL : Tu vas avoir besoin de ces deux là souvent !
    private int hauteurCase;
    
    public JeuIG(Jeu J, int largeurJeu, int hauteurJeu) {
        this.JeuMoteur = J;
        this.largeurCase = largeurJeu/JeuMoteur.getCarteMoteur().getLargeur();
        this.hauteurCase = hauteurJeu/JeuMoteur.getCarteMoteur().getHauteur();
        
        // Charger les images
        try {
            spotImage = ImageIO.read(new File("src/resource/brique_spot.PNG"));
            backgroundImage = ImageIO.read(new File("src/resource/fonddentreedujeu.PNG"));
            briqueMurImage = ImageIO.read(new File("src/resource/brique_mur.PNG"));
            briqueSableImage = ImageIO.read(new File("src/resource/brique_sable.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.avatar = new Avatars(this.JeuMoteur, this.largeurCase, this.hauteurCase);
        this.carteImage = DessinerCarte(); // Appel de DessinerCarte() et stockage de l'image de la carte
    }
    
    public BufferedImage getImageCarte() {
        return carteImage;
    }
    public Avatars getAvatar(){
        return this.avatar;
    }
  
    public final BufferedImage DessinerCarte() {
                
        // Ajout d'une ligne pour comprendre
        // System.out.println("Width: " + getWidth() + ", Height: " + getHeight());
        int largeurJeu = this.largeurCase*JeuMoteur.getCarteMoteur().getLargeur();
        int hauteurJeu = this.hauteurCase*JeuMoteur.getCarteMoteur().getHauteur();
        
        BufferedImage imageCarte = new BufferedImage(largeurJeu, hauteurJeu, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = imageCarte.createGraphics();

        for (int i = 0; i < JeuMoteur.getCarteMoteur().getLargeur(); i++) {
            for (int j = 0; j < JeuMoteur.getCarteMoteur().getHauteur(); j++) {
                Element element = JeuMoteur.laCaseDeCoordonnees(i, j);

                if (element instanceof Mur) {
                    graphics.drawImage(briqueMurImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                } else {
                    graphics.drawImage(briqueSableImage, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                }
            }
        }
        // Parcourir la liste des spots dans la carte du jeu
        for (int i = 0; i < JeuMoteur.getCarteMoteur().getSpots().size(); i++) {
            int x_spot = JeuMoteur.CarteMoteur.getSpots().get(i).getX();
            int y_spot = JeuMoteur.CarteMoteur.getSpots().get(i).getY();

            // Dessiner l'image du spot à la position correspondante
            graphics.drawImage(spotImage, x_spot* largeurCase, y_spot * hauteurCase,largeurCase, hauteurCase, null);
        }
        
        graphics.dispose();
        return imageCarte;
    }
    

    public void miseAJour() {
        this.avatar.miseAJourRunner();
        this.avatar.miseAJourBarilRouge();
        this.avatar.miseAJourBarilBleu();
        this.avatar.miseAJourBarilJaune();
    }

    public void rendu(Graphics2D contexte) {
        this.avatar.rendu(contexte);
    }
}
