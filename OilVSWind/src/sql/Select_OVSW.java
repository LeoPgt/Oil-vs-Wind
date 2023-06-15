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
import moteur.Baril;
import moteur.Runner;

/**
 *
 * @author bmartine
 */
public class Select_OVSW {
     public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

         PreparedStatement requete = connexion.prepareStatement("SELECT Id,Coordonée_X ,Coordonée_Y   FROM Joueur ");
            System.out.println(requete);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int Id = resultat.getInt("Id");
                int Coordonée_X = resultat.getInt("Coordonée_X");
                int Coordonée_Y = resultat.getInt("Coordonée_Y");
                System.out.println( Id + ", " + Coordonée_X + "," + Coordonée_Y );
            }

            requete.close();
            connexion.close();
        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }

    }
     

 public void get_jouable_x (String[] args) {
     
      try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

         PreparedStatement requete = connexion.prepareStatement("SELECT Coordonée_X FROM Jouable ");
            System.out.println(requete);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int Coordonée_X  = resultat.getInt("Coordonée_X ");
                
                
                System.out.println( Coordonée_X    );
            }

            requete.close();
            connexion.close();
        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }
     
 }
 
  public void get_jouable_y (String[] args) {
     
      try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

         PreparedStatement requete = connexion.prepareStatement("SELECT Coordonée_Y FROM Jouable ");
            System.out.println(requete);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int Coordonée_Y = resultat.getInt("Coordonée_Y ");
                
                
                System.out.println( Coordonée_Y    );
            }

            requete.close();
            connexion.close();
        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }
     
 }
 
 
 
  public void get_jouable_xy (String[] args) {
     
      try {

            Connection connexion = DriverManager.getConnection("jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind", "etudiant", "YTDTvj9TR3CDYCmP");

         PreparedStatement requete = connexion.prepareStatement("SELECT Coordonée_X, Coordonée_Y FROM Jouable ");
            System.out.println(requete);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int Coordonée_X  = resultat.getInt("Coordonée_X ");
                int Coordonée_Y  = resultat.getInt("Coordonée_Y ");
                
                System.out.println( Coordonée_X  + "," + Coordonée_Y  );
            }

            requete.close();
            connexion.close();
        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }
     
 }
 
   
     
 
  
  
  
  
  
 }    
     
     
     
     
     
     
     




   
    private static final String CONNECTION_URL = "jdbc:mariadb://nemrod.ens2m.fr:3306/2022-2023_s2_vs1_tp1_OilvSWind";
    private static final String USERNAME = "etudiant";
    private static final String PASSWORD = "YTDTvj9TR3CDYCmP"; 
    // Récupère un Runner depuis la base de données
    public Runner getRunner(int id) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Joueur WHERE id = ?");
            requete.setInt(1, id);

            ResultSet result = requete.executeQuery();
            if (result.next()) {
                return new Runner(result.getInt("id"), result.getString("pseudo"), result.getInt("x"), result.getInt("y"), result.getInt("vitesse"));
            } else {
                return null; // Ou lancez une exception si l'id du Runner n'existe pas dans la base de données
            }
        }
    }
    //Baril
    public Baril getBaril(int id) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement requete = connexion.prepareStatement("SELECT * FROM Joueur WHERE id = ?");
            requete.setInt(1, id);

            ResultSet result = requete.executeQuery();
            if (result.next()) {
                return new Baril(result.getInt("id"), result.getString("pseudo"),result.getInt("numero"), result.getInt("x"), result.getInt("y"), result.getBoolean("capturable"));
            } else {
                return null; // Ou lancez une exception si l'id du Baril n'existe pas dans la base de données
            }
        }
    }
}

//CREATE TABLE Joueur (
//    id INT PRIMARY KEY,
//    pseudo VARCHAR(255),
//    type CHAR(10),
//    x INT,
//    y INT,
//    vitesse INT,
//    capturable BOOLEAN
//);

