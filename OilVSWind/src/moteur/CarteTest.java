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
       Carte Monde = new Carte();
       Monde.getMatrice();
    //   Monde.afficherMatrice();
    //Monde.Spawn(4, 4, 3);
    Monde.afficherMatriceV2(Monde);

    System.out.print("------------");
    System.out.println();

    }
    
}
