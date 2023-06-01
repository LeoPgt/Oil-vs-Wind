/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.KeyListener;

/**
 *
 * @author alaunay
 */
public class Aurélia_FenetreDeJeu extends JFrame implements ActionListener {

    private Aurelia_Jeu jeu;
    private EcouteurClavier keyL;
    private MapData Map;
    private final Timer timer;
    

    
    public Aurélia_FenetreDeJeu() throws IOException{
        // Creation du jeu
        this.jeu = new Aurelia_Jeu();
        
        //Ajout du listener ici
        this.keyL = new EcouteurClavier(jeu); //Of course on le met APRES avoir déclaré Jeu()....
        this.addKeyListener(this.keyL);

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        
        this.Map = new MapData();
        

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(40, this);
        this.timer.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tile Mapping Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new DisplayMap.MapPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
     public void actionPerformed(ActionEvent e) {
        //Les fameuses deux étapes importantes : MiseàJour et rendu qu'on trouve dans la classe Jeu.
        this.jeu.miseAJour();
        this.jeu.afficherMap();
        
        
    }
}
