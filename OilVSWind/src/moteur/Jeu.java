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
    private int x;// x est le nombre de lignes ? coordonnée nan ?
    private int y; // y est le nombre de colonnes ? Coordoonnée nan ?
    private Carte C;
    private Jouable Joueur;
    
    public Jeu () {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.Joueur= new Jouable();
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
       int x = this.Joueur.localisation(MapMod)[0]; // localisation du joueur sur la map bouclage
       int y = this.Joueur.localisation(MapMod)[1]; // Localisation du joueur
        if (deplacement == 0) {
            if (y > 0 && Bouclage.getMatrice()[x][y-1] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
//                this.C.getMatrice()[x][y] = 0; 
                y--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); // Met à jour la nouvelle position du 1  
//                this.C.getMatrice()[x][y] = 1;               
//                this.C.afficherMatrice(); // appel de la méthode afficherMatrice() après chaque déplacement             
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
                System.out.println();
            }
        } else if (deplacement == 1) {
            if (y < Bouclage.getMatrice()[0].length-1 && Bouclage.getMatrice()[x][y+1] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1 Modification du setteur car setter modifie la matrice mais pas ses éléments !!!
//                this.C.getMatrice()[x][y] = 0; j'ai laissé en commentaire les anciennes parties du programme je les retires après le prochain cours d'info
                y++;
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
               // this.C.afficherMatrice();j'ai laissé en commentaire les anciennes parties du programme je les retires après le prochain cours d'info   
            }
            else{
                System.out.print("déplacement impossible vers le haut");
                System.out.println();
            }         
        } else if (deplacement == 2){
            if (x > 0 && Bouclage.getMatrice()[x-1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
//                this.C.getMatrice()[x][y] = 0; 
                x--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
//                this.C.getMatrice()[x][y] = 1; //
//                this.C.afficherMatrice();
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
                System.out.println();
            }
            
        } else if (deplacement == 3){
            if (x < Bouclage.getMatrice().length-1 && Bouclage.getMatrice()[x+1][y] == 0) { // Vérifie si le mouvement est possible
//                this.C.getMatrice()[x][y] = 0;
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
//                this.C.getMatrice()[x][y] = 1;
//                this.C.afficherMatrice();
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
}
