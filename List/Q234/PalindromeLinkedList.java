package List.Q234;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


//����ָ��
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // �ҵ�������м�ڵ�
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // ��ת����ĺ�벿��
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;

        // �Ƚ�ǰ�벿�ֺͷ�ת��ĺ�벿��
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
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


    //list��array��ת��
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        java.util.ArrayList<Integer> arr = new java.util.ArrayList<Integer>();
        //����һ��������Ȼ���Ԫ�ض��ŵ�������
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = arr.size() - 1;
        //��i��j����ָ�룬һ������һ����ǰ�����ϵ���
        //���i��ֵ������j˵�����ǻ��ģ���֮�ǻ���
        while (i < j) {
            if (arr.get(i).compareTo(arr.get(j)) != 0) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    //ʹ��ջ
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        // ��һ�α����������ڵ�ֵѹ��ջ��
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        current = head;
        // �ڶ��α����������ڵ�ֵ��ջ�е�����ֵ�Ƚ�
        while (current != null) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }
        return true;
    }


    public class PalindromeLinkedListRecursive {
        private ListNode frontPointer;

        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
        }

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) {
                    return false;
                }
                if (currentNode.val != frontPointer.val) {
                    return false;
                }
                frontPointer = frontPointer.next;
            }
            return true;
        }

        ListNode temp;
        private boolean check(ListNode head) {
            if (head == null)
                return true;
            boolean res = check(head.next) && (temp.val == head.val);
            temp = temp.next;
            return res;
        }


        public static void main(String[] args) {
            PalindromeLinkedList solution = new PalindromeLinkedList();
            // �������� 1 -> 2 -> 2 -> 1
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);

            boolean result = solution.isPalindrome(head);
            System.out.println("�������Ƿ�Ϊ��������: " + result);
        }
    }
}