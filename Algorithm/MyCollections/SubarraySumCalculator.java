package MyCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//��Ŀ����
//С����һ�����飬����֪���ж�������������ĺ�ͬʱ��3��5�ı�����������4�ı�����
//��������
//��һ������һ������ (1 <n �� 10��)��ʾ���鳤�ȡ� �ڶ�������n��������ʾ���� ��?(1 < a? < 10��)
public class SubarraySumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            for (int j = i; j < n; j++) {
                if (i != j) {
                    prefixSum += arr[j];
                }
                if (prefixSum % 3 == 0 && prefixSum % 5 == 0 && prefixSum % 4 != 0) {
                    count++;
                }
                if (j > i) {
                    prefixSum -= arr[j];
                }
            }
            prefixSum -= arr[i];
        }

        System.out.println(count);
    }
}    