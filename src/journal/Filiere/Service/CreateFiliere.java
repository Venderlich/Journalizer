package journal.Filiere.Service;

        import com.google.inject.Inject;
        import journal.DI.SQLiteConnectionProvider;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;


public class CreateFiliere {

    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void ServiceCreateFiliere(String filiere) throws SQLException {
        String query = "INSERT INTO Filiere VALUES (null,?);";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setString(1, filiere);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }
}
