package MyCollections.FindSubtreeNodes.ExponentiationChecker;

public class ExponentiationChecker {
    public static boolean checkPairs(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                double result1 = Math.pow(x[i], y[j]);
                double result2 = Math.pow(y[j], x[i]);
                if (result1 > result2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = {2, 3, 4};
        int[] y = {1, 2, 3};
        boolean hasPair = checkPairs(x, y);
        System.out.println("是否存在 x^y > y^x 的对: " + hasPair);
    }
}