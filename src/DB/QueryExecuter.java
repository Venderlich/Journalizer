package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecuter {
    private Connection db;

    public QueryExecuter(Connection connection) {
        this.db = connection;
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = db.createStatement();
        int result = statement.executeUpdate(query);
        System.out.println(result);
        statement.close();
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = db.createStatement();
        boolean result = statement.execute(query);
        System.out.println(result);
        statement.close();
    }
}
