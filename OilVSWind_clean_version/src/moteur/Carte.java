/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import java.util.ArrayList;
import utilitaire.*;

/**
 * Cette classe permet de créer une carte qui est une matrice où à l'intérieur de chaque case se trouve une liste d'élements
 * @author mleconte
 */
public class Carte {
    private int largeur;
    private int hauteur;
    private Cases[][] matrice; 
    
    private ArrayList<Coordonnee> Spots; //Les spots d'apparition
    
    public Carte (int largeur, int hauteur) {
        
        this.largeur = largeur;
        this.hauteur = hauteur;
        
        this.matrice = new Cases[largeur][hauteur]; // Crée une matrice
        this.Spots = new ArrayList<Coordonnee>();
        
    }

    public ArrayList<Coordonnee> getSpots() {
        return Spots;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
   
    
    public Cases[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int i, int j, Cases valeur) {
        this.matrice[i][j] = valeur;
    }
    
    @Override
    public String toString() {
        String str = "";
        for(int j = 0; j < hauteur; j++){
            for(int i = 0; i< largeur; i++){
                
                if (this.matrice[i][j].isMur()){
                    str += "2 ";
                }
                else{
                    str += "0 ";
                }

            }
            str += "\n";
        }
        return str;
    }
    
}