/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import utilitaire.*;
import java.util.ArrayList;
import sql.BDDJoueur; // lien SQL
/**
 *
 * @author mleconte
 */
public class Jeu {
    
    private BDDJoueur BJ;// lien SQL
    protected boolean gauche, droite, haut, bas;
    public Carte CarteMoteur;
    public Runner runner;
    private ArrayList<Baril> barrilJoueur;
    private ArrayList<Jouable> listeJ; // Déclaration de listeJ

    public Jeu () {
        
        //Initialiser Carte
        Fichier F = new Fichier("src/resource/carte.txt");
        F.lireFichier();
        this.CarteMoteur = F.getCarte();
        this.gauche = false;
        this.droite = false;
        this.haut = false;
        this.bas = false;
        
        // Initialisation de barrilJoueur
        this.barrilJoueur = new ArrayList<>();
       
        //Ajouter Des Jouables
        this.BJ = new BDDJoueur();
        this.BJ.SelectJoueur();
        this.listeJ = this.BJ.getListeJoueurs();
 
        for(int i = 0; i < listeJ.size(); i++ ){
            if (i >= 0 && i < this.CarteMoteur.getSpots().size()) {
                int x_spot = this.CarteMoteur.getSpots().get(i).getX();
                int y_spot = this.CarteMoteur.getSpots().get(i).getY();

                if(listeJ.get(i) instanceof Runner){
                    this.runner = (Runner)listeJ.get(i);

                    this.runner.setX(x_spot);
                    this.runner.setY(y_spot);

                    //TODO : Faire le Update SQL pour changer coordonnee !
                    BJ.UpdateJoueur(runner.getIdSQL(), x_spot, y_spot, runner.getVitesse(), false); 

                }
                else if(listeJ.get(i) instanceof Baril){
                    
                    Baril B = (Baril)listeJ.get(i);
                    B.setX(x_spot);
                    B.setY(y_spot);
                    this.barrilJoueur.add(B);

                    //TODO : Faire le Update SQL pour changer coordonnee !
                    BJ.UpdateJoueur(B.getIdSQL(), x_spot, y_spot, 10, B.capturableGet());
                }
            }    
        }
    }
    
    public ArrayList<Jouable> getListeJoueurs() {
        return BJ.getListeJoueurs();
    }
    public void InsertJoueur(Jouable J, String pseudo) {
        BJ.InsertJoueur(J, pseudo);
        listeJ.add(J);
    }
    public void setCarteMoteur(Carte CarteMoteur) {
        this.CarteMoteur = CarteMoteur;
    }

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

    public Carte getCarteMoteur() {
        return CarteMoteur;
    }

    public boolean isGauche() {
        return gauche;
    }

    public boolean isDroite() {
        return droite;
    }

    public boolean isHaut() {
        return haut;
    }

    public boolean isBas() {
        return bas;
    }

    public ArrayList<Baril> getBarrilJoueur() {
        return barrilJoueur;
    }
     
    public boolean isCasesVide(int x, int y){
        Cases c = CarteMoteur.getMatrice()[x][y];
        if(c.isMur()){
            return false;
        }
        else if(c.getListeJouable().isEmpty()){
            return true;
        }
        
        return false;
    }
 

