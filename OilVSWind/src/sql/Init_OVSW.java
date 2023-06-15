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
public class Init_OVSW {
    
        private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
        private static final String USERNAME = "etudiant";
        private static final String PASSWORD = "YTDTvj9TR3CDYCmP";
         
    
     public static void main(String[] args) {

         
      
//        try {

//            Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
//
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES (?, ?,? ,? , ? , ? , ? )");
//            requete.setInt(1, 1000);
//            requete.setString(2, "Scrum" );
//            requete.setInt(3, 1 );
//            requete.setInt(4, 1 );
//            requete.setInt(5, 1 );
//            System.out.println(requete);
//            int nombreDAjouts = requete.executeUpdate();
//            System.out.println(nombreDAjouts + " enregistrement(s) ajoute(s)");
//            
//           
//
//            requete.close();
//            connexion.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
     
     
     try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ? ");
            requete.setInt(1, 1 );
            requete.setInt(2, 2 );
            requete.setInt(3, 3 );
            requete.setInt(4, 4 );
            
            System.out.println(requete);
            

          requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
     
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? ) ");
            requete.setInt(1, 1);
            requete.setString(2, " Joueur " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, false );
            
            System.out.println(requete);

           requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
            requete.setInt(1, 2);
            requete.setString(2, " Baril 1 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );
            
            System.out.println(requete);

         requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
            requete.setInt(1, 3);
            requete.setString(2, " Baril 2 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );
            
            System.out.println(requete);

             requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
            requete.setInt(1, 4);
            requete.setString(2, " Baril 3 " );
            requete.setInt(3, 0 );
            requete.setInt(4, 0 );
            requete.setInt(5, 1 );
            requete.setInt(6, 2 );
            requete.setBoolean(7, true );
            
            System.out.println(requete);

          requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

     }
}
   
  
