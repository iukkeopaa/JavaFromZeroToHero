package OnlyAgreeTouchOneTime.Exp2;

public class MainDB {
    public static void main(String[] args) {
        UserAccessManagerDB manager = new UserAccessManagerDB();
        String userId = "user123";

        // 第一次访问
        if (manager.canUserAccess(userId)) {
            System.out.println("第一次访问：允许访问");
        } else {
            System.out.println("第一次访问：访问受限");
        }

        // 第二次访问
        if (manager.canUserAccess(userId)) {
            System.out.println("第二次访问：允许访问");
        } else {
            System.out.println("第二次访问：访问受限");
        }

        // 第三次访问
        if (manager.canUserAccess(userId)) {
            System.out.println("第三次访问：允许访问");
        } else {
            System.out.println("第三次访问：访问受限");
        }
    }
}