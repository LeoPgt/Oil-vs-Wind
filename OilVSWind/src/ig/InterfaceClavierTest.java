/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;
import clavier.Clavier;
/**
 *
 * @author rmorel
 */
public class InterfaceClavierTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InterfaceClavier Clavier = new InterfaceClavier();
        boolean test = true;
        while(test == true){
            for (int k=0;k<1000;k++){
                System.out.println(Clavier.toString());
            }
        System.out.println("Veuillez entrer un booleen : ");
        boolean unBooleen = Clavier.getBoolean();
        System.out.println("Vous avez entre : " + unBooleen);
        }

    }
    
}
