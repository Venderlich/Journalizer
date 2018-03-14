package journal.Cour.GUI;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import journal.Cour.GUI.DataClass.CourObservable;

import journal.Cour.Service.ReadCour;

import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class ReadCourController implements Initializable {

    @FXML
    private TableView<CourObservable> courListView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadCour lector = new ReadCour();

        TableColumn dateCol = new TableColumn("DATE");
        TableColumn tempsCol = new TableColumn("TEMPS");
        TableColumn filiereCol = new TableColumn("FILIERE");
        TableColumn tdcCol = new TableColumn("COUR");
        TableColumn matiereCol = new TableColumn("MATIERE");
        TableColumn commentaireCol = new TableColumn("COMMENTAIRE");
        courListView.getColumns().addAll(dateCol,tempsCol,filiereCol,tdcCol,matiereCol,commentaireCol);



        ObservableList<CourObservable> cour = observableArrayList();{
            int i = 0;
            try{
                while ( i < lector.listCour().size()){
                   cour.add(new CourObservable(lector.listCour().get(i).getId().toString(),
                            lector.listCour().get(i).getDateSeance(),
                            lector.listCour().get(i).getTemps().toString(),
                            lector.listCour().get(i).getFiliere().getLabel(),
                            lector.listCour().get(i).getTypeDeCour().getLabel(),
                            lector.listCour().get(i).getMatiere().getLabel(),
                            lector.listCour().get(i).getCommentaire()
                            ));
                    i = i + 1;}
            } catch (SQLException e){

            }
        }
        courListView.setItems(cour);


        dateCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("date"));
        tempsCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("temps"));
        filiereCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("filiere"));
        tdcCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("typeDeCour"));
        matiereCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("matiere"));
        commentaireCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("commentaire"));



    }
}
