/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utilitaire;
import moteur.Carte;

/**
 *
 * @author manal.benaissa
 */
public class TestFichier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Carte c = new Carte(25,40);

       Fichier F = new Fichier("src/resources/carte.txt");
       F.lireFichier();
       System.out.println(F.getCarte().toString());
       
    }
    
}
