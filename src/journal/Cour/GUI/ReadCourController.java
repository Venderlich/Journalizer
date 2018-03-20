package journal.Cour.GUI;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
        TableColumn ButonnCol = new TableColumn("");
        ButonnCol.setSortable(false);
        courListView.getColumns().addAll(dateCol,tempsCol,filiereCol,tdcCol,matiereCol,commentaireCol,ButonnCol);



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


        ButonnCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CourObservable, Boolean>, ObservableValue<Boolean>>() {
            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<CourObservable, Boolean> features) {
                return new SimpleBooleanProperty(features.getValue() != null);
            }
        });




        dateCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("date"));
        tempsCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("temps"));
        filiereCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("filiere"));
        tdcCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("typeDeCour"));
        matiereCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("matiere"));
        commentaireCol.setCellValueFactory(new PropertyValueFactory<CourObservable,String>("commentaire"));

        ButonnCol.setCellFactory(
                new Callback<TableColumn<CourObservable, Boolean>, TableCell<CourObservable, Boolean>>() {

                    @Override
                    public TableCell<CourObservable, Boolean> call(TableColumn<CourObservable, Boolean> p) {
                        return new ButtonCell();
                    }

                });

    }

    //Define the button cell
    private class ButtonCell extends TableCell<CourObservable, Boolean> {

        final Button cellButton = new Button("Delete");

        ButtonCell() {

            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    // do something when button clicked
                    //...
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }
}

