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

/**
 *
 * @author bmartine
 */
public class Delete_OVSW {

    public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ?");
            requete.setInt(1, 1000);
            System.out.println(requete);
            int nombreDeSuppressions = requete.executeUpdate();
            System.out.println(nombreDeSuppressions + " enregistrement(s) supprime(s)");

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }

    }
   
    private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
    private static final String USERNAME = "etudiant";
    private static final String PASSWORD = "YTDTvj9TR3CDYCmP";
    
    // Supprime un Runner de la base de données
    public void deleteRunner(Runner runner) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ?");
            requete.setInt(1, runner.getIdSQL());

            requete.executeUpdate();
        }
    }
    
    // Baril
    public void deleteBaril(Baril baril) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ?");
            requete.setInt(1, baril.getIdSQL());

            requete.executeUpdate();
        }
    }

}

