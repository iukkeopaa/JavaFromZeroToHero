package OnlyAgreeTouchOneTime.Exp2;

public class MainDB {
    public static void main(String[] args) {
        UserAccessManagerDB manager = new UserAccessManagerDB();
        String userId = "user123";

        // ��һ�η���
        if (manager.canUserAccess(userId)) {
            System.out.println("��һ�η��ʣ��������");
        } else {
            System.out.println("��һ�η��ʣ���������");
        }

        // �ڶ��η���
        if (manager.canUserAccess(userId)) {
            System.out.println("�ڶ��η��ʣ��������");
        } else {
            System.out.println("�ڶ��η��ʣ���������");
        }

        // �����η���
        if (manager.canUserAccess(userId)) {
            System.out.println("�����η��ʣ��������");
        } else {
            System.out.println("�����η��ʣ���������");
        }
    }
}