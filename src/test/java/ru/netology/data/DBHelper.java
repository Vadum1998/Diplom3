package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
    private static final QueryRunner runner = new QueryRunner();


    private static Connection getConnection() throws SQLException {
        String dbUrl = System.getProperty("db.url");
        String login = System.getProperty("login");
        String password = System.getProperty("password");
        final Connection connection = DriverManager.getConnection(dbUrl, login, password);
        return connection;
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var status = "SELECT status FROM payment_entity ORDER BY created DESC";
        return runner.query(getConnection(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static Integer getPaymentAmount() {
        var amount = "SELECT amount FROM payment_entity ORDER BY created DESC";
        return runner.query(getConnection(), amount, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditRequestStatus() {
        var status = "SELECT status FROM credit_request_entity ORDER BY created DESC";
        return runner.query(getConnection(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditId() {
        var id = "SELECT credit_id FROM order_entity ORDER BY created DESC";
        return runner.query(getConnection(), id, new ScalarHandler<>());
    }
}


