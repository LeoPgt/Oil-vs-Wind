/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author alaunay
 */
public class Aessaia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("OIL VS WIND");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {
                frame.getContentPane().add(new Aessai());
            } catch (IOException ex) {
                Logger.getLogger(Aessaia.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.getContentPane().add(new Aessai());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
}
