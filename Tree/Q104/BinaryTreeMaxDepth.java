package Tree.Q104;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    //��α���ʹ�ö��м���
    public int maxDepth2(TreeNode root) {
        // �������߶�Ϊ 0
        if(root == null){
            return 0;
        }
        // ��ʼ�����кͲ��
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        // �����в�Ϊ��
        while(!queue.isEmpty()){
            // ��ǰ��Ľڵ���
            int n = queue.size();
            // ������ǰ������нڵ㣬���������ӽڵ������
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        // ����������μ�Ϊ�������������
        return depth;
    }


//    private static int maxDepth6(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        //DFSʵ��ǰ�������ÿ���ڵ��¼���������
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> pair = stack.pop();
//            TreeNode node = pair.first;
//            //DFS���̲��ϱȽϸ���������
//            maxDepth = Math.max(maxDepth, pair.second);
//            //��¼��ǰ�ڵ��������
//            int curDepth = pair.second;
//            //��ǰ�ڵ���ӽڵ���ջ��ͬʱ���+1
//            if (node.right != null) {
//                stack.push(new Pair<>(node.right, curDepth + 1));
//            }
//            if (node.left != null) {
//                stack.push(new Pair<>(node.left, curDepth + 1));
//            }
//        }
//        return maxDepth;
//    }



    public static void main(String[] args) {
        // ����һ���򵥵Ķ�����
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaxDepth solution = new BinaryTreeMaxDepth();
        int depth = solution.maxDepth(root);
        System.out.println("����������������: " + depth);
    }
}    