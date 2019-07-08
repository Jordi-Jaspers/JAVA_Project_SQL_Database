package database_objects;

/**
 * the Object of an Database Row of Bachelorproef.
 * 
 * @author Jordi Jaspers
 */
public class BachelorProef {
    private int id;
    private String titel;
    private String beschrijving;

    /**
     *  de klasse bachelorproef houdt alle informatie nodig voor het opstellen
     *  van een bachelorproef onderwerp.
     * @param titel
     * @param beschrijving
     */
    public BachelorProef(String titel, String beschrijving) {
        this.titel = titel;
        this.beschrijving = beschrijving;
    }

    /**
     * getter voor de id/index van het object.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * setter voor de ID van het object (auto-increment)
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * getter voor de titel.
     * @return titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * setter voor de titel
     * @param titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * getter voor beschrijving
     * @return beschrijving
     */
    public String getBeschrijving() {
        return beschrijving;
    }

    /**
     * setter voor beschrijving
     * @param beschrijving
     */
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
