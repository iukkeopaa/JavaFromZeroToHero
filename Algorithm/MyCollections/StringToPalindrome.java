package MyCollections;

//С����һ������Ϊ
//n
//n ֻ����Сд��ĸ���ַ��������������ַ���ͨ�����²�����ɻ��Ĵ���
//1. ѡ���ַ����ĵ�һ����ĸ����������ַ�����ĩβ�����磬�����ַ���
//a
//b
//c
//abc���õ�
//b
//c
//a
//bca��
//2. ѡ��һ���ַ�����һ���ַ���������ַ��������Сд��ĸ��
//ÿ��ֻ�ܽ����������ֲ����е�һ�֣�С����֪��������Ҫ���ж��ٴβ������ܽ��ַ�����ɻ��Ĵ���
public class StringToPalindrome {

    public static int minOperationsToPalindrome(String s) {
        int n = s.length();
        int minOperations = Integer.MAX_VALUE;

        // �������п��ܵ�ѭ����λ
        for (int i = 0; i < n; i++) {
            // ����ѭ����λ
            String shifted = s.substring(i) + s.substring(0, i);
            // ���㵱ǰ��λ���ַ�����Ϊ���Ĵ�������滻��������
            int replaceCount = countReplacements(shifted);
            // �ܲ������� = ��λ���� + �滻����
            int totalOperations = i + replaceCount;
            // ������С��������
            minOperations = Math.min(minOperations, totalOperations);
        }

        return minOperations;
    }

    // ���㽫�ַ�����ɻ��Ĵ�������滻��������
    private static int countReplacements(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "abc";
        int result = minOperationsToPalindrome(input);
        System.out.println("���ַ���ת��Ϊ���Ĵ�������Ҫ�Ĳ�������: " + result);
    }
}    