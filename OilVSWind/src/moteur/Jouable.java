/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;


/**
 *
 * @author mleconte
 */
 
 //1 = Runner, 3= BarilB1 , 4 = BarilB2 , 5 = BarilB3

public class Jouable extends Element {
    private int ID;
    
    public Jouable (int ID, int x, int y) {
        super (x, y);
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        return "Jouable{" + "Le jouable a comme id" + this.ID + '}';
    }
    
}
