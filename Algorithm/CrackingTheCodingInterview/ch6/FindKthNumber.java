package CrackingTheCodingInterview.ch6;

public class FindKthNumber {
    public static int getKthNumber(int k) {
        if (k <= 0) {
            return -1;
        }
        int[] numbers = new int[k];
        numbers[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;

        for (int i = 1; i < k; i++) {
            int next3 = numbers[p3] * 3;
            int next5 = numbers[p5] * 5;
            int next7 = numbers[p7] * 7;

            int next = Math.min(next3, Math.min(next5, next7));
            numbers[i] = next;

            if (next == next3) {
                p3++;
            }
            if (next == next5) {
                p5++;
            }
            if (next == next7) {
                p7++;
            }
        }
        return numbers[k - 1];
    }

    public static void main(String[] args) {
        int k = 5;
        int result = getKthNumber(k);
        System.out.println("第 " + k + " 个数是: " + result);
    }
}    