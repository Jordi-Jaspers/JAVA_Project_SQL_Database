package database_objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jordi Jaspers
 */
public class SimpleSamenvatting {
    
    private final SimpleStringProperty naam1;
    private final SimpleStringProperty naam2;
    private final SimpleStringProperty naam3;
    private final SimpleStringProperty groep;
    private final SimpleStringProperty bachelorproef;

    /**
     *  deze klasse zet de string values om naar Simplestrings voor klasse
     *  samenvatting.
     * 
     * @param naam1
     * @param naam2
     * @param naam3
     * @param groep
     * @param bachelorproef
     */
    public SimpleSamenvatting(String naam1, String naam2, String naam3, String groep, String bachelorproef) {
        this.naam1 = new SimpleStringProperty(naam1);
        this.naam2 = new SimpleStringProperty(naam2);
        this.naam3 = new SimpleStringProperty(naam3);
        this.groep = new SimpleStringProperty(groep);
        this.bachelorproef = new SimpleStringProperty(bachelorproef);
    }

    /**
     * een getter voor de naam van student 1
     * @return naam1
     */
    public SimpleStringProperty naam1Property() {
        return naam1;
    }
    
    /**
     * een getter voor de naam van student 2
     * @return naam2
     */
    public SimpleStringProperty naam2Property() {
        return naam2;
    }
    
    /**
     * een getter voor de naam van student 3
     * @return naam3
     */
    public SimpleStringProperty naam3Property() {
        return naam3;
    }

    /**
     * een getter voor de groepsnaam.
     * @return groep
     */
    public SimpleStringProperty groepProperty() {
        return groep;
    }
    
    /**
     * getter voor de titel van de BP
     * @return bachelorproef
     */
    public SimpleStringProperty bachelorproefProperty() {
        return bachelorproef;
    }
}
