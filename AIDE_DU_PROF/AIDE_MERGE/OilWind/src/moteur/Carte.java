/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import java.util.ArrayList;
import java.util.Random;
import utilitaire.*;

/**
 * Le but de cette classe sera de traduire la carte en termes de 0 = Vide ,1 = Runner , 2 = Mur, 3= BarilB1 , 4 = BarilB2 , 5 = BarilB3, 6 = Bonus
 * @author mleconte
 */
public class Carte {
    private int largeur;
    private int hauteur;
    private Cases[][] matrice; 
    
    private ArrayList<Coordonnee> Spots; //Les spots d'apparition
    
    public Carte (int largeur, int hauteur) {
        
        this.largeur = largeur;
        this.hauteur = hauteur;
        
        this.matrice = new Cases[largeur][hauteur]; // Crée une matrice
        this.Spots = new ArrayList<Coordonnee>();
        
        
        //placement Runner
//        Random random = new Random();
//        
//        int x = random.nextInt(this.largeur);
//        int y = random.nextInt(this.hauteur);
//        
//        
//        this.matrice[x][y].addJouable(e); // Initialise la position de départ du 1 (ce sera la place initial du joueur)
        
    }

    public ArrayList<Coordonnee> getSpots() {
        return Spots;
    }
   

    public Cases[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int i, int j, Cases valeur) {
        this.matrice[i][j] = valeur;
    }
    
    

    
    //Manal : Idem, ça peut être dans un toString ça.
//    public void afficherMatriceV2(Carte Map){
//       Cases[][] carteMatricielle = Map.getMatrice();
//       for (int i = 0; i< carteMatricielle.length; i++){
//           for (int j=0; j< carteMatricielle[i].length;j++){
//               if(Map.getMatrice()[i][j]==1){
//                   System.out.print("1");
//               }
//               if(Map.getMatrice()[i][j]==2){
//                   System.out.print("2");
//               }
//                if(Map.getMatrice()[i][j]==0){
//                   System.out.print("0");               
//                }
//                if(Map.getMatrice()[i][j]==3){
//                   System.out.print("3");               
//                }                
//            }    
//           System.out.println();
//        }
//    }
//    
//    public void correctionMatrice(Carte Mapfausse){
//               Cases[][] carteMatricielle = Mapfausse.getMatrice();
//       for (int i = 0; i< carteMatricielle.length; i++){
//           for (int j=0; j< carteMatricielle[i].length;j++){
//               if(Mapfausse.getMatrice()[i][j]==1){
//                   System.out.print("2,");
//               }
//               if(Mapfausse.getMatrice()[i][j]==2){
//                   System.out.print("0,");
//               }
//            }    
//           System.out.println();
//        }
//    }
//    
//}
//    // Affichge Matrice Validée plein de conflit pour l'apparition de nouveau éléments

    @Override
    public String toString() {
        String str = "";
        for(int j = 0; j < hauteur; j++){
            for(int i = 0; i< largeur; i++){
                
                if (this.matrice[i][j].isMur()){
                    str += "2 ";
                }
                else{
                    str += "0 ";
                }

            }
            str += "\n";
        }
        return str;
    }
    
}