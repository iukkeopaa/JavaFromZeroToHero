package MyCollections;

//在一个3*3的棋盘上，小红和小紫正在玩“夹吃棋”。
//所谓“夹吃棋”，即如果存在一个白子，它的两侧（横向或者纵向）相邻都是黑子，则这个棋子将被“夹吃”；对于黑棋亦然。
//如果一个棋盘的局面没有一方被夹吃，或者黑白双方都被对面夹吃，则认为是平局。如果只有一方夹吃了另一方，则认为夹吃方赢，被夹吃方输。
public class SandwichChessGame {
    // 定义棋盘上的棋子状态，0 表示空位，1 表示黑子，2 表示白子
    private static final int EMPTY = 0;
    private static final int BLACK = 1;
    private static final int WHITE = 2;

    // 检查是否有棋子被夹吃
    private static int checkCapture(int[][] board) {
        int blackCaptured = 0;
        int whiteCaptured = 0;

        // 检查横向夹吃
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 2; j++) {
                if (board[i][j] == BLACK && board[i][j - 1] == WHITE && board[i][j + 1] == WHITE) {
                    blackCaptured++;
                } else if (board[i][j] == WHITE && board[i][j - 1] == BLACK && board[i][j + 1] == BLACK) {
                    whiteCaptured++;
                }
            }
        }

        // 检查纵向夹吃
        for (int j = 0; j < 3; j++) {
            for (int i = 1; i < 2; i++) {
                if (board[i][j] == BLACK && board[i - 1][j] == WHITE && board[i + 1][j] == WHITE) {
                    blackCaptured++;
                } else if (board[i][j] == WHITE && board[i - 1][j] == BLACK && board[i + 1][j] == BLACK) {
                    whiteCaptured++;
                }
            }
        }

        if (blackCaptured > 0 && whiteCaptured == 0) {
            return BLACK;
        } else if (whiteCaptured > 0 && blackCaptured == 0) {
            return WHITE;
        } else {
            return EMPTY;
        }
    }

    // 主方法，用于测试棋盘局面
    public static void main(String[] args) {
        int[][] board = {
                {BLACK, WHITE, BLACK},
                {WHITE, BLACK, WHITE},
                {BLACK, WHITE, BLACK}
        };

        int result = checkCapture(board);
        if (result == EMPTY) {
            System.out.println("平局");
        } else if (result == BLACK) {
            System.out.println("黑子赢");
        } else {
            System.out.println("白子赢");
        }
    }
}    