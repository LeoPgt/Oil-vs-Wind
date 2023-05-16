/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;


/**
 *
 * @author mleconte
 */

public class Jouable {
    protected int joueur ;
    private Carte c;
    
    public Jouable () {
        this.joueur = 1;
    }
    
    public int [] localisation(Carte carteDeJeu){
        int [] Coordo = new int[2];
        int [][] matrice = carteDeJeu.getMatrice();
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 1) {
                Coordo[0]=i;
                Coordo[1]=j;
                }
            }
        }
        return Coordo;
    }

    public void afficheCoordo(){
        int x1= this.localisation(c)[0];
        int y1= this.localisation(c)[1];
        System.out.print(x1 + "  "+ y1);
        
    }
    
}
