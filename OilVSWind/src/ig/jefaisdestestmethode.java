/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author rmorel
 */
public class jefaisdestestmethode {
    addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println("keyCode=" + keyCode);
        }
    });
}
        

