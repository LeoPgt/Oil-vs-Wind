/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;


/**
 *
 * @author mleconte
 */

public class Jouable {
    protected int joueur ;
    private int x;
    private int y;
    
    public Jouable (int x, int y) {
        this.joueur = 1;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int [] localisation(){ 
        int [] Coordo = new int[2];
        Coordo[0]=this.getX();
        Coordo[1]= this.getY();
        return Coordo;
    }

    @Override
    public String toString() {
        return "Jouable{" + "Le joueur se trouve en" + joueur + ", x=" + x + ", y=" + y + '}';
    }
  
    // je faisdes modifs pour push
}
