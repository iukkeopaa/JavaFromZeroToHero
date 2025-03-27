package OnlyAgreeTouchOneTime.Exp1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class UserAccessManager {
    // 存储用户 ID 及其访问记录
    private Map<String, UserAccessRecord> userAccessRecords;

    public UserAccessManager() {
        this.userAccessRecords = new HashMap<>();
    }

    // 检查用户是否可以访问
    public boolean canUserAccess(String userId) {
        LocalDate today = LocalDate.now();
        UserAccessRecord record = userAccessRecords.computeIfAbsent(userId, k -> new UserAccessRecord());

        // 检查是否是新的一天
        if (!record.lastAccessDate.equals(today)) {
            record.reset();
            record.lastAccessDate = today;
        }

        if (record.accessCount < 2) {
            record.accessCount++;
            record.lastAccessTime = LocalDateTime.now();
            return true;
        }
        return false;
    }

    // 获取用户的访问记录
    public UserAccessRecord getUserAccessRecord(String userId) {
        return userAccessRecords.getOrDefault(userId, new UserAccessRecord());
    }

    // 内部类，用于存储用户的访问记录
    static class UserAccessRecord {
        LocalDate lastAccessDate;
        LocalDateTime lastAccessTime;
        int accessCount;

        public UserAccessRecord() {
            this.lastAccessDate = LocalDate.MIN;
            this.lastAccessTime = LocalDateTime.MIN;
            this.accessCount = 0;
        }

        // 重置访问记录
        public void reset() {
            this.accessCount = 0;
        }
    }
}
