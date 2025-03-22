package CrackingTheCodingInterview.ch6;

public class BlueEyedPeople {
    public static int daysToLeave(int blueEyedCount) {
        return blueEyedCount;
    }

    public static void main(String[] args) {
        int blueEyedCount = 6;
        int days = daysToLeave(blueEyedCount);
        System.out.println("所有蓝眼睛的人需要 " + days + " 天才能离开这个岛。");
    }
}    