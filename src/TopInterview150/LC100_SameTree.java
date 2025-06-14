package TopInterview150;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
image: https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
image: https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
image: https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg
Input: p = [1,2,1], q = [1,1,2]
Output: false
 */
public class LC100_SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p, q)); // true
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
