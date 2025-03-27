package DesignConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

// �򵥵����ݿ����ӳ���
public class SimpleConnectionPool {
    // �洢���ӵĶ���
    private final LinkedList<Connection> connectionQueue;
    // ���ݿ����ӵ� URL
    private final String url;
    // ���ݿ��û���
    private final String username;
    // ���ݿ�����
    private final String password;
    // ��ʼ������
    private final int initialSize;
    // ���������
    private final int maxSize;

    // ���캯������ʼ�����ӳ�
    public SimpleConnectionPool(String url, String username, String password, int initialSize, int maxSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.initialSize = initialSize;
        this.maxSize = maxSize;
        this.connectionQueue = new LinkedList<>();
        // ��ʼ�����ӳ�
        initializeConnections();
    }

    // ��ʼ�����ӳ��е�����
    private void initializeConnections() {
        for (int i = 0; i < initialSize; i++) {
            try {
                // �����µ����ݿ����Ӳ���ӵ�������
                connectionQueue.add(createConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // �����µ����ݿ�����
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // �����ӳ��л�ȡһ������
    public synchronized Connection getConnection() throws SQLException {
        if (connectionQueue.isEmpty()) {
            if (connectionQueue.size() < maxSize) {
                // ������ӳ�Ϊ����δ�ﵽ����������������µ�����
                return createConnection();
            } else {
                throw new SQLException("���ӳ��Ѵﵽ������������޷���ȡ�����ӡ�");
            }
        }
        // �Ӷ���ͷ��ȡ��һ������
        return connectionQueue.poll();
    }

    // �����ӹ黹�����ӳ�
    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    // ��������ӵ�����β��
                    connectionQueue.add(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // �ر����ӳ��е���������
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
        // ���ݿ�������Ϣ
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        // ��ʼ��������
        int initialSize = 5;
        // ���������
        int maxSize = 10;

        // �������ӳ�ʵ��
        SimpleConnectionPool connectionPool = new SimpleConnectionPool(url, username, password, initialSize, maxSize);

        try {
            // �����ӳػ�ȡ����
            Connection connection = connectionPool.getConnection();
            System.out.println("��ȡ������: " + connection);
            // �����ӹ黹�����ӳ�
            connectionPool.releaseConnection(connection);
            System.out.println("�����ѹ黹�����ӳ�");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر����ӳ�
            connectionPool.closeAllConnections();
        }
    }
}    