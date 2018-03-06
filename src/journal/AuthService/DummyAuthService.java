/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.AuthService;

import journal.AuthService.AuthService;

import java.sql.SQLException;

/**
 *
 * @author tc820073
 */
public class DummyAuthService implements AuthService {

    @Override
    public boolean login(String login, String password) throws SQLException {
        return login.equals("test")
                && password.equals("test");
    }

}
