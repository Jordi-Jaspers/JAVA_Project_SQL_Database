package database_objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jordi Jaspers
 */
public class BP {
    private final SimpleStringProperty titel;
    private final SimpleStringProperty beschrijving;

    /**
     *  deze klasse zet de string values om naar Simplestrings voor klasse
     *  bachelorproef.
     * 
     * @param titel
     * @param beschrijving
     */
    public BP(String titel, String beschrijving) {
        this.titel = new SimpleStringProperty(titel);
        this.beschrijving = new SimpleStringProperty(beschrijving);
    }

    /**
     * getter voor titel
     * @return titel
     */
    public SimpleStringProperty titelProperty() {
        return titel;
    }

    /**
     * getter voor beschrijving
     * @return beschrijving
     */
    public SimpleStringProperty beschrijvingProperty() {
        return beschrijving;
    } 
}
