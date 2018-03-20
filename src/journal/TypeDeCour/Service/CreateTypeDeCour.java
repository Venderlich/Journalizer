package journal.TypeDeCour.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Boolean isExistent(String labelTDC) throws SQLException{
        String query = "SELECT * FROM TypeDeCour WHERE LabelTDC = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setString(1, labelTDC);

            resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            return false;
        } finally {
            assert preparedStatement != null;
            assert resultSet != null;
            preparedStatement.close();
            resultSet.close();
        }
    }
}

