package OnlyAgreeTouchOneTime.Exp1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class UserAccessManager {
    // �洢�û� ID ������ʼ�¼
    private Map<String, UserAccessRecord> userAccessRecords;

    public UserAccessManager() {
        this.userAccessRecords = new HashMap<>();
    }

    // ����û��Ƿ���Է���
    public boolean canUserAccess(String userId) {
        LocalDate today = LocalDate.now();
        UserAccessRecord record = userAccessRecords.computeIfAbsent(userId, k -> new UserAccessRecord());

        // ����Ƿ����µ�һ��
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

    // ��ȡ�û��ķ��ʼ�¼
    public UserAccessRecord getUserAccessRecord(String userId) {
        return userAccessRecords.getOrDefault(userId, new UserAccessRecord());
    }

    // �ڲ��࣬���ڴ洢�û��ķ��ʼ�¼
    static class UserAccessRecord {
        LocalDate lastAccessDate;
        LocalDateTime lastAccessTime;
        int accessCount;

        public UserAccessRecord() {
            this.lastAccessDate = LocalDate.MIN;
            this.lastAccessTime = LocalDateTime.MIN;
            this.accessCount = 0;
        }

        // ���÷��ʼ�¼
        public void reset() {
            this.accessCount = 0;
        }
    }
}
