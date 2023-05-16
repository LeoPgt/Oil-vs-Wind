/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import clavier.Clavier;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author mleconte
 */
public class Jeu {
    protected boolean gauche, droite, haut, bas;
    private int x;
    private int y;
    private int xR;
    private int yR;
    private int xB;
    private int yB;    
    private Carte C;
    private Jouable Joueur; //Manal : Déclarez plutôt directement Runner ou Baril.
    private Runner runner;
    private Baril barrilJoueur;
    
    public Jeu () {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.Joueur= new Jouable( x,  y);
//        this.runner = new Runner(xR,yR,2);
        this.barrilJoueur = new Baril(xB,yB);
    }
        static public long getLong() {
        long retourLong = 0;
        boolean saisieOk = false;
        while (saisieOk == false) {
            try {
                BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
                String s = inr.readLine();
                retourLong = Long.parseLong(s);
                saisieOk = true;
            } catch (Exception e) {
                System.out.println(" Erreur de saisie : veuiller entrer un entier ");
            }
        }
        return retourLong;
    }
    
    public boolean collisionLoupMouton(){
        boolean collision = false;
        if(this.barrilJoueur.getX()== this.Joueur.localisation()[0]+1){
            collision = true;
        }
        if(this.barrilJoueur.getX()== this.Joueur.localisation()[0]-1){
            collision = true;
        }
        if(this.barrilJoueur.getY()== this.Joueur.localisation()[0]+1){
            collision = true;
        }
        if(this.barrilJoueur.getY()== this.Joueur.localisation()[0]-1){
            collision = true;
        }      
        return collision;
    }
    
    public int[] deplacementCapture(){
        int [] coordoCapture = new int[2];
        if(this.collisionLoupMouton()==true){
           barrilJoueur.setX(Joueur.getX()+1);
           barrilJoueur.setY(Joueur.getY()+1);
        }
        return coordoCapture;
    }
   /**
     * Déplace le joueur sur l'axe des abscisses et des ordonnées en ayant conscience de la carte
     * @version 1
     * @return une matrice de 0 et le joueur qui représente le 1
     */  
    public Carte MiseAJour(int deplacement, Carte Bouclage) { // le boolean sera a dégager
       // Matrice d'initialisation
        Carte MapMod = Bouclage;
        int x = this.Joueur.getX(); // localisation du joueur sur la map en x
        int y = this.Joueur.getY(); // Localisation du joueur sur la map en y
        if (deplacement == 0) {
            if (y > 0 && Bouclage.getMatrice()[x][y-1] == 0) { // Vérifie si le mouvement est possible //Manal: Mettez ça dans une méthode à part, qui vous retourne True si le mouvement est possible.
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                y--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); // Met à jour la nouvelle position du 1 dans la matrice
                this.Joueur.setY(y);
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
            }
        } else if (deplacement == 1) {
            if (y < Bouclage.getMatrice()[0].length-1 && Bouclage.getMatrice()[x][y+1] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1 Modification du setteur car setter modifie la matrice mais pas ses éléments !!!
                y++;
                MapMod.setMatrice(x, y, 1);
                this.Joueur.setY(y);
            }
            else{
                System.out.print("déplacement impossible vers la droite");
            }         
        } else if (deplacement == 2){
            if (x > 0 && Bouclage.getMatrice()[x-1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1);
                this.Joueur.setX(x);
            }
            else{
                System.out.print("déplacement impossible vers le haut");
;
            } 
        } else if (deplacement == 3){
            if (x < Bouclage.getMatrice().length-1 && Bouclage.getMatrice()[x+1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); 
                this.Joueur.setX(x);

            }
            else{
                System.out.print("déplacement impossible vers le bas");

            }
        }
        Bouclage.afficherMatriceV2(MapMod);
        return MapMod;
    }

    public void partie(){
        Carte Map = new Carte();
        Jouable Joueur = new Jouable(2,2);
//        Baril Baril = new Baril(4,4);
        Map.afficherMatriceV2(Map);
        int bouclage = 10;
        int essai = 0;
        while (essai != bouclage){
            System.out.print("selectionner une direction");
            int unEntier = Clavier.getInt();
            Carte MapMod = this.MiseAJour(unEntier, Map);
            Map = MapMod;
        }
    }
}
