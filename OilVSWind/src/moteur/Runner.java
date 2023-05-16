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
   // un private avec l'élement distinguant le loup private int vitesse;
    private int vitesseLoup;
    private boolean capturePossible;
   // les coordonnées x,y seront différentes pour les spawns  
    // constructeur Règle loup
    public Runner(int x, int y, int vitesseLoup){
        super (x , y);
        this.vitesseLoup=vitesseLoup;
        // spawn a côté de l'éolienne à définir
    }     
    public void setVitesse(int newVitesse){
        this.vitesseLoup = newVitesse;
    }
    public int getVitesse(){
        return this.vitesseLoup;
    }
    public boolean capturePossibleGet() {
        return capturePossible;
    }
    public void CapturePossibleSet(boolean capturePossible) {
        this.capturePossible = capturePossible;
    }
    // Le loup ne peut capture un bidon ssi il n'as pas déjà attrapé un bidon
   public void capturePossible (){
        if(this.capturePossibleGet() == true){
          this.capturePossible = true;
       }
       else{
           this.capturePossible= false;
       }
   }        
}
