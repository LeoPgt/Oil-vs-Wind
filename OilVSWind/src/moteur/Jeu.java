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
    private int x;// x est le nombre de lignes 
    private int y; // y est le nombre de colonnes
    private Carte C;
    
    
    public Jeu () {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.x=0;
        this.y=0;
        this.C = new Carte();
    }
    
   /**
     * Déplace le joueur sur l'axe des abscisses et des ordonnées en ayant conscience de la carte
     * @version 1
     * @return une matrice de 0 et le joueur qui représente le 1
     */   
    public void MiseAJour() {
        if (this.gauche) {
            if (y > 0 && this.C.getMatrice()[x][y-1] == 0) { // Vérifie si le mouvement est possible
                this.C.getMatrice()[x][y] = 0; // Efface la position actuelle du 1
                y--; // Met à jour la position du 1
                this.C.getMatrice()[x][y] = 1; // Met à jour la nouvelle position du 1
                this.C.afficherMatrice(); // appel de la méthode afficherMatrice() après chaque déplacement
         
            }
        } else if (this.droite) {
            if (y < this.C.getMatrice()[0].length-1 && this.C.getMatrice()[x][y+1] == 0) { // Vérifie si le mouvement est possible
                this.C.getMatrice()[x][y] = 0; // Efface la position actuelle du 1
                y++; // Met à jour la position du 1
                this.C.getMatrice()[x][y] = 1; // Met à jour la nouvelle position du 1
                this.C.afficherMatrice();
            }
        } else if (this.haut) {
            if (x > 0 && this.C.getMatrice()[x-1][y] == 0) { // Vérifie si le mouvement est possible
                this.C.getMatrice()[x][y] = 0; // Efface la position actuelle du 1
                x--; // Met à jour la position du 1
                this.C.getMatrice()[x][y] = 1; // Met à jour la nouvelle position du 1
                this.C.afficherMatrice();
            }
        } else if (this.bas) {
            if (x < this.C.getMatrice().length-1 && this.C.getMatrice()[x+1][y] == 0) { // Vérifie si le mouvement est possible
                this.C.getMatrice()[x][y] = 0; // Efface la position actuelle du 1
                x++; // Met à jour la position du 1
                this.C.getMatrice()[x][y] = 1; // Met à jour la nouvelle position du 1
                this.C.afficherMatrice();
            }
        }
    }
    
}
