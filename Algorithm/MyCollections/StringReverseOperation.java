package MyCollections;

import java.util.Scanner;

//��Ŀ����
//��С����һ������Ϊ n ���ַ��� s���±�� 1��ʼ��
//�����һ�����䡼,"ִ�з�ת����Ϊ��ԭ����
//S1Sl+181+2...8,-18,��Ϊ8,8r-1...S1-181��
//������׼��ѡ�� 4 �� ���� a,b,c,d(1 <a��b��c��d�� n)��Ȼ���ȶ�����[a,bִ�з�ת������Ȼ���ٶ�����
//��,d ִ�з�ת����������������֮�����ڵ��ַ����ͳ�ʼ�ַ����ܹ�������ͬ�������YES����Ȼ����������� 4
//�����������ж���⣬�������һ�����������Ľ⡣�������"NO"��
//��������
//��һ��һ������ n(1 ��n�� 10��)����ʾ�ַ������ȡ�
//�ڶ���һ������Ϊn���ַ��� s����֤�������Сд��ĸ��ɡ�
//�������
//�������������⣬��һ�����" YES"���ڶ������4������������a,b,c,d���Կո���������ж���⣬�������-
//����
//�����ܣ������NO
public class StringReverseOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                // �ȳ��� [a, b] ���䷭ת����
                if (isValid(s, a, b, a, b)) {
                    System.out.println("YES");
                    System.out.println(a + " " + b + " " + a + " " + b);
                    scanner.close();
                    return;
                }

                // ����Ѱ�ҶԳ�����
                int len = b - a + 1;
                int c = b + 1;
                int d = c + len - 1;
                if (d <= n && isValid(s, a, b, c, d)) {
                    System.out.println("YES");
                    System.out.println(a + " " + b + " " + c + " " + d);
                    scanner.close();
                    return;
                }
            }
        }
        System.out.println("NO");
        scanner.close();
    }

    public static boolean isValid(String s, int a, int b, int c, int d) {
        String temp = reverse(reverse(s, a, b), c, d);
        return temp.equals(s);
    }

    public static String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s);
        String sub = sb.substring(start - 1, end);
        sb.replace(start - 1, end, new StringBuilder(sub).reverse().toString());
        return sb.toString();
    }
}    