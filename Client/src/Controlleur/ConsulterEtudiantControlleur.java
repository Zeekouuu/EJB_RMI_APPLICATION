/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;
import GO.ZA.NewSessionBeanLocal;
import GO.ZA.user;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConsulterEtudiantControlleur implements Initializable {
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
    private ListView<String> etudiantListView;
    @FXML
     private Button BTN;
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

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {
             NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
             List<String> kok = new ArrayList<>();
             List<user> etudiants = bk.consulterUtediant();
             for(user u : etudiants){
                 String test = "";
                 
                 test += " Nom :\n "+u.getNom()+"\n prenom :\n"+u.getPrenom();
                 kok.add(test);
             }
              
             // Initialisez votreEJB avec votre instance d'EJB
        etudiantListView.getItems().addAll(kok);
         } catch (NamingException ex) {
             Logger.getLogger(ConsulterEtudiantControlleur.class.getName()).log(Level.SEVERE, null, ex);
         }

        // Appelez la méthode consulterEtudiant pour obtenir la liste d'étudiants
        

        // Ajoutez les étudiants à la ListView
    }
}

