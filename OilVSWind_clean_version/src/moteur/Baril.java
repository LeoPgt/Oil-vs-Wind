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
    private int idSQL;
            

    public Baril(int idSQL, String pseudo, int x, int y, boolean capturable){
        super(pseudo,"baril",x,y);
        this.capturable=true;
        this.idSQL = idSQL;
        // condition pour spawn random que pour le mouton
    }
    
    public int getIdSQL(){
        return idSQL;
    }
    
    public void capturableSet (boolean modif){ // modif peut etre true ou false selon la situation définie
        this.capturable=modif;
    }
    
    public boolean capturableGet(){
        return this.capturable;
    }
}
