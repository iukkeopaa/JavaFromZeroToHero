package TheBeautyofProgramming;

public class FindMinM {
    public static void main(String[] args) {
        int N = 3;
        int M = findMinM(N);
        System.out.println("对于 N = " + N + ", 最小的 M = " + M);
    }

    public static int findMinM(int N) {
        long product = 10;
        while (true) {
            if (isValidProduct(product) && product % N == 0) {
                return (int) (product / N);
            }
            product++;
            while (!isValidProduct(product)) {
                product++;
            }
        }
    }

    public static boolean isValidProduct(long num) {
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}    