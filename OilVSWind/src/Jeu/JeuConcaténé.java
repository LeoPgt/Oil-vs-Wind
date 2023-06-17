///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Jeu;
//
//
//import moteur.Baril;
//import moteur.Carte;
//import moteur.Jouable;
//import clavier.Clavier;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import moteur.Runner;
//import moteur.Jouable;
//import ig.InterfaceClavier;
//import ig.DisplayBis;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//import ig.igMethode;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.JPanel;
//import moteur.Element;
//import moteur.Regles;
//
///**
// *
// * @author rmorel
// */
//public class JeuConcaténé {
//
//    protected boolean gauche, droite, haut, bas;
//    private Carte C;
//    private InterfaceClavier Clavier;
//    private DisplayBis MapTitle;
//    private Runner runner;
//    private ArrayList<Baril> barrilJoueur;
//    private int tailleCase; //Manal : N'est pas sensé etre ici (mais on le laisse pour l'instant)
//    
//    public JeuConcaténé (int taillecase) {
//        this.gauche = false;
//        this.droite = false;
//        this.haut = false;
//        this.bas = false;
//        this.MapTitle = MapTitle;
//        this.C = new Carte(this.MapTitle.getMAP_DATA());
////        int carteSize = C.getSize();   // pas encore vu l'utilité
//        this.runner = new Runner(4,"JoueurCours",0,0,1);
//        //BARIL
//        this.barrilJoueur = new ArrayList<Baril>();
//        Baril B1 = new Baril(0,"Joueur1",3, 1, 1,false);
//        this.barrilJoueur.add(B1);
//        Baril B2 = new Baril(1,"Joueur2",4, 2, 2,false);
//        this.barrilJoueur.add(B2);
//        Baril B3 = new Baril(2,"Joueur3",5, 3, 3,false);
//        this.barrilJoueur.add(B3);
//        //this.barrilJoueur.indexOf(B1); //Retourne indice de B1 donc 0
//        //this.barrilJoueur.get(0); //retourne l'objet d'indice 0 donc B1
//        
//        this.tailleCase = taillecase;
//        addKeyListener(new KeyAdapter() {
//        public void keyPressed(KeyEvent e) {
//            int keyCode = e.getKeyCode();
//            System.out.println("keyCode=" + keyCode);
//        }
//    });
//    }
//
//    public boolean isGauche() {
//        return gauche;
//    }
//
//    public boolean isDroite() {
//        return droite;
//    }
//
//    public boolean isHaut() {
//        return haut;
//    }
//
//    public boolean isBas() {
//        return bas;
//    }
//    
//    public void setDeplacement(ArrayList<Boolean> GDBH, int placementArayList,boolean vraiOufaux){    
//            GDBH.set(0,this.isGauche());
//            GDBH.set(1,this.isDroite());
//            GDBH.set(2,this.isBas());
//            GDBH.set(3,this.isHaut());
//    }
//    
//    public ArrayList getDeplacement(ArrayList<Boolean> GDBH){
//            GDBH.set(0,this.isGauche());
//            GDBH.set(1,this.isDroite());
//            GDBH.set(2,this.isBas());
//            GDBH.set(3,this.isHaut());
//        return GDBH;
//    }
////        ArrayList<Boolean> GDBH = new ArrayList<>();
//    public void partie(){
//        InterfaceClavier Clavier = new InterfaceClavier();
//        Carte Map = this.C; // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//        Regles règle = new Regles(2,this.C);
//        règle.partieMoteurV2();
//        Jouable Joueur = new Jouable("Skylze",0,1,1);// id, x , y
//        SwingUtilities.invokeLater(() -> {
//        JFrame frame = new JFrame("OIL VS WIND");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new igMethode.MapPanel());
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        });
//        int bouclage = 100000000;
//        int essai = 0;
//        while (essai != bouclage){
//            Carte MapMod = règle.MiseAJour(Joueur, Map);// début du bouclage de la mj
//            Map = MapMod;
//            Clavier.recuperationClavier();
//           
//        }
//    }
//
//}
//  
