package journal.Cour.GUI;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import journal.Cour.Service.ReadCour;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReadCourController implements Initializable {

    @FXML
    private ListView<String> courListView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadCour lector = new ReadCour();
        ObservableList<String> cour = courListView.getItems();
        int i = 0;
        try{
            while ( i < lector.listCour().size()){
                cour.add(lector.listCour().get(i).getCommentaire());
                cour.add(lector.listCour().get(i).getDateSeance());
                cour.add(lector.listCour().get(i).getTemps().toString());
                cour.add(lector.listCour().get(i).getMatiere().getLabel());
                cour.add(lector.listCour().get(i).getFiliere().getLabel());
                cour.add(lector.listCour().get(i).getTypeDeCour().getLabel());


                i = i + 1;}
        } catch (SQLException e){

        }
    }
}
