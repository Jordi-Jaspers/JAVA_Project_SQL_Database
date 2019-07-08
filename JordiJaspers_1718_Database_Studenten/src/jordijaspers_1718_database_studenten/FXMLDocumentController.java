package jordijaspers_1718_database_studenten;

import database.BachelorProefDB;
import database.SamenvattingDB;
import database.StudentDB;
import database_objects.BachelorProef;
import database_objects.BP;
import database_objects.Samenvatting;
import database_objects.SimpleSamenvatting;
import database_objects.SimpleStudent;
import database_objects.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
public class FXMLDocumentController {
    
    @FXML
    private Button B_ReadMe;
    
    @FXML
    private TableView<SimpleStudent> studentTable;

    @FXML
    private TableColumn<SimpleStudent, String> column_Student;

    @FXML
    private TableColumn<SimpleStudent, String> column_StudentGroep;

    @FXML
    private TableColumn<SimpleStudent, String> column_StudentBachelorproef;
    
    @FXML
    private ChoiceBox<String> TE_keuze;

    @FXML
    private TableView<BP> bpTable1;

    @FXML
    private TableColumn<BP, String> column_Titel1;

    @FXML
    private TableColumn<BP, String> column_Beschrijving1;

    @FXML
    private TextField TE_groep;

    @FXML
    private TableView<SimpleSamenvatting> samenvattingTable;

    @FXML
    private TableColumn<SimpleSamenvatting, String> column_SStudent1;

    @FXML
    private TableColumn<SimpleSamenvatting, String> column_SStudent2;

    @FXML
    private TableColumn<SimpleSamenvatting, String> column_SStudent3;

    @FXML
    private TableColumn<SimpleSamenvatting, String> column_SGroep;

    @FXML
    private TableColumn<SimpleSamenvatting, String> column_SBP;
    
    @FXML
    private TextField TE_naam;

    @FXML
    private Button B_opslaanStudent;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TE_titel;

    @FXML
    private TextArea TE_beschrijving;

    @FXML
    private Button B_opslaanBP;

    @FXML
    private TableView<BP> bpTable;
    
    @FXML
    private TableColumn<BP, String> column_Titel;

    @FXML
    private TableColumn<BP, String> column_Beschrijving;
    
    @FXML
    private Button B_deleteBP;
    
    private BachelorProefDB modelBP;
    private StudentDB modelStudent;
    private SamenvattingDB modelSamenvatting;
    
    @FXML      
    void initialize() {
        modelBP = new BachelorProefDB();
        modelStudent = new StudentDB();
        modelSamenvatting = new SamenvattingDB();
        
        B_opslaanBP.setOnAction(event -> voegBPToe());
        B_opslaanStudent.setOnAction(event -> voegStudentToe());
        B_deleteBP.setOnAction(event -> verwijderBP());
        B_ReadMe.setOnAction(event -> openReadMe());
        
        updateTable();
    }
    
