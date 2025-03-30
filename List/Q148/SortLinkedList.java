package List.Q148;

// ��������ڵ���
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ʹ�ÿ���ָ���ҵ�������е�
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // �ж�����
        prev.next = null;

        // �ݹ�ض����������ֽ�������
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // �ϲ�������������
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }


    public ListNode sortList123(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // �ҵ�������м�ڵ�
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        // �ж�����
        mid.next = null;

        // �ݹ�ض����������ֽ�������
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // �ϲ�������������
        return merge(left, right);
    }

    // ��ȡ������м�ڵ�
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // �ϲ�������������
    private ListNode merge123(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // ����һ��ʾ������ 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortLinkedList solution = new SortLinkedList();
        ListNode sortedList = solution.sortList(head);

        // �������������
        while (sortedList != null) {
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }
}    