
import Controlleur.ConsulterNoteEtudiantController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.NamingException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
public class EtudiantController {
    public void initialize(Long id) throws NamingException {

try {
    while(id==null){
        System.out.println("mazaaal");
    }
    System.out.println("id est "+id);
   // Long id = 2L;
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil2.fxml"));
        Parent fxml = loader.load();
Acceuil2Controller acc = loader.getController();
acc.setId(id);
pnlOverview.getChildren().removeAll();
pnlOverview.getChildren ().setAll(fxml);
} catch (IOException ex) {
 }
    
}
    @FXML
    public void ini() throws IOException, NamingException{
     initialize(id);
        
    }
    
     @FXML
        private Button btnCustomers;

        @FXML
        private Button btnMenus;

        @FXML
        private Button btnOrders;

        @FXML
        private Button btnOverview;

        @FXML
        private Button btnPackages;

        @FXML
        private Button btnSettings;

        @FXML
        private Button btnSignout;

        @FXML
        private VBox pnItems;

        @FXML
        private Pane pnlCustomer;

        @FXML
        private Pane pnlMenus;

        @FXML
        private Pane pnlOrders;

        @FXML
        private Pane pnlOverview;
    
     private Long id;

    public void setId(Long id) {
        this.id = id;
    }
     @FXML
     private Button BTN;
    
    @FXML
    private void consulterNotes() throws IOException {
         Parent fxml = FXMLLoader.load(getClass().getResource (  "/Views/ConsulterNoteEtudiant.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
        
        // Charger la page Enseignant.fxml et afficher
    }
    @FXML
    private void telechargerCours() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource (  "/Views/TelechargerCours.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
          
        // Charger la page Enseignant.fxml et afficher
    }
          @FXML
           private void login() {
    try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        // Créer la scène
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
    
}
