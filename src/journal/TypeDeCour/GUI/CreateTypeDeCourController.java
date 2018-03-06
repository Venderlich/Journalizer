package journal.TypeDeCour.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import journal.TypeDeCour.Service.CreateTypeDeCour;
import java.sql.SQLException;


public class CreateTypeDeCourController {

    @FXML
    private TextField txtTDC;

    @FXML
    private Spinner<Double> spnRapport;

    @FXML
    private Label lblInfo;

    CreateTypeDeCour creator = new CreateTypeDeCour();


    public void createTypeDeCour(ActionEvent event){
        try {
            creator.CreateTypeDeCours(txtTDC.getText(),spnRapport.getValue());
            lblInfo.setText("Vous avez inserez la filiére " + txtTDC.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
