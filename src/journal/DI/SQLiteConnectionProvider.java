package journal.DI;

import DB.QueryExecuter;
import DB.SQLFileReader;
import DB.ScriptRunner;
import com.google.inject.Provider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionProvider implements Provider<Connection> {
    private final String filePath = "journal.sqlite";
    private final String tableScriptPath = "initdb.sql";
    private Connection connection;

    @Override
    public Connection get() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + filePath);

            if(databaseIsEmpty()) {
                createTables();
            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private boolean databaseIsEmpty() throws IOException {
//        int arbritraryNumberOfLine = 2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
        return reader.readLine() == null;
    }

    private void createTables() throws IOException, SQLException {
        QueryExecuter executer = new QueryExecuter(connection);
        ScriptRunner runner = new ScriptRunner(new SQLFileReader(), executer);

        runner.executeFile(tableScriptPath);
        executer.executeUpdate("INSERT INTO Utilisateur VALUES ('micolet', 'root');");

        System.out.println("La Base de Donnée initial a été instancié");
    }
}
