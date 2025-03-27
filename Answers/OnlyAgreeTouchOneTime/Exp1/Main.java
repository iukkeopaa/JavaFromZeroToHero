package OnlyAgreeTouchOneTime.Exp1;

public class Main {
    public static void main(String[] args) {
        UserAccessManager manager = new UserAccessManager();
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