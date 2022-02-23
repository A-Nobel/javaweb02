package com.lf.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.ConnectionCustomizer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    public void test4() throws PropertyVetoException, SQLException {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test
    public void test3() throws PropertyVetoException, SQLException {

        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setDriverClass(driver);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test2() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc");
        dataSource.setUser("root");
        dataSource.setPassword("");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
