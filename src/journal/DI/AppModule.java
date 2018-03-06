/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.DI;

import com.google.inject.AbstractModule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import journal.AuthService.AuthService;
import journal.AuthService.SqliteAuthService;

/**
 *
 * @author tc820073
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure()  {
        bind(FXMLLoader.class).toProvider(FXMLLoaderProvider.class);
        bind(AuthService.class).to(SqliteAuthService.class);
        bind(Connection.class).toProvider(SQLiteConnectionProvider.class);
    }
}
