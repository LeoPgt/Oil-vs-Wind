/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moteur;

/**
 *
 * @author rmorel
 */
public class JeuTest {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carte Monde = new Carte();
        Jeu partie = new Jeu();
        //Monde.afficherMatrice();
        //partie.MiseAJourCourte(true);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
// 0 haut 1 droite 2 gauche 3 bas
  partie.MiseAJour(1, Monde);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
 //       partie.MiseAJour(1, partie.MiseAJour(1, Monde));
    }
    
}
