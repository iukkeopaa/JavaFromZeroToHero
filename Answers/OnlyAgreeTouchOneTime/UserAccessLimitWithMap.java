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
            return false; // 用户今天已经访问过
        }

        accessMap.put(userId, currentDate);
        return true;
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