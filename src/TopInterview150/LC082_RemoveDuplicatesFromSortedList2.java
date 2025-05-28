package TopInterview150;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
image: https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
image: https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg
Input: head = [1,1,1,2,3]
Output: [2,3]
 */
public class LC082_RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteDuplicates(head)); // [1,2,5]
    }

    public static ListNode deleteDuplicates(ListNode head) {

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
