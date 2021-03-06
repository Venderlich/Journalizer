package journal.Cour.GUI;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import journal.Cour.GUI.CustomComboBox.SimpleListFiliere;
import journal.Cour.GUI.CustomComboBox.SimpleListMatiere;
import journal.Cour.GUI.CustomComboBox.SimpleListTypeDeCour;
import journal.Cour.Service.CreateCour;
import journal.Filiere.Service.Filiere;
import journal.Filiere.Service.ReadFiliere;
import journal.Matiere.Service.Matiere;
import journal.Matiere.Service.ReadMatiere;
import journal.TypeDeCour.Service.ReadTypeDeCour;
import journal.TypeDeCour.Service.TypeDeCour;
import sun.font.TrueTypeFont;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class CreateCourController implements Initializable {


    @FXML
    private TextField txtHorraire;

    @FXML
    private TextArea txtComment;

    @FXML
    private Label lblTitle;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Matiere> comboMatiere;

    @FXML
    private ComboBox<TypeDeCour> comboTdc;

    @FXML
    private ComboBox<Filiere> comboFiliere;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadMatiere lector = new ReadMatiere();
        ObservableList<Matiere> matiere = comboMatiere.getItems();
        int imat = 0;
        try{
            while ( imat < lector.listMatiere().size()){
                matiere.add(lector.listMatiere().get(imat));

                imat = imat + 1;}
        } catch (SQLException e){

        }
        comboMatiere.setButtonCell(new SimpleListMatiere());
        comboMatiere.setCellFactory(listView -> new SimpleListMatiere());
        comboMatiere.getSelectionModel().selectFirst();

        ReadFiliere lectorFiliere = new ReadFiliere();
        ObservableList<Filiere> filiere = comboFiliere.getItems();
        int ifi = 0;
        try{
            while ( ifi < lectorFiliere.listFiliere().size()){
                filiere.add(lectorFiliere.listFiliere().get(ifi));

                ifi = ifi + 1;}
        } catch (SQLException e){

        }
        comboFiliere.setButtonCell(new SimpleListFiliere());
        comboFiliere.setCellFactory(listView -> new SimpleListFiliere());
        comboFiliere.getSelectionModel().selectFirst();

        ReadTypeDeCour lectorTdc = new ReadTypeDeCour();
        ObservableList<TypeDeCour> tdc = comboTdc.getItems();
        int itdc = 0;
        try{
            while ( itdc < lectorTdc.listTypeDeCour().size()){
                tdc.add(lectorTdc.listTypeDeCour().get(itdc));

                itdc = itdc + 1;}
        } catch (SQLException e){

        }
        comboTdc.setButtonCell(new SimpleListTypeDeCour());
        comboTdc.setCellFactory(listView -> new SimpleListTypeDeCour());
        comboTdc.getSelectionModel().selectFirst();

        txtHorraire.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtHorraire.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
        CreateCour creator = new CreateCour();
        public void createCour(ActionEvent event){
            if(isFormIsValid()){
                try {
                    creator.ServiceCreateCour(txtComment.getText(),datePicker.getEditor().getText(),Integer.parseInt(txtHorraire.getText()),comboFiliere.getSelectionModel().getSelectedItem().getID(),comboTdc.getSelectionModel().getSelectedItem().getID(),comboMatiere.getSelectionModel().getSelectedItem().getID());
                    lblTitle.setText("vous avez inserer la seance de " + comboTdc.getSelectionModel().getSelectedItem().getLabel() + " de " + comboMatiere.getSelectionModel().getSelectedItem().getLabel() + " du " + datePicker.getEditor().getText() + "dispenser a la classe de " + comboFiliere.getSelectionModel().getSelectedItem().getLabel() );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                lblTitle.setText("vous n'avez pas rempli tout les champs");
            }

        }

        public boolean isFormIsValid(){
            String dateChecked= datePicker.getEditor().getText();
            String commentChecked= txtComment.getText();
            String horraireChecked= txtHorraire.getText();
            Boolean isReady = false;
            if(dateChecker(dateChecked) && commentChecked(commentChecked) && horraireChecked(horraireChecked)){
                isReady = true;
            }else{
                isReady = false;
            }
            return isReady;
        }


        public Boolean dateChecker(String dateChecked){
            String checkedDate = dateChecked;
            Boolean isCheck = false;
            if(checkedDate.isEmpty()){
               isCheck=false;
            }else {
                isCheck =true;
            }
            return isCheck;
        }

        public boolean horraireChecked(String horraireChecked){
            String checkedHorraire = horraireChecked;
            boolean isCheck = false;
            if(horraireChecked.isEmpty()){
                isCheck =false;
            }else{
                isCheck = true;
            }
            return isCheck;
        }

        public boolean commentChecked(String commentChecked){
        String checkedComment = commentChecked;
        boolean isCheck = false;
        if(commentChecked.isEmpty()){
            isCheck =false;
        }else{
            isCheck = true;
        }
        return isCheck;
    }
}

