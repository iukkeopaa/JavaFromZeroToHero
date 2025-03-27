package MyCollections;

import java.util.Arrays;

//С����һλ����ĳ���Ա,��������о�һ��������������������һ������������ɵ�����,����ĳ�����ż����С����
//�Զ������е�����һ������ִ���������ֲ���֮һ
//1.�������ֳ��� 2;
//2.�������ֳ��� 2 ������ȡ����
//С����Ŀ����ͨ��һϵ�в���,ʹ������������ǡ��һ�������������,��һ����ż������ϣ���ҵ�һ�ַ���,ʹ�ò�����
//������
public class ArrayOddEvenOperation {

    // ���㽫һ��ż����Ϊ������������ٲ�������
    private static int countToOdd(int num) {
        int operations = 0;
        while (num % 2 == 0) {
            num /= 2;
            operations++;
        }
        return operations;
    }

    // ���㽫һ��������Ϊż����������ٲ�������
    private static int countToEven(int num) {
        if (num % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int oddCount = 0;
        int[] evenToOdd = new int[n];
        int[] oddToEven = new int[n];

        // ͳ���������������ֱ����ÿ��ż����������������ż������Ĳ�������
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
                oddToEven[i] = countToEven(nums[i]);
            } else {
                evenToOdd[i] = countToOdd(nums[i]);
            }
        }

        int targetOdd = n / 2;
        if (oddCount == targetOdd) {
            return 0;
        } else if (oddCount > targetOdd) {
            // �������࣬��һЩ������Ϊż��
            Arrays.sort(oddToEven);
            int diff = oddCount - targetOdd;
            int operations = 0;
            for (int i = 0; i < diff; i++) {
                operations += oddToEven[i];
            }
            return operations;
        } else {
            // ż�����࣬��һЩż����Ϊ����
            Arrays.sort(evenToOdd);
            int diff = targetOdd - oddCount;
            int operations = 0;
            for (int i = 0; i < diff; i++) {
                operations += evenToOdd[i];
            }
            return operations;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        System.out.println("���ٲ�������: " + minOperations(nums));
    }
}    