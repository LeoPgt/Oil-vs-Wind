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


    private ArrayList<Jouable> listeJoueurs;

    public BDDJoueur() {
        this.listeJoueurs = new ArrayList<Jouable>();
    }

    public ArrayList<Jouable> getListeJoueurs() {
        return listeJoueurs;
    }
    

    public ArrayList<Jouable> SelectJoueur() {
        try {
            Connection connexion = SingletonJDBC.getInstance().getConnection();
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
        Connection connexion = null;
        PreparedStatement requete = null;
        try {
            connexion = SingletonJDBC.getInstance().getConnection();
            if(J instanceof Runner){
                Runner runner = (Runner) J;

                    requete = connexion.prepareStatement("INSERT INTO Joueur VALUES ( ?, ?, ?, ?, ?, ?)");

                    requete.setString(1, runner.getPseudo());
                    requete.setInt(2, runner.getX());
                    requete.setInt(3, runner.getY());
                    requete.setString(4, "runner");
                    requete.setInt(5, runner.getVitesse());
                    requete.setBoolean(6, false); // Les Runners ne sont pas capturables

                    requete.executeUpdate();

            } else {
                Baril baril = (Baril) J;
                    requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?, ?, ?, ?, ?)");

                    requete.setString(1, baril.getPseudo()); 
                    requete.setInt(2, baril.getX());
                    requete.setInt(3, baril.getY());
                    requete.setString(4, "baril");
                    requete.setInt(5, 10); // Les Barils n'ont pas de vitesse attribué
                    requete.setBoolean(6, baril.capturableGet());

                    requete.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Fermeture des ressources
            try {
                if (requete != null) {
                    requete.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void UpdateJoueur(int ID, int x, int y, int vitesse, boolean capturable){
        Connection connexion = null;
        PreparedStatement requete = null;
            try {
                connexion = SingletonJDBC.getInstance().getConnection();
                requete = connexion.prepareStatement("UPDATE Joueur SET X = ?, Y = ?, VITESSE = ?, CAPTURABLE = ? WHERE ID = ?");
                requete.setInt(1, x);
                requete.setInt(2, y);
                requete.setInt(3, vitesse);
                requete.setBoolean(4, capturable);
                requete.setInt(5, ID);

                requete.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            // Fermeture des ressources
            try {
                if (requete != null) {
                    requete.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void DeleteJoueur(int ID){
        try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
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
