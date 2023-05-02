/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ig;


        import javax.swing.JFrame;
/**
 *
 * @author tmichel1
 */
public class TestEcouteurs1 {

    
    
    
    public static void main(String[] args) {
        //Ok, testons un peu nos Listeners ! Là on créer juste une bête fenêtre !
        JFrame fenetre = new JFrame("CarreRectangle");
        fenetre.setVisible(true);
        fenetre.setSize(1000, 1000); //Vous pouvez régler les dimensions de la fenêtre ici.
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        //Ca c'est ce qui nous intéresse ! Là, on dit à la fenêtre "fenetre", "ok, maintenant écoute BIEN le clavier et la souris ! Et si tu détectes un "event", tu exécutes les méthodes dans les deux autres classes !"
        fenetre.addKeyListener(new EcouteurClavier());
//        fenetre.addMouseListener(new EcouteurSouris());// TODO code application logic here

       
    }
    
}



