package OnlyAgreeTouchOneTime;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserAccessLimitWithMap {
    private static final Map<String, LocalDate> accessMap = new HashMap<>();

    public static boolean canUserAccess(String userId) {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastAccessDate = accessMap.get(userId);

        if (lastAccessDate != null && lastAccessDate.isEqual(currentDate)) {
            return false; // �û������Ѿ����ʹ�
        }

        accessMap.put(userId, currentDate);
        return true;
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