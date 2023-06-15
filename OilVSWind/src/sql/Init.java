/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bmartine
 */
public class Init {
    
     private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
    private static final String USERNAME = "etudiant";
    private static final String PASSWORD = "YTDTvj9TR3CDYCmP";
    
    
 public void initialisationJoueurs() throws SQLException {
     
     
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ? ");
            requete.setInt(1, 1 );
            requete.setInt(2, 2 );
            requete.setInt(3, 3 );
            requete.setInt(4, 4 );
            

            requete.executeUpdate();
        }
     
     
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?, ?, ?, ?,?,?) ");
            requete.setInt(1, 1);
            requete.setString(2, " Joueur " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, false );

            requete.executeUpdate();
        }
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?, ?, ?, ?,?,?)");
            requete.setInt(1, 2);
            requete.setString(2, " Baril 1 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );

            requete.executeUpdate();
        }
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?, ?, ?, ?,?,?)");
            requete.setInt(1, 3);
            requete.setString(2, " Baril 2 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );

            requete.executeUpdate();
        }
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?, ?, ?, ?,?,?)");
            requete.setInt(1, 4);
            requete.setString(2, " Baril 3 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );

            requete.executeUpdate();
        }
        
        
        
        
    }    
    
    
    
}
