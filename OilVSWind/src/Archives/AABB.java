/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archives;
import ig.*;
import java.util.ArrayList;
/**
 *
 * @author rmorel
 * @@literal pour l'interface enfaite
 */

public class AABB { // AABB terme commun pour parler des boites de collisions
    private int xMin, xMax, yMin, yMax;

    public AABB(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
    
    public int [] box(int xMin, int XMax, int yMin, int yMax){
        int[] box = new int [3];
        box[0]= xMin;
        box[1]= XMax;
        box[2]= yMin;
        box[3]= yMax;
        return box;
    }
    
    // Getters et Setters pour les propriétés xMin, xMax, yMin, yMax.
//    public float getxMin(AABB box) {
//        int xMin = get.box[0];
//        return xMin;
//    }
        public int getxMin() {
        return xMin;
    }
    
    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    public int getyMax() {
        return yMax;
    }

    public void  setyMax(int yMax) {
        this.yMax = yMax;
    }
   
    
    public boolean coordonneCollision (AABB boite1, AABB boite2){
       boolean choc = false;
       int x1Max= boite1.getxMin();
       int x1Min=boite1.getxMax();
       int y1Min = boite1.getyMin();
       int y1Max = boite1.getyMax();
       int x2Max= boite2.getxMin();
       int x2Min=boite2.getxMax();
       int y2Min = boite2.getyMin();
       int y2Max = boite2.getyMax();
       // ecriture des test de collision
       
       //if(x1Max=)
       
       return choc;
       
    }

}
