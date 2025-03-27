package MyCollections;

import java.util.HashSet;
import java.util.Set;

//����һ��������n�������������ҽ�������ȫ����λȡ�����뼯�Ϻ󣬼����е�Ԫ����������
//���磬456��5446��������������Ϊ����λȡ������뼯�ϣ����õ�(4,5,6}���������ġ�
//���ڣ����ڸ���������[,"������Ҫ���������������ж��ٸ�������
public class OrderedNumberCounter {
    public static int countOrderedNumbers(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (isOrderedNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOrderedNumber(int num) {
        Set<Integer> digits = new HashSet<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        if (digits.size() == 1) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int digit : digits) {
            min = Math.min(min, digit);
            max = Math.max(max, digit);
        }
        return digits.size() == max - min + 1;
    }

    public static void main(String[] args) {
        int l = 1;
        int r = 100;
        int result = countOrderedNumbers(l, r);
        System.out.println("���� [" + l + ", " + r + "] �ڵ�����������Ϊ: " + result);
    }
}    