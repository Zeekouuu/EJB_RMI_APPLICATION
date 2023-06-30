import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FillierController {
    @FXML
    private ChoiceBox<String> filiereChoiceBox;
    @FXML
    private ChoiceBox<String> semestreChoiceBox;

    public void initialize() {
        ObservableList<String> filiereOptions = FXCollections.observableArrayList("SMI", "SMPC", "SMA", "SVT", "M2I");
        filiereChoiceBox.setItems(filiereOptions);

        // Add semestre options based on filiere selection
        filiereChoiceBox.setOnAction(event -> {
            String selectedFiliere = filiereChoiceBox.getValue();
            ObservableList<String> semestreOptions;
            if ("M2I".equals(selectedFiliere)) {
                semestreOptions = FXCollections.observableArrayList("S1", "S2", "S3", "S4");
            } else {
                semestreOptions = FXCollections.observableArrayList("S1", "S2", "S3", "S4", "S5", "S6");
            }
            semestreChoiceBox.setItems(semestreOptions);
        });
    }

    @FXML
    private void handleAccederButtonClick() {
        // Handle the button click event
    }
}
