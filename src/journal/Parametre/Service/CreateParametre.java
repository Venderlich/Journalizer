package journal.Parametre.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateParametre {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public void ServiceVolumeHorraire(Integer VolumeHorraire) throws SQLException {
        String query = "INSERT INTO ParametrageHorraire VALUES (?);";
        Statement statement = conn.get().createStatement();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setDouble(1, VolumeHorraire);
            preparedStatement.executeUpdate();

            System.out.println("Inserer");
            statement.close();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }

    public void ServiceVariableObjectif(Integer VariableObjectif) throws SQLException {
        String query = "INSERT INTO ParametrageObjectif VALUES (?);";
        Statement statement = conn.get().createStatement();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setDouble(1, VariableObjectif);
            preparedStatement.executeUpdate();

            System.out.println("Inserer");
            statement.close();
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            preparedStatement.close();
        }
    }

    public boolean CheckVolumeHorraire() throws SQLException {
        String query = "select * from ParametrageHorraire;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
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

    public boolean CheckVariableObjectif() throws SQLException {
        String query = "select * from ParametrageObjectif;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
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