 // Méthode qui retourne l'élément à la position (x, y)
    public Element laCaseDeCoordonnees(int x, int y) {
        Cases c = CarteMoteur.getMatrice()[x][y];
        
        if (this.isCasesVide(x, y)){
            return null;
        }
        if (c.isMur()){
            return c.getMur();
        }
        if(!c.getListeJouable().isEmpty()){
            return c.getListeJouable().get(0);
        }
        if(!c.getListeBonus().isEmpty()){
            return c.getListeBonus().get(0);
        }
        return null;
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
            BJ.UpdateJoueur(baril.getIdSQL(), baril.getX(), baril.getY(), 10, baril.capturableGet()); // lien SQL
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
            BJ.UpdateJoueur(runner.getIdSQL(), runner.getX(), runner.getY(), runner.getVitesse(), false); // lien SQL
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
            BJ.UpdateJoueur(baril.getIdSQL(), baril.getX(), baril.getY(), 10, baril.capturableGet()); 
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

    if (x >= 0 && x < CarteMoteur.getLargeur() && y >= 0 && y < CarteMoteur.getHauteur()) {
        if (this.gauche) {
            if (x - 1 >= 0 && CarteMoteur.getMatrice()[x - 1][y].isMur() == false) {
                return true;
            }
        } else if (this.droite) {
            if (x + 1 < CarteMoteur.getLargeur() && CarteMoteur.getMatrice()[x + 1][y].isMur() == false) {
                return true;
            }
        } else if (this.haut) {
            if (y - 1 >= 0 && CarteMoteur.getMatrice()[x][y - 1].isMur() == false) {
                return true;
            }
        } else if (this.bas) {
            if (y + 1 < CarteMoteur.getHauteur() && CarteMoteur.getMatrice()[x][y + 1].isMur() == false) {
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
    Carte MapMod = new Carte(Bouclage.getLargeur(), Bouclage.getHauteur());

    for (int i = 0; i < Bouclage.getLargeur(); i++) {
        for (int j = 0; j < Bouclage.getHauteur(); j++) {
            MapMod.setMatrice(i, j, new Cases(i, j));
            Cases bouclageCase = Bouclage.getMatrice()[i][j];
            MapMod.getMatrice()[i][j].setMur(bouclageCase.getMur());
            MapMod.getMatrice()[i][j].setListeBonus(new ArrayList<>(bouclageCase.getListeBonus()));
            MapMod.getMatrice()[i][j].setListeJouable(new ArrayList<>(bouclageCase.getListeJouable()));
        }
    }

    int x = J.getX();
    int y = J.getY();

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

        if (caseDestination == null || !collision(J, caseDestination)) {
            MapMod.getMatrice()[x][y].getListeJouable().remove(J);
            MapMod.getMatrice()[newX][newY].addJouable(J);
            J.setX(newX);
            J.setY(newY);


            if (J instanceof Runner) {
                Runner runner = (Runner) J;
                BJ.UpdateJoueur(runner.getIdSQL(), newX, newY, runner.getVitesse(), false); // Met à jour les coordonnées du Runner dans la base de données
            } else if (J instanceof Baril) {
                Baril baril = (Baril) J;
                BJ.UpdateJoueur(baril.getIdSQL(), newX, newY, 10, baril.capturableGet());// Met à jour les coordonnées du Barril dans la base de données
            }
        } else {
            System.out.println("Déplacement impossible : collision détectée");
        }
    } else {
        System.out.println("Déplacement impossible dans la direction spécifiée");
    }

    System.out.println(MapMod.toString());
    return MapMod;
}
   
//     Méthode pour vérifier si tous les barils ont été capturés
    private boolean tousBarilsCaptures() {
        Cases[][] matrice = CarteMoteur.getMatrice();

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                ArrayList<Jouable> jouables = matrice[i][j].getListeJouable();
                for (Jouable jouable : jouables) {
                    if (jouable instanceof Baril) {
                        return false; // Il reste au moins un baril non capturé
                    }
                }
            }
        }
        return true; // Tous les barils ont été capturés
    }
    
    public boolean partieMoteurV2() {
        boolean jeuTermine = false;
        // Boucle de jeu
        while (jeuTermine == false) {
            // Vérification si tous les barils ont été capturés
            if (tousBarilsCaptures()) {
                jeuTermine = true;
            }

            // Déplacement du Runner
            CarteMoteur = MiseAJour(runner, CarteMoteur);

            // Déplacement des Barils
            for (Baril baril : barrilJoueur) {
                CarteMoteur = MiseAJour(baril, CarteMoteur);
            }
        }
        return jeuTermine;
    }
}