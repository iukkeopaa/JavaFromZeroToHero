package MyCollections;

import java.util.Scanner;

//��Ŀ����
//Сŷ��һ������Ϊn������[a1,��2,��,]����������֪��������a�е�ÿ��Ԫ�أ�ɾ����Ԫ�غ������MEXֵ�Ƕ���,
//�����������ɡ�
//�����MEX����Ϊû�г����������е���С�Ǹ�������
//��������
//��һ������һ������n(2 �� n�� 200000)���������е�Ԫ��������
//�ڶ�������n������a1,a2,��, a?(0 �� a: �� 10��)��������Ԫ�ء�
//�������
//��һ��������������������е�i��������ʾɾ��a:�������MEXֵ��
public class CalculateMexAfterDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] count = new int[1000000001];

        // ��ȡ����Ԫ�ز�ͳ��ÿ��Ԫ�صĳ��ִ���
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            count[arr[i]]++;
        }

        // �ҳ�ԭ����� MEX ֵ
        int mex = 0;
        while (count[mex] > 0) {
            mex++;
        }

        // ���㲢���ɾ��ÿ��Ԫ�غ�� MEX ֵ
        for (int i = 0; i < n; i++) {
            count[arr[i]]--;
            if (count[arr[i]] == 0 && arr[i] < mex) {
                int newMex = arr[i];
                System.out.print(newMex);
            } else {
                System.out.print(mex);
            }
            if (i < n - 1) {
                System.out.print(" ");
            }
            count[arr[i]]++;
        }
        System.out.println();
        scanner.close();
    }
}    