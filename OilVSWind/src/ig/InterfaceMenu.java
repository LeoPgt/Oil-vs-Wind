/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ig;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author rmorel
 */
public class InterfaceMenu extends JFrame {

    public InterfaceMenu(){
        InitComponent();
        this.setResizable(false);
    }
    
    private void InitComponent(){
        test= new MyButton("JOUER","bouton","bouton_clic");
        test.addActionListener(new java.awt.event.ActionListener(){
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent){
                testActionPerformed(evt);
            
            }
    });
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        this.fond = ImageIO.read(new File("baril_bleu.png"));
    }
    
}
