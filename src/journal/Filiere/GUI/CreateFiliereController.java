package journal.Filiere.GUI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import journal.Filiere.Service.CreateFiliere;
import journal.Matiere.Service.Matiere;
import journal.Matiere.Service.ReadMatiere;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateFiliereController implements Initializable {

    @FXML
    private TextField txtFiliere;

    @FXML
    private Label lblInfo;

    CreateFiliere creator = new CreateFiliere();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFiliere(ActionEvent event){
        if(isFormReady()){
            try {
                creator.ServiceCreateFiliere(txtFiliere.getText());
                lblInfo.setText("Vous avez inserez la filiére " + txtFiliere.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            lblInfo.setText("Veuillez remplir le champ");
        }


    }

    public boolean isFormReady(){
        Boolean isCheck;
        String filiereChecked = txtFiliere.getText();
        if(filiereChecked.isEmpty()){
            isCheck =false;
        }else {
            isCheck =true;
        }
        return isCheck;
    }

}