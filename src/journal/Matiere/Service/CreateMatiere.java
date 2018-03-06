package journal.Matiere.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.*;


public class CreateMatiere {

    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void ServiceCreateMatiere(String matiere) throws SQLException {
        String query = "INSERT INTO Matiere VALUES (null,?);";
        Statement statement = conn.get().createStatement();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setString(1, matiere);
            preparedStatement.executeUpdate();

            System.out.println("Inserer");
            statement.close();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }
}