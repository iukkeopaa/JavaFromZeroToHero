package MyCollections;

import java.util.Scanner;

//小红最近想到了一个好玩的游戏，这个游戏一共会进行几轮，每一轮，小红会从下方三种操作中选择一种进行!
//在黑板上写一个整数…;擦去黑板上的一个整数:(此操作之前保证黑板上有这个整数); 询问黑板上哪个数字与整数x的异
//或值最大(若黑板上此时没有数字，则输出 -1)。 对于每一次询问操作，你需要告诉他答案。
// 字典树节点类
class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}

// 字典树类
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 向字典树中插入一个整数
    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // 查找与给定整数异或值最大的数
    public int findMaxXor(int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                xor |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }
}

public class GameOperationOptimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();
        int n = scanner.nextInt(); // 游戏轮数

        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                // 写一个整数
                int num = scanner.nextInt();
                trie.insert(num);
            } else if (operation == 3) {
                // 询问与 x 异或值最大的数字
                int x = scanner.nextInt();
                int result = trie.findMaxXor(x);
                if (result == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(result);
                }
            }
        }
        scanner.close();
    }
}    