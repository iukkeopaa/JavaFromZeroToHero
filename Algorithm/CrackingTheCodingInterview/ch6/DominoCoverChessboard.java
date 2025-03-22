package CrackingTheCodingInterview.ch6;

public class DominoCoverChessboard {
    public static void main(String[] args) {
        boolean canCover = canCoverBoard();
        if (canCover) {
            System.out.println("31块多米诺骨牌可以盖住整个棋盘。");
        } else {
            System.out.println("31块多米诺骨牌不能盖住整个棋盘。");
        }
    }

    public static boolean canCoverBoard() {
        // 假设棋盘黑白格数量
        int black = 30;
        int white = 32;

        // 多米诺骨牌覆盖的黑白格数量
        int dominoBlack = 31;
        int dominoWhite = 31;

        return black == dominoBlack && white == dominoWhite;
    }
}    