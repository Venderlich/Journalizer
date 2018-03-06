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
//    @FXML
//    private ComboBox<Matiere> comMatiere;

    CreateFiliere creator = new CreateFiliere();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFiliere(ActionEvent event){
        try {
            creator.ServiceCreateFiliere(txtFiliere.getText());
            lblInfo.setText("Vous avez inserez la filiére " + txtFiliere.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        ReadMatiere lector = new ReadMatiere();
//        ObservableList<Matiere> matiere = comMatiere.getItems();
//        int i = 0;
//        try{
//            while ( i < lector.listMatiere().size()){
//                matiere.add(lector.listMatiere().get(i));
//
//                i = i + 1;}
//        } catch (SQLException e){
//
//        }
//        comMatiere.setButtonCell(new SimpleListMatiere());
//        comMatiere.setCellFactory(listView -> new SimpleListMatiere());
//        comMatiere.getSelectionModel().selectFirst();
//
//
//    }
//
//    public void createFiliere(ActionEvent event){
//        try {
//            creator.ServiceCreateFiliere(txtFiliere.getText(),comMatiere.getSelectionModel().getSelectedItem().getID());
//            lblInfo.setText("Vous avez inserez la filiére " + txtFiliere.getText());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}