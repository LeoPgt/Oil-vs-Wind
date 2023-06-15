/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 *
 * @author mleconte
 */

// Element regroupera la classe obstacle et la classe Jouable

public class Element {
    private int x;
    private int y;
    
    public Element (int x, int y) {
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
    
    
    public int [] localisationElement(){ 
       int [] Coordo = new int[2];
       Coordo[0]=this.getX();
       Coordo[1]= this.getY();
       return Coordo;
    }
    
    @Override
    public String toString() {
        return "Element{" + "L'element se trouve en x=" + this.x + ", y=" + this.y + '}';
    }
    
}
