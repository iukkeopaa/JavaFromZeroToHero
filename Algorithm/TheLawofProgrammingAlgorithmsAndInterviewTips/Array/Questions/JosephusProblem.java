package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.LinkedList;

public class JosephusProblem {
    public static int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int result = lastRemaining(n, m);
        System.out.println("最后剩下的数字是: " + result);
    }
}    