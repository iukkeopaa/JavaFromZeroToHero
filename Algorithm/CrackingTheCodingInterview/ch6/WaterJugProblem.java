package CrackingTheCodingInterview.ch6;

public class WaterJugProblem {
    public static void main(String[] args) {
        // 5 夸脱水壶初始水量为 0
        int jug5 = 0;
        // 3 夸脱水壶初始水量为 0
        int jug3 = 0;

        while (jug5 != 4) {
            if (jug3 == 0) {
                // 若 3 夸脱水壶为空，则将其装满
                jug3 = 3;
                System.out.println("将 3 夸脱的水壶装满水");
            } else if (jug5 == 5) {
                // 若 5 夸脱水壶已满，则将其倒空
                jug5 = 0;
                System.out.println("将 5 夸脱的水壶倒空");
            } else {
                // 把 3 夸脱水壶的水倒入 5 夸脱水壶
                int pour = Math.min(jug3, 5 - jug5);
                jug3 -= pour;
                jug5 += pour;
                System.out.println("将 3 夸脱水壶中的 " + pour + " 夸脱水倒入 5 夸脱的水壶");
            }
        }
        System.out.println("5 夸脱的水壶中现在有 4 夸脱水");
    }
}    