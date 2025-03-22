找 n 个人，m 个小组（每个人可以在多个小组中，也可以不在任何小组中），个人编号 0~n,
给一个人发通知，在同一个小组的人能收到通知传递，问给 0 号发通知，输出有多少人能收
到通知



```java
import java.util.ArrayList;
import java.util.List;

public class NoticePropagation {
    // 构建图的邻接表
    private static List<List<Integer>> buildGraph(int n, int[][] groups) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] group : groups) {
            for (int i = 0; i < group.length; i++) {
                for (int j = i + 1; j < group.length; j++) {
                    int person1 = group[i];
                    int person2 = group[j];
                    graph.get(person1).add(person2);
                    graph.get(person2).add(person1);
                }
            }
        }
        return graph;
    }

    // 深度优先搜索
    private static int dfs(int person, boolean[] visited, List<List<Integer>> graph) {
        visited[person] = true;
        int count = 1;
        for (int neighbor : graph.get(person)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, visited, graph);
            }
        }
        return count;
    }

    // 计算能收到通知的人数
    public static int countPeopleReceivingNotice(int n, int m, int[][] groups) {
        List<List<Integer>> graph = buildGraph(n, groups);
        boolean[] visited = new boolean[n];
        return dfs(0, visited, graph);
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        int[][] groups = {{0, 1, 2}, {2, 3, 4}};
        int result = countPeopleReceivingNotice(n, m, groups);
        System.out.println("能收到通知的人数为: " + result);
    }
}
```