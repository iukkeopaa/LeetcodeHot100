package Tree.Q114;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution1 {
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        //�����ڵ���������������
        flatten(root.left);
        //�����ڵ���������������
        flatten(root.right);
        TreeNode temp = root.right;
        //�������ұ߻�����ߵ�����
        root.right = root.left;
        //�ǵ�Ҫ������ÿ�
        root.left = null;
        //�ҵ��������ұߵĽڵ�
        while(root.right != null) root = root.right;
        //���ұߵ�����ӵ��ղ��������ұߵĽڵ�
        root.right = temp;
    }

    public void flatten2(TreeNode root) {
        if(root==null) {
            return;
        }
        LinkedList<TreeNode> res = new LinkedList<TreeNode>();
        //ǰ��������ö�����
        dfs(root,res);
        TreeNode head = res.removeFirst();
        head.left = null;
        //���������������е�TreeNode�ڵ�ǰ��������
        while(res.size()>0) {
            TreeNode tmp = res.removeFirst();
            tmp.left = null;
            head.right = tmp;
            head = head.right;
        }
    }

    //ǰ��������ö����������������Ľ���ŵ�������
    void dfs(TreeNode root, List<TreeNode> res) {
        if(root==null) {
            return;
        }
        res.add(root);
        dfs(root.left,res);
        dfs(root.right,res);
    }

    public void flatten4(TreeNode root) {
        if(root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode pre = new TreeNode(-1);
        while(stack.size()>0) {
            //��ջ��Ϊ�������ݽṹ����ջ�е���Ԫ�غ�
            //�Ƚ��ҽڵ�ŵ�ջ�У��ٽ���ڵ����ջ�У�ģ��ǰ�����
            TreeNode tmp = stack.pop();
            pre.left = null;
            pre.right = tmp;
            //�ȷ����ҽڵ㣬�ٷ�����ߵ㣬˳���ܷ���
            if(tmp.right!=null) {
                stack.add(tmp.right);
            }
            if(tmp.left!=null) {
                stack.add(tmp.left);
            }
            pre = pre.right;
        }
    }


    public void flatten344(TreeNode root) {
        helper(root);
    }

    void helper(TreeNode root) {
        if(root==null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        //���������ҵ� �����������ұ�
        //�ٽ������������ҵ����ڵ���ұ�
        if(root.left!=null) {
            TreeNode pre = root.left;
            while(pre.right!=null) {
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
//    public void flatten23424(TreeNode root) {
//        helper(root);
//    }
//
//    TreeNode pre = null;
//    void helper(TreeNode root) {
//        if(root==null) {
//            return;
//        }
//        //�ҽڵ�-��ڵ�-���ڵ� ����˳�����ø�ǰ������෴
//        //��pre�ڵ���Ϊý�飬���������Ľڵ�ǰ��������
//        helper(root.right);
//        helper(root.left);
//        root.left = null;
//        root.right = pre;
//        pre = root;
//    }



}




