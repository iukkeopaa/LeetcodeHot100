package List.Q141;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            // ָ��սڵ����޻�
            if (fast == null || fast.next == null) 
                return false;

            // fast �� slow ����ǰ��
            fast = fast.next.next;
            slow = slow.next;

            // ����
            if (slow == fast) return true;
        }
    }
}
