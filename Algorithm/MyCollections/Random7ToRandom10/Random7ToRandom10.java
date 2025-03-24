package MyCollections.FindSubtreeNodes.Random7ToRandom10;

public class Random7ToRandom10 {

    // 假设这是已经实现的 random7 函数
    public static int random7() {
        return (int) (Math.random() * 7) + 1;
    }

    public static int random10() {
        int row, col, idx;
        do {
            row = random7();
            col = random7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public static void main(String[] args) {
        // 测试 random10 函数
        for (int i = 0; i < 10; i++) {
            System.out.println(random10());
        }
    }
}    