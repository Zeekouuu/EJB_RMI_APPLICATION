
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.jboss.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author zeekouu
 */
public class coco implements Initializable {
    @FXML
  private Pane pnlCustomer ;

@FXML
private StackPane contentArea;
@Override
public void initialize(URL location, ResourceBundle resources) {

try {
Parent fxml=FXMLLoader.load(getClass().getResource (  "DeposerCours.fxml"));
pnlCustomer.getChildren().removeAll();
pnlCustomer.getChildren ().setAll(fxml);
} catch (IOException ex) {
 }
}
public void home (javafx.event.ActionEvent actionEvent) throws IOException{
Parent fxml = FXMLLoader.load(getClass().getResource (  "DeposerCours.fxml"));
pnlCustomer.getChildren().removeAll();
pnlCustomer.getChildren().setAll(fxml);
 }
}







