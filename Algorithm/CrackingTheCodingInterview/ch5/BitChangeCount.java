package CrackingTheCodingInterview.ch5;

public class BitChangeCount {
    public static int bitChangeCount(int A, int B) {
        int xorResult = A ^ B;
        int count = 0;
        while (xorResult != 0) {
            count++;
            xorResult &= (xorResult - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 10;
        int B = 20;
        System.out.println("将 " + A + " 转成 " + B + " 需要改变 " + bitChangeCount(A, B) + " 个位。");
    }
}    