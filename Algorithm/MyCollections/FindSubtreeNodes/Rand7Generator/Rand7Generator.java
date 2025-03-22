package MyCollections.FindSubtreeNodes.Rand7Generator;

public class Rand7Generator {

    // 假设已经有 rand3 函数
    public static int rand3() {
        // 这里应该是真实的 rand3 实现，暂时简单模拟
        return (int) (Math.random() * 3) + 1;
    }

    public static int rand7() {
        while (true) {
            int num = (rand3() - 1) * 3 + rand3();
            if (num <= 7) {
                return num;
            }
        }
    }

    public static void main(String[] args) {
        // 测试 rand7 函数
        for (int i = 0; i < 10; i++) {
            System.out.println(rand7());
        }
    }
}    