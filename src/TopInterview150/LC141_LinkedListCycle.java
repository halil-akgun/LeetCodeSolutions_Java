package TopInterview150;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again
by continuously following the next pointer. Internally, pos is used to denote the index of
the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
image: https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
image: https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
image: https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */
public class LC141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head)); // true

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(hasCycle(head)); // true

        head = new ListNode(1);
        System.out.println(hasCycle(head)); // false
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
