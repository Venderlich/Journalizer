/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.AuthService;

import java.sql.SQLException;

/**
 *
 * @author tc820073
 */
public interface AuthService {
    boolean login(String login, String password) throws SQLException;
}


