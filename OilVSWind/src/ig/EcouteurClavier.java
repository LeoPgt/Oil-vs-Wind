/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author tmichel1
 */
public class EcouteurClavier implements KeyListener {

   
    @Override
    public void keyPressed(KeyEvent event) {
        System.out.print("une touche a été appuyée - ");
        System.out.println("le code de la touche est " + event.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent event) {
        System.out.print("un caractère a été frappé - ");
        System.out.println("'" + event.getKeyChar() + "'");
    }

    @Override
    public void keyReleased(KeyEvent event) {
        System.out.println("touche relachée : " + event.getKeyCode());
    }
    }
    

