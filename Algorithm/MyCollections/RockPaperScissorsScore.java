package MyCollections;

import java.util.ArrayList;
import java.util.List;

//剪刀石头布是一种常见的猜拳游戏，当玩家人数为两人时，它的规则如下：在每一轮中，双方分别同时给出石头（Rock）、剪刀（Scissor）和布（Paper）这三种手势中的一种。石头战胜剪刀；剪刀战胜布；布战胜石头。若双方给出的手势一样则本轮平局，双方分数不变；否则胜方积1分。
//现在Alice和Bob想进行若干轮猜拳游戏，但他们不想逐轮进行游戏，于是决定分别在纸上写下他们每一轮要出的手势。作为裁判的你需要根据他们所写下的手势判断他们的比分是多少。

//输入样例1
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
        System.out.println("Alice 的分数: " + scores[0]);
        System.out.println("Bob 的分数: " + scores[1]);
    }
}    