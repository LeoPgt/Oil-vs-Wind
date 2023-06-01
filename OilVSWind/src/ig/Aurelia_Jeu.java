/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Aurelia_Jeu {
    private MapData Map;
    private Personnages personnage;

    public Aurelia_Jeu() {
        try {
            this.fond = ImageIO.read(getClass().getClassLoader().getResource("resources/fond.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Aurelia_Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.joueur = new Joueurs();
    }

    /**
    * Cette méthode est importante, c'est cool si vous respectez d'ailleurs ce format avec une méthode MiseàJour() et une méthode rendu(). C'est MiseàJour() qui va mettre à jour le jeu coté moteur et déplacer votre joueur coté IG.
    */
    public void miseAJour() {
        this.joueur.miseAJour();
    }

    /**
    * Maitnenant que vous avez changé du coté "console" votre jeu (avec MiseàJour()) bah...il faut l'afficher. C'est ce que fait rendu()
     * @param contexte
    */
    public void rendu(Graphics2D contexte) {
        contexte.drawImage(this.fond, 0, 0, null);
        this.joueur.rendu(contexte);
    }

    public MapData afficherMap() {
        return this.Map;
    }
}
