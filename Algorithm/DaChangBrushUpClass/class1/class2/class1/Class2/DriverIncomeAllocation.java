package DaChangBrushUpClass.class1.class2.class1.Class2;

import java.util.Arrays;

//现有司机N*2人，调度中心会将所有司机平分给A、B两区域，i号司机去A可得收入为income[i][0]，去B可得收入为income[i][1]
//返回能使所有司机总收入最高的方案是多少钱?

//思路：将司机按照去A区域和去B区域的收入差值进行排序，然后依次分配到A或B区域，直到每个区域都有一半的司机为止。
//最后计算所有司机的总收入。


//我们以 income = {{10, 20}, {30, 200}, {400, 50}, {30, 20}} 这个例子详细解释上述代码的执行过程。这里有 N * 2 = 4 个司机（即 N = 2），需要将他们平分到 A、B 两个区域。
//步骤 1：计算每个司机去 A 区域和去 B 区域的收入差值
//代码中创建了一个二维数组 diff 来存储每个司机的编号和对应的收入差值。对于每个司机 i，diff[i][0] 存储司机编号，diff[i][1] 存储去 A 区域和去 B 区域的收入差值（即 income[i][0] - income[i][1]）。
//对于第 0 个司机，income[0][0] = 10，income[0][1] = 20，差值为 10 - 20 = -10。
//对于第 1 个司机，income[1][0] = 30，income[1][1] = 200，差值为 30 - 200 = -170。
//对于第 2 个司机，income[2][0] = 400，income[2][1] = 50，差值为 400 - 50 = 350。
//对于第 3 个司机，income[3][0] = 30，income[3][1] = 20，差值为 30 - 20 = 10。
//此时 diff 数组为 {{0, -10}, {1, -170}, {2, 350}, {3, 10}}。
//步骤 2：按照收入差值进行排序
//按照收入差值对 diff 数组进行降序排序。排序后 diff 数组变为 {{2, 350}, {3, 10}, {0, -10}, {1, -170}}。这样排序的目的是优先将去 A 区域比去 B 区域收入高更多的司机分配到 A 区域。
//步骤 3：分配司机并计算总收入
//因为要将 4 个司机平分到 A、B 两个区域，所以前 2 个司机去 A 区域，后 2 个司机去 B 区域。
//前 2 个司机去 A 区域：
//第 2 个司机去 A 区域，收入为 income[2][0] = 400。
//第 3 个司机去 A 区域，收入为 income[3][0] = 30。
//后 2 个司机去 B 区域：
//第 0 个司机去 B 区域，收入为 income[0][1] = 20。
//第 1 个司机去 B 区域，收入为 income[1][1] = 200。
//步骤 4：计算最终总收入
//将所有司机的收入相加：400 + 30 + 20 + 200 = 650。
public class DriverIncomeAllocation {
    public static int maxTotalIncome(int[][] income) {
        int n = income.length;
        int[][] diff = new int[n][2];

        // 计算每个司机去A区域和去B区域的收入差值
        for (int i = 0; i < n; i++) {
            diff[i][0] = i;
            diff[i][1] = income[i][0] - income[i][1];
        }

        // 按照收入差值进行排序
        Arrays.sort(diff, (a, b) -> b[1] - a[1]);

        int totalIncome = 0;
        int countA = 0;
        int countB = 0;
        int half = n / 2;

        // 分配司机到A和B区域
        for (int[] d : diff) {
            int index = d[0];
            if (countA < half) {
                totalIncome += income[index][0];
                countA++;
            } else {
                totalIncome += income[index][1];
                countB++;
            }
        }

        return totalIncome;
    }

    public static void main(String[] args) {
        int[][] income = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        System.out.println("能使所有司机总收入最高的方案是: " + maxTotalIncome(income));
    }
}    