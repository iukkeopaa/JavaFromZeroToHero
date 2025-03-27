package MyCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//题目内容
//小美有一个结点总数为 n 且根节点编号为 1 的有根树。
//第i个结点的编号为讠,所携带的字母为 4。
//小美是一名程序员,她认为一对(“,υ)是好对,当且仅当从节点u 到节点υ的简单路径上依次拼接得到字符串 S 的子序
//列中不存在"BUG"。
//美会提出q次询问,你需要帮助她回答(u,v)是不是好对。
//子序列:子序列是原始序列的一个子集，其元素顺序保持不变，但可以选择性地删除一些元素。换句话说，子序列是从原
//始序列中挑选出来的元素集合，这些元素在原始序列中的相对顺序保持一致。
//例如:S = BAUCDEG,"BUG"为字符串 S 的一个子序列,但"BG A"不是 S 的子序列。
//输入描述
//第一行两个整数 n,q(3 < n,q ≤ 10”),分别表示节点个数和询问次数。
//第二行几个整数,第i个为 fatheri(1 < father <i-1),表示第讠个节点的父节点,特别的 father1 =0。
//第三行 n 个字母,第i个为 a?('A'≤ a: <'2’),表示第i个节点所携带的字母。
//接下来 q行,每行两个墪数 “, υ(1 ≤ u ≠≤ n),表示询问的起点和终点。
public class TreeQuery {
    static int n, q;
    static List<List<Integer>> tree;
    static char[] nodeLetters;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        int[] fathers = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            fathers[i] = scanner.nextInt();
            tree.get(fathers[i]).add(i);
        }

        String letters = scanner.next();
        nodeLetters = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeLetters[i] = letters.charAt(i - 1);
        }

        for (int i = 0; i < q; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            boolean isGoodPair = checkPath(u, v);
            System.out.println(isGoodPair? "Yes" : "No");
        }
        scanner.close();
    }

    static boolean checkPath(int u, int v) {
        List<Integer> path = findPath(u, v);
        StringBuilder pathString = new StringBuilder();
        for (int node : path) {
            pathString.append(nodeLetters[node]);
        }
        return!hasSubsequence(pathString.toString(), "BUG");
    }

    static List<Integer> findPath(int u, int v) {
        List<Integer> pathU = new ArrayList<>();
        List<Integer> pathV = new ArrayList<>();
        findPathToRoot(u, pathU);
        findPathToRoot(v, pathV);

        int i = pathU.size() - 1;
        int j = pathV.size() - 1;
        while (i >= 0 && j >= 0 && pathU.get(i).equals(pathV.get(j))) {
            i--;
            j--;
        }

        List<Integer> result = new ArrayList<>();
        for (int k = 0; k <= i; k++) {
            result.add(pathU.get(k));
        }
        for (int k = j; k >= 0; k--) {
            result.add(pathV.get(k));
        }
        return result;
    }

    static void findPathToRoot(int node, List<Integer> path) {
        while (node != 0) {
            path.add(node);
            for (List<Integer> subTree : tree) {
                if (subTree.contains(node)) {
                    node = tree.indexOf(subTree);
                    break;
                }
            }
        }
    }

    static boolean hasSubsequence(String s, String sub) {
        int i = 0, j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}    