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
import java.sql.Statement;

/**
 *
 * @author bmartine
 */
public class Init_OVSW {

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
     
     
     try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
      

            
            Statement statement = connexion.createStatement() ;
            

            
            statement.executeUpdate("DELETE FROM Joueur;");           
            
            statement.executeUpdate("INSERT INTO Joueur (Id, pseudo, x, y, type, vitesse,capturable) "
                    + "VALUES ( 1, 'Joueur 1', 0, 0, 'joueur', 2, false)");
            
            statement.executeUpdate("INSERT INTO Joueur (Id, pseudo, x, y, type, vitesse,capturable) "
                    + "VALUES ( 2, 'Joueur 1', 0, 0, 'baril', 2, true)");
            
            statement.executeUpdate("INSERT INTO Joueur (Id, pseudo, x, y, type, vitesse,capturable) "
                    + "VALUES ( 3, 'Joueur 1', 0, 0, 'baril', 2, true)");
            
            statement.executeUpdate("INSERT INTO Joueur (Id, pseudo, x, y, type, vitesse,capturable) "
                    + "VALUES ( 4, 'Joueur 1', 0, 0, 'baril', 2, true)");
           
            
            ResultSet resultat = statement.executeQuery("SELECT * FROM Joueur;");
            
               OutilsJDBC.afficherResultSet(resultat);
            
            statement.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

     }
     }

         
         
         
         
         
         
         
         
         
         
//            PreparedStatement requete = connexion.prepareStatement("DELETE FROM Joueur WHERE id = ? ");
//            
//          
//            requete.setInt(1, 1 );
//            requete.setInt(2, 2 );
//            requete.setInt(3, 3 );
//            requete.setInt(4, 4 );
//            
//            System.out.println(requete);
//       
//            
//          requete.close();
//            connexion.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//                }
//     
//     
//     
//        try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? ) ");
//            
//              ResultSet result = requete.executeQuery();
//            while (result.next()) {
//            
//            requete.setInt(1, 1);
//            requete.setString(2, " Joueur " );
//            requete.setInt(3, 0 );
//            requete.setInt(4, 0 );
//            requete.setInt(5, 1 );
//            requete.setInt(6, 2 );
//            requete.setBoolean(7, false );
//            
//            System.out.println(requete);
//
//            }requete.close();
//            connexion.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        
//        try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
//            requete.setInt(1, 2);
//            requete.setString(2, " Baril 1 " );
//            requete.setInt(3, 0 );
//            requete.setInt(4, 0 );
//            requete.setInt(5, 1 );
//            requete.setInt(6, 2 );
//            requete.setBoolean(7, true );
//            
//            System.out.println(requete);
//
//         requete.close();
//            connexion.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        
//        try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
//            requete.setInt(1, 3);
//            requete.setString(2, " Baril 2 " );
//            requete.setInt(3, 0 );
//            requete.setInt(4, 0 );
//            requete.setInt(5, 1 );
//            requete.setInt(6, 2 );
//            requete.setBoolean(7, true );
//            
//            System.out.println(requete);
//
//             requete.close();
//            connexion.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        
//        try (Connection connexion = SingletonJDBC.getInstance().getConnection()) {
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO Joueur VALUES(?, ?,? ,? , ? , ? , ? )");
//            requete.setInt(1, 4);
//            requete.setString(2, " Baril 3 " );
//            requete.setInt(3, 0 );
//            requete.setInt(4, 0 );
//            requete.setInt(5, 1 );
//            requete.setInt(6, 2 );
//            requete.setBoolean(7, true );
//            
//            System.out.println(requete);

   

   
  
