/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rmorel
 */
public class igMethodeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("OIL VS WIND");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new igMethode.MapPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        });
    }
    
}