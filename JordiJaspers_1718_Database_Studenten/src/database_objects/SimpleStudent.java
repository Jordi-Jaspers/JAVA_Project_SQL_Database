package database_objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jordi Jaspers
 */
public class SimpleStudent {
    
    private final SimpleStringProperty naam;
    private final SimpleStringProperty groep;
    private final SimpleStringProperty bachelorproef;

    /**
     *  deze klasse zet de string values om naar Simplestrings voor klasse
     *  student.
     * 
     * @param naam
     * @param groep
     * @param bachelorproef
     */
    public SimpleStudent(String naam, String groep, String bachelorproef) {
        this.naam = new SimpleStringProperty(naam);
        this.groep = new SimpleStringProperty(groep);
        this.bachelorproef = new SimpleStringProperty(bachelorproef);
    }

    /**
     * een getter voor de naam van de student
     * @return
     */
    public SimpleStringProperty naamProperty() {
        return naam;
    }

    /**
     * een getter voor de naam van de groep
     * @return
     */
    public SimpleStringProperty groepProperty() {
        return groep;
    }
    
    /**
     * een getter voor de naam van de BP
     * @return
     */
    public SimpleStringProperty bachelorproefProperty() {
        return bachelorproef;
    }
}
