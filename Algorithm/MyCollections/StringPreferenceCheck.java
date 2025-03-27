package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С���ϲ���ֽ���s������ַ���t��ĳһ����������Ϊk��ǰ׺��ĳһ����������Ϊk�ĺ�׺��s���Ӵ�����ôС��Ҳ��
//ϲ���ַ���t��
//���磬k= 2ʱ��С��ϲ���ַ���hello��ôС��Ҳϲ���ַ�"ciallo","he������Ϊ"ciallo���ĳ���Ϊ2�ĺ�׺"lo"he"�ĳ�
//��Ϊ2��ǰ׺"he������"hello�����Ӵ�����С�첻ϲ���ַ���"s!0������Ϊ"so!0"���κ�һ��ǰ׺����׺������"hello����
//�Ӵ���
//С����һ���ַ���ϲ����s����ÿ�λ����㣬�ַ���t���Ƿ�ϲ����
//��������
//��һ������һ�����Ȳ�����10����ֻ��Сд��ĸ���ɵ��ַ�����
//�ڶ�����������������q(1 ��q�� 10��),k(1 �� k �� 10)��ʾѯ�ʴ����ͳ�������,
//������q�У�ÿ������һ��ֻ��Сд��ĸ���ɵ��ַ���t��ʾѯ�ʡ�
//���ݱ�֤�����е��ַ���t�ĳ���֮�Ͳ�����105
//�������
//��ÿ��ѯ�����һ�У���С��ϲ���ַ���t�������YES"���������"NO"
public class StringPreferenceCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String t = scanner.nextLine();
            System.out.println(isPreferred(s, t, k)? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean isPreferred(String s, String t, int k) {
        int len = t.length();
        if (len < k) {
            return false;
        }

        return checkSubstring(s, t, 0, k) || checkSubstring(s, t, len - k, len);
    }

    private static boolean checkSubstring(String s, String t, int start, int end) {
        for (int i = 0; i <= s.length() - (end - start); i++) {
            boolean match = true;
            for (int j = 0; j < end - start; j++) {
                if (s.charAt(i + j) != t.charAt(start + j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
    