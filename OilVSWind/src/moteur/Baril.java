/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
/**
 *
 * @author mleconte
 */

/**
     * 
     * @version 1 ( la version 2 consistera à mettre la carte dans la boucle avec des requetes lié à la classe joueursqui lui même sera lié à du déplacement sur la carte )
      déplace le joueur de 5 à gauche ou à droite sur l'axe des abscisses / ordonnées 
     */
public class Baril extends Jouable {
    private boolean capturable;
    private boolean capturais;
            
    public Baril(int x, int y){
        super (x , y);
        this.capturable=true;
        this.capturais=false;
        // condition pour spawn random que pour le mouton
    }

    public void capturablableSett (boolean modif){ // modif peut etre true ou false selon la situation définie
        this.capturable=modif;
    }
    
    public boolean capturableGet(){
        return this.capturable;
    }

    public boolean capturaisGet() {
        return capturais;
    }

    public void setCapturais(boolean capturais) {
        this.capturais = capturais;
    }
   
   public void Capturable (boolean collisionLoupMouton){
       boolean capturais = false;
       if(collisionLoupMouton == true & this.capturableGet() == true){
           this.capturablableSett(true);
       }
       else{
           this.capturablableSett(false);
       }
   }
}
