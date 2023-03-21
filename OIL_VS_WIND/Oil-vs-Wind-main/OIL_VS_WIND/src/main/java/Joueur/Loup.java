/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Joueur;

/**
 *
 * @author rmorel
 */
public class Loup extends Joueur {
    
    
    
    // Besoin d'une collision joueurs
    // collision true false (2 collisions différentes)
    
    public void PeutCapturer (int Capture, boolean Collision){
        int Capturer = 0;
        if(Capturer ==0 & Collision == true){
            Capturer = 1;
        }
        else{
            Capturer = 0;
        }
    }
        
    }

