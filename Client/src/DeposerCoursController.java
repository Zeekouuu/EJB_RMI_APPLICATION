import GO.ZA.NewSessionBeanLocal;
import GO.ZA.cours;
import GO.ZA.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DeposerCoursController {
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
    private void retour() {
    try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Enseignan.fxml"));
        Parent root = loader.load();

       File cssFile = new File("C:\\Users\\zeekouu\\OneDrive\\Bureau\\AR\\Style.css");
URL cssUrl = cssFile.toURI().toURL();
        // Créer la scène
Scene scene = new Scene(root, 1050, 576);
scene.getStylesheets().add(cssUrl.toExternalForm());

// Obtenir la fenêtre actuelle
Stage currentStage = (Stage) moduleField.getScene().getWindow();

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
  
       private Long id;

    public void setId(Long id) throws NamingException {
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
      user u=  bk.selectuserByID(id);
        this.id = id;
         
         System.out.println("Salut : " + u.getPrenom());
    }
    @FXML
    private TextField moduleField;

    private FileChooser fileChooser;

    @FXML
    private void initialize() {
        // Initialiser le FileChooser
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Fichiers PDF", "*.pdf"));
    }
    
public void git(){
    moduleField.setText("salam");
}
    @FXML
    public void importerCours(ActionEvent event) throws NamingException {
        String module = moduleField.getText();

        // Ouvrir la boîte de dialogue de sélection de fichier
        File fichierCours = fileChooser.showOpenDialog(((Button) event.getSource()).getScene().getWindow());

        if (fichierCours != null) {
             NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
            user u=  bk.selectuserByID(id);
            System.out.println(fichierCours);
            
            cours c = new cours();
            c.setContenue(fichierCours.getPath());
            c.setEnseignant(u.getNom()+" "+u.getPrenom());
            c.setTitre(module);
            bk.enregistrerCours(c);
                    
            // Faire le traitement nécessaire avec le fichier de cours
            // Insérer les informations du cours (module et fichier) dans la table "cours" de la base de données

            // Afficher un message de succès ou effectuer une autre action appropriée
            System.out.println("Cours importé avec succès !");
        }
    }
}
