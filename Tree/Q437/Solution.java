package Tree.Q437;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // ��¼·����ĳ��ǰ׺�ͳ��ֵĴ���
        Map<Integer, Integer> map = new HashMap<>();
        // ��ֹ�������ڵ��ʱ���Ҳ���
        map.put(0, 1);
        // ��ʼ����
        dfs(root, map, 0, targetSum);
        // ����ֵ
        return ans;
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map, int currSum, int targetSum) {
        // �ݹ��˳�����
        if (node == null) {
            return;
        }

        // �ж��Ƿ���ڷ���������ǰ׺��
        currSum += node.val;
        ans += map.getOrDefault(currSum - targetSum, 0);

        // ����ǰǰ׺�ͼ�¼����
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // �������µݹ�
        dfs(node.left, map, currSum, targetSum);
        dfs(node.right, map, currSum, targetSum);

        // ���ݣ��ָ�״̬
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
    }
}

