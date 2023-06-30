/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author zeekouu
 */
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterEtudiantController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField cneField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField villeField;
    @FXML
    private TextField dateField;
    
    
    
     
    public void initialize(URL location, ResourceBundle resources) {
        
        
        // Code d'initialisation du contrôleur (si nécessaire)
    }

    @FXML
    private void enregistrerEtudiant() {
       try {
                   String nom = nomField.getText();
        String prenom = prenomField.getText();
        String cne = cneField.getText();
        String password = passwordField.getText();
                String date = dateField.getText();
        String telephone = telephoneField.getText();
        String ville = villeField.getText();
        Long id = 9L;
            // Recherche du registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupération du service à partir du registre RMI
            DatabaseService databaseService = (DatabaseService) registry.lookup("DatabaseService");
           // user uo = new user(nom, prenom, cne, password, date,"etudiant");
           user uo = new user();
             uo.setNom(nom);
            uo.setPrenom(prenom);
            uo.setCne(cne);
            uo.setPassword(password);
            uo.setDateNaissance(date);
            uo.setRole("etudiant");
          
            // Appel de la méthode du service RMI pour consulter les étudiants
             databaseService.enregistrerUser(uo);
           
             System.out.println("Étudiant enregistré :");
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("CNE : " + cne);
        System.out.println("Mot de passe : " + password);
        System.out.println("Numéro de téléphone : " + telephone);
        System.out.println("Ville : " + ville);
              
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

