/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

/**
 *
 * @author mleconte
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moteur.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JeuIGTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JeuIG Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                // Création d'un objet Jeu
                Jeu jeuMoteur = new Jeu();
                
                // Création d'un objet JeuIG
                JeuIG jeuIG = new JeuIG(jeuMoteur,30,32,g2d);
                
                // Obtention de l'image de la carte du JeuIG
                BufferedImage carteImage = jeuIG.DessinerCarte();
                
                // Affichage de l'image de la carte
                g2d.drawImage(carteImage, 0, 0, null);
            }
        };
        
        frame.getContentPane().add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
