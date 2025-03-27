package DesignConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

// 简单的数据库连接池类
public class SimpleConnectionPool {
    // 存储连接的队列
    private final LinkedList<Connection> connectionQueue;
    // 数据库连接的 URL
    private final String url;
    // 数据库用户名
    private final String username;
    // 数据库密码
    private final String password;
    // 初始连接数
    private final int initialSize;
    // 最大连接数
    private final int maxSize;

    // 构造函数，初始化连接池
    public SimpleConnectionPool(String url, String username, String password, int initialSize, int maxSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.initialSize = initialSize;
        this.maxSize = maxSize;
        this.connectionQueue = new LinkedList<>();
        // 初始化连接池
        initializeConnections();
    }

    // 初始化连接池中的连接
    private void initializeConnections() {
        for (int i = 0; i < initialSize; i++) {
            try {
                // 创建新的数据库连接并添加到队列中
                connectionQueue.add(createConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 创建新的数据库连接
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // 从连接池中获取一个连接
    public synchronized Connection getConnection() throws SQLException {
        if (connectionQueue.isEmpty()) {
            if (connectionQueue.size() < maxSize) {
                // 如果连接池为空且未达到最大连接数，创建新的连接
                return createConnection();
            } else {
                throw new SQLException("连接池已达到最大连接数，无法获取新连接。");
            }
        }
        // 从队列头部取出一个连接
        return connectionQueue.poll();
    }

    // 将连接归还给连接池
    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    // 将连接添加到队列尾部
                    connectionQueue.add(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭连接池中的所有连接
    public synchronized void closeAllConnections() {
        for (Connection connection : connectionQueue) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connectionQueue.clear();
    }

    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        // 初始化连接数
        int initialSize = 5;
        // 最大连接数
        int maxSize = 10;

        // 创建连接池实例
        SimpleConnectionPool connectionPool = new SimpleConnectionPool(url, username, password, initialSize, maxSize);

        try {
            // 从连接池获取连接
            Connection connection = connectionPool.getConnection();
            System.out.println("获取到连接: " + connection);
            // 将连接归还给连接池
            connectionPool.releaseConnection(connection);
            System.out.println("连接已归还到连接池");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接池
            connectionPool.closeAllConnections();
        }
    }
}    