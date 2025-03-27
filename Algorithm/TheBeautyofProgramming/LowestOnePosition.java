package TheBeautyofProgramming;

public class LowestOnePosition {
    public static int findLowestOnePosition(int n) {
        int count = 0;
        while (n > 0) {
            n /= 2;
            count += n;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int position = findLowestOnePosition(n);
        System.out.println("N! 的二进制表示中最低位 1 的位置是: " + position);
    }
}    