/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

/**
 *
 * @author mleconte
 */
import java.awt.Graphics;
import javax.swing.*;
import moteur.Jeu;

public class PanneauJeu extends JPanel {

    private Jeu jeu;

    public PanneauJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessinez ici le jeu en utilisant les informations de 'jeu'
        // Utilisez g.drawImage() pour dessiner chaque élément du jeu
    }

    public void rafraichir() {
        // Ceci est appelé chaque fois qu'une mise à jour de l'interface est nécessaire
        repaint();
    }
}