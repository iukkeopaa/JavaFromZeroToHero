package TheLawofProgrammingAlgorithmsAndInterviewTips.String.Questions;

import java.util.*;

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}

public class StringSetUnion {
    public static List<Set<String>> mergeSets(List<Set<String>> sets) {
        int n = sets.size();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (String str : sets.get(i)) {
                    if (sets.get(j).contains(str)) {
                        uf.union(i, j);
                        break;
                    }
                }
            }
        }

        Map<Integer, Set<String>> merged = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            merged.computeIfAbsent(root, k -> new HashSet<>()).addAll(sets.get(i));
        }

        return new ArrayList<>(merged.values());
    }

    public static void main(String[] args) {
        List<Set<String>> sets = new ArrayList<>();
        sets.add(new HashSet<>(Arrays.asList("aaa", "bbb", "ccc")));
        sets.add(new HashSet<>(Arrays.asList("bbb", "ddd")));
        sets.add(new HashSet<>(Arrays.asList("eee", "fff")));
        sets.add(new HashSet<>(Arrays.asList("ggg")));
        sets.add(new HashSet<>(Arrays.asList("ddd", "hhh")));

        List<Set<String>> result = mergeSets(sets);
        for (Set<String> set : result) {
            System.out.println(set);
        }
    }
}    