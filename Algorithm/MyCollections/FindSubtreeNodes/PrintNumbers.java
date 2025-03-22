package MyCollections.FindSubtreeNodes;

//打印 0~9，用递归和迭代两种方式实现
public class PrintNumbers {

    // 迭代方式
    public static void printIteratively() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    // 递归方式
    public static void printRecursively(int num) {
        if (num < 10) {
            System.out.println(num);
            printRecursively(num + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("迭代方式打印 0 到 9:");
        printIteratively();

        System.out.println("\n递归方式打印 0 到 9:");
        printRecursively(0);
    }
}    