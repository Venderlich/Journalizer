package journal.Cour.GUI;

import FXRouter.FXRouter;
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
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import journal.Cour.GUI.DataClass.CourObservable;

import journal.Cour.Service.DeleteCour;
import journal.Cour.Service.ReadCour;
import journal.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class ReadCourController implements Initializable {

    @FXML
    private TableView<CourObservable> courListView;

    @FXML
    private TableColumn<CourObservable, String> dateColumn;

    @FXML
    private TableColumn<CourObservable, String> tempColumn;

    @FXML
    private TableColumn<CourObservable, String> filiereColumn;

    @FXML
    private TableColumn<CourObservable, String> courColumn;

    @FXML
    private TableColumn<CourObservable, String> matiereColumn;

    @FXML
    private TableColumn<CourObservable, String> commentColumn;

    @FXML
    private TableColumn<CourObservable, String> deleteColumn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadCour lector = new ReadCour();


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




        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        tempColumn.setCellValueFactory(cellData -> cellData.getValue().tempsProperty());
        filiereColumn.setCellValueFactory(cellData -> cellData.getValue().filiereProperty());
        courColumn.setCellValueFactory(cellData -> cellData.getValue().typeDeCourProperty());
        matiereColumn.setCellValueFactory(cellData -> cellData.getValue().matiereProperty());
        commentColumn.setCellValueFactory(cellData -> cellData.getValue().commentaireProperty());
        deleteColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());

        deleteColumn.setCellFactory(_p -> new ButtonCell());
    }

    //Define the button cell
    private class ButtonCell extends TableCell<CourObservable, String> {

        final Button cellButton = new Button("Delete");
        DeleteCour deletor = new DeleteCour();
        ButtonCell() {

            cellButton.setOnAction((ActionEvent t) -> {
                try {
                    int i = getTableRow().getIndex();
                    deletor.ServiceDeleteCour(Integer.parseInt(deleteColumn.getCellObservableValue(i).getValue()));
                    try {
                        FXRouter.getInstance().goTo(Routes.READ_COUR);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(String t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

}
