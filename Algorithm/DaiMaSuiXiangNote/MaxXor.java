package DaiMaSuiXiangNote;

public class MaxXor {
    public static int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentXor = nums[i] ^ nums[j];
                if (currentXor > maxXor) {
                    maxXor = currentXor;
                }
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int result = findMaximumXOR(nums);
        System.out.println("最大异或结果是: " + result);
    }
}


class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}

class MaxXor2 {
    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        // 构建字典树
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        int maxXor = 0;
        // 查找最大异或值
        for (int num : nums) {
            TrieNode node = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = 1 - bit;
                if (node.children[toggledBit] != null) {
                    currentXor |= (1 << i);
                    node = node.children[toggledBit];
                } else {
                    node = node.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }
        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int result = findMaximumXOR(nums);
        System.out.println("最大异或结果是: " + result);
    }
}