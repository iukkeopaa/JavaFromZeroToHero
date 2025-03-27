package MyCollections;

//��Ŀ����
//С����һ������������n�����Ǽ�,w(n)Ϊn����λ֮�ͣ����� w(123)= 6.
//���β��� �� + 1���ߥ� �� -1�������������Ҫ��֤n > 0��
//С����֪���ڲ�����k�β�����ǰ���£��õ�������m��u(m)����Ƕ���?
public class MaxDigitSum {

    // ����һ�����ֵ���λ֮��
    public static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // �ҵ��ڲ����� k �β����µ������λ��
    public static int findMaxDigitSum(int n, int k) {
        int maxSum = digitSum(n);
        // �������Ӳ���
        for (int i = 1; i <= k; i++) {
            if (n + i > 0) {
                maxSum = Math.max(maxSum, digitSum(n + i));
            }
        }
        // ���Լ��ٲ���
        for (int i = 1; i <= k; i++) {
            if (n - i > 0) {
                maxSum = Math.max(maxSum, digitSum(n - i));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int n = 123;
        int k = 5;
        int result = findMaxDigitSum(n, k);
        System.out.println("�ڲ����� " + k + " �β����£��õ������ֵ���λ֮�������: " + result);
    }
}    