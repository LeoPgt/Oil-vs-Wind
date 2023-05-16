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
    private int x;
    private int y; //Manal : Ces coordonnées peuvent être hérité de Jouable !
    
    public Baril(){
        this.x=0;
        this.y=0;
        // condition pour spawn random que pour le mouton
    }
    
    
   public boolean Capturable (boolean collisionLoupMouton,boolean capturable){
       boolean capture;
       if(collisionLoupMouton == true & capturable == true){
           capture=true; //Manal : Ca peut être des attributs du Baril ça non ?
       }
       else{
           capture=false;
       }
    return capture;
   }
}
