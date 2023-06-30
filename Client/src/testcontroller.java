/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class testcontroller implements Initializable {
      @FXML
    private ListView<String> etudiantListView;
    @FXML
     private Button BTN;

   @FXML
   public void retour(){
     try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cordinateu.fxml"));
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

   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          try {
            // Recherche du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération du service à partir du registre RMI
            DatabaseService databaseService = (DatabaseService) registry.lookup("DatabaseService");

            // Appel de la méthode du service RMI pour consulter les étudiants
            List<user> data = databaseService.consulterEtudiant();
              System.out.println(data);
            List<String> kok = new ArrayList<>();
            // Utilisation des données récupérées
            for (user u : data) {
                String test = "";
                 
                 test += " Nom :\n "+u.getNom()+"\n prenom :\n"+u.getPrenom();
                 kok.add(test);
              //  System.out.println(value.getNom());
            }
              etudiantListView.getItems().addAll(kok);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Code d'initialisation du contrôleur (si nécessaire)
    }
}


