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
public class Regles {// Renommé toute la classe miseAJour
    protected boolean gauche, droite, haut, bas;  
    private Carte CarteMoteur;
//    private Runner runner;
//    private ArrayList<Baril> barrilJoueur;
    private int tailleCase; //Manal : N'est pas sensé etre ici (mais on le laisse pour l'instant)
    
    public Regles (int taillecase, Carte Maptitle) {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.CarteMoteur = Maptitle;
        int carteSize = Maptitle.getSize();// map n'exite pas pas donc nécessaire de la créer !!!
//        this.runner = new Runner(1,0,0,1);
//        //BARIL
//        this.barrilJoueur = new ArrayList<Baril>();
//        Baril B1 = new Baril(3, 1, 1);
//        this.barrilJoueur.add(B1);
//        Baril B2 = new Baril(4, 2, 2);
//        this.barrilJoueur.add(B2);
//        Baril B3 = new Baril(5, 3, 3);
//        this.barrilJoueur.add(B3);
        //this.barrilJoueur.indexOf(B1); //Retourne indice de B1 donc 0
        //this.barrilJoueur.get(0); //retourne l'objet d'indice 0 donc B1
        
        this.tailleCase = taillecase;
    }

    public void setCarteMoteur(Carte Maptitle) {
        this.CarteMoteur = Maptitle;
    }
    
    
    
        static public long getLong() {// ???
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
    
     // Méthode qui retourne l'élément à la position (x, y)
  public Element laCaseDeCoordonnees(int x, int y) {
        int valeur = CarteMoteur.getMatrice()[x][y];
        
        switch (valeur) {
            case 1:
                return new Runner(x,y,0); 
                //vitesse à 0 mais on s'en fiche c'est juste pour le rentrer l'array list Case autour
            case 2:
                return new Mur(x,y);
            case 3:
                return new Baril(3,x,y);
            case 4:
                return new Baril(4,x,y);
            case 5:
                return new Baril(5,x,y);
            case 6:
                return new Bonus(x,y);
            default:
                return null; // Retourne null si la case est vide ou n'existe pas
        }
  }
  // Ici On crée une array list des Elements qui sont autour de A
  public ArrayList<Element> caseAutour(Element A) {
        ArrayList<Element> alentour = new ArrayList<>();

        int x = A.getX();
        int y = A.getY();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                 if (i == x && j == y) {
                // On ne fait rien car ce sont les coordonnées de l'élément A
                } else {
                    Element caseVoisine = laCaseDeCoordonnees(i, j);
                    if (caseVoisine != null) {
                        alentour.add(caseVoisine); // Ajoute l'élément lui-même
                    }
                }
            }
        }
    return alentour;// un vrai nom ???
    }
     /**
     * Ce programme permet de gérer toutes les collisions
     * @version 3
     * @return un boolean de si oui ou non ils sont rentrés en collision
     */  
  public boolean collision(Element A, Element B) {
    ArrayList<Element> casesAutourA = caseAutour(A);

    if (casesAutourA.isEmpty()) {
        return false; // Aucune collision possible car aucune case autour de A
    }
    if (A instanceof Runner && B instanceof Baril && casesAutourA.contains(B)) { // Si A est une instance de Runner et Si B est une instance de Baril et si CaseAutour de A contient B)
        // Collision entre le Runner et un Baril
        Baril baril = (Baril) B;
        if (baril.capturableGet()) {
            baril.capturableSet(false);
            return true; //Collision détecté = Runner attrape baril
        }
    } else if (A instanceof Runner && B instanceof Mur && casesAutourA.contains(B)) { 
        // Collision entre le Runner et un Mur
        return true; // Collision détectée
    } else if (A instanceof Runner && B instanceof Bonus && casesAutourA.contains(B)) {
        // Collision entre le Runner et un Bonus
        Bonus bonus = (Bonus) B;
        if (bonus.capturableGet()) {
            bonus.capturableSet(false);
            ((Runner) A).setVitesse(); // le bonus s'applique sur le Runner
            return true; // Collision détectée = Le runner attrape bonus
        }
    } else if (A instanceof Baril && (B instanceof Runner || B instanceof Mur || B instanceof Baril)&& casesAutourA.contains(B)) {
        // Collision entre un Baril et Runner ou Mur ou Baril
        return true; // Collision détectée
    } else if (A instanceof Baril && B instanceof Bonus && casesAutourA.contains(B)) {
        // Collision entre un Baril et un Bonus
        Bonus bonus = (Bonus) B;
        if (bonus.capturableGet()) {
            bonus.capturableSet(false);
            return true; // Collision détectée = Le baril a attrapé un bonus
        }
    } else if (!(A instanceof Runner) && !(A instanceof Baril)) {
        // Si A n'est ni un Runner ni un Baril, on échange les rôles de A et B
        return collision(B, A);
    }
    return false; // Aucune collision détectée
}
    /**
     * Verification si le déplacement est possible pour un jouable 
     * ce qui veut dire soit c'est un 0 et ça avance soit c'est autre chose et c'est traité en collision
     * @version 3
     * * @return des true ou false suivant si c'est possible ou pas 
     */ 
   public boolean deplacementEstPossible(Jouable J) {
    int x = J.getX();
    int y = J.getY();

    if (x >= 0 && x < CarteMoteur.getSize() && y >= 0 && y < CarteMoteur.getSize()) {
        if (this.gauche) {
            if (x - 1 >= 0 && CarteMoteur.getMatrice()[x - 1][y] == 0) {
                return true;
            }
        } else if (this.droite) {
            if (x + 1 < CarteMoteur.getSize() && CarteMoteur.getMatrice()[x + 1][y] == 0) {
                return true;
            }
        } else if (this.droite) {
            if (x + 1 < CarteMoteur.getSize() && CarteMoteur.getMatrice()[x + 1][y] == 0) {
                return true;
            }
        } else if (this.bas) {
            if (y + 1 < CarteMoteur.getSize() && CarteMoteur.getMatrice()[x][y + 1] == 0) {
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
        int x = J.getX();
        int y = J.getY();
        
        int valeur = CarteMoteur.getMatrice()[J.getX()][J.getY()];
        
        if (deplacementEstPossible(J)) {
            int newX = x;
            int newY = y;

            if (this.gauche) {
                    newX = x - 1;       
            } else if (this.droite) {
                    newX = x + 1;
            } else if (this.haut) {
                    newY = y - 1;
            } else if (this.bas) {
                    newY = y + 1;
            }

            Element caseDestination = laCaseDeCoordonnees(newX, newY);

            if (caseDestination == null || !collision(J, caseDestination)) {  // Si la case de destination est nulle ou s'il n'y a pas de collision entre J et la case de destination
                MapMod.setMatrice(x, y, 0); // Efface la position actuelle du jouable
                MapMod.setMatrice(newX, newY, 1); // Met à jour la nouvelle position du jouable dans la matrice
                J.setX(newX);
                J.setY(newY);
            } else {
                System.out.println("Déplacement impossible : collision détectée");
            }
        } else {
            System.out.println("Déplacement impossible dans la direction spécifiée");
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
    public void partieMoteur(){
        Carte Map = new Carte(5,5); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
        Jouable Joueur = new Jouable(1,2,2);// A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
        Baril Baril = new Baril(2,4,4);
        Map.setMatrice(Baril.getX(), Baril.getY(), 3);
//        Map.afficherMatriceV2(Map);
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

