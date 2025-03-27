//package OnlyAgreeTouchOneTime;
//
//import redis.clients.jedis.Jedis;
//import java.time.LocalDate;
//
//public class UserAccessLimitWithRedis {
//    private static final String REDIS_HOST = "localhost";
//    private static final int REDIS_PORT = 6379;
//
//    public static boolean canUserAccess(String userId) {
//        try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
//            String key = "user_access:" + userId + ":" + LocalDate.now();
//            long result = jedis.setnx(key, "1");
//            if (result == 1) {
//                // ���ù���ʱ��Ϊһ��
//                jedis.expire(key, 86400);
//                return true;
//            }
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        String userId = "user123";
//        if (canUserAccess(userId)) {
//            System.out.println("�û����Է���");
//        } else {
//            System.out.println("�û������Ѿ����ʹ��������ٴη���");
//        }
//    }
//}