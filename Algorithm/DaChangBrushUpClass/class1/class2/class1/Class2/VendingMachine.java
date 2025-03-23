package DaChangBrushUpClass.class1.class2.class1.Class2;

//贩卖机只支持硬币支付，且收退都只支持10 ，50，100三种面额
//一次购买只能出一瓶可乐，且投钱和找零都遵循优先使用大钱的原则
//需要购买的可乐数量是m，其中手头拥有的10、50、100的数量分别为a、b、c，可乐的价格是x(x是10的倍数)
//请计算出需要投入硬币次数



//思路
//1.优先使用大面额的硬币购买可乐，直到可乐价格大于剩余硬币总额
//2.计算找零的硬币数量，优先使用大面额的硬币找零
//3.重复步骤1和2，直到购买完所有可乐或无法购买可乐
//4.如果无法购买完所有可乐，则返回-1
//5.如果购买完所有可乐，则返回投入硬币的总次数
public class VendingMachine {
    //参数
    //m:需要购买的可乐数量
    //a:10面额硬币的数量
    //b:50面额硬币的数量
    //c:100面额硬币的数量
    //x:可乐的价格
    //返回值：投入硬币的总次数
    public static int calculateCoinInsertions(int m, int a, int b, int c, int x) {
        int totalInsertions = 0;
        for (int i = 0; i < m; i++) {
            int remainingAmount = x;
            int[] coinCounts = {c, b, a};
            int[] coinValues = {100, 50, 10};

            for (int j = 0; j < coinValues.length; j++) {
                while (coinCounts[j] > 0 && remainingAmount >= coinValues[j]) {
                    remainingAmount -= coinValues[j];
                    coinCounts[j]--;
                    totalInsertions++;
                }
            }

            //思路：如果剩余金额大于0，说明无法购买可乐，返回-1
            //如果剩余金额小于0，说明需要找零，计算找零的硬币数量，并更新剩余金额为0
            //如果剩余金额等于0，说明购买可乐成功，继续购买下一瓶可乐

            if (remainingAmount > 0) {
                return -1; 
            }

            int change = 0;

            //思路：如果剩余金额小于0，说明需要找零，计算找零的硬币数量，并更新剩余金额为0
            if (remainingAmount < 0) {
                change = -remainingAmount;
            }

            //思路：计算找零的硬币数量，优先使用大面额的硬币找零
            //如果剩余金额小于0，说明需要找零，计算找零的硬币数量，并更新剩余金额为0
            //如果剩余金额等于0，说明购买可乐成功，继续购买下一瓶可乐
            //如果剩余金额大于0，说明无法购买可乐，返回-1
            //如果剩余金额小于0，说明需要找零，计算找零的硬币数量，并更新剩余金额为0
            //如果剩余金额等于0，说明购买可乐成功，继续购买下一瓶可乐
            //如果剩余金额大于0，说明无法购买可乐，返回-1

            for (int j = 0; j < coinValues.length; j++) {
                while (change >= coinValues[j]) {
                    change -= coinValues[j];
                }
            }
        }
        return totalInsertions;
    }
    public static int calculateCoinInputTimes(int m, int a, int b, int c, int x) {
        int totalTimes = 0;
        for (int i = 0; i < m; i++) {
            int remainingPrice = x;
            int[] coinCounts = {a, b, c};
            int[] coinValues = {100, 50, 10};
            int currentTimes = 0;

            for (int j = 0; j < coinValues.length; j++) {
                while (coinCounts[j] > 0 && remainingPrice >= coinValues[j]) {
                    remainingPrice -= coinValues[j];
                    coinCounts[j]--;
                    currentTimes++;
                }
            }

            if (remainingPrice > 0) {
                return -1;
            }

            totalTimes += currentTimes;
            a = coinCounts[2];
            b = coinCounts[1];
            c = coinCounts[0];
        }
        return totalTimes;
    }
    /*
     * 买饮料 时间限制： 3000MS 内存限制： 589824KB 题目描述：
     * 游游今年就要毕业了，和同学们在携程上定制了日本毕业旅行。愉快的一天行程结束后大家回到了酒店房间，这时候同学们都很口渴，
     * 石头剪刀布选出游游去楼下的自动贩卖机给大家买可乐。 贩卖机只支持硬币支付，且收退都只支持10 ，50，100
     * 三种面额。一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）
     * 游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。
     * 如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币次数？ 输入描述 依次输入， 需要可乐的数量为 m 10元的张数为 a 50元的张数为 b
     * 100元的张树为 c 1瓶可乐的价格为 x 输出描述 输出当前金额下需要投入硬币的次数
     * 例如需要购买2瓶可乐，每瓶可乐250圆，手里有100圆3枚，50圆4枚，10圆1枚。 购买第1瓶投递100圆3枚，找50圆 购买第2瓶投递50圆5枚
     * 所以是总共需要操作8次金额投递操作 样例输入 2 1 4 3 250 样例输出 8
     */

