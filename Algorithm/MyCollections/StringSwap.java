package MyCollections;

//С����һ��01��s����������ǡ��һ�����²� ��:
//ѡ���±�i,j(i�� j)������si��sj��
//С����֪������ͬ�Ĳ������������������ɶ��ٲ�ͬ���ַ���?
public class StringSwap {
    public static int countDistinctStrings(String s) {
        int n = s.length();
        int count0 = 0;
        int count1 = 0;

        // ͳ���ַ����� 0 �� 1 ������
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        // ����ַ�����ȫ�� 0 ����ȫ�� 1���޷�ͨ�������õ���ͬ���ַ���
        if (count0 == 0 || count1 == 0) {
            return 0;
        }

        // ���㲻ͬ�Ľ�����������
        return count0 * count1;
    }

    public static void main(String[] args) {
        String s = "010";
        int result = countDistinctStrings(s);
        System.out.println("��ͬ���ַ�������Ϊ: " + result);
    }
}    