package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class CountOnes {
    public static int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("从 1 到 " + n + " 中 1 出现的次数是: " + countDigitOne(n));
    }
}    