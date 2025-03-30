package Tree.Q114;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    private TreeNode head;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = head; // ͷ�巨���൱������� root.next = head
        head = root; // ��������ͷ�ڵ��� root
    }

    public void flatten3(TreeNode root) {
        while (root != null) {
            //������Ϊ null��ֱ�ӿ�����һ���ڵ�
            if (root.left == null) {
                root = root.right;
            } else {
                // �����������ұߵĽڵ�
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //��ԭ�����������ӵ������������ұ߽ڵ�
                pre.right = root.right;
                // �����������뵽�������ĵط�
                root.right = root.left;
                root.left = null;
                // ������һ���ڵ�
                root = root.right;
            }
        }
    }




    public static void main(String[] args) {
        // ����һ���򵥵Ķ��������ڲ���
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        BinaryTreeToLinkedList solution = new BinaryTreeToLinkedList();
        solution.flatten(root);

        // ��ӡչ���������
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}    