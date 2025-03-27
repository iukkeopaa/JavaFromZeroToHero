package DaChangBrushUpClass.class1;

public class CordCoverMaxPoint1 {

    public static int maxCoverPoints(int[] arr,int l){
        if(arr.length == 0 || l<0|| arr == null){
            return 0;

        }

        int max=0;
        for(int i=0;i<arr.length;i++){
            int left=i;
            int right=arr.length-1;
            while(left<right){
                int mid=left+((right-left)>>1);

                if (arr[mid]-arr[i]<=l){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            max=Math.max(max,left-i+1);
        }
    return max;
    }


    public static void main(String[] args) {
        //  Scanner scanner = new Scanner(System.in);
        //
        //        // 提示用户输入有序数组，以逗号分隔
        //        System.out.println("请输入有序数组，元素之间用逗号分隔（例如：1,3,4,7,13,16,17）：");
        //        String inputArray = scanner.nextLine();
        //        String[] strArray = inputArray.split(",");
        //        int[] arr = new int[strArray.length];
        //        for (int i = 0; i < strArray.length; i++) {
        //            arr[i] = Integer.parseInt(strArray[i]);
        //        }
        //
        //        // 提示用户输入绳子长度
        //        System.out.println("请输入绳子的长度：");
        //        int k = scanner.nextInt();
        //
        //        // 计算并输出结果
        //        int result = maxCover(arr, k);
        //        System.out.println("绳子最多能覆盖的点数为：" + result);
        //
        //        scanner.close();
        int[] arr={1, 3, 4, 7, 13, 16, 1};
        int l=4;
        int maxCoverPoints = maxCoverPoints(arr, l);
        System.out.println(maxCoverPoints);
    }
}
