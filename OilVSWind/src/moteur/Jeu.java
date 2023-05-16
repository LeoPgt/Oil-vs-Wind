/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 *
 * @author mleconte
 */
public class Jeu {
    protected boolean gauche, droite, haut, bas;
    private int x;// x est le nombre de lignes ? coordonnée nan ?
    private int y; // y est le nombre de colonnes ? Coordoonnée nan ? //Manal : J'avoue, c'est pas clair, c'est les tailles ?
    private Carte C;
    private Jouable Joueur; //Manal : Déclarez plutôt directement Runner ou Baril.
    
    public Jeu () {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
     //   this.C = new Carte();
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
       int y = this.Joueur.localisation(MapMod)[1]; // Localisation du joueur //Manal : Même remarque que dans la classe Jouable, autant définir direct les coordonnées dans la classe.
        if (deplacement == 0) { //Manal : A quoi correspond "déplacement" ?
            if (y > 0 && this.C.getMatrice()[x][y-1] == 0) { // Vérifie si le mouvement est possible //Manal: Mettez ça dans une méthode à part, qui vous retourne True si le mouvement est possible.
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
//                this.C.getMatrice()[x][y] = 0; 
                y--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); // Met à jour la nouvelle position du 1  
//                this.C.getMatrice()[x][y] = 1;               
//                this.C.afficherMatrice(); // appel de la méthode afficherMatrice() après chaque déplacement             
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
            }
        } else if (deplacement == 1) {
            if (y < this.C.getMatrice()[0].length-1 && this.C.getMatrice()[x][y+1] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1 Modification du setteur car setter modifie la matrice mais pas ses éléments !!!
//                this.C.getMatrice()[x][y] = 0; j'ai laissé en commentaire les anciennes parties du programme je les retires après le prochain cours d'info
                y++;
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
               // this.C.afficherMatrice();j'ai laissé en commentaire les anciennes parties du programme je les retires après le prochain cours d'info   
            }
            else{
                System.out.print("déplacement impossible vers le haut");
            }         
        } else if (deplacement == 2){
            if (x > 0 && this.C.getMatrice()[x-1][y] == 0) { // Vérifie si le mouvement est possible
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
//                this.C.getMatrice()[x][y] = 0; 
                x--; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
//                this.C.getMatrice()[x][y] = 1; //
//                this.C.afficherMatrice();
            }
            else{
                System.out.print("déplacement impossible vers la gauche");
            }
            
        } else if (deplacement == 3){
            if (x < this.C.getMatrice().length-1 && this.C.getMatrice()[x+1][y] == 0) { // Vérifie si le mouvement est possible
//                this.C.getMatrice()[x][y] = 0;
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                MapMod.setMatrice(x, y, 1); //this.C.getMatrice()[x][y] = 1; 
//                this.C.getMatrice()[x][y] = 1;
//                this.C.afficherMatrice();
            }
            else{
                System.out.print("déplacement impossible vers la droite");
            }
        }
        this.C.afficherMatriceV2(MapMod);
        return MapMod;
    }
    
}
