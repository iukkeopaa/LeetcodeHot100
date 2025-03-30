package Tree.Q101;

import java.util.LinkedList;

// ����������ڵ���
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeSymmetryCheck {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    //����ʵ��
    public boolean isSymmetric22(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        //�ö��б���ڵ�
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //�����ڵ�����Һ��ӷŵ�������
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0) {
            //�Ӷ�����ȡ�������ڵ㣬�ٱȽ��������ڵ�
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //��������ڵ㶼Ϊ�վͼ���ѭ����������һ��Ϊ�վͷ���false
            if(left==null && right==null) {
                continue;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }
            //����ڵ�����ӣ� �ҽڵ���Һ��ӷ������
            queue.add(left.left);
            queue.add(right.right);
            //����ڵ���Һ��ӣ��ҽڵ�����ӷ������
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }


    public static void main(String[] args) {
        // ����һ���򵥵Ķ��������ڲ���
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        BinaryTreeSymmetryCheck solution = new BinaryTreeSymmetryCheck();
        boolean result = solution.isSymmetric(root);
        System.out.println("�ö������Ƿ���Գ�: " + result);
    }
}    