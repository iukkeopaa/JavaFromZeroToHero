package CrackingTheCodingInterview.ch5;

public class FindNearestNumbers {

    // 计算一个整数二进制表示中 1 的个数
    private static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    // 查找比给定数大且二进制中 1 的个数相同的最小数
    private static int findNext(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;
        // 计算尾部 0 的个数
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }
        // 计算紧接着尾部 0 的 1 的个数
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        // 如果没有更大的数或者溢出了
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        int p = c0 + c1;
        // 把第 p 位置为 1
        num |= (1 << p);
        // 把 p 右边的位都置为 0
        num &= ~((1 << p) - 1);
        // 在右边插入 c1 - 1 个 1
        num |= (1 << (c1 - 1)) - 1;
        return num;
    }

    // 查找比给定数小且二进制中 1 的个数相同的最大数
    private static int findPrev(int num) {
        int temp = num;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) {
            return -1;
        }
        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        int p = c0 + c1;
        // 把第 p 位置为 0
        num &= ~(1 << p);
        // 把 p 右边的位都置为 1
        num |= (1 << p) - 1;
        // 把最右边的 c1 + 1 位置为 0
        num &= ~((1 << (c1 + 1)) - 1);
        return num;
    }

    public static int[] findNearestNumbers(int num) {
        int[] result = new int[2];
        result[0] = findPrev(num);
        result[1] = findNext(num);
        return result;
    }

    public static void main(String[] args) {
        int num = 13948;
        int[] nearestNumbers = findNearestNumbers(num);
        System.out.println("略小的数: " + nearestNumbers[0]);
        System.out.println("略大的数: " + nearestNumbers[1]);
    }
}    