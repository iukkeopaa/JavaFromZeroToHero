package XiaoHuiAlgorithmicJourney;

public class cp5_4 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd2(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }


    public static void main(String[] args) {

        int num1 = 48;
        int num2 = 18;
        int result = gcd2(num1, num2);
        System.out.println("两个整数 " + num1 + " 和 " + num2 + " 的最大公约数是: " + result);

        int result1 = gcd(num1, num2);
        System.out.println("两个整数 " + num1 + " 和 " + num2 + " 的最大公约数是: " + result1);
    }
}