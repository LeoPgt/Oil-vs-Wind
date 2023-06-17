/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moteur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author mleconte
 */
 
 //1 = Runner, 3= BarilB1 , 4 = BarilB2 , 5 = BarilB3

public class Jouable extends Element {
    private String nom; // soit runner en minuscule soit baril en minuscule
    private String pseudo;
    
    public Jouable (String pseudo, String nom, int x, int y) {
        super (x, y);


        this.ID = ID;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

      
    
    
    public void set_joueur_x(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

            PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET Coordonée_X = ? WHERE Id = ?");
            requete.setInt(1,this.ID );
            requete.setInt(2, this.x );
            System.out.println(requete);
            int nombreDeModifications = requete.executeUpdate();
            System.out.println(nombreDeModifications + " enregistrement(s) modifie(s)");

            requete.close();  
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    
    
    
    public void setY(int y) {
        this.y = y;


        this.numero = numero;

        this.nom = nom;

        this.pseudo = pseudo;

    }
    
    
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    @Override
    public String toString() {
        return "Jouable{" + "Le jouable a comme id" + this.nom + '}';
    }
    
}
