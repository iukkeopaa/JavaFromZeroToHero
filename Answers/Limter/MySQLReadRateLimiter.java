package Limter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Semaphore;

public class MySQLReadRateLimiter {
    // 数据库连接信息
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
    // 一秒内最多执行 5 次，所以信号量初始许可为 5
    private final Semaphore semaphore = new Semaphore(5);

    public void executeReadOperation() {
        try {
            // 获取信号量许可，如果没有可用许可则阻塞
            semaphore.acquire();
            // 模拟数据库操作
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement statement = connection.createStatement()) {
                // 执行读操作示例
                String query = "SELECT * FROM your_table";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    // 处理结果集
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放信号量许可
                semaphore.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        MySQLReadRateLimiter limiter = new MySQLReadRateLimiter();
        // 模拟多次调用读操作
        for (int i = 0; i < 10; i++) {
            new Thread(limiter::executeReadOperation).start();
        }
    }
}