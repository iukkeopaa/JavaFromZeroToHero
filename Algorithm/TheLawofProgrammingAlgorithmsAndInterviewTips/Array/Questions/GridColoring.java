package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class GridColoring {
    public static int countColoringMethods(int n, int m) {
        int total = (int) Math.pow(2, n);
        int invalid = 0;
        boolean[] valid = new boolean[total];
        for (int i = 0; i < total; i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            int consecutiveBlue = 0;
            boolean hasMConsecutiveBlue = false;
            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '1') {
                    consecutiveBlue++;
                    if (consecutiveBlue >= m) {
                        hasMConsecutiveBlue = true;
                        break;
                    }
                } else {
                    consecutiveBlue = 0;
                }
            }
            if (!hasMConsecutiveBlue) {
                invalid++;
            }
        }
        return total - invalid;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        System.out.println(countColoringMethods(n, m));
    }
}    