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
    
    protected double xPersonnage, yPersonnage;
    protected double xBarilRouge, yBarilRouge;
    protected double xBarilJaune, yBarilJaune;
    protected double xBarilBleu, yBarilBleu;
    private boolean gauche, droite;

    public Avatars(Jeu J) {
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
        Baril baril_rouge = J.getBarrilJoueur().get(0); //MANAL : Je suis pas sure pour les get(i), t'avais associé un ID à une couleur de baril ?
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
    }
    
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public void miseAJour() {
        if (this.gauche) {
            xPersonnage -= 5;
        }
        if (this.droite) {
            xPersonnage += 5;
        }
        if (xPersonnage > 607-52) {
            xPersonnage = 607-52;
        }
        if (xPersonnage < 0) {
            xPersonnage = 0;
        }
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.spritePersonnage, (int) xPersonnage, (int) yPersonnage, null);
        contexte.drawImage(this.spriteBarilRouge, (int) xBarilRouge, (int) yBarilRouge, null);
        contexte.drawImage(this.spriteBarilJaune, (int) xBarilJaune, (int) yBarilJaune, null);
        contexte.drawImage(this.spriteBarilBleu, (int) xBarilBleu, (int) yBarilBleu, null);
    }
}
