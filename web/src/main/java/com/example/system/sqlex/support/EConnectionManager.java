package com.example.system.sqlex.support;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hejing
 * @date 2025/2/7:上午9:50
 */
public class EConnectionManager {
    public Connection getConnection(ConnectionProvider provider) throws SQLException {
        return provider.getConnection();
    }

}
