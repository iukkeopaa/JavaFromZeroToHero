package MyCollections;

//С��ϲ���Զ���Ǻ�«������Ǻ�«�ϵ�ÿһ���Ǻ�«����һ����ɫ��
//��С���зǳ����ص�ǿ��֢�������Բ���������������ͬ��ɫ���Ǻ�«��
//һ���Ǻ�«ֻ�ܴ������³ԣ�һ��С�췢����һ���Ǻ�«�����ճԹ����Ǻ�«��ɫ��ͬʱ��С��ͻ����������Ǻ�«������
//
//С����֪������һ������Ǻ�«ʱ���ԳԵ������Ǻ�«��
public class CandyCount {
    public static int countEatenCandies(String colors) {
        if (colors == null || colors.length() == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String colors = "RGBGR";
        int eaten = countEatenCandies(colors);
        System.out.println("С���ܳԵ����Ǻ�«������: " + eaten);
    }
}    