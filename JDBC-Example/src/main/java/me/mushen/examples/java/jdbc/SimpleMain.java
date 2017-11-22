package me.mushen.examples.java.jdbc;

import java.sql.*;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-21
 */
public class SimpleMain {

    public static void main(String[] args){
        // 1. 注册驱动器类
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");

        // 2. 连接到数据库
        String url = "jdbc:mysql://localhost:3306/rs_ms_db?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String passport = "123456";
        try {
            Connection connection = DriverManager.getConnection(url, username, passport);
            // 3. 创建Statement
            Statement statement = connection.createStatement();

            // 4. 查询
            String sql1 = "select * from Authors";
            String sql2 = "select title, price as BookPrice from Books";
            String sql = "select * from Authors;select title, price from Books";
            ResultSet rs1 = statement.executeQuery(sql1);
            ResultSetMetaData metaData1 = rs1.getMetaData();
            while (rs1.next()) {
                for(int columnIndex = 1; columnIndex <= metaData1.getColumnCount(); columnIndex++) {
                    System.out.println(metaData1.getCatalogName(columnIndex));
                    System.out.println(metaData1.getColumnClassName(columnIndex));
                    System.out.println(metaData1.getColumnDisplaySize(columnIndex));
                    System.out.println(metaData1.getColumnLabel(columnIndex));
                    System.out.println(metaData1.getColumnName(columnIndex));
                    System.out.println(metaData1.getColumnType(columnIndex));
                    System.out.println(metaData1.getColumnTypeName(columnIndex));
                    System.out.println(metaData1.getPrecision(columnIndex));
                    System.out.println(metaData1.getScale(columnIndex));
                    System.out.println(metaData1.getSchemaName(columnIndex));
                    System.out.println(metaData1.getTableName(columnIndex));
                    System.out.println(metaData1.getColumnCount());
                }
            }

            ResultSet rs2 = statement.executeQuery(sql2);
            ResultSetMetaData metaData2 = rs2.getMetaData();
            while (rs2.next()) {
                for(int columnIndex = 1; columnIndex <= metaData2.getColumnCount(); columnIndex++) {
                    System.out.println(metaData2.getCatalogName(columnIndex));
                    System.out.println(metaData2.getColumnClassName(columnIndex));
                    System.out.println(metaData2.getColumnDisplaySize(columnIndex));
                    System.out.println("Label: " + metaData2.getColumnLabel(columnIndex));
                    System.out.println("Name: " + metaData2.getColumnName(columnIndex));
                    System.out.println(metaData2.getColumnType(columnIndex));
                    System.out.println(metaData2.getColumnTypeName(columnIndex));
                    System.out.println(metaData2.getPrecision(columnIndex));
                    System.out.println(metaData2.getScale(columnIndex));
                    System.out.println(metaData2.getSchemaName(columnIndex));
                    System.out.println(metaData2.getTableName(columnIndex));
                    System.out.println(metaData2.getColumnCount());

                    System.out.println(rs2.getObject("bookprice"));
                    System.out.println(rs2.getObject("BookPrice"));
                    System.out.println(rs2.getObject("BookpRice"));
                    System.out.println(rs2.getObject("bookPRICE"));
                    System.out.println(rs2.getObject("bookPRICE").getClass());
                    System.out.println(rs2.getObject("BookpRice").getClass());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
