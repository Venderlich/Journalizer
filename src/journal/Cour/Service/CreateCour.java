package journal.Cour.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateCour {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void ServiceCreateCour(String comentaire, String dateSeance, Integer Temps, Integer filiere, Integer typeDeCour, Integer matiere) throws SQLException {
        String query = "INSERT INTO Seance VALUES (null,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setString(1, comentaire);
            preparedStatement.setString(2,dateSeance);
            preparedStatement.setInt(3,Temps);
            preparedStatement.setInt(4,filiere);
            preparedStatement.setInt(5,typeDeCour);
            preparedStatement.setInt(6,matiere);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }
}

