package journal.Parametre.GUI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import journal.Parametre.Service.CreateParametre;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class CreateParametreController implements Initializable {


    @FXML
    private TextField txtObjectif;

    @FXML
    private TextField txtHorraire;

    @FXML
    private Label lblInfoObjectif;

    @FXML
    private Label lblInfoHorraire;


    CreateParametre creator = new CreateParametre();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtHorraire.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtHorraire.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        txtObjectif.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtObjectif.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void createVolumeHorraire(ActionEvent event) throws SQLException {
        if (creator.CheckVolumeHorraire()){
          lblInfoHorraire.setText("La variable a deja été initialiser");
        }else{
        try {

            creator.ServiceVolumeHorraire(Integer.parseInt(txtHorraire.getText()));
            lblInfoHorraire.setText("Vous Avez inserer le volume horraire" + txtHorraire.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }

    public void createVarObjectif(ActionEvent event) throws SQLException {
        if (creator.CheckVariableObjectif()) {
            lblInfoObjectif.setText("La variable a deja été initialiser");
        } else {
            try {
                creator.ServiceVariableObjectif(Integer.parseInt(txtObjectif.getText()));
                lblInfoObjectif.setText("Vous avez inserez la variable d'objectif " + txtObjectif.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
