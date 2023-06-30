
import Controlleur.ConsulterEtudiantControlleur;
import GO.ZA.NewSessionBeanLocal;
import GO.ZA.user;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zeekouu
 */
public class EnseignantController {
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
    private Pane pnlOverview;
    
  
    
    
       private Long id;

    public void setId(Long id) throws NamingException {
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
      user u=  bk.selectuserByID(id);
        this.id = id;
       
       //  System.out.println("Salut : " + u.getPrenom());
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
 private Button btnOrders;
 
 
   @FXML
void DeposerCour() throws IOException {
   Parent fxml = FXMLLoader.load(getClass().getResource (  "DeposerCours.fxml"));
pnlOverview.getChildren().removeAll();
pnlOverview.getChildren().setAll(fxml);


}
    @FXML
    private void ConsulterEtudiants() throws IOException {
        
        Parent fxml = FXMLLoader.load(getClass().getResource (  "/Views/ConsulterEtudiant.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
        

    }
    @FXML
    private void SaisirNotes()throws IOException {
        
        Parent fxml = FXMLLoader.load(getClass().getResource (  "/Views/EnregistrerNote.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
        
        
       
        // Charger la page Enseignant.fxml et afficher
    }
    @FXML
    private void ModifierNotes()throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource (  "/Views/ModifierNote.fxml"));
        pnlOverview.getChildren().removeAll();
        pnlOverview.getChildren().setAll(fxml);
           
  
    }
   
public void initialize(Long id) throws NamingException {

try {
    while(id==null){
        System.out.println("mazaaal");
    }
    System.out.println("id est "+id);
   // Long id = 2L;
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
        Parent fxml = loader.load();
AcceuilController acc = loader.getController();
acc.setId(id);
pnlOverview.getChildren().removeAll();
pnlOverview.getChildren ().setAll(fxml);
} catch (IOException ex) {
 }
    
}
}
