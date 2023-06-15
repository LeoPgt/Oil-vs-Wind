/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import sql.Update_OVSW; // lien SQL

/**
 *
 * @author mleconte
 */
public class Regles {
    private Update_OVSW update_OVSW; // lien SQL
    protected boolean gauche, droite, haut, bas;
    private Carte CarteMoteur;
    private Timer timer = new Timer(); // Déclaration du timer
//    private Runner runner;
//    private ArrayList<Baril> barrilJoueur;

    public Regles (int taillecase, Carte Maptitle) {
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        this.CarteMoteur = Maptitle;
        int carteSize = Maptitle.getSize();// map n'exite pas pas donc nécessaire de la créer !!!
        this.update_OVSW = new Update_OVSW (); // lien SQL
    }

    public void setCarteMoteur(Carte Maptitle) {
        this.CarteMoteur = Maptitle;
    }

     // Méthode qui retourne l'élément à la position (x, y)
  public Element laCaseDeCoordonnees(int x, int y) {
        int valeur = CarteMoteur.getMatrice()[x][y];
        
        switch (valeur) {
            case 1:
                return new Runner(000,"r",x,y,0); 
                // id à 000, pseudo = r, vitesse à 0 mais on s'en fiche c'est juste pour le rentrer l'array list Case autour
            case 2:
                return new Mur(x,y);
            case 3:
                return new Baril(001,"B1",3,x,y,true);
            case 4:
                return new Baril(002,"B2",4,x,y,true);
            case 5:
                return new Baril(003,"B3",5,x,y,true);
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
    return alentour;
    }
     /**
     * Ce programme permet de gérer toutes les collisions
     * @version 3
     * @return un boolean de si oui ou non ils sont rentrés en collision
     */  
  public boolean collision(Element A, Element B){ // throws SQLException // LIEN SQL
    ArrayList<Element> casesAutourA = caseAutour(A);

    if (casesAutourA.isEmpty()) {
        return false; // Aucune collision possible car aucune case autour de A
    }
    if (A instanceof Runner && B instanceof Baril && casesAutourA.contains(B)) { // Si A est une instance de Runner et Si B est une instance de Baril et si CaseAutour de A contient B)
        // Collision entre le Runner et un Baril
        Baril baril = (Baril) B;
        if (baril.capturableGet()) {
            baril.capturableSet(false);
// LIEN SQL  update_OVSW.updateBaril(baril); 
            return true; //Collision détecté = Runner attrape baril
        }
    } else if (A instanceof Runner && B instanceof Mur && casesAutourA.contains(B)) { 
        // Collision entre le Runner et un Mur
        return true; // Collision détectée
    } else if (A instanceof Runner && B instanceof Bonus && casesAutourA.contains(B)) {
        // Collision entre le Runner et un Bonus
        Bonus bonus = (Bonus) B;
        Runner runner = (Runner) A;
        if (bonus.capturableGet()) {
            bonus.capturableSet(false);
            runner.setVitesse(); // le bonus s'applique sur le Runner
//  LIEN SQL  update_OVSW.updateRunner(runner);  
            return true; // Collision détectée = Le runner attrape bonus
        }
    } else if (A instanceof Baril && (B instanceof Runner || B instanceof Mur || B instanceof Baril)&& casesAutourA.contains(B)) {
        // Collision entre un Baril et Runner ou Mur ou Baril
        return true; // Collision détectée
    } else if (A instanceof Baril && B instanceof Bonus && casesAutourA.contains(B)) {
        // Collision entre un Baril et un Bonus
        Baril baril = (Baril) A;
        Bonus bonus = (Bonus) B;
        if (bonus.capturableGet()) {
            bonus.capturableSet(false);
// LIEN SQL  update_OVSW.updateRunner(baril); 
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
//LIEN SQL      if (J instanceof Runner) {
//                  update_OVSW.updateRunner((Runner) J);
//              } else if (J instanceof Baril) {
//                  update_OVSW.updateBaril((Baril) J);
//              }
            } else {
                System.out.println("Déplacement impossible : collision détectée");
            }
        } else {
            System.out.println("Déplacement impossible dans la direction spécifiée");
        }

        Bouclage.afficherMatriceV2(MapMod);
        return MapMod;
    }
    
//     Méthode pour placer les barils aléatoirement dans la carte
    private ArrayList<Element> placerBarilsAleatoirement() {
        ArrayList<Element> listeBarils = new ArrayList<>();
        int nbBarils = 3; // Nombre de barils à placer
        Random random = new Random();
        
        while (nbBarils > 0) {
            int x = random.nextInt(CarteMoteur.getSize());
            int y = random.nextInt(CarteMoteur.getSize());
            
            if (CarteMoteur.getMatrice()[x][y] == 0) {
                CarteMoteur.setMatrice(x, y, nbBarils + 2); // Valeur de baril (3, 4, 5) correspondant au nombre restant à placer
                Baril baril =  new Baril(nbBarils,"B"+nbBarils, nbBarils+2, x, y, true); // Création du baril pour l'utiliser dans partieMoteur
                listeBarils.add(baril);
                nbBarils--;
            }
        }
        return listeBarils;
    }
    
//         Méthode pour mettre fin à la partie
    private void finPartie(Runner runner, boolean victoire) {
        if (victoire) {
            System.out.println("Victoire ! Tous les barils ont été capturés.");
        } else {
            System.out.println("Défaite ! Les barils n'ont pas été tous capturés en 3 minutes.");
        }
       
        // Arrêter le timer
        timer.cancel();
        timer.purge();
    }
    
//     Méthode pour vérifier si tous les barils ont été capturés
    private boolean tousBarilsCaptures() {
        int[][] matrice = CarteMoteur.getMatrice();
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j] == 3 || matrice[i][j] == 4 || matrice[i][j] == 5) {
                    return false; // Il reste au moins un baril non capturé
                }
            }
        }
        return true; // Tous les barils ont été capturés
    }
            
