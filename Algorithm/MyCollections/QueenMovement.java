package MyCollections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y, steps;

    Node(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}

public class QueenMovement {
    public static int minSteps(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        // ��������յ��Ƿ�Ϊ�ϰ���
        if (board[0][0] == 1 || board[n - 1][m - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {0, 1}, {1, 1}};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int steps = current.steps;

            // �����յ�
            if (x == n - 1 && y == m - 1) {
                return steps;
            }

            // ���������ƶ���ʽ
            for (int[] dir : directions) {
                for (int k = 1; ; k++) {
                    int newX = x + k * dir[0];
                    int newY = y + k * dir[1];

                    // ����Ƿ�Խ��������ϰ���
                    if (newX >= n || newY >= m || board[newX][newY] == 1) {
                        break;
                    }

                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new Node(newX, newY, steps + 1));
                    }
                }
            }
        }

        return -1; // �޷������յ�
    }

    public static int minMoves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        // ����һ����ά�������洢�����Ͻǵ�ÿ�����ӵ����ٲ���
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // ��ʼ�����ϽǵĲ���Ϊ0
        dp[0][0] = 0;

        // ��ʼ����һ�к͵�һ�еĲ���
        for (int i = 1; i < n; i++) {
            if (board[i][0] == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                break;
            }
        }
        for (int j = 1; j < m; j++) {
            if (board[0][j] == 0) {
                dp[0][j] = dp[0][j - 1] + 1;
            } else {
                break;
            }
        }

        // ��䶯̬�滮����
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 0) {
                    if (dp[i - 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (dp[i][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                    int k = 1;
                    while (i - k >= 0 && j - k >= 0 && dp[i - k][j - k] != Integer.MAX_VALUE && board[i - k][j - k] == 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - k] + 1);
                        k++;
                    }
                }
            }
        }

        // ������½��޷��������-1
        return dp[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int result = minSteps(board);
        System.out.println("�����ƶ�����: " + result);
    }
}    