/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 *
 * @author mleconte
 */
//public class Bonus extends Decor {
//    
//}
public class Bonus extends Decor {
    private boolean capturable;
    
    public Bonus(int x, int y) {
        super(6, x, y);
        this.capturable=true;
    }
    
    public void capturableSet (boolean modif){ // modif peut etre true ou false selon la situation définie
        this.capturable=modif;
    }
    
    public boolean capturableGet(){
        return this.capturable;
    }
}
