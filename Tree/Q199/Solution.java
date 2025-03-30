package Tree.Q199;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0); // �Ӹ��ڵ㿪ʼ���ʣ����ڵ������0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // �ȷ��� ��ǰ�ڵ㣬�ٵݹ�ط��� ������ �� ��������
        if (depth == res.size()) {   // �����ǰ�ڵ�������Ȼ�û�г�����res�˵���ڸ�����µ�ǰ�ڵ��ǵ�һ�������ʵĽڵ㣬��˽���ǰ�ڵ����res�С�
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}

