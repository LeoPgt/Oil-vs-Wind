/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
/**
 * Le but de cette classe sera de traduire la carte en termes de 0 = Vide ,1 = Runner , 2 = Mur, 3= BarilB1 , 4 = BarilB2 , 5 = BarilB3, 6 = Bonus
 * @author mleconte
 */
public class Carte {
    int size;
    private int[][] matrice; 

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int i, int j, int valeur) {
        this.matrice[i][j] = valeur;
    }
    
    public Carte (int hauteur,int largeur) {
        this.matrice = new int[hauteur][largeur]; // Crée une matrice
        this.matrice[0][0] = 1; // Initialise la position de départ du 1 (ce sera la place initial du joueur)
        this.matrice[4][4] = 3; // Initialise une position de départ du Baril B1 (ce sera la place initial du baril B1)
    }
     public Carte (int [][]Matrice,int x,int y){
         
     }
    public int getSize() {
        return size;
    }

    
    //Manal : Idem, ça peut être dans un toString ça.
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
                if(Map.getMatrice()[i][j]==3){
                   System.out.print("3");               
                }                
            }    
           System.out.println();
        }
    }
}
    // Affichge Matrice Validée plein de conflit pour l'apparition de nouveau éléments