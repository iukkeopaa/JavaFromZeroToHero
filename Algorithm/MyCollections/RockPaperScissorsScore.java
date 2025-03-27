package MyCollections;

import java.util.ArrayList;
import java.util.List;

//����ʯͷ����һ�ֳ����Ĳ�ȭ��Ϸ�����������Ϊ����ʱ�����Ĺ������£���ÿһ���У�˫���ֱ�ͬʱ����ʯͷ��Rock����������Scissor���Ͳ���Paper�������������е�һ�֡�ʯͷսʤ����������սʤ������սʤʯͷ����˫������������һ������ƽ�֣�˫���������䣻����ʤ����1�֡�
//����Alice��Bob����������ֲ�ȭ��Ϸ�������ǲ������ֽ�����Ϸ�����Ǿ����ֱ���ֽ��д������ÿһ��Ҫ�������ơ���Ϊ���е�����Ҫ����������д�µ������ж����ǵıȷ��Ƕ��١�

//��������1
//3
//Rock Rock Rock
//Rock Paper Scissor
public class RockPaperScissorsScore {

    public static int[] calculateScores(List<String> aliceMoves, List<String> bobMoves) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < aliceMoves.size(); i++) {
            String aliceMove = aliceMoves.get(i);
            String bobMove = bobMoves.get(i);

            if (aliceMove.equals(bobMove)) {
                continue;
            } else if ((aliceMove.equals("Rock") && bobMove.equals("Scissor")) ||
                    (aliceMove.equals("Scissor") && bobMove.equals("Paper")) ||
                    (aliceMove.equals("Paper") && bobMove.equals("Rock"))) {
                aliceScore++;
            } else {
                bobScore++;
            }
        }

        return new int[]{aliceScore, bobScore};
    }

    public static void main(String[] args) {
        List<String> aliceMoves = new ArrayList<>();
        aliceMoves.add("Rock");
        aliceMoves.add("Scissor");
        aliceMoves.add("Paper");

        List<String> bobMoves = new ArrayList<>();
        bobMoves.add("Scissor");
        bobMoves.add("Paper");
        bobMoves.add("Rock");

        int[] scores = calculateScores(aliceMoves, bobMoves);
        System.out.println("Alice �ķ���: " + scores[0]);
        System.out.println("Bob �ķ���: " + scores[1]);
    }
}    