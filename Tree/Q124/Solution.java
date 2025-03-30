package Tree.Q124;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int t = root.val;
        if (left >= 0) t += left;
        if (right >= 0) t += right;
        ans = Math.max(ans, t);
        return Math.max(root.val, Math.max(left, right) + root.val);
    }
}

class Solution2 {
    Map<TreeNode, int[]> map = new HashMap<>(); // �ڵ�: [��, ��, ��]
    public int maxPathSum(TreeNode root) {
        dfs1(root, null);
        dfs2(root, null);
        int ans = Integer.MIN_VALUE;
        for (TreeNode cur : map.keySet()) {
            int t = cur.val;
            int[] info = map.get(cur);
            Arrays.sort(info);
            if (info[2] >= 0) t += info[2];
            if (info[1] >= 0) t += info[1];
            ans = Math.max(ans, t);
        }
        return ans;
    }
    int dfs1(TreeNode cur, TreeNode fa) {
        if (cur == null) return 0;
        int left = dfs1(cur.left, cur), right = dfs1(cur.right, cur);
        int[] info = map.getOrDefault(cur, new int[3]);
        info[1] = left; info[2] = right;
        map.put(cur, info);
        return Math.max(cur.val, cur.val + Math.max(left, right));
    }
    void dfs2(TreeNode cur, TreeNode fa) {
        if (cur == null) return ;
        int[] curInfo = map.get(cur);
        if (cur.left != null) {
            int[] leftInfo = map.get(cur.left);
            leftInfo[0] = Math.max(cur.val, cur.val + Math.max(curInfo[0], curInfo[2]));
        }
        if (cur.right != null) {
            int[] rightInfo = map.get(cur.right);
            rightInfo[0] = Math.max(cur.val, cur.val + Math.max(curInfo[0], curInfo[1]));
        }
        dfs2(cur.left, cur);
        dfs2(cur.right, cur);
    }
}





