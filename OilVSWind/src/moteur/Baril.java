/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
/**
 *
 * @author mleconte
 */

// Ici capturable veut dire que le baril n'a pas encore été pris par le RUNNER
public class Baril extends Jouable {
    private boolean capturable;
            
    public Baril(int ID, int x, int y){
        super(ID,x,y);
        this.capturable=true;
        // condition pour spawn random que pour le mouton
    }

    public void capturableSet (boolean modif){ // modif peut etre true ou false selon la situation définie
        this.capturable=modif;
    }
    
    public boolean capturableGet(){
        return this.capturable;
    }
}
