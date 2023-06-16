/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

/**
 *
 * @author mleconte
 */
import javax.swing.*;
import moteur.Jeu;

public class Fenetre extends JFrame {
    private Jeu jeu;
    private PanneauJeu panneauJeu;
    private PanneauControl panneauControl;

    public Fenetre(Jeu jeu) {
        this.jeu = jeu;
        this.setTitle("Jeu Pacman");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panneauJeu = new PanneauJeu(jeu);
        panneauControl = new PanneauControl(jeu, panneauJeu);

        this.getContentPane().add(panneauJeu, BorderLayout.CENTER);
        this.getContentPane().add(panneauControl, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
