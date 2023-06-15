/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import clavier.Clavier;
import javax.swing.JFrame;

/**
 *
 * @author rmorel
 */
public class InterfaceClavier {
    private boolean haut = false;
    private boolean bas = false;
    private boolean droite = false;
    private boolean gauche = false;

    public InterfaceClavier(){
    JFrame frame = new JFrame("Capture d'événements clavier");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("keyCode=" + keyCode);
    }
    });
    }
    
        public void keyPressed(KeyEvent e) {
             int keyCode = e.getKeyCode();
             processKeyInput(keyCode);
}
        public void processKeyInput(int keyCode) {
        // Code pour traiter l'entrée de la touche
    }


        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            processKeyInput(keyCode);
    }
    

        public void keyTyped(KeyEvent e) {
    // Pas nécessaire pour cette utilisation, mais doit être implémentée en raison de l'interface
        }
      private void movePlayer(int keyCode) {
     // L'index du joueur à déplacer (ici, le personnage principal)
    
    switch (keyCode) {
        case KeyEvent.VK_LEFT:
            this.gauche = true;
            System.out.println(this.gauche);
            break;
        case KeyEvent.VK_RIGHT:
            this.droite = true;
            System.out.println(this.gauche);
            break;
        case KeyEvent.VK_UP:
            this.haut = true;
            System.out.println(this.gauche);
            break;
        case KeyEvent.VK_DOWN:
            this.bas = true;
            System.out.println(this.gauche);
            break;
        default:
            return; // Ignorer les autres touches
    }
      }

    public boolean isHaut() {
        return haut;
    }

    public boolean isBas() {
        return bas;
    }

    public boolean isDroite() {
        return droite;
    }

    public boolean isGauche() {
        return gauche;
    }
  
        public ArrayList recuperationClavier(){
        ArrayList<Boolean> listeClavier = new ArrayList<>();
            listeClavier.set(0,this.isGauche());
            listeClavier.set(1,this.isDroite());
            listeClavier.set(2,this.isBas());
            listeClavier.set(3,this.isHaut());
        return listeClavier;
    }

    @Override
    public String toString() {
        return "InterfaceClavier{" + "haut=" + haut + ", bas=" + bas + ", droite=" + droite + ", gauche=" + gauche + '}';
    }
    
        static public boolean getBoolean() {
        boolean retourBoolean = false;
        boolean saisieOk = false;
        while (saisieOk == false) {
            try {
                BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
                String s = inr.readLine();
                if (s.equals("true") || s.equals("vrai") || s.equals("1")) {
                    retourBoolean = true;
                    saisieOk = true;
                } else if (s.equals("false") || s.equals("faux") || s.equals("0")) {
                    retourBoolean = false;
                    saisieOk = true;
                } else {
                    System.out.println(" Erreur de saisie : veuiller entrer un booleen (vrai/true ou faux/false ou 0/1) ");
                }
            } catch (Exception e) {
                System.out.println(" Erreur de saisie : veuiller entrer un booleen (vrai/true ou faux/false ou 0/1) ");
            }

        }
        return retourBoolean;
    }
}

