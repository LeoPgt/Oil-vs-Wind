/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import moteur.*;

/**
 *
 * @author manal.benaissa
 */
public class BDDJoueur {

    private String CONNECTION_URL;
    private String USERNAME;
    private String PASSWORD;

    private ArrayList<Jouable> listeJoueurs;

    public BDDJoueur() {
        this.CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
        this.USERNAME = "etudiant";
        this.PASSWORD = "YTDTvj9TR3CDYCmP";

        this.listeJoueurs = new ArrayList<Jouable>();
    }

    public ArrayList<Jouable> getListeJoueurs() {
        return listeJoueurs;
    }
    

    public void SelectJoueur() {

        try {
            Connection connexion = DriverManager.getConnection(this.CONNECTION_URL, this.USERNAME, this.PASSWORD);
            PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Joueur");

            ResultSet result = requete.executeQuery();
            while (result.next()) {
                // ID, pseudo, x, y, type, vitesse, capturable
                int ID = result.getInt("id");
                String pseudo = result.getString("pseudo");
                int x = result.getInt("x");
                int y = result.getInt("y");
                String type = result.getString("type");
                int vitesse = result.getInt("vitesse");
                boolean capturable = result.getBoolean("capturable");

                if (type.equals("runner")) {
                    Runner R = new Runner(ID, pseudo, x, y, vitesse);
                    this.listeJoueurs.add(R);
                }
                else if(type.equals("baril")){
                    Baril B = new Baril(ID, pseudo, 0, x, y, capturable); //TODO : revoir le numéro dans Baril!
                    this.listeJoueurs.add(B);
                }

            }
            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void InsertJoueur(Jouable J){

        if(J instanceof Runner){
            //insérer runner
        }
        else{
            //insérer baril
        }
    
    }
    
    public void UpdateJoueur(int ID, int x, int y){}
    
    public void DeleteJoueur(){}

}
