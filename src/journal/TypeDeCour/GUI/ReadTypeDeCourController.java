package journal.TypeDeCour.GUI;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import journal.TypeDeCour.Service.ReadTypeDeCour;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReadTypeDeCourController implements Initializable {
        @FXML
        private ListView<String> typeDeCourListView;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            ReadTypeDeCour lector = new ReadTypeDeCour();
            ObservableList<String> typeDeCour = typeDeCourListView.getItems();
            int i = 0;
            try{
                while ( i < lector.listTypeDeCour().size()){
                    typeDeCour.add(lector.listTypeDeCour().get(i).getLabel());
                    typeDeCour.add(lector.listTypeDeCour().get(i).getRapport().toString());
                    i = i + 1;}
            } catch (SQLException e){

            }

        }
    }
