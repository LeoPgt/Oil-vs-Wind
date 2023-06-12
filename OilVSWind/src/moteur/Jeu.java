/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import clavier.Clavier;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author mleconte
 */
public class Jeu {// Renommé toute la classe miseAJour / regle jeu
    protected boolean gauche, droite, haut, bas;  
    private Carte C;
    private Runner runner;
    private ArrayList<Baril> barrilJoueur;
    private int tailleCase; //Manal : N'est pas sensé etre ici (mais on le laisse pour l'instant)
    
    public Jeu (int taillecase) {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.C = new Carte(5,5);
        int carteSize = C.getSize();
        this.runner = new Runner(1,0,0,1);
        //BARIL
        this.barrilJoueur = new ArrayList<Baril>();
        Baril B1 = new Baril(3, 1, 1);
        this.barrilJoueur.add(B1);
        Baril B2 = new Baril(4, 2, 2);
        this.barrilJoueur.add(B2);
        Baril B3 = new Baril(5, 3, 3);
        this.barrilJoueur.add(B3);
        //this.barrilJoueur.indexOf(B1); //Retourne indice de B1 donc 0
        //this.barrilJoueur.get(0); //retourne l'objet d'indice 0 donc B1
        
        this.tailleCase = taillecase;
    }

    // setteur pour modifier le true false de la direction
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }
    
    
    
    
        static public long getLong() {
        long retourLong = 0;
        boolean saisieOk = false;
        while (saisieOk == false) {
            try {
                BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
                String s = inr.readLine();
                retourLong = Long.parseLong(s);
                saisieOk = true;
            } catch (Exception e) {
                System.out.println(" Erreur de saisie : veuiller entrer un entier ");
            }
        }
        return retourLong;
    }
    
     /**
     * Ce programme permet de savoir si le barril et le runner sont entrées en collision
     * @version 2
     * @return un boolean de si oui ou non ils sont rentrés en collision
     */  
        // Méthode donnée par Manal
//        if (A.getClass().equals(Element.getClass()) && B.getClass().equals(Element.getClass())){
//            A.getCoord() en collision avec B.getCoord();
//        }
        // QUESTION : Si on fait le programme ci dessous, est il vraiment nécessaire de prendre en paramètres deux objets A et B et faire une comparaison equals etc ?
        
    public boolean collisionLoupMouton(){
        boolean collision = false;
        for (int i = 0; i<3; i++){
            if(this.barrilJoueur.get(i).getX()== this.runner.getX()){
                collision = true;
            }
        }
        for (int j = 0; j<3; j++){
            if(this.barrilJoueur.get(j).getY()== this.runner.getY()){
                collision = true;
            }
        }
        return collision;
    }

    /**
     * A voir a quoi sert ce programme (pour l'instant non traité)
     * @version 1
     * @return 
     */  
//    public int[] deplacementCapture(){
//        int [] coordoCapture = new int[2];
//        if(this.collisionLoupMouton()==true){
//           barrilJoueur.setX(J.getX()+1);
//           barrilJoueur.setY(J.getY()+1);
//        }
//        return coordoCapture;
//    }
//    
    
    
     /**
     * Verification si le déplacement est possible pour un jouable
     * @version 1
     * @return des true ou false suivant si c'est possible ou pas 
     */  
    public boolean deplacementEstPossible(Jouable J,boolean direction){
        if (J.getX() <= C.getSize() && J.getX() >= 0){
            if(this.gauche == true){ // ceci changera avec un deplacement == 0
                if (C.getMatrice()[J.getX()-1][J.getY()] == 2 ){
                    return false;
                }
                else{
                    return true;
                }
            }
            if(this.droite == true){ // ceci changera avec un deplacement == 1
                if (C.getMatrice()[J.getX()+1][J.getY()] == 2 ){
                    return false;
                }
                else{
                    return true;
                }
            }
            if(this.haut == true){ // ceci changera avec un deplacement == 2
                if (C.getMatrice()[J.getX()][J.getY()-1] == 2 ){
                    return false;
                }
                else{
                    return true;
                }
            }
             if(this.bas == true){ // ceci changera avec un deplacement == 3
                if (C.getMatrice()[J.getX()][J.getY()+1] == 2 ){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

     /**
     * Déplace le jouable sur la carte suivant les infos qu'il obtient du programme le déplacement est possible
     * @version 3
     * @return la matrice modifié avec le déplacement du jouable
     */  
        
    public Carte MiseAJour(Jouable J, Carte Bouclage) {
       // Matrice d'initialisation
        Carte MapMod = Bouclage;
        int x = J.getX(); // localisation du jouable sur la map en x
        int y = J.getY(); // Localisation du jouable sur la map en y
        if (deplacementEstPossible(J,gauche)) { //j'utilise le programme d'avant pour savoir si le déplacement est possible
            MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
            y--; // Met à jour la position du 1
            MapMod.setMatrice(x, y, 1); // Met à jour la nouvelle position du 1 dans la matrice
            J.setY(y);
        }
        else{
            System.out.print("déplacement impossible vers la gauche");
        }
        if (deplacementEstPossible(J,droite)) {
            MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1 Modification du setteur car setter modifie la matrice mais pas ses éléments !!!
            y++;
            MapMod.setMatrice(x, y, 1);
            J.setY(y);
        }
        else{
            System.out.print("déplacement impossible vers la droite");
        }
        if (deplacementEstPossible(J,haut)){
            MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
            x--; // Met à jour la position du 1
            MapMod.setMatrice(x, y, 1);
            J.setX(x);
        }
        else{
            System.out.print("déplacement impossible vers le haut");
        } 
        if (deplacementEstPossible(J,bas)){
            MapMod.setMatrice(x, y, 0); // Efface la position actuelle du 1
            x++; // Met à jour la position du 1
            MapMod.setMatrice(x, y, 1); 
            J.setX(x);
        }
        else{
            System.out.print("déplacement impossible vers le bas");
        }
        Bouclage.afficherMatriceV2(MapMod);
        return MapMod;
    }

        /**
         * Permet de transformer les infos du moteur avec x et y en termes de pixels pour l'interface graphique
         * @version 1
         * @return les infos en pixels
         * */
        public int convertirEnPixelssurX(int x) {
            return x * this.tailleCase;
         }
        public int convertirEnPixelssurY(int y) {
            return y * this.tailleCase;
        }


        /**
         * A voir
         * @version
         * @return
         */
    public void partie(){
        Carte Map = new Carte(5,5); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
        Jouable Joueur = new Jouable(01,2,2);// A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
        Baril Baril = new Baril(2,4,4);
        Map.setMatrice(Baril.getX(), Baril.getY(), 3);
        Map.afficherMatriceV2(Map);
        int bouclage = 10;
        int essai = 0;
        while (essai != bouclage){
            System.out.print("selectionner une direction");
            int unEntier = Clavier.getInt();
        // Carte MapMod = this.MiseAJour(unEntier, Map); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
         // Map = MapMod;
         //  this.deplacementCapture(this.collisionLoupMouton());
         //Map.setMatrice(this.barrilJoueur.getX(),this.barrilJoueur.getY(),3);      
        }
    }

}

