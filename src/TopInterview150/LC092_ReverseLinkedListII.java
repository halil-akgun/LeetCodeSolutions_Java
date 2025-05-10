package TopInterview150;

import java.util.Stack;

/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
image: https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 */
public class LC092_ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseBetween(head, 2, 4)); // [1,4,3,2,5]
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode result = new ListNode(1);
        ListNode current = result;
        for (int i = 1; i < left; i++) {
            current.next = new ListNode(head.val);
            current = current.next;
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = left; i <= right; i++) {
            stack.add(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.pop());
            current = current.next;
        }
        while (head != null) {
            current.next = new ListNode(head.val);
            current = current.next;
            head = head.next;
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            // print all nodes
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode node = next;
            while (node != null) {
                sb.append("->");
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }
}
