/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

/**
 *
 * @author rmorel
 */

public class AABB { // AABB terme commun pour parler des boites de collisions
    private float xMin, xMax, yMin, yMax, zMin, zMax;

    public AABB(float xMin, float xMax, float yMin, float yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    // Getters et Setters pour les propriétés xMin, xMax, yMin, yMax.

    // liste de get and set pour le travail des dimmensions des collisions
    public float getxMin() {
        return xMin;
    }

    public void setxMin(float xMin) {
        this.xMin = xMin;
    }

    public float getxMax() {
        return xMax;
    }

    public void setxMax(float xMax) {
        this.xMax = xMax;
    }

    public float getyMin() {
        return yMin;
    }

    public void setyMin(float yMin) {
        this.yMin = yMin;
    }

    public float getyMax() {
        return yMax;
    }

    public void setyMax(float yMax) {
        this.yMax = yMax;
    }
    
    public boolean collisionJoueur (AABB boite1, AABB boite2){
       boolean choc = false;
       xMin1,xMin2,xMax1,xMAx2,yMin1,yMin2,yMax1,yMax2
       return choc;
       
    }

}
