package com.lf.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/jdbc?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT";
        String username = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "select * from users";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getObject("id"));
        }
        rs.close();
        statement.close();
        connection.close();
    }
}
