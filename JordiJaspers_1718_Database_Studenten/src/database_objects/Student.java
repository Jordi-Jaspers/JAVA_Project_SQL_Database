package database_objects;

/**
 * the Object of an Database Row of Bachelorproef.
 * 
 * @author Jordi Jaspers
 */
public class Student {

    private int id;
    private String naam;
    private String groep;
    private String bachelorproef;
    
    /**
     * de klasse student houdt alle informatie van een student
     * 
     * @param naam 
     * @param groep
     * @param bachelorproef
     */
    public Student(String naam, String groep, String bachelorproef) {
        this.naam = naam;
        this.groep = groep;
        this.bachelorproef = bachelorproef;
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
     * een getter voor de naam van de student
     * @return naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * een setter voor de naam van een student
     * @param naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * eeng getter voor de naam van groep
     * @return groep
     */
    public String getGroep() {
        return groep;
    }

    /**
     * een setter voor de naam van de groep
     * @param groep
     */
    public void setGroep(String groep) {
        this.groep = groep;
    }

    /**
     * een getter voor de naam van de BP
     * @return bachelorproef
     */
    public String getBachelorproef() {
        return bachelorproef;
    }

    /**
     * een setter voor naam van de BP
     * @param bachelorproef
     */
    public void setBachelorproef(String bachelorproef) {
        this.bachelorproef = bachelorproef;
    }
}
