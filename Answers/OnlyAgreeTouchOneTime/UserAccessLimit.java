package OnlyAgreeTouchOneTime;

import java.sql.*;
import java.time.LocalDate;

public class UserAccessLimit {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static boolean canUserAccess(String userId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // ����û������Ƿ��Ѿ����ʹ�
            String query = "SELECT COUNT(*) FROM user_access WHERE user_id = ? AND access_date = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, userId);
                pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        if (count > 0) {
                            return false; // �û������Ѿ����ʹ�
                        }
                    }
                }
            }

            // ����û����컹û�з��ʹ�����¼���η���
            String insertQuery = "INSERT INTO user_access (user_id, access_date) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, userId);
                insertStmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                insertStmt.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String userId = "user123";
        if (canUserAccess(userId)) {
            System.out.println("�û����Է���");
        } else {
            System.out.println("�û������Ѿ����ʹ��������ٴη���");
        }
    }
}    