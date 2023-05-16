/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import java.util.Random;
/**
 * Le but de cette classe sera de traduire la carte en termes de 0 = vide ,1 = joueur , 2 = obstacle
 * @author mleconte
 */
public class Carte {
    private int[][] matrice; 

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int i, int j, int valeur) {
        this.matrice[i][j] = valeur;
    }
    
    public Carte (int taille, int nbrObstacle, int nbrPerso) {
        matrice = new int[taille][taille]; // Crée une matrice de 50x50 remplie de 0 (mod 02/05 romain)
        for (int k=0;k< nbrObstacle;k++){ // Placement des obstacles de manière aléatoires pour le moment productowner !
            int indexRandom = (int)(Math.random()*(matrice.length));
            int indexRandom2 = (int)(Math.random()*(matrice.length)); //Manal : Attention aux noms de variables pas claires. Mais ok !
            matrice[indexRandom][indexRandom2] = 2;
        }
        int Placer = 0;
        while (Placer != nbrPerso-1){
            for (int k=0; k<nbrPerso;k++ ){
                int index1Joueurk = (int)(Math.random()*(matrice.length));
                int index2Joueurk = (int)(Math.random()*(matrice.length));
                matrice[index1Joueurk][index2Joueurk]=1;
            }
            Placer++;
        }
  //  matrice[0][0] = 1; // Initialise la position de départ du 1 (ce sera la place initial du joueur) futur gestion de ce dernier
    }
    
    public void spwan(Carte Map, int nbrJoueur){
        matrice = Map.getMatrice();
        for (int k=0; k<nbrJoueur;k++ ){
            int index1Joueurk = (int)(Math.random()*(matrice.length));
            int index2Joueurk = (int)(Math.random()*(matrice.length));
            while (matrice[index1Joueurk][index2Joueurk] == 1)    
                k=k-1;
            }
    }
    // Affichge Matrice Validée plein de conflit pour l'apparition de nouveau éléments
    
    public void afficherMatrice() { //Manal : Idem, ça peut être dans un toString ça.
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 1) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
       
    
    // affichage créer pour les maps après déplacement ou futur modification cartographique obstacle apparait ! 
    
    public void afficherMatriceV2(Carte Map){
       int[][] carteMatricielle = Map.getMatrice();
       for (int i = 0; i< carteMatricielle.length; i++){
           for (int j=0; j< carteMatricielle[i].length;j++){
               if(Map.getMatrice()[i][j]==1){
                   System.out.print("1");
               }
               if(Map.getMatrice()[i][j]==2){
                   System.out.print("2");
               }
                if(Map.getMatrice()[i][j]==0){
                   System.out.print("0");               
                }
            }    
           System.out.println();
        }
    }
}
