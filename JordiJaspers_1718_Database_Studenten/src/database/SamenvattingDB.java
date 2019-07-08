package database;

import database_objects.Samenvatting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Deze klasse maakt connectie met de SQL database van "bachelor" en zoekt voor 
 *  de tabel studentenkueze om daar informatie uit te halen en te verwerken in deze
 *  applicatie.
 * 
 * @author Jordi Jaspers
 */
public class SamenvattingDB {
     private Connection connection;
    
    /**
     * de constructor maakt connectie met de database.
     */
    public SamenvattingDB(){
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bachelor", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(SamenvattingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     *  hierbij voegen we een samenvatting toe aan de database.
     * @param samenvatting
     */
    public void voegToe(Samenvatting samenvatting) {
        PreparedStatement stmt;
        
        try {
            String sql =
                    "insert into studentenkeuze (Student1, Student2, Student3, Groep, Bachelorproef)" +
                    "values (?, ?, ?, ?, ?)";
            
            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, samenvatting.getNaam1());
            stmt.setString(2, samenvatting.getNaam2());
            stmt.setString(3, samenvatting.getNaam3());
            stmt.setString(4, samenvatting.getGroep());
            stmt.setString(5, samenvatting.getBachelorproef());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SamenvattingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * hierbij vragen we alle informatie van de database.
     * @return ArrayList<Samenvatting>
     */
    public ArrayList<Samenvatting> getProeven(){
       PreparedStatement stmt;
       ArrayList<Samenvatting> lijst = new ArrayList<>();
       
        try {
            String sql =
                    "select * from studentenkeuze";
            
            stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while (results.next()){
                String naam1 = results.getString("Student1");
                String naam2 = results.getString("Student2");
                String naam3 = results.getString("Student3");
                String groep = results.getString("Groep");
                String bachelorproef = results.getString("Bachelorproef");
                
                int id = results.getInt("id");
                Samenvatting samenvatting = new Samenvatting(naam1, naam2, naam3, groep, bachelorproef);
                samenvatting.setId(id);
                lijst.add(samenvatting);
            }
            
            stmt.close();
            return lijst;
            
        } catch (SQLException ex) {
            Logger.getLogger(SamenvattingDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
