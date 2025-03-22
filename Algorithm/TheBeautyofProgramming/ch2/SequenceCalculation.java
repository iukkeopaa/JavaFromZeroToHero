package TheBeautyofProgramming.ch2;

import java.math.BigInteger;

public class SequenceCalculation {
    public static BigInteger calculateA(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (n == 1) {
            return BigInteger.valueOf(2);
        }
        if (n == 2) {
            return BigInteger.valueOf(2);
        }

        BigInteger a0 = BigInteger.ONE;
        BigInteger a1 = BigInteger.valueOf(2);
        BigInteger a2 = BigInteger.valueOf(2);
        BigInteger result = BigInteger.ZERO;

        for (int i = 3; i <= n; i++) {
            result = a0.add(a1).add(a2);
            a0 = a1;
            a1 = a2;
            a2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 260;
        BigInteger result = calculateA(n);
        System.out.println("A(" + n + ") = " + result);
    }
}    