package com.example.test;

import com.example.system.domain.Config;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hejing
 * @date 2024/8/21:下午5:21
 */
public class Test {
    public static void main(String[] args) {
        getConnection();
        test();


    }

    private static void getConnection() {
        //999999
        // 数据库连接URL


        try {
            // 加载JDBC驱动程序（对于较新版本的JDBC和MySQL驱动，这一步可能不是必需的，但为了兼容性建议保留）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库连接
            Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password);
            if (connection != null) {
                System.out.println("getConnection 成功连接到数据库");
                // 在这里可以进行后续的数据库操作，例如执行SQL语句等
                connection.close(); // 使用完连接后记得关闭
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        try {
            BasicDataSource ds = new BasicDataSource();

            ds.setUrl(Config.url);

            ds.setUsername(Config.username);

            ds.setPassword(Config.password);

            ds.setInitialSize(10);

            ds.setMaxTotal(1000);

            ds.setMaxIdle(1000);

            ds.setMinIdle(100);

            ds.setMaxWaitMillis(1000);

            ds.setRemoveAbandonedOnMaintenance(true);

            ds.setRemoveAbandonedOnBorrow(true);

            ds.setRemoveAbandonedTimeout(300);

            ds.setMaxOpenPreparedStatements(1000);

            for (int i = 0; i < 50; i++) {
                try {
                    Connection connection = ds.getConnection();
                    if (connection != null) {
                        System.out.println(" test 成功连接到数据库"+i);
                        // 在这里可以进行后续的数据库操作，例如执行SQL语句等
                        connection.close(); // 使用完连接后记得关闭
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println(i+"失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


