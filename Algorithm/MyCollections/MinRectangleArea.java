package MyCollections;

//���Ӹ��õ���һ������Ϊ2n�����飬��ϣ���������е�Ԫ�طֳ�n����Ԫ��:(i,y)
//ÿ����Ԫ���Ӧƽ��ֱ������ϵ��һ���㣬Ȼ�����Ӹ�ϣ����һ���ߺ�������ƽ�еľ��ν����е��������ڡ����Ӹ�ϣ
//�����վ��ε����������С�����ܰ������?
public class MinRectangleArea {
    public static int minArea(int[] arr) {
        // ������鳤���Ƿ�Ϊż�������������׳��쳣
        if (arr.length % 2 != 0) {
            throw new IllegalArgumentException("��������ĳ��ȱ���Ϊż��");
        }
        // ������Ϊ�գ��������Ϊ 0
        if (arr.length == 0) {
            return 0;
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i += 2) {
            int x = arr[i];
            int y = arr[i + 1];
            // ������С����� x ����
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            // ������С����� y ����
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        int width = maxX - minX;
        int height = maxY - minY;

        return width * height;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        try {
            int area = minArea(arr);
            System.out.println("��С���ε������: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}    