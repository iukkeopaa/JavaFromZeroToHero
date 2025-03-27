package MyCollections;

import java.util.HashSet;
import java.util.Set;

//定义一个正整数n是有序数，当且仅当将其全部数位取出放入集合后，集合中的元素是连续的
//例如，456和5446都是有序数，因为将数位取出后放入集合，均得到(4,5,6}，是连续的。
//现在，对于给定的区间[,"，你需要计算出这个区间内有多少个有序数
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
        System.out.println("区间 [" + l + ", " + r + "] 内的有序数数量为: " + result);
    }
}    