package journal.Filiere.GUI;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import journal.Filiere.Service.ReadFiliere;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReadFiliereController implements Initializable {
    @FXML
    private ListView<String> filiereListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadFiliere lector = new ReadFiliere();
        ObservableList<String> filiere = filiereListView.getItems();
        int i = 0;
        try{
            while ( i < lector.listFiliere().size()){
                filiere.add(lector.listFiliere().get(i).getLabel());
                i = i + 1;}
        } catch (SQLException e){

        }

    }
}
