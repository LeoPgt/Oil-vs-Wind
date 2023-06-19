/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ig;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import moteur.*;

/**
 * Création de la classe Avatars
 *
 * @author mleconte
 */
public class Avatars {
    
    private BufferedImage spritePersonnage;
    private BufferedImage spriteBarilRouge;
    private BufferedImage spriteBarilJaune;
    private BufferedImage spriteBarilBleu;
    
    private JeuMoteur jeuMoteur;
    
    protected double xPersonnage, yPersonnage;
    protected double xBarilRouge, yBarilRouge;
    protected double xBarilJaune, yBarilJaune;
    protected double xBarilBleu, yBarilBleu;
    private boolean gauche, droite, bas, haut;
    
    private int largeurCase; 
    private int hauteurCase;

    public Avatars(JeuMoteur J, int largeurCase, int hauteurCase) {
        this.jeuMoteur = J;
        this.largeurCase = largeurCase;
        this.hauteurCase = hauteurCase;
        
        try {
            this.spritePersonnage = ImageIO.read(new File("src/resource/perso.png"));
            this.spriteBarilRouge = ImageIO.read(new File("src/resource/baril_rouge.png"));
            this.spriteBarilJaune = ImageIO.read(new File("src/resource/baril_jaune.png"));
            this.spriteBarilBleu =  ImageIO.read(new File("src/resource/baril_bleu.png"));
       
        } catch (IOException ex) {
            Logger.getLogger(Avatars.class.getName()).log(Level.SEVERE, null, ex);
        }
        //MANAL : Tu peux utiliser ton Jeu moteur là, pour capter les positions initiales de tes joueurs
        //MANAL : (Une arrayList pour les coordonnées de tes barils aurait été cool, ça aurait permis de juste faire une boucle ;)
        Baril baril_rouge = J.getBarrilJoueur().get(0);
        Baril baril_bleu = J.getBarrilJoueur().get(1);
        Baril baril_jaune = J.getBarrilJoueur().get(2);
        Runner personnage = J.getRunner();
        
        //MANAL : Et là tu vois, on se sert bien du moteur ! :)
        this.xPersonnage = personnage.getX()*this.largeurCase;
        this.yPersonnage = personnage.getY()*this.hauteurCase;
        this.xBarilRouge = baril_rouge.getX()*this.largeurCase;
        this.yBarilRouge = baril_rouge.getY()*this.hauteurCase;
        this.xBarilJaune = baril_jaune.getX()*this.largeurCase;
        this.yBarilJaune = (baril_jaune.getY()-1)*this.hauteurCase;
        this.xBarilBleu = baril_bleu.getX()*this.largeurCase;  
        this.yBarilBleu = (baril_bleu.getY()-1)*this.hauteurCase; 
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        
    }
    
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
        this.miseAJourRunner();
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
        this.miseAJourRunner();
    }

    public void setBas(boolean bas) {
        this.bas = bas;
        this.miseAJourRunner();
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
        this.miseAJourRunner();
    }

    public void miseAJourRunner() {
        // Pixel de déplacement.
        double vitesse = 20; // peut être à changer, je ne sais pas si c'est assez rapide

        // Mettre à jour la position du personnage en fonction des touches pressées.
        if (this.haut) {
            if (this.jeuMoteur.deplacementEstPossible(this.jeuMoteur.getRunner())){
                 this.yPersonnage -= vitesse;
            }
        }
        if (this.bas) {
            if (this.jeuMoteur.deplacementEstPossible(this.jeuMoteur.getRunner())){
                this.yPersonnage += vitesse;
            }
        }
        if (this.droite) {
            if (this.jeuMoteur.deplacementEstPossible(this.jeuMoteur.getRunner())){
                this.xPersonnage += vitesse;
            }
        }
        if (this.gauche) {
            if (this.jeuMoteur.deplacementEstPossible(this.jeuMoteur.getRunner())){
                this.xPersonnage -= vitesse;
            }
        }
        // Mettre à jour les coordonnées du personnage dans la classe Jeu
        jeuMoteur.getRunner().setX((int) xPersonnage/this.largeurCase);
        jeuMoteur.getRunner().setY((int) yPersonnage/this.hauteurCase);
        
        boolean jeuTermine = jeuMoteur.partieMoteurV2(); //Calcul collision
        
        this.xPersonnage = this.jeuMoteur.getRunner().getX()*this.largeurCase;
        this.yPersonnage = this.jeuMoteur.getRunner().getY()*this.hauteurCase;
        System.out.println(jeuMoteur.getRunner().getX()+"-"+jeuMoteur.getRunner().getY());

    }
    
    public void miseAJourBarilRouge() {
        // Pixel de déplacement.
        double vitesse = 20; // peut être à changer, je ne sais pas si c'est assez rapide

        // Mettre à jour la position du personnage en fonction des touches pressées.
        if (this.haut) {
            this.yBarilRouge -= vitesse;
        }
        if (this.bas) {
            this.yBarilRouge += vitesse;
        }
        if (this.droite) {
            this.xBarilRouge+= vitesse;
        }
        if (this.gauche) {
            this.xBarilRouge -= vitesse;
        }
        // Mettre à jour les coordonnées du personnage dans la classe Jeu
        jeuMoteur.getBarrilJoueur().get(0).setX((int) xBarilRouge/this.largeurCase);
        jeuMoteur.getBarrilJoueur().get(0).setY((int) yBarilRouge/this.hauteurCase);

    }
        
    public void miseAJourBarilBleu() {
        // Pixel de déplacement.
        double vitesse = 20; // peut être à changer, je ne sais pas si c'est assez rapide

        // Mettre à jour la position du personnage en fonction des touches pressées.
        if (this.haut) {
            this.yBarilBleu -= vitesse;
        }
        if (this.bas) {
            this.yBarilBleu += vitesse;
        }
        if (this.droite) {
            this.xBarilBleu+= vitesse;
        }
        if (this.gauche) {
            this.xBarilBleu -= vitesse;
        }
        // Mettre à jour les coordonnées du personnage dans la classe Jeu
        jeuMoteur.getBarrilJoueur().get(1).setX((int) xBarilBleu/this.largeurCase);
        jeuMoteur.getBarrilJoueur().get(1).setY((int) yBarilBleu/this.hauteurCase);

    }
    
    public void miseAJourBarilJaune() {
        // Pixel de déplacement.
        double vitesse = 20; // peut être à changer, je ne sais pas si c'est assez rapide

        // Mettre à jour la position du personnage en fonction des touches pressées.
        if (this.haut) {
            this.yBarilJaune -= vitesse;
        }
        if (this.bas) {
            this.yBarilJaune += vitesse;
        }
        if (this.droite) {
            this.xBarilJaune+= vitesse;
        }
        if (this.gauche) {
            this.xBarilJaune -= vitesse;
        }
        // Mettre à jour les coordonnées du personnage dans la classe Jeu
        jeuMoteur.getBarrilJoueur().get(2).setX((int) xBarilJaune/this.largeurCase);
        jeuMoteur.getBarrilJoueur().get(2).setY((int) yBarilJaune/this.hauteurCase);

    }
        
    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.spritePersonnage, (int) this.xPersonnage, (int) this.yPersonnage, null);
        contexte.drawImage(this.spriteBarilRouge, (int) this.xBarilRouge, (int) this.yBarilRouge, null);
        contexte.drawImage(this.spriteBarilJaune, (int) this.xBarilJaune, (int) this.yBarilJaune, null);
        contexte.drawImage(this.spriteBarilBleu, (int) this.xBarilBleu, (int) this.yBarilBleu, null);
    }
}
