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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ConsulterEtudiantControlleu implements Initializable {
      @FXML
    private ListView<String> etudiantListView;
    @FXML
     private Button BTN;

   @FXML
   public void retour(){
       
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

