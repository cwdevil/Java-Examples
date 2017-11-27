package me.mushen.examples.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-22
 */
public class Connections {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection localMysql() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/rs_ms_db?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String passport = "123456";

        return DriverManager.getConnection(url, username, passport);
    }
}
