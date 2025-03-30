package Tree.Q124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // �ݹ�������������������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ����
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewpath = node.val + leftGain + rightGain;

        // ���´�
        maxSum = Math.max(maxSum, priceNewpath);

        // ���ؽڵ�������ֵ
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        // ����һ���򵥵Ķ�����
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("���·����: " + maxPathSum);
    }
}    