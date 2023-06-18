/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import java.util.ArrayList;



/**
 *
 * @author manal.benaissa
 */
public class Cases {
    
    private Mur mur;
    private ArrayList<Bonus> listeBonus;
    private ArrayList<Jouable> listeJouable;
    private int x;
    private int y;

    public Cases(int x, int y) {
        this.x = x;
        this.y = y;
        
        this.mur = null;
        this.listeBonus = new ArrayList<Bonus>();
        this.listeJouable = new ArrayList<Jouable>();
        
    }


    public ArrayList<Bonus> getListeBonus() {
        return listeBonus;
    }

    public ArrayList<Jouable> getListeJouable() {
        return listeJouable;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMur(){
        if(this.mur == null){
            return false;
        }
        return true;
    }

    public Mur getMur() {
        return mur;
    }

    public void setMur(Mur mur){
        this.mur = mur;
    }
    
    public void setListeBonus(ArrayList<Bonus> listeBonus) {
        this.listeBonus = listeBonus;
    }

    public void setListeJouable(ArrayList<Jouable> listeJouable) {
        this.listeJouable = listeJouable;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void addJouable(Jouable e){
        this.listeJouable.add(e);
    }
    
    public void addBonus(Bonus b){
        this.listeBonus.add(b);
    }
    
}
