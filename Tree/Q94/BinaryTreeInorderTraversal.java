package Tree.Q94;

import java.util.*;

// ����������ڵ���
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> inorderTraversal1123(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null ||!stack.isEmpty()) {
            // �Ƚ��������ڵ�ȫ����ջ
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // ȡ��ջ���ڵ�
            current = stack.pop();
            result.add(current.val);
            // ת��������
            current = current.right;
        }
        return result;
    }




    //��ɫ��Ƿ�
    class Node {
        TreeNode node;
        int color;

        Node(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal6(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if(root == null) return ans;
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.node == null) continue;
            if (cur.color == 1) {
                stack.push(new Node(cur.node.right, 1));
                stack.push(new Node(cur.node, 2));
                stack.push(new Node(cur.node.left, 1));
            } else {
                ans.add(cur.node.val);
            }
        }
        return ans;
    }
public static void main(String[] args) {
        // ����һ���򵥵Ķ�����
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
    }
}    