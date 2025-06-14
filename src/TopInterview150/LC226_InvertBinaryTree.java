package TopInterview150;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
image: https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
image: https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 */
public class LC226_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(invertTree(root)); // [4,7,2,9,6,3,1]
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        if (root.left != null || root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }

        if (root.left != null) {
            invertTree(root.left);
        }

        if (root.right != null) {
            invertTree(root.right);
        }

        return root;
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
