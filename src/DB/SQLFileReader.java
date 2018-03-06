package DB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQLFileReader {
    private String file;

    public SQLFileReader readFile(String filePath) throws IOException {
        file = sanitize(new String(Files.readAllBytes(Paths.get(filePath))));
        return this;
    }

    public String[] getQueries() {
        return file.split(";");
    }

    private String sanitize(String file) {
        return file
                .replace("\n", "")
                .replace("\t", "");
    }
}
