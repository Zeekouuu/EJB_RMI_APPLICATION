package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class slider {

    @FXML
    private Label drawerImage;

    @FXML
    private ImageView exit;

    // Ajoutez ici les méthodes et les fonctionnalités de votre contrôleur

    // Exemple de méthode avec un événement déclenché par un bouton
    @FXML
    private void handleButtonAction() {
        // Code à exécuter lorsque le bouton est cliqué
        System.out.println("Bouton cliqué !");
    }

    // Exemple de méthode d'initialisation du contrôleur
    @FXML
    private void initialize() {
        // Code d'initialisation du contrôleur
        System.out.println("Contrôleur initialisé !");
    }
}
