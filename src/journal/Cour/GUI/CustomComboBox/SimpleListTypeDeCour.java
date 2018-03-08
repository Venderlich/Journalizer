package journal.Cour.GUI.CustomComboBox;

import javafx.scene.control.ListCell;
import journal.TypeDeCour.Service.TypeDeCour;

public class SimpleListTypeDeCour extends ListCell<TypeDeCour> {
    @Override
    protected void updateItem(TypeDeCour item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (!empty && item != null) {
            final String text = String.format("%s", item.getLabel());
            setText(text);
        }
    }
}
