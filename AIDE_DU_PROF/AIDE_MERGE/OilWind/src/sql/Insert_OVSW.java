/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import moteur.Baril;
import moteur.Runner;
import outils.OutilsJDBC;


/**
 *
 * @author bmartine
 */
public class Insert_OVSW {
     public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?, ?, ?, ? )");
            requete.setInt(1, 1001);
            requete.setString(2, "Scrum" );
            requete.setInt(3, 1 );
            requete.setInt(4, 1 );
            requete.setInt(5, 1 );
            System.out.println(requete);
            int nombreDAjouts = requete.executeUpdate();
            System.out.println(nombreDAjouts + " enregistrement(s) ajoute(s)");

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
     }
   
    private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
    private static final String USERNAME = "etudiant";
    private static final String PASSWORD = "YTDTvj9TR3CDYCmP";

    // Ajoute un nouveau Runner à la base de données
    public void addRunner(Runner runner) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?, ?, ?, ?)");
            requete.setInt(1, runner.getIdSQL());
            requete.setString(2, runner.getPseudo());
            requete.setString(3, "Runner");
            requete.setInt(4, runner.getX());
            requete.setInt(5, runner.getY());
            requete.setInt(6, runner.getVitesse());
            requete.setBoolean(7, false); // Les Runners ne sont pas capturables

            requete.executeUpdate();
        }
    }
    
    // Pour Baril
    public void addBaril(Baril baril) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?, ?, ?, ?, ?)");
            requete.setInt(1, baril.getIdSQL());
            requete.setString(2, baril.getPseudo());
            requete.setString(3, "Baril"); 
            requete.setInt(4, baril.getX());
            requete.setInt(5, baril.getY());
            requete.setInt(6, 10); // Les Barils n'ont pas de vitesse attribué
            requete.setBoolean(6, baril.capturableGet());

            requete.executeUpdate();
        }
    }
}
