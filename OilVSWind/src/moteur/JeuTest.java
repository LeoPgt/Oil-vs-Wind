/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moteur;
import Archives.igMethode;
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
        Jeu jeu = new Jeu();
        
        // Test du déplacement du Runner
        jeu.setDroite(true);
        System.out.println("Déplacement du Runner : Droite");
        System.out.println("Déplacement possible : " + jeu.deplacementEstPossible(jeu.getRunner()));
        
        // Test de la mise à jour de la carte
        System.out.println("Mise à jour de la carte");
        Carte nouvelleCarte = jeu.MiseAJour(jeu.getRunner(), jeu.getCarteMoteur());
        System.out.println("Nouvelles positions du Runner : " + jeu.getRunner().getX() + ", " + jeu.getRunner().getY());
        
        // Affichage de la carte modifiée
        System.out.println("Carte modifiée :");
        nouvelleCarte.toString();
        
        // Test de la fin du jeu
        System.out.println("Jeu terminé : " + jeu.partieMoteurV2());
    }
}

