package OnlyAgreeTouchOneTime.Exp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

//一个用户在一天中访问两次，并且涉及到时间限制怎么实现
public class UserAccessManagerDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // 检查用户是否可以访问
    public boolean canUserAccess(String userId) {
        LocalDate today = LocalDate.now();
        int visitCount = getVisitCount(userId, today);
        if (visitCount < 2) {
            recordVisit(userId, today);
            return true;
        }
        return false;
    }

    // 获取用户当天的访问次数
    private int getVisitCount(String userId, LocalDate date) {
        String sql = "SELECT visit_count FROM user_visits WHERE user_id =? AND visit_date =?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, date.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("visit_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 记录用户的访问信息
    private void recordVisit(String userId, LocalDate date) {
        int visitCount = getVisitCount(userId, date);
        String sql;
        if (visitCount == 0) {
            sql = "INSERT INTO user_visits (user_id, visit_date, visit_time, visit_count) VALUES (?,?,?,?)";
        } else {
            sql = "UPDATE user_visits SET visit_time =?, visit_count =? WHERE user_id =? AND visit_date =?";
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (visitCount == 0) {
                pstmt.setString(1, userId);
                pstmt.setString(2, date.toString());
                pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                pstmt.setInt(4, 1);
            } else {
                pstmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                pstmt.setInt(2, visitCount + 1);
                pstmt.setString(3, userId);
                pstmt.setString(4, date.toString());
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}