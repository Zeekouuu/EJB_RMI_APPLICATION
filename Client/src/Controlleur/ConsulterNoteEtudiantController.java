/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;
import GO.ZA.NewSessionBeanLocal;
import GO.ZA.note;
import GO.ZA.user;
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
import javafx.stage.Stage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConsulterNoteEtudiantController implements Initializable {
     public static NewSessionBeanLocal getProxy() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        props.put("wildfly.naming.client.ejb.context", true);
        InitialContext ctx = new InitialContext(props);
        NewSessionBeanLocal NW = (NewSessionBeanLocal) ctx.lookup("ejb:/YESTA/NewSessionBean!GO.ZA.NewSessionBeanLocal");
        return NW;
    }
      private Long id;

    public void setId(Long id) {
        this.id = id;
        
    }
    
    public Long sous(){
        return id;
    }
    
     
    @FXML
    private ListView<String> etudiantListView;
    @FXML
     private Button BTN;
    @FXML
    private void retour() {
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
        Stage currentStage = (Stage) BTN.getScene().getWindow();

        // Afficher la scène dans la fenêtre actuelle
        currentStage.setScene(scene);
        currentStage.show();
      
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer les exceptions lors du chargement de la page Etudiant.fxml
    }
}

    


    public void initialize(URL location, ResourceBundle resources) {
         try {
            // Long k = sous();
            Long k = 4L;
           

             System.out.println("dexiem id est :"+k);
             NewSessionBeanLocal bk = (NewSessionBeanLocal) getProxy();
             user etudiant = bk.selectuserByID(k);
             System.out.println(etudiant.getPrenom());
             List<String> kok = new ArrayList<>();
             List<note> notes = bk.consulterNotes(etudiant);
             for(note n : notes){
                 String test = "";
                 
                 test += " Module :\n "+n.getModule()+"\n valeur :\n"+n.getValeur();
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

