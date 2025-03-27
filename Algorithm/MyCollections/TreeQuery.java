package MyCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//��Ŀ����
//С����һ���������Ϊ n �Ҹ��ڵ���Ϊ 1 ���и�����
//��i�����ı��Ϊڥ,��Я������ĸΪ 4��
//С����һ������Ա,����Ϊһ��(��,��)�Ǻö�,���ҽ����ӽڵ�u ���ڵ�Եļ�·��������ƴ�ӵõ��ַ��� S ������
//���в�����"BUG"��
//�������q��ѯ��,����Ҫ�������ش�(u,v)�ǲ��Ǻöԡ�
//������:��������ԭʼ���е�һ���Ӽ�����Ԫ��˳�򱣳ֲ��䣬������ѡ���Ե�ɾ��һЩԪ�ء����仰˵���������Ǵ�ԭ
//ʼ��������ѡ������Ԫ�ؼ��ϣ���ЩԪ����ԭʼ�����е����˳�򱣳�һ�¡�
//����:S = BAUCDEG,"BUG"Ϊ�ַ��� S ��һ��������,��"BG A"���� S �������С�
//��������
//��һ���������� n,q(3 < n,q �� 10��),�ֱ��ʾ�ڵ������ѯ�ʴ�����
//�ڶ��м�������,��i��Ϊ fatheri(1 < father <i-1),��ʾ��ڥ���ڵ�ĸ��ڵ�,�ر�� father1 =0��
//������ n ����ĸ,��i��Ϊ a?('A'�� a: <'2��),��ʾ��i���ڵ���Я������ĸ��
//������ q��,ÿ���������� ��, ��(1 �� u �١� n),��ʾѯ�ʵ������յ㡣
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