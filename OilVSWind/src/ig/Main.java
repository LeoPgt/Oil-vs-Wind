/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import moteur.Jeu;

/**
 *
 * @author mleconte
 */
public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        // Créez la fenêtre de l'application
        new Fenetre(jeu);
    }
}