/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

/**
 *
 * @author mleconte
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moteur.*;

// CA MARCHE
public class AvatarsTest extends JPanel implements KeyListener {

    private Jeu jeu;
    private Avatars avatars;

    public AvatarsTest() {
        jeu = new Jeu();
        avatars = new Avatars(jeu);

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("Jeu de test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        avatars.rendu(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            avatars.setGauche(true);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            avatars.setDroite(true);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            avatars.setHaut(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            avatars.setBas(true);
        }
        avatars.miseAJour();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            avatars.setGauche(false);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            avatars.setDroite(false);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            avatars.setHaut(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            avatars.setBas(false);
        }
        avatars.miseAJour();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new AvatarsTest();
    }
}
