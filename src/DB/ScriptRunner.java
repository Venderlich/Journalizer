package DB;

import java.io.IOException;
import java.sql.*;


public class ScriptRunner {
    private SQLFileReader reader;
    private QueryExecuter executer;

    public ScriptRunner(SQLFileReader sqlFileReader, QueryExecuter executer) {
        this.reader = sqlFileReader;
        this.executer = executer;
    }

    public void executeFile(String filePath) throws SQLException, IOException {
        String[] queries = reader
                .readFile(filePath)
                .getQueries();

        for(String query: queries) {
            executer.executeQuery(query);
        }
    }
}