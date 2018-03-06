package journal.Filiere.GUI;

import javafx.scene.control.ListCell;
import journal.Matiere.Service.Matiere;

public class SimpleListMatiere extends ListCell<Matiere> {
    @Override
    protected void updateItem(Matiere item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (!empty && item != null) {
            final String text = String.format("%s", item.getLabel());
            setText(text);
        }
    }

}