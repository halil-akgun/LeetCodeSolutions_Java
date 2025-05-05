package TopInterview150;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
image: https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */
public class LC021_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode3 list1 = new ListNode3(1);
        list1.next = new ListNode3(2);
        list1.next.next = new ListNode3(4);
        ListNode3 list2 = new ListNode3(1);
        list2.next = new ListNode3(3);
        list2.next.next = new ListNode3(4);
        System.out.println(mergeTwoLists(list1, list2)); // [1,1,2,3,4,4]
    }

    public static ListNode3 mergeTwoLists(ListNode3 list1, ListNode3 list2) {
        ListNode3 dummy = new ListNode3(-1);
        ListNode3 current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        return dummy.next;
    }
}

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        // print all nodes
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode3 node = next;
        while (node != null) {
            sb.append("->");
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
