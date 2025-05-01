package TopInterview150;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
image: https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */
public class LC002_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(2);
        l1.next = new ListNode2(4);
        l1.next.next = new ListNode2(3);
        ListNode2 l2 = new ListNode2(5);
        l2.next = new ListNode2(6);
        l2.next.next = new ListNode2(4);
        System.out.println(addTwoNumbers(l1, l2)); // [7,0,8]
    }

    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 dummy = new ListNode2(l1.val + l2.val);
        ListNode2 current = dummy;
        int a = 0;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            int b = l1.val + l2.val + a;
            current.next = new ListNode2(b % 10);
            current = current.next;
            a = b / 10;
        }
        while (l1.next != null) {
            l1 = l1.next;
            int b = l1.val + a;
            current.next = new ListNode2(b % 10);
            current = current.next;
            a = b / 10;
        }
        while (l2.next != null) {
            l2 = l2.next;
            int b = l2.val + a;
            current.next = new ListNode2(b % 10);
            current = current.next;
            a = b / 10;
        }
        return dummy;
    }
}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        // print all nodes
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode2 node = next;
        while (node != null) {
            sb.append("->");
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}