package MyCollections;

import java.util.Scanner;

//��Ŀ����
//Сŷ��һ����СΪn������[a1,a2,��.an,
//������ѡ��һ��Ԫ�أ�������������෴��a:��(-1)xa.������ʱ����
//֮��������0,�ڣ������ѡ���Ǻõġ�
//Сŷ��֪���ж�����ѡ���Ǻõġ�
//��������
//��һ��������������n,t(1 <n< 2x 10��;1 ��t< 4x 1018)���������е�Ԫ���������������ơ�
//�ڶ������뼸������a1,42,��,��n(-2 x10�� �� a�� 2x10��)��������Ԫ�ء�
//�������
//��һ�������һ����������ʾ�õ�ѡ�������
public class GoodChoiceCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ��ȡ����Ԫ������ n ���������� t
        int n = scanner.nextInt();
        long t = scanner.nextLong();

        // ���ڴ洢����Ԫ��
        long[] array = new long[n];
        // �洢����Ԫ�ص��ܺ�
        long totalSum = 0;

        // ��ȡ����Ԫ�ز������ܺ�
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            totalSum += array[i];
        }

        // ���ڼ�¼�õ�ѡ�������
        int validChoices = 0;

        // �������飬���Խ�ÿ��Ԫ��ȡ��
        for (int i = 0; i < n; i++) {
            // ���㽫��ǰԪ��ȡ����������ܺ�
            long newSum = totalSum - 2 * array[i];
            // ����µ��ܺ��Ƿ������� [0, t] ��
            if (newSum >= 0 && newSum <= t) {
                validChoices++;
            }
        }

        // ����õ�ѡ�������
        System.out.println(validChoices);

        scanner.close();
    }
}    