package journal.Cour.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCour {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void ServiceDeleteCour(Integer id) throws SQLException {
        String query = "DELETE FROM Seance WHERE id= ?;";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }
}
