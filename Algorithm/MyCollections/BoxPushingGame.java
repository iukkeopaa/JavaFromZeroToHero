package MyCollections;

//����������һ����������Ϸ����һ����ά�����У����ӵ���������(��,y)��������ĸ���������Բ���:
//��W:�����������ƶ�����:(��,y)->(,y+1)
//A:�����������ƶ�����:(,y)- >(�� - 1,y)
//S:�����������ƶ�����:(,y)->(,y-1
//"D:�����������ƶ�����:(,y)->(�� +1,y)
//�ھ������һϵ�а������������ǡ���������ӵ�λ��ǡ����(0,0)����Ӯ�ˣ������æ�������Ƿ���Ӯ��
public class BoxPushingGame {
    public static boolean canWin(int startX, int startY, String operations) {
        if (operations == null) {
            return startX == 0 && startY == 0;
        }
        int currentX = startX;
        int currentY = startY;

        for (int i = 0; i < operations.length(); i++) {
            char operation = operations.charAt(i);
            switch (operation) {
                case 'W':
                    currentY++;
                    break;
                case 'A':
                    currentX--;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'D':
                    currentX++;
                    break;
                default:
                    // ������Ч����
                    break;
            }
        }

        return currentX == 0 && currentY == 0;
    }

    public static void main(String[] args) {
        int startX = 1;
        int startY = 1;
        String operations = "AS";
        boolean result = canWin(startX, startY, operations);
        if (result) {
            System.out.println("���Ӯ�ˣ�");
        } else {
            System.out.println("������ˡ�");
        }
    }
}    