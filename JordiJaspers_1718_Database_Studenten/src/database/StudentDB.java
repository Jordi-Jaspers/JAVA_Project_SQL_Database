package database;

import database_objects.Student;
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
 *  de tabel student om daar informatie uit te halen en te verwerken in deze
 *  applicatie.
 * 
 * @author Jordi Jaspers
 */
public class StudentDB {
    
    private Connection connection;
    
    /**
     * de constructor maakt connectie met de database.
     */
    public StudentDB(){
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bachelor", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * hierbij voegen we een student toe aan de database.
     * @param student
     */
    public void voegToe(Student student) {
        PreparedStatement stmt;
        
        try {
            String sql =
                    "insert into studenten (naam, groep, bachelorproef)" +
                    "values (?, ?, ?)";
            
            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, student.getNaam());
            stmt.setString(2, student.getGroep());
            stmt.setString(3, student.getBachelorproef());
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * hierbij vragen we alle informatie van de database.
     * @return ArrayList<Student>
     */
    public ArrayList<Student> getProeven(){
       PreparedStatement stmt;
       ArrayList<Student> lijst = new ArrayList<>();
       
        try {
            String sql =
                    "select * from studenten";
            
            stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while (results.next()){
                String naam = results.getString("naam");
                String groep = results.getString("groep");
                String bachelorproef = results.getString("bachelorproef");
                int id = results.getInt("id");
                Student student = new Student(naam, groep, bachelorproef);
                student.setId(id);
                lijst.add(student);
            }
            
            stmt.close();
            return lijst;
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
