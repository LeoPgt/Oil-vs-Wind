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
    private int x;// indice de ligne de la case
    private int y; // indice de colonne de la case //Manal : J'avoue, c'est pas clair, c'est les tailles ?
    private Carte C;
    private Jouable Joueur; //Manal : Déclarez plutôt directement Runner ou Baril.
    private int tailleCase;
    
    public Jeu (int taillecase) {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.Joueur= new Jouable( x,  y);
        this.tailleCase = taillecase;
    }
    
    public void setCoordonne(int[] Localisation){
        this.x = Localisation[0];
        this.y = Localisation[1];
    }
    
   /**
     * Déplace le joueur sur l'axe des abscisses et des ordonnées en ayant conscience de la carte
     * @version 1
     * @return une matrice de 0 et le joueur qui représente le 1
     */   
    public Carte MiseAJour(int deplacement, Carte Bouclage) { // le boolean sera a dégager
       // Matrice d'initialisation
       Carte MapMod = Bouclage;
       int x = this.Joueur.localisation()[0]; // localisation du joueur sur la map en x
       int y = this.Joueur.localisation()[1]; // Localisation du joueur sur la map en y
        if (deplacement == 0) { //Manal : A quoi correspond "déplacement" ?
            if (y > 0 && this.C.getMatrice()[x][y-1] == 0) { // Vérifie si le mouvement est possible //Manal: Mettez ça dans une méthode à part, qui vous retourne True si le mouvement est possible.
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                y--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); // Met à jour la nouvelle position du 1             
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
                System.out.println();
            }
        } else if (deplacement == 1) {
            if (y < Bouclage.getMatrice()[0].length-1 && Bouclage.getMatrice()[x][y+1] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1 Modification du setteur car setter modifie la matrice mais pas ses éléments !!!
                y++;
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
            }
            else{
                System.out.print("déplacement impossible vers le haut");
                System.out.println();
            }         
        } else if (deplacement == 2){
            if (x > 0 && Bouclage.getMatrice()[x-1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
                System.out.println();
            }
            
        } else if (deplacement == 3){
            if (x < Bouclage.getMatrice().length-1 && Bouclage.getMatrice()[x+1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
            }
            else{
                System.out.print("déplacement impossible vers la droite");
                System.out.println();
            }
        }
        Bouclage.afficherMatriceV2(MapMod);
        return MapMod;
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
    
    public void partie(){
        Carte Map = new Carte();
        Map.afficherMatriceV2(Map);
        boolean resultat = false;
        int bouclage = 5;
        int essai = 0;
        while (essai != bouclage){
        System.out.print("selectionner une direction");
        int unEntier = Clavier.getInt();
        this.MiseAJour(unEntier, Map);
        }
    }
    
    // Création du programme qui permet de transformeer les infos moteur en termes de pixels
    public int convertirEnPixelssurX(int x) {
        return x * this.tailleCase;
    }
    public int convertirEnPixelssurY(int y) {
        return y * this.tailleCase;
    }
}

   //testgithub