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

         PreparedStatement requete = connexion.prepareStatement("SELECT Id, Pseudo FROM Joueur ");
            System.out.println(requete);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                int Id = resultat.getInt("Id");
                String Pseudo = resultat.getString("Pseudo");
                
                System.out.println( Id + ", " + Pseudo  );
            }

            requete.close();
            connexion.close();
        } catch (SQLException ex) {
          
            
            ex.printStackTrace();
        }

    }
}
