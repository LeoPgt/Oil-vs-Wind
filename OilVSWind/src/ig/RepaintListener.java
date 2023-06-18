/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import moteur.Jeu;

/**
 *
 * @author manal.benaissa
 */
public class RepaintListener implements ActionListener{
    
    private JeuIG jeu;
    private Jeu jeuMoteur;
    
    private Graphics2D contexte;
    private JLabel jLabel1;

    public RepaintListener(JeuIG jeu, Jeu jeuMoteur, JLabel jLabel1, Graphics2D contexte) {
        this.jeu = jeu;
        this.jeuMoteur = jeuMoteur;
        this.jLabel1 = jLabel1;
        this.contexte = contexte;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
            boolean jeuTermine = jeuMoteur.partieMoteurV2();

            // Mettre à jour les positions des personnages
            this.jeu.miseAJour();
            this.jeu.rendu(contexte);
            // Redessiner l'affichage
        
            //Ca c'est juste pour appliquer le rendu()...
            this.jLabel1.repaint();
    }
    
}
