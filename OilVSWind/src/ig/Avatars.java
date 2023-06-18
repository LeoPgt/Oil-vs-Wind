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
    
    private Jeu jeuMoteur;
    
    protected double xPersonnage, yPersonnage;
    protected double xBarilRouge, yBarilRouge;
    protected double xBarilJaune, yBarilJaune;
    protected double xBarilBleu, yBarilBleu;
    private boolean gauche, droite, bas, haut;

    public Avatars(Jeu J) {
        this.jeuMoteur = J;
        try {
            this.spritePersonnage = ImageIO.read(new File("src/resource/perso.PNG"));
            this.spriteBarilRouge = ImageIO.read(new File("src/resource/baril_rouge.PNG"));
            this.spriteBarilJaune = ImageIO.read(new File("src/resource/baril_jaune.PNG"));
            this.spriteBarilBleu =  ImageIO.read(new File("src/resource/baril_bleu.PNG"));
       
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
        this.xPersonnage = personnage.getX();
        this.yPersonnage = personnage.getY();
        this.xBarilRouge = baril_rouge.getX();
        this.yBarilRouge = baril_rouge.getY();
        this.xBarilJaune = baril_jaune.getX();
        this.yBarilJaune = baril_jaune.getY();
        this.xBarilBleu = baril_bleu.getX();
        this.yBarilBleu = baril_bleu.getY(); 
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
    }
    
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public void miseAJourRunner() {
        // Pixel de déplacement.
        double vitesse = 20; // peut être à changer, je ne sais pas si c'est assez rapide

        // Mettre à jour la position du personnage en fonction des touches pressées.
        if (this.haut) {
            this.yPersonnage -= vitesse;
        }
        if (this.bas) {
            this.yPersonnage += vitesse;
        }
        if (this.droite) {
            this.xPersonnage += vitesse;
        }
        if (this.gauche) {
            this.xPersonnage -= vitesse;
        }
        // Mettre à jour les coordonnées du personnage dans la classe Jeu
        jeuMoteur.getRunner().setX((int) xPersonnage);
        jeuMoteur.getRunner().setY((int) yPersonnage);

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
        jeuMoteur.getBarrilJoueur().get(0).setX((int) xBarilRouge);
        jeuMoteur.getBarrilJoueur().get(0).setY((int) yBarilRouge);

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
        jeuMoteur.getBarrilJoueur().get(1).setX((int) xBarilBleu);
        jeuMoteur.getBarrilJoueur().get(1).setY((int) yBarilBleu);

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
        jeuMoteur.getBarrilJoueur().get(2).setX((int) xBarilJaune);
        jeuMoteur.getBarrilJoueur().get(2).setY((int) yBarilJaune);

    }
        
    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.spritePersonnage, (int) xPersonnage, (int) yPersonnage, null);
        contexte.drawImage(this.spriteBarilRouge, (int) xBarilRouge, (int) yBarilRouge, null);
        contexte.drawImage(this.spriteBarilJaune, (int) xBarilJaune, (int) yBarilJaune, null);
        contexte.drawImage(this.spriteBarilBleu, (int) xBarilBleu, (int) yBarilBleu, null);
    }
}
