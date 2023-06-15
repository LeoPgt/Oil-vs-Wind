/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moteur;
import ig.igMethode;
/**
 *
 * @author rmorel
 */
public class ReglesTest {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        igMethode Maptitle = new igMethode();
        
        Carte Monde = new Carte(Maptitle.getMAP_DATA());
        Monde.afficherMatriceV2(Monde);
       Regles partieMoteur = new Regles(2,Monde);
//        System.out.println();
//        partieMoteur.partieMoteurV2();
 
 
    }
    
}

