package journal.Cour.GUI.CustomComboBox;

import javafx.scene.control.ListCell;
import journal.Filiere.Service.Filiere;


public class SimpleListFiliere extends ListCell<Filiere> {
    @Override
    protected void updateItem(Filiere item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (!empty && item != null) {
            final String text = String.format("%s", item.getLabel());
            setText(text);
        }
    }
}
