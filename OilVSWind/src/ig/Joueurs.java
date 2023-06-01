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
 *
 * @author tmichel1
 */
public class Joueurs {

    private BufferedImage sprite;
    protected double x, y;
    private boolean gauche, droite, haut, bas;

    public Joueurs() {
        try {
            this.sprite = ImageIO.read(getClass().getClassLoader().getResource("resource/baril.png"));
        } catch (IOException ex) {
            Logger.getLogger(Joueurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x = 100;
        this.y = 150;
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
    
    public void setHaut(boolean haut) {
        this.haut = haut;
    }
    
    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public void miseAJour() {
        if (this.gauche) {
            x -= 5;
        }
        if (this.droite) {
            x += 5;
        }
        if (this.haut) {
            y += 5;
        }
        if (this.bas) {
            y -= 5;
        }
        if (x > 607-52) {
            x = 607-52;
        }
        if (x < 0) {
            x = 0;
        }
    }

    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.sprite, (int) x, (int) y, null);
    }

}
