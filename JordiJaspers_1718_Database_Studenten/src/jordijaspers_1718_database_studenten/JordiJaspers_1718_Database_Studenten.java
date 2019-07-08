package jordijaspers_1718_database_studenten;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Dit is een beginende databsae waarbij men bachelorproeven kan toevoegen/verwijderen.
 * Hierbij kan in het tweede tablad een student zijn gegevens invullen en kiezen welke
 * voorkeur hij heeft voor de aangegeven bachelorproeven die gelinkt zijn vanuit de 
 * database naar de choicebox. als er eenmaal 3 man met dezelfde groep zitten, wordt
 * er automatisch een algoritme opgeroepen die dan de 3 hun voorkeuren pakken en daaruit
 * een willekeurige bachelorproef kiest en die dan toevoegd aan de samenvattende tabel
 * deze tabel bestaat uit 3 studenten, hun groep naam en de gekozen proef.
 * 
 * @author Jordi Jaspers
 * @version V1.0
 */
public class JordiJaspers_1718_Database_Studenten extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Bachelorproef Database");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Laden van de driver is gelukt.");
        }
        catch(ClassNotFoundException ex){
            System.err.println(ex);
            return;
        }
        
        launch(args);
    }
    
}
