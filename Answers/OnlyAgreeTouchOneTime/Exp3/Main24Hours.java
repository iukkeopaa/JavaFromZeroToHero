package OnlyAgreeTouchOneTime.Exp3;

//Ҫ������ʱ����24Сʱ��ֻ�ܷ�������
public class Main24Hours {
    public static void main(String[] args) {
        UserAccessManager24Hours manager = new UserAccessManager24Hours();
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