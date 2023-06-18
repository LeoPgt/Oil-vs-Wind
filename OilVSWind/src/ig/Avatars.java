/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ig;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
            this.spritePersonnage = ImageIO.read(getClass().getClassLoader().getResource("perso.png"));
            this.spriteBarilRouge = ImageIO.read(getClass().getClassLoader().getResource("baril_rouge.png"));
            this.spriteBarilJaune = ImageIO.read(getClass().getClassLoader().getResource("baril_jaune.png"));
            this.spriteBarilBleu = ImageIO.read(getClass().getClassLoader().getResource("baril_bleu.png"));
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

    public void miseAJour() {
        this.xPersonnage = jeuMoteur.getRunner().getX();
        this.yPersonnage = jeuMoteur.getRunner().getY();
        this.xBarilRouge = jeuMoteur.getBarrilJoueur().get(0).getX();
        this.yBarilRouge = jeuMoteur.getBarrilJoueur().get(0).getY();
        this.xBarilJaune = jeuMoteur.getBarrilJoueur().get(1).getX();
        this.yBarilJaune = jeuMoteur.getBarrilJoueur().get(1).getY();
        this.xBarilBleu = jeuMoteur.getBarrilJoueur().get(2).getX();
        this.yBarilBleu = jeuMoteur.getBarrilJoueur().get(2).getY();
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.spritePersonnage, (int) xPersonnage, (int) yPersonnage, null);
        contexte.drawImage(this.spriteBarilRouge, (int) xBarilRouge, (int) yBarilRouge, null);
        contexte.drawImage(this.spriteBarilJaune, (int) xBarilJaune, (int) yBarilJaune, null);
        contexte.drawImage(this.spriteBarilBleu, (int) xBarilBleu, (int) yBarilBleu, null);
    }
}
