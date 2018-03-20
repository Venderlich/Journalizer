package journal.TypeDeCour.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import journal.Cour.Service.ReadCour;
import journal.TypeDeCour.Service.CreateTypeDeCour;

import javax.xml.soap.Text;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CreateTypeDeCourController implements Initializable{

    @FXML
    private TextField txtTDC;

    @FXML
    private TextField txtRapport;

    @FXML
    private Label lblInfo;

    CreateTypeDeCour creator = new CreateTypeDeCour();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtRapport.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    txtRapport.setText(oldValue);
                }
            }
        });
    }
    public void createTypeDeCour(ActionEvent event){
        try {
            if(!creator.isExistent(txtTDC.getText())){
                if(isFormReady()){
                    try {
                        creator.CreateTypeDeCours(txtTDC.getText(),Double.parseDouble(txtRapport.getText()));
                        lblInfo.setText("Vous avez inserez le Type de cour " + txtTDC.getText());

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    lblInfo.setText("Veuillez remplire tout les champs");
                }
            }else {
                lblInfo.setText("Ce champs existe deja");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Boolean isFormReady(){
        String checkedTDC = txtTDC.getText();
        String checkedRapport = txtRapport.getText();
        Boolean isReady;
        if(tdcChecked(checkedTDC) && rapportChecked(checkedRapport)){
            isReady = true;
        }else {
            isReady =false;
        }
        return isReady;
    }

    public Boolean tdcChecked(String checkedTDC){
        Boolean isChecked;
        if(checkedTDC.isEmpty()){
            isChecked =false;
        }else{
            isChecked =true;
        }
        return isChecked;
    }

    public  Boolean rapportChecked(String checkedRapport){
        Boolean isChecked;
        if(checkedRapport.isEmpty()){
            isChecked =false;
        }else{
            isChecked =true;
        }
        return isChecked;
    }
}
