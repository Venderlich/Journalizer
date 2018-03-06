/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.AuthService;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tc820073
 */
public class SqliteAuthService implements AuthService {
    private Connection connection;

    @Inject
    SqliteAuthService(Connection connection) {
        this.connection = connection;
    }
            
    @Override
    public boolean login(String login, String password) throws SQLException {
        String query = "select * from Utilisateur where login = ? and mdp = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

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
