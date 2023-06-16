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

public class PanneauControl extends JPanel {

    private JButton buttonJoueur;
    private JTextField fieldPseudo;
    private Jeu jeu;
    private PanneauJeu panneauJeu;

    public PanneauControl(Jeu jeu, PanneauJeu panneauJeu) {
        this.jeu = jeu;
        this.panneauJeu = panneauJeu;
        
        fieldPseudo = new JTextField(20);
        this.add(new JLabel("Pseudo:"));
        this.add(fieldPseudo);

        buttonJoueur = new JButton("Joueur");
        buttonJoueur.addActionListener(e -> buttonJoueurClicked());
        this.add(buttonJoueur);
    }

    private void buttonJoueurClicked() {
        String pseudo = fieldPseudo.getText();
        if (!pseudo.isEmpty()) {
            // Faire quelque chose avec 'pseudo'
            // Faire le jeu de début, etc.
            panneauJeu.rafraichir(); // Rafraîchir l'interface de jeu
        }
    }
}