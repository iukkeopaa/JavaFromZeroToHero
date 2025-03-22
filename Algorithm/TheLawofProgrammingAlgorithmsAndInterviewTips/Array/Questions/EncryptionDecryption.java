package TheLawofProgrammingAlgorithmsAndInterviewTips.Array.Questions;

import java.util.*;

public class EncryptionDecryption {

    // 加密方法
    public static int[] encrypt(int[] original) {
        int n = original.length;
        int k = 3 * n; // 这里选择 k = 3n，满足 k ≤ 15n
        int[] encrypted = new int[k];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int num = original[i];
            // 将一个 8 位整数拆分成三个部分
            int part1 = num & 0x3F; // 低 6 位
            int part2 = (num >> 6) & 0x03; // 中间 2 位
            int part3 = (num >> 8) & 0x01; // 高 1 位

            // 将拆分后的部分放入加密数组
            encrypted[3 * i] = part1;
            encrypted[3 * i + 1] = part2;
            encrypted[3 * i + 2] = part3;
        }

        // 打乱加密数组的顺序
        for (int i = k - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = encrypted[i];
            encrypted[i] = encrypted[j];
            encrypted[j] = temp;
        }

        return encrypted;
    }

    // 解密方法
    public static int[] decrypt(int[] encrypted, int n) {
        int k = encrypted.length;
        int[][] mapping = new int[n][3];

        // 构建映射表，记录每个部分的位置
        for (int i = 0; i < k; i++) {
            int index = i % n;
            int partIndex = i / n;
            mapping[index][partIndex] = encrypted[i];
        }

        int[] decrypted = new int[n];
        for (int i = 0; i < n; i++) {
            int part1 = mapping[i][0];
            int part2 = mapping[i][1];
            int part3 = mapping[i][2];

            // 组合拆分后的部分，恢复原整数
            int num = (part3 << 8) | (part2 << 6) | part1;
            decrypted[i] = num;
        }

        return decrypted;
    }

    public static void main(String[] args) {
        int[] original = {123, 45, 67};
        int n = original.length;

        // 加密
        int[] encrypted = encrypt(original);
        System.out.println("Encrypted: " + Arrays.toString(encrypted));

        // 解密
        int[] decrypted = decrypt(encrypted, n);
        System.out.println("Decrypted: " + Arrays.toString(decrypted));
    }
}    