package MyCollections;

//��һ��3*3�������ϣ�С���С�������桰�г��塱��
//��ν���г��塱�����������һ�����ӣ��������ࣨ��������������ڶ��Ǻ��ӣ���������ӽ������гԡ������ں�����Ȼ��
//���һ�����̵ľ���û��һ�����гԣ����ߺڰ�˫����������гԣ�����Ϊ��ƽ�֡����ֻ��һ���г�����һ��������Ϊ�гԷ�Ӯ�����гԷ��䡣
public class SandwichChessGame {
    // ���������ϵ�����״̬��0 ��ʾ��λ��1 ��ʾ���ӣ�2 ��ʾ����
    private static final int EMPTY = 0;
    private static final int BLACK = 1;
    private static final int WHITE = 2;

    // ����Ƿ������ӱ��г�
    private static int checkCapture(int[][] board) {
        int blackCaptured = 0;
        int whiteCaptured = 0;

        // ������г�
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 2; j++) {
                if (board[i][j] == BLACK && board[i][j - 1] == WHITE && board[i][j + 1] == WHITE) {
                    blackCaptured++;
                } else if (board[i][j] == WHITE && board[i][j - 1] == BLACK && board[i][j + 1] == BLACK) {
                    whiteCaptured++;
                }
            }
        }

        // �������г�
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

    // �����������ڲ������̾���
    public static void main(String[] args) {
        int[][] board = {
                {BLACK, WHITE, BLACK},
                {WHITE, BLACK, WHITE},
                {BLACK, WHITE, BLACK}
        };

        int result = checkCapture(board);
        if (result == EMPTY) {
            System.out.println("ƽ��");
        } else if (result == BLACK) {
            System.out.println("����Ӯ");
        } else {
            System.out.println("����Ӯ");
        }
    }
}    