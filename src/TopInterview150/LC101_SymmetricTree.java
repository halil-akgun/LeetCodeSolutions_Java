package TopInterview150;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
image: https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
image: https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg
Input: root = [1,2,2,null,3,null,3]
Output: false
 */
public class LC101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root)); // true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root2)); // false
    }

    public static boolean isSymmetric(TreeNode root) {

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

        // toString()
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(this); // Start from the root node
            sb.append("[");

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current == null) {
                    sb.append("null,");
                    continue;
                }
                sb.append(current.val).append(",");

                // Add left and right children to the queue (even if they are null)
                queue.offer(current.left);
                queue.offer(current.right);
            }

            // Remove trailing "null"s and commas
            while (sb.length() >= 6 && sb.substring(sb.length() - 5).equals("null,")) {
                sb.setLength(sb.length() - 5); // Remove the last "null,"
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setLength(sb.length() - 1); // Remove trailing comma
            }

            sb.append("]");
            return sb.toString();
        }
    }
}
