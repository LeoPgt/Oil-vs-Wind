/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import java.util.Random;
import moteur.AABB;
/**
 *
 * @author rmorel
 */
public class Regle_Mouton extends Joueur {
    private int x;
    private int z;
    
    public Regle_Mouton(){
        this.x=0;
        this.y=0;
        // condition pour spawn random que pour le mouton
    }
    
    
   public boolean Capturable (boolean collisionLoupMouton,boolean capturable){
       boolean capture;
       if(collisionLoupMouton == true & capturable == true){
           capture=true;
       }
       else{
           capture=false;
       }
    return capture;
   }
   
   
}
