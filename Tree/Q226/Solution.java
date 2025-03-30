package Tree.Q226;

import java.util.LinkedList;

class Solution {
	public TreeNode invertTree(TreeNode root) {
		//�ݹ麯������ֹ�������ڵ�Ϊ��ʱ����
		if(root==null) {
			return null;
		}
		//���������ǽ���ǰ�ڵ��������������
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		//�ݹ齻����ǰ�ڵ�� ������
		invertTree(root.left);
		//�ݹ齻����ǰ�ڵ�� ������
		invertTree(root.right);
		//��������ʱ�ͱ�ʾ��ǰ����ڵ㣬�Լ�������������
		//���Ѿ���������
		return root;
	}

	public TreeNode invertTree44(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = invertTree(root.left); // ��ת������
		TreeNode right = invertTree(root.right); // ��ת������
		root.left = right; // �������Ҷ���
		root.right = left;
		return root;
	}


	public TreeNode invertTree1(TreeNode root) {
		if(root==null) {
			return null;
		}
		//���������еĽڵ�����������У��ٵ�����������е�Ԫ��
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//ÿ�ζ��Ӷ�������һ���ڵ㣬����������ڵ����������
			TreeNode tmp = queue.poll();
			TreeNode left = tmp.left;
			tmp.left = tmp.right;
			tmp.right = left;
			//�����ǰ�ڵ����������Ϊ�գ��������еȴ���������
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			//�����ǰ�ڵ����������Ϊ�գ��������еȴ���������
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}

		}
		//���ش�����ĸ��ڵ�
		return root;
	}


}

