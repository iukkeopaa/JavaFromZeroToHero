package MyCollections;

import java.util.HashSet;
import java.util.Set;

//小红有一个大小为
//n
//×
//m
//n×m 的棋盘，'.' 表示这个格子没有棋子，'X' 表示这个格子有棋子。
//第
//i
//i 行第
//j
//j 列的格子可以用一个坐标
//(
//i
//,
//j
//)
//(i,j) 表示。
//小红想选出四个棋子，对应坐标分别为
//(
//x
//1
//,
//y
//1
//)
//,
//(
//x
//2
//,
//y
//2
//)
//,
//(
//x
//3
//,
//y
//3
//)
//,
//(
//x
//4
//,
//y
//4
//)
//(x
//1
//?
// ,y
//1
//?
// ),(x
//2
//?
// ,y
//2
//?
// ),(x
//3
//?
// ,y
//3
//?
// ),(x
//4
//?
// ,y
//4
//?
// )，使得这四个坐标构成一个正方形，小红有多少种方案。
class ChessboardSquareCount {
    public static int countSquares(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> points = new HashSet<>();

        // 找出所有有棋子的格子的坐标
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    points.add(i + "," + j);
                }
            }
        }

        int count = 0;
        // 枚举两个点作为正方形的一条边
        for (String p1Str : points) {
            String[] p1Arr = p1Str.split(",");
            int x1 = Integer.parseInt(p1Arr[0]);
            int y1 = Integer.parseInt(p1Arr[1]);
            for (String p2Str : points) {
                if (p1Str.equals(p2Str)) continue;
                String[] p2Arr = p2Str.split(",");
                int x2 = Integer.parseInt(p2Arr[0]);
                int y2 = Integer.parseInt(p2Arr[1]);

                // 计算另外两个点的坐标
                int dx = x2 - x1;
                int dy = y2 - y1;
                String p3Str = (x1 - dy) + "," + (y1 + dx);
                String p4Str = (x2 - dy) + "," + (y2 + dx);

                // 检查另外两个点是否存在棋子
                if (points.contains(p3Str) && points.contains(p4Str)) {
                    count++;
                }

                // 考虑另一种可能的正方形方向
                p3Str = (x1 + dy) + "," + (y1 - dx);
                p4Str = (x2 + dy) + "," + (y2 - dx);
                if (points.contains(p3Str) && points.contains(p4Str)) {
                    count++;
                }
            }
        }

        // 由于每个正方形被重复计算了 4 次，所以要除以 4
        return count / 4;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', 'X', '.'},
                {'X', '.', 'X'},
                {'.', 'X', '.'}
        };
        System.out.println("正方形的数量: " + countSquares(board));
    }
}    