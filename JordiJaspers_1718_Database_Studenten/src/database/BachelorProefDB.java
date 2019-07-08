package database;

import database_objects.BachelorProef;
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
 *  de tabel bachelorproef om daar informatie uit te halen en te verwerken in deze
 *  applicatie.
 * 
 * @author Jordi Jaspers
 */
public class BachelorProefDB {
 
    private Connection connection;
    
    /**
     * de constructor maakt connectie met de database.
     */
    public BachelorProefDB(){
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bachelor", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(BachelorProefDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * hierbij verwijderen we een BP van de database.
     * @param value 
     */
    public void verwijder(String value){
    try{    
      String sql = "DELETE FROM bachelorproef WHERE titel = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, value);

      stmt.execute();
      
    }catch (SQLException e){
      System.err.println(e.getMessage());
    }

    }
    
    /**
     *  hierbij voegen we een BP toe aan de database.
     * @param bp
     */
    public void voegToe(BachelorProef bp) {
        PreparedStatement stmt;
        
        try {
            String sql =
                    "insert into bachelorproef (titel, beschrijving)" +
                    "values (?, ?)";
            
            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, bp.getTitel());
            stmt.setString(2, bp.getBeschrijving());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BachelorProefDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * hierbij vragen we alle informatie van de database.
     * @return ArrayList<BachelorProef>
     */
    public ArrayList<BachelorProef> getProeven(){
       PreparedStatement stmt;
       ArrayList<BachelorProef> lijst = new ArrayList<>();
       
        try {
            String sql =
                    "select * from bachelorproef";
            
            stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while (results.next()){
                String titel = results.getString("titel");
                String beschrijving = results.getString("beschrijving");
                int id = results.getInt("id");
                BachelorProef bp = new BachelorProef(titel, beschrijving);
                bp.setId(id);
                lijst.add(bp);
            }
            
            stmt.close();
            return lijst;
            
        } catch (SQLException ex) {
            Logger.getLogger(BachelorProefDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
