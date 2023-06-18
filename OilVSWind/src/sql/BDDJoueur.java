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
 * @author mandy.leconte
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
    

    public ArrayList<Jouable> SelectJoueur() {
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
                    Baril B = new Baril(ID, pseudo, x, y, capturable);
                    this.listeJoueurs.add(B);
                }

            }
            requete.close();
            connexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.listeJoueurs;
    }
    
    public void InsertJoueur(Jouable J, String pseudo) {
        try {
            Connection connexion = DriverManager.getConnection(this.CONNECTION_URL, this.USERNAME, this.PASSWORD);
            
            if(J instanceof Runner){
                Runner runner = (Runner) J;

                    PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES ( ?, ?, ?, ?, ?, ?)");

                    requete.setString(1, runner.getPseudo());
                    requete.setInt(2, runner.getX());
                    requete.setInt(3, runner.getY());
                    requete.setString(4, "runner");
                    requete.setInt(5, runner.getVitesse());
                    requete.setBoolean(6, false); // Les Runners ne sont pas capturables

                    requete.executeUpdate();
                    
                    requete.close();
                    connexion.close();

            } else {
                Baril baril = (Baril) J;
                    PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?, ?, ?, ?, ?)");

                    requete.setString(1, baril.getPseudo()); 
                    requete.setInt(2, baril.getX());
                    requete.setInt(3, baril.getY());
                    requete.setString(4, "baril");
                    requete.setInt(5, 10); // Les Barils n'ont pas de vitesse attribué
                    requete.setBoolean(6, baril.capturableGet());

                    requete.executeUpdate();
                    
                    requete.close();
                    connexion.close();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void UpdateJoueur(int ID, int x, int y, int vitesse, boolean capturable){
            try {
                Connection connexion = DriverManager.getConnection(this.CONNECTION_URL, this.USERNAME, this.PASSWORD);
                PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET X = ?, Y = ?, VITESSE = ?, CAPTURABLE = ? WHERE ID = ?");
                requete.setInt(1, x);
                requete.setInt(2, y);
                requete.setInt(3, vitesse);
                requete.setBoolean(4, capturable);
                requete.setInt(5, ID);

                requete.executeUpdate();
                
                requete.close();
                connexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    
    public void DeleteJoueur(int ID){
        try {
            Connection connexion = DriverManager.getConnection(this.CONNECTION_URL, this.USERNAME, this.PASSWORD);
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE ID = ?");
            
            requete.setInt(1,ID);

            requete.executeUpdate();
            
            requete.close();
            connexion.close();
            
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
}
