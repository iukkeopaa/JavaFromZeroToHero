package MyCollections;

import java.util.HashSet;
import java.util.Set;

//С����һ����СΪ
//n
//��
//m
//n��m �����̣�'.' ��ʾ�������û�����ӣ�'X' ��ʾ������������ӡ�
//��
//i
//i �е�
//j
//j �еĸ��ӿ�����һ������
//(
//i
//,
//j
//)
//(i,j) ��ʾ��
//С����ѡ���ĸ����ӣ���Ӧ����ֱ�Ϊ
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
// )��ʹ�����ĸ����깹��һ�������Σ�С���ж����ַ�����
class ChessboardSquareCount {
    public static int countSquares(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> points = new HashSet<>();

        // �ҳ����������ӵĸ��ӵ�����
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    points.add(i + "," + j);
                }
            }
        }

        int count = 0;
        // ö����������Ϊ�����ε�һ����
        for (String p1Str : points) {
            String[] p1Arr = p1Str.split(",");
            int x1 = Integer.parseInt(p1Arr[0]);
            int y1 = Integer.parseInt(p1Arr[1]);
            for (String p2Str : points) {
                if (p1Str.equals(p2Str)) continue;
                String[] p2Arr = p2Str.split(",");
                int x2 = Integer.parseInt(p2Arr[0]);
                int y2 = Integer.parseInt(p2Arr[1]);

                // �������������������
                int dx = x2 - x1;
                int dy = y2 - y1;
                String p3Str = (x1 - dy) + "," + (y1 + dx);
                String p4Str = (x2 - dy) + "," + (y2 + dx);

                // ��������������Ƿ��������
                if (points.contains(p3Str) && points.contains(p4Str)) {
                    count++;
                }

                // ������һ�ֿ��ܵ������η���
                p3Str = (x1 + dy) + "," + (y1 - dx);
                p4Str = (x2 + dy) + "," + (y2 - dx);
                if (points.contains(p3Str) && points.contains(p4Str)) {
                    count++;
                }
            }
        }

        // ����ÿ�������α��ظ������� 4 �Σ�����Ҫ���� 4
        return count / 4;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', 'X', '.'},
                {'X', '.', 'X'},
                {'.', 'X', '.'}
        };
        System.out.println("�����ε�����: " + countSquares(board));
    }
}    