package DaChangBrushUpClass.class1.class2.class1.Class1;

//给定一个非负整数num，如何不用循环语句，返回>=num，并且离num最近的，2的某次方
public class Near2Power {
    public static int nextPowerOfTwo(int num) {
        if (num == 0) {
            return 1;
        }
        // -- 的目的是为了兼容本来就是2的幂的情况
        num--;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        num++;
        return num;
    }

    //将最高位1后面的所有0变为1
    public static int test(int num){
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        return num;
    }

    public static final int tableSizeFor(int n) {

        // n=13
        //二进制为001101
        //n--  = 001100
        //跑这一堆代码变为 001111
        // n++ = 010000


        //exp2
        //n=16 10000
        //n-1 = 01111
        //跑一大堆代码变为01111
        //n++ = 10000
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
        System.out.println("大于等于 " + num + " 的最近的 2 的幂是: " + nextPowerOfTwo(num));
    }



}
