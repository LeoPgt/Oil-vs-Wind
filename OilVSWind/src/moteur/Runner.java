/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
/**
 *
 * @author rmorel
 */
public class Runner extends Jouable{
    private int vitesseRunner;
    private boolean capturePossible;
   // les coordonnées x,y seront différentes pour les spawns  
    public Runner(int ID, int x, int y, int vitesseRunner){
        super (1, x , y); // le numéro de Runner sera 1 en terme de matrice.
        this.vitesseRunner = vitesseRunner;
        // spawn a côté de l'éolienne à définir
    }     
    public void setVitesse(){
        this.vitesseRunner = vitesseRunner*2; // Augmente sa vitesse * 2 
    }
    public int getVitesse(){
        return this.vitesseRunner;
    }
    public boolean capturePossibleGet() {
        return capturePossible;
    }
    public void CapturePossibleSet(boolean capturePossible) {
        this.capturePossible = capturePossible;
    }
    // Le Runner ne peut capturer un baril s'il n'est pas sur la même case que la baril
   public void capturePossible (){
       this.capturePossible = this.capturePossibleGet() == true;
   }        
}
