package MyCollections;

import java.util.Scanner;

//С������뵽��һ���������Ϸ�������Ϸһ������м��֣�ÿһ�֣�С�����·����ֲ�����ѡ��һ�ֽ���!
//�ںڰ���дһ��������;��ȥ�ڰ��ϵ�һ������:(�˲���֮ǰ��֤�ڰ������������); ѯ�ʺڰ����ĸ�����������x����
//��ֵ���(���ڰ��ϴ�ʱû�����֣������ -1)�� ����ÿһ��ѯ�ʲ���������Ҫ�������𰸡�
// �ֵ����ڵ���
class TrieNode {
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}

// �ֵ�����
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // ���ֵ����в���һ������
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

    // ����������������ֵ������
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
        int n = scanner.nextInt(); // ��Ϸ����

        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                // дһ������
                int num = scanner.nextInt();
                trie.insert(num);
            } else if (operation == 3) {
                // ѯ���� x ���ֵ��������
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