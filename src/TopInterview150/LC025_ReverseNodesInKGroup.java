package TopInterview150;

import java.util.Stack;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
image: https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
image: https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class LC025_ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();

        while (current != null) {
            ListNode temp = current;

            for (int i = 0; i < k && temp != null; i++) {
                stack.push(temp);
                temp = temp.next;
            }

            if (stack.size() != k) {
                tail.next = current;
                break;
            }

            while (!stack.isEmpty()) {
                tail.next = stack.pop();
                tail = tail.next;
            }

            current = temp;
        }

        tail.next = current;
        return dummy.next;
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
