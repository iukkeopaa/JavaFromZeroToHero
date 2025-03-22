package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class GoldbachConjecture {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int even = 6; even <= 10000; even += 2) {
            for (int i = 3; i <= even / 2; i += 2) {
                if (isPrime(i) && isPrime(even - i)) {
                    System.out.println(even + " = " + i + " + " + (even - i));
                    break;
                }
            }
        }
    }
}    