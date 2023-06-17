/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archives;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import moteur.Baril;
import moteur.Runner;

/**
 *
 * @author bmartine
 */
public class Update_OVSW {
    
    public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

            PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET Pseudo = ? WHERE Id = ?");
            requete.setString(1, "Superscrum" );
            requete.setInt(2, 1000);
            System.out.println(requete);
            int nombreDeModifications = requete.executeUpdate();
            System.out.println(nombreDeModifications + " enregistrement(s) modifie(s)");

            requete.close();  
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
   
    private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
    private static final String USERNAME = "etudiant";
    private static final String PASSWORD = "YTDTvj9TR3CDYCmP";
    
   
    // Met à jour un Runner dans la base de données
    public void updateRunner(Runner runner) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET pseudo = ?, x = ?, y = ?, vitesse = ? WHERE id = ?");
            requete.setString(1, runner.getPseudo());
            requete.setInt(2, runner.getX());
            requete.setInt(3, runner.getY());
            requete.setInt(4, runner.getVitesse());
            requete.setInt(5, runner.getIdSQL());

            requete.executeUpdate();
        }
    }
    
    // BARIL
    public void updateBaril(Baril baril) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET pseudo = ?, x = ?, y = ?, capturable = ? WHERE id = ?");
            requete.setString(1, baril.getPseudo());
            requete.setInt(2, baril.getX());
            requete.setInt(3, baril.getY());
            requete.setBoolean(4, baril.capturableGet());
            requete.setInt(5, baril.getIdSQL());

            requete.executeUpdate();
        }
    }
}
