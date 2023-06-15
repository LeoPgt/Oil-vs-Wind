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
    private int numero;
    private String pseudo;
    
    public Jouable (String pseudo, int numero, int x, int y) {
        super (x, y);
        this.numero = numero;
        this.pseudo = pseudo;
    }
    
    
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    @Override
    public String toString() {
        return "Jouable{" + "Le jouable a comme id" + this.numero + '}';
    }
    
}
