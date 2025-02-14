package com.example.system.sqlex.support;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hejing
 * @date 2025/2/7:上午9:51
 */
@FunctionalInterface
public interface ConnectionProvider {
    Connection getConnection() throws SQLException;
}
