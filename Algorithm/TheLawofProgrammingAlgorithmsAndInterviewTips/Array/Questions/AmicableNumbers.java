package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class AmicableNumbers {
    public static int sumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void findAmicableNumbers(int limit) {
        for (int a = 2; a < limit; a++) {
            int b = sumOfProperDivisors(a);
            if (b > a && sumOfProperDivisors(b) == a) {
                System.out.println("亲和数对: (" + a + ", " + b + ")");
            }
        }
    }

    public static void main(String[] args) {
        int limit = 10000;
        findAmicableNumbers(limit);
    }
}    