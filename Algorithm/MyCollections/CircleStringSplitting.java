package MyCollections;

import java.util.Scanner;

//��Ŀ����
//С��ᰮȦȦ�ַ���
//С����Ϊ:['a,'b,d,e,g'o,p��q]��Щ�ַ�ΪȦ�ַ�����Ϊ���Ƕ�����һ��ԲȦ��
//������Ϊһ���ַ�����ȦȦ�ַ�����ǰ��������ַ����е�ȦȦ�ַ��������ڷ�ȦȦ�ַ�������
//����С����������ַ����ֳ����ɸ��ǿ��ַ�������������������Щ�ǿ��ַ������������ж��ٸ�ȦȦ�ַ���,
//��������
//һ���ַ���s�����뱣֤����Сд��ĸ�ҳ��Ȳ�����10
//�������
//����������ʾ�������г����ٸ�ȦȦ�ַ�����
public class CircleStringSplitting {
    // ȦȦ�ַ�����
    private static final String CIRCLE_CHARS = "abdegopq";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(maxCircleStrings(s));
        scanner.close();
    }

    // �����������г���ȦȦ�ַ�������
    private static int maxCircleStrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isCircleString(s, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }

    // �ж����ַ����Ƿ�ΪȦȦ�ַ���
    private static boolean isCircleString(String s, int start, int end) {
        int circleCount = 0;
        int nonCircleCount = 0;
        for (int i = start; i < end; i++) {
            if (CIRCLE_CHARS.indexOf(s.charAt(i)) != -1) {
                circleCount++;
            } else {
                nonCircleCount++;
            }
        }
        return circleCount > nonCircleCount;
    }
}    