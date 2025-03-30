package List.Q24;

import java.util.Stack;

// ��������ڵ���
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesInPairs {
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // �����ڵ�
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // �ƶ�ָ��
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    // ����������������ת��Ϊ����
    public static ListNode arrayToList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // ����������������ת��Ϊ�ַ����Ա����
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }


//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0, head); // ���ڱ��ڵ�򻯴����߼�
//        ListNode node0 = dummy;
//        ListNode node1 = head;
//        while (node1 != null && node1.next != null) { // �����������ڵ�
//            ListNode node2 = node1.next;
//            ListNode node3 = node2.next;
//
//            node0.next = node2; // 0 -> 2
//            node2.next = node1; // 2 -> 1
//            node1.next = node3; // 1 -> 3
//
//            node0 = node1; // ��һ�ֽ�����0 �� 1
//            node1 = node3; // ��һ�ֽ�����1 �� 3
//        }
//        return dummy.next; // �����������ͷ�ڵ�
//    }
    public ListNode swapPairs4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = node2.next;

        node1.next = swapPairs4(node3); // 1 ָ��ݹ鷵�ص�����ͷ
        node2.next = node1; // 2 ָ�� 1

        return node2; // ���ؽ����������ͷ�ڵ�
    }

    public ListNode swapPairs123(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        //��stack����ÿ�ε����������ڵ�
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //headָ���µ�p�ڵ㣬��������ʱ����head.next����
        head = p;
        while(cur!=null && cur.next!=null) {
            //�������ڵ����stack��
            stack.add(cur);
            stack.add(cur.next);
            //��ǰ�ڵ���ǰ������
            cur = cur.next.next;
            //��stack�е��������ڵ㣬Ȼ����p�ڵ�ָ���µ����������ڵ�
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //ע��߽���������������������ʱ��cur�Ͳ�Ϊ��
        if(cur!=null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
    }




    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = arrayToList(arr);
        System.out.println("ԭʼ����: " + listToString(head));

        ListNode swappedHead = swapPairs1(head);
        System.out.println("�����������: " + listToString(swappedHead));
    }
}    