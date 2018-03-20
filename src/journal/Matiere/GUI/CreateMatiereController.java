package journal.Matiere.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import journal.Matiere.Service.CreateMatiere;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateMatiereController implements Initializable {

    @FXML
    private TextField txtMatiere;

    @FXML
    private Label lblInfo;


    CreateMatiere creator = new CreateMatiere();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createMatiere(ActionEvent event){
        if(isFormReady()){
            try {
                creator.ServiceCreateMatiere(txtMatiere.getText());
                lblInfo.setText("Vous avez inserez la matiere " + txtMatiere.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            lblInfo.setText("veuillez remplir le champs");
        }
    }

    public boolean isFormReady(){
        Boolean isCheck;
        String matiereChecked = txtMatiere.getText();
        if(matiereChecked.isEmpty()){
            isCheck =false;
        }else {
            isCheck =true;
        }
        return isCheck;
    }
}
