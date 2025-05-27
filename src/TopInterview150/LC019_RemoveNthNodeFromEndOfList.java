package TopInterview150;

import java.util.Stack;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
image: https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */
public class LC019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head, 2)); // [1,2,3,5]
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // way 1
//        if (head.next == null && n == 1) return null;
//
//        ListNode a = new ListNode(1);
//        a.next = head;
//        ListNode current = a;
//        Stack<ListNode> stack = new Stack<>();
//
//        while (current != null) {
//            ListNode temp = current;
//            stack.push(temp);
//            temp = temp.next;
//            current = temp;
//        }
//
//        for (int i = 0; i < n; i++) {
//            stack.pop();
//        }
//
//        ListNode node = stack.pop();
//        node.next = node.next.next;
//        return a.next;

        // way 2
        if (head.next == null) return null;

        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }

        if (size == n) return head.next;

        ListNode a = head;
        for (int i = 0; i < size - n - 1; i++) {
            a = a.next;
        }
        a.next = a.next.next;
        return head;
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