    /**
     * methode voor het verwijderen van een element uit de database.
     */
    public void verwijderBP(){
        BP selected = bpTable.getSelectionModel().getSelectedItem();
        if(selected != null){
        bpTable.getItems().remove(selected);
        modelBP.verwijder(selected.titelProperty().getValue());
        updateTable();
        }
        else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Error 404: Nothing selected");
            alert.setContentText("Selecteer iets voordat u op deze knop duwt!");

            alert.showAndWait();
        }
    }
    
    /**
     * een methode die een bachelorproef toevoegd aan de tabel.
     */
    public void voegBPToe(){
        if(TE_titel.getText().trim().isEmpty() || TE_beschrijving.getText().trim().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Error 404: input not found");
            alert.setContentText("Vul alle gegevens in A.U.B!");

            alert.showAndWait();
        }else{
        BachelorProef newBP = new BachelorProef(TE_titel.getText(), TE_beschrijving.getText());
        modelBP.voegToe(newBP);
        updateTable();
        }
    }
    
    /**
     * een methode die een student toevoegd aan de tabel.
     * hierbij wordt er eerst gekeken als alles is ingevuld is en erna
     * wordt er gechecked als de groep niet al groter is dan 3 of als de groepsnaam
     * niet te lang is.
     */
    public void voegStudentToe(){

        if(TE_naam.getText().trim().isEmpty() || TE_groep.getText().trim().isEmpty() || TE_keuze.getValue().equals("")){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Error 404: input not found");
            alert.setContentText("Vul alle gegevens in A.U.B!");

            alert.showAndWait();
        }
        else if(getStudentGroepIndex(TE_groep.getText()) != null){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Error 101: Groep te groot!");
            alert.setContentText("Vul een andere groep aan. Huidige groep is te vol!");

            alert.showAndWait();
        }
        else if(TE_groep.getText().length() > 2) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Error 101: Groepnaam is te lang");
            alert.setContentText("Zorg ervoor de naam maximaal 2 charachters lang is. Voorbeeld: C3");

            alert.showAndWait(); 
        }else{
            Student newStudent = new Student(TE_naam.getText(), TE_groep.getText(), TE_keuze.getValue());
            modelStudent.voegToe(newStudent);
            updateTable();
            voegSamenvattingToe(TE_groep.getText().toUpperCase());
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("Student succesvol toegevoegd!");

            alert.showAndWait();
        }
    }
    
    /**
     * een methode die automatisch opgeroepen wordt op het moment dat er 3 studenten
     * dezelfde groep hebben en die samenvoegt met en bachelorproef in een andere 
     * tabel.
     * 
     * @param value is de groepnaam
     */
    public void voegSamenvattingToe(String value){
        int[] index = getStudentGroepIndex(value);
        
        if(index != null){
            ArrayList<Student> studentList = modelStudent.getProeven();
            
            int counter = 0;
            for (int i = 1; i < 3; i++) {
                if(studentList.get(index[0]).getBachelorproef().equals(studentList.get(index[i]).getBachelorproef())){
                    counter ++;
                }
            }
            
            String bachelorproef = null;
            if (counter >= 2){
                bachelorproef = studentList.get(index[0]).getBachelorproef();
            }
            else{
                Random random = new Random();
                bachelorproef = studentList.get(index[random.nextInt(3)]).getBachelorproef();
            }

            Samenvatting newSamenvatting = new Samenvatting(
                    studentList.get(index[0]).getNaam(), 
                    studentList.get(index[1]).getNaam(),
                    studentList.get(index[2]).getNaam(),
                    value, 
                    bachelorproef
            );
            
            modelSamenvatting.voegToe(newSamenvatting);
            updateTable();
        }
    }
    
    /**
     * Hierbij wordt data uit de database getrokken en deze omgezet naar de tabel.
     */
    public void vulTabelBP(){
        ArrayList<BachelorProef> BPList = modelBP.getProeven();
        ObservableList<BP> bps = FXCollections.observableArrayList();
        ObservableList<String> keuze = FXCollections.observableArrayList();
        
        for (BachelorProef bp : BPList) {
            bps.add(new BP(bp.getTitel(),bp.getBeschrijving()));
            keuze.add(bp.getTitel());
        }
        
        TE_keuze.setItems(keuze);
        
        column_Titel.setCellValueFactory(rij -> rij.getValue().titelProperty());
        column_Titel1.setCellValueFactory(rij -> rij.getValue().titelProperty());
        
        column_Beschrijving.setCellValueFactory(rij -> rij.getValue().beschrijvingProperty());
        column_Beschrijving1.setCellValueFactory(rij -> rij.getValue().beschrijvingProperty());
        
        bpTable.setItems(bps);
        bpTable1.setItems(bps);
    }
    
    /**
     * Hierbij wordt data uit de database getrokken en deze omgezet naar de tabel.
     */
    public void vulTabelStudent(){
        ArrayList<Student> studentList = modelStudent.getProeven();
        ObservableList<SimpleStudent> simpleStudent = FXCollections.observableArrayList();
        
        for (Student student : studentList) {
            simpleStudent.add(new SimpleStudent(student.getNaam(), student.getGroep(), student.getBachelorproef()));
        }
        
        column_Student.setCellValueFactory(rij -> rij.getValue().naamProperty());
        column_StudentGroep.setCellValueFactory(rij -> rij.getValue().groepProperty());
        column_StudentBachelorproef.setCellValueFactory(rij -> rij.getValue().bachelorproefProperty());
        
        studentTable.setItems(simpleStudent);
    }

    /**
     * Hierbij wordt data uit de database getrokken en deze omgezet naar de tabel.
     */
    private void vulTabelSamenvatting() {
       ArrayList<Samenvatting> samenvattingList = modelSamenvatting.getProeven();
       ObservableList<SimpleSamenvatting> simpleSamenvatting = FXCollections.observableArrayList();
        
        for (Samenvatting samenvatting : samenvattingList) {
            simpleSamenvatting.add(new SimpleSamenvatting(
                    samenvatting.getNaam1(), 
                    samenvatting.getNaam2(), 
                    samenvatting.getNaam3(), 
                    samenvatting.getGroep(), 
                    samenvatting.getBachelorproef()));
        }

        column_SStudent1.setCellValueFactory(rij -> rij.getValue().naam1Property());
        column_SStudent2.setCellValueFactory(rij -> rij.getValue().naam2Property());
        column_SStudent3.setCellValueFactory(rij -> rij.getValue().naam3Property());
        column_SGroep.setCellValueFactory(rij -> rij.getValue().groepProperty());
        column_SBP.setCellValueFactory(rij -> rij.getValue().bachelorproefProperty());
        
        samenvattingTable.setItems(simpleSamenvatting);
    }
    
    /**
     * deze methode update alle tabellen.
     */
    public void updateTable(){
        vulTabelStudent();
        vulTabelSamenvatting();
        vulTabelBP();
    }
    
    /**
     * Deze methode geeft de index van de 3 studenten terug met dezelfde groepnaam.
     * 
     * @param value groepnaam
     * @return index van de studenten
     */
    public int[] getStudentGroepIndex(String value){
        ArrayList<String> groepList = new ArrayList<>();
        
        for(SimpleStudent simplestudent : studentTable.getItems()){
            groepList.add(column_StudentGroep.getCellObservableValue(simplestudent).getValue());
        }
        
        int counter = 0;
        int[] index = new int[3];
        for (int i = 0; i < groepList.size(); i++) {
            if (groepList.get(i).equals(value)) {
                index[counter] = i;
                counter ++;
            }
        }
        
        if(counter >= 3){
            return index;
        }
        else{
            return null;
        }
    }
    
    /**
     * Deze methode opent de bijhorende readme file voor extra uitleg.
     */
    private void openReadMe(){
        Runtime rs = Runtime.getRuntime();
        
        try {
            File file = new File("src\\resources\\README.txt");
            String[] command = { "notepad.exe", file.getAbsolutePath() };
            rs.exec(command);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