    // 暴力尝试，为了验证正式方法而已
    public static int right(int m, int a, int b, int c, int x) {
        int[] qian = { 100, 50, 10 };
        int[] zhang = { c, b, a };
        int puts = 0;
        while (m != 0) {
            int cur = buy(qian, zhang, x);
            if (cur == -1) {
                return -1;
            }
            puts += cur;
            m--;
        }
        return puts;
    }

    public static int buy(int[] qian, int[] zhang, int rest) {
        int first = -1;
        for (int i = 0; i < 3; i++) {
            if (zhang[i] != 0) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return -1;
        }
        if (qian[first] >= rest) {
            zhang[first]--;
            giveRest(qian, zhang, first + 1, qian[first] - rest, 1);
            return 1;
        } else {
            zhang[first]--;
            int next = buy(qian, zhang, rest - qian[first]);
            if (next == -1) {
                return -1;
            }
            return 1 + next;
        }
    }

    // 正式的方法
    // 要买的可乐数量，m
    // 100元有a张
    // 50元有b张
    // 10元有c张
    // 可乐单价x
    public static int putTimes(int m, int a, int b, int c, int x) {
        //              0    1   2
        int[] qian = { 100, 50, 10 };
        int[] zhang = { c,  b,  a };
        // 总共需要多少次投币
        int puts = 0;
        // 之前面值的钱还剩下多少总钱数
        int preQianRest = 0;
        // 之前面值的钱还剩下多少总张数
        int preQianZhang = 0;
        for (int i = 0; i < 3 && m != 0; i++) {
            // 要用之前剩下的钱、当前面值的钱，共同买第一瓶可乐
            // 之前的面值剩下多少钱，是preQianRest
            // 之前的面值剩下多少张，是preQianZhang
            // 之所以之前的面值会剩下来，一定是剩下的钱，一直攒不出一瓶可乐的单价
            // 当前的面值付出一些钱+之前剩下的钱，此时有可能凑出一瓶可乐来
            // 那么当前面值参与搞定第一瓶可乐，需要掏出多少张呢？就是curQianFirstBuyZhang
            //q/x向上取整
            int curQianFirstBuyZhang = (x - preQianRest + qian[i] - 1) / qian[i];
            if (zhang[i] >= curQianFirstBuyZhang) { // 如果之前的钱和当前面值的钱，能凑出第一瓶可乐
                // 凑出来了一瓶可乐也可能存在找钱的情况，
                giveRest(qian, zhang, i + 1, (preQianRest + qian[i] * curQianFirstBuyZhang) - x, 1);
                puts += curQianFirstBuyZhang + preQianZhang;
                zhang[i] -= curQianFirstBuyZhang;
                m--;
            } else { // 如果之前的钱和当前面值的钱，不能凑出第一瓶可乐
                preQianRest += qian[i] * zhang[i];
                preQianZhang += zhang[i];
                continue;
            }
            // 凑出第一瓶可乐之后，当前的面值有可能能继续买更多的可乐
            // 以下过程就是后续的可乐怎么用当前面值的钱来买
            // 用当前面值的钱，买一瓶可乐需要几张
            int curQianBuyOneColaZhang = (x + qian[i] - 1) / qian[i];
            // 用当前面值的钱，一共可以搞定几瓶可乐
            int curQianBuyColas = Math.min(zhang[i] / curQianBuyOneColaZhang, m);
            // 用当前面值的钱，每搞定一瓶可乐，收货机会吐出多少零钱
            int oneTimeRest = qian[i] * curQianBuyOneColaZhang - x;
            // 每次买一瓶可乐，吐出的找零总钱数是oneTimeRest
            // 一共买的可乐数是curQianBuyColas，所以把零钱去提升后面几种面值的硬币数，
            // 就是giveRest的含义
            giveRest(qian, zhang, i + 1, oneTimeRest, curQianBuyColas);
            // 当前面值去搞定可乐这件事，一共投了几次币
            puts += curQianBuyOneColaZhang * curQianBuyColas;
            // 还剩下多少瓶可乐需要去搞定，继续用后面的面值搞定去吧
            m -= curQianBuyColas;
            // 当前面值可能剩下若干张，要参与到后续买可乐的过程中去，
            // 所以要更新preQianRest和preQianZhang
            zhang[i] -= curQianBuyOneColaZhang * curQianBuyColas;
            preQianRest = qian[i] * zhang[i];
            preQianZhang = zhang[i];
        }
        return m == 0 ? puts : -1;
    }

    public static void giveRest(int[] qian, int[] zhang, int i, int oneTimeRest, int times) {
        for (; i < 3; i++) {
            zhang[i] += (oneTimeRest / qian[i]) * times;
            oneTimeRest %= qian[i];
        }
    }


    public static void main(String[] args) {
        int m = 2; 
        int a = 5; 
        int b = 3; 
        int c = 2; 
        int x = 120; 

        int result = calculateCoinInputTimes(m, a, b, c, x);
        if (result == -1) {
            System.out.println("无法完成购买");
        } else {
            System.out.println("需要投入硬币的次数: " + result);
        }
    }
}    