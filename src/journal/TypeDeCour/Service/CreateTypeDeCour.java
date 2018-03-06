package journal.TypeDeCour.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTypeDeCour {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void CreateTypeDeCours(String labelTDC, Double rapport) throws SQLException {
        String query = "INSERT INTO TypeDeCour VALUES (null,?,?);";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setString(1, labelTDC);
            preparedStatement.setDouble(2, rapport);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }
}
