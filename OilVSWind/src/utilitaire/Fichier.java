/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import moteur.*;

/**
 *
 * @author mleconte
 */
public class Fichier {
    
    private String nomfichier;
    private Carte c;

    public Fichier(String nomfichier) {
        this.nomfichier = nomfichier;
       
    }
    
    public void lireFichier(){
        
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(this.nomfichier));
            int j = 0;
            int largeur = 0;
            int hauteur = 0;
            while (fichier.ready()){
                String ligne;
                ligne = fichier.readLine();
                
                //Lecture dimension
                if(j == 0){
                    largeur = Integer.parseInt(ligne);
                }
                
                if(j == 1){
                    hauteur = Integer.parseInt(ligne);
                    this.c = new Carte(largeur, hauteur);
                }
                if (j >= 2){
                    String champs[] = ligne.split( " " );

                    for(int i = 0; i < champs.length; i++){
                        
                        Cases cases = new Cases(i, j-2);
                        c.getMatrice()[i][j-2] = cases;
                        
                        if(champs[i].equals("2")){
                            Mur m = new Mur(i, j-2);
                            c.getMatrice()[i][j-2].setMur(m);
                        }
                        if(champs[i].equals("S")){
                            c.getSpots().add(new Coordonnee(i, j-2));
                        }
                        if(champs[i].equals("6")){
                            Bonus b = new Bonus(i, j-2);
                            c.getMatrice()[i][j-2].addBonus(b);
                        }
                    }
                }
            j++;
            }
            
            fichier.close();
        }catch( IOException e) {
            e.printStackTrace() ;
        }
        
        
    }

    public Carte getCarte() {
        return c;
    }
    
}
