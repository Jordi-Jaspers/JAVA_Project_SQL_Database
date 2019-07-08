package database_objects;

/**
 * De klasse samenvatting is een object met de 3 studenten, hun groepsnaam
 * samen met de meegegven bachelorproef in hun voorkeuze lijst.
 * 
 * @author Jordi Jaspers
 */
public class Samenvatting {
    
    private int id;
    private String naam1;
    private String naam2;
    private String naam3;
    private String groep;
    private String bachelorproef;
    
    /**
     *
     * @param naam1
     * @param naam2
     * @param naam3
     * @param groep
     * @param bachelorproef
     */
    public Samenvatting(String naam1, String naam2, String naam3, String groep, String bachelorproef) {
        this.naam1 = naam1;
        this.naam2 = naam2;
        this.naam3 = naam3;
        this.groep = groep;
        this.bachelorproef = bachelorproef;
    }

    /**
     * getter voor de id/index van het object.
     * @return
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
     * getter voor de student1
     * @return naam1
     */
    public String getNaam1() {
        return naam1;
    }

    /**
     * setter voor de naam van student 1
     * @param naam1
     */
    public void setNaam1(String naam1) {
        this.naam1 = naam1;
    }

    /**
     * getter voor de student2
     * @return naam2
     */
    public String getNaam2() {
        return naam2;
    }

    /**
     * setter voor de naam van student 2
     * @param naam2
     */
    public void setNaam2(String naam2) {
        this.naam2 = naam2;
    }

    /**
     * getter voor de student3
     * @return naam3
     */
    public String getNaam3() {
        return naam3;
    }

    /**
     * setter voor de naam van student 3
     * @param naam3
     */
    public void setNaam3(String naam3) {
        this.naam3 = naam3;
    }
    
    /**
     * een getter voor de groepsnaam
     * @return groep
     */
    public String getGroep() {
        return groep;
    }

    /**
     * eens setter voor de groepsnaam
     * @param groep
     */
    public void setGroep(String groep) {
        this.groep = groep;
    }

    /**
     * een getter voor de titel van de bachelorproef
     * @return
     */
    public String getBachelorproef() {
        return bachelorproef;
    }

    /**
     * een setten voor de titel van de bachelorproef
     * @param bachelorproef
     */
    public void setBachelorproef(String bachelorproef) {
        this.bachelorproef = bachelorproef;
    }
}
