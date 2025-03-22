package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class FindMedian {
    public static int findMedian(int a, int b, int c) {
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;
        int num3 = 7;
        int median = findMedian(num1, num2, num3);
        System.out.println("这三个数的中位数是: " + median);
    }
}    