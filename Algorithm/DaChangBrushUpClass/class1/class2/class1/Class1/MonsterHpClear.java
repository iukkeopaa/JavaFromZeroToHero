package DaChangBrushUpClass.class1.class2.class1.Class1;

//给定两个非负数组x和hp，长度都是N，再给定一个正数range
//x有序，x[i]表示i号怪兽在x轴上的位置
//hp[i]表示i号怪兽的血量
//再给定一个正数range，表示如果法师释放技能的范围长度
//被打到的每只怪兽损失1点血量。返回要把所有怪兽血量清空，至少需要释放多少次AOE技能？


//线段树解法
public class MonsterHpClear {

    public static int minAOECount(int[] x, int[] hp, int range) {
        int n = x.length;
        int[] cover = new int[n];
        int right = 0;
        // 计算每个位置能覆盖到的最右怪兽
        for (int i = 0; i < n; i++) {
            while (right < n && x[right] - x[i] <= range) {
                right++;
            }
            cover[i] = right - 1;
        }
        int ans = 0;
        int[] add = new int[n];
        int[] minus = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += add[i];
            int currentHp = hp[i] - sum;
            if (currentHp > 0) {
                ans += currentHp;
                sum += currentHp;
                minus[cover[i]] += currentHp;
            }
            sum -= minus[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 5, 7, 9};
        int[] hp = {2, 3, 4, 2, 1};
        int range = 2;
        System.out.println("至少需要释放 AOE 技能的次数: " + minAOECount(x, hp, range));
    }
}    