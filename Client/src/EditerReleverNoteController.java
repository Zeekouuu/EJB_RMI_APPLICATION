import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EditerReleverNoteController implements Initializable{
   
     @FXML
    private ListView<String> etudiantListView;
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
Stage currentStage = (Stage) etudiantListView.getScene().getWindow();

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
    private void editerReleveNotes() {
         try {
     //   String notes = notesTextArea.getText();
            // Recherche du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération du service à partir du registre RMI
            DatabaseService databaseService = (DatabaseService) registry.lookup("DatabaseService");

            // Appel de la méthode du service RMI pour consulter les étudiants
             databaseService.editerNotes();
          
            // Utilisation des données récupérées
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Récupérer le texte du TextArea

        // Traiter les relevés de notes ici
        // Par exemple, enregistrer les notes dans la base de données

        // Afficher un message de confirmation
      //  System.out.println("Relevés de notes édités : " + notes);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // Recherche du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération du service à partir du registre RMI
            DatabaseService databaseService = (DatabaseService) registry.lookup("DatabaseService");

            // Appel de la méthode du service RMI pour consulter les étudiants
            List<note> data = databaseService.consulterNote();
            List<String> kok = new ArrayList<>();
            // Utilisation des données récupérées
                String test = "";
            for (note u : data) {
                 
                 test += ""+u.getEtudiant()+"       "+u.getModule()+"       "+u.getValeur()+"\n";
                 kok.add(test);
              //  System.out.println(value.getNom());
            }
            test="ETUDIANT         MODULE           VALEUR\n"+test;
            etudiantListView.getItems().addAll(test);
            String k = String.valueOf(kok);
             // notesTextArea.setText(k);
        } catch (Exception e) {
            e.printStackTrace();
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