//    Méthode pour jouer une partie sans interface graphique
    public void partieMoteurV2() {
        // Création du runner
        Runner runner = new Runner(1, "Runner", 0, 0, 1); // Exemple de valeurs pour le Runner
        
//         Placement aléatoire des barils
        ArrayList<Element> listeBarils = placerBarilsAleatoirement();
        
//         Lancement du timer de 3 minutes
        timer.schedule(new TimerTask() {
            public void run() {
                finPartie(runner, false);
            }
        }, 3 * 60 * 1000); // 3 minutes
        
        // Boucle de jeu
        while (true) {
//             Vérification si tous les barils ont été capturés
            if (tousBarilsCaptures()) {
                finPartie(runner, true);
                break;
            }
            
//             Déplacement du Runner
            MiseAJour(runner, CarteMoteur);
            
//             Déplacement des Barils
            for (int i = 0; i < 3; i++) {
                MiseAJour((Jouable) listeBarils.get(i), CarteMoteur);
            }
            
//             Pause de 1 seconde entre les mouvements du Runner
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//    public void partieMoteurV1(){
//        Carte Map = new Carte(5,5); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//        int nbBarils = 3;
//        Jouable Joueur = new Jouable("Joueur1",1,2,2);// A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//        Baril Baril = new Baril(1,"joueur2",2,4,4,false);
//        Map.setMatrice(Baril.getX(), Baril.getY(), 3);
////      Map.afficherMatriceV2(Map);
 
//    public void partieMoteur(){
//        Carte Map = new Carte(5,5); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//        Jouable Joueur = new Jouable(1,2,2);// A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//        Baril Baril = new Baril(2,4,4);
//        Map.setMatrice(Baril.getX(), Baril.getY(), 3);
////        Map.afficherMatriceV2(Map);
//        int bouclage = 10;
//        int essai = 0;
//        while (essai != bouclage){
//            System.out.print("selectionner une direction");
//            int unEntier = Clavier.getInt();
//         // Carte MapMod = this.MiseAJour(unEntier, Map); // A regarder car il y a PEUT ETRE de nouveaux paramètres dans la fonction
//         // Map = MapMod;
//         //  this.deplacementCapture(this.collisionLoupMouton());
//         //Map.setMatrice(this.barrilJoueur.getX(),this.barrilJoueur.getY(),3);
//        while (nbBarils > 0) {
//            int x = random.nextInt(CarteMoteur.getSize());
//            int y = random.nextInt(CarteMoteur.getSize());
//            
//            if (CarteMoteur.getMatrice()[x][y] == 0) {
//                CarteMoteur.setMatrice(x, y, nbBarils + 2); // Valeur de baril (3, 4, 5) correspondant au nombre restant à placer
//                Baril baril =  new Baril(001,"B"+ nbBarils,nbBarils +2,x,y,true); // Création du baril pour l'utiliser dans partieMoteur
//                nbBarils--;
//            }
//        }
//    }

    // l'utilité de ça ?
//        static public long getLong() { 
//        long retourLong = 0;
//        boolean saisieOk = false;
//        while (saisieOk == false) {
//            try {
//                BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
//                String s = inr.readLine();
//                retourLong = Long.parseLong(s);
//                saisieOk = true;
//            } catch (Exception e) {
//                System.out.println(" Erreur de saisie : veuiller entrer un entier ");
//            }
//        }
//        return retourLong;
//    }