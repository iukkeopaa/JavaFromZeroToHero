package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

public class FindDuplicateElement {
    public static int findDuplicate(int[] arr) {
        int n = 1000;
        // 计算 1 到 1000 的和
        int sumOfOneToThousand = (n * (n + 1)) / 2;
        int sumOfArray = 0;
        // 计算数组元素的和
        for (int num : arr) {
            sumOfArray += num;
        }
        // 差值即为重复元素
        return sumOfArray - sumOfOneToThousand;
    }

    public static void main(String[] args) {
        int[] arr = new int[1001];
        // 初始化数组，假设重复元素为 500
        for (int i = 0; i < 1000; i++) {
            arr[i] = i + 1;
        }
        arr[1000] = 500;

        int duplicate = findDuplicate(arr);
        System.out.println("唯一重复的元素是: " + duplicate);
    }
}    