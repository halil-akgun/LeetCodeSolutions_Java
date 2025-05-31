package TopInterview150;

import java.util.Stack;

/*
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
image: https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
image: https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class LC061_RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rotateRight(head, 2)); // [4,5,1,2,3]
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int rotate = k % stack.size();
        if (rotate == 0) return head;

        ListNode last = stack.getLast();
        last.next = head;
        ListNode newTail = stack.get(stack.size() - rotate - 1);
        head = newTail.next;
        newTail.next = null;

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
