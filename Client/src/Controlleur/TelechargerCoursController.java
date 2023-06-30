/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

/**
 *
 * @author zeekouu
 */
import static Controlleur.EnregistrerNoteController.getProxy;
import GO.ZA.NewSessionBeanLocal;
import GO.ZA.note;
import GO.ZA.user;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TelechargerCoursController {
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
    private ComboBox<String> etudiantComboBox;

    @FXML
    private TextField noteTextField;
    
      private String selectedModule;
    private String selectesEtudiant;
    private Long id ;
    public void initialize() throws NamingException {
        //---------------partie etudiant----------------
          NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
          List<String> kok = new ArrayList<>();
             List<user> etudiants = bk.consulterEnseignant();
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
    
    void afficher() throws NamingException, MalformedURLException, IOException {
    // Action à effectuer lorsque le bouton "Modifier" est pressé
    String module = moduleComboBox.getValue();
    String etudiant = etudiantComboBox.getValue();
    NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
    String filePath = bk.TelechargerCours(selectedModule, selectesEtudiant);
    noteTextField.setText(filePath);
    
    Path source = Paths.get(filePath);
    Path destination = Paths.get("C:\\Users\\zeekouu\\OneDrive\\Documents\\FichierTelecharger"); // Remplacez par le chemin de destination souhaité
    
    if (!Files.exists(destination)) {
        Files.createDirectories(destination);
    }
    
    Path destinationFile = destination.resolve(source.getFileName());
    
    // Copier le fichier de source vers la destination en utilisant Files.copy()
    Files.copy(source, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    
    System.out.println("Téléchargement terminé !");
}

    
    
    
    

  
   /*  @FXML
    private void afficher() throws NamingException, MalformedURLException, IOException {
        // Action à effectuer lorsque le bouton "Modifier" est pressé
        String module = moduleComboBox.getValue();
        String etudiant = etudiantComboBox.getValue();
        NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
        String url = bk.TelechargerCours(selectedModule, selectesEtudiant);
        noteTextField.setText(url);
         URL fileUrl = new URL(url);
            
            // Ouverture de la connexion
            InputStream inputStream = fileUrl.openStream();
            
            // Création d'un chemin de destination pour enregistrer le fichier
            Path destination = Path.of("C:\\Users\\zeekouu\\OneDrive\\Documents\\FichierTelecharger"); // Remplacez par le chemin de destination souhaité
            System.out.println("salam");
           //  Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
             if (!Files.exists(destination)) {
                 System.out.println("salaam 222222222");
                Files.createDirectories(destination);
            }
            
            // Nom du fichier
            String fileName = fileUrl.getFile().substring(fileUrl.getFile().lastIndexOf('/') + 1);
            
            // Chemin complet du fichier de destination
            Path destinationf = destination.resolve(fileName);
            
            // Méthode 1 : Copier le contenu de l'URL vers un fichier en utilisant Files.copy()
            Files.copy(inputStream, destinationf, StandardCopyOption.REPLACE_EXISTING);
            
            
            
            System.out.println("Téléchargement terminé !");

        // Effectuer les opérations nécessaires pour modifier la note
        // et mettre à jour le champ de texte noteTextField
    }*/

    @FXML
    private void retournerButtonAction() {
           try {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Etudiant.fxml"));
        Parent root = loader.load();

        // Créer la scène
        Scene scene = new Scene(root, 400, 300);

        // Obtenir une référence au contrôleur de la page Etudiant
      //  EnseignantController etudiantController = loader.getController();

        // Configurer toute donnée ou interaction supplémentaire avec le contrôleur ici

        // Obtenir la fenêtre actuelle
        Stage currentStage = (Stage) noteTextField.getScene().getWindow();

        // Afficher la scène dans la fenêtre actuelle
        currentStage.setScene(scene);
        currentStage.show();
      
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les exceptions lors du chargement de la page Etudiant.fxml
    }
        // Action à effectuer lorsque le bouton "Retourner" est pressé
        // Peut-être une transition vers une autre vue ou une opération de nettoyage, etc.
    }
}

