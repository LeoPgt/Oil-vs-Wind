/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jeu;

import moteur.Baril;
import moteur.Carte;
import moteur.Jouable;
import clavier.Clavier;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import moteur.Runner;
import moteur.Jeu;
import moteur.Jouable;
import ig.InterfaceClavier;
import ig.DisplayBis;

/**
 *
 * @author rmorel
 */
public class JeuConcaténé {

    protected boolean gauche, droite, haut, bas;
    private Carte C;
    private InterfaceClavier Clavier;
    private DisplayBis MapTitle;
    private Runner runner;
    private ArrayList<Baril> barrilJoueur;
    private int tailleCase; //Manal : N'est pas sensé etre ici (mais on le laisse pour l'instant)
    
    public JeuConcaténé (int taillecase) {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.MapTitle = MapTitle;
        this.C = new Carte(this.MapTitle.getMAP_DATA());
//        int carteSize = C.getSize();   // pas encore vu l'utilité
        this.runner = new Runner(0,0,1);
        //BARIL
        this.barrilJoueur = new ArrayList<Baril>();
        Baril B1 = new Baril(3, 1, 1);
        this.barrilJoueur.add(B1);
        Baril B2 = new Baril(4, 2, 2);
        this.barrilJoueur.add(B2);
        Baril B3 = new Baril(5, 3, 3);
        this.barrilJoueur.add(B3);
        //this.barrilJoueur.indexOf(B1); //Retourne indice de B1 donc 0
        //this.barrilJoueur.get(0); //retourne l'objet d'indice 0 donc B1
        
        this.tailleCase = taillecase;
    }
    

    public void partie(){
        Jeu règle = new Jeu(2);
        Carte Map = new Carte(5,5); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//      Map.afficherMatriceV2(Map);
        int bouclage = 10;
        int essai = 0;
        while (essai != bouclage){
            this.bas = this.Clavier.isBas();
            this.haut = this.Clavier.isHaut();
            this.droite = this.Clavier.isDroite();
            this.gauche = this.Clavier.isGauche();
            Carte MapMod = règle.MiseAJour(Joueur, Map);// début du bouclage de la mj
            Map = MapMod;
            this.gauche = false;
            this.droite = false;
            this.haut = false;
            this.bas = false;            
        }
    }

}
  
