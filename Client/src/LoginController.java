

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import GO.ZA.NewSessionBean;
import GO.ZA.NewSessionBeanLocal;
import GO.ZA.user;
import GO.ZA.perso;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LoginController {
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
     private Button BTN;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginButtonClicked(ActionEvent event) throws NamingException {
        
        String username = usernameField.getText();
        String password = passwordField.getText();
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
       user u= bk.findUtilisateurByUsernameAndPassword(username, password);
       System.out.println(u.getRole());

        // Vérifier le rôle dans la base de données
       // String role = verifyUserRole(username, password);

        if (u.getRole().equals("etudiant")) {
            System.out.println("je suis etudiant");
            EtudiantPage(u.getId());
        } else if (u.getRole().equals("enseignant")) {
             System.out.println("je suis enseignant");
           EnseignantPage(u.getId());
        }  else if (u.getRole().equals("cordinateur")) {
             System.out.println("je suis cordinateur");
           CordinateurPage(u.getId());
        }
        else  {
            // Afficher un message d'erreur pour un rôle invalide
            InvalidPage();
        }
    }

  

  private void EtudiantPage(Long id) throws NamingException {
   try {
         
         
         // Créer un objet File pour représenter votre fichier CSS

// Convertir l'objet File en une URL

// Appliquer la feuille de style CSS à la scène

         
         
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Etudian.fxml"));
     // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Fillier.fxml"));
        Parent root = loader.load();
//FillierController filierController =  loader.getController();
        // Obtenir le contrôleur EtudiantController
        EtudiantController enseignantController = loader.getController();
        
        // Injecter l'ID dans le contrôleur EtudiantController
        enseignantController.setId(id);
                enseignantController.initialize(id);

        
        

File cssFile = new File("C:\\Users\\zeekouu\\OneDrive\\Bureau\\AR\\Style.css");
URL cssUrl = cssFile.toURI().toURL();
        // Créer la scène
Scene scene = new Scene(root, 1050, 576);
scene.getStylesheets().add(cssUrl.toExternalForm());

// Obtenir la fenêtre actuelle
Stage currentStage = (Stage) usernameField.getScene().getWindow();

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


     private void EnseignantPage(Long id) throws NamingException {
     try {
         
         
         // Créer un objet File pour représenter votre fichier CSS

// Convertir l'objet File en une URL

// Appliquer la feuille de style CSS à la scène

         
         
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Enseignan.fxml"));
     // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Fillier.fxml"));
        Parent root = loader.load();
//FillierController filierController =  loader.getController();
        // Obtenir le contrôleur EtudiantController
        EnseignantController enseignantController = loader.getController();
        
        // Injecter l'ID dans le contrôleur EtudiantController
        enseignantController.setId(id);
                enseignantController.initialize(id);

        
        

File cssFile = new File("C:\\Users\\zeekouu\\OneDrive\\Bureau\\AR\\Style.css");
URL cssUrl = cssFile.toURI().toURL();
        // Créer la scène
Scene scene = new Scene(root, 1050, 576);
scene.getStylesheets().add(cssUrl.toExternalForm());

// Obtenir la fenêtre actuelle
Stage currentStage = (Stage) usernameField.getScene().getWindow();

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
       private void CordinateurPage(Long id) throws NamingException {
   try {
         
         
         // Créer un objet File pour représenter votre fichier CSS

// Convertir l'objet File en une URL

// Appliquer la feuille de style CSS à la scène

         
         
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Cordinateu.fxml"));
     // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Fillier.fxml"));
        Parent root = loader.load();
//FillierController filierController =  loader.getController();
        // Obtenir le contrôleur EtudiantController
        ConrdinateurController enseignantController = loader.getController();
        
        // Injecter l'ID dans le contrôleur EtudiantController
        enseignantController.setId(id);
                enseignantController.initialize(id);

        
        

File cssFile = new File("C:\\Users\\zeekouu\\OneDrive\\Bureau\\AR\\Style.css");
URL cssUrl = cssFile.toURI().toURL();
        // Créer la scène
Scene scene = new Scene(root, 1050, 576);
scene.getStylesheets().add(cssUrl.toExternalForm());

// Obtenir la fenêtre actuelle
Stage currentStage = (Stage) usernameField.getScene().getWindow();

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
           private void login() {
    try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        // Créer la scène
        Scene scene = new Scene(root, 400, 300);

        // Obtenir une référence au contrôleur de la page Etudiant
        LoginController etudiantController = loader.getController();

        // Configurer toute donnée ou interaction supplémentaire avec le contrôleur ici

        // Obtenir la fenêtre actuelle
        Stage currentStage = (Stage) BTN.getScene().getWindow();

        // Afficher la scène dans la fenêtre actuelle
        currentStage.setScene(scene);
        currentStage.show();
      
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les exceptions lors du chargement de la page Etudiant.fxml
    }
}
         private void InvalidPage() {
     Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Erreur");
        alert.setContentText("LES INFORMATIONS INCORRECT.");
        alert.showAndWait();
    }  

@FXML
    private void AjouterEtudiant() {
        // Charger la page Enseignant.fxml et afficher
    }
    
    @FXML
    private void ConsulterEtudiant() {
        // Charger la page Enseignant.fxml et afficher
    }
    
    @FXML
    private void ReleverDeNotes() {
        // Charger la page Enseignant.fxml et afficher
    }
    
 

   


    // Ajoutez d'autres méthodes nécessaires pour les actions des boutons ou d'autres fonctionnalités

}
