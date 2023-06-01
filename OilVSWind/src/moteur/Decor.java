/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 *
 * @author mleconte
 */
public class Decor extends Element {
    private int numero;
    
    public Decor (int numero, int x, int y) {
        super (x, y);
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return "Decor{" + "Le décor a comme numero" + this.numero + '}';
    }
    
}