/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 * Le but de cette classe sera de traduire la carte en termes de 0 = vide ,1 = joueur , 2 = obstacle
 * @author mleconte
 */
public class Carte {
    private int[][] matrice; 

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }
    
    public Carte () {
        matrice = new int[50][50]; // Crée une matrice de 50x50 remplie de 0
        matrice[0][0] = 1; // Initialise la position de départ du 1 (ce sera la place initial du joueur)
    }
        
    
    public void afficherMatrice() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 0) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
}
