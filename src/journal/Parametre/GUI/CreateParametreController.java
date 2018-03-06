package journal.Parametre.GUI;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import journal.Parametre.Service.CreateParametre;


import java.sql.SQLException;
import java.util.function.UnaryOperator;

public class CreateParametreController {


    @FXML
    private Spinner<Integer> spnObjectif;

    @FXML
    private TextField txtHorraire = new TextField();

    @FXML
    private Label lblInfoObjectif;

    @FXML
    private Label lblInfoHorraire;

    CreateParametre creator = new CreateParametre();


    public void createVolumeHorraire(ActionEvent event) throws SQLException {
//        if (creator.CheckVolumeHorraire()){
//            lblInfoHorraire.setText("La variable a deja été initialiser");
//        }else{
            try {
                creator.ServiceVolumeHorraire(Integer.parseInt(txtHorraire.getText()));
                lblInfoHorraire.setText("Vous Avez inserer le volume horraire" + txtHorraire.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
//        }
    }

    public void createVarObjectif(ActionEvent event) throws SQLException {
        if(creator.CheckVariableObjectif()){
            lblInfoObjectif.setText("La variable a deja été initialiser");
        }else{
            try {
                creator.ServiceVariableObjectif(spnObjectif.getValue());
                lblInfoObjectif.setText("Vous avez inserez la variable d'objectif " + spnObjectif.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
