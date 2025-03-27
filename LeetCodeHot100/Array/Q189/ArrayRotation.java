package Array.Q189;

public class ArrayRotation {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //使用临时数组
    public void rotate2(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    //技巧性
    public void rotate3(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse1(nums, 0, length - 1);//先反转全部的元素
        reverse1(nums, 0, k - 1);//在反转前k个元素
        reverse1(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate4(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse1(nums, 0, length - k - 1);//先反转前面的
        reverse1(nums, length - k, length - 1);//接着反转后面k个
        reverse1(nums, 0, length - 1);//最后在反转全部的元素
    }



    //当 n 和 k 的最大公约数 等于 1 的时候：1 次遍历就可以完成交换；比如 n=5,k=3
    //当 n 和 k 的最大公约数 不等于 1 的时候：1 次遍历是无法完成的所有元素归位，需要 m (最大公约数) 次


    public static void rotate5(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                //如果访问过，再次访问的话，会出现原地打转的现象，
                //不能再访问当前元素了，我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                //把当前值保存在下一个位置，保存之前要把下一个位置的
                //值给记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }




    public void rotate6(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for(int start = 0; count < len; start++) {
            int cur = start;       // 从0位置开始换位子
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人

        }
    }



    public static void main(String[] args) {
        //第一种情况

//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
        //第二种情况
        int[] mums1={1,2,3,4,5,6};
        int k1=4;
//        rotate5(nums, k);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
        rotate5(mums1,k1);
        for (int num : mums1){
            System.out.print(num+" ");
        }
    }
}    