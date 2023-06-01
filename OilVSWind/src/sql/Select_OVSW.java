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
     
     
     
     
     
     
     



