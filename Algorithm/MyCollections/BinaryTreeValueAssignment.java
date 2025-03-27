package MyCollections;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//С���õ���һ��������������������n���ڵ㡣С��ϣ���㽫���нڵ㸳ֵΪ1��n������������û�������ڵ��ֵ��ȡ���Ҫ���㣺�������Ȩֵ����ż�����Ȩֵ��֮��ľ���ֵ������1��
//����ж��ָ�ֵ�������뷵������һ�ַ���������޽⣬�뷵�ؿ�����
//�����Ķ������ڵ��ʼȨֵĬ��Ϊ-1��
public class BinaryTreeValueAssignment {
    private int[] values;
    private int index;

    public TreeNode assignValues(TreeNode root, int n) {
        if (n < 1 || n > 10) {
            return root;
        }
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }
        index = 0;
        dfs(root, 1, n);
        return root;
    }

    private void dfs(TreeNode node, int level, int n) {
        if (node == null) {
            return;
        }
        node.val = values[index++];
        dfs(node.left, level + 1, n);
        dfs(node.right, level + 1, n);
    }

    public static void main(String[] args) {
        BinaryTreeValueAssignment solution = new BinaryTreeValueAssignment();
        TreeNode root = new TreeNode(-1);
        // ����򵥹���һ��ֻ�и��ڵ�Ķ�������ʵ��Ӧ������Ҫ���ݾ��������������������
        TreeNode result = solution.assignValues(root, 5);
        // ������Ӵ�ӡ����Ĵ��룬�鿴��ֵ��Ķ�����
    }
}