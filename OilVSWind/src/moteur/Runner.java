/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import moteur.AABB;
/**
 *
 * @author rmorel
 */
public class Runner extends Joueur{
   // un private avec l'élement distinguant le loup private int vitesse;
   // besoin de l'envoie de la calsse Perso
    private int vitesseLoup;
    private int x;
    private int y;
   // les coordonnées x,y seront différentes pour les spawns
    // constructeur Règle loup
    public Runner(int vitesseLoup,int x, int y){
        
        this.vitesseLoup=vitesseLoup;
        this.x=x;
        this.y=y;
        // spawn a côté de l'éolienne à définir
    }

    

    
          
   //setteur de reférence
    public void setVitesse(int newVitesse){
        this.vitesseLoup = newVitesse;
    }
    
    public int getVitesse(){
        return this.vitesseLoup;
    }

    // Le loup ne peut capture un bidon ssi il n'as pas déjà attrapé un bidon
   public boolean capturePossible (boolean Attrapé){
       boolean capturable;
       if(Attrapé == true){
           capturable = false;
       }
       else{
           capturable = true;
       }
    return capturable;
   }    
    
       
       
       
}
