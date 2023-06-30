/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import GO.ZA.NewSessionBeanLocal;
import GO.ZA.note;
import GO.ZA.user;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author zeekouu
 */
public class EnregistrerNoteController {
    
    
     public static NewSessionBeanLocal getProxy() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        props.put("wildfly.naming.client.ejb.context", true);
        InitialContext ctx = new InitialContext(props);
        NewSessionBeanLocal NW = (NewSessionBeanLocal) ctx.lookup("ejb:/YESTA/NewSessionBean!GO.ZA.NewSessionBeanLocal");
        return NW;
    }
    
      @FXML
    private ComboBox<String> moduleComboBox;
      
      @FXML
     private Button BTN;

    @FXML
    private ComboBox<String> etudiantComboBox;

    @FXML
    private TextField noteTextField;

    private String selectedModule;
    private String selectesEtudiant;
    public void initialize() throws NamingException {
        //---------------partie etudiant----------------
          NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
          List<String> kok = new ArrayList<>();
             List<user> etudiants = bk.consulterUtediant();
             for(user u : etudiants){
                 String test = "";
                 
                 test += u.getNom()+" "+u.getPrenom();
                 kok.add(test);
             }
               ObservableList<String> mod = FXCollections.observableArrayList(kok);
            etudiantComboBox.setItems(mod);
             etudiantComboBox.setOnAction(event -> {
            selectesEtudiant = etudiantComboBox.getValue();
            System.out.println("Etudiant sélectionné : " + selectesEtudiant);
        });
             
        //---------------partie module------------------
         // Ajouter les modules à la liste de sélection
        ObservableList<String> modules = FXCollections.observableArrayList("DATAMINNING", "DATAWAREHOUSE", "APPLICATION REPARTIE","APPLICATION REPARTIE","MOTEUR DE RECHERCHE","GENIE LOGICIEL","ANGLAIS");
        moduleComboBox.setItems(modules);
         moduleComboBox.setOnAction(event -> {
            selectedModule = moduleComboBox.getValue();
            System.out.println("Module sélectionné : " + selectedModule);
        });
    }

    @FXML
    private void retour() {
          try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Enseignan.fxml"));
        Parent root = loader.load();

        File cssFile = new File("C:\\Users\\zeekouu\\OneDrive\\Bureau\\AR\\Style.css");
URL cssUrl = cssFile.toURI().toURL();
        // Créer la scène
Scene scene = new Scene(root, 1050, 576);
scene.getStylesheets().add(cssUrl.toExternalForm());

// Obtenir la fenêtre actuelle
Stage currentStage = (Stage) BTN.getScene().getWindow();

// Centrer la fenêtre sur l'écran
Screen screen = Screen.getPrimary();
         javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
double centerX = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) / 2;
double centerY = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) / 2;

// Afficher la scène dans la fenêtre actuelle
currentStage.setScene(scene);
currentStage.setX(centerX);
currentStage.setY(centerY);
currentStage.show();
      
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les exceptions lors du chargement de la page Etudiant.fxml
    }
    }
    @FXML
    private void ajout() throws NamingException {
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
        String valeur = noteTextField.getText();
        double value = Double.valueOf(valeur);
        System.out.println(value);
        note note = new note();
        note.setEtudiant(selectesEtudiant);
        note.setModule(selectedModule);
        note.setValeur(value);
        note.setReponse("0");
        bk.enregistrerNote(note);
        
        // Code pour gérer l'événement de retour
    }
    
}
