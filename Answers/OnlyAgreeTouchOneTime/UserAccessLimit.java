package OnlyAgreeTouchOneTime;

import java.sql.*;
import java.time.LocalDate;

public class UserAccessLimit {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static boolean canUserAccess(String userId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // 检查用户今天是否已经访问过
            String query = "SELECT COUNT(*) FROM user_access WHERE user_id = ? AND access_date = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, userId);
                pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        if (count > 0) {
                            return false; // 用户今天已经访问过
                        }
                    }
                }
            }

            // 如果用户今天还没有访问过，记录本次访问
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
            System.out.println("用户可以访问");
        } else {
            System.out.println("用户今天已经访问过，不能再次访问");
        }
    }
}    