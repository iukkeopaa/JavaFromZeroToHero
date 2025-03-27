package DaChangBrushUpClass.Class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

//给定数组hard和money，长度都为N，hard[i]表示i号工作的难度， money[i]表示i号工作的收入
//给定数组ability，长度都为M，ability[j]表示j号人的能力，每一号工作，都可以提供无数的岗位，难度和收入都一样
//但是人的能力必须>=这份工作的难度，才能上班。返回一个长度为M的数组ans，ans[j]表示j号人能获得的最好收入


//1. 首先将工作按照难度排序，如果难度相同则收入高的排在前面
//2. 然后使用 TreeMap 来存储每个难度对应的最大收入，如果当前难度对应的收入小于上一个难度对应的收入，则更新为上一个难度对应的收入
//3. 最后遍历每个人的能力，找到最接近他能力的工作，然后获取该工作的最大收入，即为他的最好收入

public class JobIncomeCalculation {
    public static int[] bestIncome(int[] hard, int[] money, int[] ability) {
        int N = hard.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 将工作难度和收入存入 TreeMap 中
        //coding技巧
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(hard[i])) {
                map.put(hard[i], money[i]);
            } else {
                //如果当前难度对应的收入小于上一个难度对应的收入，则更新为上一个难度对应的收入
                map.put(hard[i], Math.max(map.get(hard[i]), money[i]));
            }
        }
        int pre = 0;
        // 处理 TreeMap，确保每个难度对应的收入是当前难度及以下的最大收入
        for (int key : map.keySet()) {
            if (pre > map.get(key)) {
                map.put(key, pre);
            } else {
                pre = map.get(key);
            }
        }
        //=====================
        int M = ability.length;
        int[] ans = new int[M];
        // 计算每个人能获得的最好收入
        for (int j = 0; j < M; j++) {
            Integer key = map.floorKey(ability[j]);
            ans[j] = key != null ? map.get(key) : 0;
        }
        return ans;
    }

    public static class Job {
        public int money;
        public int hard;

        public Job(int m, int h) {
            money = m;
            hard = h;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }

    public static int[] getMoneys(Job[] job, int[] ability) {
        Arrays.sort(job, new JobComparator());
        // key : 难度   value：报酬
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        // pre : 上一份进入map的工作
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            // ability[i] 当前人的能力 <= ability[i]  且离它最近的
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] hard = {2, 4, 6, 8};
        int[] money = {10, 20, 30, 40};
        int[] ability = {3, 5, 7, 9};
        int[] ans = bestIncome(hard, money, ability);
        System.out.println(Arrays.toString(ans));
    }
}    