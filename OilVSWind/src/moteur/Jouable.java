/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 *
 * @author mleconte
 */
public class Jouable {
    protected BufferedImage sprite ; 
    // protected Carte laCarte; // il faudra créer une classe carte comme dans le style pokémon pour avoir la carte et retraduire l'image en terme de 0 et de 1
    protected boolean gauche, droite, haut, bas;
    private int x;
    private int y;
    private int[][] matrice; // x est le nombre de lignes et y est le nombre de colonnes
    
    public Jouable () {
        // cette partie ne sera pas à mettre ici mais plutôt dans la fonction héritage car chaque personnage aura un sprite différent
//        try {
//            this . sprite = ImageIO . read ( getClass () . getResource (" .... ")) // rajouter le png 
//                ;
//        } catch ( IOException ex ) {
//        // Logger . getLogger (Joueur . class . getName () ). log ( Level . SEVERE , null , ex );
//        }

        // this.laCarte = laCarte; // constructeur de la carte
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        matrice = new int[50][50]; // Crée une matrice de 10x10 remplie de 0
        matrice[0][0] = 1; // Initialise la position de départ du 1
        x = 0;
        y = 0;
    
    }
    
    /**
     * Déplace le joueur sur l'axe des abscisses et des ordonnées sans lien avec une carte
     * @version 1 ( la version 2 consistera à mettre la carte dans la boucle avec des requetes lié à la classe joueursqui lui même sera lié à du déplacement sur la carte )
     * @return une matrice de 0 et de le joueur de 1 à gauche ou à droite sur l'axe des abscisses / ordonnées 
     */
    public void MiseAJour() {
        if (this.gauche) {
            if (y > 0 && matrice[x][y-1] == 0) { // Vérifie si le mouvement est possible
                matrice[x][y] = 0; // Efface la position actuelle du 1
                y--; // Met à jour la position du 1
                matrice[x][y] = 1; // Met à jour la nouvelle position du 1
                afficherMatrice(); // appel de la méthode afficherMatrice() après chaque déplacement
         
            }
        } else if (this.droite) {
            if (y < matrice[0].length-1 && matrice[x][y+1] == 0) { // Vérifie si le mouvement est possible
                matrice[x][y] = 0; // Efface la position actuelle du 1
                y++; // Met à jour la position du 1
                matrice[x][y] = 1; // Met à jour la nouvelle position du 1
                afficherMatrice();
            }
        } else if (this.haut) {
            if (x > 0 && matrice[x-1][y] == 0) { // Vérifie si le mouvement est possible
                matrice[x][y] = 0; // Efface la position actuelle du 1
                x--; // Met à jour la position du 1
                matrice[x][y] = 1; // Met à jour la nouvelle position du 1
                afficherMatrice();
            }
        } else if (this.bas) {
            if (x < matrice.length-1 && matrice[x+1][y] == 0) { // Vérifie si le mouvement est possible
                matrice[x][y] = 0; // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                matrice[x][y] = 1; // Met à jour la nouvelle position du 1
                afficherMatrice();
            }
        }
 
    }
    public void afficherMatrice() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }

    

    
        /* 
   
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
        
        * Ici c'est pour éviter de sortir du cadre mais il est déjà coder avec sprite
        
        */ 
   
    
     /**
     * rendu du personnage avec ses coordonnées quand il y aura une carte de faite
     *
     * @return rendu
     */
     /*   public void rendu(Graphics2D contexte) {
        try {
            Connection connexion = SingletonJDBC.getInstance().getConnection();

            PreparedStatement requete = connexion.prepareStatement("SELECT latitude, longitude FROM Joueur WHERE nom = ?");
            requete.setString(1, nom);
            ResultSet resultat = requete.executeQuery();
            if (resultat.next()) {
                double latitude = resultat.getDouble("latitude");
                double longitude = resultat.getDouble("longitude");

                int x = laCarte.longitudeEnPixel(longitude);
                int y = laCarte.latitudeEnPixel(latitude);
                contexte.setColor(Color.red);
                contexte.drawOval(x - 7, y - 7, 14, 14);
                //contexte.drawString(pseudo, x + 8, y - 8);
            }
            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    */
        
    
// Pour récupérer les événements liés au clavier, il faut un écouteur clavier. Il faut pour cela que la classe FenetreDeJeu implémente l’interface KeyListener et définisse les méthodes keyTyped, keyPressed et keyReleased
    
    public double getHauteur () {
        return sprite . getHeight () ; // quand il y aura un sprite (bonhomme) pour le joueur
    }
    public double getLargeur() {
        return sprite . getWidth () ; // quand il y aura un sprite (bonhomme) pour le joueur
    }

}