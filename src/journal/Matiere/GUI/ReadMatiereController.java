package journal.Matiere.GUI;

        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.ListView;
        import journal.Matiere.Service.ReadMatiere;

        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class ReadMatiereController implements Initializable {
    @FXML
    private ListView<String> matiereListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReadMatiere lector = new ReadMatiere();
        ObservableList<String> matiere = matiereListView.getItems();
        int i = 0;
        try{
            while ( i < lector.listMatiere().size()){
                matiere.add(lector.listMatiere().get(i).getLabel());
                i = i + 1;}
        } catch (SQLException e){

        }

    }
}
