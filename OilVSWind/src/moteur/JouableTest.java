/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moteur;

/**
 *
 * @author rmorel
 */
public class JouableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carte Map = new Carte();
        Jouable Joueur = new Jouable();
        Joueur.localisation(Map);
        Joueur.afficheCoordo();
    }
    
}
