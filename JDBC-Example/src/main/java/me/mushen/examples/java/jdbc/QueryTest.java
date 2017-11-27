package me.mushen.examples.java.jdbc;

import java.sql.*;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-22
 */
public class QueryTest {
    private static String queryString =
            "select " +
            "   books.title, books.price, publishers.name " +
            "from " +
            "   publishers " +
            "       join " +
            "   books on books.publisher_id = publishers.publisher_id " +
            "where" +
            "   publishers.name = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = Connections.localMysql();
        PreparedStatement preState = connection.prepareStatement(queryString);
        preState.setObject(1, "Addison-Wesley");

        ResultSet rs = preState.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        System.out.println(metaData.getColumnLabel(1));
        System.out.println(metaData.getColumnLabel(2));
        System.out.println(metaData.getColumnLabel(3));
        while (rs.next()) {
            System.out.println(metaData.getColumnLabel(1) + ":" + rs.getObject(1));
            System.out.println(metaData.getColumnLabel(2) + ":" + rs.getObject(2));
            System.out.println(metaData.getColumnLabel(3) + ":" + rs.getObject(3));
            System.out.println();
        }
    }
}
