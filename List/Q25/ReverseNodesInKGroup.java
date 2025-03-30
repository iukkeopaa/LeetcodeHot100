package List.Q25;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) return null;
        // �ҵ��� k ���ڵ�
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // ���� k ���ڵ㣬�����з�ת
            if (b == null) return head;
            b = b.next;
        }
        // ��ת [a, b) ����Ľڵ�
        ListNode newHead = reverse1(a, b);
        // �ݹ鷭ת��������
        a.next = reverseKGroup1(b, k);
        return newHead;
    }

    // ��ת [a, b) ����Ľڵ�
    private ListNode reverse1(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public ListNode reverseKGroup12(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // �� k ���ڵ�ѹ��ջ��
            for (int i = 0; i < k && current != null; i++) {
                stack.push(current);
                current = current.next;
            }
            // ���ջ�нڵ��������� k �����򲻽��з�ת
            if (stack.size() < k) {
                break;
            }
            // ���ε���ջ�нڵ㣬���ӳ��µ�����
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
            // ����ʣ������
            prev.next = current;
        }
        return dummy.next;
    }


    public ListNode reverseKGroup233(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (true) {
            // �ҵ���ǰ��ĵ� k ���ڵ�
            ListNode kthNode = findKthNode(prevGroupTail, k);
            if (kthNode == null) {
                break;
            }
            ListNode nextGroupHead = kthNode.next;

            // ��¼��ǰ��ĵ�һ���ڵ㣬��ת�������Ϊ��������һ���ڵ�
            ListNode currentGroupFirst = prevGroupTail.next;
            // β�巨��ת��ǰ��� k ���ڵ�
            while (prevGroupTail.next != nextGroupHead) {
                ListNode temp = prevGroupTail.next;
                prevGroupTail.next = temp.next;
                temp.next = kthNode.next;
                kthNode.next = temp;
            }

            // ���� prevGroupTail ָ����һ���ǰһ���ڵ�
            prevGroupTail = currentGroupFirst;
        }
        return dummy.next;
    }

    // �ҵ��� start ��ʼ�ĵ� k ���ڵ�
    private ListNode findKthNode(ListNode start, int k) {
        ListNode current = start;
        for (int i = 0; i < k; i++) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        return current;
    }
    public static void main(String[] args) {
        // �������� 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        // ��ӡ���
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}