package OnlyAgreeTouchOneTime.Exp3;

//要是限制时间是24小时内只能访问两次
public class Main24Hours {
    public static void main(String[] args) {
        UserAccessManager24Hours manager = new UserAccessManager24Hours();
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