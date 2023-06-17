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

    public Avatars() {
        try {
            this.spritePersonnage = ImageIO.read(getClass().getClassLoader().getResource("perso.png"));
            this.spriteBarilRouge = ImageIO.read(getClass().getClassLoader().getResource("baril_rouge.png"));
            this.spriteBarilJaune = ImageIO.read(getClass().getClassLoader().getResource("baril_jaune.png"));
            this.spriteBarilBleu = ImageIO.read(getClass().getClassLoader().getResource("baril_bleu.png"));
        } catch (IOException ex) {
            Logger.getLogger(Avatars.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.xPersonnage = ;
        this.yPersonnage = 150;
        this.xBarilRouge = 200;
        this.yBarilRouge = 150;
        this.xBarilJaune = 300;
        this.yBarilJaune = 150;
        this.xBarilBleu = 400;
        this.yBarilBleu = 150;
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
