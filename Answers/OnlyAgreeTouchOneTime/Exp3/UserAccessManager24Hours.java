package OnlyAgreeTouchOneTime.Exp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserAccessManager24Hours {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // 检查用户是否可以访问
    public boolean canUserAccess(String userId) {
        int visitCount = getVisitCountIn24Hours(userId);
        if (visitCount < 2) {
            recordVisit(userId);
            return true;
        }
        return false;
    }

    // 获取用户在 24 小时内的访问次数
    private int getVisitCountIn24Hours(String userId) {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minus(24, ChronoUnit.HOURS);
        String sql = "SELECT COUNT(*) FROM user_visits WHERE user_id =? AND visit_time >=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setTimestamp(2, Timestamp.valueOf(twentyFourHoursAgo));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 记录用户的访问信息
    private void recordVisit(String userId) {
        String sql = "INSERT INTO user_visits (user_id, visit_date, visit_time, visit_count) VALUES (?,?,?,?)";
        LocalDateTime now = LocalDateTime.now();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, now.toLocalDate().toString());
            pstmt.setTimestamp(3, Timestamp.valueOf(now));
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}