package Tree.Q437;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // ������ǰ�ڵ��·����
        int pathsFromRoot = countPaths(root, targetSum);
        // �������е�·����
        int pathsInLeft = pathSum(root.left, targetSum);
        // �������е�·����
        int pathsInRight = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsInLeft + pathsInRight;
    }

    private int countPaths(TreeNode node, int remainingSum) {
        if (node == null) {
            return 0;
        }
        int paths = 0;
        if (node.val == remainingSum) {
            paths++;
        }
        // ��������������Ѱ��
        paths += countPaths(node.left, remainingSum - node.val);
        // ��������������Ѱ��
        paths += countPaths(node.right, remainingSum - node.val);

        return paths;
    }


    Map<Long, Integer> map = new HashMap<>();
    int ans, t;
    public int pathSum2(TreeNode root, int _t) {
        if (root == null) return 0;
        t = _t;
        map.put(0L, 1);
        dfs(root, root.val);
        return ans;
    }
    void dfs(TreeNode root, long val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }


    public static void main(String[] args) {
        // ����һ���򵥵Ķ�����
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        BinaryTreePathSum solution = new BinaryTreePathSum();
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println("·����Ŀ: " + result);
    }
}    