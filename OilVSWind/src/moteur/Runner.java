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
   // un private avec l'élement distinguant le runner private int vitesse;
    private int vitesseRunner;
    private boolean capturePossible;
   // les coordonnées x,y seront différentes pour les spawns  
    public Runner(int ID, int x, int y, int vitesseRunner){
        super (ID, x , y);
        this.vitesseRunner = vitesseRunner;
        // spawn a côté de l'éolienne à définir
    }     
    public void setVitesse(int newVitesse){
        this.vitesseRunner = newVitesse;
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
        if(this.capturePossibleGet() == true){
          this.capturePossible = true;
       }
       else{
           this.capturePossible= false;
       }
   }        
}
