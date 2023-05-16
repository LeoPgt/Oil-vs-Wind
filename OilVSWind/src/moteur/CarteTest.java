/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moteur;

/**
 *
 * @author rmorel
 */
public class CarteTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Carte Monde = new Carte(5,3,2);
       Monde.getMatrice();
    //   Monde.afficherMatrice();
    Monde.afficherMatriceV2(Monde);
    Monde.spwan(Monde, 3);
    System.out.print("------------");
    System.out.println();

    }
    
}
