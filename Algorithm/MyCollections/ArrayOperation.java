package MyCollections;

import java.util.Scanner;

//С����һ����Ϊn ������ a���±��0����-1�������������²���:
//������ÿһ��i(1 <i< n)����b; = a:|a(i+1)%n��ȫ��ִ������ٽ�a���鸳ֵΪb���飬����ִ��:a;=
//bi(l ��i�� n)��
//С����֪�����������Ҫa����Сֵ��С��k�Ļ���������Ҫִ�ж��ٴ������Ĳ��������������һ��ɡ�(���ݱ�֤
//��������
//ÿ�������ļ��ڶ���������������ݡ�
//��һ��һ�������� T(1 �� T < 1000)����ʾ�������ݵ�����
//����������ÿ��������ݣ�����������С�
//��һ���������� n, k(1 �� n �� 2* 10',0 �ܤ��� 231)��ʾ����a�ĳ��Ⱥ���Сֵ�����ơ�
//�ڶ��� �� ������ ��? (0 < �� < 231)����ʾ���� a��(��֤���в��������� n ���ܺͲ����� 3*10'
public class ArrayOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int operations = 0;
            boolean canReach = false;

            // ������ n �β�������Ϊ n �β�����״̬��ѭ��
            for (int op = 0; op <= n; op++) {
                boolean allValid = true;
                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    temp[i] = a[i];
                    if (i > 0) {
                        temp[i] |= a[i - 1];
                    }
                    if (i < n - 1) {
                        temp[i] |= a[i + 1];
                    }
                    if (i == 0) {
                        temp[i] |= a[n - 1];
                    }
                    if (temp[i] < k) {
                        allValid = false;
                    }
                }
                if (allValid) {
                    operations = op;
                    canReach = true;
                    break;
                }
                a = temp;
            }

            if (canReach) {
                System.out.println(operations);
            } else {
                System.out.println(-1);
            }
        }
        scanner.close();
    }
}    