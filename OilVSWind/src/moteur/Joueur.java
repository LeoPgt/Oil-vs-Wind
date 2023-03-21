/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OilVSWind;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mleconte
 */
public class Joueur {
    protected BufferedImage sprite ; 
    protected double z ;
    protected double s;
    protected double q;
    protected double d;
    protected double x, y;
    protected double vitesse ;
    private boolean gauche , droite , haut, bas ;

    public Joueur () {
        try {
            this . sprite = ImageIO . read ( getClass () . getResource (" .... ")) // rajouter le png 
                ;
        } catch ( IOException ex ) {
        // Logger . getLogger (Joueur . class . getName () ). log ( Level . SEVERE , null , ex );
        }
        this . x = 0;
        this . y = 0;
        this . gauche = false ;
        this . droite = false ;
        this. haut = false;
        this. bas = false;
        this. vitesse = 0;    
    }
        
    
    public void MiseAJour () { // méthode miseAJour augmente l’ordonnée/abscisse de 5 pixels à chaque appel donc si la boucle du jeu est exécutée 25 fois par seconde, le joueur va se déplacer vers le bas de 5 pixels tous les 40 ms
        if ( this . gauche ) { 
        x -= 5; // déplacement du perso sur la gauche
        }
        if ( this . droite ) {
        x += 5; //déplacement du perso sur la droite
        }
        if ( this . haut ) {
        y += 5; //déplacement du perso sur le haut
        }
        if ( this . bas ) {
        y -= 5; //déplacement du perso sur le bas
        }
        if (y > 380 - sprite . getHeight () ) { // collision avec le bord haut de la scene
        y = 380 - sprite . getHeight () ;
        }
        if (y < 0) { // collision avec le bord bas de la scene
        y = 0 ;
        }
        if (x > 380 - sprite . getWidth () ) { // collision avec le bord droit de la scene
        x = 380 - sprite . getWidth () ;
        }
        if (x < 0) { // collision avec le bord gauche de la scene
        x = 0;
        }
    }
    
// Il faudrait un programme qui donne le rendu du personnage avec ses coordonnées sur la carte
    
    public void setGauche ( boolean gauche ) {
        this . gauche = gauche ;
    }
    
    public void setDroite ( boolean droite ) {
        this . droite = droite ;
    }
    
    public void setHaut ( boolean haut ) {
        this . haut = haut ;
    }
     
    public void setBas ( boolean bas ) {
        this . bas = bas ;
    }
    
    public double getZ () {
        return z;
    }
    
    public double getQ () {
            return q;
        }

    public double getS () {
            return s;
        }

    public double getD () {
            return d;
        }
// Pour récupérer les événements liés au clavier, il faut un écouteur clavier. Il faut pour cela que la classe FenetreDeJeu implémente l’interface KeyListener et définisse les méthodes keyTyped, keyPressed et keyReleased
    
    public double getLargeur () {
        return sprite . getHeight () ; // quand il y aura un sprite pour le joueur
    }
    public double getHauteur () {
        return sprite . getWidth () ; // quand il y aura un sprite pour le joueur
    }
}
