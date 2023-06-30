/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */

import GO.ZA.NewSessionBeanLocal;
import GO.ZA.user;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConrdinateurController {
        public static NewSessionBeanLocal getProxy() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        props.put("wildfly.naming.client.ejb.context", true);
        InitialContext ctx = new InitialContext(props);
        NewSessionBeanLocal NW = (NewSessionBeanLocal) ctx.lookup("ejb:/YESTA/NewSessionBean!GO.ZA.NewSessionBeanLocal");
        return NW;
    }
        
            public void initialize(Long id) throws NamingException {

try {
    while(id==null){
        id=1L;
    }
    System.out.println("id est "+id);
   // Long id = 2L;
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil3.fxml"));
        Parent fxml = loader.load();
AcceuilController acc = loader.getController();
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
        private Pane pnlOverview;
        
       
        
            private Long id;

    public void setId(Long id) throws NamingException {
        
        this.id = id;
      
    }
    @FXML
    private Button BTN;

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

    @FXML
    private void AjouterEtudiant() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource (  "AjouterEtudiant.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
      
       
        // Code pour gérer l'événement de clic sur le bouton "AjouterEtudiant"
        // ...
    }

    @FXML
    private void ConsulterEtudiant() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource (  "test.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
     
        // Code pour gérer l'événement de clic sur le bouton "ConsulterEtudiant"
        // ...
    }

    @FXML
    private void ReleverDeNotes() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource (  "EditerRleverNote.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
        
        // Code pour gérer l'événement de clic sur le bouton "ReleverDeNotes"
        // ...
    }
}

