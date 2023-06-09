/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author alaunay
 */
public class Aurélia_FenetreDeJeu extends JFrame  {
//implements ActionListener
    private Aurelia_Jeu jeu;
    private Graphics2D contexte;
    private EcouteurClavier keyL;
    private MapData Map;
//    private final Timer timer;
    private BufferedImage framebuffer;
    private JLabel jLabel1;
    private Personnages joueur;
    private BufferedImage joueur1;
    

    
    public Aurélia_FenetreDeJeu() throws IOException{
        // Creation du jeu
        this.setSize(607, 380);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(607, 380));
        this.setContentPane(this.jLabel1);
        this.pack();
        
        
     
        this.jeu = new Aurelia_Jeu();
        
        //Ajout du listener ici
        this.keyL = new EcouteurClavier(this.jeu); //Of course on le met APRES avoir déclaré Jeu()....
        this.addKeyListener(this.keyL);
        
        this.framebuffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(framebuffer));
        this.contexte = this.framebuffer.createGraphics();
//this.contexte= Map.afficherMap() ;
        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        
//        this.Map = new MapData();
        

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
//        this.timer = new Timer(40, this);
//        this.timer.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fenetre de jeu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             try {
                 frame.getContentPane().add(new MapData());
             } catch (IOException ex) {
                 Logger.getLogger(Aurélia_FenetreDeJeu.class.getName()).log(Level.SEVERE, null, ex);
             }
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
             
        });
    }
    
//    @Override
//     public void actionPerformed(ActionEvent e) {
//        //Les fameuses deux étapes importantes : MiseàJour et rendu qu'on trouve dans la classe Jeu.
////        this.jeu.miseAJour();
//        this.joueur.paintComponent(contexte);
//        
//        this.jLabel1.repaint();
//    }
//     
//     
}
        